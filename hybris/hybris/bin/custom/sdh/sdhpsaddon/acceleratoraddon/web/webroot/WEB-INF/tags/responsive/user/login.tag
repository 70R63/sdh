<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true"
	type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:set var="hideDescription" value="checkout.login.loginAndCheckout" />

<div class="headline" style="text-align: center !important; margin-left: -2% !important">
	<span tabindex="0" class="new_title"
		style="font-size: 150% !important; align-items: center !important; text-align: center !important;"><spring:theme
			code="Oficina Virtual" /></span>
</div>
<div class="newLoggin">
	<div class="headline" style="text-align: center !important">
		<span tabindex="0" class="new_title"
			style="font-size: 150% !important; align-items: center !important; text-align: center !important;"><spring:theme
				code="login.title" /></span>
	</div>

	<form:form action="${action}" method="post" modelAttribute="loginForm">
		<fieldset>
			<legend class="visuallyhidden">
				<spring:theme code="login.form" />
			</legend>

			<c:if test="${not empty message}">
				<span class="has-error"> <spring:theme code="${message}" />
				</span>
			</c:if>

			<%-- 		<formElement:formInputBox idKey="j_username"labelKey="" path="j_username" mandatory="true" inputCSS="tamnewtwo form-control redtam tamnew"/> --%>
			<%-- 		<formElement:formPasswordBox idKey="j_password"   labelKey="" inputCSS="tamnewtwo form-control redtam tamnew" mandatory="true"/> --%>
			<form:input type="text" id="j_username"
				placeholder="Ingresar usuario*" path="j_username" value=""
				class="tamnewtwo form-control"
				style="margin-top: 5% !; margin-bottom: 5% !important" />
			<form:input type="password" id="j_password"
				placeholder="Ingresar contraseña*" path="j_password" value=""
				class="tamnewtwo form-control"
				style="margin-top: 5% !; margin-bottom: 5% !important" />
			<input type="hidden" id="registeredCheckout"
				name="registeredCheckout" value="${registeredCheckout}" />

			<c:choose>
				<c:when test="${captchaEnabledForCurrentStore eq true }">
					<div
						class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
				</c:when>
				<c:otherwise>
					<formElement:formCheckbox idKey="notARobot"
						labelKey="login.not.a.robot" path="notARobot" />
				</c:otherwise>
			</c:choose>

			<div class="forgotten-password"
				style="margin-bottom: 1px !important; text-align: center !important;">
				<ycommerce:testId code="login_forgotPassword_link">
					<a href="<c:url value='/login/pw/request/external'/>"
						class="pssword"
						data-cbox-title="<spring:theme code="forgottenPwd.title"/>"> <spring:theme
							code="login.link.forgottenPwd" />
					</a>
				</ycommerce:testId>
			</div>

			<div class="forgotten-password"
				style="margin-bottom: 1px !important; text-align: center !important;">
				<ycommerce:testId code="login_forgotPassword_link">
					<c:url value='/register' var="registerURL" />
					<spring:theme code="login.link.getPassword" htmlEscape="false"
						arguments="${registerURL }" />
				</ycommerce:testId>
			</div>
			<ycommerce:testId code="loginAndCheckoutButton">
				<button type="submit" class="btn btn-primary redtam tam_button"
					style="width: 100% !important; border-radius: 20px !important; background-color: #156ab5 !important; color: white !important; height: 48px !important; margin-top: 10%;">
					<spring:theme code="${actionNameKey}" />
				</button>
			</ycommerce:testId>
		</fieldset>

	</form:form>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="prefooter">
			<h2>Secretaría Distrital de Hacienda</h2>
			<aside class="footer">
				<div>
					<p>
						<img title="Bogota" alt="Bogota" class="encabezado"
							src="${themeResourcePath}/images/encabezados.svg"
							alt="Encabezados colombia" width="230" height="80">
					</p>
				</div>
			</aside>

			<div class="row"></div>
			<div class="row" style="margin-left: 1px !important;">
				<div class="col-md-12">
					<div class="block-content">
						<h2>Sede principal</h2>

						<p>
							<strong>Dirección:</strong> <em>Carrera 30 N° 25-90 - Bogotá
								D.C.</em><br> <strong>Código postal: </strong>111311<br> <strong>Horario
								de atención:</strong> <em>Lunes a viernes 7:00 am - 4:30 pm</em><br>
							<strong>Teléfono PBX:</strong> +57 (1) &nbsp;601 338 50 00<br>
							<strong>Línea gratuita:</strong> 195
						</p>

						<p>
							<a href="#">Defensoría de la ciudadanía</a><br> <a href="#">Contáctanos
								en Bogotá te escucha</a><br> <a href="#">Denuncias por
								actos de corrupción</a>
						</p>

						<p>
							<strong>Correo de notificaciones judiciales:</strong> <a
								href="mailto:notificacionesjudiciales@secretariajuridica.gov.co">notificacionesjudiciales@secretariajuridica.gov.co</a>
						</p>

						<p>
							<strong>Acciones de tutela y acciones de cumplimiento:</strong> <a
								href="mailto:tutelaycumplimiento@shd.gov.co">tutelaycumplimiento@shd.gov.co</a>
						</p>
					</div>
				</div>
			
		
					<ul class="menu-social menu-footer">
						<li><a class="font-link-1 font-sm-link-3"
							href="https://www.facebook.com/HaciendaBogota" title="Facebook"
							target="_blank"><i class="fa-facebook-f fab"></i>@HaciendaBogota</a></li>
						<li><a class="font-link-1 font-sm-link-3"
							href="https://www.instagram.com/hacienda_bogota/"
							title="Instagram" target="_blank"><i class="fa-instagram fab"></i>@Hacienda_Bogota</a></li>
						<li><a class="font-link-1 font-sm-link-3"
							href="https://twitter.com/HaciendaBogota" title="Twitter"
							target="_blank"><i class="fa-twitter fab"></i>@HaciendaBogota</a></li>
					</ul>
					<ul class="menu-terms menu-footer">
						<li><a class="font-link-2 font-sm-link-4"
							href="http://localhost:4200/noticia/secretaria-de-hacienda-presenta-el-calendario-tributario-2021-de-bogota">Términos
								y condiciones</a></li>
						<li><a class="font-link-2 font-sm-link-4" href="">Políticas</a></li>
						<li><a class="font-link-2 font-sm-link-4" href="">Accesibilidad</a></li>
						<li><a class="font-link-2 font-sm-link-4" href="">Mapa
								del sitio</a></li>
						<li><a class="font-link-2 font-sm-link-4" href="">Colaboradores
								Hacienda</a></li>
					</ul>
		</div>
		</div>
	</div>
</div>



