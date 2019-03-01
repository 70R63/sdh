<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="reportantes"
	tagdir="/WEB-INF/tags/responsive/reportantesInformacion"%>


<div class="container">
	<reportantes:reportantesInicial></reportantes:reportantesInicial>
	<div id="idPredial" style="display: none;">
		<reportantes:reportantesCargaPredial />
	</div>
	<div id="idOpain" style="display: none;">
		<reportantes:reportantesCargaOpain />
	</div>
	<div id="idIca" style="display: none;">
		<reportantes:reportantesCargaIca />
	</div>
	<div id="idVehicular" style="display: none;">
		<reportantes:reportantesCargaVehicular />
	</div>
</div>


<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idinrepor").value = value;
	}

	function myFunction() {

		var x = document.getElementById('Idinrepor').value;
		var idPredial = document.getElementById('idPredial');
		var idOpain = document.getElementById('idOpain');
		var idIca = document.getElementById('idIca');
		var idVehicular = document.getElementById('idVehicular');

		if (x == '1') {
			idPredial.style.display = 'block';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';

		} else if (x == '2') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'block';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';

		} else if (x == '3') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'block';
			idVehicular.style.display = 'none';

		} else if (x == '4') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'block';

		} else {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';
		}

	}
</script>

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
