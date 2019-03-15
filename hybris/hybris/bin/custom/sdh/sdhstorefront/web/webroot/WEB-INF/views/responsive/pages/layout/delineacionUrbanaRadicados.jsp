<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana"
	tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form>

	<delineacionUrbana:delineacionUrbanaRetenGenerales />
	<delineacionUrbana:delineacionUrbanaRetenAreasUsos />
	<delineacionUrbana:delineacionUrbanaRetenLiqPriva />
	<delineacionUrbana:delineacionUrbanaRetenFirma />

</sf:form>


<script>
	function goBack() {
		window.history.back();
	}
	
	function obranueva(selectObject){
	
			var value = selectObject.value;
			var areaintervenida = document.getElementById('selectareinter');
			var inareainter = document.getElementById('inputareainter');
			
			if (value == '6'){
				
				areaintervenida.disabled=false;
				inareainter.disabled=false;
				
			}else{
				areaintervenida.disabled=true;
				inareainter.disabled=true;
			}
	}
	
	function costoshabil(selectObject){
		
		var value = selectObject.value;
		var cosdir = document.getElementById('codstdirec');
		var cosind = document.getElementById('costindirec');
		var metcons = document.getElementById('metconstr');
		var metvent = document.getElementById('metventa');
		var valcons = document.getElementById('valconstr');
		var valapr = document.getElementById('valaprox');
		
		if (value == '1'){
			cosdir.disabled=true;
			cosind.disabled=true;
			metcons.disabled=true;
			metvent.disabled=true;
			valcons.disabled=true;
			valapr.disabled=true;
			
			
		}else{
			cosdir.disabled=false;
			cosind.disabled=false;
			metcons.disabled=false;
			metvent.disabled=false;
			valcons.disabled=false;
			valapr.disabled=false;
		}
}
	
</script>


