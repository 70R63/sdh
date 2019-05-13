<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="icadecla" tagdir="/WEB-INF/tags/responsive/ica"%>
	<icadecla:icaDeclaraInicial/>
	<icadecla:icaDeclaraGenerales/>
	
	<icadecla:icaDeclaraActFuera/>
	<icadecla:icaDeclaraDeduccion/>
	<icadecla:icaDeclaraTotal/>
	<icadecla:icaDeclaraValor/>
	<icadecla:icaDeclaraLiquidacion/>
	<icadecla:icaDeclaraFirma/>

	<div id="dialogICA" title="ICA" ><div id="icaDialogContent"></div></div>
	
	
<script>	
	function goBack() {
		window.history.back();
	}
</script>	