<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="row" id="idmensajes">
	<div class="col-md-6 col-md-offset-1 headline">
		<h2>
			<span><spring:theme code="mibuzon.mensajes.mensajes" /></span>
		</h2>
	</div>
</div>
<sf:form>
<div style=" aling-items: center; justify-content: center">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 center headline">
			<h2>
				<span><spring:theme code="mibuzon.mensajes.nuevos" /></span>
			</h2>
		</div>
	</div>
	<div>
		<div class="row">

			<div class="col-md-7 col-md-offset-3 center">
				<table class="table" id="">
					<thead>
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme code="mibuzon.mensajes.identi" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.autoridad" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.asunto" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.fecnoti" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.papelera" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="identifi"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="autoridad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="asunto"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fechanotificacion"></c:out>"
								maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><img src="${themeResourcePath}/images/papeleranuevos.png" style= "width: 30px"></img></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-6 col-md-offset-3 headline">
			<h2>
				<span><spring:theme code="mibuzon.mensajes.leidos" /></span>
			</h2>
		</div>
	</div>
	<div>
		<div class="row">

			<div class="col-md-7 col-md-offset-3 center">
				<table class="table" id="">
					<thead>
						<tr>
							<th style="text-align: center"><label class="control-label "
								for=""><spring:theme code="mibuzon.mensajes.identi" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.autoridad" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.asunto" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.fecnoti" /></label></th>
							<th style="text-align: center"><label class="control-label"
								for=""> <spring:theme code="mibuzon.mensajes.papelera" /></label></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="identifi"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="autoridad"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="asunto"></c:out>" maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><input id="" name="" class="inputtextnew"
								aria-required="true" type="text" readonly="readonly"
								value="<c:out value="fechanotificacion"></c:out>"
								maxlength="240"
								style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
							<td><img src="${themeResourcePath}/images/papeleraleidos.png" style= "width: 20px"></img></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
</sf:form>
