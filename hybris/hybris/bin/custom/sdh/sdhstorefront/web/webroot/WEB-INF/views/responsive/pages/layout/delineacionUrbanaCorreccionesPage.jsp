<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="delineacionUrbana" tagdir="/WEB-INF/tags/responsive/delineacionUrbana"%>

<div class="loader"></div>
<template:page pageTitle="${pageTitle}">
	<div class="container">
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="delineacion.urbana.corrections.idData" /></span>
				</h3>
			</div>	
		</div> 
		<br/>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.idType" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.idNumber" /></label>
			</div>
			<div class="col-md-3">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-1">
				<label><spring:theme code="delineacion.urbana.corrections.dv" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>				
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.socialName" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.phone" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.notificationAddress" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.county" /></label>
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
					<span tabindex="0"><spring:theme code="delineacion.urbana.corrections.propertyData" /></span>
				</h3>
			</div>	
		</div> 
		<br/>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.propertyAddress" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.estrato" /></label>
			</div>
			<div class="col-md-1">
				<div class="form-group ">
					<select id="u2465_input" class="form-control">
                            <option value="N/A">N/A</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                          </select>
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.license" /></label>
			</div>
			<div class="col-md-1">
				<div class="form-group ">
					<select id="u2483_input" class="form-control">
                            <option value="Seleccionar">Seleccionar</option>
                            <option value="050S">050S</option>
                            <option value="050C">050C</option>
                            <option value="050N">050N</option>
                          </select>
				</div>
			</div>
			<div class="col-md-2">
				<div class="row">
					<div class="col-md-1">
						<label>-</label>
					</div>
					<div class="col-md-10">
						<div class="form-group ">
							<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
						</div>
					</div>
				</div>
			</div>				
		</div>
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.chip" /></label>
			</div>
			<div class="col-md-1">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="AAA" maxlength="240">
				</div>
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
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="delineacion.urbana.corrections.licenseData" /></span>
				</h3>
			</div>	
		</div> 
		<br/>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.budgetWork" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<select id="u2492_input" class="form-control">
                      <option value="Calcular con Base en la Resoluci�n de la Secretar�a de Hacienda y Planeaci�n">Calcular con Base en la Resoluci�n de la Secretar�a de Hacienda y Planeaci�n</option>
                      <option value="Incorporar el valor de su presupuesto estimado">Incorporar el valor de su presupuesto estimado</option>
                    </select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.causal" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<select id="u2494_input"  class="form-control">
                            <option value="Obras Nuevas Vis estratos 1, 2 y 3">Obras Nuevas Vis estratos 1, 2 y 3</option>
                          </select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.constructionNumber" /></label>
			</div>
			<div class="col-md-2">
				<div class="col-md-10">
						<div class="form-group ">
							<select id="u2483_input" class="form-control">
		                            <option value="Seleccionar">Seleccionar</option>
		                            <option value="050S">050S</option>
		                            <option value="050C">050C</option>
		                            <option value="050N">050N</option>
		                          </select>
						</div>
					</div>
					<div class="col-md-1">
						<label>-</label>
					</div>
			</div>
			<div class="col-md-2">
				<div class="col-md-10">
						<div class="form-group ">
							<select id="u2483_input" class="form-control">
		                            <option value="Seleccionar">Seleccionar</option>
		                            <option value="050S">050S</option>
		                            <option value="050C">050C</option>
		                            <option value="050N">050N</option>
		                          </select>
						</div>
					</div>
					<div class="col-md-1">
						<label>-</label>
					</div>
			</div>
			<div class="col-md-2">
				<div class="col-md-10">
						<div class="form-group ">
							<select id="u2483_input" class="form-control">
		                            <option value="Seleccionar">Seleccionar</option>
		                            <option value="050S">050S</option>
		                            <option value="050C">050C</option>
		                            <option value="050N">050N</option>
		                          </select>
						</div>
					</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.type" /></label>
			</div>
			<div class="col-md-2">
						<div class="form-group ">
							<select id="u2512_input" class="form-control">
	                            <option value="Licencia">Licencia</option>
	                            <option value="Reconocimiento">Reconocimiento</option>
	                          </select>
						</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.licenseObject" /></label>
			</div>
			<div class="col-md-2">
						<div class="form-group ">
							<select id="u2514_input" class="form-control">
	                            <option value="Inicial">Inicial</option>
	                            <option value="Modificaci�n de la Licencia">Modificaci�n de la Licencia</option>
	                          </select>
						</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.licenseMode" /></label>
			</div>
			<div class="col-md-2">
						<div class="form-group ">
							<select id="u2516_input" class="form-control">
                            <option value="Adecuaci�n">Adecuaci�n</option>
                            <option value="Ampliaci�n">Ampliaci�n</option>
                          </select>
						</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="delineacion.urbana.corrections.liquidationData" /></span>
				</h3>
			</div>	
		</div> 
		
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.extensionLicense" /></label>
			</div>
			<div class="col-md-1">
						<div class="form-group ">
							<select id="u2516_input" class="form-control">
                            <option value="Adecuaci�n">NO</option>
                            <option value="Ampliaci�n">SI</option>
                          </select>
						</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.resolutionNumber" /></label>
			</div>
			<div class="col-md-1">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.endingDate" /></label>
			</div>
			<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.lastPaymentDate" /></label>
			</div>
			<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.expirationDate" /></label>
			</div>
			<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
			</div>
		</div>
		
		
		
		<div class="row">
		<div class="headline">
			<h3>
				<span tabindex="0"><spring:theme code="delineacion.urbana.corrections.squareAndUsesData" /></span>
			</h3>
		</div>	
	</div> 
	
	<div class="row">
		<div class="col-md-3" style="border: 1px solid gray;">
			<br>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.useCode" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<select id="u2443_input" class="form-control">
                             <option value="Vivienda Estrato 1">Vivienda Estrato 1</option>
                             <option value="Comercio Metropolitano">Comercio Metropolitano</option>
                             <option value="Servicios Vecinal o Local">Servicios Vecinal o Local</option>
                           </select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.unitNumber" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<input type="text" class="form-control" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3" style="border: 1px solid gray;">
			<br>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.useCode" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<select id="u2443_input" class="form-control">
                             <option value="Vivienda Estrato 1">Vivienda Estrato 1</option>
                             <option value="Comercio Metropolitano">Comercio Metropolitano</option>
                             <option value="Servicios Vecinal o Local">Servicios Vecinal o Local</option>
                           </select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.unitNumber" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<input type="text" class="form-control" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3" style="border: 1px solid gray;">
			<br>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.useCode" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<select id="u2443_input" class="form-control">
                             <option value="Vivienda Estrato 1">Vivienda Estrato 1</option>
                             <option value="Comercio Metropolitano">Comercio Metropolitano</option>
                             <option value="Servicios Vecinal o Local">Servicios Vecinal o Local</option>
                           </select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.unitNumber" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<input type="text" class="form-control" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3" style="border: 1px solid gray;">
			<br>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.useCode" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<select id="u2443_input" class="form-control">
                             <option value="Vivienda Estrato 1">Vivienda Estrato 1</option>
                             <option value="Comercio Metropolitano">Comercio Metropolitano</option>
                             <option value="Servicios Vecinal o Local">Servicios Vecinal o Local</option>
                           </select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label><spring:theme code="delineacion.urbana.corrections.unitNumber" /></label>
				</div>
				<div class="col-md-6">
					<div class="form-group ">
						<input type="text" class="form-control" />
					</div>
				</div>
			</div>
		</div>
	</div> 
		
	<br>
	<div class="row">
		<div id="tabs">
			  <ul>
			    <li><a href="#tabs-1"><spring:theme code="delineacion.urbana.corrections.areasProject" /></a></li>
			    <li><a href="#tabs-2"><spring:theme code="delineacion.urbana.corrections.areasToUse" /></a></li>
			    <li><a href="#tabs-3"><spring:theme code="delineacion.urbana.corrections.areasInverted" /></a></li>
			  </ul>
			  <div id="tabs-1">
			    <div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.lote" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.basement" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.semibasement" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.firstFloor" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.otherFloors" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.totalbuild" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.freeFirstFloor" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<input type="text" class="form-control" />
						</div>
					</div>
				</div>
			  </div>
			  
			  
			  
			  <div id="tabs-2">
			    <div class="row">
			    	<div class="col-md-2  ">
						<div class="form-group ">
									<spring:theme code="delineacion.urbana.corrections.exentedArea" />
						</div>
					</div>
			    	<div class="col-md-2  ">
			    		<div class="form-group ">
							<input id="consentForm.consentGiven1" style="visibility: visible !important; margin:0;min-height:0;" name="consentForm.consentGiven" type="checkbox" value="true">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.usoVivienda" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<select id="u2575_input" class="form-control" >
                                  <option value="Vivienda estrato 1">Vivienda estrato 1</option>
                                  <option value="Vivienda estrato 2">Vivienda estrato 2</option>
                                  <option value="Vivienda estrato 3">Vivienda estrato 3</option>
                                  <option value="Vivienda estrato 4">Vivienda estrato 4</option>
                                  <option value="Vivienda estrato 5">Vivienda estrato 5</option>
                                </select>
						</div>
					</div>
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.vivienda" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
			 
			  <div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.commercialUse" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<select id="u2578_input" class="form-control">
                                  <option value="Comercio Metropilitano">Comercio Metropilitano</option>
                                  <option value="Comercio Vecinal o Local">Comercio Vecinal o Local</option>
                                  <option value="comercio Zonal">comercio Zonal</option>
                                  <option value="Comercio Urbano">Comercio Urbano</option>
                                </select>
						</div>
					</div>
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.commerce" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.serviceUse" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group " >
								<select id="u2580_input" class="form-control">
                                  <option value="Servicios Vecinal o Local">Servicios Vecinal o Local</option>
                                  <option value="Servicios Zonal">Servicios Zonal</option>
                                  <option value="Servicios Urbano">Servicios Urbano</option>
                                  <option value="Servicios Metropilitano">Servicios Metropilitano</option>
                                </select>
						</div>
					</div>
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.services" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.dotationalUser" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group " >
								<select id="u2582_input" class="form-control">
                                  <option value="Dotacional Vecinal o Local">Dotacional Vecinal o Local</option>
                                  <option value="Dotacional Zonal">Dotacional Zonal</option>
                                  <option value="Dotacional Urbano">Dotacional Urbano</option>
                                  <option value="Dotacional Metropilitano">Dotacional Metropilitano</option>
                                  <option value="Industrial">Industrial</option>
                                </select>
						</div>
					</div>
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.dotacional" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label>&nbsp;</label>
					</div>
					<div class="col-md-2">
						<label>&nbsp;</label>
					</div>
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.industry" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label>&nbsp;</label>
					</div>
					<div class="col-md-2">
						<label>&nbsp;</label>
					</div>
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.others" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label>&nbsp;</label>
					</div>
					<div class="col-md-2">
						<label>&nbsp;</label>
					</div>
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.total" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
			  </div>
			  <div id="tabs-3">
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.amplied" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.modified" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.adequate" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.recognition" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.enclosure" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.built" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<label><spring:theme code="delineacion.urbana.corrections.interArea" /></label>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
								<input type="text" class="form-control" />
						</div>
					</div>
				</div>
			  </div>
			  
			  
			  
			  
			</div>
		</div>	
		
		
		<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="delineacion.urbana.corrections.settlement" /></span>
				</h3>
			</div>	
		</div>
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.totalBudget" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.po" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.currentValue" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.vc" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.taxToCharge" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.fu" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.totalSactions" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.vs" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.totalRetention" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.tr" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.balanceTaxToCharge" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.si" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.balanceInFavor" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.sf" /></label>
			</div>
		</div>
		
		
			<div class="row">
			<div class="headline">
				<h3>
					<span tabindex="0"><spring:theme code="delineacion.urbana.corrections.payment" /></span>
				</h3>
			</div>	
		</div>
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.valueToPay" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.vp" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.interests" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.im" /></label>
			</div>
		</div>
		
		<div class="row">				
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.corrections.totalToPay" /></label>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<label><spring:theme code="delineacion.urbana.detail.tp" /></label>
			</div>
		</div>
		
		<div class="row ">
			<div class="col-md-8  text-right">
				<button class="btn btn-primary btn-lg" type="button"><spring:theme code="delineacion.urbana.corrections.calculate" /></button>
				<button class="btn btn-primary btn-lg" type="button"><spring:theme code="delineacion.urbana.corrections.generate" /></button>
				<button class="btn btn-sencondary btn-lg" type="button"><spring:theme code="delineacion.urbana.corrections.create" /></button>
				<button class="btn btn-sencondary btn-lg" type="button"><spring:theme code="delineacion.urbana.corrections.back" /></button>
			</div>
		</div>
		
	</div>	
	


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
	 $(".loader").fadeOut("slow");
}
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>
  </template:page>
