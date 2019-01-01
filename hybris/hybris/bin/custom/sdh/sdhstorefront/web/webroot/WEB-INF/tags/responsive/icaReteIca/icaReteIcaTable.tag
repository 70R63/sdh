<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

		<div class="container">
		
		<div class="row">
			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="ica.reteica.title" text="Mis actividades ICA"/></span>
				</h2>
			</div>			
			<p><spring:theme code="ica.reteica.desciption" /></p>	
			
		</div>
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="ica.reteica.propertiesList" /></span>
				</h3>
			</div>	
		</div> 
		<br/>
		<div class="row">				
			<div class="col-md-2 text-right">
				<label><spring:theme code="ica.reteica.showing" /></label>
			</div>
			<div class="col-md-2">
				<select id="u5013_input" class="form-control">
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="50">50</option>
                </select>
			</div>
			<div class="col-md-2 ">
				<label><spring:theme code="ica.reteica.dataPerPage" /></label>
			</div>
			<div class="col-md-2 text-right">
				<label><spring:theme code="ica.reteica.search" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="table-responsive">
				  <table class="table">
				  	<thead>
				  		<tr>
				  			<th><spring:theme code="ica.reteica.code" /></th>
				  			<th><spring:theme code="ica.reteica.description" /></th>
				  			<th><spring:theme code="ica.reteica.registrationdate" /></th>
				  			<th><spring:theme code="ica.reteica.select" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>123456</td>
				  			<td></td>
				  			<td></td>
				  			<td>
								<input id="consentForm.consentGiven1" style="visibility: visible !important; margin:0;min-height:0;" name="consentForm.consentGiven" type="checkbox" value="true">
							</td>
						</tr>
						<tr>
				  			<td>678909</td>
				  			<td></td>
				  			<td></td>
				  			<td>
								<input id="consentForm.consentGiven1" style="visibility: visible !important; margin:0;min-height:0;" name="consentForm.consentGiven" type="checkbox" value="true">
							</td>
						</tr>
				  	</tbody>
				  </table>
				</div>
			</div>
			<div class="col-md-4">
				<label><spring:theme code="ica.reteica.whatToSee" /></label>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <!-- <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.seeDetail" /></li>  -->
						  <c:url value="/contribuyentes2/icareteica/detail" var="icaReteIcaDetail"/>
						  <li><a href="${icaReteIcaDetail}"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.seeDetail" /></a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled ">
						  <li ><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#declarationMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.billing" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="declarationMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.billing.downloadinvoice" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.billing.additionaldiscount" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.billing.redirectinginvoices" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.billing.billmodificationrequest" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.billing.billcancellationrequest" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled ">
						  <li ><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#declarationMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="predial.unificado.declaration" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="declarationMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.declaration.declaration" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.declaration.corrections" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="ica.reteica.declaration.paymentcoupons" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#pagosMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.payments" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="pagosMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.payments.ROPGeneration" /></li>
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.payments.PSE" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#reportesMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.reports" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="reportesMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.reports.paymentCertifications" /></li>
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.reports.pendingDuties" /></li>
						   <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.reports.paymentRelation" /></li>
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.reports.accountStatement" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#reportesMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.massiveLiquidations" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="massiveLiquidationsMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="ica.reteica.massiveLiquidations" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<br />
				</div>
				<div class="row">
				<br />
				</div>
			</div>	
		</div>
	</div>


