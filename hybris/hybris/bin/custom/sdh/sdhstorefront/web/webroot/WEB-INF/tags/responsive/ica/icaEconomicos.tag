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
							code="ica.inicial.datecono.title" /></span>
				</h2>
			</div>
			<form:form action="">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.datecono.actsoc" /></label> <input id="" name=""
								class="form-control" disabled type="text" 
								value="${icaInfObjetoFormResp.icaInfObjetoResponse.datosEconomicos.activoTotal}"
								maxlength="240" style="width: auto !important; text-align: center"></input>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.datecono.ingoper" /></label> <input id="" name=""
								class="form-control" disabled type="text" 
								value="${icaInfObjetoFormResp.icaInfObjetoResponse.datosEconomicos.ingresosOp}"
								maxlength="240" style="width: auto !important; text-align: center"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.datecono.pastot" /></label> <input id="" name=""
								class="form-control" disabled type="text" 
								value="${icaInfObjetoFormResp.icaInfObjetoResponse.datosEconomicos.pasivoTotal}"
								maxlength="240" style="width: auto !important; text-align: center"></input>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.datecono.ingnoper" /></label> <input id="" name=""
								class="form-control" disabled type="text" 
								value="${icaInfObjetoFormResp.icaInfObjetoResponse.datosEconomicos.ingresosNoOp}"
								maxlength="240" style="width: auto !important; text-align: center"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.datecono.patneto" /></label> <input id="" name=""
								class="form-control" disabled type="text" 
								value="${icaInfObjetoFormResp.icaInfObjetoResponse.datosEconomicos.patrimonioNeto}"
								maxlength="240" style="width: auto !important;text-align: center"></input>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.datecono.paspat" /></label> <input id="" name=""
								class="form-control" disabled type="text" 
								value="${icaInfObjetoFormResp.icaInfObjetoResponse.datosEconomicos.pasivoPatrim}"
								maxlength="240" style="width: auto !important; text-align: center"></input>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>


