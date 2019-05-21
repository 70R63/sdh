/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.sdhpsaddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.publicsectordocmanagement.data.PSDocumentData;
import de.hybris.platform.publicsectorfacades.docmanagement.PSDocumentManagementFacade;
import de.hybris.platform.relationshipfacades.permission.PSPermissionFacade;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;
import de.hybris.platform.relationshipservices.relationship.exception.RelationshipDoesNotExistException;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Extended Controller for functionality related with Documents in My Account
 */
//@RequestMapping("/my-account")
public class PSAccountDocumentsController extends AbstractSearchPageController
{
	private static final Logger LOG = LoggerFactory.getLogger(PSAccountDocumentsController.class);
	private static final String ACCOUNT_MY_DOCUMENTS = "text.account.documents";
	private static final String MY_DOCUMENTS_CMS_PAGE = "my-documents";
	private static final String PSDOCUMENT_TYPECODE = "PSDocument";
	private static final String MY_EXPIRED_DOCUMENTS_CMS_PAGE = "my-expired-documents";
	private static final String ACCOUNT_MY_EXPIRED_DOCUMENTS = "text.account.expired.documents";
	private static final String RELATIONSHIP_CUSTOMER = "relationshipCustomer";
	private static final String DOCUMENTS = "documents";
	private static final String DOCUMENT_NOT_FOUND = "Document not found.";

	protected static final String BREADCRUMBS_ATTR = "breadcrumbs";

	@Resource(name = "psDocumentManagementFacade")
	protected PSDocumentManagementFacade documentManagementFacade;

	@Resource(name = "customerFacade")
	protected CustomerFacade customerFacade;

	@Resource(name = "psRelationshipfacade")
	protected PSRelationshipFacade psRelationshipFacade;

