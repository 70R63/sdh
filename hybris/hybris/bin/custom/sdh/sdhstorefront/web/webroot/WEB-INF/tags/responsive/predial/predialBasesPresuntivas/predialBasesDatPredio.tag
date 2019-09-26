<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<form:form>
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predial.basespresun.datospredio.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datospredio.areterreno" /></label> <input id="areaterreno"
						name="areaterreno" class="newalto form-control areaterreno" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datospredio.areaconstru" /></label> <input id="areaconstruccion"
						name="areaconstruccion" class="newalto form-control areaconstruccion" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datospredio.caracpredio" /></label> <select id=""
						name="" class="newalto form-control"><option>Seleccionar</option></select>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datospredio.prophorizon" /></label> <select id="prophorizontal"
						name="prophorizontal" class="newalto form-control prophorizontal"><option>Seleccionar</option>
						<option value="Si">Si</option>
						<option value="No">No</option></select>
				</div>
			</div>
		</div>
			<div class="row">
			<div class="col-md-3">
				<button style="margin-top: 3px;" id="buttonPrecalculo"
					class="btn btn-primary btn-lg buttonPrecalculo" type="button">
					<spring:theme code="predial.basespresun.datospredio.precalculo" />
				</button>
			</div>
		</div>
	</form:form>
</div>



