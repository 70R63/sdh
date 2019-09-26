ACC.predial = {

	_autoload : [ "bindoptionNo","bindprophorizontal", "binbuttonPrecalculo" ],

	bindoptionNo : function() {
		$(document).on("click", ".optradio", function() {
			var valo = this.value;
			var pro = document.getElementById('proyecto');
			
			if (valo == '2') {
				pro.style.display = 'none';
			} else if (valo == '1') {
				pro.style.display = 'block';
			}

		});
	},
	
	bindprophorizontal : function() {
		$(document).on("change", ".prophorizontal", function(e) {
			e.preventDefault();
			var val = this.value;
			
			if(val == 'Si'){
				$('#areaconstruccion').prop('disabled',false);;
				$('#areaterreno').prop('disabled',true);;
			}else if(val == 'No'){
				$('#areaconstruccion').prop('disabled',false);;
				$('#areaterreno').prop('disabled',false);;
			}else{
				$('#areaconstruccion').prop('disabled',true);;
				$('#areaterreno').prop('disabled',true);;
			}

		});
	},
	
	binbuttonPrecalculo : function() {
		$(document).on("click", ".buttonPrecalculo", function(e) {
			e.preventDefault();
			var base = document.getElementById('BasesDetalle');
			base.style.display = 'block';

		});
	}
	
};