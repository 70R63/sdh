<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="publicidadExterior"
	tagdir="/WEB-INF/tags/responsive/publicidadExterior"%>

<style>
#divAvisos { }
#divConvencional { }
#divVehiculos { }
#divTubular { }
</style>

<template:page>


	<div class="container">
	
	<publicidadExterior:publicidadExteriorTable />
		<publicidadExterior:publicidadExteriorDetail />
		<publicidadExterior:publicidadExteriorAvisos />
		<publicidadExterior:publicidadExteriorConvencional />
		<publicidadExterior:publicidadExteriorVehiculos />
		<publicidadExterior:publicidadExteriorTubular />
		

	</div>
	
</template:page>

<script type="text/javascript">
	document.onreadystatechange = function() {
		if (document.readyState == "complete") {
			datatable();
		}
	}

	function datatable(e) {
		if ($.fn.dataTable.isDataTable('#example')) {
			table = $('#example').DataTable();
			table.destroy();
		}
		var tabla = $("#example")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : "Anterior",

									"sNext" : "Siguiente",
									"sLast" : "Ultima",
									"sFirst" : "Primera"
								},
								"sLengthMenu" : 'Mostrando <select>'
										+ '<option value="5">5</option>'
										+ '<option value="10">10</option>'
										+ '<option value="15">15</option>'
										+ '<option value="20">20</option>'
										+ '<option value="30">30</option>'
										+ '</select> datos por página',
								"sInfo" : "Mostrando del START a END (Total: TOTAL resultados)",
								"sInfoFiltered" : " Filtrados de MAX registros",
								"sInfoEmpty" : " ",
								"sZeroRecords" : "No se encontraron registros",
								"sProcessing" : "Espere, por favor...",
								"sSearch" : "Buscar:",
							}
						});
	}

	function funcionUno(valor) {
		
		debugger;
		
		var x = document.getElementsByName("action")[valor].value;
		document.getElementById("inIdVariable").value = x;
		
		var temp = new Array();
		temp = x.split(",");
		document.getElementById("resol").value = temp[0];
		document.getElementById("tValla").value = temp[1];
		
	    
		var avisos       = document.getElementById("divAvisos");
	    var convencional = document.getElementById("divConvencional");
	    var vehiculos    = document.getElementById("divVehiculos");
	    var tubular      = document.getElementById("divTubular");
	    
	    
	    if(temp[1].includes("VALLA AVISOS")){
	    	avisos.style.display = "block";	  
	    }
	    else{
	    	avisos.style.display = "none";
	    }
	    
	    if(temp[1].includes("VALLA CONVENCIONAL")){
	    	convencional.style.display = "block";	  
	    }
	    else{
	    	convencional.style.display = "none";
	    }
	    
	    if(temp[1].includes("VALLA VEHÍCULOS")){
	    	vehiculos.style.display = "block";	  
	    }
	    else{
	    	vehiculos.style.display = "none";
	    }
	    
	    if(temp[1].includes("VALLA TUBULAR")){
	    	tubular.style.display = "block";	  
	    }
	    else{
	    	tubular.style.display = "none";
	    }
	}	

	
	function parametrosURL() {		
		var x =  $("#anioGravable").val();
		var y = document.getElementById("resol").value;
		console.log("${pageContext.request.contextPath}/contribuyentes/publicidadexterior/declaracion?anio="+ x + "numResolu="+ y);
		location.href="/sdhstorefront/es/contribuyentes/publicidadexterior/declaracion?anio="+ x + "numResolu="+ y;
		
	}


	function ShowSelected() {
	  $("#anioGravable").val(this.value);
	}
	
</script>