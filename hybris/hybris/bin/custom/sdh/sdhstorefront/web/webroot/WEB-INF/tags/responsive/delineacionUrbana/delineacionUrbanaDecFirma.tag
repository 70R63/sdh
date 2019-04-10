<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h3>
				<span><spring:theme code="delineacion.urbana.dec.firm.title" /></span>
			</h3>
		</div>
	</div>

	<form:form>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.firm.tipiden" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="" maxlength="240">
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.firm.numide" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="" maxlength="240">
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.firm.nombraz" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						value="" maxlength="240" disabled>
				</div>
			</div>
		</div>



		<br>
		<div class="container">
			<div class="row">

				<div class=" col-md-3">
					<button type="button" class="btn btn-primary btn-lg"
						id="regresarButton" name="" value="regresar" onclick="goBack()">
						<spring:theme code="delineacion.urbana.dec.firm.regresar" />
					</button>
				</div>

				<div class=" col-md-3">
					<button type="submit" class="btn btn-primary btn-lg" id="" name=""
						value="calcular">
						<spring:theme code="delineacion.urbana.dec.firm.cancelar" />
					</button>
				</div>

				<div class="col-md-3">
					<button type="submit" class="btn btn-primary btn-lg" id="" name=""
						value="calcular">
						<spring:theme code="delineacion.urbana.dec.firm.predec" />
					</button>
				</div>

				<div class="col-md-3">
					<button type="submit" class="btn btn-primary btn-lg" id="" name=""
						value="calcular">
						<spring:theme code="delineacion.urbana.dec.firm.paglin" />
					</button>
				</div>
			</div>
		</div>

	</form:form>
</div>

