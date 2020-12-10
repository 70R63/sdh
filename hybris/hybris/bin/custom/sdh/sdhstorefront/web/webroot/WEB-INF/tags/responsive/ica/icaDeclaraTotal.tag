<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Total ingresos netos gravables -->

<c:set var="roIngNetosGrava" value=""/>
<c:set var="roIngNetosGravaBoolean" value='false'/>
<c:set var="disabledIngNetosGrava" value=""/>
<c:if test="${icaInfObjetoFormResp.controlCampos.ingNetosGrava == true}">
	<c:set var="roIngNetosGrava" value='readonly="readonly"'/>
	<c:set var="roIngNetosGravaBoolean" value='true'/>
	<c:set var="disabledIngNetosGrava" value='disabled="disabled"'/>
</c:if>
<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }"
	var="infoDeclara" />
<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="hwomargin headline">
				<h2>
					<span class="hwomargin"><spring:theme
							code="ica.declaracion.total.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>
<br>
<sf:form action="" style="padding-left: 0px !important" commandName="icaInfObjetoFormResp">
	<div class="container">
		<div class="row mostrarMD">
			<div class="col-md-1">
				<label class="control-label format_label" for="">
					<spring:theme code="ica.declaracion.total.actprinci" />
				</label>
			</div>
			<div class="col-md-7">
				<label class="control-label format_label" for="">
					<spring:theme code="ica.declaracion.total.denomi" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label" for="">
					<spring:theme code="ica.declaracion.total.ingnet" />
				</label>
			</div>
		</div>


		<c:forEach items="${infoDeclara.ingNetosGrava }" var="eachIngreso" varStatus="loopStatusInfo" >
			<c:set var="idAEP_principal" value='AEPprincipal_${loopStatusInfo.index}'/>
			<c:set var="idDEA_CIIU" value='DEAciiu_${loopStatusInfo.index}'/>
			<c:set var="checkAEP" value=""/>
			<c:if test="${eachIngreso.actPrincipal eq 'X' }">
				<c:set var="checkAEP" value='checked="checked"'/>
			</c:if>
				<div class="row totaluno" id="totaluno">
					<div class="col-md-1">
					<label class="control-label format_label mostrarXS" for="">
					<spring:theme code="ica.declaracion.total.actprinci" />
				</label>
						<input type="checkbox" name=""
							class="form-check-input mr-2 actividad actPrincipal"
							style="visibility: visible !important; min-height: 4px !important; width: 20px;"
							size="10" ${checkAEP} ${roIngNetosGrava} id="${idAEP_principal}">
					</div>

					<div class="col-md-7">
					<label class="control-label format_label mostrarXS" for="">
					<spring:theme code="ica.declaracion.total.denomi" />
				</label>
						<!-- EJRR Adding data to select box eachActivity -->
						<fmt:formatNumber value="${ eachIngreso.codCIIU}"
							pattern="#######################" var="codCIIUNumber" />
						<select id="${idDEA_CIIU}" class="alto form-control codCIIU"
							style="height: 48px; font-size:11px !important; padding: 0px !important;" ${disabledIngNetosGrava} onchange="habilitarTablaING_onChange()">
							<option value="" selected>SELECCIONAR</option>
							<c:forEach items="${ gravableNetIncomes}" var="eachActivity">
								<c:set var="selected" value="" />
								<fmt:formatNumber value="${ eachActivity.ciiu}"
									pattern="#######################" var="eachCodCIIUNumber" />
								<c:if test="${codCIIUNumber eq eachCodCIIUNumber}">
									<c:set var="selected" value="selected" />
								</c:if>
								<option ${selected } value="${eachActivity.ciiu}">${eachActivity.ciiu}
									- ${eachActivity.denominacion }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-2">
					<label class="control-label format_label mostrarXS" for="">
					<spring:theme code="ica.declaracion.total.ingnet" />
				</label>
						<input style="margin-bottom:5px !important"class="newalto form-control ingreso ingresos" type="text"
							value="${eachIngreso.ingresos}" ${roIngNetosGrava}/>
					</div>
					<div class="col-md-1">
						<div class="form-group ">
				 			<c:if test="${icaInfObjetoFormResp.controlCampos.ingNetosGrava != true}">
							<img onclick="addtotaluno()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deletotaluno()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
							</c:if>
						</div>
					</div>
				</div>
		</c:forEach>
		
		<c:if test="${icaInfObjetoFormResp.controlCampos.ingNetosGrava != true and 1==2}">
			<div class="row totaluno" id="totaluno">
				<div class="col-md-1">
					<c:choose>
						<c:when test="${eachIngreso.actPrincipal eq 'X' }">
							<input type="checkbox" name=""
								class="form-check-input mr-2 actividad actPrincipal"
								style="visibility: visible !important; min-height: 4px !important; width: 20px;"
								size="10" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="checkbox" name=""
								class="form-check-input mr-2 actividad actPrincipal"
								style="visibility: visible !important; min-height: 4px !important; width: 20px;"
								size="10">
						</c:otherwise>
					</c:choose>
				</div>
	
				<div class="col-md-7">
					<!-- EJRR Adding data to select box -->
					<select id="" class="alto form-control codCIIU"
						style="font-size:10px !important; padding: 0px !important" >
						<option value="" selected>SELECCIONAR</option>
						<c:forEach items="${gravableNetIncomes}" var="eachActivity">
							<option value="${eachActivity.ciiu}">${eachActivity.ciiu}
								- ${eachActivity.denominacion}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-2">
					<input class="newalto form-control ingreso ingresos" type="text"
						value="${eachIngreso.ingresos}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<img onclick="addtotaluno()"
							src="${themeResourcePath}/images/adddelineacion.png"
							style="width: 25px"></img> <img onclick="deletotaluno()"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
	</div>

	<!-- 	se agrega boton para adjuntar archivo -->
	<div class="container" style="margin-top: 15px !important">
		<div class="row">
			<!-- 			<div class="col-md-3" style="margin-bottom: 3px !important"> -->
			<!-- 				<button style="margin-top: 25px!importan" class="btn btn-primary" -->
			<!-- 					data-toggle="modal" data-target="#fm-modal" type="button" -->
			<!-- 					onclick="addfiletotal()">Adjuntar archivo</button> -->
			<!-- 			</div> -->

			<!-- 			<div id="adjuntar-total" class="row" style="display: none;"> -->
			<!-- 				<div class="col-md-3" style="margin-top: 20px !important"> -->

			<!-- 					<input class="control-form" type="file"></input> -->

			<!-- 				</div> -->
			<!-- 			</div> -->
		</div>
	</div>
	<!-- fin de codigo adjuntar archivo -->

	<br>
