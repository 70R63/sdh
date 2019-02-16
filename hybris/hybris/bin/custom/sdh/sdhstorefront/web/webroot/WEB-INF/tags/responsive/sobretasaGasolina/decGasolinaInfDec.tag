<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url
	value="/contribuyentes/sobretasa-gasolina/declaracion-gasolina"
	var="presentarDeclaracionUrl" htmlEscape="false" />


<div class="row">
	<div class="col-md-6">
		<div class="hieadline">
			<h2>
				<span tabindex="0"><spring:theme
						code="impuestos.decGasolina.InformacionDec.titulo" /></span>
			</h2>
		</div>
	</div>
</div>


<div class="col-md-9">
	<div>
		<div class="col-md-12">
			<table class="table col-md-2 table-bordered">
				<thead>
					<tr>
						<td><label
							class="control-label text-capitalize !important"><spring:theme
									code="impuestos.decGasolina.InformacionDec.claseProducto" /></label></td>
						<td><label
							class="col-md-offset-1 control-label text-capitalize !important"><spring:theme
									code="impuestos.decGasolina.InformacionDec.galones" /></label></td>
						<td><label
							class="control-label text-capitalize !important"><spring:theme
									code="impuestos.decGasolina.InformacionDec.preciosReferencia" /></label></td>
						<td><label
							class="col-md-4 control-label text-capitalize !important"><spring:theme
									code="impuestos.decGasolina.InformacionDec.porcentajeAlcohol" /></label></td>
						<td><label
							class="control-label text-capitalize !important"><spring:theme
									code="impuestos.decGasolina.InformacionDec.baseGravable" /></label></td>
						<td><label
							class="control-label text-capitalize !important"><spring:theme
									code="impuestos.decGasolina.InformacionDec.valorSobretasa" /></label></td>
					</tr>
					<tr></tr>
				</thead>
				<tbody>
					<c:forEach items="${dataForm.dataForm.infoDeclara}" var="info"
						varStatus="loop">
						 <tr>
							 <td><div class="col-md-12">
									 <sf:select path="dataForm.infoDeclara[${loop.index}].claseProd"
										 items="${dataForm.catalogosSo.claseProd}"
										 referenceData="${dataForm.catalogosSo.claseProd}"
										 cssClass="form-control-gasolina"  maxlength="10"/>
								 </div></td>
							 <td><div class="col-md-12">
									 <sf:input path="dataForm.infoDeclara[${loop.index}].galonesGra"
										 value="${info.galonesGra}" class="form-control form-control"
										 maxlength="30" size="20"  />
								 </div></td>
							<td><div class="col-md-12">
									<sf:input path="dataForm.infoDeclara[${loop.index}].precioRef"
										value="${info.precioRef}" class="form-control form-control"
										maxlength="30" size="20" readonly="true" />
								</div></td>
							<td><div class="col-sm-12">
									<sf:select
										path="dataForm.infoDeclara[${loop.index}].alcoholCarbu"
										items="${dataForm.catalogosSo.alcoholCarbu}"
										referenceData="${dataForm.catalogosSo.alcoholCarbu}"
										class="form-control" />
								</div></td>
							<td><div class="col-md-12">
									<sf:input
										path="dataForm.infoDeclara[${loop.index}].baseGravable"
										value="${info.baseGravable}" class="form-control form-control"
										maxlength="30" size="20" readonly="true" />
								</div></td>
							<td><div class="col-md-12">
									<sf:input
										path="dataForm.infoDeclara[${loop.index}].vlrSobretasa"
										value="${info.vlrSobretasa}" class="form-control form-control"
										maxlength="30" size="20" readonly="true" />
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<br>
<br>
<div class="row">
	<div class="col-md-12 col-md-offset-4">
		<div class="form-group ">
			<sf:button action="${presentarDeclaracionUrl}" type="submit"
				class="btn btn-primary btn-lg" id="action" name="action"
				value="calcular">
				<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" />
			</sf:button>
		</div>
	</div>
</div>

<div class="row"></div>