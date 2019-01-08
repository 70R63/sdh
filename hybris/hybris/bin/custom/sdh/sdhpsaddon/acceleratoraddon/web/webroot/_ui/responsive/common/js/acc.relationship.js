ACC.relationship = {

	_autoload: [
	            "bindChangeButton"
	],

	spinner: $("<img src='" + ACC.config.commonResourcePath + "/images/spinner.gif' />"),
	getRelationsWithServiceRequestData: function(options) {
		$.ajax(
			{
				url: ACC.config.encodedContextPath + '/checkout/multi/relations/getRelations/serviceRequestAccess',
				async: true,
				data: options,
				dataType: "html"
			}).done(function(data) {
				ACC.relationship.displayRelationshipPopup(data);
			}).fail(function() {
				window.location.href = ACC.config.encodedContextPath + "/login";
			});
	},
	displayRelationshipPopup: function(data){
		var changeApplicantPopupTitle = $('.relationship-change-user .hide').html();
		var changeApplicantPopupAriaLableTitle = $('.relationship-change-user .hide .headline-text').html();
		$.colorbox({
			html: data,
			title: changeApplicantPopupTitle,
			overlayClose: false,
			maxWidth: "100%",
			opacity: 0.7,
			close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
			onComplete: function() {
				$('#cboxTitle').insertBefore('#cboxLoadedContent');
            	$('#cboxClose').insertBefore('#cboxLoadedContent');
            	$('.headline-text').attr({'aria-label': changeApplicantPopupAriaLableTitle,'tabindex': '0','id': 'customTitle'});
            	$('#cboxClose').attr( {'aria-label': PSACC.textCloseOverlay,'tabindex': '0'});
			}
		});
	},
	bindChangeButton: function(){
		$('.changeUserBtn').click(function(){
			ACC.relationship.getRelationsWithServiceRequestData();
		});
	}
};