	@Resource(name = "psMyAccountBreadcrumbBuilder")
	protected ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "psPermissionFacade")
	private PSPermissionFacade psPermissionFacade;

	@RequestMapping(value = "/my-documents", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyDocuments(final Model model) throws CMSItemNotFoundException
	{
		final List<PSDocumentData> documents = getDocumentManagementFacade()
				.getDocumentsForCustomer(getCustomerFacade().getCurrentCustomerUid());

		final List<PSDocumentData> expiredDocuments = getDocumentManagementFacade()
				.getExpiredDocumentsForCustomer(customerFacade.getCurrentCustomerUid());

		model.addAttribute(DOCUMENTS, documents);
		model.addAttribute("expiredDocuments", expiredDocuments);

		final List<CustomerData> relations = psRelationshipFacade
				.getRelationshipUsersForUserAndPermissibleItemType(getUser().getUid(), PSDOCUMENT_TYPECODE);

		if (CollectionUtils.isNotEmpty(relations))
		{
			model.addAttribute("allRelationships", relations);
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_DOCUMENTS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_DOCUMENTS));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_DOCUMENTS_CMS_PAGE));
		return getViewForPage(model);
	}

	@RequestMapping(value = "/my-expired-documents", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyExpiredDocuments(final Model model) throws CMSItemNotFoundException
	{
		final List<PSDocumentData> documents = getDocumentManagementFacade()
				.getExpiredDocumentsForCustomer(getCustomerFacade().getCurrentCustomerUid());
		model.addAttribute(DOCUMENTS, documents);

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_EXPIRED_DOCUMENTS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_EXPIRED_DOCUMENTS));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_EXPIRED_DOCUMENTS_CMS_PAGE));
		return getViewForPage(model);
	}

	@RequestMapping(value = "/psSecureDocument", method = RequestMethod.GET)
	@RequireHardLogIn
	public void retrieveDocument(@RequestParam(value = "docCode", required = true) final String docCode,
			final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException
	{
		final PSDocumentData document = documentManagementFacade.findDocumentByDocumentSecurePathUrlId(docCode);

		if (document == null)
		{
			LOG.error("Error retrieving document for code [{}]. No document found with given document id", docCode);
			throw new UnknownIdentifierException(DOCUMENT_NOT_FOUND);
		}

		final String customerUid = getCustomerFacade().getCurrentCustomerUid();
		final String docCustomerId = document.getCustomerUid();

		if (!customerUid.equals(docCustomerId))
		{
			try
			{
				if (psPermissionFacade.isPermitted(customerUid, docCustomerId, PSDOCUMENT_TYPECODE))
				{
					this.sendData(response, documentManagementFacade.decryptDocumentSecurePathUrlById(document.getSecurePathURLId(),
							document.getDocId()), document.getMimeType(), document.getDocId());
				}
				else
				{
					// User logged in is not document owner and does not have permissions on the document owner, return error
					LOG.error("User [{}] Do not have privilege to access document [{}] of User [{}]", customerUid, docCode,
							docCustomerId);
					throw new UnknownIdentifierException(DOCUMENT_NOT_FOUND);
				}
			}
			catch (final RelationshipDoesNotExistException rdne)
			{
				LOG.error("Don't have privilege to access document [{}] ]. More details :" + rdne, docCode);
				throw new UnknownIdentifierException(DOCUMENT_NOT_FOUND);
			}
		}
		else
		{
			this.sendData(response,
					documentManagementFacade.decryptDocumentSecurePathUrlById(document.getSecurePathURLId(), document.getDocId()),
					document.getMimeType(), document.getDocId());
		}
	}

	private void sendData(final HttpServletResponse httpResponse, final String documentPath, final String mimeType, final String documentId)
			throws IOException
	{
		final File document = getFileForLocation(documentPath);
		if (document != null)
		{
			httpResponse.setContentType(mimeType);
			httpResponse.setContentLength((int) document.length());
			InputStream mediaStream = null;

			try
			{
				mediaStream = getFileAsInputStream(document);
				if (mediaStream == null)
				{
					LOG.error("Error retrieving document. No document found for id: [{}]", documentId);
					throw new UnknownIdentifierException(DOCUMENT_NOT_FOUND);
				}
				final OutputStream out = httpResponse.getOutputStream();
				IOUtils.copyLarge(mediaStream, out);
			}
			finally
			{
				if (mediaStream != null)
				{
					safeClose(mediaStream);
				}
			}
		}
		else
		{
			LOG.warn("Document does not exist for id:[{}]", documentId);
		}
	}

	protected InputStream getFileAsInputStream(final File actualFile)
	{
		FileInputStream fileInputStream = null;
		try
		{
			if (actualFile.exists())
			{
				fileInputStream = new FileInputStream(actualFile);
			}
		}
		catch (final IOException e)
		{
			LOG.error("Exception occured while reading file ", e);
		}
		return fileInputStream;
	}

	private static void safeClose(final InputStream mediaStream)
	{
		if (mediaStream != null)
		{
			try
			{
				mediaStream.close();
			}
			catch (final IOException e)
			{
				LOG.error("Exception occured while closing stream", e);
			}
		}
	}

	protected File getFileForLocation(final String documentPath)
	{
		if (StringUtils.isNotEmpty(documentPath))
		{
			return new File(documentPath);
		}
		return null;
	}

	@ExceptionHandler(UnknownIdentifierException.class)
	public String handleUnknownIdentifierException(final UnknownIdentifierException exception, final HttpServletRequest request)
	{
		request.setAttribute("message", exception.getMessage());
		LOG.warn(exception.getMessage());
		return FORWARD_PREFIX + "/404";
	}

	@RequestMapping(value = "/documents/loadCustomerDocuments", method = RequestMethod.GET)
	public String getDocumentsForCustomer(@RequestParam("customerId") final String customerId, final Model model)
			throws RelationshipDoesNotExistException
	{
		if (psPermissionFacade.isPermitted(getUser().getUid(), customerId, PSDOCUMENT_TYPECODE))
		{
			final List<PSDocumentData> documents = getDocumentManagementFacade().getDocumentsForCustomer(customerId);
			model.addAttribute("results", documents);
			final List<PSDocumentData> expiredDocuments = getDocumentManagementFacade().getExpiredDocumentsForCustomer(customerId);
			model.addAttribute("expiredDocuments", expiredDocuments);
			final CustomerData customer = psRelationshipFacade.getCustomerDataForUid(customerId);
			model.addAttribute("customer", customer);
			model.addAttribute("isAccessible", Boolean.TRUE);
		}
		else
		{
			LOG.error("[{}] does not have privilege to access [{}]'s document ", getUser().getUid(), customerId);
			model.addAttribute("isAccessible", Boolean.FALSE);
		}
		return ControllerConstants.Views.Fragments.Documents.RelationshipDocumentsAjaxPage;
	}

	@RequestMapping(value = "/relationshipExpiredDocuments", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyRelationsExpiredDocuments(@RequestParam(value = "customerPK", required = true) final String customerPK,
			final Model model) throws CMSItemNotFoundException, RelationshipDoesNotExistException
	{
		final CustomerData relationshipCustomer = psRelationshipFacade.getCustomerForPK(customerPK);
		if (null != relationshipCustomer)
		{
			final String customerId = relationshipCustomer.getUid();
			if (psPermissionFacade.isPermitted(getUser().getUid(), customerId, PSDOCUMENT_TYPECODE))
			{
				final List<PSDocumentData> documents = getDocumentManagementFacade().getExpiredDocumentsForCustomer(customerId);
				model.addAttribute(DOCUMENTS, documents);
				storeCmsPageInModel(model, getContentPageForLabelOrId(MY_EXPIRED_DOCUMENTS_CMS_PAGE));
				model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_EXPIRED_DOCUMENTS));
				setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_EXPIRED_DOCUMENTS_CMS_PAGE));
				model.addAttribute(RELATIONSHIP_CUSTOMER, relationshipCustomer);
				return getViewForPage(model);
			}
			else
			{
				LOG.error("[{}] does not have privilege to access [{}]'s expired documents ", getUser().getUid(), customerId);
				throw new UnknownIdentifierException("Expired Document not found.");
			}
		}
		return null;
	}

	protected PSDocumentManagementFacade getDocumentManagementFacade()
	{
		return this.documentManagementFacade;
	}

	protected ResourceBreadcrumbBuilder getAccountBreadcrumbBuilder()
	{
		return accountBreadcrumbBuilder;
	}
}
