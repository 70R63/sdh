<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }"
	var="infoDeclara" />
<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.valor.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>
<br>

<div class="row mt-3">
	<div class="col-md-8 col-md-offset-2 d-flex align-items-center">
		<spring:theme code="ica.declaracion.valor.descripcion1" />
	</div>
</div>

<br>

<sf:form action="" commandName="icaInfObjetoFormResp">
	<div>
		<div class="row" style="padding-left: 46px;">
			<!-- 	<div class="col-md-1" style="width: 10.5% !important">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.angrav" />
				</label>
			</div>-->
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px; width: 5% !important">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="Año" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px; width: 5% !important">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="Mes" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 5px; padding-right: 2px; width: 5% !important">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="Día" />
				</label>
			</div>
			<div class="col-md-2" style="padding-left: 2px; padding-right: 2px; width: 10% !important">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="ica.declaracion.valor.tipdoc" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
				<label style="text-transform: none !important;"
					class="control-label format_label" for=""> <spring:theme
						code="ica.declaracion.valor.numide" />
				</label>
			</div>
			<div class="col-md-2" style="padding-left: 2px; padding-right: 2px; width: 15% !important">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="ica.declaracion.valor.nombre" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="ica.declaracion.valor.direccion" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="ica.declaracion.valor.tel" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="ica.declaracion.valor.municipio" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="ica.declaracion.valor.taraplicada" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
				<label class="control-label format_label"
					style="text-transform: none !important" for=""> <spring:theme
						code="ica.declaracion.valor.montoret" />
				</label>
			</div>
		</div>




		<c:forEach items="${infoDeclara.valorRetenido }" var="eachValor" varStatus="loopStatusInfo" >
			<c:set var="anoGravable_formateado"
				value="${fn:substring(eachValor.anoGravable, 6, 10)}-${fn:substring(eachValor.anoGravable, 3, 5)}-${fn:substring(eachValor.anoGravable, 0, 2)}" />
			<c:set var="idMes" value='mesValorRetenido_${loopStatusInfo.index}' />
			<c:set var="idDia" value='diaValorRetenido_${loopStatusInfo.index}' />
			<div class="row valor" id="valor" style="padding-left: 45px;">
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px; width: 5% !important">

					<sf:input class="new_alto form-control anio_anoGravable " 
					path="icaInfObjetoResponse.infoDeclara.valorRetenido[${loopStatusInfo.index}].anio"
					readonly="true" onchange="activarValidacion_valorRetenido()"/>
				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px; width: 5% !important">
					<sf:select class="new_alto form-control mes_anoGravable " 
					path="icaInfObjetoResponse.infoDeclara.valorRetenido[${loopStatusInfo.index}].mes" 
					items="${icaInfObjetoFormResp.catalogos.valor_retenido_meses}" 
					onchange="realizarUpdateMes_valorRetenido(this)" id="${idMes}"></sf:select>
				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px; width: 5% !important">
					<sf:select class="new_alto form-control dia_anoGravable " 
					path="icaInfObjetoResponse.infoDeclara.valorRetenido[${loopStatusInfo.index}].dia" 
					items="${icaInfObjetoFormResp.catalogos.valor_retenido_meses}" 
					onchange="activarValidacion_valorRetenido()" id="${idDia}" disabled="true"></sf:select>
				</div>
				<div class="col-md-2" style="padding-left: 2px; padding-right: 2px; width: 10% !important">
					<select id="" class="etiq_valor form-control tipoID"
						style="height: 48px;" onchange="activarValidacion_valorRetenido()">
						<option value="">Seleccionar</option>
						<c:forEach items="${ idTypes}" var="eachType">

							<c:set var="selected" value="" />
							<c:if test="${eachValor.tipoID  eq  eachType}">
								<c:set var="selected" value="selected" />
							</c:if>

							<option value="${eachType }" ${selected }><spring:theme
									code="register.id.types.${eachType }" /></option>

						</c:forEach>


					</select>
				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
					<input class="new_alto form-control numID" type="text"
						value="${eachValor.numID }"
						onchange="activarValidacion_valorRetenido()" />
				</div>
				<div class="col-md-2" style="padding-left: 2px; padding-right: 2px; width: 15% !important">
					<input class="new_alto form-control razonSocial" type="text"
						value="${eachValor.razonSocial }"
						onchange="activarValidacion_valorRetenido()"/>
				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
					<input class="new_alto form-control direccion" type="text"
						value="${eachValor.direccion }"
						onchange="activarValidacion_valorRetenido()" />
				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
					<input class="new_alto form-control telefono" type="text"
						value="${eachValor.telefono }"
						onchange="activarValidacion_valorRetenido()" />
				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
					<select id="" class="new_alto form-control codMunicipio"
						style="height: 48px;" onchange="activarValidacion_valorRetenido()">
						<option value="">SELECCIONAR</option>
						<c:forEach items="${cities}" var="eachCity">

							<c:set var="selected" value="" />
							<c:if test="${eachCity.code eq  eachValor.codMunicipio}">
								<c:set var="selected" value="selected" />
							</c:if>

							<option value="${ eachCity.code}" ${selected }>${eachCity.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
					<!-- 						<input class="form-control tarifaApl" type="text" -->
					<%-- 							value="${eachValor.tarifaApl }" /> --%>
					<select id="" class="new_alto form-control tarifaApl"
						style="height: 48px;" onchange="activarValidacion_valorRetenido()">
						<option value="">Seleccionar</option>
						<c:forEach items="${ tarifasValorRetenido}" var="eachTarifa">

							<c:set var="selected" value="" />
							<c:if test="${ fn:trim(eachValor.tarifaApl)  eq  eachTarifa}">
								<c:set var="selected" value="selected" />
							</c:if>

							<option value="${eachTarifa }" ${selected }>${eachTarifa }</option>

						</c:forEach>


					</select>

				</div>
				<div class="col-md-1" style="padding-left: 2px; padding-right: 2px;">
					<input class="new_alto form-control montoRetenido" type="text"
						value="${eachValor.montoRetenido }"
						onchange="activarValidacion_valorRetenido()" />
				</div>
				<div class="col-md-1" style="width: 5.9% !important; padding-left: 2px; padding-right: 2px;">
					<div class="form-group ">
						<img onclick="addvalor()"
							src="${themeResourcePath}/images/adddelineacion.png"
							style="width: 25px"></img> <img onclick="delevalor()"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- 	se agrega boton para adjuntar archivo -->
	<div class="container" style="margin-top: 15px !important">


		<div class="row">
			<!-- 			<div class="col-md-3" style="margin-bottom: 3px !important"> -->
			<!-- 				<button class="btn btn-primary" data-toggle="modal" -->
			<!-- 					data-target="#fm-modal" type="button" onclick="addfilevalor()" -->
			<!-- 					style="margin-top: 15px!importan">Adjuntar archivo</button> -->
			<!-- 			</div> -->

			<!-- 			<div id="adjuntar-valor" class="row" style="display: none;"> -->
			<!-- 				<div class="col-md-3" style="margin-top: 20px !important"> -->

			<!-- 					<input class="control-form" type="file"></input> -->

			<!-- 				</div> -->
			<!-- 			</div> -->
			<div class="row">
				<div class="col-md-12 text-center" style="marging-top: 15px">
					<button style="margin-top: 3px;" id="icaCalculoButton"
						class="btn btn-primary btn-lg" type="button">
						<spring:theme code="ica.declaracion.valor.calcular" />
					</button>
				</div>
			</div>
		</div>

	</div>
	<!-- fin de codigo adjuntar archivo -->
</sf:form>

<script type="text/javascript">
	function addvalor() {

		debugger;
		var tam = $(".valor").length;
		var idMes = "mesValorRetenido_"+tam;
		if ($(".valor").length < 20) {
			$($(".valor")[0]).parent().append($($(".valor")[0]).clone());
			$($(".valor")[0]).parent().children().last().find(".mes").val("")
			$($(".valor")[0]).parent().children().last().find(".dia").val("")
			$($(".valor")[0]).parent().children().last().find(".tipo").val("")
			$($(".valor")[0]).parent().children().last().find(".numID").val("")
			$($(".valor")[0]).parent().children().last().find(".razonSocial")
					.val("")
			$($(".valor")[0]).parent().children().last().find(".direccion")
					.val("")
			$($(".valor")[0]).parent().children().last().find(".telefono").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".denoact").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".valbrut").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".valtotal").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".montoRetenido")
					.val("")

			$($(".valor")[0]).parent().children().last().find(".mes").attr("id",
				"mesValorRetenido_"+tam);
			$($(".valor")[0]).parent().children().last().find(".dia").attr("id",
				"diaValorRetenido_"+tam);
			$($(".valor")[0]).parent().children().last().find(".dia").attr("disabled",
					"disabled");
		} else {
			alert("No se pueden agregar mï¿½s registros");
		}

	}

	function delevalor() {
		var elem = document.getElementsByTagName("img");
		var ElementosClick = new Array();
		var HaHechoClick;

		HaHechoClick = event.srcElement;
		ElementosClick.push(HaHechoClick);

		for (var i = 0; i < elem.length; i++) {
			var cual = elem[i];
			var cual2 = ElementosClick[0];

			if (cual == cual2) {
				var eliminar = cual.parentNode;
				while (eliminar.id != "valor") {
					eliminar = eliminar.parentNode;
				}
				var h = $(".valor").length;
				if ($(".valor").length <= 20 && $(".valor").length > 1) {
					for (var j = 0; j < $(".valor").length; j++) {
						eliminar.remove();
					}
				} else if ($(".valor").length <= 1) {
					alert("No puede eliminar todos los registros");
				}
				break;
			} else {
			}
		}
	}

	function addfilevalor() {
		debugger;
		var subir = document.getElementById('adjuntar-valor');
		subir.style.display = 'block';
	}

	function activarValidacion_valorRetenido() {
		ACC.ica.validacion_valorRetenido = 'X';
	}
	
	function realizarUpdateMes_valorRetenido(infoMes) {
		
		debugger;
		var idElemento = 'diaValorRetenido_'+infoMes.id.substring(17);
		var sel = document.getElementById(idElemento);
		sel.disabled = '';
		sel.value = '';
		
	    var i;
	    for(i = sel.options.length - 1 ; i >= 0 ; i--)
	    {
	    	sel.remove(i);
	    }
	    
		var opt = document.createElement('option');
		opt.appendChild( document.createTextNode('Seleccionar') );
		opt.value = ''; sel.appendChild(opt); 

		var diaFormateado = "";
		for(j = 0 ; j<mesesInfo.length ; j++){
			if(mesesInfo[j].mes == infoMes.value){
			    for(i = 1 ; i <= mesesInfo[j].diasEnMes ; i++){
					opt = document.createElement('option');
					diaFormateado = i.toString();
					if(i<9){
						diaFormateado = "0"+diaFormateado;
					}
					opt.appendChild( document.createTextNode(diaFormateado) );
					opt.value = diaFormateado; 
					sel.appendChild(opt);
			    }
			}
	    }
	    
	    debugger;
	   
		
		activarValidacion_valorRetenido();
	}
</script>
