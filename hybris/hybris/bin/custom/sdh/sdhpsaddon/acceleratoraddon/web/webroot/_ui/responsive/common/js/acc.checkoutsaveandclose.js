ACC.checkoutaddon = {

	_autoload: ["bindFormsSave", "bindSaveAndClose"],

	bindFormsSave: function() {

		$(document).on(
				"click",
				"#addressSave",
				function(e) {
					$('#addressForm').attr(
							'action',
							ACC.config.encodedContextPath + "/checkout/multi/delivery-address/save");
					e.preventDefault();
					if (ACC.checkoutaddon.checkModalData()) {
						$('#addressForm').submit();
					}
				});

		$(document).on(
				"click",
				"#deliveryMethodSave",
				function(e) {
					$('#selectDeliveryMethodForm').attr(
							'action',
							ACC.config.encodedContextPath + "/checkout/multi/delivery-method/save");
					e.preventDefault();
					if (ACC.checkoutaddon.checkModalData()) {
						$('#selectDeliveryMethodForm').submit();
					}
				});

		$(document).on(
				"click",
				"#bundleQuestionSave",
				function(e) {
					e.preventDefault();
					if (ACC.checkoutaddon.checkModalData()) {
						window.location.href = ACC.config.encodedContextPath + "/checkout/multi/bundle/save";
					}
				});

		$(document).on(
						"click",
				"#draftPopupBtn, #cboxClose .overlay-close",
						function(e) {
							e.preventDefault();
							var title = $("#saveddrafttitle").html();
							if (typeof title !== 'undefined') {
								var formId = $('.checkout-indent form').attr('id');
								var saveCloseID = $('.js-saveandclose').attr('id');
								if (typeof formId !== 'undefined' && saveCloseID !== "saveYformButton") {
									$('#' + formId).submit();
								} else if (typeof formId !== 'undefined' && saveCloseID === "saveYformButton") {
										window.location.href = ACC.config.encodedContextPath + "/checkout/multi/form/save";
								} else {
									window.location.href = ACC.config.encodedContextPath + "/checkout/multi/bundle/save";
								}
							}
						});
	},
	bindSaveAndClose: function() {
		$(document).on("click", ".js-saveandclose", function(e) {
			e.preventDefault();
			var title = $("#saveddrafttitle").html();
			if (typeof title !== 'undefined') {
				$.colorbox({
					href: "#saveddraftbody",
					inline: true,
					overlayClose: false,
					maxWidth: "100%",
					opacity: 0.7,
					title: title,
					close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
					onComplete: function() {
						$('#cboxTitle').insertBefore('#cboxLoadedContent');
		            	$('#cboxClose').insertBefore('#cboxLoadedContent');
		            	$('.headline-text').attr({'aria-label': $('#cboxTitle .headline-text').html(),'tabindex': '0','id': 'customTitle'});
		            	$('#cboxClose').attr({'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
					}
				});
			}
		});
	},

	checkModalData: function() {
		var title = $("#saveddrafttitle").html();
		if (typeof title === 'undefined') {
			return true;
		}
	}
};

$(document).ready(function() {
	 ACC.checkoutaddon.bindFormsSave();
	 ACC.checkoutaddon.bindSaveAndClose();
});
