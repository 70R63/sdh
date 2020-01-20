<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="roDeducciones" value=""/>
<c:set var="disabledDeducciones" value=""/>
<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones == true}">
	<c:set var="roDeducciones" value='readonly="readonly"'/>
	<c:set var="disabledDeducciones" value='disabled="disabled"'/>
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
							code="ica.declaracion.deducciones.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>

	<br>
	<form:form action="" style="padding-left: 0px !important">
		<div class="row">
			<div class="col-md-6">
				<label class="control-label format_label" for=""> <spring:theme
						code="ica.declaracion.deducciones.deduccion" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label" for=""> <spring:theme
						code="ica.declaracion.deducciones.monto" />
				</label>
			</div>
		</div>

		<fmt:parseNumber var="actnosubPA" type="number"
			value="${fn:trim(infoDeclara.deducciones.actnosubPA)}" />
		<c:if test="${ actnosubPA != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="actnosubPA">1.- Actividad no sujeta por la
							producción Primaria Agricola</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.actnosubPA}" ${roDeducciones}/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>

		<fmt:parseNumber var="enajActFijo" type="number"
			value="${fn:trim(infoDeclara.deducciones.enajActFijo)}" />
		<c:if test="${ enajActFijo != 0  }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="enajActFijo">2.- Enajenación de Activo
							Fijos</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.enajActFijo}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>

		<fmt:parseNumber var="exportBienes" type="number"
			value="${fn:trim(infoDeclara.deducciones.exportBienes)}" />
		<c:if test="${ exportBienes != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="exportBienes">3.- Exportación de bienes</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.exportBienes}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>

		<fmt:parseNumber var="exportServ" type="number"
			value="${fn:trim(infoDeclara.deducciones.exportServ)}" />
		<c:if test="${ exportServ != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="exportServ">4.- Exportación de Servicios</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.exportServ}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>

		<fmt:parseNumber var="actnosub39" type="number"
			value="${fn:trim(infoDeclara.deducciones.actnosub39)}" />
		<c:if test="${ actnosub39 != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important"${disabledDeducciones}>
						<option value="actnosub39">5.- Actividad no sujeta Art.
							39 Decreto 352 de 2002</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.actnosub39}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="actnosubPH" type="number"
			value="${fn:trim(infoDeclara.deducciones.actnosubPH)}" />
		<c:if test="${ actnosubPH != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="actnosubPH">6.- Actividades no sujetas
							propias de obj.soc. de prop.horiz.</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.actnosubPH}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>

		<fmt:parseNumber var="juegoSuerteAzar" type="number"
			value="${fn:trim(infoDeclara.deducciones.juegoSuerteAzar)}" />
		<c:if test="${ juegoSuerteAzar != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="juegoSuerteAzar">7.- Explotación de los
							juegos de suerte y azar (Ley 643 de 2001)</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.juegoSuerteAzar}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="donaciones" type="number"
			value="${fn:trim(infoDeclara.deducciones.donaciones)}" />
		<c:if test="${ donaciones != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="donaciones">8.- Donaciones</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.donaciones}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="exenActos" type="number"
			value="${fn:trim(infoDeclara.deducciones.exenActos)}" />
		<c:if test="${ exenActos != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="exenActos">9.- Exen.consec.de actos
							terroristas o catástrofes naturales</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.exenActos}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="baseGravEsp" type="number"
			value="${fn:trim(infoDeclara.deducciones.baseGravEsp)}" />
		<c:if test="${ baseGravEsp != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="baseGravEsp">10.- Base gravable especial</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.baseGravEsp}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="ingrActConsorc" type="number"
			value="${fn:trim(infoDeclara.deducciones.ingrActConsorc)}" />
		<c:if test="${ ingrActConsorc != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="ingrActConsorc">11.- Ingresos por
							actividades realizadas a través de Consorcios</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.ingrActConsorc}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="diviNOGiroOrd" type="number"
			value="${fn:trim(infoDeclara.deducciones.diviNOGiroOrd)}" />
		<c:if test="${ diviNOGiroOrd != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="diviNOGiroOrd">12.- Dividendos que no
							hacen parte del giro ordinario del negocio</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.diviNOGiroOrd}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="exenVictima" type="number"
			value="${fn:trim(infoDeclara.deducciones.exenVictima)}" />
		<c:if test="${ exenVictima != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="exenVictima">13.- Exención víctima del
							secuestro o de la desaparición forzada</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.exenVictima}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="correcMoneda" type="number"
			value="${fn:trim(infoDeclara.deducciones.correcMoneda)}" />
		<c:if test="${ correcMoneda != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="correcMoneda">14.- Corrección monetaria
							y/o Diferencia en cambio</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.correcMoneda}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<!-- 						<img onclick="adddeducciones()" -->
						<%-- 							src="${themeResourcePath}/images/adddelineacion.png" --%>
						<!-- 							style="width: 25px"></img>  -->
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="reintegro" type="number"
			value="${fn:trim(infoDeclara.deducciones.reintegro)}" />
		<c:if test="${ reintegro != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="reintegro">15.- Reintegro de costos y
							gastos</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.reintegro}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<!-- 						<img onclick="adddeducciones()" -->
						<%-- 							src="${themeResourcePath}/images/adddelineacion.png" --%>
						<!-- 							style="width: 25px"></img>  -->
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="salarios" type="number"
			value="${fn:trim(infoDeclara.deducciones.salarios)}" />
		<c:if test="${ salarios != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="salarios">16.- Salarios</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.salarios}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<!-- 						<img onclick="adddeducciones()" -->
						<%-- 							src="${themeResourcePath}/images/adddelineacion.png" --%>
						<!-- 							style="width: 25px"></img>  -->
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<fmt:parseNumber var="devoluciones" type="number"
			value="${fn:trim(infoDeclara.deducciones.devoluciones)}" />
		<c:if test="${ devoluciones != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="devoluciones">17.- Devoluciones</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.devoluciones}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>

		<fmt:parseNumber var="rebajas" type="number"
			value="${fn:trim(infoDeclara.deducciones.rebajas)}" />
		<c:if test="${ rebajas != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="rebajas">18.- Rebajas</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.rebajas}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>

		<fmt:parseNumber var="descuentos" type="number"
			value="${fn:trim(infoDeclara.deducciones.descuentos)}" />
		<c:if test="${ descuentos != 0 }">
			<div class="row deducciones">
				<div class="col-md-6">
					<select id="" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important" ${disabledDeducciones}>
						<option value="descuentos">19.- Descuentos</option>
					</select>
				</div>

				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text"
						value="${infoDeclara.deducciones.descuentos}" />
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
						</c:if>
					</div>
				</div>
			</div>
		</c:if>


		<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
			<div class="row deducciones" id="deducciones">
				<div class="col-md-6">
					<select id="deduccionBase" class="alto form-control deducci"
						style="height: 48px; text-transform: none !important; font-size: 12px !important; padding: 0px !important">
						<option value="">Seleccionar</option>
						<option value="actnosubPA">1.- Actividad no sujeta por la
							producción Primaria Agricola</option>
						<option value="enajActFijo">2.- Enajenación de Activo
							Fijos</option>
						<option value="exportBienes">3.- Exportación de bienes</option>
						<option value="exportServ">4.- Exportación de Servicios</option>
						<option value="actnosub39">5.- Actividad no sujeta Art. 39
							Decreto 352 de 2002</option>
						<option value="actnosubPH">6.- Actividades no sujetas
							propias de obj.soc. de prop.horiz.</option>
						<option value="juegoSuerteAzar">7.- Explotación de los
							juegos de suerte y azar (Ley 643 de 2001)</option>
						<option value="donaciones">8.- Donaciones</option>
						<option value="exenActos">9.- Exen.consec.de actos
							terroristas o catástrofes naturales</option>
						<option value="baseGravEsp">10.- Base gravable especial</option>
						<option value="ingrActConsorc">11.- Ingresos por
							actividades realizadas a través de Consorcios</option>
						<option value="diviNOGiroOrd">12.- Dividendos que no hacen
							parte del giro ordinario del negocio</option>
						<option value="exenVictima">13.- Exención víctima del
							secuestro o de la desaparición forzada</option>
						<option value="correcMoneda">14.- Corrección monetaria y/o
							Diferencia en cambio</option>
						<option value="reintegro">15.- Reintegro de costos y
							gastos</option>
						<option value="salarios">16.- Salarios</option>
						<option value="devoluciones">17.- Devoluciones</option>
						<option value="rebajas">18.- Rebajas</option>
						<option value="descuentos">19.- Descuentos</option>
					</select>
				</div>
	
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" />
				</div>
				<div class="borrar col-md-1" style="height: 20px;"
					onclick="borrar(this)">
					<!--  <div class="form-group ">-->
					<c:if test="${icaInfObjetoFormResp.controlCampos.deducciones != true}">
					<img onclick="borrar(this)" class="delededucciones"
						id="delededucciones"
						src="${themeResourcePath}/images/deledelineacion.png"
						style="width: 20px; margin-top: 0px; margin-bottom: 2px !important"></img>
					</c:if>
					<!-- </div>-->
				</div>
			</div>
		</c:if>
	</form:form>
