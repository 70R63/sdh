<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<script > 
    function menuAutoSearch(){ 
    	var country = document.getElementById("u5070_input").value;
    	var addressType = document.getElementById("u5067_input").value;
    	var deparment = document.getElementById("u5056_input").value;
    	var town = document.getElementById("u5058_input").value;
    	var postCode = document.getElementById("u5073_input").value;
    	var streetType = document.getElementById("u5059_input").value;
    	var section1 = document.getElementById("u5060_input").value;
    	var section2 = document.getElementById("u5062_input").value;
    	var section3 = document.getElementById("u5061_input").value;
    	var section4 = document.getElementById("u5063_input").value;
    	var section5 = document.getElementById("u5064_input").value;
    	var section6 = document.getElementById("u6064_input").value;
    	var section7 = document.getElementById("u5065_input").value;
    	var section8 = document.getElementById("u6065_input").value;
    	var section9 = document.getElementById("u5079_input").value;
    	var complement = document.getElementById("u5066_input").value;
    	var complementText = document.getElementById("u6066_input").value;
    	
    	document.getElementById("address.assistant.output").value = streetType + " " + 
    																section1 + " " + 
    																section2 + " " + 
    																section3 + " " + 
    																section4 + " " + 
    																section5 + " " + 
    																section6 + " " + 
    																section7 + " " + 
    																section8 + " " + 
    																section9 + " " + 
    																complement + " " + 
    																complementText;
    	
    }
