<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana" tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>

<template:page pageTitle="${pageTitle}">
	<div class="container">
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="delineacion.urbana.pagos.idData" /></span>
				</h3>
			</div>			
		</div>

		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.idType" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.idNumber" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-1">
				<label><spring:theme code="delineacion.urbana.pagos.dv" /></label>
			</div>
			<div class="col-md-1">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>	
		</div>		
		<div class="row">
			
						
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.socialName" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.phone" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.email" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.notificationAddress" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.county" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.department" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="delineacion.urbana.pagos.paymentData" /></span>
				</h3>
			</div>			
		</div>

		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.selectBank" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<select id="u421_input" class="form-control">
                      <option value="Seleccionar">Seleccionar</option>
                      <option value="Bancolombia">Bancolombia</option>
                      <option value="BBVA">BBVA</option>
                      <option value="Davivienda">Davivienda</option>
                    </select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.valueToPay" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-1">
				<label><spring:theme code="delineacion.urbana.pagos.cops" /></label>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.pagos.cardType" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<select id="u426_input" class="form-control">
                      <option selected="" value="Seleccionar">Seleccionar</option>
                      <option value="Debito">Debito</option>
                      <option value="Crédito">Crédito</option>
                    </select>
				</div>
			</div>
		</div>	
	</div>	
</template:page>

<script>

window.onload = function() {
	debugger;
	var cosas = $(":input");
	var tam = cosas.length;
	if (false){
		for (var i = 0; i < tam; i++) {
			var valor = cosas[i].value;
			if (valor == "") {
				cosas[i].value = "-";

			}
		}
	}
}
</script>
