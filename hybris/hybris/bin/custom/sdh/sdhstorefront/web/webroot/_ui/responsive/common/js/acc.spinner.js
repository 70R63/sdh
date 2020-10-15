ACC.spinner = {

	_autoload: [],

	spinner: $("<img src='" + ACC.config.commonResourcePath + "/images/3dots.gif' />"),


	show: function() {
		debugger;
		var spinnerdiv = document.getElementById('cargandoSpinner');
		$("#cargandoSpinner").html(ACC.spinner.spinner);
		spinnerdiv.style.display = 'block';
	},

	close: function() {
		var spinnerdiv = document.getElementById('cargandoSpinner');
		$("#cargandoSpinner").html();
		spinnerdiv.style.display = 'none';
	}
};