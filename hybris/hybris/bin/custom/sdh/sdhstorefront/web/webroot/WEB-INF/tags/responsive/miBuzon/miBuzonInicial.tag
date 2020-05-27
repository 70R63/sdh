<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="mibuzon.inicial.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="mibuzon.inicial.descripcion" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<c:if test="${not empty errores}">
			<c:forEach items="${errores}" var="msg">
				<div class="alert alert-danger alert-dismissable getAccAlert">
					<button class="close closeAccAlert" aria-hidden="true" data-dismiss="alert" type="button">&times;</button>
					<spring:theme code="${msg.id_msj}" arguments="${msg.txt_msj}" htmlEscape="false" var="errorMessages"/>
<%-- 					${ycommerce:sanitizeHTML(errorMessages)} --%>
				</div>
			</c:forEach>
		</c:if>

<sf:form>
	<br>
	<div class="container">
		<div class="col-md-5 col-md-offset-4 center">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="mibuzon.inicial.verdetalle" /></label>
			</div>
		</div>
		<br> <br>
		
		</div>
	
</sf:form>
