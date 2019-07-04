<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }" var="infoDeclara" />
<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.deducciones.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>

	<br>
	<form:form action="">
		<div class="row">
			<div class="col-md-4">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.deducciones.deduccion" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.deducciones.monto" />
				</label>
			</div>
		</div>
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.actnosubPA) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="actnosubPA">1.- Actividad no sujeta por la producción Primaria Agricola</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.actnosubPA}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.enajActFijo) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="enajActFijo">2.- Enajenación de Activo Fijos</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.enajActFijo}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.exportBienes) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="exportBienes">3.- Exportación de bienes</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.exportBienes}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.exportServ) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="exportServ">4.- Exportación de Servicios</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.exportServ}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.actnosub39) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="actnosub39">5.- Actividad no sujeta Art. 39 Decreto 352 de 2002</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.actnosub39}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.actnosubPH) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="actnosubPH">6.- Actividades no sujetas propias de obj.soc. de prop.horiz.</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.actnosubPH}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.juegoSuerteAzar) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="juegoSuerteAzar">7.- Explotación de los juegos de suerte y azar (Ley 643 de 2001)</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.juegoSuerteAzar}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.donaciones) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="donaciones">8.- Donaciones</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.donaciones}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.exenActos) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="exenActos">9.- Exen.consec.de actos terroristas o catástrofes naturales</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.exenActos}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.baseGravEsp) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="baseGravEsp">10.- Base gravable especial</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.baseGravEsp}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.ingrActConsorc) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="ingrActConsorc">11.- Ingresos por actividades realizadas a través de Consorcios</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.ingrActConsorc}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.diviNOGiroOrd) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="diviNOGiroOrd">12.- Dividendos que no hacen parte del giro ordinario del negocio</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.diviNOGiroOrd}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.exenVictima) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="exenVictima">13.- Exención víctima del secuestro o de la desaparición forzada</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.exenVictima}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						 <img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.correcMoneda) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="correcMoneda">14.- Corrección monetaria y/o Diferencia en cambio</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.correcMoneda}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
<!-- 						<img onclick="adddeducciones()" -->
<%-- 							src="${themeResourcePath}/images/adddelineacion.png" --%>
<!-- 							style="width: 25px"></img>  -->
							<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.reintegro) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="reintegro">15.- Reintegro de costos y gastos</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.reintegro}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
<!-- 						<img onclick="adddeducciones()" -->
<%-- 							src="${themeResourcePath}/images/adddelineacion.png" --%>
<!-- 							style="width: 25px"></img>  -->
							<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.salarios) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="salarios">16.- Salarios</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.salarios}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
<!-- 						<img onclick="adddeducciones()" -->
<%-- 							src="${themeResourcePath}/images/adddelineacion.png" --%>
<!-- 							style="width: 25px"></img>  -->
							<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.devoluciones) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="devoluciones">17.- Devoluciones</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.devoluciones}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
							<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.rebajas) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="rebajas">18.- Rebajas</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.rebajas}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${ '0.00' ne fn:trim(infoDeclara.deducciones.descuentos) }">
			<div class="row deducciones">
				<div class="col-md-4">
					<select id="" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
						<option value="descuentos">19.- Descuentos</option>
					</select>
				</div>
	
				<div class="col-md-2">
					<input class="newalto form-control valordedu" type="text" value="${infoDeclara.deducciones.descuentos}"/>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<img class="delededucciones"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		
		<div class="row deducciones">
			<div class="col-md-4">
				<select id="deduccionBase" class="new_alto form-control deducci" style="height: 48px; text-transform: none !important; font-size: 14px !important">
					<option value="">Seleccionar</option>
					<option value="actnosubPA">1.- Actividad no sujeta por la producción Primaria Agricola</option>
					<option value="enajActFijo">2.- Enajenación de Activo Fijos</option>
					<option value="exportBienes">3.- Exportación de bienes</option>
					<option value="exportServ">4.- Exportación de Servicios</option>
					<option value="actnosub39">5.- Actividad no sujeta Art. 39 Decreto 352 de 2002</option>
					<option value="actnosubPH">6.- Actividades no sujetas propias de obj.soc. de prop.horiz.</option>
					<option value="juegoSuerteAzar">7.- Explotación de los juegos de suerte y azar (Ley 643 de 2001)</option>
					<option value="donaciones">8.- Donaciones</option>
					<option value="exenActos">9.- Exen.consec.de actos terroristas o catástrofes naturales</option>
					<option value="baseGravEsp">10.- Base gravable especial</option>
					<option value="ingrActConsorc">11.- Ingresos por actividades realizadas a través de Consorcios</option>
					<option value="diviNOGiroOrd">12.- Dividendos que no hacen parte del giro ordinario del negocio</option>
					<option value="exenVictima">13.- Exención víctima del secuestro o de la desaparición forzada</option>
					<option value="correcMoneda">14.- Corrección monetaria y/o Diferencia en cambio</option>
					<option value="reintegro">15.- Reintegro de costos y gastos</option>
					<option value="salarios">16.- Salarios</option>
					<option value="devoluciones">17.- Devoluciones</option>
					<option value="rebajas">18.- Rebajas</option>
					<option value="descuentos">19.- Descuentos</option>
				</select>
			</div>

			<div class="col-md-2">
				<input class="newalto form-control valordedu" type="text" />
			</div>
			<div class="col-md-1">
				<div class="form-group ">
<!-- 					<img class="delededucciones" -->
<%-- 						src="${themeResourcePath}/images/deledelineacion.png" --%>
<!-- 						style="width: 25px"></img> -->
				</div>
			</div>
		</div>
	</form:form>
</div>

