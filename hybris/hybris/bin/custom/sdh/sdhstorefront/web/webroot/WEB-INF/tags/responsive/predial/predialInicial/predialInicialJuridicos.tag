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
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.table.chip" /></label> <input id="chip" name=""
						class="newalto form-control areaterreno" disabled type="text"
						value="" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predial.inicial.juridicos.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.juridicos.tipdoc" /></label> <input id="" name=""
						class="newalto form-control areaterreno tipdocPredial" disabled type="text"
						value="" maxlength="240" id="tipdocPredial"></input>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.juridicos.nomcom" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.juridicos.propiedad" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.juridicos.numdoc" /></label> <input id="" name=""
						class="newalto form-control areaterreno" disabled type="text"
						value="" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.juridicos.calsuj" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.juridicos.otros" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>

		</div>
	</form:form>
</div>