</script>

			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.contactData.title" text="Datos Contacto"/></span>
				</h2>
			</div>
			
			<!--  First column of form -->
		<div class="row">
			<div class="col-md-8">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.contactData.notificationAddress" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" disabled="disabled" value="${miRitForm.direccionNotificacion }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.contactData.anotherContactAddress" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" disabled="disabled" value="${miRitForm.direccionContacto }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.contactData.landPhone" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.telefonoPricipal }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.contactData.extension" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.extensionTelefono }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		<c:choose>
			<c:when test="${not empty miRitForm.redsocial }">
			
				<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.contactData.socialNetwork" />
						</label> 
					</div>
					
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.contactData.socialNetworkUser" />
						</label> 
					</div>
				</div>
				</div>
				<c:forEach items="${miRitForm.redsocial }" var="eachRedSocial">
					<div class="row">
						<div class="col-md-4">
							<div class="form-group ">
								<select  class="form-control">
					                  <c:forEach items="${socialNetworks }" var="eachSN">
					                  	<c:set var="selected" value=""/>
					                  	<c:if test="${eachSN eq  eachRedSocial.RED_SOCIAL}">
					                  		<c:set var="selected" value="selected"/>
					                  	</c:if>
						                  <option value="${eachSN }" ${selected }>${eachSN}</option>
										</c:forEach>			                  
					                </select>
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
								</div>
							</div>
							
						</div>
						<div class="col-md-4">
							<div class="form-group ">
								<input id="" name="" class="form-control form-control" aria-required="true" type="text" value="${eachRedSocial.USUARIORED }" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.contactData.socialNetwork" />
						</label> 
					</div>
					
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="address.surname">
							<spring:theme code="mirit.contactData.socialNetworkUser" />
						</label> 
					</div>
				</div>
				</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group ">
								<select  class="form-control">
					                  <c:forEach items="${socialNetworks }" var="eachSN">
						                  <option value="${eachSN }">${eachSN}</option>
										</c:forEach>			                  
					                </select>
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
								</div>
							</div>
							
						</div>
						<div class="col-md-4">
							<div class="form-group ">
								<input id="" name="" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
			</c:otherwise>
		</c:choose>
		
			<br>
			<br>
			<div class="form-group ">
				<label class="control-label " >
					<spring:theme code="mirit.contactData.note" />
				</label>
			</div>
			<input id="address.assistant.output" name="addressAssistantOutput" class="form-control form-control" aria-required="true" type="text" value="" maxlength="2000" width="90000" onkeyup="menuAutoSearch();" disabled>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
					
					<label class="control-label " for="address.surname">
						<spring:theme code="mirit.contactData.country" />
					</label> 
 					<select id="u5070_input"  class="form-control" onchange="menuAutoSearch();">
		                <option selected="" value="Colombia">Colombia</option>
		                <option value="Argentina">Argentina</option>
		                <option value="España">España</option>
		                <option value="Estados Unidos ">Estados Unidos </option>
		                <option value="México">México</option>
		              </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
					<label class="control-label " for="address.surname">
						<spring:theme code="mirit.contactData.addressType" />
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select id="u5067_input" class="form-control" onchange="menuAutoSearch();">
		                <option value="">Seleccionar</option>
		                <option value="Notificación">Notificación</option>
		                <option value="Otra dirección">Otra dirección</option>
		              </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
					<label class="control-label " for="address.surname">
						<spring:theme code="mirit.contactData.department" />
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select id="u5056_input" class="form-control" onchange="menuAutoSearch();">
		                <option value="">Seleccionar</option>
		                <option value="Antioquia">Antioquia</option>
		                <option value="Bogotá D.C.">Bogotá D.C.</option>
		                <option value="Caldas">Caldas</option>
		                <option value="Nariño">Nariño</option>
		              </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
							<spring:theme code="mirit.contactData.county" />
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
						<select id="u5058_input" class="form-control" onchange="menuAutoSearch();">
			                <option value="">Seleccionar</option>
			                <option value="Bogotá D.C.">Bogotá D.C.</option>
			                <option value="Medellin">Medellin</option>
			                <option value="Nariño">Nariño</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
							<spring:theme code="mirit.contactData.postalCode" />
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
						<select id="u5073_input" class="form-control" onchange="menuAutoSearch();">
			                <option value="">Seleccionar</option>
			                <option value="Bogotá D.C.">Bogotá D.C.</option>
			                <option value="Medellin">Medellin</option>
			                <option value="Nariño">Nariño</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
					<label class="control-label " for="address.surname">
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
						<select id="u5059_input" class="form-control" onchange="menuAutoSearch();">
			                <option selected="" value="">Seleccionar</option>
			                <option value="AC">Avenida Calle</option>
			                <option value="AK">Avenida Carrera</option>
			                <option value="CL">Calle</option>
			                <option value="KR">Carrera</option>			                
			                <option value="DG">Diagonal</option>
			                <option value="TV">Trasnversal</option>
			              </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
						<input id="u5060_input" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240" oninput="menuAutoSearch();">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
						<select id="u5062_input" class="form-control" onchange="menuAutoSearch();">
			                <option selected="" value="">Seleccionar</option>
			                <option value="A">A</option>
			                <option value="B">B</option>
			                <option value="C">C</option>
			                <option value="D">D</option>
			                <option value="E">E</option>
			                <option value="F">F</option>
			                <option value="G">G</option>
			                <option value="H">H</option>
			                <option value="I">I</option>
			                <option value="J">J</option>
			                <option value="K">K</option>
			                <option value="L">L</option>
			                <option value="M">M</option>
			                <option value="N">N</option>
		                <option value="O">O</option>
		                <option value="P">P</option>
		                <option value="Q">Q</option>
		                <option value="R">R</option>
		                <option value="S">S</option>
		                <option value="T">T</option>
		                <option value="U">U</option>
		                <option value="V">V</option>
		                <option value="W">W</option>
		                <option value="X">X</option>
		                <option value="Y">Y</option>
		                <option value="Z">Z</option>
		              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
							<select id="u5061_input" class="form-control" onchange="menuAutoSearch();">
				                <option selected="" value="">Seleccionar</option>
				                <option value="Bis">Bis</option>
				              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
						<select id="u5063_input" class="form-control" onchange="menuAutoSearch();">
			                <option selected="" value="">Seleccionar</option>
			                <option value="A">A</option>
			                <option value="B">B</option>
			                <option value="C">C</option>
			                <option value="D">D</option>
			                <option value="E">E</option>
			                <option value="F">F</option>
			                <option value="G">G</option>
			                <option value="H">H</option>
			                <option value="I">I</option>
			                <option value="J">J</option>
			                <option value="K">K</option>
			                <option value="L">L</option>
			                <option value="M">M</option>
			                <option value="N">N</option>
			                <option value="O">O</option>
			                <option value="P">P</option>
			                <option value="Q">Q</option>
			                <option value="R">R</option>
			                <option value="S">S</option>
			                <option value="T">T</option>
			                <option value="U">U</option>
			                <option value="V">V</option>
			                <option value="W">W</option>
			                <option value="X">X</option>
			                <option value="Y">Y</option>
			                <option value="Z">Z</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
						<select id="u5064_input" class="form-control" onchange="menuAutoSearch();">
			                <option selected="" value="">Seleccionar</option>
			                <option value="Sur">Sur</option>
			                <option value="Este">Este</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
						<input id="u6064_input" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240" oninput="menuAutoSearch();">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
							<select id="u5065_input"  class="form-control" onchange="menuAutoSearch();">
				                <option selected="" value="">Seleccionar</option>
				                <option value="A">A</option>
				                <option value="B">B</option>
				                <option value="C">C</option>
				                <option value="D">D</option>
				                <option value="E">E</option>
				                <option value="F">F</option>
				                <option value="G">G</option>
				                <option value="H">H</option>
				                <option value="I">I</option>
				                <option value="J">J</option>
				                <option value="K">K</option>
				                <option value="L">L</option>
				                <option value="M">M</option>
				                <option value="N">N</option>
				                <option value="O">O</option>
				                <option value="P">P</option>
				                <option value="Q">Q</option>
				                <option value="R">R</option>
				                <option value="S">S</option>
				                <option value="T">T</option>
				                <option value="U">U</option>
				                <option value="V">V</option>
				                <option value="W">W</option>
				                <option value="X">X</option>
				                <option value="Y">Y</option>
				                <option value="Z">Z</option>
				              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
						<input id="u6065_input" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240" oninput="menuAutoSearch();">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="address.surname">
						</label> 
