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

/**
 * To get control value :
 * var firstName = $('input[id*="first-name-1-control"]').val();
 *
 * To set control value :
 * var addressLine1Control = $('input[id*="primary-address-line1-control"]')[0];
 * ORBEON.xforms.Document.setValue(addressLine1Control, "Address Line1");
 *
 * To make control readonly :
 * ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine1Control, true);
 */

var $ = ORBEON.jQuery;

var isAddressBookAvailable = false;
var addressCountySelectControl = $('span[id $= "primary-address-country-control"]').find('.xforms-select1')[0];
var addressLine1Control = $('*[id $= "primary-address-line1-control"]')[0];
var addressLine2Control = $('*[id $= "primary-address-line2-control"]')[0];
var addressCityControl = $('*[id $= "primary-address-city-control"]')[0];
var addressPostCodeControl = $('*[id $= "primary-address-post-code-control"]')[0];
var addressePhoneControl = $('*[id $= "primary-address-phone-number-control"]')[0];
var addressHTMLHiddenControl = $('*[id $= "primary-address-html-hidden-control"]')[0];
var addressBookSelectedControl = $('*[id $="is-address-book-selected-control"]')[0];
var primaryAddressBookValue = $('*[id $= "primary-address-is-anonymous-user"]')[0];
var defaultCountry = $('#defaultCountry').val();
var sampleAddressHTML;

$(document).on('click', 'span[id$="user-address-book-control"]', function() {
	if(!isAddressBookAvailable)
	{
		var url = ACC.config.encodedContextPath + "/checkout/multi/form/getAddressBook";
		var options = {
			url: url,
			type: 'GET',
			success: function (data)
			{
				sampleAddressHTML=data;
				isAddressBookAvailable=true;
				ACC.colorbox.open("Address Book",{
			        html: sampleAddressHTML,
			        width: '350',
			        height: '350',
			        onClosed: function() {
			        }
			    });
			}
		};
		$.ajax(options);
	}else{
		ACC.colorbox.open("Address Book",{
	        html: sampleAddressHTML,
	        width: '350',
	        height: '350',
	        onClosed: function() {
	        }
	    });
	}
});

function updateFormValues(values) {
	
	ORBEON.xforms.Events.focus({explicitOriginalTarget: addressCountySelectControl});
	ORBEON.xforms.Document.setValue($(addressCountySelectControl).attr('id'), values[0]);
	ORBEON.xforms.Document.setValue($('span[id $= "primary-address-country-control"]').find('.xforms-select1')[0], values[0]);
	ORBEON.xforms.Events.blur({explicitOriginalTarget: addressCountySelectControl});
	ORBEON.xforms.Events.change({explicitOriginalTarget: addressCountySelectControl});
	
	ORBEON.xforms.Events.focus({explicitOriginalTarget: addressLine1Control});
	ORBEON.xforms.Document.setValue($(addressLine1Control).attr('id'), values[1]);
	ORBEON.xforms.Document.setValue($('*[id $= "primary-address-line1-control"]')[0], values[1]);
	ORBEON.xforms.Events.blur({explicitOriginalTarget: addressLine1Control});
	ORBEON.xforms.Events.change({explicitOriginalTarget: addressLine1Control});

	ORBEON.xforms.Events.focus({explicitOriginalTarget: addressPostCodeControl});
	ORBEON.xforms.Document.setValue($(addressPostCodeControl).attr('id'), values[2]);
	ORBEON.xforms.Document.setValue($('*[id $= "primary-address-post-code-control"]')[0],values[2]);
	ORBEON.xforms.Events.blur({explicitOriginalTarget: addressPostCodeControl});
	ORBEON.xforms.Events.change({explicitOriginalTarget: addressPostCodeControl});
	
	ORBEON.xforms.Events.focus({explicitOriginalTarget: addressLine2Control});
	ORBEON.xforms.Document.setValue($(addressLine2Control).attr('id'), values[3] );
	ORBEON.xforms.Document.setValue($('*[id $= "primary-address-line2-control"]')[0],values[3]);
	ORBEON.xforms.Events.blur({explicitOriginalTarget: addressLine2Control});
	ORBEON.xforms.Events.change({explicitOriginalTarget: addressLine2Control});

	ORBEON.xforms.Events.focus({explicitOriginalTarget: addressCityControl});
	ORBEON.xforms.Document.setValue($(addressCityControl).attr('id'), values[4]);
	ORBEON.xforms.Document.setValue($('*[id $= "primary-address-city-control"]')[0], values[4]);
	ORBEON.xforms.Events.blur({explicitOriginalTarget: addressCityControl});
	ORBEON.xforms.Events.change({explicitOriginalTarget: addressCityControl});
	
	ORBEON.xforms.Events.focus({explicitOriginalTarget: addressePhoneControl});
	ORBEON.xforms.Document.setValue($(addressePhoneControl).attr('id'), values[5]);
	ORBEON.xforms.Document.setValue($('*[id $= "primary-address-phone-number-control"]')[0], values[5]);
	ORBEON.xforms.Events.blur({explicitOriginalTarget: addressePhoneControl});
	ORBEON.xforms.Events.change({explicitOriginalTarget: addressePhoneControl});
}

