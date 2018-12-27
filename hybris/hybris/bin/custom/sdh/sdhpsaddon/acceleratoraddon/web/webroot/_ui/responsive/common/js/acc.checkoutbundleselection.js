ACC.checkoutbundleselection = {
	bindAll: function ()
	{
		this.initPageEvents();
		this.initOnRadioClick();
	},
	addServiceAddonToCart: function (self, productCode, bundleId)
	{
		var url = ACC.config.encodedContextPath + "/checkout/multi/bundle/addEntry";
		var formData = {
			productCodePost: productCode,
			quantity: 1,
			bundleId: bundleId
		};
		$.ajax({
			url: url,
			type: "POST",
			data: formData,
			dataType: "html",
			success: function(data) {
				$(self).parents(".bundleTemplateDiv").nextAll().remove();
				$("div#bundleTemplatesDiv").append($.parseHTML(data));
				ACC.checkoutbundleselection.getApplicationSummary();
			}
		});
	},
	getApplicationSummary: function ()
	{
		var url = ACC.config.encodedContextPath + "/checkout/multi/bundle/applicationSummary";
		$.ajax({
			url: url,
			type: "GET",
			dataType: "html",
			success: function(data) {
				$("div.checkout-order-summary").html($.parseHTML(data));
			}
		});
	},
	initPageEvents: function () {
		$(document).on('click', "label.bundleTemplateLabel input:radio[name=bundleOption]", function () {
			$(this).parents("form").children('div.radio').attr("aria-checked","false");
			$(this).parent("label").parent("div").attr("aria-checked","true");
			$(this).parents("form").find(".bundleTemplateLabel").removeClass("checked");
			$(this).parent("label").addClass("checked");
			var productCode = $(this).val();
			var bundleId = $(this).parents('.bundleTemplateDiv').data('bundleid');
			ACC.checkoutbundleselection.addServiceAddonToCart(this, productCode, bundleId);
		});
	},
	initOnRadioClick: function () {
		 $('div.bundleRadio').keypress(function(e) {
			 if (e.keyCode === 32 || e.keyCode === 0) {
				 $(this).find("label.bundleTemplateLabel input:radio[name=bundleOption]").trigger( "click" );
			 }
		});
	}
};
$(document).ready(function ()
{
	ACC.checkoutbundleselection.bindAll();
});