ACC.yform = {
	bindAll: function ()
	{
		this.initOnyFormCheckboxRadioClick();
		this.addAriaCheckboxRadioAttribute();
		this.initOnFieldMandatoryAsterisk();
	},
	 initOnyFormCheckboxRadioClick: function () {
     	 $('.orbeon-portlet-body label.checkbox, .orbeon-portlet-body label.radio').parent('.xforms-deselected, .xforms-selected').attr('tabindex','0');
     	 $('.orbeon-portlet-body label.radio').parent().attr('role','radio');
     	 $('.orbeon-portlet-body label.checkbox').parent().attr('role','checkbox');
     	 $('.orbeon-portlet-body label.radio:visible, .orbeon-portlet-body label.checkbox:visible').parent('.xforms-deselected').attr('aria-checked','false');
    	 $('.orbeon-portlet-body label.radio:visible, .orbeon-portlet-body label.checkbox:visible').parent('.xforms-selected').attr('aria-checked','true');
     	$(document).on('click', '.orbeon-portlet-body label.radio, .orbeon-portlet-body label.checkbox' ,function(){
     			ACC.yform.addAriaCheckboxRadioAttribute();
     	});
  	},
  	addAriaCheckboxRadioAttribute: function(){
 		setTimeout(function(){
				 $('.orbeon-portlet-body label.radio:visible, .orbeon-portlet-body label.checkbox:visible').parent('.xforms-deselected').attr('aria-checked','false');
		     	 $('.orbeon-portlet-body label.radio:visible, .orbeon-portlet-body label.checkbox:visible').parent('.xforms-selected').attr('aria-checked','true');
       },1000);
	},
	initOnFieldMandatoryAsterisk: function(){
 		$(".orbeon .xforms-label, .orbeon .fr-grid-content").each(function() {
 		    var html = $(this).html().replace(/\*/g, "<span class=\"required\"></span>");
 		    $(this).html(html);
 		});
 	}
};

$(document).ready(function()
{
	ACC.yform.bindAll();

});