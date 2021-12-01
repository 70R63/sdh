<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />


<div class="container">
	<br>
	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />
	<div id="causales">
		<div class="row">
			<div class="col-md-10">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<td colspan="2" style="text-align: center"><strong><spring:theme
											code="CAUSALES DE SANCIÓN: " /></strong> <spring:theme
										code="Elegir una de las siguientes opciones: " /></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="1. No suministró la información" />
								</label></td>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="" /><input type="checkbox" name="" id=""
										class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								</label></td>
							</tr>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="2. Suministró información en forma errónea" />
								</label></td>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="" /><input type="checkbox" name="" id=""
										class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								</label></td>
							</tr>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="3. Suministró información extemporaneamente" />
								</label></td>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="" /><input type="checkbox" name="" id=""
										class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								</label></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="baseLiquidacion">
		<div class="row">
			<div class="col-md-10">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<td colspan="2" style="text-align: center"><strong><spring:theme
											code="ESTABLECER LA BASE DE LIQUDACIÓN DE LA SANCIÓN: " /></strong> <spring:theme
										code="Ingrese los montos según corresponda: " /></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="1. Digitar las sumas sobre la información que no reportó información o se reportó errónea o extemporalmente" />
								</label></td>
								<td style="border: 0px !important"><input type="text"
									name="" id="" class="form-check-input mr-2"
									style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"></td>
							</tr>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="2. No se puede establecer base o no existe cuantía, ingrese el valor según sea el caso (solo una opción): " />
								</label></td>
							</tr>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="Digite valor de los ingresos netos" />
								</label></td>
									<td style="border: 0px !important"><input type="text"
									name="" id="" class="form-check-input mr-2"
									style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"></td>
							</tr>
								<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="Digite patrimonio bruto del año anterior o ultima declaración de renta o de ing y patrimonio" />
								</label></td>
									<td style="border: 0px !important"><input type="text"
									name="" id="" class="form-check-input mr-2"
									style="visibility: visible !important; min-height: 4px !important; margin-left: 12px"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div id="conductaAnterior">
		<div class="row">
			<div class="col-md-10">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<td style="text-align: center"><strong><spring:theme
											code="CONDUCTA ANTERIOR" /></strong></td>
								<td style="text-align: center"><strong><spring:theme
											code="SI" /></strong></td>
								<td style="text-align: center"><strong><spring:theme
											code="NO" /></strong></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="Ha presentado la conducta en los dos años anteriores? Y que no se haya proferido pliego de cargos " />
								</label></td>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="" /><input type="checkbox" name="" id=""
										class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								</label></td>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="" /><input type="checkbox" name="" id=""
										class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								</label></td>
							</tr>
							<tr>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme
											code="Ha presentado la conducta dentro del año anterior? Y que no se haya proferido pliego de cargos " />
								</label></td>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="" /><input type="checkbox" name="" id=""
										class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								</label></td>
								<td style="border: 0px !important"><label
									class="form-check-label" style="text-transform: none">
										<spring:theme code="" /><input type="checkbox" name="" id=""
										class="form-check-input mr-2"
										style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
								</label></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-offset-5">
			<div class="form-group ">
				<button class="btn btn-primary btn-block" type="button" onclick="showTotal()">
					<spring:theme code="Calcular" />
				</button>
			</div>
		</div>
	</div>
</div>