<div id="divTablaING" style="display: none;">
 	<div class="row"> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.angrava" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.tipdoc" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.numide" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.nombre" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.direc" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.municipio" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.tel" /> 
 			</label> 
 		</div> 
 		<div class="col-md-2"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme code="ica.declaracion.total.denomi" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme 
 					code="ica.declaracion.total.valtotaliva" /> 
 			</label> 
 		</div> 
 		<div class="col-md-1"> 
 			<label class="control-label format_label" style="text-transform: none !important" 
 				for=""> <spring:theme 
 					code="ica.declaracion.total.valtotaldev" /> 
 			</label> 
 		</div> 
 	</div> 

 	<c:if test="${empty infoDeclara.ingPorCIIU }"> 
 		<div class="row totaldos" id="totaldos"> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control anoGravable" type="text" /> 
 			</div> 


 			<div class="col-md-1"> 
 				<select id="" class="new_alto form-control tipoID" 
 					style="height: 48px; font-size:11px !important; padding: 0px !important;"> 
 					<option value="">Seleccionar</option> 
 					<option value="CC">CC C&eacutedula de ciudadania</option> 
 					<option value="CE">CE C&eacutedula de extranjer&iacutea</option> 
 					<option value="NIT">NIT N&uacutemero de identificaci&oacuten tributaria</option> 
 					<option value="PA">PA Pasaporte</option> 
 					<option value="TI">TI Tarjeta de identidad</option> 
 					<option value="TIE">TIE Tarjeta de identidad de extranjero</option> 
 					<option value="NITE">NITE NIT extranjero</option> 
 					<option value="NUIP">NUIP N&uacutemero unico de identificaci&oacuten 
 						personal</option> 
 				</select> 
 			</div> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control numID" type="text" /> 
 			</div> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control razonSocial" type="text" /> 
 			</div> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control direccion" type="text" /> 
 			</div> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control municipio" type="text" /> 
 			</div> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control telefono" type="text" /> 
 			</div> 
 			<div class="col-md-2"> 
 				<select id="" class="new_alto form-control codCIIU" 
 					style="font-size:12px !important; padding: 0px !important"> 
 					<option value="">SELECCIONAR</option> 
 					<c:forEach items="${ econActivities}" var="eachActivity"> 
 						<option value="${eachActivity.code}">${eachActivity.code} 
 							- ${eachActivity.description }</option> 
 					</c:forEach> 
 				</select> 
 			</div> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control ingBrutoSINIVA" type="text" /> 
 			</div> 
 			<div class="col-md-1"> 
 				<input class="new_alto form-control valorTotalDevol" type="text" /> 
 			</div> 
 			<div class="col-md-1"> 
 				<div class="form-group "> 
 					<img onclick="addtotaldos()" 
 						src="${themeResourcePath}/images/adddelineacion.png" 
 						style="width: 25px"></img> <img onclick="deletotaldos()" 
 						src="${themeResourcePath}/images/deledelineacion.png" 
 						style="width: 25px"></img> 
 				</div> 
 			</div> 
 		</div> 
 	</c:if> 

 	<c:forEach items="${infoDeclara.ingPorCIIU }" var="eachIngreso" varStatus="infoLoop"> 
 		<div class="row totaldos" id="totaldos"> 
 			<div class="col-md-1"> 
 				<sf:input class="new_alto form-control anoGravable" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].anoGravable" readonly="${roIngNetosGravaBoolean}"/>
 			</div> 


 			<div class="col-md-1"> 
