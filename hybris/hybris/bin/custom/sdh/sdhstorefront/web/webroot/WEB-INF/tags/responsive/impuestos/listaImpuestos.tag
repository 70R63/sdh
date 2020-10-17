<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="jquery.min.js"></script>

<spring:htmlEscape defaultHtmlEscape="true" />
<c:url value="/contribuyentes/presentar-declaracion"
	var="presentarDeclaracionUrl"/>
<br>
<div>Solo se puede revisar el año 2020, si requiere revisar su información de años anteriores al 2020 visite el siguiente enlace:</div>
<br>
<br>
<br>
<div class="container_new_page">
	<sf:form action="${presentarDeclaracionUrl}"
		method="POST" id="forma" commandName="dataForm">
		<c:if test="${mensajeDelinea != null}">
			<div class="row">
				<div class="col-12 notas_deli">
					<div class="alert alert-danger mt-3">
						<spring:theme code="${mensajeDelinea}" />
					</div>
				</div>
			</div>
		</c:if>

		<div class="row" id="notaVehPre" style="display: none">
			<div class="col-md-12"
				style="background: #d2d2d2; margin-top: 20px !important;">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.presentarDeclaracion.notaPredial" /></label>
				</div>
			</div>
		</div>
		<div class="row" id="notaOtros" style="display: none">
			<div class="col-md-12"
				style="background: #d2d2d2; margin-top: 20px !important;">
				<div class="form-group">
					<label class="control-label "><spring:theme
							code="impuestos.presentarDeclaracion.notaOtros" /></label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-12 mb-20 no-marginright">
				<span class="paso--uno pasos color-sr1">1</span>
				<h2 class="titulo-caja--ser-rel color-sr1 label-control ">
					<spring:theme
						code="impuestos.presentarDeclaracion.PresentarDeclaracionUpper" />
				</h2>
				<p class="pasoClase1 metrophobic">Selecciona el impuesto que
					deseas consultar.</p>
				<div class="caja--ser-rel color-sr1">
					<div class="form-group ">
						<label class="control-label required"><spring:theme
								code="impuestos.presentarDeclaracion.impuesto" /></label>
						<sf:select path="impuesto" id="impuesto" items="${tpImpuesto}"
							referenceData="${dataForm.impuesto}"
							class="new_alto form-control" onchange="onChange()">
						</sf:select>
					</div>
				</div>
			</div>


			<div id="impuestoss" style="display: none;">
				<input value="${dataForm.optionPubliExt}" id="impuestoPE" />
			</div>
			<div id="impuestoss2" style="display: none;">
				<input value="${dataForm.optionGas}" id="impuestoGas" />
			</div>

			<input type="hidden" name="skipReques" value="" id="skipReques"/>
			<sf:hidden path="periodicidadImpuesto"/>

<%-- 			<c:if test="${dataForm.impuesto != '3'}"> --%>
				<div class="col-md-4 col-xs-12 mb-20 no-margincol">
					<span class="paso--dos pasos color-sr2">2</span>
					<h2 class="titulo-caja--ser-rel color-sr2 ">
						<span class="paso2"><spring:theme
								code="impuestos.presentarDeclaracion.anioGravableConsultarUpper" /></span>
					</h2>
					<p class="pasoClase2 metrophobic">
						<spring:theme code="impuestos.presentarDeclaracion.seleccionaAnio" />
					</p>
					<div class="caja--ser-rel color-sr2">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.anioGravableConsultar" /></label>

							<sf:select path="anoGravable" id="anoGravable"
								items="${dataForm.catalogosSo.anioGravable}"
								referenceData="${dataForm.catalogosSo.anioGravable}"
								class="newalto form-control" onchange="onChangeAnioGravable()" />
						</div>
					</div>
				</div>
<%-- 			</c:if> --%>

