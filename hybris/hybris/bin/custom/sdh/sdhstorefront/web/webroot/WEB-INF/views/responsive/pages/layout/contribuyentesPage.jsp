<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="cont"
	tagdir="/WEB-INF/tags/responsive/listaContribuyente"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<template:page pageTitle="${pageTitle}">
</template:page>
<cont:contribuyentesLista/>

<script type="text/javascript">
	

	function onErrorSITII() {
		
		var errorSitII = '${errorSITII}';
		if (errorSitII === null || errorSitII === '' || typeof errorSitII === 'undefined' ){
		  
		}else{
			alert(errorSitII);
		}
	}	
		
	window.onload = function() {
		
	    $(".loader").fadeOut("slow");
	    
	    onErrorSITII();
	    
	}
</script>




