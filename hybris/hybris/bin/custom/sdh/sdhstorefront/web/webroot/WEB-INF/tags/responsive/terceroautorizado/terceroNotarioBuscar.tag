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
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="terceros.notario.buscar.tipdoc" /></label> <select id="" name=""
					class="newalto form-control"><option>Seleccionar</option></select>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="terceros.notario.buscar.numdoc" /></label> <input id="" name=""
					class="newalto form-control" type="text" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="terceros.notario.buscar.impuesto" /></label> <select id="" name=""
					class="newalto form-control"><option>Todos</option></select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<button type="button" class="btn btn-primary btn-lg" id="" name=""
				value="Buscar" onclick="">
				<spring:theme code="terceros.sim.buscar.buscar" />
			</button>
		</div>
	</div>
</div>