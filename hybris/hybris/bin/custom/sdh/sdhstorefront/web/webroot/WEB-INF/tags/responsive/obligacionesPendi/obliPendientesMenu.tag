<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />




<!-- <div>Solo se puede revisar el año 2020, si requiere revisar su información de años anteriores al 2020 visite el siguiente -->
<!-- <a href="https://pit.shd.gov.co/vehiculos/">enlace vehicular</a> -->
<!-- <a href="https://pit.shd.gov.co/predial/">enlace predial</a> -->
<!-- </div> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<div class="container_new_page">
<div class="alert alert-success" role="alert">
 <span><spring:theme code="message.download" /> </span>
</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="obligacion.inicial.encabezado" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="obligacion.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								informaci&oacuten.</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="headline">
			<h2>
				<span><spring:theme code="obligacion.inicial.titulo" /></span>

			</h2>
		</div>
	</div>


	<sf:form modelAttribute="obligacionesFormuno" >
		<div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-3" id="idImpuesto" style="display: none;">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="obligacion.inicial.selcimpuesto" /></label> 
					<sf:select class="new_alto form-control" id="impuesto" name="impuesto"
						path="claveImpuesto" items="${listaImpuestosUsuario}" referenceData="${listaImpuestosUsuario}"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-2">
				<button type="button" class="btn btn-secondary btn-lg" id="action"
					name="action" value="cancelar" style="margin-top: 3px"
					onclick="window.location.href ='<c:url value='/contribuyentes' />';">
					<spring:theme code="obligacion.inicial.cancelar" />
				</button>

			</div>
			<div class="col-md-3">
				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg"
						id="buscarObliPend" name="action" value="buscar"
						style="margin-top: 3px" onclick="buscarObligacionPendiente();">
						<spring:theme code="obligacion.inicial.buscar" />
					</button>
				</div>
			</div>
		</div>
	</sf:form>
</div>
<br>


<script>

function buscarObligacionPendiente(){
	ACC.oblipend.buscarObliPend();
	
}
</script>