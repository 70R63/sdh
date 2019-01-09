ACC.billaddress = {

	spinner: $("<img src='" + ACC.config.commonResourcePath + "/images/spinner.gif' />"),
	currentCountryCode: '',
	bindBillViewAddressBook: function ()
	{
		$(document).on("click",".js-billaddress-book",function(e){
			e.preventDefault();
			var title = $("#billaddressbooktitle").html();
            var ariaLabelTitle = $("#billaddressbooktitle .headline-text").html();
			ACC.colorbox.open("Saved Addresses",{
				href: "#billaddressbookBody",
				inline: true,
				width: "380px",
				title: title,
				close: '<span class="glyphicon glyphicon-remove" aria-label="saved Address close button"></span>',
                onComplete: ACC.billaddress.callbackOnOverlayClose(ariaLabelTitle)
			});
		});
	},
	showAddressForm: function() {
		$('.billingAddressForm, #billPaymentForm #billCountrySelector').show();
	},
	useSavedAddressSelected: function() {
		$('#address\\.country').val(ACC.billaddress.currentCountryCode);
		ACC.billaddress.disableAddressForm();
		ACC.billaddress.showAddressForm();
	},
	bindBillUseSavedAddress: function() {
		$('#billaddressbook .btn-billbilling-address').on('click', function() {
			$('#useBillPrimaryAddress').attr('checked', false);
			$('#useBillPrimaryAddress').parent("label").removeClass("checked");
			var options = {
				'countryIsoCode': $(this).data('countryisocode'),
				'useDeliveryAddress': false,
				'addressCode': $(this).data('addresscode')
			};
			ACC.billaddress.currentCountryCode= $(this).data('countryisocode');
			ACC.billaddress.displayCreditCardAddressForm(options,
					ACC.billaddress.useSavedAddressSelected);
			ACC.colorbox.close();
			ACC.billaddress.disableAddressForm();
		});
	},
	disableAddressForm: function() {
		$('.billingAddressForm, #billPaymentForm #billCountrySelector').hide();
		$('input[id^="address\\."]').prop('disabled', true);
		$('select[id^="address\\."]').prop('disabled', true);
	},
	enableAddressForm: function() {
		$('.billingAddressForm, #billPaymentForm #billCountrySelector').show();
		$('input[id^="address\\."]').prop('disabled', false);
		$('select[id^="address\\."]').prop('disabled', false);
	},
	clearAddressForm: function() {
		$('input[id^="address\\."]').val("");
		$('select[id^="address\\."]').val("");
	},
	displayCreditCardAddressForm: function(options, callback) {
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/bills/billingaddressform',
				async: true,
				data: options,
				dataType: "html",
				beforeSend: function() {
					$('#billingAddressForm').html(ACC.billaddress.spinner);
				}
			}).done(function(data) {
			$("#billingAddressForm").html(data);
			if (typeof callback === 'function') {
				callback.call();
			}
		});
	},
	usePrimaryAddressSelected: function() {
		if ($("#useBillPrimaryAddress").prop("checked") === true) {
			$('#address\\.country').val($('#useBillPrimaryAddressData').data('countryisocode'));
			ACC.billaddress.disableAddressForm();
		} else {
			ACC.billaddress.clearAddressForm();
			ACC.billaddress.enableAddressForm();
		}
	},
	bindUsePrimaryAddress: function() {
		$('#useBillPrimaryAddress').on(
				'change',
				function() {
					if ($("#useBillPrimaryAddress").prop("checked") === true) {
						var options = {
							'countryIsoCode': $('#useBillPrimaryAddressData')
									.data('countryisocode'),
							'usePrimaryAddress': true
						};
						ACC.billaddress.enableAddressForm();
						ACC.billaddress.displayCreditCardAddressForm(
								options,
								ACC.billaddress.usePrimaryAddressSelected);
						ACC.billaddress.disableAddressForm();
						$('.js-billaddress-book').hide();
					} else {
						$('.js-billaddress-book').show();
						ACC.billaddress.clearAddressForm();
						ACC.billaddress.enableAddressForm();
					}
				});
		if ($('#useBillPrimaryAddress').is(":checked")) {
			var options = {
				'countryIsoCode': $('#useBillPrimaryAddressData').data(
						'countryisocode'),
				'usePrimaryAddress': true
			};
			ACC.billaddress.enableAddressForm();
			ACC.billaddress.displayCreditCardAddressForm(options,
					ACC.billaddress.usePrimaryAddressSelected);
			ACC.billaddress.disableAddressForm();
		}
	},
	bindCreditCardAddressForm: function() {
		$('select[name="billTo_country"]').on("change", function() {
			var countrySelection = $(this).val();
			if(!countrySelection) {
				countrySelection = $('#addressDefaultCountry').attr('data-countryisocode');
		    }
			var options = {
				'countryIsoCode': countrySelection,
				'usePrimaryAddress': false
			};
			ACC.billaddress.displayCreditCardAddressForm(
					options
					);
		});
	},
	bindPartialAmountValidation: function(){
		$('.bill-textbox #partial_amount').on('change', function() {
			$.ajax(
					{
						url: ACC.config.encodedContextPath + '/bills/validatePartialAmount',
						async: true,
						dataType: "json",
						data: {billCode: $('#billCode').val(), partialAmount: $(this).val()},
						beforeSend: function() {
							$('.bill-textbox #partial_amount').parent().parent('.form-group').removeClass("has-error");
							$('.bill-textbox #partial_amount').parent().siblings('.amount_help_block').remove();
						}
					}).done(function(result) {
						if(result.result.valid==='false'){
							$('.bill-textbox #partial_amount').parent().parent('.form-group').addClass("has-error");
							var error ='<div class="help-block amount_help_block col-md-12 col-sm-12 col-xs-12"><span id="amount.errors">'+result.result.errorMessage+'</span></div>';
							$('.bill-textbox #partial_amount').parent().parent('.form-group').append(error);
							$('.submit_billPaymentForm').prop('disabled',true);
						}else{
							$('.bill-textbox #partial_amount').parent().parent('.form-group').removeClass("has-error");
							$('.bill-textbox #partial_amount').parent().siblings('.amount_help_block').remove();
							$('.submit_billPaymentForm').prop('disabled',false);
						}
					});
		});
	},
	//Use Saved Card JS start
	bindSavedPayments: function(){
		$(document).on("click",".js-billsaved-payments",function(e){
			e.preventDefault();
			var title = $("#billsavedpaymentstitle").html();
			var ariaLabelTitle = $("#billsavedpaymentstitle .headline-text").html();
			$.colorbox({
				href: "#billsavedpaymentsbody",
				inline: true,
				maxWidth: "100%",
				opacity: 0.7,
				//width:"320px",
				title: title,
				close: '<span class="glyphicon glyphicon-remove"></span>',
				onComplete: ACC.billaddress.callbackOnOverlayClose(ariaLabelTitle)
			});
		});
	},
	bindUsedBillPaymentDetails: function(){
		$(document).on("click",".use-bill-Payment-Details",function(){
			$.colorbox.close();
			$('#usePaymentInfo').attr('value','true');
			$('#paymentId').attr('value', $(this).parent('.saved-payment-entry').find('.selectedPaymentMethod').val());
			$('.use-Bill-Payment-trigger').hide();
			$('.bill-card-content .bill-card-details ul').html('');
			$('.bill-card-content .bill-card-details').append($(this).parent('.saved-payment-entry').html());
			$('.bill-card-content .btn').hide();
			$('.bill-card-content').show();
			$('.bill-card-content').next('.bills-steps-buttons').addClass('bills-buttons');
			$('#billPaymentForm').attr('action', $('#customSOPResponseUrl').attr('value'));
		});
	},
	bindRemoveBillPaymentButton: function(){
		$(document).on("click",".removeBillPaymentButton",function(){
			$('#usePaymentInfo').attr('value','false');
			$('.bill-card-content').hide();
			$('.bill-card-content').next('.bills-steps-buttons').removeClass('bills-buttons');
			$('.use-Bill-Payment-trigger').show();
			$('select[id="card_cardType"]').focus();
			event.preventDefault();
		});
	},
	bindSubmitButtonClick: function(){
		$(document).on("click",".submit_billPaymentForm",function(){
			ACC.billaddress.enableAddressForm();
		});
	},
	backToBillReferer: function(){
		$(".billBackBtn").on("click", function(){
			var sUrl = $(this).data("backToAddresses");
			window.location = sUrl;
		});
	},
	preventBillPaymentFormSubmitOnEnter: function(){
		$("#billPaymentForm").on("keyup keypress", function(event) {
		    if(event.keyCode === 13) {
		      event.preventDefault();
		      return false;
		    }
		    return true;
		});
	},
	callbackOnOverlayClose: function(ariaLabelTitle){
		$('#cboxTitle').insertBefore('#cboxLoadedContent');
    	$('#cboxClose').insertBefore('#cboxLoadedContent');
    	$('.headline-text').attr({'aria-label': ariaLabelTitle,'tabindex': '0','id': 'customTitle'});
    	$('#cboxClose').attr({'aria-label': PSBILL.textCloseOverlay,'tabindex': '0'});
	}
};
$(document).ready(function() {
	ACC.billaddress.bindBillViewAddressBook();
	ACC.billaddress.bindBillUseSavedAddress();
	ACC.billaddress.bindUsePrimaryAddress();
	ACC.billaddress.bindSavedPayments();
	ACC.billaddress.bindPartialAmountValidation();
	ACC.billaddress.bindUsedBillPaymentDetails();
	ACC.billaddress.bindRemoveBillPaymentButton();
	ACC.billaddress.bindCreditCardAddressForm();
	ACC.billaddress.bindSubmitButtonClick();
	ACC.billaddress.backToBillReferer();
	ACC.billaddress.preventBillPaymentFormSubmitOnEnter();
});
