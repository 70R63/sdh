<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="controllerPseConstants" class="de.hybris.sdh.core.constants.ControllerPseConstants"/>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<script src="jquery.min.js"></script>


<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var = "tipoDeImpuestoSeleccionado" scope = "session" value = "${psePaymentForm.tipoDeImpuesto}"/>
<%-- <c:set var = "buttonImagePSE" scope = "session" value = "https://jumpseller.co/images/support/pse/logopse.png"/> --%>
<c:set var = "buttonImagePSE" scope = "session" value = "http://blog.achcolombia.com.co/wp-content/themes/ach/img/logo.svg"/>
<c:set var = "buttonImageCRE" scope = "session" value = "https://acis.org.co/portal/sites/default/files/5907822af25d3c0dd184dc45_credibanco.png"/>
<c:set var = "buttonImageCredibanco" scope = "session" value = "https://acis.org.co/portal/sites/default/files/5907822af25d3c0dd184dc45_credibanco.png"/>
<c:set var = "buttonImageBBVA" scope = "session" value = "https://pbs.twimg.com/profile_images/907185208549572608/Hn65NsHV_400x400.jpg"/>
<c:set var = "buttonImageDAVIVIENDA" scope = "session" value = "https://d31dn7nfpuwjnm.cloudfront.net/images/valoraciones/0029/4616/davivienda.png"/>

<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<c:url var="obligaciones" value="/contribuyentes/consultas/obligaciones"/> 
			
				<form:form id="psePaymentFormSubmition" method="" commandName="" action="">					
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<c:if test = "${disabled eq false or not empty flagReintetarPago}">
									<div id="PSE" class="text-center">

									    <button id="" class="btn btn-secondary btn-lg" type="button" onclick="location.href='${obligaciones}';" disabled>
                                           Obligaciones Pendientes 
                                        </button>
                                                
										<button class="btn btn-secondary btn-lg" type="button" onclick="goBack()">
											<spring:theme code="impuestos.decGasolina.Pago.Regresar"/>
										</button>
									</div>
								</c:if>
							</ycommerce:testId>
						
				</form:form>
				
						
				
			</div>
		</div>
	</div>
</div>