<!-- 						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
						<select id="u5079_input" class="form-control" onchange="menuAutoSearch();">
			                <option selected="" value="">Seleccionar</option>
			                <option value="Sur">Sur</option>
			                <option value="Este">Este</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				</div>
			</div>
			<br>
			<div class="form-group ">
			<label class="control-label " ><spring:theme code="mirit.contactData.selectRequieredFields" />
			</label>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group ">
						<select id="u5066_input" class="form-control" onchange="menuAutoSearch();"> 
							<option selected="" value="">Seleccionar</option>
			                <option value="AP">Apartamento</option>
							<option value="AG">Agrupación</option>
							<option value="BL">Bloque</option>
							<option value="BG">Bodega</option>
							<option value="CN">Camino</option>
							<option value="CT">Carrera</option>
							<option value="CEL">Celula</option>
							<option value="CA">Casa</option>
							<option value="CONJ">Conjunto</option>
							<option value="CS">Consultorio</option>
							<option value="ED">Edificio</option>
							<option value="EN">Entrada</option>
							<option value="ESQ">Esquina</option>
							<option value="ET">Etapa</option>
							<option value="IN">Interior</option>
							<option value="KM">Kilómetro</option>
							<option value="LC">Local</option>
							<option value="MZ">Manzana</option>
							<option value="MN">Mezanine</option>
							<option value="MD">Modula</option>
							<option value="OF">Oficina</option>
							<option value="PS">Paseo</option>
							<option value="PA">Parcela</option>
							<option value="PH">Penthouse</option>
							<option value="PI">Piso</option>
							<option value="PN">Puente</option>
							<option value="PD">Predio</option>
							<option value="SC">Salón Comunal</option>
							<option value="SR">Sector</option>
							<option value="SL">Solar</option>
							<option value="SM">Supermanzana</option>
							<option value="TO">Torre</option>
							<option value="UN">Unidad</option>
							<option value="UR">Unidad Residencial</option>
							<option value="URB">Urbanización</option>
							<option value="VDA">Vereda</option>
							<option value="VIA">Vía</option>
							<option value="ZN">Zona</option>
			              </select>
			           </div>
				</div>
				<div class="col-md-3">
					<div class="form-group ">

						<input id="u6066_input" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240" oninput="menuAutoSearch();">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="">
							<button class="btn btn-primary btn-lg" type="button" onclick="window.location.href = '/sdhstorefront/es/register/searchUser'">
									<spring:theme code="mirit.contactData.acept" /></button>
								<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href = '/sdhstorefront/es/'">
									<spring:theme code="mirit.contactData.addAddress" /></button>
							</div>
			</div>
			