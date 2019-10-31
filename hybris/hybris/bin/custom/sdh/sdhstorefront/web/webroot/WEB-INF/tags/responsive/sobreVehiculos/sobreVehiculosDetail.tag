<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form>
	<div class="container">
		<div class="row">
			<div class="col-md-6 headline">
				<h2>
					<span><spring:theme code="sobre.vehiculo.detail.title" /></span>
				</h2>
			</div>
		</div>


		<br>
		<div class="col-md-1">
			<label class="control-label"><spring:theme
					code="sobre.vehiculo.detail.placa" /></label>
		</div>
		<div class="col-md-2">
			<input id="placas" name="" class="newalto form-control placas"
				type="text" readonly="readonly" maxlength="240">
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-10">
				<br>
				<table class="table">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.idServicio" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.idestado" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.watts" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.clasanti" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.tipvehiculo" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.cappasa" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.capton" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.fecinacti" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.detail.feccambio" /></label></th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><input id="inidServicio" name=""
								class="inputtextnew inidServicio" type="text"
								readonly="readonly" value="" maxlength="240"
								style="width: 100% !important;"></td>
							<td><input id="inidEstado" name=""
								class="inputtextnew inidEstado" type="text" readonly="readonly"
								value="" maxlength="240" style="width: 100% !important;"></td>
							<td><input id="inwatts" name="" class="inputtextnew inwatts"
								type="text" readonly="readonly" value="" maxlength="240"
								style="width: 100% !important;"></td>
							<td><input id="inclasico" name=""
								class="inputtextnew inclasico" type="text" readonly="readonly"
								value="" maxlength="240" style="width: 100% !important;"></td>
							<td><input id="intipvehiculo" name=""
								class="inputtextnew intipvehiculo" type="text"
								readonly="readonly" value="" maxlength="240"
								style="width: 100% !important;"></td>
							<td><input id="inpasajeros" name="" class="inputtextnew inpasajeros" type="text"
								readonly="readonly" value=""
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="inton" name="" class="inputtextnew inton" type="text"
								readonly="readonly" value=""
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="infecinacti" name="" class="inputtextnew infecinacti" type="text"
								readonly="readonly" value=""
								maxlength="240" style="width: 100% !important;"></td>
							<td><input id="infechacambio" name="" class="inputtextnew infechacambio" type="text"
								readonly="readonly" value=""
								maxlength="240" style="width: 100% !important;"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</sf:form>