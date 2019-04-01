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
							code="ica.declaracion.liquidacion.titulo" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row mt-3">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.valtot" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.dedexeact" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.valexe" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totinnetos" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.sanciones" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.impincom" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.intmora" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.impavtableros" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.acteco" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totimpcar" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totinord" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.valret" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totinobte" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totsaldo" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totinbrut" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totpag" /></label> <input disabled
								id="" name="" class="form-control" disabled type="text" value=""
								maxlength="240"></input>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.devrebdes" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="ica.declaracion.liquidacion.totpagvol" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<button style="margin-top: 3px;" id=""
							class="btn btn-primary btn-lg" type="button">
							<spring:theme code="ica.declaracion.liquidacion.calcular" />
						</button>
					</div>
				</div>



			</form:form>
		</div>
	</div>
</div>
