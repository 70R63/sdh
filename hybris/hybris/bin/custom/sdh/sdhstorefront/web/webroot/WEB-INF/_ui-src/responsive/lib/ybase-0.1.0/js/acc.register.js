ACC.register = {

	_autoload: [
		"bindCalendar","bindDocumentType"
	],

	bindCalendar: function(){
		$("#expeditionDate").datepicker({
		      changeMonth: true,
		      changeYear: true,
		      yearRange: "-200:+0",
		    });
		
		$("#expeditionDate").datepicker( $.datepicker.regional[ "es" ] );
	},
	
	bindDocumentType: function(){
		$("#documentType").on("change",function(){
			
			if($(this).val() == "CC")
			{
				$("#expeditionDate").val("");
				$("#expeditionDateDiv").show();
			}else
			{
				$("#expeditionDate").val("");
				$("#expeditionDateDiv").hide();
			}
			
			
		});
	}



};