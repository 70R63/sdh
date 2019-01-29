<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="publicidadExterior"
	tagdir="/WEB-INF/tags/responsive/publicidadExterior"%>

<template:page pageTitle="${pageTitle}">

	<div class="container">

		<publicidadExterior:publicidadExteriorTable />

		<div id="idAvisos" style="display: none;">
			<publicidadExterior:publicidadExteriorDetail />
			<publicidadExterior:publicidadExteriorAvisos />
		</div>
		<div id="idConvencional" style="display: none;">
			<publicidadExterior:publicidadExteriorDetail />
			<publicidadExterior:publicidadExteriorConvencional />
		</div>
		<div id="idVehicular" style="display: none;">
			<publicidadExterior:publicidadExteriorDetail />
			<publicidadExterior:publicidadExteriorVehiculos />
		</div>
		<div id="idTubular" style="display: none;">
			<publicidadExterior:publicidadExteriorDetail />
			<publicidadExterior:publicidadExteriorTubular />
		</div>




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
</script>

<script>
	function funcionUno(valor) {	
		var x = document.getElementsByName("action")[valor].value;		
<<<<<<< HEAD
		document.getElementById("inIdVariable").value = x;
		alert(x);

				
=======
		document.getElementById("inIdVariable").value = x;				
>>>>>>> dev
	}
</script>


<script>
	function functionDos() {
		if (x == "VALLA VEHÍCULOS")
			{
			 x = "VALLA VEHICULOS";
			} else {x = x}
		var x = document.getElementById("inIdVariable").value;
		alert(x);
		var a = document.getElementById('idAvisos');
		var b = document.getElementById('idConvencional');
		var c = document.getElementById('idVehicular');
		var d = document.getElementById('idTubular');

		if (x == "VALLA AVISOS") {
			a.style.display = 'block';
			b.style.display = 'none';
			c.style.display = 'none';
			d.style.display = 'none';
		} else if (x == "VALLA CONVENCIONAL") {
			b.style.display = 'block';
			a.style.display = 'none';
			c.style.display = 'none';
			d.style.display = 'none';

		} else if (x == "VALLA VEHICULOS") {
			c.style.display = 'block';
			a.style.display = 'none';
			b.style.display = 'none';
			d.style.display = 'none';
		} else if (x == "VALLA TUBULAR") {
			d.style.display = 'block';
			a.style.display = 'none';
			b.style.display = 'none';
			c.style.display = 'none';
		} else {
			alert("error");
		}
	}
</script>

<script>
	function parametrosURL() {		
		var x = document.getElementById("inIdAnio").value;
		location.href="/sdhstorefront/es/contribuyentes/publicidadexterior/declaracion?anio="+ x;
	}
</script>



<script type="text/javascript">
	function ShowSelected(selectObject)
	{	 
	  var value = selectObject.value;   
	  document.getElementById("inIdAnio").value = value;
	
	}
</script>

