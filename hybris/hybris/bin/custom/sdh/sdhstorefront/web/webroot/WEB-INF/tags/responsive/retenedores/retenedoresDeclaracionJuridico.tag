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
									code="reteica.declaracion.juridico.base" /></label> <input id="baseReten"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.baseReten }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totalreten" /></label> <input id="totalRetePer"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.totalRetePer }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.descuentos" /></label> <input id="descDevol"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.descDevol }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totretdec" /></label> <input id="totalReteDecl"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.totalReteDecl }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.sancion" /></label> <input id="sancion"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.sancion }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totsaldoca" /></label> <input id="totalSaldo"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.totalSaldo }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.valpag" /></label> <input id="valorPagar"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.valorPagar }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridic.interes" /></label> <input id="interesMora"
								name="" class="form-control" disabled type="text" value="${calculoResponse.infoDeclara.interesMora }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="reteica.declaracion.juridico.totpagar" /></label> <input id="totalPagar"
								name="" class="form-control" type="text" value="${calculoResponse.infoDeclara.totalPagar }"
								maxlength="240"
								style="width: 280px !important; text-align: center !important"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10">
						<div class="form-group">
							<button type="button" class="btn btn-primary text-center" id="actualizarButton" name="actualizarButton"
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
