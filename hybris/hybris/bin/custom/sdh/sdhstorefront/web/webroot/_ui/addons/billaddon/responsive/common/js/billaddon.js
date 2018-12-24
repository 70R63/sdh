ACC.billaddon  = {

	bindBillHelpMobile: function() {
		$(document).on("click", ".js-billHelp-mobile", function() {
			var title = $("#savedbillttitle").html();
			var ariaLabelTitle = $("#savedbillttitle .headline-text").html();
			if (typeof title !== 'undefined') {
				$.colorbox({
					href: "#savedbillbody",
					inline: true,
					overlayClose: false,
					maxWidth: "100%",
					opacity: 0.7,
					title: title,
					close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
					onComplete: function() {
						$('#cboxTitle').insertBefore('#cboxLoadedContent');
	                	$('#cboxClose').insertBefore('#cboxLoadedContent');
	                	$('.headline-text').attr({'aria-label': ariaLabelTitle,'tabindex': '0','id': 'customTitle'});
	                	$('#cboxClose').attr({'aria-label': PSBILL.textCloseOverlay,'tabindex': '0'});
					}
				});
			}
		});
	},
	initHelpMobile: function() {
		$(document).on("keypress", ".js-billHelp-mobile", function(e) {
			 if (e.keyCode === 32 || e.keyCode === 0) {
				   $('.js-billHelp-mobile').trigger("click");
			     }
		});
	}
};

$(document).ready(function() {
	 ACC.billaddon.bindBillHelpMobile();
	 ACC.billaddon.initHelpMobile();
});