<%-- 			<c:if test="${dataForm.impuesto == '3'}"> --%>
<!-- 				<div class="col-md-4 col-xs-12 mb-20 no-margincol"> -->
<!-- 					<span class="paso--dos pasos color-sr2">2</span> -->
<!-- 					<h2 class="titulo-caja--ser-rel color-sr2 "> -->
<%-- 						<span class="paso2"><spring:theme --%>
<%-- 								code="impuestos.presentarDeclaracion.anioGravableConsultarUpper" /></span> --%>
<!-- 					</h2> -->
<!-- 					<p class="pasoClase2 metrophobic"> -->
<%-- 						<spring:theme code="impuestos.presentarDeclaracion.seleccionaAnio" /> --%>
<!-- 					</p> -->
<!-- 					<div class="caja--ser-rel color-sr2"> -->
<!-- 						<div class="form-group "> -->
<%-- 							<label class="control-label required"><spring:theme --%>
<%-- 									code="impuestos.presentarDeclaracion.anioGravableConsultar" /></label> --%>


<%-- 							<sf:select path="anoGravable" id="anoGravable" --%>
<%-- 								items="${icaAnioGravable}" referenceData="${icaAnioGravable}" --%>
<%-- 								class="newalto form-control" onchange="onChangeAnioGravable()" /> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<%-- 			</c:if> --%>

			<c:if
				test="${dataForm.impuesto ne '3' and dataForm.impuesto ne '4' and dataForm.impuesto ne '6' and dataForm.impuesto ne '2'}">

				<div class="col-md-4 col-xs-12 mb-20 no-marginleft"
					id="seccionPeriodo2">
					<span class="paso--tres pasos color-sr3 rajdhani">3</span>
					<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
					<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
					<div class="caja--ser-rel color-sr3">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.Periodo" /></label>



							<sf:select id="periodo" path="periodo"
								items="${dataForm.catalogosSo.periodo}"
								referenceData="${dataForm.catalogosSo.periodo}"
								class="newalto form-control" />
						</div>
					</div>
				</div>


			</c:if>

			<c:if test="${dataForm.impuesto == '3' and  isPeriodoAnual == false}">
				<div class="col-md-4 col-xs-12 mb-20 no-marginleft">
					<span class="paso--tres pasos color-sr3 rajdhani">3</span>
					<h2 class="titulo-caja--ser-rel color-sr3 paso3">PERIODO</h2>
					<p class="pasoClase3 metrophobic">Selecciona el periodo.</p>
					<div class="caja--ser-rel color-sr3">
						<div class="form-group ">
							<label class="control-label required"><spring:theme
									code="impuestos.presentarDeclaracion.Periodo" /></label>

							<sf:select id="periodo" path="periodo" items="${icaPeriodo}"
								referenceData="${icaPeriodo}" class="new_alto form-control" />
						</div>
					</div>
				</div>

			</c:if>
		</div>

		<!-- Jair Roa -New modification - opcionUso validation -->
		<c:if
			test="${dataForm.impuesto ne '4' and dataForm.impuesto ne ' ' and dataForm.impuesto ne '6'}">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-9 text-center">
					<sf:button type="button"
						class="btn btn-primary btn-lg" id="action" name="action"
						onClick="validateForm();"
						value="presentarDeclaracion"
						style="margin-top: 15px">
						<spring:theme
							code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
					</sf:button>

					<sf:button type="submit"
                        class="btn btn-primary btn-lg" id="actionHidden" name="action"
                    	value="presentarDeclaracion"
                    	style="display:none;">
                    	<spring:theme
                    	    code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
                    	</sf:button>

					<sf:button type="submit"
						class="btn btn-primary btn-lg accionGasolina" id="action" name="action"
 						value="presentarDeclaracion"
						style="display:none;">
						<spring:theme
							code="impuestos.presentarDeclaracion.PresentarDeclaracion" />
					</sf:button>
					
				</div>
			</div>
		</c:if>

	</sf:form>
	<br>

	<c:if test="${not empty publicidadExtList}">
		<table id="myTable" class="tabPaginacion">
			<tr>
				<th>NUMERO DE RESOLUCION</th>
				<th>TIPO DE VALLA</th>
				<th>ACTION</th>
			</tr>
			<c:forEach var="item" items="${publicidadExtList}">
				<tr>
					<td><c:out value="${item.numResolu}" /></td>
					<td><c:out value="${item.tipoValla}" /></td>
					<td>
						<button onclick="return validarPublicidadForm('${item.numResolu}','${item.tipoVallaCode}' );" id="myButton"
							class="float-left submit-button">Generar</button></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<div class="col-12 notas_deli" id="notas_deli" style="display: none">
		<div class="alert alert-success mt-3">
			<strong><spring:theme code="impuestos.presentarDeclaracion.deliur.tituloNota1" /></strong>
			<spring:theme code="impuestos.presentarDeclaracion.deliur.nota1" />
		</div>
		<div class="alert alert-info mt-3">
			<strong><spring:theme code="impuestos.presentarDeclaracion.deliur.tituloNota2" /></strong>
			<spring:theme code="impuestos.presentarDeclaracion.deliur.nota2" />
		</div>
	</div>


	<c:out value="${dataFormDelineacion.valCont}" />

	<c:if test="${not empty delineacionWithRadicadosList}">
		<table class="table tabPaginacion">
			<thead>
				<tr>
					<td class="col-md-2">
						<label class="control-label" for="" style="text-transform: none">
							<spring:theme code="impuestos.presentarDeclaracion.deliur.cdu" />
						</label>
					</td>
					<td class="col-md-3">
						<label class="control-label" for="" style="text-transform: none">
							<spring:theme code="impuestos.presentarDeclaracion.deliur.tipobli" />
						</label>
					</td>
					<td class="col-md-3">
						<label class="control-label" for="" style="text-transform: none">
							<spring:theme code="impuestos.presentarDeclaracion.deliur.tiplic" />
						</label>
					</td>
					<td class="col-md-3">
						<label class="control-label" for="" style="text-transform: none">
							<spring:theme code="Evento" />
						</label>
					</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="item" items="${delineacionWithRadicadosList}">
					<tr>
						<td class="col-sm-2">
							<label>${item.cdu}</label>
						</td>
						<td class="col-sm-3">
							<select id="selctipobliga" class="newalto form-control"
								onchange="ShowSelected(this)">
								<option value="0-${item.cdu}">Seleccionar</option>
								<option value="1-${item.cdu}">Declaraci&oacuten</option>
								<option value="2-${item.cdu}">Retenci&oacuten</option>
							</select>
						</td>
						<td class="col-sm-3">
							<select id="btnTpLic_${item.cdu}" class="newalto form-control"
								onchange="establecerTipoLicencia(this)">
								<option value="00">Seleccionar</option>
								<option value="01">Licencia</option>
								<option value="02">Reconocimiento</option>
							</select>
						</td>
						<td class="col-sm-3">
							<c:url var="post_url" value="/contribuyentes/delineacion-urbana/declaracion" />
							<form:form method="post" commandName="inputDelineacion"
								action="${post_url}">
								<c:set var="idCampoTipoLicencia"
									value='tipoLicenciaSeleccionada_${item.cdu}' />
								<form:hidden path="selectedCDU" value="${item.cdu}" />
								<form:hidden path="selectedRadicado" value="" />
								<form:hidden path="selectedTipoLicencia" value=""
									id="${idCampoTipoLicencia}" />
								<form:hidden path="selectedAnoPresDeclaracion" value="" />

								<button type="submit" id="btn_${item.cdu}"
									name="action" value="declaracion" disabled="disabled" class="btn-primary" onclick="return validarDelineacionform('${item.cdu}');">
									<spring:theme code="delineacion.urbana.radicados.declara" />
								</button>
								<button type="submit" class="btn-link" id="auxbtn_${item.cdu}"
									name="action" value="declaracion" hidden="hidden" >
									<spring:theme code="delineacion.urbana.radicados.declara" />
								</button>								
							</form:form>
						</td>
					</tr>

					<c:forEach var="radicado" items="${item.radicados}" varStatus="loopStatus">
						<tr id="${item.cdu}" >
													<td class="col-sm-2">
							<label hidden="true">${item.cdu}</label>
						</td>
							<c:choose>
								<c:when test="${loopStatus.index == 0}">
									<td><label>Radicados:</label></td>
								</c:when>
								<c:otherwise>
								<td/>
								</c:otherwise>
							</c:choose>
							<td class="col-sm-3">
								<label>${radicado.numRadicado}</label>
							</td>
							<td class="col-sm-3">
								<c:url var="post_url" value="/contribuyentes/delineacion-urbana/declaracion" />
								<form:form method="post" commandName="inputDelineacion"
									action="${post_url}">
									<form:hidden path="selectedCDU" value="${item.cdu}" />
									<form:hidden path="selectedRadicado"
										value="${radicado.numRadicado}" />
									<form:hidden path="selectedTipoLicencia" value="" />
									<form:hidden path="selectedAnoPresDeclaracion" value="" />

									<button type="submit" 
										id="btn_presRetencion_${item.cdu}_${loopStatus.index}" name="action" value="retencion" class="btn-primary" disabled="disabled">
										<spring:theme
											code="delineacion.urbana.radicados.retencion.generar" />
									</button>
								</form:form>
							</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<div class="row" id="table-vehicular" style="display: none;">
		<div class="col-md-6 col-md-offset-2">
			<table class="table tabPaginacion" id="table-vehicular1">
				<thead style="cellspacing: 10 !important">
					<tr>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.placa" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.marca" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.linea" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.modelo" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.clase" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.carroceria" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.numpuertas" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.blindado" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.cilindraje" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="sobre.vehiculo.table.presndecla" /></label></th>
						<!-- 						<th style="text-align: center"><label class="control-label" -->
						<%-- 							for=""> <spring:theme --%>
						<%-- 									code="impuestos.presentarDeclaracion.PresentarDeclaracion" /></label></th> --%>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	
	 <div class="row" id="table-predial" style="display: none;">
        <div class="col-md-6 col-md-offset-2">
            <table class="table tabPaginacion" id="table-predial1">
                <thead style="cellspacing: 10 !important">
                    <tr>
                        <th><label class="control-label labeltabletd tableident"><spring:theme
                                    code="predial.inicial.table.chip" /></label></th>
                        <th><label class="control-label labeltabletd tablenumiden"><spring:theme
                                    code="predial.inicial.table.matinmo" /></label></th>
                        <th><label class="control-label labeltabletd "><spring:theme
                                    code="predial.inicial.table.dir" /></label></th>
                        <th><label class="control-label labeltabletd "><spring:theme
                                    code="predial.inicial.table.nocotrato" /></label></th>
                        <th><label class="control-label labeltabletd "><spring:theme
                                    code="predial.inicial.table.presentarDeclaracion" /></label></th>
                     
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<!-- se agrega control para tablas de delineaciï¿½n -->
<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		var selected = value.substring(0, 1);
		var div = value.substring(2, value.length);
		var x = document.getElementById(div);
		var tipoLicencia = document.getElementById("btnTpLic_" + div);
		var btnDeclaracion = document.getElementById("btn_" + div);
	
		if (selected == "2") { //retencion
			tipoLicencia.selectedIndex = "1"
			tipoLicencia.disabled = true;
			btnDeclaracion.disabled = true;
			
			configurarBotonRetencion(div,false);
		} else if(selected == "1"){ //declaracion
			tipoLicencia.selectedIndex = "0"
			tipoLicencia.disabled = false;
			btnDeclaracion.disabled = false;
			configurarBotonRetencion(div,true);
		} else {
			tipoLicencia.selectedIndex = "0"
			tipoLicencia.disabled = false;
			btnDeclaracion.disabled = true;
			configurarBotonRetencion(div,true);
		}
	}
	
	function configurarBotonRetencion(cdu,valDisabled){
		var btnDeclaracion = null;
		for(var i=0;i<100;i++){
			btnPresRetencion = document.getElementById("btn_presRetencion_"+cdu+"_"+i);
			if(btnPresRetencion!=null){
				btnPresRetencion.disabled=valDisabled;
			}else{
				break;
			}
		}
	}

	function establecerTipoLicencia(selectObject) {
		var value = selectObject.value;
		var selected = selectObject.id;
		var div = selected.substring(9);
		div = "tipoLicenciaSeleccionada_" + div;
		var tipoLicencia = document.getElementById(div);
		tipoLicencia.value = value;

	}

	function validateForm() {
	    var anioGravable = document.getElementById("anoGravable").value;
	    var impuesto = document.getElementById("impuesto");
	    var periodo = "00";

        impuesto = impuesto.options[impuesto.selectedIndex].value;

        //Si - Sobretasa a la gasolina - obtener periodo
        if(impuesto == "5"){
            periodo = document.getElementById("periodo").value;
        }

        var currentUrl = window.location.href;
        var targetUrl = "infoObject/getUseOption?anioGravable="	+
        		    anioGravable + "&periodo=" +
        		    periodo + "&taxType=" + impuesto;
        currentUrl = currentUrl.replace("contribuyentes/presentar-declaracion",targetUrl);

        $.ajax({
            url : currentUrl,
        	type : "GET",
        	success : function(data) {
        	    debugger;
        		
        		var opcUso = data;
                if (impuesto == '5' && opcUso == '02') {//Sobretasa a la gasolina
                    promtConfirmation();
        		}else if(impuesto == '3' && opcUso == '02'){//ICA
        		    promtConfirmation();
        		} else {
        			$(".accionGasolina").click();
                    return true;
                }
        	},
        	error : function() {
        	    alert("Error");
        	}
        });
	}

    function promtConfirmation(){
        var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
        if (r == true) {
            document.getElementById("actionHidden").click();
        } else {
            window.location.href = "presentar-declaracion";
        }
    }

    function validarDelineacionform(hiddenCdu){
        var btnSelected = document.getElementById("auxbtn_"+hiddenCdu);

        var nowUrl = window.location.href;
        var targetUrl = "infoObject/getUseOption?cdu="+hiddenCdu+"&taxType=6";
        currentUrl = nowUrl.replace("contribuyentes/presentar-declaracion",targetUrl);

	    $.ajax({
            url : currentUrl,
           	type : "GET",
        	success : function(dataResponse) {
               
        		debugger;
        		
        		if ( dataResponse == "99"){
	               	 alert("Solicite mediante un Trámite la actualización de los datos de la Licencia, una vez actualizado presente su Declaración");
	               	 
      			}else{
	        		if(dataResponse == "02"){
	                    var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
	                    if (r == true) {
	                        btnSelected.click();
	                    } else {
	                        return false;
	                    }
	                }else{
	                   btnSelected.click();
	                 }
      			}	
        	},
        	error : function() {
        	}
        });
	    

        return false;
    }
    
    
    function validarPublicidadForm(numResolu, tipoVallaCode ){
        //var btnSelected = document.getElementById("auxbtn_"+hiddenCdu);
		
        debugger;
        
        var anioGravable = document.getElementById("anoGravable").value;
        
        var urlDeclaracion = "publicidadexterior/declaracion?numResolu="+numResolu+"&anoGravable="+anioGravable+"&tipoValla="+tipoVallaCode;
        
        var nowUrl = window.location.href;
        var targetUrl = "infoObject/getUseOption?anioGravable="+anioGravable+"&taxType=4"+"&numResolu="+numResolu+"&tipoVallaCode="+tipoVallaCode;
        currentUrl = nowUrl.replace("contribuyentes/presentar-declaracion",targetUrl);

	    $.ajax({
            url : currentUrl,
           	type : "GET",
        	success : function(dataResponse) {
               
        		debugger;
        		
       			if(dataResponse == "02"){
                    var r = confirm("Ya tienes una declaraci\u00F3n presentada por este impuesto, a\u00F1o gravable y periodo. Si quieres efectuar una correcci\u00F3n por favor haz clic en -Aceptar- ");
                    if (r == true) {
                    	window.location.href = urlDeclaracion;
                    } else {
                        return false;
                    }
                }else{
                	window.location.href = urlDeclaracion;
                 }
      				
        	},
        	error : function() {
        	}
        });
	    

        return false;
    }
    

</script>

