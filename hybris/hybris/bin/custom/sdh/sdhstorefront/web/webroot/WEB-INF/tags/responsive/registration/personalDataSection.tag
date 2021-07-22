<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="item_container_holder ">
				<div class="forgotten-password item_container ">
					<c:url var="action" value="/register/newcustomer" />

					<form:form method="post" modelAttribute="SDHRegisterForm"
						action="${action}"> 
						<fieldset>
							<div class="headline">
								<h2>
									<span tabindex="0"><spring:theme
											code="register.personalData.title" /></span>
								</h2>
							</div>
							<div class="description">
								<spring:theme code="register.emailUser" htmlEscape="false" />
							</div>
							<input name="titleCode" id="titleCode" value="mr" type="hidden" />

							<formElement:formInputBox idKey="register.email"
								labelKey="register.email" path="email" inputCSS="form-control"
								mandatory="true" />
							<formElement:formInputBox idKey="register.confirmEmail"
								labelKey="register.confirmEmail" path="confirmEmail"
								inputCSS="form-control" mandatory="true" />
							<formElement:formPasswordBox idKey="password"
								labelKey="register.pwd" path="pwd"
								inputCSS="form-control password-strength" mandatory="true" />
							<formElement:formPasswordBox idKey="register.checkPwd"
								labelKey="register.checkPwd" path="checkPwd"
								inputCSS="form-control" mandatory="true" />

							<div class="description">
								<spring:theme code="register.passwordRequirements"
									htmlEscape="false" />
							</div>
							<div class="row" id="mensaggeBuzon">
								<div class="col-md-12">
									<div class="form-group ">
										<label class="control-label" for=""> <spring:theme
												code="buzon.mirit.mensaje" />
											<button id="terminosPopUpRegister"
												class="terminosPopUpRegister"
												style="background: #fff; border: 0px">términos y
												condiciones</button>
										</label>
									</div>
								</div>
							</div>
							
							<c:choose>
         
         <c:when test = "${valorBuzon == 1}">
            <div style="cursor: not-allowed; pointer-events: none;">
								<formElement:formCheckbox idKey="useEmailForNotifications"
									labelKey="register.activateInbox"
									path="useEmailForNotifications"
									inputCSS="form-control disabled" labelCSS="checkedlabel" />
							</div>
         </c:when>
         
         <c:otherwise>
           <div style="cursor: not-allowed; pointer-events: none;">
								<formElement:formCheckbox labelCSS="" idKey="useEmailForNotifications"
									labelKey="register.activateInbox"
									path="useEmailForNotifications"
									inputCSS="form-control disabled checked"/>
							</div>
         </c:otherwise>
      </c:choose>

							
							<formElement:formCheckbox
								idKey="useInformationForInstitutionalPurposes"
								labelKey="register.personalDataAuthorization"
								path="useInformationForInstitutionalPurposes"
								inputCSS="form-control" />


							<div class="text-right">
								<ycommerce:testId code="login_forgotPasswordSubmit_button">
									<button class="btn btn-primary btn-lg" type="submit">
										<spring:theme code="register.send" />
									</button>
									<button class="btn btn-secondary btn-lg" type="button"
										onclick="window.location.href = '<c:url value="/" />'">
										<spring:theme code="register.cancel" />
									</button>
								</ycommerce:testId>
							</div>

						</fieldset>
					</form:form>



				</div>
			</div>
		</div>
	</div>
</div>


