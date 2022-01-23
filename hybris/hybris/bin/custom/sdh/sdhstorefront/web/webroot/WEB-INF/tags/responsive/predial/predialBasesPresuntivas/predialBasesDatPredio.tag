<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="disabledDatosPredio_boolean" value="false" />
<c:set var="disabledDatosPredio_text" value="" />
<c:if test="${predialFormbases.controlCampos.datosPredio == true}">
	<c:set var="disabledDatosPredio_boolean" value='true' />
	<c:set var="disabledDatosPredio_text" value="disabled" />
</c:if>
<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<form:form modelAttribute="predialFormbases">
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme code="predial.basespresun.datospredio.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme code="Uso de suelo" /></label> 
					<select class="newalto form-control" id="usoSuelo" onchange="actualizarCatalogos(this)" ${disabledDatosPredio_text}>
						<option value="">Seleccionar</option>
						<option value="0">Urbano</option>
						<option value="1">Rural</option>
					</select>
				</div>
			</div>
			<div class="col-md-2" id="destHacendario" style="display: block">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datliquidacion.destino" /></label> 
<%-- 					<form:select class="newalto form-control" id="DestinoHacendario" path="estrLiquidacionPredial.destinoHacendario" items="${predialFormbases.catalogos.destinoHacendario}" onclick="accionCat_destinoHacendario()" disabled="${disabledDatosPredio_boolean}" onchange="showHacendario(this)"></form:select> --%>
					<select class="newalto form-control" id="DestinoHacendario" onchange="actualizarCatalogos(this)" ${disabledDatosPredio_text}>
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.areterreno" /></label> 
					<input id="areaterreno" name="areaterreno" class="newalto form-control areaterreno" type="text" value="" maxlength="240" disabled/>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.areaconstru" /></label> 
					<input id="areaconstruccion" name="areaconstruccion" class="newalto form-control areaconstruccion" type="text" value="" maxlength="240" disabled />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme code="Actividad Ecónomica" /></label>
					<select class="newalto form-control" id="activEconomica" onchange="actualizarCatalogos(this)" ${disabledDatosPredio_text}>
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.prophorizon" /></label> 
					<select class="newalto form-control" id="propiedadHorizontal" onchange="actualizarCatalogos(this)" ${disabledDatosPredio_text}>
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme code="Base gravable calc." /></label> 
					<input id="baseGrav" name="baseGrav" class="newalto form-control" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme code="Tarifa" /></label> 
					<input id="tarifa" name="tarifa" class="newalto form-control" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.caracpredio" /></label>
					<form:select style="display: block" class="newalto form-control" id="caracterizacionPredio" path="estrDatosGenerales.caracterizacionPredio" items="${predialFormbases.catalogos.caracteri61}" disabled="${disabledDatosPredio_boolean}"></form:select>
					<form:select style="display: none" class="newalto form-control" id="caracterizacionPredio62" path="estrDatosGenerales.caracterizacionPredio" items="${predialFormbases.catalogos.caracteri62}" disabled="${disabledDatosPredio_boolean}"></form:select>
					<form:select style="display: none" class="newalto form-control" id="caracterizacionPredio65" path="estrDatosGenerales.caracterizacionPredio" items="${predialFormbases.catalogos.caracteri65}" disabled="${disabledDatosPredio_boolean}"></form:select>
					<form:select style="display: none" class="newalto form-control" id="caracterizacionPredio67" path="estrDatosGenerales.caracterizacionPredio" items="${predialFormbases.catalogos.caracteri67}" disabled="${disabledDatosPredio_boolean}"></form:select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme code="Confirmar BG final" /></label> 
					<input id="confirmBG" name="baseGrav" class="newalto form-control areaterreno" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<c:if test="${predialFormbases.controlCampos.datosPredio != true}">
						<button id="buttonPrecalculo" class="btn btn-primary btn-lg buttonPrecalculo" type="button" onclick="accionPreCalculo()">
							<spring:theme code="predial.basespresun.datospredio.precalculo" />
						</button>
					</c:if>
				</div>
			</div>
		</div>
	</form:form>
</div>

