<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<form:form>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predialocho.liquidacionpriv.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.valimp" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.descuento" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.impajustado" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.sancion" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.saldo" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.valpagar" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.intereses" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predialocho.liquidacionpriv.totpag" /></label> <input id=""
						name="" class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="predialocho.liquidacionpriv.calcular" />
				</button>
			</div>
		</div>
	</div>
</form:form>

