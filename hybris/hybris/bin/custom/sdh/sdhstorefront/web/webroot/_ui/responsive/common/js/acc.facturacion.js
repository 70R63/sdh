ACC.facturacion = {

	_autoload : ["bindBuscar"],

	
	bindBuscar : function(){
		$(document).on("click", ".facBuscar", function(){
			
			debugger;
			var imp = document.getElementById('impuesto').value;
			var tabpred = document.getElementById('table-predial');
			var tabveh = document.getElementById('table-vehiculos');
			var buscar = document.getElementById('aniograv').value;
			

			if (imp == '01') {
				
				$("#tabPaginacion0 tr").find('td:eq(0)').each(function () {
					 
					
					  valor = $(this).html();
					  if(valor == buscar){
						  $("#tabPaginacion0 tr").show();
						  
					  }else{
					
						  $("#tabPaginacion0 tr").hide();
					  }
					})
					 
				
				tabpred.style.display = 'block';
				tabveh.style.display = 'none';


		        
			} else if (imp == '02') {
				$("#tabPaginacion1 tr").find('td:eq(0)').each(function () {
					 
					  valor = $(this).html();
					  if(valor == buscar && valor != " "){
						  $("#tabPaginacion1 tr").show();
						  
					  }else{
					
						  $("#tabPaginacion1 tr").hide();
					  }
					})
				tabpred.style.display = 'none';
				tabveh.style.display = 'block';
			} else {
				tabpred.style.display = 'none';
				tabveh.style.display = 'none';
			}

			
		});
	}
	
};