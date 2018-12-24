ACC.account = {
	_autoload: ["bindDraftDeleteOverlay", "bindDeleteDraftSubmit", "bindEditDraftServiceRequestSubmit",
			"bindCancelWithColorboxClose",
			"displayRelationshipUserBills", "displayRelationshipUserDocuments", "displayRelationshipUserApplications" , "showRemovePaymentDetailsConfirmation"],

	bindEditDraftServiceRequestSubmit: function() {
		$(document).on("click", ".js-edit-draft-service-request", function(e) {
			var draftCode = $(this).parent('.retrieveQuoteForm').find('.draftCode').val();

			// check if it locked
			if (ACC.account.checkLockedCart(draftCode)) {
 				e.preventDefault();
				ACC.account.displayLockedCartPopup(draftCode);
				return false;
			} else {
				$(this).parent('.retrieveQuoteForm').submit();
			}
		});
	},

	bindDraftDeleteOverlay: function() {
		$(document).on("click",".delete-draft", function(e) {
			var draftCode = $(this).parent('.retrieveQuoteForm').find('.draftCode').val();
			// check if it locked
			if (ACC.account.checkLockedCart(draftCode)) {
 				e.preventDefault();
				ACC.account.displayLockedCartPopup(draftCode);
				return false;
			} else {
				ACC.account.updateOverlayWithSelectedDraftInfo(this);
				var deleteDraftPopupTitle;
				deleteDraftPopupTitle = $('.divTableRow .hide').html();
       			if (!deleteDraftPopupTitle){
       				deleteDraftPopupTitle = $('.dashlet-application-request .hide').html();
      			}
				var deleteDraftPopupAriaLableTitle = $('.divTableRow .hide .headline-text').html();

				ACC.colorbox.open($('#delete-draft-overlay #draftHeading')
						.html(), {
					href: "#delete-draft-overlay",
					inline: true,
					title: deleteDraftPopupTitle,
					width: "auto",
					overlayClose: false,
					escKey: false,
					fixed: true,
					transition: "elastic",
					close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
					onComplete: function() {
						$(window).resize(function(){
						    if(!$('#colorbox').hasClass('variantSelectMobile')){
						        $.colorbox.resize({
						            height: "63%"
						        });
						    }
						});
						$('#cboxTitle').insertBefore('#cboxLoadedContent');
		            	$('#cboxClose').insertBefore('#cboxLoadedContent');
		            	$('.headline-text').attr({'aria-label': deleteDraftPopupAriaLableTitle,'tabindex': '0','id': 'customTitle'});
		            	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
					}
				});
			}
			e.preventDefault();
			return false;
		});
	},
	bindCancelWithColorboxClose: function() {
		$(document).on("click", ".delete-cancel", function(e) {
			e.preventDefault();
			$.colorbox.close();
		});
	},
	updateOverlayWithSelectedDraftInfo: function(currentDraft) {
		var deleteDraftUrl;
		$('#delete-draft-overlay #productname').html(
				$(currentDraft).data("product-name"));
		$('#delete-draft-overlay #productname').attr(
				'aria-label',$(currentDraft).data("product-name"));
		$('#delete-draft-overlay #draftNumber').html(
				$(currentDraft).data("draft-code"));
		$('#delete-draft-overlay .draft-no').closest('div').attr(
				'aria-label',$.trim($('.draft-no').html())  + ' ' + $(currentDraft).data("draft-code"));
		if($(currentDraft).data("customer-email") === null || $(currentDraft).data("customer-email") === ''){
			deleteDraftUrl = $('#delete-draft-overlay #delete-draft-submit')
					.data('url') + $(currentDraft).data("draft-code") + "?CSRFToken=" + ACC.config.CSRFToken;
		}else{
			deleteDraftUrl = $('#delete-draft-overlay #delete-draft-submit')
			.data('relationship-url') + $(currentDraft).data("draft-code") + "?CSRFToken="	+ ACC.config.CSRFToken + "&customerId="+ $(currentDraft).data("customer-email");
		}
		$('#delete-draft-overlay #delete-draft-submit').attr('href', deleteDraftUrl);
	},
	bindDeleteDraftSubmit: function() {
		$(document).on("click", '#delete-draft-submit', function() {
			$("#delete-draft-overlay").html(ACC.address.spinner);
		});
	},

	displayRelationshipUserDocuments: function() {
		$('.relationDocumentsLink').on("click", function() {
			ACC.account.bindRelationshipUserDocuments(this);
		});
	},
	bindRelationshipUserDocuments: function(thisObject){
			var loopCount = $(thisObject).first().find('#loopCount').val();
			var customerId = $('#hidden_'+loopCount).val();
			var options = {
				'customerId': customerId
			};
			ACC.account.getRelationshipUserDocumentData(
				options,loopCount
			);
			$(thisObject).addClass("loadedContent");
	},

	getRelationshipUserDocumentData: function(options, loopCount, callback) {
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/my-account/documents/loadCustomerDocuments',
				async: false,
				data: options,
				dataType: "html",
				beforeSend: function() {
					$('#relationdocumentsSection_'+loopCount).html(ACC.address.spinner);
				}
			}).done(function(data) {
				$('#relationdocumentsSection_'+loopCount).html(data);
				if (typeof callback === 'function') {
					callback.call();
				}
			});
	},
	displayRelationshipUserBills: function() {
		$('.relationbillsLink').on("click", function() {
			ACC.account.bindRelationshipUserBills(this);
		});
	},

	bindRelationshipUserBills: function(thisObject) {
		var loopCount = $(thisObject).first().find('#loopCount').val();
		var customerId = $('#hidden_'+loopCount).val();
		var options = {
			'customerId': customerId
		};
		ACC.account.getRelationshipUserBillData(
				options,loopCount
				);
		$(thisObject).addClass("loadedContent");
	},

	getRelationshipUserBillData: function(options, loopCount, callback) {
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/my-account/bills/loadCustomerBills',
				async: false,
				data: options,
				dataType: "html",
				beforeSend: function() {
					$('#relationbillsSection_'+loopCount).html(ACC.address.spinner);
				}
			}).done(function(data) {
			$('#relationbillsSection_'+loopCount).html(data);
			$('#relationbillsSection_'+loopCount).find('.content-space').removeClass('content-space');
			if (typeof callback === 'function') {
				callback.call();
			}
		});
	},
	displayRelationshipUserApplications: function() {
		$('.relationApplicationsLink').on("click", function() {
			ACC.account.bindRelationshipUserApplications(this);
		});
	},

	bindRelationshipUserApplications: function(thisObject){
		var loopCount = $(thisObject).first().find('#loopCount').val();
		var customerId = $('#hidden_'+loopCount).val();
		var options = {
			'customerId': customerId
		};
		ACC.account.getRelationshipUserApplicationsData(options,loopCount);
		$(thisObject).addClass("loadedContent");
	},

	getRelationshipUserApplicationsData: function(options, loopCount, callback) {
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/my-account/loadRelationApplications',
				async: false,
				data: options,
				dataType: "html",
				beforeSend: function() {
					$('#relationApplicationsSection_'+loopCount).html(ACC.address.spinner);
				}
			}).done(function(data) {
			$('#relationApplicationsSection_'+loopCount).html(data);
			$('#relationApplicationsSection_'+loopCount).find('.content-space').removeClass('content-space');
			if (typeof callback === 'function') {
				callback.call();
			}
		});
	},

	checkLockedCart: function(draftCode) {
		var cartLocked = false;
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/my-account/checkLockedCart',
				type: "GET",
				async: false,
				data: {
					draftCode: draftCode
				},
				success: function (response) {
					cartLocked = response;
				}
			});
		return  cartLocked;
	},

	displayLockedCartPopup: function(draftCode, customerEmail, callback){
		$.ajax({
			url: ACC.config.encodedContextPath + '/my-account/displayLockedCartPopup',
			type: "POST",
			async: false,
			data: {
				draftCode: draftCode
			},
			dataType: "html"
		}).done(function(data) {
			$.colorbox({
				html: data,
				overlayClose: false,
				maxWidth: "100%",
				width: "auto",
				opacity: 0.7,
				fixed: true,
				transition: "elastic",
				title: PSACC.textTitleCartLockOverlay,
				close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
				onComplete: function() {
					$(window).resize(function(){
					    if(!$('#colorbox').hasClass('variantSelectMobile')){
					        $.colorbox.resize({
					            height: "55%"
					        });
					    }
					});
					$('#cboxTitle').insertBefore('#cboxLoadedContent');
					$('#cboxClose').insertBefore('#cboxLoadedContent');
					$('.headline-text').attr({'aria-label': PSACC.textTitleCartLockOverlay,'tabindex': '0','id': 'customTitle'});
					$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
				}
			});

			if (typeof callback === 'function') {
				callback.call();
			}
		});
	},
	showRemovePaymentDetailsConfirmation: function ()
	{
		$(document).on("click", ".removePaymentDetailsButton", function (){
			var paymentId = $(this).data("paymentId");
			var popupTitle = $(this).data("popupTitle");
			ACC.colorbox.open(popupTitle,{
				inline: true,
				href: "#popup_confirm_payment_removal_" + paymentId,
				onComplete: function ()
				{
					$(this).colorbox.resize();
					$('#cboxTitle').insertBefore('#cboxLoadedContent');
	            	$('#cboxClose').insertBefore('#cboxLoadedContent');
	            	$('.headline-text').attr({'aria-label': popupTitle,'tabindex': '0','id': 'customTitle'});
	            	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
				}
			});

		});
	}
};