<%--  			value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].tipoID}" --%>
 				<select id="" 
 					class="new_alto form-control tipoID" style="height: 48px; font-size:11px !important; padding: 0px;" ${disabledIngNetosGrava}> 
 					<option value="">Seleccionar</option> 
 					<c:forEach items="${ idTypes}" var="eachType"> 

 						<c:set var="selected" value="" /> 
 						<c:if test="${eachIngreso.tipoID  eq  eachType}"> 
 							<c:set var="selected" value="selected" /> 
 						</c:if> 

 						<option value="${eachType}" ${selected }><spring:theme 
 								code="register.id.types.${eachType }" /></option> 

 					</c:forEach> 
 				</select> 
 			</div> 
 			<div class="col-md-1"> 
				<sf:input class="new_alto form-control numID" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].numID" readonly="${roIngNetosGravaBoolean}"/> 					
 			</div> 
 			<div class="col-md-1"> 
				<sf:input class="new_alto form-control razonSocial" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].razonSocial" readonly="${roIngNetosGravaBoolean}"/>
 			</div> 
 			<div class="col-md-1"> 
				<sf:input class="new_alto form-control direccion" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].direccion" readonly="${roIngNetosGravaBoolean}"/>
 			</div> 
 			<div class="col-md-1"> 
<%--  				<sf:input class="new_alto form-control municipio" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].codMunicipio" readonly="${roIngNetosGravaBoolean}"/> --%>
				<select id="" class="new_alto form-control codMunicipioING"
					style="height: 48px; padding:0px; font-size: 11 px; padding: 0px !important;" onchange="activarValidacion_valorRetenido()" ${disabledIngNetosGrava}>
					<option value="">SELECCIONAR</option>
					<c:forEach items="${cities}" var="eachCity">
						<c:set var="selected" value="" />
						<c:if test="${eachCity.code eq  eachIngreso.codMunicipio}">
							<c:set var="selected" value="selected" />
						</c:if>
						<option value="${ eachCity.code}" ${selected }>${eachCity.name}</option>
					</c:forEach>
				</select>
 			</div> 
 			<div class="col-md-1"> 
 				 <sf:input class="new_alto form-control telefono" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].telefono" readonly="${roIngNetosGravaBoolean}"/>
 			</div> 
 			<div class="col-md-2"> 

 				<fmt:formatNumber value="${ eachIngreso.codCIIU}" 
 					pattern="#######################" var="codCIIUNumber" /> 

 				<select id="" 
 					class="new_alto form-control codCIIU" style="font-size:12px !important; padding: 0px !important" ${disabledIngNetosGrava}> 
 					<option value="">SELECCIONAR</option> 
 					<c:forEach items="${ gravableNetIncomes}" var="eachActivity"> 

 						<fmt:formatNumber value="${ eachActivity.ciiu}" 
 							pattern="#######################" var="eachCodCIIUNumber" /> 

 						<c:set var="selected" value="" /> 
 						<c:if test="${eachCodCIIUNumber eq  codCIIUNumber}"> 
 							<c:set var="selected" value="selected" /> 
 						</c:if> 

 						<option value="${eachActivity.ciiu}" ${selected }>${eachActivity.ciiu} 
 							- ${eachActivity.denominacion }</option> 
 					</c:forEach> 
 				</select> 

 			</div> 
 			<div class="col-md-1"> 
 				<sf:input class="new_alto form-control ingBrutoSINIVA" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].ingBrutoSINIVA" readonly="${roIngNetosGravaBoolean}"/>
 			</div> 
 			<div class="col-md-1"> 
				<sf:input class="new_alto form-control valorTotalDevol" path="icaInfObjetoResponse.infoDeclara.ingPorCIIU[${infoLoop.index}].valorTotalDevol" readonly="${roIngNetosGravaBoolean}"/>
 			</div> 
 			<div class="col-md-1"> 
 				<div class="form-group "> 
		 			<c:if test="${icaInfObjetoFormResp.controlCampos.ingNetosGrava != true}">
 					<img onclick="addtotaldos()" 
 						src="${themeResourcePath}/images/adddelineacion.png" 
 						style="width: 25px"></img> <img onclick="deletotaldos()" 
 						src="${themeResourcePath}/images/deledelineacion.png" 
 						style="width: 25px"></img> 
 					</c:if>
 				</div>
 			</div> 
 		</div> 
 	</c:forEach> 