</div>

<script type="text/javascript">
	function delededucciones(id) {
		debugger;
		var elem = document.getElementsByTagName("img");
		var ElementosClick = new Array();
		var HaHechoClick;

		HaHechoClick = event.srcElement;
		ElementosClick.push(HaHechoClick);

		for (var i = 0; i < elem.length; i++) {
			var cual = elem[i];
			var cual2 = ElementosClick[0];
			var texto = cual2.parentNode.innerText;

			if (cual == cual2) {
				var eliminar = cual.parentNode;
				while (eliminar.id != "deducciones") {
					eliminar = eliminar.parentNode;
				}
				var h = $(".deducciones").length;
				if ($(".deducciones").length <= 2000
						&& $(".deducciones").length > 1) {
					for (var j = 0; j < $(".deducciones").length; j++) {
						eliminar.remove();
					}
				} else if ($(".deducciones").length <= 1) {
					alert("No puede eliminar todos los registros");
				}
				break;
			} else {
			}
		}
	}

	function borrar(SelectObject) {
		debugger;
		var dele = SelectObject;
		//dele.remove()
		var elem = document.getElementsByTagName("div");
		var ElementosClick = new Array();
		var HaHechoClick;

		HaHechoClick = event.srcElement;
		ElementosClick.push(HaHechoClick);
		var cual2 = ElementosClick[0];
		var texto = cual2.parentNode.innerText;
		if (texto.includes('Seleccionar')) {
			alert("No se puede eliminar esta línea ya que no se podrán seguir agregando campos");
		} else {
			for (var i = 0; i < elem.length; i++) {
				var cual = elem[i];

				if (cual == cual2) {
					debugger;
					var eliminar = cual.parentNode;
					while (eliminar.id != "deducciones") {
						eliminar = eliminar.parentNode;
					}
					var h = $(".deducciones").length;
					if ($(".deducciones").length <= 2000
							&& $(".deducciones").length > 1) {
						for (var j = 0; j < $(".deducciones").length; j++) {
							eliminar.remove();
						}
					} else if ($(".deducciones").length <= 1) {
						alert("No puede eliminar todos los registros");
					}
					break;
				} else {
				}
			}
		}
	}
</script>


