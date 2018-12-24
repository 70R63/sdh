/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
ACC.billpaginationsort = {

	downUpKeysPressed: false,

	bindAll: function ()
	{
		this.bindBillPaginationSort();
	},
	bindBillPaginationSort: function ()
	{
		ACC.billpaginationsort.bindSortForm($('#billSortForm1'));
		ACC.billpaginationsort.bindSortForm($('#billSortForm2'));
	},
	bindSortForm: function (sortForm)
	{
		sortForm.change(function ()
		{
			if (!ACC.billpaginationsort.downUpPressed)
				{
					this.submit();
				}
				ACC.billpaginationsort.downUpPressed = false;
		});
	},
	sortFormIEFix: function (sortOptions, selectedOption)
	{
		sortOptions.keydown(function (e)
		{
			// Pressed up or down keys
			if (e.keyCode === 38 || e.keyCode === 40)
			{
				ACC.billpaginationsort.downUpPressed = true;
			}
			// Pressed enter
			else if (e.keyCode === 13 && selectedOption !== $(this).val())
			{
				$(this).parent().submit();
			}
			// Any other key
			else
			{
				ACC.billpaginationsort.downUpPressed = false;
			}
		});
	}
};

$(document).ready(function ()
{
	ACC.billpaginationsort.bindAll();
	$("select[id^='sortOptions']").prop("disabled", false);
});
