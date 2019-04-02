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
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.firma.titulo" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row margin-bottom-4" style="margin-top: 18px">
					<div class="col-md-12" style="margin-top: 18px">
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								name="regimen" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								<spring:theme code="ica.declaracion.firma.obligado" />
							</label> <label class="form-check-label"> <input type="radio"
								name="firma" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								<spring:theme code="ica.declaracion.firma.revisor" />
							</label> <label class="form-check-label"> <input type="radio"
								name="firma" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								<spring:theme code="ica.declaracion.firma.contador" />
							</label>
						</div>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-md-2">
						<div class="form-group">
							<input disabled id="" name="" class="form-control" disabled
								type="text" value="" maxlength="240" placeholder="Revisor"
								style="margin-top: 26px;">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.tipoien" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numide" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>

					<div class="col-md-3">
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
				<div class="row mt-3">
					<div class="col-md-2">
						<div class="form-group">
							<input disabled id="" name="" class="form-control" disabled
								type="text" value="" maxlength="240" placeholder="Contador"
								style="margin-top: 26px;"> </input>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.tipoien" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.firma.numide" /></label> <input disabled id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>

					<div class="col-md-3">
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
						<button style="margin-top: 3px;" id=""
							class="btn btn-primary btn-lg" type="button">
							<spring:theme code="ica.declaracion.firma.rop" />
						</button>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>
