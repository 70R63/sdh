<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="sobretasa.gasolina.detail.title" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.selectYear" /></label>
	</div>
	<div class="col-md-2">
		<select id="u5013_input" class="form-control">
            <option value="2019">2019</option>
            <option value="2018">2018</option>
            <option value="2017">2017</option>
            <option value="2016">2016</option>
          </select>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.selectMonth" /></label>
	</div>
	<div class="col-md-2">
		<select id="u5195_input" class="form-control">
                    <option value="Enero">Enero</option>
                    <option value="Febrero">Febrero</option>
                    <option value="Marzo">Marzo</option>
                    <option value="Abril">Abril</option>
                    <option value="Mayo">Mayo</option>
                    <option value="Junio">Junio</option>
                    <option value="Julio">Julio</option>
                    <option value="Agosto">Agosto</option>
                    <option value="Septiembre">Septiembre</option>
                    <option value="Octubre">Octubre</option>
                    <option value="Noviembre">Noviembre</option>
                  </select>
	</div>
	<div class="col-md-1 ">
		<button class="btn btn-secondary btn-lg" type="button">
			<spring:theme code="sobretasa.gasolina.detail.search" />
		</button>
	</div>
</div>

<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="sobretasa.gasolina.detail.pedingObligations" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-8">
		<h4>
			<span tabindex="0"><spring:theme code="sobretasa.gasolina.detail.pedingObligations.imporant" /></span>
		</h4>
		<label><spring:theme code="sobretasa.gasolina.detail.pendingObligations.note1" /></label>
		<br/>
		<label><spring:theme code="sobretasa.gasolina.detail.pendingObligations.note2" /></label>
	</div>
</div>


<div class="row">				
	<div class="col-md-6">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="sobretasa.gasolina.detail.pendingObligations.period" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.pendingObligations.status" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.pendingObligations.obligation" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>123456</td>
				  			<td></td>
				  			<td>KR 3d 48K 60 SUR</td>
						</tr>
						<tr>
				  			<td></td>
				  			<td></td>
				  			<td></td>
						</tr>
				  	</tbody>
				  </table>
				</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-8">
		<h4>
			<span tabindex="0"><spring:theme code="sobretasa.gasolina.detail.paymentRelations.title" /></span>
		</h4>
	</div>
</div>


<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.year" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.period" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.referenceNumer" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.formNumber" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.sticker" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.documentType" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.presentationDate" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.nameOrSocialName" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.declarantQuality" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.notificationAddress" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.f1ProductClass" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.f2ReferencePrice" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.f4AlcoholCarburant" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.f5TaxeableBase" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.f6surcharge" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.totalSurcharge" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.vsSanction" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.totalToCharge" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.imLatePaymentIntegerests" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.minusCompetaions" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.detail.paymentRelations.totalPaid" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>123456</td>
				  			<td></td>
				  			<td>KR 3d 48K 60 SUR</td>
						</tr>
						<tr>
				  			<td></td>
				  			<td></td>
				  			<td></td>
						</tr>
				  	</tbody>
				  </table>
				</div>
	</div>
</div>


<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="sobretasa.gasolina.detail.generalData" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.documentType" /></label>
	</div>
	<div class="col-md-2">
         <select id="u5203_input" class="form-control">
            <option value="Seleccionar">Seleccionar</option>
            <option value="Cédula Ciudadanía">Cédula Ciudadanía</option>
            <option value="Cédula Extranjería">Cédula Extranjería</option>
            <option value="Pasaporte">Pasaporte</option>
          </select>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.legalOrganization" /></label>
	</div>
	<div class="col-md-2">
         <select id="u5213_input" class="form-control">
             <option value="Seleccionar">Seleccionar</option>
             <option value="Sociedad colectiva">Sociedad colectiva</option>
             <option value="Sociedad comandita">Sociedad comandita</option>
             <option value="Sociedad limitada">Sociedad limitada</option>
           </select>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.documentNumber" /></label>
	</div>
	<div class="col-md-2">
         <input type="text" class="form-control"/>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.responsableQuality" /></label>
	</div>
	<div class="col-md-2">
         <select id="u5214_input" class="form-control">
            <option value="Seleccionar">Seleccionar</option>
            <option value="Productor">Productor</option>
            <option value="Distribuidor mayorista">Distribuidor mayorista</option>
            <option value="Importador">Importador</option>
          </select>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.responsableSocialName" /></label>
	</div>
	<div class="col-md-2">
         <input type="text" class="form-control"/>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.taxPayerClass" /></label>
	</div>
	<div class="col-md-2">
         <input type="text" class="form-control"/>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.verificationDigit" /></label>
	</div>
	<div class="col-md-2">
         <input type="text" class="form-control"/>
	</div>
</div>

<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="sobretasa.gasolina.detail.basicData" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.productType" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5164_input" class="form-control">
               <option selected="" value="Seleccionar">Seleccionar</option>
               <option value="Gasolina básica corriente">Gasolina básica corriente</option>
               <option value="Gasolina corriente oxigenada">Gasolina corriente oxigenada</option>
               <option value="Gasolina extra básica">Gasolina extra básica</option>
               <option value="Gasolina extra oxigenada">Gasolina extra oxigenada</option>
               <option value="Gasolina de frontera">Gasolina de frontera</option>
             </select>
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.idNumbers" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.customers" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5196_input" class="form-control">
                  <option selected="" value="Seleccionar">Seleccionar</option>
                  <option value="Estación de Servicio">Estación de Servicio</option>
                  <option value="Gran consumidor">Gran consumidor</option>
                  <option value="Distribuidor industrial">Distribuidor industrial</option>
                  <option value="Distribuidor mayorista">Distribuidor mayorista</option>
                </select>
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.plantLocation" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.customerName" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.storageCapacity" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.storageLocation" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.storageCapacity" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.idType" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5286_input" class="form-control">
                  <option value="Seleccionar">Seleccionar</option>
                  <option value="Cédula Ciudadanía">Cédula Ciudadanía</option>
                  <option value="Cédula Extranjería">Cédula Extranjería</option>
                  <option value="Pasaporte">Pasaporte</option>
                </select>
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.tanksCapacity" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>




<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="sobretasa.gasolina.detail.legal" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.idType" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5294_input" class="form-control">
                 <option value="Seleccionar">Seleccionar</option>
                 <option value="Cédula Ciudadanía">Cédula Ciudadanía</option>
                 <option value="Cédula Extranjería">Cédula Extranjería</option>
                 <option value="Pasaporte">Pasaporte</option>
               </select>
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.dataSource" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.idNumber" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.dateFrom" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.systemNumber" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.dateTo" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.name" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.verificationDigit" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobretasa.gasolina.detail.representaitonType" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5295_input" class="form-control">
                  <option value="Seleccionar">Seleccionar</option>
                  <option value="Representante legal">Representante legal</option>
                  <option value="Representante legal suplente">Representante legal suplente</option>
                  <option value="Revisor fiscal">Revisor fiscal</option>
                  <option value="Revisor fiscal suplente">Revisor fiscal suplente</option>
                  <option value="Contador">Contador</option>
                  <option value="Contador suplente">Contador suplente</option>
                </select>
		</div>
	</div>
	
</div>