</div>
</sf:form>


<script>
	function addtotaluno() {
debugger;
		var tam = $(".totaluno").length;
		if ($(".totaluno").length < 20) {
			$($(".totaluno")[0]).parent().append($($(".totaluno")[0]).clone());
			$($(".totaluno")[0]).parent().children().last().find(".actividad")
					.val("")
			$($(".totaluno")[0]).parent().children().last().find(".codCIIU")
					.val("")
			$($(".totaluno")[0]).parent().children().last().find(".denomina")
					.val("")
			$($(".totaluno")[0]).parent().children().last().find(".ingreso")
					.val("")
					
			$($(".totaluno")[0]).parent().children().last().find(".codCIIU").attr("id",
					"DEAciiu_"+tam);
			$($(".totaluno")[0]).parent().children().last().find(".actividad").attr("id",
					"AEPprincipal_"+tam);

			var elemento = document.getElementById("AEPprincipal_"+tam);
			elemento.checked = "";
			
		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function deletotaluno() {
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
				while (eliminar.id != "totaluno") {
					eliminar = eliminar.parentNode;
				}
				var h = $(".totaluno").length;
				if ($(".totaluno").length <= 20 && $(".totaluno").length > 1) {
					for (var j = 0; j < $(".totaluno").length; j++) {
						eliminar.remove();
					}
				} else if ($(".totaluno").length <= 1) {
					alert("No puede eliminar todos los registros");
				}
				break;
			} else {
			}
		}
	}

	function addtotaldos() {

		var tam = $(".totaldos").length;
		if ($(".totaldos").length < 20) {
			$($(".totaldos")[0]).parent().append($($(".totaldos")[0]).clone());
			$($(".totaldos")[0]).parent().children().last().find(".anio").val(
					"")
			$($(".totaldos")[0]).parent().children().last().find(".tipo").val(
					"")
			$($(".totaldos")[0]).parent().children().last().find(".numiden")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".nombre")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".direc").val(
					"")
			$($(".totaldos")[0]).parent().children().last().find(".telefono")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".denoact")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".valbrut")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".valtotal")
					.val("")

		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function deletotaldos() {
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
				while (eliminar.id != "totaldos") {
					eliminar = eliminar.parentNode;
				}
				var h = $(".totaldos").length;
				if ($(".totaldos").length <= 20 && $(".totaldos").length > 1) {
					for (var j = 0; j < $(".totaldos").length; j++) {
						eliminar.remove();
					}
				} else if ($(".totaldos").length <= 1) {
					alert("No puede eliminar todos los registros");
				}
				break;
			} else {
			}
		}

	}

	function addfiletotal() {

		var subir = document.getElementById('adjuntar-total');
		subir.style.display = 'block';
	}
	
	function habilitarTablaING_onChange(){
		debugger;
		llenarTablaING_CIIU();
		habilitarTablaING_general();
		
	}
	
	function llenarTablaING_CIIU(){
		var idElemento = "";
		var selElemento = null;
		
		codigosCIIU = new Array();
		for(var i = 0;i < 50; i++){
			idElemento = "DEAciiu_"+i;
			selElemento = document.getElementById(idElemento);
			
			if(selElemento == null){
				break;
			}
			
			if(selElemento.value != "" ){
				item_codigosCIIU = new Object();
				item_codigosCIIU.idCodigoCIIU = selElemento.value;
				codigosCIIU.push(item_codigosCIIU);
			}
		}

	}
</script>