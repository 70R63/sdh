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
			<span tabindex="0"><spring:theme code="sobre.vehiculos.detail.title" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-3">
		<label><spring:theme code="sobre.vehiculos.detail.selectYear" /></label>
	</div>
	<div class="col-md-2">
		<select id="u5013_input" class="form-control">
            <option value="2019">2019</option>
            <option value="2018">2018</option>
            <option value="2017">2017</option>
            <option value="2016">2016</option>
          </select>
	</div>
	<div class="col-md-2 ">
		<button class="btn btn-secondary btn-lg" type="button">
			<spring:theme code="sobre.vehiculos.detail.search" />
		</button>
	</div>
</div>

<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="sobre.vehiculos.detail.pedingObligations" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-8">
		<h4>
			<span tabindex="0"><spring:theme code="sobre.vehiculos.detail.pedingObligations.imporant" /></span>
		</h4>
		<label><spring:theme code="sobre.vehiculos.detail.pendingObligations.notes" /></label>
	</div>
</div>


<div class="row">				
	<div class="col-md-6">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="sobre.vehiculos.detail.pendingObligations.period" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.pendingObligations.status" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.pendingObligations.obligation" /></th>
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
			<span tabindex="0"><spring:theme code="sobre.vehiculos.detail.paymentRelations.title" /></span>
		</h4>
	</div>
</div>


<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.taxableyear" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.period" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.reference" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.formnumber" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.financialentity" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.datepresentation" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.transactionnumber" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.paymentindicator" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.paymentRelations.certificationamount" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>123456</td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
						</tr>
						<tr>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
				  			<td></td>
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
			<span tabindex="0"><spring:theme code="sobre.vehiculos.detail.economics" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="sobre.vehiculos.detail.validity" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.commercialappraisal" /></th>
				  			<th><spring:theme code="sobre.vehiculos.detail.tarifa" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>123456</td>
				  			<td></td>
				  			<td></td>
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
			<span tabindex="0"><spring:theme code="sobre.vehiculos.detail.legal" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.ownerFrom" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.reponsabilityPercentage" /></label>
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
			<span tabindex="0"><spring:theme code="sobre.vehiculos.detail.appraisals" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.mark" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.use" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.line" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.displacement" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.model" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.passengers" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.class" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.bodywork" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="sobre.vehiculos.detail.Tipo" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>

</div>


<div class="row">				

</div>

