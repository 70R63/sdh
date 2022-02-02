<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="disabledLiquidacion" value="" />
<c:if test="${predialFormbases.controlCampos.liquidacion == true}">
	<c:set var="disabledLiquidacion" value='disabled="disabled"' />
</c:if>
<spring:htmlEscape defaultHtmlEscape="true" />
<form:form>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predial.basespresun.datliquidacion.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datliquidacion.porcepropiedad" /></label> <input
						id="" name="" class="newalto form-control" disabled type="text"
						value="${predialFormbases.datosJuridicos.porcentajePropiedad}" maxlength="240"></input><label class="control-label"><spring:theme
							code="%" /></label>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datliquidacion.calidad" /></label> <input
						id="" name="" class="newalto form-control" disabled type="text"
						value="${predialFormbases.desCalidad}" maxlength="240"></input>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datliquidacion.basegrav" /></label> <input
						id="basegrav" name="basegrav" class="newalto form-control valFormatoImporte" type="text" value="${predialFormbases.estrLiquidacionPredial.baseGravable}"
						maxlength="240" ${disabledLiquidacion} onchange="basegrav_val(this)"></input>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.basespresun.datliquidacion.tarliqui" /></label> <input
						id="Tarifa_liquidacion" name="" class="newalto form-control" disabled type="text"
						value="${predialFormbases.estrLiquidacionPredial.tarifaLiquidacion}" maxlength="240"></input>
				</div>
			</div>
		</div>
	</div>
</form:form>



<script type="text/javascript">

function basegrav_val(objeto){
	
	$('#BaseGravable').val($('#basegrav').val());
	
}
</script>
