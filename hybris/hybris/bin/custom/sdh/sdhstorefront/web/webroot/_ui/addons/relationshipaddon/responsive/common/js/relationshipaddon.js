ACC.relationshipaddon  = {
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
			   ACC.relationshipaddon.initRelationRadioClick(this);
			   ACC.relationshipaddon.initOnRadioButton();
			   var permissionType =	$(this).find( "input[name$='permissionType']").attr('class');
			       permissionType = permissionType.split('.').join("\\.");
				$('div.permissionType').hide();
				$('div.'+permissionType).show();
				ACC.relationshipaddon.bindRadioButtonClick();
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
					if(ACC.relationshipaddon.isKeyPress){
						 var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
						 if(isCheck===true){
						  ACC.relationshipaddon.bindCheckedGivePermissionCheckbox();
						  ACC.relationshipaddon.getSourcePermissionSelectedValue();
				    }else{
				    	  ACC.relationshipaddon.bindCheckedGivePermissionCheckbox();
					  }
					}
			});
		},
		bindRequestPermissionCheckbox: function(){
			$('.permissionType .sourcePermission label.checkbox-label').click(function(){
				ACC.relationshipaddon.initRequestPermissionCheckbox();
			});
		},
		bindGivePermissionCheckbox: function(){
			$('.permissionType .targetPermission label.checkbox-label').click(function(e){
				if(e.which) {
					ACC.relationshipaddon.initRequestPermissionCheckbox();
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
					   ACC.relationshipaddon.isKeyPress=true;
					   ACC.relationshipaddon.initRequestPermissionCheckbox();
					   $(this).find('label.checkbox-label').trigger("click");
				     }
			});
			$(document).on("keypress", ".permissionType .sourcePermission .checkbox", function(e) {
				 if (e.keyCode === 32 || e.keyCode === 0) {
					   ACC.relationshipaddon.isKeyPress=true;
					   $(this).find('label.checkbox-label').trigger("click");
				     }
			});
			$(document).on("keypress.relationship", ".permissionType .requestPermission .checkbox", function(e) {
				 if (e.keyCode === 32 || e.keyCode === 0) {
						ACC.relationshipaddon.isKeyPress=false;
					 var isCheck = $(this).find('input[type="checkbox"]').prop('checked');
					 if(isCheck===false){
						 ACC.relationshipaddon.bindCheckedGivePermissionCheckbox();
						 ACC.relationshipaddon.getSourcePermissionSelectedValue();
						 $('.checkbox-label.request-permission').find('input[type="checkbox"]').prop('checked', true);
						 $('.checkbox-label.request-permission').addClass('checked');
				     }else{
				    	 ACC.relationshipaddon.bindCheckedGivePermissionCheckbox();
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
				  ACC.relationshipaddon.bindManageDetailsAccordian(this);
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
	ACC.relationshipaddon.bindPermissionRadioSelect();
	ACC.relationshipaddon.bindRelationHelpMobile();
	ACC.relationshipaddon.initHelpMobile();
	ACC.relationshipaddon.bindRequestSameAsGivenPermissionCheckbox();
	ACC.relationshipaddon.bindRequestPermissionCheckbox();
	ACC.relationshipaddon.bindGivePermissionCheckbox();
	ACC.relationshipaddon.bindCheckedGivePermissionCheckbox();
	ACC.relationshipaddon.initOnPermissionCheckboxRadioClick();
	ACC.relationshipaddon.initOnAccordian();
	ACC.relationshipaddon.initOnRadioButton();
});
