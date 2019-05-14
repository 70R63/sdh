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
							code="reteica.declaracion.juridico.titulo" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row mt-3">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.base" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totalreten" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.descuentos" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totretdec" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.sancion" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totsaldoca" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.valpag" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridic.interes" /></label> <input id=""
								name="" class="form-control" disabled type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totpagar" /></label> <input id=""
								name="" class="form-control" type="text" value=""
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10">
						<div class="form-group">
							<button class="btn btn-primary text-center" id="" name=""
								value="actualizar">
								<spring:theme code="reteica.declaracion.juridico.actualizar" />
							</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
