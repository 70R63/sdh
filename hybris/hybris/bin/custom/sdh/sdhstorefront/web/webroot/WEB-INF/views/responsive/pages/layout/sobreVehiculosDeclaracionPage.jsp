<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobreVehiculos"
	tagdir="/WEB-INF/tags/responsive/sobreVehiculos"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>

<sobreVehiculos:sobreVehiculosDeclaraInicial />
<sobreVehiculos:sobreVehiculosDeclaraInfo />
<sobreVehiculos:sobreVehiculosDeclaraLiqui />
<%-- <sobreVehiculos:sobreVehiculosDeclaraFirma /> --%>
<c:url value='${redirectURL}' var="taxRedirection"/>
<firmas:generalFirmas firmaContribuyenteRedirection="${taxRedirection}"/>
<sobreVehiculos:sobreVehiculosDeclaraFirmas/>

<div id="dialogVehiculos" title="Vehiculos" >
	<div id="vehiculosDialogContent"></div>
</div>

<script>
	function goBack() {
		window.history.back();
	}
	
	window.onload = function() {
	
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){
			for (var i = 0; i < tam; i++) {
				if((cosas[i].name != "firmInterFunct")&&(cosas[i].id != "firmCompleteName")&&(cosas[i].id != "lblcontribuyente_documentType")&&(cosas[i].id != "contribuyente_documentNumber")&&(cosas[i].id != "contribuyente_numBP")){
					var valor = cosas[i].value;
					if (valor == "") {
						cosas[i].value = "-";
					}
				}
			}
		}	
		 $(".loader").fadeOut("slow");
		 
		debugger;
		 
		 var date = new Date();
		 var currentday = date.getDate(); //obteniendo dia
		 var currentmes = date.getMonth()+1; //obteniendo mes
		  var currentano = date.getFullYear(); //obteniendo año
		  var currentwday = date.getDay(); //obtiene el dia de la semana
		  
		 var primerDia = new Date(date.getFullYear(), date.getMonth(), 1);
		 var yearday = primerDia.getDay();
		 var ultimoDia = new Date(date.getFullYear(), date.getMonth() + 1, 0);
		 
		 var proyecto = document.getElementById('proyecto');
		 var aportesi = document.getElementById('aporteSi');
		 var aporteno = document.getElementById('aporteNo');
		 
		    if(currentmes == "6"){
		  
			  if(currentday == "27" && yearday=="0" ){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
				  
			  }	  
			  
			  if(currentday == "26" && yearday=="1"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
		
			  if(currentday == "25" && yearday=="2"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  
			  if(currentday == "24" && yearday=="3"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  if(currentday == "23" && yearday=="4"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  if(currentday == "22" && yearday=="5"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
			  if(currentday == "28" && yearday=="6"){
				  proyecto.disabled = true;
				  aportesi.disabled = true;
				  aporteno.disabled = true;
			  }
		    }
			  
	}
	
	function pagarlinea() {

		var btnpaglinea = document.getElementById('action');
		btnpaglinea.disabled = false;

	}
	
	function presdec() {
		var btnpresdec = document.getElementById('duGeneraDeclaracionButton');
		btnpresdec.disabled = false;

	}
</script>


