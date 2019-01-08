ACC.sdhrelationshipsaddon  = {
		isKeyPress: true,
		initRelationRadioClick: function (thisObj) {
				$(thisObj).parents("form").children('div.radio').attr("aria-checked","false");
				$(thisObj).parent("div").attr("aria-checked","true");
				$(thisObj).parents("form").find(".permissionTypeLabel").removeClass("checked");
				$(thisObj).parents("form").find(".permissionTypeLabel").find( "input[name$='permissionType']").removeAttr('checked');
				$(thisObj).addClass("checked");
				$(thisObj).find( "input[name$='permissionType']").attr('checked','checked');
		},
		bindPermissionRadioSelect: function() {
			$('.setup-permissions label.permissionTypeLabel ').click(function() {
			   ACC.sdhrelationshipsaddon.initRelationRadioClick(this);
			   ACC.sdhrelationshipsaddon.initOnRadioButton();
			   var permissionType =	$(this).find( "input[name$='permissionType']").attr('class');
			       permissionType = permissionType.split('.').join("\\.");
				$('div.permissionType').hide();
				$('div.'+permissionType).show();
				ACC.sdhrelationshipsaddon.bindRadioButtonClick();
			});
		},
		bindRelationHelpMobile: function() {
			$(document).on("click", ".js-permissionHelp-mobile", function() {
				var title = $("#savedPermissionttitle").html();
				var ariaLabelTitle = $("#savedPermissionttitle .headline-text").html();
				if (typeof title !== 'undefined') {
					$.colorbox({
						href: "#savedPermissionbody",
						inline: true,
						overlayClose: false,
						maxWidth: "100%",
						opacity: 0.7,
						title: title,
						close: '<span class="glyphicon glyphicon-remove overlay-close"></span>',
						onComplete: function() {
							$('#cboxTitle').insertBefore('#cboxLoadedContent');
		                	$('#cboxClose').insertBefore('#cboxLoadedContent');
		                	$('.headline-text').attr({'aria-label': ariaLabelTitle, 'tabindex': '0','id': 'customTitle'});
		                	$('#cboxClose').attr({'aria-label': PSRELATION.textCloseOverlay, 'tabindex': '0'});
						}
					});
				}
			});
		},
		bindRequestSameAsGivenPermissionCheckbox: function(){
				$(document).on("checkboxClick", ".checkbox-label.request-permission", function() {
					if(ACC.sdhrelationshipsaddon.isKeyPress){
						 var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
						 if(isCheck===true){
						  ACC.sdhrelationshipsaddon.bindCheckedGivePermissionCheckbox();
						  ACC.sdhrelationshipsaddon.getSourcePermissionSelectedValue();
				    }else{
				    	  ACC.sdhrelationshipsaddon.bindCheckedGivePermissionCheckbox();
					  }
					}
			});
		},
		bindRequestPermissionCheckbox: function(){
			$('.permissionType .sourcePermission label.checkbox-label').click(function(){
				ACC.sdhrelationshipsaddon.initRequestPermissionCheckbox();
			});
		},
		bindGivePermissionCheckbox: function(){
			$('.permissionType .targetPermission label.checkbox-label').click(function(e){
				if(e.which) {
					ACC.sdhrelationshipsaddon.initRequestPermissionCheckbox();
			   }
			});
		},
		bindCheckedGivePermissionCheckbox: function(){
				$('.targetPermission').find( "input[name$='targetPermissibleItemTypes']").parent('label.checked').each(function(){
		    		 var selectedValue=$(this).find("input[name$='targetPermissibleItemTypes']").attr('value');
				        $("input[name$='targetPermissibleItemTypes'][value='"+selectedValue+"']").parent('label').click();
		    	 });
		},
		bindRadioButtonClick: function(){
			$('.checkbox-label').find('input[type="checkbox"]').parent('label.checked').each(function(){
				 var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
	        		if(isCheck === true) {
	        			$(this).find('input[type="checkbox"]').prop('checked', false);
	        		    $(this).parent('.checkbox').attr( 'aria-checked','false');
	                    $(this).removeClass('checked');
	        		}
			 });
		},
		initRequestPermissionCheckbox: function(){
			 var isCheck = $('.checkbox-label.request-permission').find('input[type="checkbox"]').prop('checked');
			 if(isCheck===true){
				 $('.checkbox-label.request-permission').find('input[type="checkbox"]').prop('checked', false);
				 $('.checkbox-label.request-permission').removeClass('checked');
			 }
		},
		getSourcePermissionSelectedValue: function(){
			$('.sourcePermission').find( "input[name$='sourcePermissibleItemTypes']").parent('label.checked').each(function(){
	              var selectedValue=$(this).find("input[name$='sourcePermissibleItemTypes']").attr('value');
	              $("input[name$='targetPermissibleItemTypes'][value='"+selectedValue+"']").prop('checked',true);
	              $("input[name$='targetPermissibleItemTypes'][value='"+selectedValue+"']").parent('label').addClass('checked');
		    });
		},
		initHelpMobile: function() {
			$(document).on("keypress", ".js-permissionHelp-mobile", function(e) {
				 if (e.keyCode === 32 || e.keyCode === 0) {
					   $('.js-permissionHelp-mobile').trigger("click");
				     }
			});
		},
		initOnPermissionCheckboxRadioClick: function() {
			$(document).on("keypress", ".setup-permissions .radio", function(e) {
				 if (e.keyCode === 32 || e.keyCode === 0) {
					   $(this).find('label.permissionTypeLabel').trigger("click");
				     }
			});
			$(document).on("keypress", ".permissionType .targetPermission .checkbox", function(e) {
				 if (e.keyCode === 32 || e.keyCode === 0) {
					   ACC.sdhrelationshipsaddon.isKeyPress=true;
					   ACC.sdhrelationshipsaddon.initRequestPermissionCheckbox();
					   $(this).find('label.checkbox-label').trigger("click");
				     }
			});
			$(document).on("keypress", ".permissionType .sourcePermission .checkbox", function(e) {
				 if (e.keyCode === 32 || e.keyCode === 0) {
					   ACC.sdhrelationshipsaddon.isKeyPress=true;
					   $(this).find('label.checkbox-label').trigger("click");
				     }
			});
			$(document).on("keypress.relationship", ".permissionType .requestPermission .checkbox", function(e) {
				 if (e.keyCode === 32 || e.keyCode === 0) {
						ACC.sdhrelationshipsaddon.isKeyPress=false;
					 var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
					 if(isCheck===false){
						 ACC.sdhrelationshipsaddon.bindCheckedGivePermissionCheckbox();
						 ACC.sdhrelationshipsaddon.getSourcePermissionSelectedValue();
						 $('.checkbox-label.request-permission').find('input[type="checkbox"]').prop('checked', true);
						 $('.checkbox-label.request-permission').addClass('checked');
				     }else{
				    	 ACC.sdhrelationshipsaddon.bindCheckedGivePermissionCheckbox();
				     }
				 }
			});
		},
		initOnAccordian: function(){
			$(document).on("click", ".accordion-toggle", function (){
				  if($(this).attr('aria-expanded')==="true"){
				      $(this).attr({'aria-expanded': 'false'});
				  }else if($(this).attr('aria-expanded')==="false"){
				      $(this).attr({'aria-expanded': 'true'});
				  }
				  ACC.sdhrelationshipsaddon.bindManageDetailsAccordian(this);
				});
		},
		bindManageDetailsAccordian: function(thisObject){
			 $('#accordion .accordion-toggle').not(thisObject).each(function(){
			     $(this).attr({'aria-expanded': 'false'});
			  });
		},
		initOnRadioButton: function(){
			$('#permissionForm').each(function(){
				  if($('#permissionForm').find("input[name*='permissionType']").is(':checked')){
				    $('.radioButton-text').hide();
				  }
			 });
		}
		};

$(document).ready(function() {
	ACC.sdhrelationshipsaddon.bindPermissionRadioSelect();
	ACC.sdhrelationshipsaddon.bindRelationHelpMobile();
	ACC.sdhrelationshipsaddon.initHelpMobile();
	ACC.sdhrelationshipsaddon.bindRequestSameAsGivenPermissionCheckbox();
	ACC.sdhrelationshipsaddon.bindRequestPermissionCheckbox();
	ACC.sdhrelationshipsaddon.bindGivePermissionCheckbox();
	ACC.sdhrelationshipsaddon.bindCheckedGivePermissionCheckbox();
	ACC.sdhrelationshipsaddon.initOnPermissionCheckboxRadioClick();
	ACC.sdhrelationshipsaddon.initOnAccordian();
	ACC.sdhrelationshipsaddon.initOnRadioButton();
});
