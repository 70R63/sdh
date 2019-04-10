<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="avisoheadline " style="width: auto; height: 35px;">
				<h2>
					<span class="p"><spring:theme
							code="retenedor.registro.inicial.titulo" /></span>
				</h2>
			</div>
			<p class="avisobody" style="width: auto; height: auto;">
				<spring:theme code="retenedor.registro.inicial.descrip" />
			</p>
		</div>
	</div>


	<form:form action="">
		<div class="row" style="margin-top: 40px;">
			<div class="col-md-12">
				<div class="form-group text-center">
					<label class="control-label"><spring:theme
							code="retenedor.registro.inicial.nota" /></label>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 40px;">
			<div class="col-md-6" style="text-align: center !important">
				<label class="control-label" style="text-align: center !important"><spring:theme
						code="retenedor.registro.inicial.registro" /></label>
				<hr
					style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;">
				<div class="form-group">
					<label class="control-label" style="text-align: center !important"><spring:theme
							code="retenedor.registro.inicial.descarga" /></label>
				</div>
				<div class="form-group">
					<button class="btn btn-primary"
						style="text-align: center !important" type="button">
						<spring:theme code="retenedor.registro.inicial.descargar" />
					</button>
				</div>
				<div class="form-group">
					<label class="control-label" style="text-align: center !important"><spring:theme
							code="retenedor.registro.inicial.agrega" /></label>
				</div>
				<div class="form-group">
					<label class="control-label" style="text-align: center !important"><spring:theme
							code="retenedor.registro.inicial.guarda" /></label>
				</div>
				<div class="form-group">
					<label class="control-label" style="text-align: center !important"><spring:theme
							code="retenedor.registro.inicial.adjunta" /></label>
				</div>
				<div class="form-group">
					<input type="file" class="form-control"
						id="exampleFormControlFile1" accept=".csv">
				</div>
			</div>

			<div class="col-md-6" style="text-align: center !important">
				<label class="control-label" style="text-align: center !important"><spring:theme
						code="retenedor.registro.inicial.devolucion" /></label>
				<hr
					style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;">
				<div class="form-group">
					<label class="control-label" style="text-align: center !important"><spring:theme
							code="retenedor.registro.inicial.devolporrete" /></label>
				</div>
				<div class="form-group">
					<label class="control-label" style="text-align: center !important"><spring:theme
							code="retenedor.registro.inicial.devoldescarga" /></label>
				</div>
				<div class="form-group">
					<button class="btn btn-primary"
						style="text-align: center !important" type="button">
						<spring:theme code="retenedor.registro.inicial.devoldescargar" />
					</button>
				</div>
				<div class="form-group" style="margin-top: 5px">
					<label class="control-label" style="text-align: center !important"><spring:theme
							code="retenedor.registro.inicial.delfina" /></label>
				</div>
				<div class="form-group" style="margin-top: 55px">
					<input type="file" class="form-control"
						id="exampleFormControlFile1" accept=".csv">
				</div>
			</div>
		</div>
		<div class="row text-center">
			<div class="col-md-6 text-center">
				<button class="btn btn-primary"
					style="text-align: center !important" type="submit">
					<spring:theme code="retenedor.registro.inicial.actualizar" />
				</button>
			</div>
			<div class="col-md-6 text-center">
				<button class="btn btn-primary"
					style="text-align: center !important" type="submit">
					<spring:theme code="retenedor.registro.inicial.consulta" />
				</button>
			</div>
		</div>
	</form:form>
</div>