$(document).on('click','.btn-yform-address',function(){
	var selectedAddress=$(this);
	var addressData=[selectedAddress.data('countryisocode'),selectedAddress.data('addressline1'),selectedAddress.data('addresspostalcode'),selectedAddress.data('addressline2'),selectedAddress.data('addresscity'),selectedAddress.data('phone')]
	updateFormValues(addressData);
	$('.address-field').parents('div.fr-grid-tr').addClass('hide-disabled-tr').removeClass('fr-grid-tr-visible');
	$('.address-output-field').parents('div.fr-grid-tr').removeClass('hide-disabled-tr').addClass('fr-grid-tr-visible');
	ACC.colorbox.close();
});

/* On click of Use Primary Address checkbox */
$(document).on('click', 'input[id*="use-primary-address-control"]', function() {
	if (this.checked) {
		var url = ACC.config.encodedContextPath + "/checkout/multi/form/usePrimaryAddress";
		var options = {
			url: url,
			type: 'GET',
			success: function (data)
			{
				if(data.result.isPrimaryAddressAvailable){
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine1Control, false);
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine2Control, false);
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressCityControl, false);
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressPostCodeControl, false);
					var selectedAddress=data.result.addressData;
					var address=[selectedAddress.country,selectedAddress.addressline1,selectedAddress.postalCode,selectedAddress.addressline2,selectedAddress.town,selectedAddress.phone]
					updateFormValues(address);
					$('.address-field').parents('div.fr-grid-tr').addClass('hide-disabled-tr').removeClass('fr-grid-tr-visible');
					$('.address-output-field').parents('div.fr-grid-tr').removeClass('hide-disabled-tr').addClass('fr-grid-tr-visible');
				}
			}
		};
		$.ajax(options);
	} else {
		$('.address-field').parents('div.fr-grid-tr').addClass('fr-grid-tr-visible').removeClass('hide-disabled-tr');
		ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine1Control, false);
		ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine2Control, false);
		ORBEON.xforms.Controls.setDisabledOnFormElement(addressCityControl, false);
		ORBEON.xforms.Controls.setDisabledOnFormElement(addressPostCodeControl, false);
		var address=[defaultCountry,"","","","",""];
		updateFormValues(address);
		$('.clear-button').click();
		$('.fr-grid div.fr-grid-tr').removeClass('hide-disabled-tr').addClass('fr-grid-tr-visible');
		$('.fr-grid .fr-grid-content div.xforms-readonly').parent('div.fr-grid-content').parent('div.fr-grid-td').parent('div.fr-grid-tr').addClass('hide-disabled-tr');
		$('.xforms-disabled').parent('div,span').parent('div.fr-grid-td').parent('div.fr-grid-tr').addClass('hide-disabled-tr');
		$('button[id*="user-address-book-control"]').parents('div.fr-grid-tr').removeClass('hide-disabled-tr');
		$('.address-output-field').parents('div.fr-grid-tr').removeClass('fr-grid-tr-visible').addClass('hide-disabled-tr');
	}
});

$(document).on('click', '.delete-address-button .glyphicon-remove', function() {
	$('.delete-address-button').hide();
	$('.address-field').parents('div.fr-grid-tr').removeClass('hide-disabled-tr');
	ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine1Control, false);
	ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine2Control, false);
	ORBEON.xforms.Controls.setDisabledOnFormElement(addressCityControl, false);
	ORBEON.xforms.Controls.setDisabledOnFormElement(addressPostCodeControl, false);
	var address=[defaultCountry,"","","","",""];
	updateFormValues(address);
	$('.clear-button').click();
	$('.address-field').parents('div.fr-grid-tr').addClass('fr-grid-tr-visible').removeClass('hide-disabled-tr');
	$('.address-output-field').parents('div.fr-grid-tr').addClass('hide-disabled-tr').removeClass('fr-grid-tr-visible');
});

