ACC.checkoutsummary = {

	bindDeclarationLink: function() {
		$(document).on("click", ".consentDeclaration a#termsCondition", function(e) {
			e.preventDefault();
			var href = $(this).attr("href");
			$(href).show();
			ACC.colorbox.open("", {
				href: $(this).attr("href"),
				inline: true,
				width: "auto",
				close: '<span class="glyphicon glyphicon-remove"></span>',
				onClosed: function() {
					$(href).hide();
				}
			});
		});
	},
	bindApplicationSummaryApplyNowButton: function(){
		$("#applyButton").click(function() {
		$("#placeOrderForm1").submit();
	});
	}
};

$(function() {
	ACC.checkoutsummary.bindDeclarationLink();
	ACC.checkoutsummary.bindApplicationSummaryApplyNowButton();
});
