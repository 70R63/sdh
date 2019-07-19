
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<script>
		function downloadPDF(pdf) {
			debugger;
			const linkSource = 'data:application/pdf;base64,' + pdf;
			const downloadLink = document.createElement("a");
			const fileName = "ROP.pdf";

			downloadLink.href = linkSource;
			downloadLink.download = fileName;
			downloadLink.click();

		}

		downloadPDF('${ropForm.stringFact}');
	</script>



	<!-- 	<div class="container"> -->
	<!-- 	 	<div class="headline"> -->
	<!-- 			<h3> -->
	<%-- 				<c:if test="${not empty ropForm.stringFact}"> --%>
	<%-- 				  <iframe width='100%' height='600' width='15' src=' data:application/pdf;/Certificación RIT#zoom=100&view=fitH&;base64,${ropForm.stringFact}'>	</iframe> --%>
	<%-- 				</c:if>   --%>
	<!-- 			</h3> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
</div>



<div class="container_new_page">
	<form:form id="form_pdf" action="/sdhstorefront/es/contribuyentes/rop"
		method="post" commandName="ropForm">
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label">
						<spring:theme code="rop.generar.valobli" />
					</label>
					<input class="form-control new_alto" disabled="disabled"
						type="text" size="30" value=""/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="rop.generar.totalpagar" /></label> <form:input
						class="form-control new_alto" disabled="disabled" type="text"
						size="30" value="" path="importeusuario" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="rop.generar.parcial" /></label> <input
						class="form-control new_alto" type="text" size="30" value="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<button style="margin-top: 26px; margin-bottom: 15px;" id=""
					class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="rop.generar.regresar" />
				</button>


			</div>
			<div class="col-md-2">
				<button style="margin-top: 26px; margin-bottom: 15px;" id=""
					class="btn btn-primary btn-lg" onclick="" type="submit">
					<spring:theme code="rop.generar.genrop" />
				</button>
			</div>
		</div>

	</form:form>
</div>
<script>
	function goBack() {
		window.history.back();
	}
</script>

