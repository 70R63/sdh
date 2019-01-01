<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

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
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.contactData.anotherContactAddress" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
						<spring:theme code="mirit.contactData.cellPhone" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
						<spring:theme code="mirit.contactData.socialNetwork" />
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select  class="form-control">
                  <option value="FACEBOOK">FACEBOOK</option>
                  <option value="INSTAGRAM">INSTAGRAM</option>
                  <option value="LINKEDIN">LINKEDIN</option>
                  <option value="SKYPE">SKYPE</option>
                  <option value="TWITTER">TWITTER</option>
                  <option value="WHATSAPP">WHATSAPP</option>
                  <option value="YOUTUBE">YOUTUBE</option>
                </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="address.surname">
						<spring:theme code="mirit.contactData.socialNetworkUser" />
					</label> 
					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
				
			</div>
			<label class="control-label " >
				<spring:theme code="mirit.contactData.note" />
			</label> 
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
					<label class="control-label " for="address.surname">
						<spring:theme code="mirit.contactData.country" />
					</label> 
<!-- 					<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240"> -->
					<select id="u5070_input"  class="form-control">
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
					<select id="u5067_input" class="form-control">
		                <option value="Seleccionar">Seleccionar</option>
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
					<select id="u5056_input" class="form-control">
		                <option value="Seleccionar">Seleccionar</option>
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
						<select id="u5058_input" class="form-control">
			                <option value="Seleccionar">Seleccionar</option>
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
						<select id="u5073_input" class="form-control">
			                <option value="Seleccionar">Seleccionar</option>
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
						<select id="u5059_input" class="form-control">
			                <option selected="" value="Seleccionar">Seleccionar</option>
			                <option value="Avenida">Avenida</option>
			                <option value="Carrera">Carrera</option>
			                <option value="Calle">Calle</option>
			                <option value="Diagonal">Diagonal</option>
			                <option value="Trasnversal">Trasnversal</option>
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
						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
						<select id="u5062_input" class="form-control">
			                <option selected="" value="Seleccionar">Seleccionar</option>
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
							<select id="u5061_input" class="form-control">
				                <option selected="" value="Seleccionar">Seleccionar</option>
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
						<select id="u5063_input" class="form-control">
			                <option selected="" value="Seleccionar">Seleccionar</option>
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
						<select id="u5064_input" class="form-control">
			                <option selected="" value="Seleccionar">Seleccionar</option>
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
						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
							<select id="u5065_input"  class="form-control">
				                <option selected="" value="Seleccionar">Seleccionar</option>
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
						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
						<select id="u5079_input" class="form-control">
			                <option selected="" value="Seleccionar">Seleccionar</option>
			                <option value="Sur">Sur</option>
			                <option value="Este">Este</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				</div>
			</div>
			<label class="control-label " ><spring:theme code="mirit.contactData.selectRequieredFields" />
			</label> 
			<div class="row">
				<div class="col-md-3">
					<div class="form-group ">
						<select id="u5066_input" class="form-control" disabled="disabled">
			                <option value="Seleccionar">Seleccionar</option>
			                <option value="Apartamento">Apartamento</option>
			                <option value="Agrupación">Agrupación</option>
			                <option value="Bloque">Bloque</option>
			                <option value="Bodega">Bodega</option>
			                <option value="Camino">Camino</option>
			                <option value="Carretera">Carretera</option>
			                <option value="Celula">Celula</option>
			                <option value="Casa">Casa</option>
			                <option value="Conjunto">Conjunto</option>
			                <option value="Consultorio">Consultorio</option>
			                <option value="Deposito">Deposito</option>
			                <option value="Edificio">Edificio</option>
			                <option value="Entrada">Entrada</option>
			                <option value="Esquina">Esquina</option>
			                <option value="Etapa">Etapa</option>
			                <option value="Garage">Garage</option>
			                <option value="Interior">Interior</option>
			                <option value="Kilómetro">Kilómetro</option>
			                <option value="Local">Local</option>
			                <option value="Lote">Lote</option>
			                <option value="Manzana">Manzana</option>
			                <option value="Mezanine">Mezanine</option>
			                <option value="Modula">Modula</option>
			                <option value="Oficina">Oficina</option>
			                <option value="Paseo">Paseo</option>
			                <option value="Parcela">Parcela</option>
			                <option value="Penthouse">Penthouse</option>
			                <option value="Piso">Piso</option>
			                <option value="Puente">Puente</option>
			                <option value="Predio">Predio</option>
			                <option value="Salón Comunal">Salón Comunal</option>
			                <option value="Sector">Sector</option>
			                <option value="Solar">Solar</option>
			                <option value="Semi Sotano">Semi Sotano</option>
			                <option value="Super Manzana">Super Manzana</option>
			                <option value="Torre">Torre</option>
			                <option value="Unidad">Unidad</option>
			                <option value="Unidad Residencial">Unidad Residencial</option>
			                <option value="Urbanización">Urbanización</option>
			                <option value="Vereda">Vereda</option>
			                <option value="Vía">Vía</option>
			                <option value="Zona">Zona</option>
			              </select>
			           </div>
				</div>
				<div class="col-md-3">
					<div class="form-group ">

						<input id="address.surname" name="lastName" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
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
			