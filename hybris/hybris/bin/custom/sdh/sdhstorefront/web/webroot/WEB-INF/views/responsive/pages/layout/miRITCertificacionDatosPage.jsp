<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<style>
#myDIV { }

input[type=radio] {
    border: 0px;
    width: 15pt;
    height: 15pt;
    vertical-align: -15pt;
}

.inner2 {
   
}
</style>



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
	    	for( li_index = 7; li_index <= 16; li_index++ ) {
	    		
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
	
	borrarMenu("${miRitCertificacionForm.bPredial}", "${miRitCertificacionForm.bVehicular}", "${miRitCertificacionForm.bIca}", "${miRitCertificacionForm.bPublicidadExt}", "${miRitCertificacionForm.bSobreGasolina}", "${miRitCertificacionForm.bDelineacionUrbana}");
	
</script>

 <!--
<div class="col-md-2" >
			<button class="btn btn-primary btn-block" type="button" style="margin-top: 30px;margin-left: 40px" onclick='borrarMenu("${miRitCertificacionForm.bPredial}", "${miRitCertificacionForm.bVehicular}", "${miRitCertificacionForm.bIca}", "${miRitCertificacionForm.bPublicidadExt}", "${miRitCertificacionForm.bSobreGasolina}", "${miRitCertificacionForm.bDelineacionUrbana}")'>
				<spring:theme code="mirit.certificacion.btnGenerar" />
			</button>
		</div>
-->

<div class="row">
 	<div class=" headline">
		<h2>
			<span tabindex="0"><spring:theme code="mirit.certificacion.titulo" /></span>
		</h2>
	</div>
</div>

 <form:form action="/sdhstorefront/es/contribuyentes/mirit/certificacion" method="post" commandName="miRitCertificacionForm" >
       
	<br>
	  <div class="row">  
	    <div class=" col-md-2">
	    	<div class="form-group ">
	    	    <label class="control-label" for="tipoCert"><spring:theme code="mirit.certificacion.textImp" /></label>
	    	    <form:select  id="tipoCert" path="tipoCert" onchange="Hide(this.value);" cssClass="form-control">
			        <form:option value="0"> <spring:theme code="mirit.certificacion.opSeleccionar"/> </form:option>
			  		<form:option value="1"> <spring:theme code="mirit.certificacion.opImpuesto"/> </form:option> 
			  		<form:option value="2"> <spring:theme code="mirit.certificacion.opSujeto"/> </form:option>
				</form:select>
			</div>
		</div>
		
		<div class="col-md-2" >
			<button class="btn btn-primary btn-block" type="submit" style="margin-top: 30px;margin-left: 40px">
				<spring:theme code="mirit.certificacion.btnGenerar" />
			</button>
		</div>
	  </div>	
	
  	<br>
  		
	
	<div class="row">
		<div id="myDIV"  style="display:none">
		
		    <div class="headline">				
				<h2>
					<span tabindex="0"><spring:theme code="mirit.certificacion.tituloImpuesto" /></span>
				</h2>			
			</div>
		
			<br>
		    
			<div class=" col-md-2">
				<c:if test="${miRitCertificacionForm.bPredial == 'X'}">
					<input type="radio" name="tipoImp" id="tipoImp" value="01" style="visibility: visible"><spring:theme code="mirit.certificacion.opPredial"/><br>
				</c:if>
				
				
				<c:if test="${miRitCertificacionForm.bVehicular == 'X'}">
					<input type="radio" name="tipoImp" id="tipoImp" value="02" style="visibility: visible"><spring:theme code="mirit.certificacion.opVehicular"/><br>
				</c:if>
				
				<c:if test="${miRitCertificacionForm.bIca == 'X'}">
					<input type="radio" name="tipoImp" id="tipoImp" value="03" style="visibility: visible"><spring:theme code="mirit.certificacion.opICA"/><br>	
		    	</c:if>
		    	
		    	<c:if test="${miRitCertificacionForm.bPublicidadExt == 'X'}">
		    		<input type="radio" name="tipoImp" id="tipoImp" value="07" style="visibility: visible"><spring:theme code="mirit.certificacion.opPublicidadExterior"/><br>
		    	</c:if>
		    	
		    	<c:if test="${miRitCertificacionForm.bSobreGasolina == 'X'}">
		    		<input type="radio" name="tipoImp" id="tipoImp" value="05" style="visibility: visible"><spring:theme code="mirit.certificacion.opSobretasaGasolina"/><br>
		    	</c:if>
		    	
		    	<c:if test="${miRitCertificacionForm.bDelineacionUrbana == 'X'}">
		    		<input type="radio" name="tipoImp" id="tipoImp" value="06" style="visibility: visible"><spring:theme code="mirit.certificacion.opDelineaciónUrbana"/><br>
		    	</c:if>
		    </div>    
	    </div>
    </div>
  </form:form>

  <script>
    function Hide(val) {
	  var x = document.getElementById("myDIV");
	  if(val == "1"){
		  x.style.display = "block";	  
	  }
	  else{
		  x.style.display = "none";
	  }
	}
  </script>
  
