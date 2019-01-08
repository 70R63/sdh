ACC.publicsectorForm = {
	$continueBtn: $('#continueBtn'),
	bindAll: function() {
		this.triggerSave();
		this.bindProgressBarButtons();
	    window.setInterval(ACC.publicsectorForm.lookForClassNames(), 100);
		this.changeContinueBtnHref();
	},

	triggerSave: function() {
		var isMobile= {
		    Android: function() {
		        return navigator.userAgent.match(/Android/i);
		    },
		    BlackBerry: function() {
		        return navigator.userAgent.match(/BlackBerry/i);
		    },
		    iOS: function() {
		        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
		    },
		    Opera: function() {
		        return navigator.userAgent.match(/Opera Mini/i);
		    },
		    Windows: function() {
		        return navigator.userAgent.match(/IEMobile/i);
		    },
		    any: function() {
		        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
		    }
	    };
		$("#placeOrderBtn").on('click', function() {
			$('.fr-save-final-button button').trigger('click').trigger('click');
			return false;
		});
		this.$continueBtn.on('click', function() {
			if(isMobile.any()) {
				$('.fr-save-final-button button').trigger('click').trigger('click');
				return false;
			}else{
				$('.fr-save-final-button button').trigger('click');
				return false;
			}
		});
		$("#saveYformButton").on('click', function() {
			if(isMobile.any()) {
				$('.fr-save-draft-button button').trigger('click').trigger('click');
				return false;
			}else{
				$('.fr-save-draft-button button').trigger('click');
				return false;
			}
		});
		var popUpButtonId = $('.xbl-fr-alert-dialog').find('.btn-primary').attr('id');
		$('#' + popUpButtonId).on('click', function() {
			if(isMobile.any()) {
				if($('.xbl-fr-alert-dialog').is(':visible')){
					$(this).parent('.xforms-trigger-appearance-full').trigger('click').trigger('click');
				}
			}
		});
	},
	bindProgressBarButtons: function() {
		var $checkoutProgressLinks = $('#checkoutProgress li.disabled').find('a');
		if (this.$continueBtn.length > 0) {
			$checkoutProgressLinks.each(function() {
				if ($(this).prop('href') !== "") {
					$(this).on('click', function() {
						$('.fr-save-final-button button').trigger('click');
						return false;
					});
				}
			});
		}
	},
	lookForClassNames: function() {
		var forms = document.getElementsByTagName("form");
		var i;
		for (i = 0; i < forms.length; i++) {
			if (forms[i].className.indexOf("xforms-help-appearance-dialog") > -1) {
				var divs = forms[i].getElementsByTagName("div");
				ACC.publicsectorForm.lookForClassNamesForyuiDialog(divs);
			}
		}
	},
	lookForClassNamesForyuiDialog: function(divs){
		var j;
		for (j = 0; j < divs.length; j++) {
			if (divs[j].className.indexOf("yui-dialog") > -1) {
				var labels = divs[j].getElementsByTagName("label");
				ACC.publicsectorForm.lookForClassNamesForErrorMessages(labels);
			}
		}
	},
	lookForClassNamesForErrorMessages: function(labels){
		var k;
		for (k = 0; k < labels.length; k++) {
			if (labels[k].innerHTML.indexOf("errorMessage") > -1) {
				var labelHTML = labels[k].innerHTML.replace(
						/&gt;/gi, ">");
				labels[k].innerHTML = labelHTML.replace(
						/&lt;/gi, "<");
			}
		}
	},
	changeContinueBtnHref: function() {
		$(".pageType-CategoryPage #checkoutProgress a").on(
				'click',
				function() {
					ACC.insuranceform.$continueBtn.attr('href', $(this).attr(
							'href'));
				});
	}
};
$(document).ready(function() {
	ACC.publicsectorForm.bindAll();
});

/**
 * This function will get called from properties-publicsector.xml from Orbeon.
 * @return {undefined}
 */
function formPageNextPage() {
	window.location = ACC.publicsectorForm.$continueBtn.attr('href');
}

/**
 * This function will get called from properties-publicsector.xml from Orbeon.
 * @return {undefined}
 */
function formMoveToDraftConfirmation() {
	var title = $("#saveddrafttitle").html();
	if (typeof title === 'undefined') {
		window.location.href = ACC.config.encodedContextPath + "/checkout/multi/form/save";
	} else {
		$.colorbox({
			href: "#saveddraftbody",
			inline: true,
			overlayClose: false,
			maxWidth: "100%",
			opacity: 0.7,
			title: title,
			close: '<span class="glyphicon glyphicon-remove"></span>',
			onComplete: function() {
			}
		});
	}
}

/**
 * This function will get called from form-report-graffiti.xml and form-report-pothole.xml from Orbeon.
 * @return {undefined}
 */
function submitPlaceOrderForm() {
	if ($('legend.fr-error-title').html().length === 0) {
		$("#placeOrderForm1").submit();
	}
}
