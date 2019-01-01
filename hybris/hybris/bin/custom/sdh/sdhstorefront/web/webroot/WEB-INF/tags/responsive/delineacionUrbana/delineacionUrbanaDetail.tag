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
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.title" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-3">
		<label><spring:theme code="delineacion.urbana.detail.selectYear" /></label>
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
			<spring:theme code="delineacion.urbana.detail.search" />
		</button>
	</div>
</div>

<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.pedingObligations" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-8">
		<h4>
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.pedingObligations.imporant" /></span>
		</h4>
		<label><spring:theme code="delineacion.urbana.detail.pendingObligations.notes" /></label>
	</div>
</div>


<div class="row">				
	<div class="col-md-6">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="delineacion.urbana.detail.pendingObligations.period" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.pendingObligations.status" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.pendingObligations.obligation" /></th>
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
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.paymentRelations.title" /></span>
		</h4>
	</div>
</div>


<div class="row">				
	<div class="col-md-12">
		<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.ddu" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.recollectionReference" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.formNumber" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.sticker" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.documentType" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.idType" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.idNumber" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.nameOrSocialName" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.presentationDate" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.notificationAddress" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.propertyAddress" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.realStateRegistration" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.estrato" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.chip" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.licenseNumber" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.expeditionDate" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.radicationNumber" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.type" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.licenseObject" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.mode" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.licenseExtensionNumber" /></th>
				  			
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.resolutionNumber" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.executionDate" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.endingWorkDate" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.lastPaymentDate" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.userCodeORUnitNumber" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.userCodeORUnitNumber2" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.userCodeORUnitNumber3" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.userCodeORUnitNumber4" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.lote" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.basement" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.semiBasement" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.firstFloor" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.otherFloors" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.totalBuild" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.firstFloorFree" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.living" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.commerce" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.services" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.institutional" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.industri" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.others" /></th>
				  			
				  			
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.total" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.amplied" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.modified" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.suitable" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.newWork" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.linearMeters" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.demolition" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.intervenedTotal" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.totalBudgetConstruction" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.currentWOrkValue" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.FU-ChargeTax" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.VS-sanction" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.TR-totalRetention" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.SI-balanceImposeCharged" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.VP-valueToPay" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.IM-arrearsInterests" /></th>
				  			<th><spring:theme code="delineacion.urbana.detail.paymentRelations.TP-totalToPay" /></th>
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
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.generalData" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.documentType" /></label>
	</div>
	<div class="col-md-2">
		<select id="u5013_input" class="form-control">
           <option value="CC">CC</option>
           <option value="NIT">NIT</option>
           <option value="TI">TI</option>
           <option value="CE">CE</option>
         </select>
	</div>
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.idNumber" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.dv" /></label>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.names" /></label>
	</div>
	<div class="col-md-4">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.legalOrganization" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5130_input" class="form-control">
              <option value="Tipo de presentación">Tipo de presentación</option>
            </select>
         </div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.taxPayerClass" /></label>
	</div>
	<div class="col-md-2">
			<div class="form-group ">
				<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
			</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.licenseMode" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5134_input" class="form-control">
	           <option value="Adecuación">Adecuación</option>
	           <option value="Ampliación">Ampliación</option>
	         </select>
	    </div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.endingDate" /></label>
	</div>
	<div class="col-md-2">
			<div class="form-group ">
				<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
			</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.licenseMode" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<select id="u5138_input" class="form-control">
	          <option value="NO">NO</option>
	          <option value="SI">SI</option>
	        </select>
	      </div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.curatorship" /></label>
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
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.basicData" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.addressWork" /></label>
	</div>
	<div class="col-md-4">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.addressWork2" /></label>
	</div>
	<div class="col-md-4">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.county" /></label>
	</div>
	<div class="col-md-4">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.zipCode" /></label>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.estrato" /></label>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.CHIP" />:</label>
	</div>
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.AAA" />:</label>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.unitTypeToBuild" />:</label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
	      <select id="u5147_input" class="form-control">
             <option selected="" value="Equipamentos recreacionales">Equipamentos recreacionales</option>
             <option value="Equipamentos recreativos">Equipamentos recreativos</option>
           </select>
          </div>
	</div>
</div>


<div class="row">				
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.unitQty" /></label>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-1">
		<label><spring:theme code="delineacion.urbana.detail.areaPerUnit" /></label>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>


<div class="row">
	<div class="headline">
		<h3>
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.legal" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.passiveName" /></label>
	</div>
	<div class="col-md-6">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.reponsabilityType" /></label>
	</div>
	<div class="col-md-6">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.ownerFrom" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.ownerTo" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.reponsabilityPercentage" /></label>
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
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.economics" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.workCost" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.indirectCosts" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.constructoion" /></label>
	</div>
	<div class="col-md-2">
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-1">
				M2
			</div>
		</div>
	</div>
	
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.sale" /></label>
	</div>
	<div class="col-md-2">
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-1">
				M2
			</div>
		</div>
	</div>
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.commercialValue" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.meterValue" /></label>
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
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.marks" /></span>
		</h3>
	</div>			
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.exclutionMark" />:</label>
	</div>
	<div class="col-md-6">
		<div class="form-group ">
           <select id="u5074_input" class="form-control">
             <option selected="" value="Obras adelantadas por suejtos signatarios de la convencion de Viena">Obras adelantadas por suejtos signatarios de la convencion de Viena</option>
             <option value="Sociedad Nacional de la Cruz Roja Colombiana">Sociedad Nacional de la Cruz Roja Colombiana</option>
             <option value="Distrito Capital">Distrito Capital</option>
           </select>
          </div>
	</div>
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.markCode" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.descriptionMark" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>



<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.exeptionMark" />:</label>
	</div>
	<div class="col-md-6">
		<div class="form-group ">
           <select id="u5074_input" class="form-control">
             <option selected="" value="Obras adelantadas por suejtos signatarios de la convencion de Viena">Obras adelantadas por suejtos signatarios de la convencion de Viena</option>
             <option value="Sociedad Nacional de la Cruz Roja Colombiana">Sociedad Nacional de la Cruz Roja Colombiana</option>
             <option value="Distrito Capital">Distrito Capital</option>
           </select>
          </div>
	</div>
</div>


<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.markCode" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.descriptionMark" /></label>
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
			<span tabindex="0"><spring:theme code="delineacion.urbana.detail.liquidations" /></span>
		</h3>
	</div>			
</div>

<div class="row">				
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.totalBudget" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-2">
		<label><spring:theme code="delineacion.urbana.detail.currentWorkValue" /></label>
	</div>
	<div class="col-md-2">
		<div class="form-group ">
			<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
		</div>
	</div>
</div>

