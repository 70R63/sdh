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
							code="ica.inicial.detalle.title" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row mt-3">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.feciniact" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.fecceseact" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.mat" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">

					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.codliq" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.cantesta" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.orgjuri" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.causal" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.edomat" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>


					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.regimen" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.inicial.detalle.clasiden" /></label> <input id="" name=""
								class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
