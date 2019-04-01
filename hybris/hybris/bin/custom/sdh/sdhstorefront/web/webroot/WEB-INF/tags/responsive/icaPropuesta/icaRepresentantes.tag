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
							code="ica.propuesta.representantes.title" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>

<form:form action="">
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.propuesta.representantes.tipiden" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.propuesta.representantes.numide" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.propuesta.representantes.nombre" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.propuesta.representantes.tiprela" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.propuesta.representantes.fecdesde" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.propuesta.representantes.fechasta" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" style="visibility: visibility !important" size="auto" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
							<td><input class="inputtextnew" disabled="disabled"
								type="text" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="row" style="marging-top: 5px">
		<div class="col-md-12 centercol-md-8 text-center">

			<button style="margin-top: 3px;" id="regresar"
				class="btn btn-primary btn-lg"
				onclick="window.location.href ='<c:url value='/' />';" type="button">
				<spring:theme code="ica.propuesta.representantes.regresar" />
			</button>
			<button style="margin-top: 3px;" id="" class="btn btn-primary btn-lg"
				type="button">
				<spring:theme code="ica.propuesta.representantes.presendecla" />
			</button>
			<button style="margin-top: 3px;" id="" class="btn btn-primary btn-lg"
				type="button">
				<spring:theme code="ica.propuesta.representantes.rop" />
			</button>

		</div>
	</div>
	</div>
</form:form>