<script type="text/javascript">
	function actualizarCatalogos(objetoActualizado){
		var catActualizado = $(objetoActualizado).attr('id');
		
		switch(catActualizado){
			case "usoSuelo":
				$("#destHacendario").find("option:gt(0)").remove();
				$("#activEconomica").find("option:gt(0)").remove();
				$("#propiedadHorizontal").find("option:gt(0)").remove();
				actualizarCatalogosInferior(objetoActualizado);
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			case "DestinoHacendario":
				$("#activEconomica").find("option:gt(0)").remove();
				$("#propiedadHorizontal").find("option:gt(0)").remove();
				actualizarCatalogosInferior(objetoActualizado);
				actualizarObjetosHabilitados(objetoActualizado);
				accionCat_destinoHacendario()
				break;
			case "activEconomica":
				$("#propiedadHorizontal").find("option:gt(0)").remove();
				actualizarCatalogosInferior(objetoActualizado);
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			case "propiedadHorizontal":
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			default:
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			
		}
		
	}
	
	function actualizarCatalogosInferior(objetoActualizado){
		var catActualizado = $(objetoActualizado).attr('id');
		
		switch(catActualizado){
			case "usoSuelo":
				actualizarCatalogoDestinoHacendario($(objetoActualizado).val());
				break;
			case "DestinoHacendario":
				actualizarCatalogoActividadEconomica($(objetoActualizado).val());
				break;
			case "activEconomica":
				actualizarCatalogoPropiedadHorizontal($("#DestinoHacendario").val(),$(objetoActualizado).val());
				break;
			default:
				
				break;
		
		}
	}
	
	function actualizarObjetosHabilitados(objetoActualizado){
		var catActualizado = $(objetoActualizado).attr('id');
		var valActualizado = $(objetoActualizado).val();
	
		switch(catActualizado){
			case "usoSuelo":
				switch(valActualizado){
				case "0":
					$("#baseGrav").prop("disabled",true);
					break;
				case "1":
					$("#baseGrav").prop("disabled",false);
					break;
				default:
					$("#areaconstruccion").prop("disabled",true);
					$("#areaterreno").prop("disabled",true);
					break;
				}
				break;
			case "propiedadHorizontal":
				var destinoHacendario = $("#DestinoHacendario").val();
				switch(destinoHacendario){
					case "61":
					case "62":
					case "64":
					case "66":
						switch(valActualizado){
						case "1":
						case "2":
							$("#areaconstruccion").prop("disabled",false);
							$("#areaterreno").prop("disabled",false);
							break;
						default:
							$("#areaconstruccion").prop("disabled",true);
							$("#areaterreno").prop("disabled",true);
							break;
						}
						break;
					case "65":
						switch(valActualizado){
						case "1":
							$("#areaconstruccion").prop("disabled",false);
							break;
						default:
							$("#areaconstruccion").prop("disabled",true);
							$("#areaterreno").prop("disabled",true);
							break;
						}
						break;
					case "67":
						switch(valActualizado){
						case "2":
							$("#areaconstruccion").prop("disabled",false);
							$("#areaterreno").prop("disabled",false);
							break;
						default:
							$("#areaconstruccion").prop("disabled",true);
							$("#areaterreno").prop("disabled",true);
							break;
						}
						break;
	
					default:
						$("#areaconstruccion").prop("disabled",true);
						$("#areaterreno").prop("disabled",true);
						break;
				}
				break;
			default:
				$("#areaconstruccion").prop("disabled",true);
				$("#areaterreno").prop("disabled",true);
				break;
		
		}
	}
	
	function actualizarCatalogoPropiedadHorizontal(idDestinoHacendario, idActividadEconomica){
		var idObjetoActualizar = "#propiedadHorizontal";
		
		switch(idActividadEconomica){
			case "":
				break;
			default:
				for(var i=0;i<cat_predial_propiedadHorizontal.length;i++){
					if(cat_predial_propiedadHorizontal[i].destinoHacendario == idDestinoHacendario && cat_predial_propiedadHorizontal[i].actividadEconomica == idActividadEconomica){
						$(idObjetoActualizar).append('<option value="'+ cat_predial_propiedadHorizontal[i].itemId +'">'+ cat_predial_propiedadHorizontal[i].itemValue + "</option>");
					}
				}
				break;
		}
	}
	
	function actualizarCatalogoDestinoHacendario(idSeleccionado){
		var idObjetoActualizar = "#DestinoHacendario";
		
		switch(idSeleccionado){
			case "":
				break;
			default:
				for(var i=0;i<cat_predial_destinoHacendario.length;i++){
					if(cat_predial_destinoHacendario[i].usoSuelo == idSeleccionado){
						$(idObjetoActualizar).append('<option value="'+ cat_predial_destinoHacendario[i].itemId +'">'+ cat_predial_destinoHacendario[i].itemValue + "</option>");
					}
				}
				break;
		}
	}
	
	function actualizarCatalogoActividadEconomica(idSeleccionado){
		var idObjetoActualizar = "#activEconomica";
		
		switch(idSeleccionado){
			case "":
				break;
			default:
				for(var i=0;i<cat_predial_actividadEconomica.length;i++){
					if(cat_predial_actividadEconomica[i].destinoHacendario == idSeleccionado){
						$(idObjetoActualizar).append('<option value="'+ cat_predial_actividadEconomica[i].itemId +'">'+ cat_predial_actividadEconomica[i].itemValue + "</option>");
					}
				}
				break;
		}
	}
	
	
	function accionPreCalculo(){
		
		var numBP = $('#numBP').val();
		var chip = $('#chip').val();
		var anioGravable = $('#anioGravable').val();
		var areaConstruida = $('#areaconstruccion').val();
		var areaTerrenoCatastro = $('#areaterreno').val();
		var caracterizacionPredio = $('#caracterizacionPredio').val();
		var propiedadHorizontal = $('#propiedadHorizontal').val();
		var destinoHacendario = $('#DestinoHacendario').val();
		var actividadEconomica = $('#activEconomica').val();
		
		ACC.predial.ejecutarPreCalculoPB(numBP,chip,anioGravable,areaConstruida,areaTerrenoCatastro,caracterizacionPredio, propiedadHorizontal, destinoHacendario,actividadEconomica);
		
	}
	
	function accionCat_destinoHacendario(){
		$("#caracterizacionPredio").find("option:gt(0)").remove();	
		if($("#DestinoHacendario").val() != null){
			for(var i=0;i<cat_predial_caracterizacionPredio.length;i++){
				if(cat_predial_caracterizacionPredio[i].destinoHacendario == $("#DestinoHacendario").val()){
					$('#caracterizacionPredio').append('<option value="'+ cat_predial_caracterizacionPredio[i].itemId +'">'+ cat_predial_caracterizacionPredio[i].itemValue + "</option>");
				}
			}		
		}
	}
</script>

