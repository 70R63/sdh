<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head5">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse5" aria-expanded="true"
					aria-controls="collapse5">
					<h4>
						<span tabindex="0"><spring:theme
								code="mirit.constents.title" text="Autorizaciones" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse5" class="collapse" aria-ladelledby="head5"
			data-parent="#acordeon">
			<div class="card-body">

				<c:set var="checkBuzon" value="false" />
				<c:set var="checked" value="" />
				<c:if test="${miRitForm.useEmailForNotifications }">
					<c:set var="checkBuzon" value="true" />
					<c:set var="checked" value="checked" />
				</c:if>
				<!-- 				<div class="row" id="mensaggeBuzon" style="visibility: hidden"> -->
				<!-- 				<div class="global-alerts"> -->
				<!-- 		<button class="global-alert close" aria-label="Cerrar este mensaje" data-dismiss="alert" type="button"><span aria-label="Close">×</span></button> -->
				<!-- 				<div class="alert alert-info alert-dismissable"> -->
				<%-- 					<spring:theme --%>
				<%-- 										code="buzon.mirit.mensaje" /> --%>
				<!-- 				</div> -->
				<!-- 			</div> -->
				<!-- 			</div> -->
				<div class="row"  id="mensaggeBuzon" style="visibility: hidden">
					<div class="col-md-12">
						<div class="form-group ">
							<label class="control-label" for="" > <spring:theme
									code="buzon.mirit.mensaje" />
							</label>
						</div>
					</div>
				</div>
				
				<div class="row" onclick="showMessage()">
					<div class="col-md-8 ">
						<div class="form-group ">

							<div class="checkbox" role="checkbox" aria-checked="false"
								id="buzon2">
								<label tabindex="0" class="control-label" id="buzon3"> <input
									id="buzon" name="buzon" type="checkbox" ${ checked}
									value="true"> <input type="hidden"
									name="_consentForm.consentGiven" value="on"> <spring:theme
										code="mirit.constents.notifications" />
								</label>
							</div>
						</div>
					</div>
				</div>
				<c:set var="checkAutUsoInfo" value="false" />
				<c:set var="checked" value="" />
				<c:if test="${miRitForm.useInformationForInstitutionalPurposes }">
					<c:set var="checkAutUsoInfo" value="true" />
					<c:set var="checked" value="checked" />
				</c:if>
				<div class="row">
					<div class="col-md-8 ">
						<div class="form-group ">
							<div class="checkbox" role="checkbox" aria-checked="false"
								id="buzoncheck">
								<label tabindex="0" class="control-label "> <input
									id="usoInformacion" name="usoInformacion" type="checkbox"
									${ checked} value="true"> <input type="hidden"
									name="_consentForm.consentGiven" value="on"> <spring:theme
										code="mirit.constents.useOfInformation" />
								</label>
							</div>
						</div>
					</div>
				</div>
				<!-- 						<div class="row"> -->
				<!-- 					<div class="col-md-8 "> -->
				<!-- 						<div class="form-group "> -->
				<!-- 							<div class="checkbox" role="checkbox" aria-checked="false"> -->
				<!-- 								<label tabindex="0" class="control-label "> <input -->
				<!-- 									id="termsConditions" name="termsConditions" type="checkbox" -->
				<%-- 									${ checked} value="true"> <input type="hidden" --%>
				<%-- 									name="_consentForm.consentGiven" value="on"> <spring:theme --%>
				<%-- 										code="mirit.constents.termsConditions" /> --%>
				<!-- 								</label> -->
				<!-- 							</div> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<div class="row">
					<div class="col-12 col-md-3  ">
						<div class="form-group ">
							<button class="btn btn-secondary btn-block btn-lg " type="button"
								id="updateAutorizacionesButton">
								<spring:theme code="mirit.contactData.updateAutorizaciones" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function showMessage() {
		debugger;
		var chulo3 = document.getElementById("buzon").checked;
		if (chulo3 == true) {
			alert("Usted NO esta aceptando los términos y condiciones. \n Aquí van los términos y condiciones.");
		} else {
			alert("Usted esta aceptando los términos y condiciones. \n Aquí van los términos y condiciones.");
		}
	}
</script>

