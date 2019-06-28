<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
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

<sf:form>
	<br>
	<div class="container_new">
		<div class="col-md-5 col-md-offset-4 center">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="mibuzon.inicial.verdetalle" /></label>
			</div>
		</div>
		<br> <br>
		<div>
			<div class="row">

				<div class="col-md-4 col-md-offset-4 center">
					<table class="table table-responsive" id="">
						<thead>
							<tr>
								<th style="text-align: center"><label
									class="control-label " for=""
									style="text-transform: capitalize !important"><spring:theme
											code="mibuzon.inicial.tipmsn" /></label></th>
								<th style="text-align: center"><label class="control-label"
									for=""> <spring:theme code="mibuzon.inicial.numero" /></label></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><label class="control-label"
									style="text-transform: capitalize !important"><spring:theme
											code="mibuzon.inicial.noti" /></label></td>
								<td><input id="notificaciones" name="notificaciones"
									class="inputtextnew" aria-required="true" type="text"
									readonly="readonly"
									value="<c:out value="notificaciones"></c:out>" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"
									onclick="myFunction(1)"></td>

							</tr>
							<tr>
								<td><label class="control-label"
									style="text-transform: capitalize !important"><spring:theme
											code="mibuzon.inicial.mns" /></label></td>
								<td><input id="" name="" class="inputtextnew"
									aria-required="true" type="text" readonly="readonly"
									value="<c:out value="mensajes"></c:out>" maxlength="240"
									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"
									onclick="myFunction(2)"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</sf:form>
