<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="retenciones"
	tagdir="/WEB-INF/tags/responsive/retencionesPracticadas"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<spring:htmlEscape defaultHtmlEscape="true" />

	<retenciones:retencionesPracticadas/>


	<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
	var url = window.parent.location.href;
	
}

 function showTable(){
	 var pro = document.getElementById('tableData');
	 var detail = document.getElementById('detailRetenedor');
		pro.style.display = 'block';
		detail.style.display = 'none';
}
 
 function showDetail(){
	 var data = document.getElementById('tableData');
	 var pro = document.getElementById('detailRetenedor');
		pro.style.display = 'block'; 
		data.style.display = 'none';
 }
</script>

