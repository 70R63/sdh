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
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.usoSuelo" /></label> 
					<select class="newalto form-control" id="usoSuelo" onchange="actualizarCatalogos(this)" ${disabledDatosPredio_text}>
						<option value="">Seleccionar</option>
						<option value="0">URBANO</option>
						<option value="1">RURAL</option>
						<option value="2">ZONA DE EXPANSIÓN O SUBURBANO</option>
					</select>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.caracpredio" /></label>
					<select class="newalto form-control" id="caracterizacionPredio" onchange="actualizarCatalogos(this)" disabled>
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datliquidacion.destino" /></label>
					<select class="newalto form-control" id="DestinoHacendario" onchange="actualizarCatalogos(this)" disabled>
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.areaconstru" /></label> 
					<input id="areaconstruccion" name="areaconstruccion" class="newalto form-control areaconstruccion" type="text" value="" maxlength="240" disabled />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.actividadEconomica" /></label>
					<select class="newalto form-control" id="activEconomica" onchange="actualizarCatalogos(this)" disabled>
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.areterreno" /></label> 
					<input id="areaterreno" name="areaterreno" class="newalto form-control areaterreno" type="text" value="" maxlength="240" disabled/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.prophorizon" /></label> 
					<select class="newalto form-control" id="propiedadHorizontal" onchange="actualizarCatalogos(this)" disabled>
						<option value="">Seleccionar</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.baseGravableCalc" /></label> 
					<input id="baseGrav" name="baseGrav" class="newalto form-control valFormatoImporte" disabled type="text" value="" maxlength="240" onchange="validarValorBaseGrav(this)"></input>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.confirmarBGF" /></label> 
					<input id="confirmBG" name="baseGrav" class="newalto form-control areaterreno" disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="predial.basespresun.datospredio.tarifa" /></label> 
					<input id="tarifa" name="tarifa" class="newalto form-control" disabled type="text" value="" maxlength="240"></input>
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

	<c:if test="${not empty predialFormbases.marcas}">
		<input type="hidden" id="ztipo_marca" value="${predialFormbases.marcas[0].tipoMarca}"/>
		<input type="hidden" id="zmarca" value="${predialFormbases.marcas[0].marca}"/>
	</c:if>
</div>

