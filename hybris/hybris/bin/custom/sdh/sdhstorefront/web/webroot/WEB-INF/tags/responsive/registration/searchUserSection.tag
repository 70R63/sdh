<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<div class="description text-center"><spring:theme code="register.description" htmlEscape="false"/></div>
				
				<c:url value="/register/searchUser" var="formAction"/>
				<form:form method="post" modelAttribute="searchUserForm" action="${formAction}"> 
					<div class="control-group">
						<c:if test="${userFound eq false }">
							<div class="has-error">
								<div class="help-block">
									<span id="lastName.errors"><spring:theme code="register.userNotFound" /></span>
								</div>
							</div>
						</c:if>
						<c:if test="${userRegistered eq true }">
							<div class="has-error">
								<div class="help-block">
									<span id="lastName.errors"><spring:theme code="register.userAlreadyRegistered" /></span>
								</div>
							</div>
						</c:if>
						<div class="form-group">
							<label class="control-label required" for="profile.title">
							<spring:theme code="register.documentType"/><span class="mandatory">
									</span>
							<span class="skip">
									</span>
							</label>
								<div class="control">
									
							            
									<select id="documentType" name="documentType" class="form-control" aria-required="true">
										<c:set var="selected" value="" />
										<c:if test="${empty searchUserForm.documentType}">
											<c:set var="selected" value="selected" />
										</c:if>
										<option value="Seleccionar" ${selected}>Seleccionar</option>
									<c:forEach items="${idTypes }" var="eachType">
										<c:set var="selected" value="" />
										<c:if test="${eachType eq  searchUserForm.documentType}">
											<c:set var="selected" value="selected" />
										</c:if>
										<option value="${ eachType}" ${selected }><spring:theme code="register.id.types.${eachType}" /></option>
									</c:forEach>
									</select>
									
								</div>
						</div>
						
						<div class="form-group">
							<label class="control-label " for="documentNumber"><spring:theme code="register.documentNumber" /></label>
							<input class=" form-control validacionDocumentNumber" type="text" id="documentNumber" name="documentNumber" value="${searchUserForm.documentNumber }" 
								onkeyup="valInputText('up',this);" onchange="valInputText('change',this);" maxlength="60" >
						</div>
						
						<c:set var="hiddenStyle" value="" />
						<c:if test="${empty searchUserForm.documentType  or searchUserForm.documentType ne 'CC' }">
							<c:set var="hiddenStyle" value="display:none;" />
						</c:if>
						
						<div id="expeditionDateDiv" class="form-group" style="${hiddenStyle}">
							<label class="control-label " for="expeditionDate"><spring:theme code="register.expeditioDate"/></label>
							<input class=" form-control datepicker"  type="text" id="expeditionDate" name="expeditionDate" value="${searchUserForm.expeditionDate }">
						</div>
						
						<div class="text-right">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<button class="btn btn-primary btn-lg" type="button" onclick="validarCampos()">
									<spring:theme code="register.search"/>
								</button>
								<button class="btn btn-primary btn-lg" type="submit" style="display:none;" id="btnSearch">
									<spring:theme code="register.search"/>
								</button>
								<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href = '<c:url value="/" />'">
									<spring:theme code="register.cancel"/>
								</button>
							</ycommerce:testId>
						</div>
					</div>
				</form:form>
				
			</div>
		</div>
	</div>
</div>
</div>

<script>
function validarCampos() {
	var flagValidacion = false;
	
	var documentType = $("#documentType").val();
	if($("#documentType").val()!= "" && documentType != "Seleccionar"){
		switch (documentType){
		case "CC":
			var expeditionDate = $("#expeditionDate").val();
			if(expeditionDate!= ""){
				flagValidacion = true;
			}else{
				alert("El campo: "+'<spring:theme code="register.expeditioDate"/>'+" es obligatorio");
			}
			break;
		default:
			flagValidacion = true;
			break;
		}
	}else{
		alert("El campo: "+'<spring:theme code="register.documentType"/>'+" es obligatorio");
	}
	
	if(flagValidacion == true){
		$("#btnSearch").click();
	}
}

function valInputText(evento,objeto){
	var newValue="";
	if(realizarValidacion(objeto.value,evento)){
		var allowedCharacters=obtenerCaracteres(objeto.value,evento);	
		objeto.value.split("").forEach(function(char){
			if(in_array(char, allowedCharacters.split(""))) newValue+=char;
		});
	}else{
		newValue = objeto.value;
	}
	objeto.value=newValue;
}


function realizarValidacion(str,evento){
	var completa = "NIT-1234567";
	var realizarVal = true;
	
	switch (evento){
	case "change":
		if(str.toUpperCase() == completa){
			realizarVal = false;
		}
		break;
		
	default:
		realizarVal = true;
	}

	return realizarVal;
}

function obtenerCaracteres(str,evento){
	var inicio = "NIT"
	var allowedCharacters="0123456789azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN";
	
	switch (evento){
	case "up":
		if(str.toUpperCase().startsWith(inicio)){
			allowedCharacters="0123456789azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN-";
		}
		break;
	default:
		realizarVal = true;
		allowedCharacters="0123456789azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN";
	}

	return allowedCharacters;
}

function in_array(elem, array){
	var isIn = false;
	for(var i=0;i<array.length;i++){
		if(elem==array[i]){
			isIn=true;
		}
	}
	return isIn;
}

</script>