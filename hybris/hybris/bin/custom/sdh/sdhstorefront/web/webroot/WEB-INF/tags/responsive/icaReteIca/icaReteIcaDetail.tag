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
			<span tabindex="0"><spring:theme code="ica.reteica.detail.title" /></span>
		</h3>
	</div>			
</div>

<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="ica.reteica.detail.pedingObligations" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-8">
		<h4>
			<span tabindex="0"><spring:theme code="ica.reteica.detail.pedingObligations.imporant" /></span>
		</h4>
		<label><spring:theme code="ica.reteica.detail.pendingObligations.notes" /></label>
	</div>
</div>

<div class="row">				
	<div class="col-md-6">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="ica.reteica.detail.pendingObligations.tax" /></th>
				  			<th><spring:theme code="ica.reteica.detail.pendingObligations.object" /></th>
				  			<th><spring:theme code="ica.reteica.detail.pendingObligations.validity" /></th>
				  			<th><spring:theme code="ica.reteica.detail.pendingObligations.typeobligation" /></th>
				  			<th><spring:theme code="ica.reteica.detail.pendingObligations.officialactdate" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>123456</td>
				  			<td>1</td>
				  			<td>1</td>
				  			<td>1</td>
				  			<td>1</td>
						</tr>
						<tr>
				  			<td>2</td>
				  			<td>2</td>
				  			<td>2</td>
				  			<td>2</td>
				  			<td>2</td>
						</tr>
				  	</tbody>
				  </table>
				</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-8">
		<h4>
			<span tabindex="0"><spring:theme code="ica.reteica.detail.paymentRelations.title" /></span>
		</h4>
	</div>
</div>


<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.validity" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.period" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.reference" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.formnumber" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.financialentity" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.datepresentation" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.transactionnumber" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.paymentindicator" /></th>
				  			<th><spring:theme code="ica.reteica.detail.paymentRelations.certificationamount" /></th>
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
			<span tabindex="0"><spring:theme code="ica.reteica.detail.economics" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="ica.reteica.detail.validity" /></th>
				  			<th><spring:theme code="ica.reteica.detail.commercialappraisal" /></th>
				  			<th><spring:theme code="ica.reteica.detail.tarifa" /></th>
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
			<span tabindex="0"><spring:theme code="ica.reteica.detail.legal" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.ownerFrom" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.reponsabilityPercentage" /></label>
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
			<span tabindex="0"><spring:theme code="ica.reteica.detail.appraisals" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.mark" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.use" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.line" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.displacement" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.model" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.passengers" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.class" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.bodywork" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="ica.reteica.detail.Tipo" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>

</div>


<div class="row">				

</div>

