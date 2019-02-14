<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="publicidadExterior"
	tagdir="/WEB-INF/tags/responsive/publicidadExterior"%>

<style>
#divAvisos { }
#divConvencional { }
#divVehiculos { }
#divTubular { }
</style>

<template:page>

<%-- <sf:form action="${pageContext.request.contextPath}/contribuyentes/publicidadexterior/declaracion" method="POST" modelAttribute="publicidadForm" id="forma"> --%>
<sf:form action="" method="POST" modelAttribute="publicidadForm" id="forma">
	<div class="container">
	
		<publicidadExterior:publicidadExteriorTable />
		<publicidadExterior:publicidadExteriorDetail />
<%-- 		<publicidadExterior:publicidadExteriorAvisos /> --%>
		<publicidadExterior:publicidadExteriorTubularComercial />
		<publicidadExterior:publicidadExteriorVehiculos />
		<publicidadExterior:publicidadExteriorTubularObra />
		<publicidadExterior:publicidadExteriorObraConvencional />
		<publicidadExterior:publicidadExteriorPantallaLed />
	</div>
	</sf:form>
	
	<div id="dialogPublicidadExterior" title="Publicidad Exterior" ><div id="publicidadExteriorDialogContent"></div></div>


	
	
</template:page>


<script>
	function borrarMenu(bPredial, bVehicular, bIca, bPublicidadExt, bSobreGasolina, bDelineacionUrbana) {
		debugger;
		var li_array = document.getElementsByTagName('li');
		var borrar_index;
		var submenu_index;
		var li_index;
		var a_index;
		var itext;
		
	    
		for( submenu_index = 1; submenu_index <= 6; submenu_index++ ) {
	    	for( li_index = 7; li_index <= 19; li_index++ ) {
	    		
	    		a_array = li_array[li_index].getElementsByTagName('a');
		    	
	    		for( a_index = 0; a_index < a_array.length; a_index++ ) {
		    		itext = a_array[a_index].getAttribute('href');
		    		
		    		if( ( (bDelineacionUrbana != "X") && (itext.includes("/contribuyentes/delineacion-urbana"))                 ) ||
		    			( (bIca != "X") && (itext.includes("/contribuyentes2/icareteica"))                      ) ||
		    			( (bPredial != "X") && (itext.includes("/sdhstorefront/es/contribuyentes2/predialunificado"))            ) ||
		    			( (bPublicidadExt != "X") && (itext.includes("/sdhstorefront/es/contribuyentes2/publicidadexterior"))    ) ||
		    			( (bVehicular != "X") && (itext.includes("/sdhstorefront/es/contribuyentes2/sobrevehiculosautomotores")) ) ||
		    		    ( (bSobreGasolina != "X") && (itext.includes("/sdhstorefront/es/contribuyentes/sobretasa-gasolina"))     )
		    		  )			
		    		{
		    			borrar_index = true;
		    			break;
		    		}
		    		else{
		    			borrar_index = false;
		    			break;
		    		}
			    }
	    		
	    		if(borrar_index){
	    			li_array[li_index].remove();
	    		}
	    	}
		}	
	}	
	
	borrarMenu("${publicidadForm.bPredial}", "${publicidadForm.bVehicular}", "${publicidadForm.bIca}", "${publicidadForm.bPublicidadExt}", "${publicidadForm.bSobreGasolina}", "${publicidadForm.bDelineacionUrbana}");	
</script>