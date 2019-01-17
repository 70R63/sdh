ACC.silentorderpost = {
	spinner: $("<img src='" + ACC.config.commonResourcePath + "/images/spinner.gif' />"),
	currentCountryCode: '',

	bindUseDeliveryAddress: function() {
		$('#useShippingAddress').on('click', function() {
			$('#usePrimaryAddress').parent().hide();
			if($("#isPaymentAddressAvailable").val() !== "true") {
				if ($('#useShippingAddress').prop('checked'))
				{
					$('#usePrimaryAddress').attr('checked', false);
					$('#usePrimaryAddress').parent("label").removeClass("checked");
					$('#usePrimaryAddress').parent().show();
					ACC.silentorderpost.clearAddressForm();
					ACC.silentorderpost.enableAddressForm();
					ACC.silentorderpost.bindSetDefaultCountry();
					$('.js-address-book').show();
					$('#primaryAddressData').hide();
					$('#deliveryAddressData').hide();
					$('#billAddressBookSavedContent').hide();
				}
				else
				{
					var options = {'countryIsoCode': $('#useDeliveryAddressData').data('countryisocode'), 'useDeliveryAddress': true};
					ACC.silentorderpost.enableAddressForm();
					ACC.silentorderpost.displayCreditCardAddressForm(options, ACC.silentorderpost.useDeliveryAddressSelected);
					ACC.silentorderpost.disableAddressForm();
					$('.js-address-book').hide();
					$('#primaryAddressData').hide();
					$('#deliveryAddressData').show();
					$('#billAddressBookSavedContent').hide();
				}
			}
		});
	},
	bindUsePrimaryAddress: function() {
		$('#usePrimaryAddress').on('click',	function() {
			if ($('#usePrimaryAddress').prop('checked'))
		 	{
				$('#useShippingAddress').parent().show();
				ACC.silentorderpost.clearAddressForm();
				ACC.silentorderpost.enableAddressForm();
				ACC.silentorderpost.bindSetDefaultCountry();
				$('.js-address-book').show();
				$('#primaryAddressData').hide();
				$('#deliveryAddressData').hide();
				$('#billAddressBookSavedContent').hide();
			}
			else
			{
				$('#useShippingAddress').parent().hide();
				var options = {
					'countryIsoCode': $('#usePrimaryAddressData')
							.data('countryisocode'),
					'useDeliveryAddress': false,
					'usePrimaryAddress': true
				};
				ACC.silentorderpost.enableAddressForm();
				ACC.silentorderpost.displayCreditCardAddressForm(options, ACC.silentorderpost.usePrimaryAddressSelected);
				ACC.silentorderpost.disableAddressForm();

				$('.js-address-book').hide();
				$('#primaryAddressData').show();
				$('#deliveryAddressData').hide();
				$('#billAddressBookSavedContent').hide();
			}
		});
	},
   	bindSetDefaultCountry: function(){
	   var hasBillingAddressFormErrors = $('#billingCountrySelector .form-group,#billingAddressForm .form-group').hasClass('has-error');
		var hasErrorInCreditCardAndValidCustomBillingAddress= $('#silentOrderPostForm .form-group').hasClass('has-error') && !$("#useShippingAddress").prop('checked');
	   if(!hasBillingAddressFormErrors && !hasErrorInCreditCardAndValidCustomBillingAddress)
		{
	       $('#address\\.country').val(
			      $('#addressDefaultCountry').attr('data-countryisocode')).change();
		}
   },
	bindUsePaymentAddress: function ()
	{
		if($("#isPaymentAddressAvailable").val() === "true")
		{
			var options = {'countryIsoCode': $('#useSavedPaymentAddressData').data('countryisocode'),'useDeliveryAddress': false, 'usePrimaryAddress': false, 'usePaymentAddress': true};
			ACC.silentorderpost.enableAddressForm();
			ACC.silentorderpost.displayCreditCardAddressForm(options, ACC.silentorderpost.usePaymentAddressSelected);
		}
	},
	bindUseSavedAddress: function() {
		$('#addressbook .btn-billing-address').on('click', function() {
			var options = {
				'countryIsoCode': $(this).data('countryisocode'),
				'useDeliveryAddress': false,
				'addressCode': $(this).data('addresscode')
			};
			ACC.silentorderpost.currentCountryCode = $(this).data('countryisocode');
			ACC.silentorderpost.displayCreditCardAddressForm(options);
			$('#useShippingAddress').attr('checked', false);
			$('#usePrimaryAddress').attr('checked', false);
			$('#useShippingAddress').parent("label").removeClass("checked");
			$('#usePrimaryAddress').parent("label").removeClass("checked");
			$('#useShippingAddress').parent().show();
			$('#usePrimaryAddress').parent().show();
			ACC.colorbox.close();
			ACC.silentorderpost.disableAddressForm();
			$('#billAddressBookSavedContent').show();
			$('.payment-bill-address-book .addressEntry ul').html('');
			$('.payment-bill-address-book .addressEntry ul').append($(this).closest('.addressEntry').find('ul').html());
		});

		$(document).on("click", ".js-remove-bill-address-book", function (){
			ACC.silentorderpost.enableAddressForm();
			$('#billAddressBookSavedContent').hide();
			ACC.silentorderpost.bindSetDefaultCountry();
		});
	},

	bindSubmitSilentOrderPostForm: function() {
		$('.submit_silentOrderPostForm').click(function() {
			ACC.common.blockFormAndShowProcessingMessage($(this));
			ACC.silentorderpost.enableAddressForm();
			$('.billingAddressForm').filter(":hidden").remove();
			$('#silentOrderPostForm').submit();
		});

		$('#saveDraft_silentOrderPostForm').click(function() {
			$('#silentOrderPostForm').attr(
					'action', ACC.config.encodedContextPath + "/checkout/multi/payment-method/save");
			ACC.common.blockFormAndShowProcessingMessage($(this));
			ACC.silentorderpost.enableAddressForm();
			$('.billingAddressForm').filter(":hidden").remove();
			if (ACC.checkoutaddon.checkModalData()) {
				$('#silentOrderPostForm').submit();
			}
		});
	},

	bindCycleFocusEvent: function() {
		$('#lastInTheForm').blur(function() {
			$('#silentOrderPostForm [tabindex$="10"]').focus();
		});
	},

	isEmpty: function(obj) {
		if (typeof obj === 'undefined' || obj === null || obj === '')
			return true;
		return false;
	},
	showAddressForm: function() {
		$('.billingAddressForm, #silentOrderPostForm #billingCountrySelector').show();
	},
	disableAddressForm: function() {
		$('.billingAddressForm, #silentOrderPostForm #billingCountrySelector').hide();
		$('input[id^="address\\."]').prop('disabled', true);
		$('select[id^="address\\."]').prop('disabled', true);
	},

	enableAddressForm: function() {
		$('.billingAddressForm, #silentOrderPostForm #billingCountrySelector').show();
		$('input[id^="address\\."]').prop('disabled', false);
		$('select[id^="address\\."]').prop('disabled', false);
	},

	clearAddressForm: function() {
		$('input[id^="address\\."]').val("");
		$('select[id^="address\\."]').val("");
	},

	useDeliveryAddressSelected: function() {
		if ($('#useShippingAddress').is(":checked")) {
			$('#address\\.country').val(
					$('#useDeliveryAddressData').data('countryisocode'));
			ACC.silentorderpost.disableAddressForm();
		} else {
			ACC.silentorderpost.clearAddressForm();
			ACC.silentorderpost.enableAddressForm();
		}
	},

	usePrimaryAddressSelected: function() {
		if ($('#usePrimaryAddress').is(":checked")) {
			$('#address\\.country').val($('#usePrimaryAddressData').data('countryisocode'));
			ACC.silentorderpost.disableAddressForm();
		} else {
			ACC.silentorderpost.clearAddressForm();
			ACC.silentorderpost.enableAddressForm();
		}
	},

	usePaymentAddressSelected: function ()
	{
		if($("#isPaymentAddressAvailable").val() === "true")
		{
			$('#address\\.country').val($('#useSavedPaymentAddressData').data('countryisocode'));
			$("#isPaymentAddressAvailable").attr("value", "false");
		}
	},
	useSavedAddressSelected: function() {
		$('#address\\.country').val(ACC.silentorderpost.currentCountryCode);
		ACC.silentorderpost.disableAddressForm();
		ACC.silentorderpost.showAddressForm();
	},

	bindCreditCardAddressForm: function() {
		$(document).on("click", ".js-billingSavedCardAddress", function (e){
			e.preventDefault();
			$.colorbox.close();
			$('#silentOrderPostForm').hide();
			$('#billCreditCardSavedContent').show();
			$('#selectedPaymentMethodId').val($(this).siblings('.paymentMethodId').val());
			$('.bill-saved-address-book .addressEntry ul').html('');
			$('.bill-saved-address-book .addressEntry ul').append($(this).closest('.saved-payment-entry').find('ul').html());
		});

		$(document).on("click", ".js-remove-bill-saved-card", function (){
			$('#silentOrderPostForm').show();
			$('#billCreditCardSavedContent').hide();
			$('#selectedPaymentMethodId').val('');
			ACC.silentorderpost.bindSetDefaultCountry();
		});
		$('#billingCountrySelector :input').on("change", function() {
			var countrySelection = $(this).val();
			var options = {
				'countryIsoCode': countrySelection,
				'useDeliveryAddress': false
			};
			ACC.silentorderpost.displayCreditCardAddressForm(options);
		});
	},

	displayCreditCardAddressForm: function(options, callback) {
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/checkout/multi/sop/billingaddressform',
				async: true,
				data: options,
				dataType: "html",
				beforeSend: function() {
					$('#billingAddressForm').html(ACC.silentorderpost.spinner);
				}
			}).done(function(data) {
			$("#billingAddressForm").html(data);

			if (typeof callback === 'function') {
				callback.call();
			}
		});
	},
	bindSavedPayments: function(){
		$(document).on("click",".js-saved-payments",function(e){
			e.preventDefault();
			var title = $("#savedpaymentstitle").html();
			var popupTitleAriaLabel = $("#savedpaymentstitle .headline-text").html();
			$.colorbox({
				href: "#savedpaymentsbody",
				inline: true,
				maxWidth: "100%",
				opacity: 0.7,
				title: title,
				close: '<span class="glyphicon glyphicon-remove"></span>',
				onComplete: function(){
					$('#cboxTitle').insertBefore('#cboxLoadedContent');
	            	$('#cboxClose').insertBefore('#cboxLoadedContent');
	            	$('.headline-text').attr({'aria-label': popupTitleAriaLabel,'tabindex': '0','id': 'customTitle'});
	            	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
				}
			});
		});
	},
	bindOnCardType: function(){
		$('#card_cardType').on('change',function(){
			$('#card_cvNumber').attr('value','');
			if($(this).val()==="003"){
				$('#card_cvNumber').attr('maxlength','4');
			}else{
				$('#card_cvNumber').attr('maxlength','3');
			}
		});

		$("#card_cvNumber").keypress(function (e) {
		     //if the letter is not digit then don't type anything
		     if(e.which !== 8 && e.which !== 0 && (e.which < 48 || e.which > 57)){
		          return false;
		       }
		   });
	}
};

