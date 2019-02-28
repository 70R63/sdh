<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



 	<cms:pageSlot position="YFormSlot" var="feature">
        <cms:component component="${feature}"  />
    </cms:pageSlot>




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
		    		
		    		if( ( (bDelineacionUrbana != "X") && (itext.includes("delineacion-urbana"))   ) ||
		    			( (bIca != "X") && (itext.includes("icareteica"))                         ) ||
		    			( (bPredial != "X") && (itext.includes("predialunificado"))               ) ||
		    			( (bPublicidadExt != "X") && (itext.includes("publicidadexterior"))       ) ||
		    			( (bVehicular != "X") && (itext.includes("sobrevehiculosautomotores"))    ) ||
		    		    ( (bSobreGasolina != "X") && (itext.includes("sobretasa-gasolina"))       )
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
	
	borrarMenu("${uiContribuyenteForm.bPredial}", "${uiContribuyenteForm.bVehicular}", "${uiContribuyenteForm.bIca}", "${uiContribuyenteForm.bPublicidadExt}", "${uiContribuyenteForm.bSobreGasolina}", "${uiContribuyenteForm.bDelineacionUrbana}");	
</script>