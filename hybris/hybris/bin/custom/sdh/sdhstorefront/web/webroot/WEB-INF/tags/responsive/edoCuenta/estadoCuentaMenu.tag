<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />


<c:set var="claveImpuesto_1" value="false"/>
<c:set var="claveImpuesto_2" value="false"/>
<c:set var="claveImpuesto_3" value="false"/>
<c:set var="claveImpuesto_4" value="false"/>
<c:set var="claveImpuesto_5" value="false"/>
<c:set var="claveImpuesto_6" value="false"/>
<c:set var="claveImpuesto_7" value="false"/>

<c:if test="${not empty ctaForm.predial}">
<c:set var="claveImpuesto_1" value="true"/>
</c:if>
<c:if test="${not empty ctaForm.tablaVehicular}">
<c:set var="claveImpuesto_2" value="true"/>
</c:if>
<c:if test="${not empty ctaForm.tablaICA}">
<c:set var="claveImpuesto_3" value="true"/>
</c:if>
<c:if test="${not empty ctaForm.tablaPublicidad}">
<c:set var="claveImpuesto_4" value="true"/>
</c:if>
<c:if test="${not empty ctaForm.tablaGasolina}">
<c:set var="claveImpuesto_5" value="true"/>
</c:if>
<c:if test="${not empty ctaForm.tablaDelineacion}">
<c:set var="claveImpuesto_6" value="true"/>
</c:if>
<c:if test="${not empty ctaForm.obligNoTributaria}">
<c:set var="claveImpuesto_7" value="true"/>
</c:if>


<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="edocuenta.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="edocuenta.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								informaci&oacuten.</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="headline">
			<h2>
				<span><spring:theme code="edocuenta.inicial.titulo" /></span>

			</h2>
		</div>
	</div>


	<sf:form>
		<div class="row mt-md-3">


			<div class="col-md-6">
				<div class="card cardsinfondo">
				<div class="row">
						<div class="col-md-7">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.nom" /></label> <input class="alto form-control"
									maxlength="30" size="30" disabled="disabled" type="text"
									value="<c:out value="${ctaForm.compleName}"></c:out>" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.tipiden" /></label> <input
									class="newalto form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value="${ctaForm.tipoDoc}"></c:out>" />
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.numiden" /></label> <input
									class="newalto form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value="${ctaForm.numDoc}"></c:out>" />
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.fecgen" /></label> <input
									class="newalto form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value="${ctaForm.fechageneracion}"></c:out>" />
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.tasint" /></label> <input
									class="newalto form-control" maxlength="30" size="30"
									disabled="disabled" type="text"
									value="<c:out value="${ctaForm.tasaInteres}"></c:out>" />
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="col-md-3">
				<div class="card cardsinfondo">
					<div class="row">
						<div class="col-md-10" id="idImpuesto" style="display: none;">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.selcimpuesto" /></label> <select
									id="impuesto" class="new_alto form-control " name="impuesto">
									<option value="0">Todo</option>
									<c:if test="${claveImpuesto_1}"><option value="1"><spring:theme code="edocuenta.inicial.impuestos.0001"/></option></c:if>
									<c:if test="${claveImpuesto_2}"><option value="2"><spring:theme code="edocuenta.inicial.impuestos.0002"/></option></c:if>
									<c:if test="${claveImpuesto_3}"><option value="3"><spring:theme code="edocuenta.inicial.impuestos.0003"/></option></c:if>
									<c:if test="${claveImpuesto_4}"><option value="4"><spring:theme code="edocuenta.inicial.impuestos.0004"/></option></c:if>
									<c:if test="${claveImpuesto_5}"><option value="5"><spring:theme code="edocuenta.inicial.impuestos.0005"/></option></c:if>
									<c:if test="${claveImpuesto_6}"><option value="6"><spring:theme code="edocuenta.inicial.impuestos.0006"/></option></c:if>
									<c:if test="${claveImpuesto_7}"><option value="7"><spring:theme code="edocuenta.inicial.impuestos.0007"/></option></c:if>
								</select>
							</div>
						</div>
						<div class="col-md-10" id="idImpuestoAgente" style="display: none;">
							<div class="form-group">
								<label class="control-label"><spring:theme
										code="edocuenta.inicial.selcimpuesto" /></label> <select
									id="impuesto" class="new_alto form-control " name="impuesto">
									<option value="8">RETEICA</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
		    <div class="col-md-3">
				<button type="button" class="btn btn-secondary btn-lg" id="action"
					name="action" value="cancelar" style="margin-top: 3px"
					onclick="window.location.href ='<c:url value='/contribuyentes' />';">
					<spring:theme code="obligacion.inicial.cancelar" />
				</button>

			</div>			
			<div class="col-md-3" style="display: none;" id="btnBuscar">
				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="buscar" style="margin-top: 3px"
						onclick=" Selectedver(this)">
						<spring:theme code="obligacion.inicial.buscar" />
					</button>

				</div>
			</div>			
		</div>
	</sf:form>
</div>

<script type="text/javascript">
	function Selected(selectObject) {
		var value = selectObject.value;
		document.getElementById("impuesto").value = value;
	}

	</script>

