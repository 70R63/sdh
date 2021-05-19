/*
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 *
 */
package de.hybris.platform.sdhpsaddon.controllers.cms;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectordocmanagement.data.PSDocumentData;
import de.hybris.platform.publicsectorfacades.docmanagement.PSDocumentManagementFacade;
import de.hybris.platform.publicsectorservices.model.PSDocumentDashletComponentModel;
import de.hybris.platform.relationshipfacades.relationship.PSRelationshipFacade;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("PSDocumentDashletComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSDocumentDashletComponent)
public class PSDocumentDashletComponentController extends SubstitutingCMSAddOnComponentController<PSDocumentDashletComponentModel>
{
	private static final int DOCUMENTS_MAX_COUNT = 3;

	@Resource(name = "psDocumentManagementFacade")
	private PSDocumentManagementFacade documentManagementFacade;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "psRelationshipfacade")
	protected PSRelationshipFacade psRelationshipFacade;

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSDocumentDashletComponentModel component)
	{
		//TODO revisar que este cambio sea correcto, los metodos cambiaron y se adaptó de acuerdo a lo entendido
		//TODO en el contexto que otroga el código
		final List<PSDocumentData> documents = documentManagementFacade
				.getDocumentsForUserRelationshipsByStatus(customerFacade.getCurrentCustomerUid(), false);

		final List<PSDocumentData> expiredDocuments = documentManagementFacade
				.getDocumentsForUserRelationshipsByStatus(customerFacade.getCurrentCustomerUid(), true);

		//latest 3 documents only
		if (CollectionUtils.isNotEmpty(documents))
		{
			final List<PSDocumentData> latestDocuments = documents.stream().limit(DOCUMENTS_MAX_COUNT).collect(Collectors.toList());
			model.addAttribute("documents", latestDocuments);
		}

		final boolean relationshipsHaveDocuments = CollectionUtils
				.isNotEmpty(documentManagementFacade.getDocumentsForUserRelationships(customerFacade.getCurrentCustomer().getUid()));
		final boolean isSeeAllDocsButtonVisible = setSeeAllDocumentsButtonVisible(documents, expiredDocuments,
				relationshipsHaveDocuments);

		model.addAttribute("userDocumentsAvailable", Boolean.valueOf(CollectionUtils.isNotEmpty(documents)));
		model.addAttribute("relationshipDocumentsAvailable", Boolean.valueOf(relationshipsHaveDocuments));
		model.addAttribute("isSeeAllDocsButtonVisible", Boolean.valueOf(isSeeAllDocsButtonVisible));
		model.addAttribute("showDocumentDashlet", Boolean.valueOf(setShowDocumentDashlet(documents, isSeeAllDocsButtonVisible)));
		model.addAttribute("userExpiredDocumentsAvailable", Boolean.valueOf(CollectionUtils.isNotEmpty(expiredDocuments)));


	}

	private boolean isUserHasMoreDocuments(final List<PSDocumentData> documents, final List<PSDocumentData> expiredDocuments)
	{
		return (CollectionUtils.isNotEmpty(documents) && documents.size() > DOCUMENTS_MAX_COUNT)
				|| CollectionUtils.isNotEmpty(expiredDocuments);
	}

	private boolean setSeeAllDocumentsButtonVisible(final List<PSDocumentData> documents,
			final List<PSDocumentData> expiredDocuments, final boolean relationshipsHaveDocuments)
	{
		return relationshipsHaveDocuments || isUserHasMoreDocuments(documents, expiredDocuments);
	}

	private boolean setShowDocumentDashlet(final List<PSDocumentData> documents, final boolean isSeeAllDocsButtonVisible)
	{
		return CollectionUtils.isNotEmpty(documents) || isSeeAllDocsButtonVisible;
	}

}
