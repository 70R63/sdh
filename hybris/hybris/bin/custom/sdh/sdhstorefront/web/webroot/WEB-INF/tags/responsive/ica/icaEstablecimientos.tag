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
			<div class="hwomargin headline">
				<h2>
					<span class="hwomargin"><spring:theme
							code="ica.inicial.estableci.title" /></span>
				</h2>
			</div>
		</div>
	</div>


	<br>
	<form:form action="" style="padding-left: 0px !important">

		<div class="row">
			<div class="col-md-12 tableamplia">
				<div class="table-responsive">
					<table class="table table-bordered" id="example">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd"><spring:theme
											code="ica.inicial.estableci.nomesta" /></label></td>
								<td><label class="control-label labeltabletd"><spring:theme
											code="ica.inicial.estableci.direc" /></label></td>
								<td><label class="control-label labeltabletd"><spring:theme
											code="ica.inicial.estableci.loca" /></label></td>
								<td><label class="control-label labeltabletd tablecodpost"><spring:theme
											code="ica.inicial.estableci.matesta" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.estableci.fecdesde" /></label></td>
								<td><label class="control-label labeltabletd tabledomatri"><spring:theme
											code="ica.inicial.estableci.edomat" /></label></td>
								<td><label class="control-label labeltabletd tablefechas"><spring:theme
											code="ica.inicial.estableci.fechasta" /></label></td>
								<td><label
									class="control-label labeltabletd tablecantperoc"><spring:theme
											code="ica.inicial.estableci.valactivo" /></label></td>
								<td><label
									class="control-label labeltabletd tablecantperoc"><spring:theme
											code="ica.inicial.estableci.cantperso" /></label></td>
								<td><label class="control-label labeltabletd tablecodpost"><spring:theme
											code="ica.inicial.estableci.codpost" /></label></td>
								<td><label class="control-label labeltabletd inputcodciuu"><spring:theme
											code="ica.inicial.estableci.ciiu" /></label></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="loop"
								items="${icaInfObjetoFormResp.icaInfObjetoResponse.establecimientos}"
								var="eachEstablecimientos">
								<tr>
									<td><input class="inputtextnew" disabled="disabled"
										value="${eachEstablecimientos.nombre}" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="${eachEstablecimientos.direccion}" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="${eachEstablecimientos.localidad}" type="text"
										style="width: 104px !important;" /></td>
									<td><input class="inputtextnew tablecodpost"
										disabled="disabled" value="${eachEstablecimientos.matricula}"
										type="text" style="width: 104px !important;" /></td>
									<td><input class="inputtextnew tablefechas"
										disabled="disabled" value="${eachEstablecimientos.fechaDesde}"
										type="text" /></td>
									<td><input class="inputtextnew tabledomatri"
										disabled="disabled"
										value="${eachEstablecimientos.estadoMatricula}" type="text" /></td>
									<td><input class="inputtextnew tablefechas"
										disabled="disabled" value="${eachEstablecimientos.fechaHasta}"
										type="text" /></td>
									<td><input class="inputtextnew tablecantperoc"
										disabled="disabled"
										value="${eachEstablecimientos.valorActivo}" type="text" /></td>
									<td><input class="inputtextnew tablecantperoc"
										disabled="disabled"
										value="${eachEstablecimientos.cantPersonal}" type="text" /></td>
									<td><input class="inputtextnew tablecodpost"
										disabled="disabled" value="${eachEstablecimientos.codPostal}"
										type="text" /></td>
									<td><input class="inputtextnew inputcodciuu"
										disabled="disabled" value="${eachEstablecimientos.ciiu}"
										type="text" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</form:form>
</div>

