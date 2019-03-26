/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.controllers.pages.forms.ImportConciliacionForm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sf.sevenzipjbinding.ExtractOperationResult;
import net.sf.sevenzipjbinding.ISequentialOutStream;
import net.sf.sevenzipjbinding.ISevenZipInArchive;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipException;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/conciliaciones")
public class ConciliacionesPageController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(ConciliacionesPageController.class);

	private static final String CONCILIACIONES_CMS_PAGE = "ConciliacionesPage";

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;


	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public String showView(final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();

		storeCmsPageInModel(model, getContentPageForLabelOrId(CONCILIACIONES_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONCILIACIONES_CMS_PAGE));
		updatePageTitle(model, getContentPageForLabelOrId(CONCILIACIONES_CMS_PAGE));

		return getViewForPage(model);
	}


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@RequireHardLogIn
	public String upload(@ModelAttribute("importConciliacionForm")
	final ImportConciliacionForm importConciliacionForm, final RedirectAttributes redirectAttributes) throws IOException
	{
		redirectAttributes.addFlashAttribute("importConciliacionForm", importConciliacionForm);
		GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
				"conciliaciones.upload.messages.success", new Object[]
				{ importConciliacionForm.getConciliacionFile().getOriginalFilename() });


		final File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
		final FileOutputStream o = new FileOutputStream(zip);
		IOUtils.copy(importConciliacionForm.getConciliacionFile().getInputStream(), o);
		o.close();

		ISevenZipInArchive inArchive = null;
		ISimpleInArchive simpleInArchive = null;
		final RandomAccessFile randomAccessFile = new RandomAccessFile(zip.getAbsolutePath(), "r");
		try
		{
			inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));

			simpleInArchive = inArchive.getSimpleInterface();

			LOG.info("   Hash   |    Size    | Filename");
			LOG.info("----------+------------+---------");

			for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems())
			{
				final int[] hash = new int[]
				{ 0 };
				if (!item.isFolder())
				{
					ExtractOperationResult result;

					final long[] sizeArray = new long[1];
					result = item.extractSlow(new ISequentialOutStream()
					{



						public int write(final byte[] data) throws SevenZipException
						{

							//Write to file
							final FileOutputStream fos;
							try
							{
								final File file = new File(item.getPath());

								final Scanner reader = new Scanner(file);

								while (reader.hasNext())
								{
									final String str = reader.nextLine();
									LOG.info(str);
								}


							}
							catch (final FileNotFoundException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							catch (final IOException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							hash[0] ^= Arrays.hashCode(data); // Consume data
							sizeArray[0] += data.length;
							return data.length; // Return amount of consumed data
						}


					});
					if (result == ExtractOperationResult.OK)
					{
						LOG.info(String.format("%9X | %10s | %s", //
								hash[0], sizeArray[0], item.getPath()));
					}
					else
					{
						LOG.error("Error extracting item: " + result);
					}
				}
			}
		}
		catch (final SevenZipException e)
		{
			// XXX Auto-generated catch block
			e.printStackTrace();
		}
		catch (final Exception e)
		{
			LOG.error("Error occurs: " + e);
		}
		finally
		{
			if (inArchive != null)
			{
				try
				{
					inArchive.close();
				}
				catch (final SevenZipException e)
				{
					LOG.error("Error closing archive: " + e);
				}
			}
			if (randomAccessFile != null)
			{
				try
				{
					randomAccessFile.close();
				}
				catch (final IOException e)
				{
					LOG.error("Error closing file: " + e);
				}
			}

		}


		//		final ZipInputStream zipFileStream = new ZipInputStream(importConciliacionForm.getConciliacionFile().getInputStream());
		//
		//		ZipEntry ze = null;
		//		while ((ze = zipFileStream.getNextEntry()) != null)
		//		{
		//			if (ze.getName().endsWith(".txt"))
		//			{
		//				final Scanner sc = new Scanner(zipFileStream);
		//				while (sc.hasNextLine())
		//				{
		//					LOG.info(sc.nextLine());
		//				}
		//			}
		//		}

		return "redirect:/conciliaciones";
	}


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}