$(document).ready(function() {
		ACC.silentorderpost.bindUseDeliveryAddress();
		ACC.silentorderpost.bindUsePrimaryAddress();
		ACC.silentorderpost.bindUseSavedAddress();
		ACC.silentorderpost.bindSubmitSilentOrderPostForm();
		ACC.silentorderpost.bindCreditCardAddressForm();
		ACC.silentorderpost.bindSavedPayments();
		ACC.silentorderpost.bindOnCardType();
	var useShippingAddressCheckbox=$("#useShippingAddress");
	var usePrimaryAddressCheckbox=$("#usePrimaryAddress");
	if($("#isPaymentAddressAvailable").val() === "true")
	{
		useShippingAddressCheckbox.attr('checked', false);
		useShippingAddressCheckbox.parent("label").removeClass("checked");
		ACC.silentorderpost.bindUsePaymentAddress();
	}
	else
	{
	    var hasBillingAddressFormErrors = $('#billingCountrySelector .form-group,#billingAddressForm .form-group').hasClass('has-error');
		var hasErrorInCreditCardAndValidCustomBillingAddress= $('#silentOrderPostForm .form-group').hasClass('has-error') && !$("#useShippingAddress").prop('checked');
	    if(!hasBillingAddressFormErrors && !hasErrorInCreditCardAndValidCustomBillingAddress)
		{
	    	if(useShippingAddressCheckbox.length){
	    	useShippingAddressCheckbox.attr("checked",true);
	    	useShippingAddressCheckbox.click();
	    	}
	    	else if(usePrimaryAddressCheckbox.length)
	    	{
	    		usePrimaryAddressCheckbox.attr("checked",true);
	    		usePrimaryAddressCheckbox.click();
	    	}else{
	    		ACC.silentorderpost.bindSetDefaultCountry();
	    	}
		}
	}
	var savePaymentCheckboxLabel=$("#savePaymentMethod").parent("label");
	if($('#savePaymentMethod').prop('checked')) {
		savePaymentCheckboxLabel.addClass("checked");
	}else {
		savePaymentCheckboxLabel.removeClass("checked");
	}
});