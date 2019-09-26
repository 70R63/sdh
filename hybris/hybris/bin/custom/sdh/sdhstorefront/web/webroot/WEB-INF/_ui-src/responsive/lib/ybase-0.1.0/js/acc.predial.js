ACC.predial = {

	_autoload : [ "bindoptionNo" ],

	bindoptionNo : function() {
		$(document).on("click", ".optradio", function(e) {
			e.preventDefault();
			debugger;

			var pro = document.getElementById('proyecto');
			if ($('#optionNo').prop('checked')) {
				pro.style.display = 'none';
			} else if ($('#optionSi').prop('checked')) {
				pro.style.display = 'block';
			}

		});
	}
};