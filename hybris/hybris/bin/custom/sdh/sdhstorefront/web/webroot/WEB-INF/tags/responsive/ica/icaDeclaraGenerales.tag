<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.generales.titulo" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row mt-3">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.aniograv" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.periodo" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.opcuso" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.generales.cantesta" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-check">
							<label class="form-check-label"> <input type="radio"
								name="regimen" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important">
								<spring:theme code="ica.declaracion.generales.regimencomun" />
							</label> <label class="form-check-label"> <input type="radio"
								name="regimen" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important">
								<spring:theme code="ica.declaracion.generales.regsimpli" />
							</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label class="form-check-label" style="text-transform:capitalize !important"><spring:theme
								code="ica.declaracion.generales.aporte" /> </label>
						<div class="form-check">
							<label class="form-check-label" style="text-transform:capitalize !important"> <input type="radio"
								name="aporte" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important">
								Si
							</label> <label class="form-check-label" style="text-transform:capitalize !important"> <input type="radio"
								name="aporte" id="" class="form-check-input mr-2"
								style="visibility: visible !important; min-height: 4px !important">
								No
							</label>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>