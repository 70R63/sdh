<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

		<div class="row">
			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="sobre.vehiculos.title" text="Mis Vehiculos"/></span>
				</h2>
			</div>			
			<p><spring:theme code="sobre.vehiculos.desciption" /></p>	
			
		</div>
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="sobre.vehiculos.propertiesList" /></span>
				</h3>
			</div>	
		</div> 
		<br/>
		<div class="row">				
			<div class="col-md-2 text-right">
				<label><spring:theme code="sobre.vehiculos.showing" /></label>
			</div>
			<div class="col-md-2">
				<select id="u5013_input" class="form-control">
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="50">50</option>
                </select>
			</div>
			<div class="col-md-2 ">
				<label><spring:theme code="sobre.vehiculos.dataPerPage" /></label>
			</div>
			<div class="col-md-2 text-right">
				<label><spring:theme code="sobre.vehiculos.search" /></label>
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
				  			<th><spring:theme code="sobre.vehiculos.licenseplate" /></th>
				  			<th><spring:theme code="sobre.vehiculos.brand" /></th>
				  			<th><spring:theme code="sobre.vehiculos.officialactdate" /></th>
				  			<th><spring:theme code="sobre.vehiculos.select" /></th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>123456</td>
				  			<td></td>
				  			<td>KR 3d 48K 60 SUR</td>
				  			<td>
								<input id="consentForm.consentGiven1" style="visibility: visible !important; margin:0;min-height:0;" name="consentForm.consentGiven" type="checkbox" value="true">
							</td>
						</tr>
						<tr>
				  			<td>678909</td>
				  			<td></td>
				  			<td>KR 5D 48K 60 SUR</td>
				  			<td>
								<input id="consentForm.consentGiven1" style="visibility: visible !important; margin:0;min-height:0;" name="consentForm.consentGiven" type="checkbox" value="true">
							</td>
						</tr>
				  	</tbody>
				  </table>
				</div>
			</div>
			<div class="col-md-4">
				<label><spring:theme code="sobre.vehiculos.whatToSee" /></label>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <!-- <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.seeDetail" /></li>   -->
						  <c:url value="/contribuyentes2/sobrevehiculosautomotores/detail" var="sobreVehiculosDetail"/>
						  <li><a href="${sobreVehiculosDetail}"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.seeDetail" /></a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled ">
						  <li ><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#declarationMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.billing" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="facturasMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.billing.downloadinvoice" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.billing.additionaldiscount" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.billing.redirectinginvoices" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.billing.billmodificationrequest" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.billing.billcancellationrequest" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled ">
						  <li ><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#declarationMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.declaration" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="declarationMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.declaration.declaration" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.declaration.corrections" /></li>
						  <li><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobre.vehiculos.declaration.paymentcoupons" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#pagosMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="predial.unificado.payments" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="pagosMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="predial.unificado.payments.ROPGeneration" /></li>
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="predial.unificado.payments.PSE" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#reportesMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="predial.unificado.reports" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="reportesMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.reports.paymentCertifications" /></li>
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.reports.pendingDuties" /></li>
						   <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.reports.paymentRelation" /></li>
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.reports.accountStatement" /></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#reportesMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobre.vehiculos.massiveLiquidations" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="liquidacionesmasivasMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="predial.unificado.massiveLiquidations" /></li>
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
	


