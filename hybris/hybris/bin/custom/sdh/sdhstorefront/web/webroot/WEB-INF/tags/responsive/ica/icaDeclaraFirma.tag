<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row mt-3">
		<div class="col-md-12 mt-3">
			<div class="headline">
				<h2>
					<span><spring:theme code="ica.declaracion.firma.titulo" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row margin-bottom-4" style="margin-top: 18px">
					<div class="col-md-12" style="margin-top: 18px">
						<div class="form-check">
							<label class="form-check-label"
								style="text-transform: capitalize"> <input
								type="checkbox" name="regimen" id=""
								class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								<spring:theme code="ica.declaracion.firma.obligado" />
							</label> <label class="form-check-label"> <input onclick="show()" type="radio"
								name="firma" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								<spring:theme code="ica.declaracion.firma.revisor"  />
							</label> <label class="form-check-label"> <input onclick="show2()" type="radio"
								name="firma" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								<spring:theme code="ica.declaracion.firma.replegal" />
							</label>
						</div>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-md-4">
						<div class="form-group">
							<input disabled id="" name="" class="form-control" disabled
								type="text" value="" maxlength="240" placeholder="Declarante"
								style="margin-top: 26px;">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.tipoiden" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numide" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numtarjeta" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.nombre" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>

				<div id="representante" class="row mt-3" style="display: none">
					<div class="col-md-2">
						<div class="form-group">
							<input disabled id="" name="" class="form-control" disabled
								type="text" value="" maxlength="240"
								placeholder="Representante Legal" style="margin-top: 26px;">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme code="" /></label> <select
								class="form-control">
								<option>seleccionar</option>
							</select>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.tipoiden" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numide" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numtarjeta" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.nombre" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div id="Revisor" class="row mt-3" style="display: none">
					<div class="col-md-2">
						<div class="form-group">
							<input disabled id="" name="" class="form-control" disabled
								type="text" value="" maxlength="240"
								placeholder="Revisor/Contador" style="margin-top: 26px;">
							</input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme code="" /></label> <select
								class="form-control">
								<option>seleccionar</option>
							</select>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.tipoiden" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numide" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numtarjeta" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.nombre" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row" style="marging-top: 5px">
					<div class="col-md-12 centercol-md-8 text-center">

						<button style="margin-top: 3px;" id="regresar"
							class="btn btn-primary btn-lg"
							onclick="window.location.href ='<c:url value='/' />';"
							type="button">
							<spring:theme code="ica.declaracion.firma.regresar" />
						</button>
						<button style="margin-top: 3px;" id=""
							class="btn btn-primary btn-lg" type="button">
							<spring:theme code="ica.declaracion.firma.prendecla" />
						</button>
						<button style="margin-top: 3px;" id=""
							class="btn btn-primary btn-lg" type="button">
							<spring:theme code="ica.declaracion.firma.pagliena" />
						</button>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>
<script>

function show() {
	var rep = document.getElementById('representante');
	var rev = document.getElementById('Revisor');
	rep.style.display = 'block';
	rev.style.display = 'none';

	}
	
function show2() {
	var rep = document.getElementById('representante');
	var rev = document.getElementById('Revisor');
	rep.style.display = 'none';
	rev.style.display = 'block';

	}
</script>
