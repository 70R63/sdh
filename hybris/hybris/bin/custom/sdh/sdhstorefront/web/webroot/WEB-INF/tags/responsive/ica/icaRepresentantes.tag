<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.inicial.representantes.title" /></span>
				</h2>
			</div>
		</div>
	</div>
	
		
	<br>
	<form:form action="">
		<div class="row text-center">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table" id="example">
						<thead>
							<tr>

								<td><label class="control-label labeltabletd tabletiprela"><spring:theme
											code="ica.inicial.representantes.tiprela" /></label></td>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="ica.inicial.representantes.tipiden" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="ica.inicial.representantes.numide" /></label></td>
								<td><label class="control-label labeltabletd"><spring:theme
											code="ica.inicial.representantes.nombre" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.representantes.fecdesde" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.representantes.fechasta" /></label></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach
								items="${icaInfObjetoFormResp.icaInfObjetoResponse.relaciones}"
								var="eachRelation">
								<c:if test="${not empty eachRelation.tipoRelacion }">
									<tr>
										<td><input class="inputtextnew tabletiprela"
											disabled="disabled" value="${eachRelation.tipoRelacion}"
											type="text" style="width: 303px;" /></td>
										<td><input class="inputtextnew tableident"
											disabled="disabled" value="${eachRelation.tipoDoc}"
											type="text" style="visibility: visibility !important" /></td>
										<td><input class="inputtextnew tablenumiden"
											disabled="disabled" value="${eachRelation.numDoc}"
											type="text" style="text-align: center" /></td>
										<td><input class="inputtextnew" disabled="disabled"
											value="${eachRelation.nombre}" type="text" /></td>
										<td><input class="inputtextnew tablefechas"
											disabled="disabled" value="${eachRelation.fechaDesde}"
											type="text" /></td>
										<td><input class="inputtextnew tablefechas"
											disabled="disabled" value="${eachRelation.fechaHasta}"
											type="text" /></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row" style="marging-top: 5px">
			<div class="col-md-3 centercol-md-8 text-center">

				<button style="margin-top: 3px;" id="regresar"
					class="btn btn-secondary btn-lg"
					onclick="goBack()"
					type="button">
					<spring:theme code="ica.inicial.representantes.regresar" />
				</button>
				<%-- 				<button style="margin-top: 3px;" id="" onclick="window.location.href ='<c:url value='/contribuyentes/ica/declaracion?anoGravable=${fn:substring(icaInfObjetoFormResp.icaInfObjetoResponse.fechaIniAct,0,4)}&numObjeto=${numObjeto}' />';" --%>
				</div>
				<div class="col-md-6">
				<button style="margin-top: 3px;" id=""
					onclick="window.location.href ='<c:url value='/contribuyentes/ica/declaracion?&numObjeto=${numObjeto}' />';"
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="ica.inicial.representantes.presendecla" /><span class="badge badge-light" style="background: transparent; color: #000000; font-size: 16px;">vigencia actual</span>
				</button>
			</div>
		</div>
			<div class="row">
			<div class="col-md-12" style="background: #d2d2d2; margin-top: 20px !important;">
				<label class="control-label "><spring:theme
						code="ica.inicial.representantes.nota1" /></label>
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="ica.inicial.representantes.nota2" /></label>
				</div>
			</div>
		</div>
	</form:form>
</div>