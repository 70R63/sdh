<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="row mt-3">
		<div class="col-md-12 mt-3">
			<div class="headline">
				<h2>
					<span><spring:theme code="reteica.declaracion.firma.titulo" /></span>
				</h2>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.declaracion.firma.agregarfirmantes" /></label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme code="" /></label>
						<button id="agregarFirma" class="btn btn-primary btn-lg"
							type="button" onclick="addfirma()">
							<spring:theme code="reteica.declaracion.firma.agregar" />
						</button>
					</div>
				</div>
			</div>
			<div class="firma row">
				<div class="col-md-2">
					<div class="form-group tipdoc">
						<label class="control-label "><spring:theme
								code="reteica.declaracion.firma.tipdoc" /></label> <input disabled
							id="" name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group numdoc">
						<label class="control-label "><spring:theme
								code="reteica.declaracion.firma.numdoc" /></label> <input disabled
							id="" name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group name">
						<label class="control-label"><spring:theme
								code="reteica.declaracion.firma.nombre" /></label> <input disabled
							id="" name="" class="form-control" disabled type="text" value=""
							maxlength="240"></input>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="control-label"><spring:theme code="" /></label>
						<button style="margin-top: 25px;" id=""
							class="btn btn-primary btn-lg" type="button">
							<spring:theme code="reteica.declaracion.firma.firma" />
						</button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<button type="button" id="" class="btn btn-secondary btn-lg" type="button" onclick="goBack()">
						<spring:theme code="reteica.declaracion.firma.regresar" />
					</button>
				</div>
					<div class="col-md-3">
					<button id="" class="btn btn-primary btn-lg" type="button">
						<spring:theme code="reteica.declaracion.firma.presendecla" />
					</button>
				</div>
					<div class="col-md-3">
					<button id="" class="btn btn-primary btn-lg" type="button">
						<spring:theme code="reteica.declaracion.firma.paglinea" />
					</button>
				</div>
			</div>

		</div>
	</div>
</div>




<script>
	function addfirma() {

		var tam = $(".firma").length;
		if ($(".firma").length < 3) {
			$($(".firma")[0]).parent().append($($(".firma")[0]).clone());
			$($(".firma")[0]).parent().children().last().find(".tipodoc").val(
					"")
			$($(".firma")[0]).parent().children().last().find(".numdoc")
					.val("")
			$($(".firma")[0]).parent().children().last().find(".name").val("")

		} else {
			alert("No se pueden agregar más registros");
		}

	}
</script>