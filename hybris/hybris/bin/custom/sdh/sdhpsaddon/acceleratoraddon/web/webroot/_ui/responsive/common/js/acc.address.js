ACC.address = {
	_autoload: [
		"bindToChangeAddressButton",
		"bindCreateUpdateAddressForm",
		"bindSuggestedDeliveryAddresses",
		"bindCountrySpecificAddressForms",
		"showAddressFormButtonPanel",
		"bindViewAddressBook",
		"bindToColorboxClose",
		"showRemoveAddressFromBookConfirmation",
		"backToListAddresses",
		"bindUsePrimaryAddressShippingOnLoad",
		"bindUsePrimaryAddressShipping",
		"bindUseSavedDeliveryAddressOnLoad",
		"useDeliveryAddressSelected",
		"displayRelationshipUserAddresses",
		"bindOnSelectShippingAddress",
		"bindDeleteShippingAddress",
		"initOnCheckboxSelect"
	],

	spinner: $("<img src='" + ACC.config.commonResourcePath + "/images/spinner.gif' />"),
	addressID: '',

	handleChangeAddressButtonClick: function ()
	{
		ACC.address.addressID = ($(this).data("address")) ? $(this).data("address") : '';
		$('#summaryDeliveryAddressFormContainer').show();
		$('#summaryOverlayViewAddressBook').show();
		$('#summaryDeliveryAddressBook').hide();
		$.getJSON(getDeliveryAddressesUrl, ACC.address.handleAddressDataLoad);
		return false;
	},

	handleAddressDataLoad: function (data)
	{
		ACC.address.setupDeliveryAddressPopupForm(data);
		// Show the delivery address popup
		ACC.colorbox.open("",{
		 	inline: true,
			href: "#summaryDeliveryAddressOverlay",
			overlayClose: false,
			onOpen: function (){
				// empty address form fields
				ACC.address.emptyAddressForm();
				$(document).on('change', '#saveAddress', function ()
				{
					var saveAddressChecked = $(this).prop('checked');
					$('#defaultAddress').prop('disabled', !saveAddressChecked);
					if (!saveAddressChecked)
					{
						$('#defaultAddress').prop('checked', false);
					}
				});
			}
		});
	},

	setupDeliveryAddressPopupForm: function (data)
	{
		// Fill the available delivery addresses
		$('#summaryDeliveryAddressBook').html($('#deliveryAddressesTemplate').tmpl({addresses: data}));
		// Handle selection of address
		$('#summaryDeliveryAddressBook button.use_address').click(ACC.address.handleSelectExistingAddressClick);
		// Handle edit address
		$('#summaryDeliveryAddressBook button.edit').click(ACC.address.handleEditAddressClick);
		// Handle set default address
		$('#summaryDeliveryAddressBook button.default').click(ACC.address.handleDefaultAddressClick);
	},

	emptyAddressForm: function ()
	{
		var options = {
			url: getDeliveryAddressFormUrl,
			data: {addressId: ACC.address.addressID, createUpdateStatus: ''},
			type: 'GET',
			success: function (data)
			{
				$('#summaryDeliveryAddressFormContainer').html($.parseHTML(data));
				ACC.address.bindCreateUpdateAddressForm();
			}
		};
		$.ajax(options);
	},

	handleSelectExistingAddressClick: function ()
	{
		var addressId = $(this).attr('data-address');
		$.postJSON(setDeliveryAddressUrl, {addressId: addressId}, ACC.address.handleSelectExitingAddressSuccess);
		return false;
	},

	handleEditAddressClick: function ()
	{
		$('#summaryDeliveryAddressFormContainer').show();
		$('#summaryOverlayViewAddressBook').show();
		$('#summaryDeliveryAddressBook').hide();
		var addressId = $(this).attr('data-address');
		var options = {
			url: getDeliveryAddressFormUrl,
			data: {addressId: addressId, createUpdateStatus: ''},
			target: '#summaryDeliveryAddressFormContainer',
			type: 'GET',
			success: function ()
			{
				ACC.address.bindCreateUpdateAddressForm();
				ACC.colorbox.resize();
			},
			error: function (xht, textStatus, ex)
			{
				alert("Failed to update cart. Error details [" + xht + ", " + textStatus + ", " + ex + "]"); // NOSONAR
			}
		};
		$(this).ajaxSubmit(options);
		return false;
	},

	handleDefaultAddressClick: function ()
	{
		var addressId = $(this).attr('data-address');
		var options = {
			url: setDefaultAddressUrl,
			data: {addressId: addressId},
			type: 'GET',
			success: function (data)
			{
				ACC.address.setupDeliveryAddressPopupForm(data);
			},
			error: function (xht, textStatus, ex)
			{
				alert("Failed to update address book. Error details [" + xht + ", " + textStatus + ", " + ex + "]"); // NOSONAR
			}
		};

		$(this).ajaxSubmit(options);
		return false;
	},

	handleSelectExitingAddressSuccess: function (data)
	{
		if (data !== null)
		{
			ACC.refresh.refreshPage(data);
			ACC.colorbox.close();
		}
		else
		{
			alert("Failed to set delivery address"); // NOSONAR
		}
	},

	bindCreateUpdateAddressForm: function ()
	{
		$('.create_update_address_form').each(function ()
		{
			var options = {
				type: 'POST',
				beforeSubmit: function ()
				{
					$('#checkout_delivery_address').block({message: ACC.address.spinner});
				},
				success: function (data)
				{
					$('#summaryDeliveryAddressFormContainer').html(data);
					var status = $('.create_update_address_id').attr('status');
					if (status !== null && status.toLowerCase() === "success")
					{
						ACC.refresh.getCheckoutCartDataAndRefreshPage();
						ACC.colorbox.close();
					}
					else
					{
						ACC.address.bindCreateUpdateAddressForm();
						ACC.colorbox.resize();
					}
				},
				error: function (xht, textStatus, ex)
				{
					alert("Failed to update cart. Error details [" + xht + ", " + textStatus + ", " + ex + "]"); // NOSONAR
				},
				complete: function ()
				{
					$('#checkout_delivery_address').unblock();
				}
			};
			$(this).ajaxForm(options);
		});
	},

	refreshDeliveryAddressSection: function (data)
	{
		$('.summaryDeliveryAddress').replaceWith($('#deliveryAddressSummaryTemplate').tmpl(data));
	},

	bindSuggestedDeliveryAddresses: function ()
	{
		var status = $('.add_edit_delivery_address_id').attr('status');
		if (status !== null && status === "hasSuggestedAddresses")
		{
			ACC.address.showSuggestedAddressesPopup();
		}
	},

	showSuggestedAddressesPopup: function ()
	{
		ACC.colorbox.open("",{
			href: "#popup_suggested_delivery_addresses",
			inline: true,
			overlayClose: false,
			width: 525
		});
	},

	bindCountrySpecificAddressForms: function (){
		$(document).on("change",'#countrySelector select', function (event){
			event.stopPropagation();
			var usePrimaryAddressValue, countryIsoCode;
			if ($('#usePrimaryAddressShip').is(":checked")){
				usePrimaryAddressValue = true;
			}else{
				usePrimaryAddressValue = false;
			}
			if($(this).val() !==null && $(this).val().length !==0 ){
				countryIsoCode = $(this).val();
			}else if($('[name=primaryAddressCountry]').val() !== undefined){
				countryIsoCode = $('[name=primaryAddressCountry]').val();
			}else{
				countryIsoCode = $('#selectedDeliveryAddress').data('countryisocode');
			}
			var options = {
				'addressCode': '',
				'countryIsoCode': countryIsoCode,
				'usePrimaryAddress': usePrimaryAddressValue
			};
			if($(this).val()!==null && $(this).val().length !==0){
			   ACC.address.displayCountrySpecificAddressForm(options, ACC.address.showAddressFormButtonPanel);
			}else{
				$('#address\\.country').val(countryIsoCode);
			}
		});
	},
	bindUsePrimaryAddressShippingOnLoad: function (){
		if($('#usePrimaryAddressShip').is(":visible") && $("#showSelectedDeliveryAddress").length && $("#showSelectedDeliveryAddress").val() === "false") {
			$('#usePrimaryAddressShip').prop('checked', true);
			$('#saveAddressInMyAddressBook').prop('checked', false);
			var usePrimaryAddressValue = true;
			var options = {
					'addressCode': '',
					'countryIsoCode': $('#countrySelector select').val(),
					'usePrimaryAddress': usePrimaryAddressValue
				};
			ACC.address.displayCountrySpecificAddressForm(options, ACC.address.showAddressFormButtonPanel);
		}
	},

	bindUsePrimaryAddressShipping: function (){
		$(document).on('change' , '#usePrimaryAddressShip', function (){
			 ACC.address.usePrimaryAddressShippingContent();
			 if (!$('#usePrimaryAddressShip').is(":checked")){
					$('#address\\.country').val($('#addressDefaultCountry').val()).change();
					$('.display-primary-address').removeClass('hideContent');
			 }
		});
	},
	bindUseSavedDeliveryAddressOnLoad: function (){
		if($("#showSelectedDeliveryAddress").val() === "true") {
			var options = {
					'addressCode': $('#selectedDeliveryAddress').data('addresscode'),
					'countryIsoCode': $('#selectedDeliveryAddress').data('countryisocode'),
					'usePrimaryAddress': false,
					'useDeliveryAddress': true
				};
			ACC.address.displayCountrySpecificAddressForm(options, ACC.address.useDeliveryAddressSelected);
		}
	},

	disableAddressForm: function ()
	{
		$('#addressForm #i18nAddressForm').hide();
		$('#addressForm #countrySelector').hide();
		$('input[id^="address\\."]').prop('readonly', true);
		$('select[id^="address\\."]').prop('readonly', true);
		$('select[id^="address\\."] option:not(:selected)').attr('disabled', true);
	},

	enableAddressForm: function ()
	{
		$('#addressForm #i18nAddressForm').show();
		$('#addressForm #countrySelector').show();
		$('input[id^="address\\."]').prop('readonly', false);
		$('select[id^="address\\."]').prop('readonly', false);
		$('option:not(:selected)').attr('disabled', false);
	},

	clearAddressForm: function ()
	{
		$('input[id^="address\\."]').val("");
		$('select[id^="address\\."]').val("");
	},
    showAddressFormButtonPanel: function (usePrimaryAddressShipping,useThisAddress)
    {
        if ($('#countrySelector :input').val() !== '')
        {
            $('#addressform_button_panel').show();
        }
        if($('#usePrimaryAddressShip:checked').is(":checked") && $('[name=primaryAddressCountry]').length) {
            $('#address\\.country').val($('[name=primaryAddressCountry]').val());
        }
        var $saveAddressInMyAddressBook = $('#saveAddressInMyAddressBook');
        if($('#usePrimaryAddressShip').is(":checked")){
            ACC.address.togglePrimaryAddressShipSelector($saveAddressInMyAddressBook, useThisAddress);
        }else{
            ACC.address.togglePrimaryAddressCheck($saveAddressInMyAddressBook);
            ACC.address.toggleUseThisAddress(usePrimaryAddressShipping, useThisAddress);
        }
    },
	toggleUseThisAddress: function(usePrimaryAddressShipping, useThisAddress){
        if(useThisAddress===true){
            $('#countrySelector, #i18nAddressForm, .saveAddress-inMy-AddressBook, .primary-address').hide();
            $('.addressBook-primary-address, .shipping-primary-address-delete').show();
        }else{
            var countryCode = $('#addressDefaultCountry').val();
            var options = {
                'addressCode': '',
                'countryIsoCode': countryCode,
                'usePrimaryAddress': false
            };
            if(usePrimaryAddressShipping){
                ACC.address.displayCountrySpecificAddressForm(options,'',countryCode);
            }
            $('#countrySelector, #i18nAddressForm, .shipping-primary-address-delete, .saveAddress-inMy-AddressBook').show();
            $('.shipping-address-content').hide();
            ACC.address.enableAddressForm();
        }
	},
	togglePrimaryAddressCheck: function(saveAddressInMyAddressBook) {
        saveAddressInMyAddressBook.prop('checked', false);
        saveAddressInMyAddressBook.parent("label").removeClass("checked");
        saveAddressInMyAddressBook.parent("label").show();
        if($.trim($('.usePrimaryAddressShip-checkbox').html())===''){
            $('.usePrimaryAddressShip-checkbox').addClass('hideContent');
        }else{
            $('.usePrimaryAddressShip-checkbox').removeClass('hideContent');
        }
        if($('[name=primaryAddressCountry]').val()){
            $('#address\\.country').val($('[name=primaryAddressCountry]').val());
        }
        $(".js-address-book").show();
	},
	togglePrimaryAddressShipSelector: function(saveAddressInMyAddressBook, useThisAddress) {
        saveAddressInMyAddressBook.prop('checked', false);
        saveAddressInMyAddressBook.parent("label").removeClass("checked");
        saveAddressInMyAddressBook.parent("label").hide();
        $(".js-address-book").hide();
        ACC.address.disableAddressForm();
        if(useThisAddress===true){
            $('#countrySelector, #i18nAddressForm, .saveAddress-inMy-AddressBook, .primary-address').hide();
            $('.addressBook-primary-address, .shipping-primary-address-delete').show();
        }else{
            $('#countrySelector, #i18nAddressForm, .shipping-primary-address-delete, .addressBook-primary-address').hide();
            $('.primary-address').show();
        }
	},
	useDeliveryAddressSelected: function ()
	{
		if($("#showSelectedDeliveryAddress").val() === "true") {
			$('#address\\.country').val($('#selectedDeliveryAddress').data('countryisocode'));
			$("#showSelectedDeliveryAddress").attr("value", "false");
			ACC.address.enableAddressForm();
		}
	},

	bindToColorboxClose: function ()
	{
		$(document).on("click", ".closeColorBox", function ()
		{
			ACC.colorbox.close();
		});
	},

	displayCountrySpecificAddressForm: function (options, callback, countryCode)
	{
		$.ajax({
			url: ACC.config.encodedContextPath + '/my-account/addressform',
			async: true,
			data: options,
			dataType: "html",
			beforeSend: function ()
			{
				$("#i18nAddressForm").html(ACC.address.spinner);
			}
		}).done(function (data)
		{
			$("#i18nAddressForm").html($(data).html());
			if($('#address\\.country').val()===""){
				countryCode=$('#addressDefaultCountry').val();
				$('#address\\.country').val(countryCode);
			}
			$('#address\\.country option').removeAttr('disabled');
			if (typeof callback === 'function')
			{
				callback.call();
			}
		});
	},

	bindToChangeAddressButton: function ()
	{
		$(document).on("click", '.summaryDeliveryAddress .editButton', ACC.address.handleChangeAddressButtonClick);
	},

	bindViewAddressBook: function ()
	{
		$(document).on("click",".js-address-book",function(e){
			e.preventDefault();
			var title = $('#addressbookTitle .headline-text').html();
			ACC.colorbox.open("Saved Addresses",{
				href: "#addressbook",
				inline: true,
				width: "380px",
				onComplete: function ()
				{
					$(this).colorbox.resize();
					$('#cboxTitle').insertBefore('#cboxLoadedContent');
	            	$('#cboxClose').insertBefore('#cboxLoadedContent');
	            	$('.headline-text').attr({'aria-label': title,'tabindex': '0','id': 'customTitle'});
	            	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
				}
			});
		});

		$(document).on("click", '#summaryOverlayViewAddressBook', function ()
		{
			$('#summaryDeliveryAddressFormContainer').hide();
			$('#summaryOverlayViewAddressBook').hide();
			$('#summaryDeliveryAddressBook').show();
			ACC.colorbox.resize();
		});
	},
	showRemoveAddressFromBookConfirmation: function ()
	{
		$(document).on("click", ".removeAddressFromBookButton", function ()
		{
			var addressId = $(this).data("addressId");
			var popupTitle = $(this).data("popupTitle");
			ACC.colorbox.open(popupTitle,{
				inline: true,
				height: false,
				fixed: true,
				href: "#popup_confirm_address_removal_" + addressId,
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
	},

	backToListAddresses: function(){
		$(".addressBackBtn").on("click", function(){
			var sUrl = $(this).data("backToAddresses");
			window.location = sUrl;
		});
	},
	usePrimaryAddressShippingContent: function (){
		var usePrimaryAddressValue,countryCode;
		var usePrimaryAddressShipping =true;
		$('#addressId').val("");
		 if ($('#usePrimaryAddressShip').parent("label").hasClass("checked")){
			usePrimaryAddressValue = true;
			countryCode = $('#primaryAddressCountryCode').val();
		}else{
			$('#address\\.country').val("");
			usePrimaryAddressValue = false;
			countryCode = $('#addressDefaultCountry').val();
		}
		var options = {
			'addressCode': '',
			'countryIsoCode': $('#addressDefaultCountry').val(),
			'usePrimaryAddress': usePrimaryAddressValue
		};
		ACC.address.displayCountrySpecificAddressForm(options, ACC.address.showAddressFormButtonPanel(usePrimaryAddressShipping,''),countryCode);
	},

	displayRelationshipUserAddresses: function() {
		$('.relationAddressesLink').on("click", function() {
			ACC.address.bindRelationshipUserAddresses(this);
		});
	},

	bindRelationshipUserAddresses: function(thisObject){
		var loopCount = $(thisObject).first().find('#loopCount').val();
		var customerId = $('#hidden_'+loopCount).val();
		ACC.address.getRelationshipUserAddressesData(
				customerId,loopCount
				);
		$(thisObject).addClass("loadedContent");
	},

	getRelationshipUserAddressesData: function(id, loopCount, callback) {
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/my-account/get-rel-address',
				async: false,
				data: {
					id: id
				},
				dataType: "html",
				beforeSend: function() {
					$('#relationAddressesSection_'+loopCount).html(ACC.address.spinner);
				}
			}).done(function(data) {
			$('#relationAddressesSection_'+loopCount).html(data);
			if (typeof callback === 'function') {
				callback.call();
			}
		});
	},
	bindOnSelectShippingAddress: function(){
		$('#shippingAddressBook').submit(function (evt) {
		    evt.preventDefault();
		    return false;
		});
		$(document).on("click", ".shipping-useThisAddress", function (e){
			e.preventDefault();
			$.colorbox.close();
			$('.addressBook-primary-address .addressEntry ul').html('');
			$('.addressBook-primary-address .addressEntry ul').append($(this).closest('.addressEntry').find('ul').html());
			var addressCode = $(this).closest('.addressEntry').find('input[name="selectedAddressCode"]').val();
			var countryCode = $(this).closest('.addressEntry').find('input[name="selectedCountryCode"]').val();
			$('#addressId').val(addressCode);
			var useThisAddress = true;
			var options = {
					'addressCode': addressCode,
					'countryIsoCode': countryCode
				};
				ACC.address.displayCountrySpecificAddressForm(options, ACC.address.showAddressFormButtonPanel('',useThisAddress), countryCode);
		});
	},
	bindDeleteShippingAddress: function(){
		$(document).on('click', '.removeShippingAddressButton' ,function(){
			$('#countrySelector, #i18nAddressForm, .saveAddress-inMy-AddressBook').show();
			$('.shipping-address-content').hide();
			$('#address\\.country').val($('#addressDefaultCountry').val()).change();
		});
	},
	initOnCheckboxSelect: function(){
		$(document).on('click', '.checkout-shipping-address .checkbox label.control-label', function() {
		   	 var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
		   		if(isCheck === false) {
		   			$(this).find('input[type="checkbox"]').prop('checked', true);
		   		    $(this).parent('.checkbox').attr('aria-checked','true');
		            $(this).addClass('checked');
		   		} else {
		   			$(this).find('input[type="checkbox"]').prop('checked', false);
		   		    $(this).parent('.checkbox').attr('aria-checked','false');
		            $(this).removeClass('checked');
		   		}
		  	});
		$(document).on("keypress", ".checkout-shipping-address .form-group .checkbox", function(e) {
			 if (e.keyCode === 32 || e.keyCode === 0 || e.keyCode === 13) {
				if($(this).find('label').hasClass('usePrimaryAddressShip')){
					    ACC.publicsector.initCheckboxOnKeypress(this);
					    ACC.address.usePrimaryAddressShippingContent();
					    ACC.publicsector.initDefaultCheckbox();
				 }else if($(this).find('label').hasClass('saveAddressInMyAddressBook')){
					   ACC.publicsector.initCheckboxOnKeypress(this);
				 }
			 }
		});
	}
};
