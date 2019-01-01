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

ACC.permissionselection = {

	_autoload: [
	   "handleViewEditPendingRequestClick",
	   "bindButtonOnCheckboxClick",
	   "bindCancelPendingPermissionRequestClick",
	   "bindNotCancelPendingPermissionRequestClick",
	   "bindCancelPendingRequestOverlay",
	   "bindCancelPendingRequestWithColorboxClose"
	],
	showPendingRequestPopup: function (title, data)
	{
		$.colorbox({
			html: data,
			overlayClose: false,
			maxWidth: "100%",
			opacity: 0.7,
			close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
			onComplete: function() {
				$('#cboxTitle').insertBefore('#cboxLoadedContent');
            	$('#cboxClose').insertBefore('#cboxLoadedContent');
            	$('#cboxTitle').append('<div class="headline"><span class="headline-text" aria-label="'+title+'" tabindex="0" id="customTitle">'+title+'</span></div>');
            	$('#cboxClose').attr({'aria-label': PSRELATION.textCloseOverlay,'tabindex': '0'});
            	ACC.permissionselection.bindToPendingRequestColorboxOnComplete();
			}
		});
	},
	bindToPendingRequestColorboxOnComplete: function() {
		$('.sourcePermission').each(function() {
			if ($(this).find('input[type="checkbox"]').is(':checked')) {
				$(this).find('.checkbox label').addClass('checked');
				$(this).find('.checkbox').attr( 'aria-checked','true');
			 }
		});
	},

	handleViewEditPendingRequestClick: function ()
	{
		$(document).on("click", ".viewPendingRequest, .editPendingRequest", function ()
		{
			var relationId = $(this).attr('data-relationid');
			var title = $(this).attr('data-title');
			var url = ACC.config.encodedContextPath + "/my-account/pending-request/edit/" + relationId;
			var formData = {
				isGiven: $(this).attr('data-isgiven')
			};
			$.ajax({
				url: url,
				type: "GET",
				data: formData,
				dataType: "html",
				success: function(data) {
					ACC.permissionselection.showPendingRequestPopup(title, data);
				}
			});
		});
	},
	bindButtonOnCheckboxClick: function()
	{
		 $(document).on("change", ".change-permissions input[type='checkbox'], .request-more-permissions input[type='checkbox']", function() {
			 var button = $(this).parents('.request-change-permissions').find('button.btn-primary');
 	   		   button.removeAttr('disabled');
		 });
	},
	bindCancelPendingPermissionRequestClick: function()
	{
        $(document).on("click", ".cancel-request .btn-cancel-pending-permission-request", function ()
        {
        	var title = $(this).attr('data-title');
        	var url = ACC.config.encodedContextPath + "/my-account/my-relationships/cancelPermissionRequests/confirmation";
        	var formData = {
        	    relationId: $(this).attr('data-relationId'),
        	    sourceUserPK: $(this).attr('data-sourceUserPK'),
                targetUserPK: $(this).attr('data-targetUserPK'),
                isGiven: $(this).attr('data-isGiven'),
                isSourceUserLoggedIn: $(this).attr('data-isSourceUserLoggedIn')
        	};
        	$.ajax({
        		url: url,
        		type: "GET",
        		data: formData,
        		dataType: "html",
        		success: function(data) {
        			ACC.permissionselection.showPendingRequestPopup(title, data);
        		}
        	});
        });
	},
	bindNotCancelPendingPermissionRequestClick: function()
	{
	    $(document).on("click", ".btn-no-cancel", function ()
        {
            $.colorbox.close();
        });
	},
	bindCancelPendingRequestOverlay: function() {
		$(document).on(
				"click",
				".cancel-pending-request",
				function(e) {
					e.preventDefault();
					var cancelPendingRequestPopupTitle = $('.cancel-request .hide').html();
					ACC.colorbox.open($('#cancelPendingRequest')
							.html(), {
						href: "#cancelPendingRequest",
						inline: true,
						title: cancelPendingRequestPopupTitle,
						width: "550px",
						height: "450px",
						overlayClose: false,
						escKey: false,
						transition: "elastic",
						close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
						onComplete: function() {
							$('#colorbox').addClass('colorbox');
							$('#cboxTitle').insertBefore('#cboxLoadedContent');
			            	$('#cboxClose').insertBefore('#cboxLoadedContent');
			            	$('#cboxClose').attr({'aria-label': PSRELATION.textCloseOverlay,'tabindex': '0'});
						}
					});
				});
	},
	bindCancelPendingRequestWithColorboxClose: function() {
		$(document).on("click", ".pending-request-cancel,.overlay-close", function(e) {
			e.preventDefault();
			$.colorbox.close();
		});
	}
};