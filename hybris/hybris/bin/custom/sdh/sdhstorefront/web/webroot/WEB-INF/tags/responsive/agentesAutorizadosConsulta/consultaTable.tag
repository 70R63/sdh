<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<script type="text/javascript">
 	var resultado = new Array();
 	<c:forEach items="${fileConsultaResponse.resultado}" var="resul" varStatus="status">
 		resultado[${status.index}] = "${resul.stringFile}";
 	</c:forEach>
 	
 	
    function downloadPDF(indexItem) {
    	debugger;
        var dlnk = document.getElementById('dwnldLnk');
			if(resultado != null){ 
 	            dlnk.href = 'data:application/octet-stream;base64,' + resultado[indexItem];
    	        dlnk.click();
			}
    }
</script>

<div class="container">
	<div class="row" style="margin-top: 50px !important">
		<div class="col-md-7">
			<div class="table-responsive">
				<table class="table" id="example">
					<thead style="background-color: #006DCC !important">
						<tr>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.secuencia" /> </label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.tiparc" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.idenvio" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"> <spring:theme
										code="autorizado.consultas.tabla.fecenvio" />
							</label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"><spring:theme
										code="autorizado.consultas.tabla.fecnoti" /></label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"> <spring:theme
										code="autorizado.consultas.tabla.resultado" />
							</label></th>
							<th style="text-align: center"><label
								class="control-label labeltabletd tablefechas"> <spring:theme
										code="autorizado.consultas.tabla.reporte" />
							</label></th>
						</tr>
					</thead>
					<tbody data-customvalueone="${beanName.attrName}">
						<c:forEach items="${fileConsultaResponse.resultado}" var="itemResultado" varStatus="loopStatus">
							<tr>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value="${itemResultado.nroSecuencia}"
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value="${itemResultado.tipoFile}"
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value="${itemResultado.idEnvio}"
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value="${itemResultado.fchEnvio}"
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value="${itemResultado.fchEnvio}"
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value="${itemResultado.estado}"
									maxlength="240"></td>
								<td>
								    <a id='dwnldLnk' download='archivo.pdf' style="display:none;" > </a>
								    <a href="#" onclick='downloadPDF("${loopStatus.index}");' title='archivo.pdf'>Descargar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

