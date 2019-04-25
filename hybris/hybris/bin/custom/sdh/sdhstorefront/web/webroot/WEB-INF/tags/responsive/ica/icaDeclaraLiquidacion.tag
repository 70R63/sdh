<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<form:form action="">
		<br>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinord" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totobfuerabogo" /></label> <input
						disabled id="" name="" class="form-control" disabled type="text"
						value="" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinbrut" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.devrebdes" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.dedexeact" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totinnetos" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.sanciones" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.impincom" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: capitalize !important"><spring:theme
							code="ica.declaracion.liquidacion.impavtableros" /> </label> <label
						class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;">
						Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
						No
					</label>
				</div>

			</div>
			<div class="col-md-5">
				<div class="form-group">
					<input disabled id="" name="" class="form-control" disabled
						type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valtot" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totimpcar" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valret" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totsaldo" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.valpag" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>




			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.intmora" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpag" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>

			<div class="col-md-5">
				<label class="form-check-label"
					style="text-transform: capitalize !important"><spring:theme
						code="ica.declaracion.liquidacion.aportvol" /> </label>
				<div class="form-check">
					<label class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important;">
						Si
					</label> <label class="form-check-label"
						style="text-transform: capitalize !important"> <input
						type="radio" name="aporte" id="" class="form-check-input mr-2"
						style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
						No
					</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="ica.declaracion.liquidacion.totpagvol" /></label> <input disabled
						id="" name="" class="form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

	</form:form>
</div>

