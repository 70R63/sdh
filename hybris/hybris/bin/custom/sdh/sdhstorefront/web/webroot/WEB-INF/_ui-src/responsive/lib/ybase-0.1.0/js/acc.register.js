ACC.register = {

	_autoload: [
		"bindCalendar"
	],

	bindCalendar: function(){
		$("#expeditionDate").datepicker({
		      changeMonth: true,
		      changeYear: true,
		      yearRange: "-200:+0",
		    });
		
		$("#expeditionDate").datepicker( $.datepicker.regional[ "es" ] );
	}

};