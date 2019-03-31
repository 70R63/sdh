<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />




 <script>
    function menuAutoSearch(){ 
    	var country = document.getElementById("countrySelect").value;
    	var deparment = document.getElementById("deparmentSelect").value;
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
//     	var complement = document.getElementById("u5066_input").value;
//     	var complementText = document.getElementById("u6066_input").value;
    	
    	document.getElementById("address.assistant.output").value = streetType + " " + 
    																section1 + " " + 
    																section2 + " " + 
    																section3 + " " + 
    																section4 + " " + 
    																section5 + " " + 
    																section6 + " " + 
    																section7 + " " + 
    																section8 + " " + 
    																section9 + " " ;
    	
    	document.getElementById("address.assistant.output.street").value = 
		streetType + " " + 
		section1 + " " + 
		section2 + " " + 
		section3 + " " + 
		section4 + " " + 
		section5 + " " + 
		section6 + " " + 
		section7 + " " + 
		section8 + " " + 
		section9 + " " ;
    	
    }
    
    function departmentChanged()
    {
    	var selectedDepartment = $("#deparmentSelect").val();
    	
    	$('#u5058_input')
        .find('option')
        .remove();
    	
    	var o = new Option( "SELECCIONAR","");
    	/// jquerify the DOM object 'o' so we can use the html method
    	$(o).html("SELECCIONAR");
    	$("#u5058_input").append(o);
    	
    	
    	$('#u5073_input')
        .find('option')
        .remove();
    	
    	var o = new Option( "SELECCIONAR","");
    	/// jquerify the DOM object 'o' so we can use the html method
    	$(o).html("SELECCIONAR");
    	$("#u5073_input").append(o);
    	
    	municipios.forEach(function (eachMun) {
    	    if (eachMun.dep == selectedDepartment) {
    	    	var o = new Option( eachMun.desc,eachMun.desc);
    	    	/// jquerify the DOM object 'o' so we can use the html method
    	    	$(o).html(eachMun.desc);
    	    	$("#u5058_input").append(o);
    	    }
    	});
    	
//     	menuAutoSearch();
    }
    
    function cancelAddAddress()
    {
    	$(".form-control.addressHelperField").val("");
    	document.getElementById("address.assistant.output").value ="";
    	
//     	document.getElementById("direccionNotificacionStreet").value = "";
// 		document.getElementById("direccionNotificacionSuppl1").value = "";
// 		document.getElementById("direccionNotificacionSuppl2").value = "";
		
// 		document.getElementById("direccionContactoStreet").value = "";
// 		document.getElementById("direccionContactoSuppl1").value = "";
// 		document.getElementById("direccionContactoSuppl2").value = "";
		
		
		document.getElementById("address.assistant.output").value ="";
		document.getElementById("address.assistant.output.street").value ="";
		document.getElementById("address.assistant.output.spl1").value ="";
		document.getElementById("address.assistant.output.spl2").value ="";
		
		document.getElementById("address.assistant.output").value  ="";
		document.getElementById("address.assistant.output.street").value  ="";
		document.getElementById("address.assistant.output.spl1").value  ="";
		document.getElementById("address.assistant.output.spl2").value ="";
		
		complementos= 0;
		
    }
    
    function municipioChanged()
    {
    	var selectedMunicipio = $("#u5058_input").val();
    	
    	$('#u5073_input')
        .find('option')
        .remove();
    	
    	var o = new Option( "SELECCIONAR","");
    	/// jquerify the DOM object 'o' so we can use the html method
    	$(o).html("SELECCIONAR");
    	$("#u5073_input").append(o);
    	
    	var munID="";
    	
    	municipios.forEach(function (eachMun) {
    	    if (eachMun.desc == selectedMunicipio) {
    	    	var o = new Option( eachMun.desc,eachMun.desc);
    	    	munID=eachMun.mun;
    	    }
    	});
    	
    	cps.forEach(function (eachCP) {
    	    if (eachCP.mun == munID) {
    	    	var o = new Option( eachCP.cp,eachCP.cp);
    	    	/// jquerify the DOM object 'o' so we can use the html method
    	    	$(o).html(eachCP.cp);
    	    	$("#u5073_input").append(o);
    	    }
    	});
    	
//     	menuAutoSearch()
    }
    
    function setAddress(){
    	var addressType = document.getElementById("u5067_input").value;
    	
    	
    	if(addressType == "notificacion")
   		{
    		document.getElementById("direccionNotificacion").value = document.getElementById("address.assistant.output").value;
    		document.getElementById("direccionNotificacionStreet").value = document.getElementById("address.assistant.output.street").value;
    		document.getElementById("direccionNotificacionSuppl1").value = document.getElementById("address.assistant.output.spl1").value;
    		document.getElementById("direccionNotificacionSuppl2").value = document.getElementById("address.assistant.output.spl2").value;
    		
    		
    		document.getElementById("countryDireccionNotificacion").value = document.getElementById("countrySelect").value;
    		document.getElementById("deparmentDireccionNotificacion").value = document.getElementById("deparmentSelect").value;
    		
    		
    		$("#municipioDireccionNotificacion").find('option').remove();
    		var o = new Option( $('#u5058_input option:selected').text(),$('#u5058_input').val());
	    	/// jquerify the DOM object 'o' so we can use the html method
	    	$(o).html($('#u5058_input option:selected').text());
	    	$("#municipioDireccionNotificacion").append(o);
	    	
	    	
			$("#postalCodeDireccionNotificacion").find('option').remove();
    		var o = new Option( $('#u5073_input option:selected').text(),$('#u5073_input').val());
	    	/// jquerify the DOM object 'o' so we can use the html method
	    	$(o).html($('#u5073_input option:selected').text());
	    	$("#postalCodeDireccionNotificacion").append(o);
    		
    		
    		
    		
   		}else if(addressType == "contacto")
   		{
   			document.getElementById("direccionContacto").value = document.getElementById("address.assistant.output").value;
    		document.getElementById("direccionContactoStreet").value = document.getElementById("address.assistant.output.street").value;
    		document.getElementById("direccionContactoSuppl1").value = document.getElementById("address.assistant.output.spl1").value;
    		document.getElementById("direccionContactoSuppl2").value = document.getElementById("address.assistant.output.spl2").value;
    		
    		
    		document.getElementById("countryDireccionContacto").value = document.getElementById("countrySelect").value;
    		document.getElementById("deparmentDireccionContacto").value = document.getElementById("deparmentSelect").value;
    		
    		
    		$("#municipioDireccionContacto").find('option').remove();
    		var o = new Option( $('#u5058_input option:selected').text(),$('#u5058_input').val());
	    	/// jquerify the DOM object 'o' so we can use the html method
	    	$(o).html($('#u5058_input option:selected').text());
	    	$("#municipioDireccionContacto").append(o);
	    	
	    	
			$("#postalCodeDireccionContacto").find('option').remove();
    		var o = new Option( $('#u5073_input option:selected').text(),$('#u5073_input').val());
	    	/// jquerify the DOM object 'o' so we can use the html method
	    	$(o).html($('#u5073_input option:selected').text());
	    	$("#postalCodeDireccionContacto").append(o);
   		}
    	
    	
    }
    
    var complementos = 0;
    
    function addComplement(){
    	var complement = document.getElementById("u5066_input").value;
    	var complementText = document.getElementById("u6066_input").value;
    	
    	if(complementos == 0)
    	{
    		document.getElementById("address.assistant.output").value = document.getElementById("address.assistant.output").value +" "+ complement + " " + complementText;
    		document.getElementById("address.assistant.output.spl1").value =  complement + " " + complementText;
    		complementos ++;
    	}else if(complementos == 1 )
    	{
    		document.getElementById("address.assistant.output").value = document.getElementById("address.assistant.output").value +" "+ complement + " " + complementText;
    		document.getElementById("address.assistant.output.spl2").value = document.getElementById("address.assistant.output.spl2").value + complement + " " + complementText;
    		complementos++;
    	}else if(complementos == 2 )
    	{
    		document.getElementById("address.assistant.output").value = document.getElementById("address.assistant.output").value +" "+ complement + " " + complementText;
    		document.getElementById("address.assistant.output.spl2").value = document.getElementById("address.assistant.output.spl2").value +" "+ complement + " " + complementText;
    		complementos++;
    	}else
    	{
    		alert("Solo se permiten hasta 3 complementos.");
    	}
    	
    	
    }
    
    function countryChanged()
    {
    	
    	var country = document.getElementById("countrySelect").value;
    	
    	if(country == "CO")
   		{
   			$(".addressHelperField").prop('disabled', false);
   			$("#direccionNotificacion").prop('disabled', true);
			$("#direccionContacto").prop('disabled', true);
			
			$("#deparmentSelect").prop('disabled', false);
			$("#u5058_input").prop('disabled', false);
			$("#u5073_input").prop('disabled', false);
			
   		}else
		{
			$(".addressHelperField").prop('disabled', true);
			
			$("#deparmentSelect").prop('disabled', true);
			$("#u5058_input").prop('disabled', true);
			$("#u5073_input").prop('disabled', true);
			
			var addressType = document.getElementById("u5067_input").value;
	    	
	    	
	    	if(addressType == "notificacion")
	   		{
	    		$("#direccionNotificacion").prop('disabled', false);
	    		
	    		$("#countryDireccionNotificacion").val(country);
				
	   		}else if(addressType == "contacto")
	   		{
	   			$("#direccionContacto").prop('disabled', false);
	   			$("#countryDireccionContacto").val(country);
	   		}
			
		}
    	
    }
    
    function toggleAssistant()
    {
    	$("#addressAssistant").toggle();
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
					<label class="control-label required" for="direccionNotificacion">
						<spring:theme code="mirit.contactData.notificationAddress" />
					</label> 
					<input id="direccionNotificacion" name="direccionNotificacion" class="form-control" aria-required="true" type="text" data-original="${miRitForm.direccionNotificacion.STREET} ${miRitForm.direccionNotificacion.STR_SUPPL1 } ${miRitForm.direccionNotificacion.STR_SUPPL2 }"" disabled="disabled" value="${miRitForm.direccionNotificacion.STREET} ${miRitForm.direccionNotificacion.STR_SUPPL1 } ${miRitForm.direccionNotificacion.STR_SUPPL2 }" maxlength="240">
					<input id="direccionNotificacionStreet" name="direccionNotificacionStreet"  type="hidden" data-original="${miRitForm.direccionNotificacion.STREET}"  value="${miRitForm.direccionNotificacion.STREET}">
					<input id="direccionNotificacionSuppl1" name="direccionNotificacionStreet"  type="hidden" data-original="${miRitForm.direccionNotificacion.STR_SUPPL1 }"  value="${miRitForm.direccionNotificacion.STR_SUPPL1}">
					<input id="direccionNotificacionSuppl2" name="direccionNotificacionStreet"  type="hidden" data-original="${miRitForm.direccionNotificacion.STR_SUPPL2 }"  value="${miRitForm.direccionNotificacion.STR_SUPPL2 }">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="countryDireccionNotificacion">
						<spring:theme code="mirit.contactData.country" />
					</label> 
					<select disabled="disabled" id="countryDireccionNotificacion"  class="form-control" onchange="">
	              	</select>
				</div>
			
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="deparmentDireccionNotificacion">
						<spring:theme code="mirit.contactData.department" />
					</label> 
					<select disabled="disabled" id="deparmentDireccionNotificacion" class="form-control " onchange="">
		              </select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="municipioDireccionNotificacion">
						<spring:theme code="mirit.contactData.county" />
					</label> 
					<select disabled="disabled" id="municipioDireccionNotificacion" class="form-control" onchange="municipioDNChanged();">
		              </select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="postalCodeDireccionNotificacion">
						<spring:theme code="mirit.contactData.postalCode" />
					</label> 
					<select disabled="disabled" id="postalCodeDireccionNotificacion" class="form-control" onchange="">
		              </select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12 col-md-4  ">
				<div class="form-group ">
					<button class="btn btn-secondary btn-lg btn-block" type="button" id="updateNotificationAddressButton">
							<spring:theme code="mirit.contactData.updateNotificationAddress" />
					</button>
				</div>
			</div>
		</div>
		
		<br>
		<br>
		<div class="row">
			<div class="col-md-8">
				<div class="form-group ">
					<label class="control-label required" for="direccionContacto">
						<spring:theme code="mirit.contactData.anotherContactAddress" />
					</label> 
					<input id="direccionContacto" name="direccionContacto" class="form-control" aria-required="true" type="text" disabled="disabled" data-original="${miRitForm.direccionContacto.STREET } ${miRitForm.direccionContacto.STR_SUPPL1 } ${miRitForm.direccionContacto.STR_SUPPL2 }" value="${miRitForm.direccionContacto.STREET } ${miRitForm.direccionContacto.STR_SUPPL1 } ${miRitForm.direccionContacto.STR_SUPPL2 }" maxlength="240">
					<input id="direccionContactoStreet" name="direccionContactoStreet"  type="hidden" data-original="${miRitForm.direccionContacto.STREET}" value="${miRitForm.direccionContacto.STREET}">
					<input id="direccionContactoSuppl1" name="direccionContactoSuppl1"  type="hidden" data-original="${miRitForm.direccionContacto.STR_SUPPL1 }" value=" ${miRitForm.direccionContacto.STR_SUPPL1 } ">
					<input id="direccionContactoSuppl2" name="direccionContactoSuppl2"  type="hidden" data-original="${miRitForm.direccionContacto.STR_SUPPL2 }" value="${miRitForm.direccionContacto.STR_SUPPL2 }">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="countryDireccionContacto">
						<spring:theme code="mirit.contactData.country" />
					</label> 
					<select disabled="disabled" id="countryDireccionContacto"  class="form-control" onchange="countryACChanged();">
	              	</select>
				</div>
			
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="deparmentDireccionContacto">
						<spring:theme code="mirit.contactData.department" />
					</label> 
					<select disabled="disabled" id="deparmentDireccionContacto" class="form-control " onchange="departmentACChanged();">
		              </select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="municipioDireccionContacto">
						<spring:theme code="mirit.contactData.county" />
					</label> 
					<select disabled="disabled" id="municipioDireccionContacto" class="form-control" onchange="municipioDNChanged();">
		              </select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label " for="postalCodeDireccionContacto">
						<spring:theme code="mirit.contactData.postalCode" />
					</label> 
					<select disabled="disabled" id="postalCodeDireccionContacto" class="form-control" onchange="">
		              </select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12 col-md-4  ">
				<div class="form-group ">
					<button class="btn btn-secondary btn-lg btn-block" type="button" id="updateContactAddressButton">
							<spring:theme code="mirit.contactData.updateContactAddress" />
					</button>
				</div>
			</div>
		</div>
		
		<br>
		<br>
		<div class="row">
			<div class="row">
				<div class="col-12 col-md-4">	
					<div>
						<button class="btn btn-primary btn-lg btn-block addressHelperField" type="button" onclick="toggleAssistant();">
							<spring:theme code="mirit.contactData.editarAddress" /></button>
					</div>
				</div>
			</div>
		
		</div>
		<div id="addressAssistant" style="display:none;">
			<br>
			<br>
			<div class="form-group ">
				<label class="control-label " >
					<spring:theme code="mirit.contactData.note" />
				</label>
			</div>
			<input id="address.assistant.output" name="addressAssistantOutput" class="form-control form-control" aria-required="true" type="text" value="" maxlength="2000" width="90000" onkeyup="menuAutoSearch();" disabled>
			<input id="address.assistant.output.street" name="address.assistant.output.street" class="form-control form-control" type="hidden" />
			<input id="address.assistant.output.spl1" name="address.assistant.output.spl1" class="form-control form-control" type="hidden" />
			<input id="address.assistant.output.spl2" name="address.assistant.output.spl2" class="form-control form-control" type="hidden" />
			<br>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label " for="u5067_input">
							<spring:theme code="mirit.contactData.addressType" />
						</label> 
						<select id="u5067_input" class="form-control" onchange="cancelAddAddress();">
			                <option value="notificacion">Notificación</option>
			                <option value="contacto">Otra dirección</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				</div>
				<div class="col-md-2">
				</div>
				<div class="col-md-2">
				</div>
				<div class="col-md-2">
				</div>
				<div class="col-12 col-md-2 text-center">
					<div class="form-group ">
						<button class="btn btn-secondary btn-lg addressHelperField" type="button" onclick="cancelAddAddress();">
						<spring:theme code="mirit.contactData.cancel" /></button>
					</div>
				</div>
				<div class="col-12 col-md-2 text-center">	
					<div class="form-group ">
						<button class="btn btn-primary btn-lg addressHelperField" type="button" onclick="setAddress();">
							<spring:theme code="mirit.contactData.addAddress" /></button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<div class="form-group ">
					
						<label class="control-label " for="countrySelect">
							<spring:theme code="mirit.contactData.country" />
						</label> 
	 					<select id="countrySelect"  class="form-control" onchange="countryChanged();">
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
					<label class="control-label " for="deparmentSelect">
						<spring:theme code="mirit.contactData.department" />
					</label> 
					<select id="deparmentSelect" class="form-control " onchange="departmentChanged();">
		                <option value="">Seleccionar</option>
		                <option value="05">ANTIOQUIA</option>
						<option value="08">ATLÁNTICO</option>
						<option value="11">BOGOTÁ</option>
						<option value="13">BOLÍVAR</option>
						<option value="15">BOYACA</option>
						<option value="17">CALDAS</option>
						<option value="18">CAQUETA</option>
						<option value="19">CAUCA</option>
						<option value="20">CESAR</option>
						<option value="23">CÓRDOBA</option>
						<option value="25">CUNDINAMARCA</option>
						<option value="27">CHOCO</option>
						<option value="41">HUILA</option>
						<option value="44">LA GUAJIRA</option>
						<option value="47">MAGDALENA</option>
						<option value="50">META</option>
						<option value="52">NARIÑO</option>
						<option value="54">NORTE SANTANDER</option>
						<option value="63">QUINDIO</option>
						<option value="66">RISARALDA</option>
						<option value="68">SANTANDER</option>
						<option value="70">SUCRE</option>
						<option value="73">TOLIMA</option>
						<option value="76">VALLE</option>
						<option value="81">ARAUCA</option>
						<option value="85">CASANARE</option>
						<option value="86">PUTUMAYO</option>
						<option value="88">SAN ANDRÉS</option>
						<option value="91">AMAZONAS</option>
						<option value="94">GUAINIA</option>
						<option value="95">GUAVIARE</option>
						<option value="97">VAUPES</option>
						<option value="99">VICHADA</option>
		              </select>
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
				
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label " for="u5058_input">
							<spring:theme code="mirit.contactData.county" />
						</label> 
						<select id="u5058_input" class="form-control" onchange="municipioChanged();">
			                <option value="">Seleccionar</option>
			              </select>
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label " for="u5073_input">
							<spring:theme code="mirit.contactData.postalCode" />
						</label> 
						<select id="u5073_input" class="form-control" onchange="">
			                <option value="">Seleccionar</option>
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
					<label class="control-label " for="u5059_input">
						<spring:theme code="mirit.addresshelper.tipo" />
					</label> 
						<select id="u5059_input" class="form-control addressHelperField" onchange="menuAutoSearch();">
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
						<label class="control-label " for="u5060_input">
							<spring:theme code="mirit.addresshelper.numero" />
						</label> 
						<input id="u5060_input" name="lastName" class="form-control form-control addressHelperField" aria-required="true" type="text" value="" maxlength="240" oninput="menuAutoSearch();">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="u5062_input">
							<spring:theme code="mirit.addresshelper.letra" />
						</label> 
						<select id="u5062_input" class="form-control addressHelperField" onchange="menuAutoSearch();">
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
						<label class="control-label " for="u5061_input">
							<spring:theme code="mirit.addresshelper.bis" />
						</label> 
							<select id="u5061_input" class="form-control addressHelperField" onchange="menuAutoSearch();">
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
						<label class="control-label " for="u5063_input">
							<spring:theme code="mirit.addresshelper.letra" />
						</label> 
						<select id="u5063_input" class="form-control addressHelperField" onchange="menuAutoSearch();">
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
						<label class="control-label " for="u5064_input">
							<spring:theme code="mirit.addresshelper.zona" />
						</label> 
						<select id="u5064_input" class="form-control addressHelperField" onchange="menuAutoSearch();">
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
						<label class="control-label " for="u6064_input">
							<spring:theme code="mirit.addresshelper.numero" />
						</label> 
						<input id="u6064_input" name="lastName" class="form-control form-control addressHelperField" aria-required="true" type="text" value="" maxlength="240" oninput="menuAutoSearch();">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="u5065_input">
							<spring:theme code="mirit.addresshelper.letra" />
						</label> 
							<select id="u5065_input"  class="form-control addressHelperField" onchange="menuAutoSearch();">
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
						<label class="control-label " for="u6065_input">
							<spring:theme code="mirit.addresshelper.numero" />
						</label> 
						<input id="u6065_input" name="lastName" class="form-control form-control addressHelperField" aria-required="true" type="text" value="" maxlength="240" oninput="menuAutoSearch();">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<label class="control-label " for="u5079_input">
							<spring:theme code="mirit.addresshelper.zona" />
						</label> 
						<select id="u5079_input" class="form-control addressHelperField" onchange="menuAutoSearch();">
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
						<label class="control-label " for="u5066_input">
							<spring:theme code="mirit.addresshelper.tipoComplemento" />
						</label> 
						<select id="u5066_input" class="form-control addressHelperField" onchange=""> 
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
						<label class="control-label " for="u6066_input">
							<spring:theme code="mirit.addresshelper.complemento" />
						</label> 
						<input id="u6066_input" name="lastName" class="form-control addressHelperField" aria-required="true" type="text" value="" maxlength="240" oninput="">
						<div class="help-block">
							<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
						</div>
					</div>
				
				</div>
				<div class="col-md-3">
					<div class="form-group ">
						<label class="control-label " for="u6066_input">
							&nbsp;
						</label> 
						<button class="btn btn-primary btn-lg  form-control  addressHelperField" type="button" onclick="addComplement();">
						<spring:theme code="mirit.contactData.acept" /></button>
					</div>
				</div>
				
			</div>
		</div>	
		<br>
		<br>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="telefonoPricipal">
						<spring:theme code="mirit.contactData.landPhone" />
					</label> 
					<input id="telefonoPricipal" name="telefonoPricipal" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.telefonoPricipal }" maxlength="240">
					<div class="help-block">
						<span id="telefonoPricipal.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label required" for="extensionTelefono">
						<spring:theme code="mirit.contactData.extension" />
					</label> 
					<input id="extensionTelefono" name="extensionTelefono" class="form-control form-control" aria-required="true" type="text" value="${miRitForm.extensionTelefono }" maxlength="240">
					<div class="help-block">
						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-12 col-md-4  ">
				<div class="form-group ">
					<button class="btn btn-secondary btn-block btn-lg " type="button" id="updateTelefonoButton">
							<spring:theme code="mirit.contactData.updateTelefono" />
					</button>
				</div>
			</div>
		</div>
		
		<br>
		<br>
		<div id="socialNetRows">
		
		<c:choose>
			<c:when test="${not empty miRitForm.redsocial }">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group ">
							<label class="control-label required" for="">
								<spring:theme code="mirit.contactData.socialNetwork" />
							</label> 
						</div>
						
					</div>
					<div class="col-md-4">
						<div class="form-group ">
							<label class="control-label required" for="">
								<spring:theme code="mirit.contactData.socialNetworkUser" />
							</label> 
						</div>
					</div>
					<div class="col-12 col-md-4">
						<div class="form-group ">
						<button class="btn btn-secondary btn-lg btn-block " type="button" id="addSocialNetworkButton">
							<spring:theme code="mirit.contactData.addSocialNetwork" /></button>
						</div>
					</div>
					
				</div>
				<c:forEach items="${miRitForm.redsocial }" var="eachRedSocial" varStatus="status">
					<div class="row socialNetworkRow" >
						<div class="col-md-4">
							<div class="form-group ">
								<select  class="form-control redSocial"   >
									<option value=""></option>
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
								<input   class="form-control usuarioRedSocial" aria-required="true" type="text" value="${eachRedSocial.USUARIORED }" maxlength="240">
								<div class="help-block">
									<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="row" >
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="">
							<spring:theme code="mirit.contactData.socialNetwork" />
						</label> 
					</div>
					
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label required" for="">
							<spring:theme code="mirit.contactData.socialNetworkUser" />
						</label> 
					</div>
				</div>
				<div class="col-12 col-md-4">
						<div class="form-group ">
						<button class="btn btn-secondary btn-lg btn-block" type="button" id="addSocialNetworkButton">
							<spring:theme code="mirit.contactData.addSocialNetwork" /></button>
						</div>
					</div>
				</div>
					<div class="row socialNetworkRow">
						<div class="col-md-4">
							<div class="form-group ">
								<select  class="form-control redSocial"   >
									<option value=""></option>
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
								<input  class="form-control usuarioRedSocial" aria-required="true" type="text" value="" maxlength="240">
								<div class="help-block">
									<span id="redsocial[0].USUARIORED.errors" class="hidden"></span>
								</div>
							</div>
						</div>
					</div>
			</c:otherwise>
		</c:choose>
		
		</div>	
		<div class="row">
			<div class="col-12 col-md-4">
				<div class="form-group ">
					<button class="btn btn-secondary btn-lg btn-block " type="button" id="updateRedesSocialesButton">
							<spring:theme code="mirit.contactData.updateRedesSociales" />
					</button>
				</div>
			</div>
		</div>
