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
package de.hybris.platform.billaddon.controllers.pages;

import static org.junit.Assert.assertEquals;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.UserFacade;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


/**
 * Test for {@link PSBillController}
 */
@UnitTest
public class PSBillControllerTest
{
	private static final String BILL_PAGE = "addon:/billaddon/pages/account/accountMyBillsPage";

	@InjectMocks
	private PSBillController psBillController;

	@Mock
	private UserFacade userFacade;

	@Mock
	private Model model;

	@Before
	public void prepare() throws CMSItemNotFoundException
	{
		MockitoAnnotations.initMocks(this);
		psBillController = Mockito.spy(new PSBillController());
	}

	@Test
	public void shouldRetrieveBillPage() throws CMSItemNotFoundException
	{
		Mockito.when(Boolean.valueOf(userFacade.isAnonymousUser())).thenReturn(Boolean.FALSE);
		final String billPage = psBillController.showRetrieveBill(model);
		assertEquals(billPage, BILL_PAGE);
	}
}
