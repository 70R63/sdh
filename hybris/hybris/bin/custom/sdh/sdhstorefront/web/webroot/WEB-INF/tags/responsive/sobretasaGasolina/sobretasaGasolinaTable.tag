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
					<span tabindex="0"><spring:theme code="sobretasa.gasolina.title" /></span>
				</h2>
			</div>			
			<p><spring:theme code="sobretasa.gasolina.desciption" /></p>	
			
		</div>
		<br/>
		<div class="row">				
			<div class="col-md-2 text-right">
				<label><spring:theme code="sobretasa.gasolina.showing" /></label>
			</div>
			<div class="col-md-2">
				<select id="u5013_input" class="form-control">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="50">50</option>
                  </select>
			</div>
			<div class="col-md-2 ">
				<label><spring:theme code="sobretasa.gasolina.dataPerPage" /></label>
			</div>
			<div class="col-md-2 text-right">
				<label><spring:theme code="sobretasa.gasolina.search" /></label>
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
				  			<th><spring:theme code="sobretasa.gasolina.documentType" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.documentNumber" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.gasType" /></th>
				  			<th><spring:theme code="sobretasa.gasolina.select" /></th>
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
				  			<td></td>
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
				<label><spring:theme code="sobretasa.gasolina.whatToSee" /></label>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
							<c:url value="/contribuyentes/sobretasa-gasolina/detail" var="sobretasaGasolinaDetail"/>
						  <li><a href="${sobretasaGasolinaDetail}"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.seeDetail" /></a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled ">
						  <li ><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#declarationMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.declaration" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="declarationMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
<%-- 						  <c:url value="/contribuyentes/delineacion-urbana/declaraciones" var="delieacionUrbanaDeclaracionesURL"/> --%>
						  <li><a href="${ delieacionUrbanaDeclaracionesURL}"><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobretasa.gasolina.declaration.declaration" /></a></li>
<%-- 						  <c:url value="/contribuyentes/delineacion-urbana/correcciones" var="delieacionUrbanaCorreccionesURL"/> --%>
						  <li><a href="${ delieacionUrbanaCorreccionesURL}"><span class="glyphicon glyphicon-edit"></span>&nbsp;<spring:theme code="sobretasa.gasolina.declaration.corrections" /></a></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#pagosMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.payments" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="pagosMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.payments.ROPGeneration" /></li>
<%-- 						  <c:url value="/contribuyentes/delineacion-urbana/pagos/pse" var="delieacionUrbanaPagosPSEURL" /> --%>
						  <li><a href="${ delieacionUrbanaPagosPSEURL}"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.payments.PSE" /></a></li>
						</ul>
					</div>		
				</div>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<ul class="list-unstyled">
						  <li><a href="javascript:;" onclick="$('.menu').addClass('hidden');$('#reportesMenu').removeClass('hidden');"><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.reports" /></a></li>
						</ul>
					</div>
					<div class="col-md-6 col-xs-6">
						<ul id="reportesMenu" class="list-unstyled hidden menu" style="position: absolute; z-index: 1000;">
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.reports.pendingDuties" /></li>
						   <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.reports.paymentRelation" /></li>
						  <li><span class="glyphicon glyphicon-edit" ></span>&nbsp;<spring:theme code="sobretasa.gasolina.reports.accountStatement" /></li>
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


