<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="avisoheadline">
		<h3>
			<span class="p"><spring:theme code="delineacion.urbana.title"
					text="Delineacion Urbana" /></span>
		</h3>
	</div>
	<p class="avisobody">
		<spring:theme code="delineacion.urbana.desciption" />
	</p>
</div>
<form:form>
	<div class="row">
		<table class="newtable" id="example">
			<thead>
				<tr>
					<th><label class="labeltabla " for=""><spring:theme
								code="delineacion.urbana.CDU" /></label></th>
					<th><label class="labeltabla " for=""> <spring:theme
								code="delineacion.urbana.select" /></label></th>
				</tr>
			</thead>
			<tbody>
		
					<tr>
						<td><c:out value=""></c:out></td>
						<td><input id="action"
							style="visibility: visible !important; margin: 0; min-height: 0;"
							name="action" onchange="" type="radio" value=""></td>
					</tr>
				
			</tbody>
		</table>
	</div>

	<div class="row">
		<div class="col-md-3 col-md-offset-5 center">
			<button action="" type="submit" class="boton" id="" name=""
				value="declarar">
				<spring:theme code="delineacion.urbana.declaration" />
			</button>
		</div>
		<div class="col-md-3 col-md-offset-5 center">
			<button action="" type="submit" class="boton" id="" name=""
				value="rop">
				<spring:theme code="delineacion.urbana.payments.ROPGeneration" />
			</button>
		</div>
				<div class="col-md-2 col-md-offset-5 center">
			<button action="" type="submit" class="boton" id="" name=""
				value="pagolinea">
				<spring:theme code="delineacion.urbana.pago.linea" />
			</button>
		</div>
	</div>
</form:form>