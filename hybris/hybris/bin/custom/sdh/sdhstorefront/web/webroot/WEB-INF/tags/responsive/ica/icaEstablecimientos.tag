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
							code="ica.inicial.estableci.title" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>

<br>
<form:form action="">

	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table table-bordered" id="example">
					<thead style="background-color: rgb(235, 235, 228) !important">
						<tr>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.nomesta" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.direc" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.loca" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.matesta" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.fecdesde" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.edomat" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.inicial.estableci.fechasta" /></label></td>
							<td><label class="control-label text-capitalize !important" style="width: 94px !important;"><spring:theme
										code="ica.inicial.estableci.valactivo" /></label></td>
							<td><label class="control-label text-capitalize !important" style="width: 84px !important;"><spring:theme
										code="ica.inicial.estableci.cantperso" /></label></td>
							<td><label class="control-label text-capitalize !important" style="width: 84px !important;"><spring:theme
										code="ica.inicial.estableci.codpost" /></label></td>
							<td><label class="control-label text-capitalize !important" style="width: 84px !important;"><spring:theme
										code="ica.inicial.estableci.ciiu" /></label></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="loop" items="${icaInfObjetoFormResp.icaInfObjetoResponse.establecimientos}"
									var="eachEstablecimientos">
							<tr>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.nombre}"
									type="text" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.direccion}"
									type="text" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.localidad}"
									type="text" style="width: 104px !important;" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.matricula}"
									type="text" style="width: 104px !important;"/></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.fechaDesde}"
									type="text" style="width: 90px !important;" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.estadoMatricula}"
									type="text" style="width: 104px !important;"/></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.fechaHasta}"
									type="text" style="width: 90px !important;"/></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.valorActivo}"
									type="text"  style="width: 94px !important;"/></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.cantPersonal}"
									type="text" style="width: 84px !important;"/></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.codPostal}"
									type="text" style="width: 84px !important;"/></td>
								<td><input class="inputtextnew" disabled="disabled"
									value="${eachEstablecimientos.ciiu}"
									type="text" style="width: 80px !important;" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</form:form>

