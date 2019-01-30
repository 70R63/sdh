<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<style>
#myDIV { }
</style>

<div class="row">
	<div class="container">
	 	<div class=" headline">
			<h3 class="cintillo">
				<span tabindex="0"><spring:theme code="mirit.certificacion.titulo" /></span>
			</h3>
		</div>
	</div>
</div>

 <form:form action="/sdhstorefront/es/contribuyentes/mirit/certificacion" method="post" commandName="miRitCertificacionForm" >
 
	<div class="row">	
	 	<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme code="mirit.certificacion.textImp" /></label>
		</div>
	    <div class="col-md-2">
		    <form:select path="tipoCert" onchange="Hide(this.value);" cssClass="inputdropdown">
		        <form:option value="0"> <spring:theme code="mirit.certificacion.opSeleccionar"/> </form:option>
		  		<form:option value="1"> <spring:theme code="mirit.certificacion.opImpuesto"/> </form:option> 
		  		<form:option value="2"> <spring:theme code="mirit.certificacion.opSujeto"/> </form:option>
			</form:select>
		</div>
		<div class="col-md-2 ">
			<button class="boton btn-secondary " type="submit" >
				<spring:theme code="mirit.certificacion.btnGenerar" />
			</button>
		</div>
	</div>
	
	<div id="myDIV"  style="display:none"> 
		<div class="row">				
			<div class="col-md-3">
				<label class="inputlabelnew"><spring:theme code="mirit.certificacion.tituloImpuesto" /></label>
			</div>
		</div>
		
		<c:if test="${miRitCertificacionForm.bPredial == 'X'}">
			<input type="radio" name="tipoImp" id="tipoImp" value="1" style="visibility: visible"><spring:theme code="mirit.certificacion.opPredial"/><br>
		</c:if>
		<c:if test="${miRitCertificacionForm.bVehicular == 'X'}">
			<input type="radio" name="tipoImp" id="tipoImp" value="1" style="visibility: visible"><spring:theme code="mirit.certificacion.opPredial"/><br>
		</c:if>	
		<c:if test="${miRitCertificacionForm.bIca == 'X'}">
			<input type="radio" name="tipoImp" id="tipoImp" value="3" style="visibility: visible"><spring:theme code="mirit.certificacion.opICA"/><br>	
    	</c:if>
    	<c:if test="${miRitCertificacionForm.bPublicidadExt == 'X'}">
    		<input type="radio" name="tipoImp" id="tipoImp" value="4" style="visibility: visible"><spring:theme code="mirit.certificacion.opPublicidadExterior"/><br>
    	</c:if>
    	<c:if test="${miRitCertificacionForm.bSobreGasolina == 'X'}">
    		<input type="radio" name="tipoImp" id="tipoImp" value="5" style="visibility: visible"><spring:theme code="mirit.certificacion.opSobretasaGasolina"/><br>
    	</c:if>	
    	<c:if test="${miRitCertificacionForm.bDelineacionUrbana == 'X'}">
    		<input type="radio" name="tipoImp" id="tipoImp" value="6" style="visibility: visible"><spring:theme code="mirit.certificacion.opDelineaciónUrbana"/><br>
    	</c:if>		
    	
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