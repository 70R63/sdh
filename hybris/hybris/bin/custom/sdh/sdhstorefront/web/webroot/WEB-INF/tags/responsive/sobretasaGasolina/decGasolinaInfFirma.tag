<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0" class="col-md-12 cintillo"><spring:theme
					code="impuestos.decGasolina.InformacionFirma.titulo" /></span>
		</h3>
	</div>
</div>

<!-- <div class="col-md-2"> -->
<%-- 	<label><spring:theme --%>
<%-- 			code="impuestos.decGasolina.InformacionFirma.agregarFirmas" /></label> --%>
<!-- </div> -->

<!-- <div class="col-md-4"> -->
<!-- 	<div class="form-group "> -->
<!-- 		<button class="btn btn-primary btn-block" type="button"> -->
<%-- 			<spring:theme code="impuestos.decGasolina.InformacionFirma.Agregar" /> --%>
<!-- 		</button> -->
<!-- 	</div> -->
<!-- </div> -->

<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<div class="row">
		<div class="col-md-10">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<td><label class="col-md-2 inputlabelnew"><spring:theme
										code="impuestos.decGasolina.InformacionFirma.tipoId" /></label></td>
							<td><label class="col-md-2 col-md-offset-1 inputlabelnew"><spring:theme
										code="impuestos.decGasolina.InformacionFirma.numeroId" /></label></td>
							<td><label class="col-md-3  inputlabelnew"><spring:theme
										code="impuestos.decGasolina.InformacionFirma.denominacion" /></label></td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<div class="form-group ">
									<sf:select path="revisor.tipoDoc"
										items="${dataForm.catalogosSo.tipoIdRev}"
										referenceData="${dataForm.catalogosSo.tipoIdRev}"
										class="col-md-2  inputdropdown" />
								</div>
							</td>
							<td>
								<div class="form-group ">
									<sf:input path="revisor.numDoc" value="${revisor.numDoc}"
										readonly="true" class="col-md-5 col-md-offset-5 inputtextnew"
										aria-required="true" maxlength="30" size="30"
										disabled="disabled" type="text" />
									<!-- 								<input id="numeroId" name="gnumeroId" class="col-md-5 col-md-offset-5 inputtextnew"									aria-required="true" type="text" value="" maxlength="240"> -->
								</div>
							</td>
							<td>
								<div class="form-group ">
									<sf:input path="revisor.nombres" value="${revisor.nombre}"
										readonly="true" class="col-md-5 col-md-offset-1 inputtextnew"
										aria-required="true" maxlength="30" size="30"
										disabled="disabled" type="text" />

									<!-- 									<input id="nombre" name="nombre"										class="col-md-5 col-md-offset-1 inputtextnew"										aria-required="true" type="text" value="" maxlength="240"> -->
								</div>
							</td>
							<td>
								<div class="form-group ">
									<button class="boton" type="button">
										<spring:theme
											code="impuestos.decGasolina.InformacionFirma.Firma" />
									</button>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</sf:form>

<div class="row"></div>

<div class="row"></div>
