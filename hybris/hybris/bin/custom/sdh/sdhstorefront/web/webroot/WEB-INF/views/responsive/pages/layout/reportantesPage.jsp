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
		var li_index;
		var currentUrl = document.URL;
		var inner_Text;
		var error_message;
		var counter;
		
		
		<c:forEach items="${uiContribuyenteForm.roles}" var="row_uiContribuyenteForm">
			<c:if test = "${row_uiContribuyenteForm.nombreRol == '05'}">  
				for( counter = 1; counter <= 7; counter++ ) {
					for( li_index = 1; li_index <= li_array.length; li_index++ ) {	    		
						try{
							inner_Text = li_array[li_index].innerText;
							
							if( inner_Text.includes("Impuestos")	 ||
								inner_Text.includes("Buzón")         ||
								inner_Text.includes("Trámites")      ||
								inner_Text.includes("Facturación")   ||
								inner_Text.includes("Declaraciones") ||
								inner_Text.includes("Pagos")         ||
								inner_Text.includes("Consultas")   	
							  ){					
								li_array[li_index].remove();
							}	
						}catch(err){
							error_message = err.message;
						}		
			    	}
				}	
			</c:if>
		</c:forEach>
			
		
		
		for( counter = 1; counter <= 6; counter++ ) {
			for( li_index = 1; li_index <= li_array.length; li_index++ ) {
				try{
					inner_Text = li_array[li_index].innerText;
					
					if( ( (bDelineacionUrbana != "X") && (inner_Text.includes("Delineación Urbana"))                ) ||
		    			( (bIca != "X")               && (inner_Text.includes("ICA"))                               ) ||
		    			( (bPredial != "X")           && (inner_Text.includes("Predial unificado"))                 ) ||
		    			( (bPublicidadExt != "X")     && (inner_Text.includes("Publicidad exterior"))               ) ||
		    			( (bVehicular != "X")         && (inner_Text.includes("Sobre vehículos automotores"))       ) ||
		    		    ( (bSobreGasolina != "X")     && (inner_Text.includes("Sobretasa a la gasolina"))           )
			    	  )		
					{
						li_array[li_index].remove();
					}
				}catch(err){
					error_message = err.message;
				}
	    	}
		}	
		
	}	
	
	borrarMenu("${uiContribuyenteForm.bPredial}", "${uiContribuyenteForm.bVehicular}", "${uiContribuyenteForm.bIca}", "${uiContribuyenteForm.bPublicidadExt}", "${uiContribuyenteForm.bSobreGasolina}", "${uiContribuyenteForm.bDelineacionUrbana}", "${uiContribuyenteForm.roles}");	
</script>