ORBEON.xforms.Events.orbeonLoadedEvent.subscribe(function(eventName, eventData) {
	$('.hide-field').parents('div.fr-grid-tr').hide();
	if( $('.checkout-steps, .content-space').find('.card-section').hasClass('card-review-section-nospace') && $('span[id*="use-primary-address-control"]').find('span.xforms-selected, span.xforms-deselected').attr('aria-checked')==='true'){
		$('.fr-grid .fr-grid-content span.xforms-disabled, .fr-grid-content span.address-field').parent('div.fr-grid-content').parent('div.fr-grid-td').parent('div.fr-grid-tr').addClass('hide-disabled-tr');
		$('.address-output-field').addClass('address-output-field-blank');
		$('.address-output-field-blank').find('.address-card').addClass('address-card-static');
	}else if($('span[id*="use-primary-address-control"]').find('span.xforms-selected, span.xforms-deselected').attr('aria-checked')==="false" || $('input[id*="use-primary-address-control"]').length===0){
		$('#primaryAddressData').parent('div.xforms-output-output').parents('div.fr-grid-content').parent('div.fr-grid-td').parent('div.fr-grid-tr').addClass('hide-disabled-tr');
	}

   if($('input[id*="use-primary-address-control"]').length && $('input[id*="use-primary-address-control"]').attr('checked')){
	   var url = ACC.config.encodedContextPath + "/checkout/multi/form/usePrimaryAddress";
	   var options = {
			url: url,
			type: 'GET',
			success: function (data)
			{
				if(data.result.isPrimaryAddressAvailable){
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine1Control, false);
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressLine2Control, false);
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressCityControl, false);
					ORBEON.xforms.Controls.setDisabledOnFormElement(addressPostCodeControl, false);
					var selectedAddress=data.result.addressData;
					var address=[selectedAddress.country,selectedAddress.addressline1,selectedAddress.postalCode,selectedAddress.addressline2,selectedAddress.town,selectedAddress.phone]
					updateFormValues(address);
					$('.address-output-field').parents('div.fr-grid-tr').removeClass('hide-disabled-tr').addClass('fr-grid-tr-visible');
				}
			}
		};
		$.ajax(options);
		$('.address-field').parents('div.fr-grid-tr').addClass('hide-disabled-tr').removeClass('fr-grid-tr-visible');
		$('.address-output-field').parents('div.fr-grid-tr').addClass('fr-grid-tr-visible').removeClass('hide-disabled-tr');
		$('.fr-grid .fr-grid-content span.xforms-disabled, .fr-grid-content span.address-field').parent('div.fr-grid-content').parent('div.fr-grid-td').parent('div.fr-grid-tr').addClass('hide-disabled-tr');
		$('.fr-grid .fr-grid-content div.xforms-readonly').parents('tr').removeClass('hide-disabled-tr');
   } else {
	   var countrySelectControlId = $(addressCountySelectControl).find('select').attr("id");
	   if(countrySelectControlId !== undefined && ORBEON.xforms.Document.getValue(addressCountySelectControl) === "") {
			ORBEON.xforms.Events.focus({explicitOriginalTarget: addressCountySelectControl});
			ORBEON.xforms.Document.setValue($(addressCountySelectControl).attr('id'), defaultCountry);
			ORBEON.xforms.Document.setValue($('span[id $= "primary-address-country-control"]').find('.xforms-select1')[0], defaultCountry);
			ORBEON.xforms.Events.blur({explicitOriginalTarget: addressCountySelectControl});
			ORBEON.xforms.Events.change({explicitOriginalTarget: addressCountySelectControl});

			$('.address-field').parents('div.fr-grid-tr').addClass('fr-grid-tr-visible').removeClass('hide-disabled-tr');
			$('.address-output-field').parents('div.fr-grid-tr').hide();
		    $('.fr-grid').removeClass('hide-disabled-tr');
		    $('.fr-grid .fr-grid-content div.xforms-readonly').parent('div.fr-grid-content').parent('div.fr-grid-td').parent('div.fr-grid-tr').addClass('hide-disabled-tr');
   		}
   }
});

