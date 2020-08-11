<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="terceros" tagdir="/WEB-INF/tags/responsive/terceroautorizado"%>
<div class="loader"></div>


<terceros:terceroOpcionesBuscar/>
<br>
<br>
<br>
<br>
<br>
<br>
<terceros:terceroSIMBuscar/>
<terceros:terceroNotarioBuscar/>
<terceros:tercero_predial/>
<terceros:tercero_ica/>
<terceros:tercero_reteica/>
<terceros:tercero_vehicular/>
<terceros:tercero_delineacion/>
<terceros:tercero_gasolina/>
<terceros:tercero_publicidad/>


<!-- <div class="container_new_page"> -->
<!-- 	<div class="row "> -->
<!-- 		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3"> -->
<%-- 			<a href="<c:url value='/terceros/sujeto' />"> --%>
<!-- 				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1"> -->
<%-- 					<img title="sujeto" alt="sujeto" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/terceros_notario.jpg"> --%>
<!-- 				</div> -->
<!-- 				<div class="card-section  col-xs-8 col-sm-10 col-md-10"> -->
<%-- 					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="terceros.menu.sujeto" /></span></h2></div> --%>
<!-- 					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0"> -->
<!-- 						<div id="helpSection"><div></div></div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</a> -->
<!-- 		</div>	 -->
<!-- 	</div> -->
	
<!-- 	<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3"> -->
<%-- 		<a href="<c:url value='/terceros/objeto' />"> --%>
<!-- 			<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1"> -->
<%-- 				<img title="objeto" alt="objeto" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/terceros_sim.jpg"> --%>
<!-- 			</div> -->
<!-- 			<div class="card-section  col-xs-8 col-sm-10 col-md-10"> -->
<%-- 				<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="terceros.menu.objeto" /></span></h2></div> --%>
<!-- 				<div class="card-section-content" aria-labelledby="helpSection" tabindex="0"> -->
<!-- 					<div id="helpSection"><div></div></div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</a> -->
<!-- 	</div> -->
	
<!-- </div> -->

<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}

function habilitarBusqueda(opcionBusqueda){
	
	var nombreObjeto = null;
	
	switch(opcionBusqueda){
	case "sujeto":
		opcionVisualizar("buscarSujeto","block");
		opcionVisualizar("buscarObjeto","none");
		break;
	case "objeto":
		opcionVisualizar("buscarSujeto","none");
		opcionVisualizar("buscarObjeto","block");
		break;		
	}
	
	
}

function opcionVisualizar(nombreObjeto,opcionMostrar){
	
	if(nombreObjeto != null){
		var doc = document.getElementById(nombreObjeto);
		if(doc != null){
			doc.style.display = opcionMostrar; 
		}
	}
	
}
</script>