<div class="terminosycondiciones" style="display: none;">
	<div class="js-terminos-facet" id="js-terminos-facet">
		<div class="facet js-facet-veh">
			<div class="facet__name js-facet-name-veh">
				<spring:theme code="" />
				<div class="" id="mensajeTerminosCondiciones">
					<h3>REGLAMENTO DE USO BUZÓN ELECTRÓNICO</h3>
					<p>En el presente documento se establecen las condiciones de
						validez jurídica de las notificaciones realizadas por medio
						Electrónico, y se definen los derechos, obligaciones y
						consecuencias del uso de esta forma de notificación de acuerdo a
						lo establecido en la Ley 527 de 1999, Acuerdo 469 de 2011 y demás
						normas concordantes, entre la Secretaría Distrital de Hacienda y
						el ciudadano o particular</p>
					<p>La notificación por correo electrónico está prevista en el
						artículo 56 del C.P.A.C.A., el cual dispone que: Las Autoridades
						podrán notificar sus actos a través de medios electrónicos,
						siempre que el administrado haya aceptado ese medio de
						notificación.</p>
					<p>
						<b>CLÁUSULA PRIMERA. - DEFINICIONES:</b> Para efectos del presente
						reglamento, se entenderán las siguientes definiciones, las cuales
						podrán estar escritas en mayúsculas o minúsculas.
					</p>
					<p>1. MENSAJE DE DATOS: La información generada, enviada,
						recibida, almacenada o comunicada por medios electrónicos, ópticos
						o similares, como pudieran ser, entre otros, el Intercambio
						Electrónico de Datos, Internet, el correo electrónico, el
						telegrama, el télex o el telefax</p>
					<p>2. INTERCAMBIO ELECTRÓNICO DE DATOS: La transmisión
						electrónica de datos de una computadora a otra, que está
						estructurada bajo normas técnicas convenidas al efecto.</p>
					<p>3. EMISOR: Es aquel agente que emite o envía el mensaje a
						través de un canal hasta un receptor.</p>
					<p>4. RECEPTOR: Es el agente que recibe el mensaje, señal o
						código (comunicación) emitido por un emisor, transmisor o
						enunciante; es el destinatario que recibe la información
						suficiente.</p>
					<p>5. BUZÓN ELECTRÓNICO: Espacio en la nube o depósito que
						sirve para almacenar mensajes de datos.</p>
					<p>CLÁUSULA SEGUNDA. USO DEL BUZÓN ELETRÓNICO: El buzón
						electrónico tendrá los siguientes usos:</p>
					<p>1. Recibir cartas, invitaciones, boletines informativos y
						demás comunicaciones inherentes a la gestión realizada por la
						Secretaría Distrital de Hacienda.</p>
					<p>2. Recibir notificaciones de los Actos Administrativos.</p>
					<p>3. Recibir respuestas a sus PQR</p>
					<p>
						<b>CLÁUSULA TERCERA. - DE LA NOTIFICACIÓN ELECTRÓNICA:</b> Se
						podrán notificar de manera electrónica los actos administrativos
						proferidos por las diferentes dependencias de la entidad que
						actúan en uso de las facultades administrativas, siempre que el
						administrado haya aceptado este medio de notificación. Para el
						efecto, la entidad ha escogido como medio, el buzón electrónico.
						Para lo cual se le enviará un mensaje dándole a conocer que ha
						recibido notificación en su buzón electrónico. La notificación
						quedará surtida a partir de la fecha y hora en que el administrado
						tenga acceso al acto administrativo, es decir, que el mismo se
						deposite en la bandeja de entrada de su buzón electrónico. Para el
						efecto, dadas las características del buzón, la entidad registrará
						la fecha y hora reportada en la confirmación de entrega del
						mensaje de datos, a través del cual se dispuso el acto en su buzón
						electrónico, así como la fecha y hora de la puesta del mensaje en
						su buzón electrónico. La notificación que por este medio se
						efectúe tiene los mismos efectos de la que se realiza en forma
						personal por el funcionario competente.
					</p>
					<p>
						<b>CLÁUSULA CUARTA. - DEL TEXTO DEL MENSAJE DE DATOS:</b>Se
						enviará un mensaje al correo electrónico y/o celular registrado
						por el contribuyente en la oficina virtual en la que indica que se
						ha dispuesto un enlace en su correo electrónico o celular desde el
						cual puede acceder a la oficina virtual a revisar sus mensajes en
						el buzón" El texto del mensaje mediante el cual se le comunica que
						tiene notificación en su buzón electrónico debe indicara que se ha
						dispuesto un enlace en su correo electrónico o celular desde el
						cual puede acceder a la oficina virtual a revisar sus mensajes en
						el buzón, se adjuntará un certificado de la notificación que
						contendrá Nombre el del interesado y la fecha de expedición del
						mensaje de datos del acto y oficina que lo genera.
					</p>
					<p>
						<b>CLÁUSULA QUINTA. - DE LOS RECURSOS:</b> Los términos de
						interposición de los recursos y los de ejecutoria empezarán a
						contar desde el día siguiente a la notificación electrónica, es
						decir, desde el día siguiente a aquel en el cual el mensaje de
						datos haya sido depositado en la bandeja de entrada de su buzón
						electrónico.
					</p>
					<p>
						<b>CLÁUSULA SEXTA. - OBLIGACIONES DEL USUARIO:</b>
					</p>
					<p>1.Hacer uso debido de los Actos Administrativos y/o
						Resoluciones recibidas por parte de la Secretaría de Distrital de
						Hacienda, demás comunicaciones.</p>
					<p>2. Reportar a la Secretaría de Distrital de Hacienda en un
						término no mayor a tres (3) díascontados a partir de la fecha de
						notificación del acto o comunicación, cualquier inconveniente
						relacionado con el acceso al documento notificado, cuándo éste
						corresponda a posibles errores o defectos técnicos en su
						generación atribuible a la entidad. En este caso, el error o
						defecto deberá informarse a la cuenta de Bogotá Te Escucha ,
						indicandoexpresamente el inconveniente presentado y adjuntado
						copia del mensaje de datos remitido por la entidad. (Acuerdo
						469/2011 art. 12 parágrafo 3).</p>
					<p>3. No ceder, ni hacerse sustituir por terceros en el
						ejercicio de los derechos y compromisosque asume.</p>
					<p>4. Adquirir y manejar los medios de comunicación necesarios
						para utilizar los servicios ycontenidos del Buzón Electrónico y
						disponer de los dispositivos físicos que le permitan recibir o
						transmitir, vía internet, la información aquí prevista. El USUARIO
						adquirirá y mantendrá a su propio costo y gasto todo el equipo y
						los medios de comunicación necesarios para utilizar el servicio y,
						la Secretaría Distrital de Hacienda no se hará responsable de la
						disponibilidad, ni de la confiabilidad de dicho equipo o de los
						medios de comunicación.</p>
					<p>Una vez leído el reglamento, si está de acuerdo haga clic en
						el botón correspondiente SI o NO.</p>
					<h3>REGLAMENTO DE USO DEL BUZÓN ELECTRÓNICO:</h3>
					<p>
						<b>Que es el Buzón Electrónico</b>
					</p>
					<p>
						<b>Finalidad</b>
					</p>
					<p>
						<b>Sustento Legal</b>
					</p>
					<p>
						<b>Efectos Legales</b>
					</p>
					<p>
						<b>Servicios que ofrece al usuario</b>
					</p>
					<p>
						<b>Implementación del Buzón Electrónico</b>
					</p>
					<p>
						<b>Reglamento de uso</b>
					</p>

					<p>
						<b>Que es el Buzón Electrónico</b>
					</p>
					<p>Es un servicio que permite la comunicación entre la
						Dirección de Impuestos de Bogotá -DIB-, y los contribuyentes,
						donde se depositarán los actos administrativos objeto de
						notificación, comunicaciones informativas y respuesta a peticiones
						realizadas.</p>
					<p>La información así como los datos que se depositen en el
						buzón son confidenciales.</p>

					<p>
						<b>Finalidad</b>
					</p>
					<p>Hacer más fácil y ágil la comunicación entre la Dirección de
						Impuesto de Bogotá DIB, La Dirección Distrital de Cobro DCO y los
						contribuyentes o usuarios de los servicios ofrecidos por estos.</p>

					<p>
						<b>Sustento Legal</b>
					</p>
					<p>El Acuerdo 469 de 2011 "Por el cual se establecen medidas
						especiales de Pago de Tributos en el Distrito Capital y se dictan
						otras disposiciones", en su artículo 12 "Notificaciones", y su
						parágrafo 3 estableció la notificación electrónica, como la forma
						de notificación de los actos administrativos emitidos por la
						administración tributaria mediante el envío de una comunicación
						electrónica, a través del buzón electrónico que asigne la
						administración tributaria a los contribuyentes, responsables,
						agentes retenedores o declarantes, que opten de manera preferente
						por esta forma de notificación garantizando el principio de
						equivalencia funcional, en los términos de la ley 527 de 1999.</p>

					<p>
						<b>Efectos Legales</b>
					</p>
					<p>La notificación que se realice por medio del Buzón
						Electrónico tiene los mismos efectos legales que la notificación
						realizada de forma personal por el funcionario competente.</p>

					<p>
						<b>Servicios que ofrece al usuario</b>
					</p>
					<p>El buzón electrónico tendrá entre otros los siguientes
						servicios:</p>
					<p>1. Recibir notificaciones de los Actos Administrativos.</p>
					<p>2. Recibir cartas, invitaciones, boletines informativos y
						demás comunicaciones inherentes a la gestión realizada por la
						Secretaría Distrital de Hacienda.</p>
					<p>3. Recibir respuestas a sus PQR'S.</p>

					<p>
						<b>Implementación del Buzón Electrónico</b>
					</p>
					<p>El buzón estará disponible para todos los ciudadanos que
						ingresen a la Oficina Virtual y quedará habilitado de forma
						automática para disponer información relacionada con impuestos,
						comunicaciones y respuestas a PQRS.</p>
					<p>
						Para recibir Notificaciones de Actos Admirativos, será necesario
						que autorice desde la Oficina Virtual ingresando a la opción RIT,
						sección Buzón y marcar la opción <b>"Aceptar términos y
							condiciones" OK.</b>
					</p>
					<p>Autorizado el buzón, este quedará habilitado por un año y
						solo pasado este tiempo podrá cambiar el estado de autorización.</p>
				</div>
				<div class="row">
					<div class="col-md-4">
						<button class="btn btn-primary btn-block btn-lg " type="button"
							id="" onclick="ACC.mirit.terminosRegister()">
							<spring:theme code="Aceptar" />
						</button>
					</div>
<!-- 				</div> -->
<!-- 				<div class="row"> -->
				
					<div class="col-md-4">
						<button class="btn btn-secondary btn-block btn-lg " type="button"
							id="" onclick="ACC.mirit.terminosCancelarRegister()">
							<spring:theme code="Cancelar" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>