<script type="text/javascript">
	function actualizarCatalogos(objetoActualizado){
		var catActualizado = $(objetoActualizado).attr('id');
		
		switch(catActualizado){
			case "usoSuelo":
				$("#DestinoHacendario").find("option:gt(0)").remove();
				$("#activEconomica").find("option:gt(0)").remove();
				$("#propiedadHorizontal").find("option:gt(0)").remove();
				$("#caracterizacionPredio").find("option:gt(0)").remove();
				$("#areaconstruccion").val("");
				$("#areaterreno").val("");
				$("#baseGrav").val("");
				$("#confirmBG").val("");
				actualizarCatalogosInferior(objetoActualizado);
				actualizarObjetosHabilitados(objetoActualizado);
				mostrarMensajes(objetoActualizado);
				ACC.predial.visualizacionBasesDetalle(false);
				$(document).off("change", "#confirmBG", ACC.predial.validacionMonto_confirmBG );
				break;
			case "DestinoHacendario":
				$("#activEconomica").find("option:gt(0)").remove();
				$("#propiedadHorizontal").find("option:gt(0)").remove();
				$("#caracterizacionPredio").find("option:gt(0)").remove();
				$("#areaconstruccion").val("");
				$("#areaterreno").val("");
				actualizarCatalogosInferior(objetoActualizado);
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			case "activEconomica":
				$("#propiedadHorizontal").find("option:gt(0)").remove();
				$("#caracterizacionPredio").find("option:gt(0)").remove();
				$("#areaconstruccion").val("");
				$("#areaterreno").val("");
				actualizarCatalogosInferior(objetoActualizado);
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			case "propiedadHorizontal":
				$("#caracterizacionPredio").find("option:gt(0)").remove();
				$("#areaconstruccion").val("");
				$("#areaterreno").val("");
				actualizarCatalogosInferior(objetoActualizado);
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			case "caracterizacionPredio":
				$("#areaconstruccion").val("");
				$("#areaterreno").val("");
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			default:
				actualizarObjetosHabilitados(objetoActualizado);
				break;
			
		}
		
	}
	
	function actualizarCatalogosInferior(objetoActualizado){
		var catActualizado = $(objetoActualizado).attr('id');
		var valActualizado = $(objetoActualizado).val();
		
		switch(catActualizado){
			case "usoSuelo":
				actualizarCatalogoDestinoHacendario($(objetoActualizado).val());
				break;
			case "DestinoHacendario":
				var flagActualizarInferior = false;
				switch(valActualizado){
					case "70":
					case "72":
						flagActualizarInferior = validarMarca(valActualizado);
						break;
					default:
						flagActualizarInferior = true;
						break;
				}
				if(flagActualizarInferior){
					actualizarCatalogoActividadEconomica($(objetoActualizado).val());					
				}else{
					$(objetoActualizado).val("");
					alert("Sr. Contribuyente, este predio no ha sido reportado por la entidad competente como No Urbanizable. Por lo tanto, no se puede liquidar con ese destino hacendario.");			
				}
				break;
			case "activEconomica":
				actualizarCatalogoPropiedadHorizontal($(objetoActualizado).val());
				break;
			case "propiedadHorizontal":
				actualizarCatalogoCaracterizacionPredio($("#activEconomica").val());
				break;
			default:
				break;
		}
		
	}
	
	function actualizarObjetosHabilitados(objetoActualizado){
		var catActualizado = $(objetoActualizado).attr('id');
		var valActualizado = $(objetoActualizado).val();
		
		$("#DestinoHacendario").prop("disabled",true);
		$("#activEconomica").prop("disabled",true);
		$("#propiedadHorizontal	").prop("disabled",true);
		$("#caracterizacionPredio").prop("disabled",true);
		$("#areaterreno").prop("disabled",true);
		$("#areaconstruccion").prop("disabled",true);
		$("#baseGrav").prop("disabled",true);
		$("#confirmBG").prop("disabled",true);
		
	
		switch(catActualizado){
			case "usoSuelo":
				switch(valActualizado){
				case "0":
				case "1":
				case "2":
					$("#DestinoHacendario").prop("disabled",false);
					break;
				default:
					break;
				}
				break;
			case "DestinoHacendario":
				$("#DestinoHacendario").prop("disabled",false);
				switch(valActualizado){
					case "":
						break;
					default:
						var usoSuelo = $("#usoSuelo").val();
						switch(usoSuelo){
							case "0":
								$("#activEconomica").prop("disabled",false);			
								break;
							case "1":
							case "2":
								$("#baseGrav").prop("disabled",false);
								break;
							default:
								break;
						}						
						break;
				}
				break;
			case "activEconomica":
				$("#DestinoHacendario").prop("disabled",false);
				$("#activEconomica").prop("disabled",false);
				switch(valActualizado){
					case "":
						break;
					default:
						$("#propiedadHorizontal").prop("disabled",false);
				}
				break;
			case "propiedadHorizontal":
				$("#DestinoHacendario").prop("disabled",false);
				$("#activEconomica").prop("disabled",false);
				switch(valActualizado){
				case "":
					break;
				default:
					$("#propiedadHorizontal").prop("disabled",false);
					$("#caracterizacionPredio").prop("disabled",false);
				}
				break;
			case "caracterizacionPredio":
				$("#DestinoHacendario").prop("disabled",false);
				$("#activEconomica").prop("disabled",false);
				switch(valActualizado){
				case "":
					break;
				default:
					$("#propiedadHorizontal").prop("disabled",false);
					$("#caracterizacionPredio").prop("disabled",false);
					
					var activEconomica = $("#activEconomica").val();
					var propiedadHorizontal = $("#propiedadHorizontal").val();
					switch(activEconomica){
						case "1":
							switch(propiedadHorizontal){
								case "N":
									$("#areaterreno").prop("disabled",false);
									$("#areaconstruccion").prop("disabled",false);
									break;
								case "P":
									$("#areaconstruccion").prop("disabled",false);
									break;
							}
							break;
						case "3":
							switch(propiedadHorizontal){
								case "N":
									$("#areaterreno").prop("disabled",false);
									$("#areaconstruccion").prop("disabled",false);
									break;
								case "P":
									$("#areaconstruccion").prop("disabled",false);
									break;
							}
							break;
							
						case "10":
							switch(propiedadHorizontal){
								case "N":
									$("#areaterreno").prop("disabled",false);
									$("#areaconstruccion").prop("disabled",false);
									break;
								case "P":
									$("#areaconstruccion").prop("disabled",false);
									break;
							}
							break;
							
						case "48":
							switch(propiedadHorizontal){
								case "P":
									$("#areaconstruccion").prop("disabled",false);
									break;
							}
							break;
							
						case "12":
							switch(propiedadHorizontal){
								case "N":
									$("#areaterreno").prop("disabled",false);
									$("#areaconstruccion").prop("disabled",false);
									break;
								case "P":
									$("#areaconstruccion").prop("disabled",false);
									break;
							}
							break;
							
						case "2":
							switch(propiedadHorizontal){
								case "N":
									$("#areaterreno").prop("disabled",false);
									break;
							}
							break;
						default:
							break;
					}
				}
				break;
			default:
				break;
		}
		
	}
	
	function validarMarca(valActualizado){
		var flagValidacion = false;
		
		switch(valActualizado){
			case "70":
				if($("#ztipo_marca").val()=="5" && $("#zmarca").val()=="6"){
					flagValidacion = true;
				}
				break;
			case "72":
				if($("#ztipo_marca").val()=="5" && $("#zmarca").val()=="3"){
					flagValidacion = true;
				}
				break;
			default:
				flagValidacion = true;
				break;
		}
		
		return flagValidacion;
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
	
	function actualizarCatalogoPropiedadHorizontal(idActividadEconomica){
		var idObjetoActualizar = "#propiedadHorizontal";
		
		switch(idActividadEconomica){
			case "":
				break;
			default:
				for(var i=0;i<cat_predial_propiedadHorizontal.length;i++){
					if(cat_predial_propiedadHorizontal[i].actividadEconomica == idActividadEconomica){
						$(idObjetoActualizar).append('<option value="'+ cat_predial_propiedadHorizontal[i].itemId +'">'+ cat_predial_propiedadHorizontal[i].itemValue + "</option>");
					}
				}
				break;
		}
	}
	
	function actualizarCatalogoCaracterizacionPredio(idActividadEconomica){
		var idObjetoActualizar = "#caracterizacionPredio";
		
		switch(idActividadEconomica){
			case "":
				break;
			default:
				for(var i=0;i<cat_predial_caracterizacionPredio.length;i++){
					if(cat_predial_caracterizacionPredio[i].actividadEconomica == idActividadEconomica){
						$(idObjetoActualizar).append('<option value="'+ cat_predial_caracterizacionPredio[i].itemId +'">'+ cat_predial_caracterizacionPredio[i].itemValue + "</option>");
					}
				}
				break;
		}
	}
	
	function validarValorBaseGrav(objetoActualizado){
		if(parseInt($(objetoActualizado).val())<0){
			alert("El valor en base gravable calc. debe ser mayor a 0");
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
	
	function mostrarMensajes(objetoActualizado){
		var catActualizado = $(objetoActualizado).attr('id');
		var valActualizado = $(objetoActualizado).val();
		var mensaje = "";
		
		switch(catActualizado){
			case "usoSuelo":
				switch(valActualizado){
				case "1":
					mensaje = "Se\u00F1or contribuyente para los predios rurales a los cuales no se les haya fijado aval\u00FAo catastral a primero de enero de 20XX, la base gravable del impuesto predial unificado ser· el valor que mediante autoaval\u00FAo establezca el contribuyente";
					break;
				case "2":
					mensaje = "Se\u00F1or contribuyente para los predios rurales a los cuales no se les haya fijado aval\u00FAo catastral a primero de enero la base gravable del impuesto predial unificado ser· el valor que mediante autoaval\u00FAo establezca el contribuyente.";
					break;
				default:
					break;
				}
				break;
			default:
				break;
		}
		
		if(mensaje != ""){
			alert(mensaje);
		}
		
	}
</script>

