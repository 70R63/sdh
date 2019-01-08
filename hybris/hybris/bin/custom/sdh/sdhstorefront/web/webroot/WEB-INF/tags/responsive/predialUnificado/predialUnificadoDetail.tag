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
			<span tabindex="0"><spring:theme code="predial.unificado.detail.title" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-3">
		<label><spring:theme code="predial.unificado.detail.selectYear" /></label>
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
			<spring:theme code="predial.unificado.detail.search" />
		</button>
	</div>
</div>

<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="predial.unificado.detail.pedingObligations" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-8">
		<h4>
			<span tabindex="0"><spring:theme code="predial.unificado.detail.pedingObligations.imporant" /></span>
		</h4>
		<label><spring:theme code="predial.unificado.detail.pendingObligations.notes" /></label>
	</div>
</div>


<div class="row">				
	<div class="col-md-6">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="predial.unificado.detail.pendingObligations.period" /></th>
				  			<th><spring:theme code="predial.unificado.detail.pendingObligations.status" /></th>
				  			<th><spring:theme code="predial.unificado.detail.pendingObligations.obligation" /></th>
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
			<span tabindex="0"><spring:theme code="predial.unificado.detail.paymentRelations.title" /></span>
		</h4>
	</div>
</div>


<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.taxableyear" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.period" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.idtyper" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.identificationnumber" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.nameorsocialreason" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.document" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.documentdate" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.paymentidentification" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.sanctionvalue" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.notificationAddress" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.valueinterests" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.discountvalue" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.amounttobepaid" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.valuevoluntarycontribution" /></th>
				  			<th><spring:theme code="predial.unificado.detail.paymentRelations.totalvaluepaidr" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
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
			<span tabindex="0"><spring:theme code="predial.unificado.detail.economic" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.terrainarea" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.areapredio" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.stratum" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.destination" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.tarifa" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.excenction" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>

</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.exclusions" /></label>
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
			<span tabindex="0"><spring:theme code="predial.unificado.detail.legal" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.ownerFrom" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="predial.unificado.detail.reponsabilityPercentage" /></label>
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
			<span tabindex="0"><spring:theme code="predial.unificado.detail.appraisals" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="predial.unificado.detail.date" /></th>
				  			<th><spring:theme code="predial.unificado.detail.propertyvaluation" /></th>
				  			<th><spring:theme code="predial.unificado.detail.basegravable" /></th>
				  			<th><spring:theme code="predial.unificado.detail.declaredappraisal" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
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
						</tr>
				  		<tr>
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
						</tr>
						<tr>
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
						</tr>
				  	</tbody>
				  </table>
				</div>
	</div>
</div>
<div class="row">				
	<div class="col-md-8">
		<label><spring:theme code="predial.unificado.detail.message1" /></label>
		<label><spring:theme code="predial.unificado.detail.message2" /></label>
		<label><spring:theme code="predial.unificado.detail.message3" /></label>
	</div>
</div>

