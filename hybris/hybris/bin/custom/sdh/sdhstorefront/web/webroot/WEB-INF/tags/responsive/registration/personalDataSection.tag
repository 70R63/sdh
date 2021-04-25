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

					<form:form method="post" commandName="SDHRegisterForm"
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
												style="background: #fff; border: 0px">t�rminos y
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
					<h3>REGLAMENTO DE USO BUZ�N ELECTR�NICO</h3>
					<p>En el presente documento se establecen las condiciones de
						validez jur�dica de las notificaciones realizadas por medio
						Electr�nico, y se definen los derechos, obligaciones y
						consecuencias del uso de esta forma de notificaci�n de acuerdo a
						lo establecido en la Ley 527 de 1999, Acuerdo 469 de 2011 y dem�s
						normas concordantes, entre la Secretar�a Distrital de Hacienda y
						el ciudadano o particular</p>
					<p>La notificaci�n por correo electr�nico est� prevista en el
						art�culo 56 del C.P.A.C.A., el cual dispone que: Las Autoridades
						podr�n notificar sus actos a trav�s de medios electr�nicos,
						siempre que el administrado haya aceptado ese medio de
						notificaci�n.</p>
					<p>
						<b>CL�USULA PRIMERA. - DEFINICIONES:</b> Para efectos del presente
						reglamento, se entender�n las siguientes definiciones, las cuales
						podr�n estar escritas en may�sculas o min�sculas.
					</p>
					<p>1. MENSAJE DE DATOS: La informaci�n generada, enviada,
						recibida, almacenada o comunicada por medios electr�nicos, �pticos
						o similares, como pudieran ser, entre otros, el Intercambio
						Electr�nico de Datos, Internet, el correo electr�nico, el
						telegrama, el t�lex o el telefax</p>
					<p>2. INTERCAMBIO ELECTR�NICO DE DATOS: La transmisi�n
						electr�nica de datos de una computadora a otra, que est�
						estructurada bajo normas t�cnicas convenidas al efecto.</p>
					<p>3. EMISOR: Es aquel agente que emite o env�a el mensaje a
						trav�s de un canal hasta un receptor.</p>
					<p>4. RECEPTOR: Es el agente que recibe el mensaje, se�al o
						c�digo (comunicaci�n) emitido por un emisor, transmisor o
						enunciante; es el destinatario que recibe la informaci�n
						suficiente.</p>
					<p>5. BUZ�N ELECTR�NICO: Espacio en la nube o dep�sito que
						sirve para almacenar mensajes de datos.</p>
					<p>CL�USULA SEGUNDA. USO DEL BUZ�N ELETR�NICO: El buz�n
						electr�nico tendr� los siguientes usos:</p>
					<p>1. Recibir cartas, invitaciones, boletines informativos y
						dem�s comunicaciones inherentes a la gesti�n realizada por la
						Secretar�a Distrital de Hacienda.</p>
					<p>2. Recibir notificaciones de los Actos Administrativos.</p>
					<p>3. Recibir respuestas a sus PQR</p>
					<p>
						<b>CL�USULA TERCERA. - DE LA NOTIFICACI�N ELECTR�NICA:</b> Se
						podr�n notificar de manera electr�nica los actos administrativos
						proferidos por las diferentes dependencias de la entidad que
						act�an en uso de las facultades administrativas, siempre que el
						administrado haya aceptado este medio de notificaci�n. Para el
						efecto, la entidad ha escogido como medio, el buz�n electr�nico.
						Para lo cual se le enviar� un mensaje d�ndole a conocer que ha
						recibido notificaci�n en su buz�n electr�nico. La notificaci�n
						quedar� surtida a partir de la fecha y hora en que el administrado
						tenga acceso al acto administrativo, es decir, que el mismo se
						deposite en la bandeja de entrada de su buz�n electr�nico. Para el
						efecto, dadas las caracter�sticas del buz�n, la entidad registrar�
						la fecha y hora reportada en la confirmaci�n de entrega del
						mensaje de datos, a trav�s del cual se dispuso el acto en su buz�n
						electr�nico, as� como la fecha y hora de la puesta del mensaje en
						su buz�n electr�nico. La notificaci�n que por este medio se
						efect�e tiene los mismos efectos de la que se realiza en forma
						personal por el funcionario competente.
					</p>
					<p>
						<b>CL�USULA CUARTA. - DEL TEXTO DEL MENSAJE DE DATOS:</b>Se
						enviar� un mensaje al correo electr�nico y/o celular registrado
						por el contribuyente en la oficina virtual en la que indica que se
						ha dispuesto un enlace en su correo electr�nico o celular desde el
						cual puede acceder a la oficina virtual a revisar sus mensajes en
						el buz�n" El texto del mensaje mediante el cual se le comunica que
						tiene notificaci�n en su buz�n electr�nico debe indicara que se ha
						dispuesto un enlace en su correo electr�nico o celular desde el
						cual puede acceder a la oficina virtual a revisar sus mensajes en
						el buz�n, se adjuntar� un certificado de la notificaci�n que
						contendr� Nombre el del interesado y la fecha de expedici�n del
						mensaje de datos del acto y oficina que lo genera.
					</p>
					<p>
						<b>CL�USULA QUINTA. - DE LOS RECURSOS:</b> Los t�rminos de
						interposici�n de los recursos y los de ejecutoria empezar�n a
						contar desde el d�a siguiente a la notificaci�n electr�nica, es
						decir, desde el d�a siguiente a aquel en el cual el mensaje de
						datos haya sido depositado en la bandeja de entrada de su buz�n
						electr�nico.
					</p>
					<p>
						<b>CL�USULA SEXTA. - OBLIGACIONES DEL USUARIO:</b>
					</p>
					<p>1.Hacer uso debido de los Actos Administrativos y/o
						Resoluciones recibidas por parte de la Secretar�a de Distrital de
						Hacienda, dem�s comunicaciones.</p>
					<p>2. Reportar a la Secretar�a de Distrital de Hacienda en un
						t�rmino no mayor a tres (3) d�ascontados a partir de la fecha de
						notificaci�n del acto o comunicaci�n, cualquier inconveniente
						relacionado con el acceso al documento notificado, cu�ndo �ste
						corresponda a posibles errores o defectos t�cnicos en su
						generaci�n atribuible a la entidad. En este caso, el error o
						defecto deber� informarse a la cuenta de Bogot� Te Escucha ,
						indicandoexpresamente el inconveniente presentado y adjuntado
						copia del mensaje de datos remitido por la entidad. (Acuerdo
						469/2011 art. 12 par�grafo 3).</p>
					<p>3. No ceder, ni hacerse sustituir por terceros en el
						ejercicio de los derechos y compromisosque asume.</p>
					<p>4. Adquirir y manejar los medios de comunicaci�n necesarios
						para utilizar los servicios ycontenidos del Buz�n Electr�nico y
						disponer de los dispositivos f�sicos que le permitan recibir o
						transmitir, v�a internet, la informaci�n aqu� prevista. El USUARIO
						adquirir� y mantendr� a su propio costo y gasto todo el equipo y
						los medios de comunicaci�n necesarios para utilizar el servicio y,
						la Secretar�a Distrital de Hacienda no se har� responsable de la
						disponibilidad, ni de la confiabilidad de dicho equipo o de los
						medios de comunicaci�n.</p>
					<p>Una vez le�do el reglamento, si est� de acuerdo haga clic en
						el bot�n correspondiente SI o NO.</p>
					<h3>REGLAMENTO DE USO DEL BUZ�N ELECTR�NICO:</h3>
					<p>
						<b>Que es el Buz�n Electr�nico</b>
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
						<b>Implementaci�n del Buz�n Electr�nico</b>
					</p>
					<p>
						<b>Reglamento de uso</b>
					</p>

					<p>
						<b>Que es el Buz�n Electr�nico</b>
					</p>
					<p>Es un servicio que permite la comunicaci�n entre la
						Direcci�n de Impuestos de Bogot� -DIB-, y los contribuyentes,
						donde se depositar�n los actos administrativos objeto de
						notificaci�n, comunicaciones informativas y respuesta a peticiones
						realizadas.</p>
					<p>La informaci�n as� como los datos que se depositen en el
						buz�n son confidenciales.</p>

					<p>
						<b>Finalidad</b>
					</p>
					<p>Hacer m�s f�cil y �gil la comunicaci�n entre la Direcci�n de
						Impuesto de Bogot� DIB, La Direcci�n Distrital de Cobro DCO y los
						contribuyentes o usuarios de los servicios ofrecidos por estos.</p>

					<p>
						<b>Sustento Legal</b>
					</p>
					<p>El Acuerdo 469 de 2011 "Por el cual se establecen medidas
						especiales de Pago de Tributos en el Distrito Capital y se dictan
						otras disposiciones", en su art�culo 12 "Notificaciones", y su
						par�grafo 3 estableci� la notificaci�n electr�nica, como la forma
						de notificaci�n de los actos administrativos emitidos por la
						administraci�n tributaria mediante el env�o de una comunicaci�n
						electr�nica, a trav�s del buz�n electr�nico que asigne la
						administraci�n tributaria a los contribuyentes, responsables,
						agentes retenedores o declarantes, que opten de manera preferente
						por esta forma de notificaci�n garantizando el principio de
						equivalencia funcional, en los t�rminos de la ley 527 de 1999.</p>

					<p>
						<b>Efectos Legales</b>
					</p>
					<p>La notificaci�n que se realice por medio del Buz�n
						Electr�nico tiene los mismos efectos legales que la notificaci�n
						realizada de forma personal por el funcionario competente.</p>

					<p>
						<b>Servicios que ofrece al usuario</b>
					</p>
					<p>El buz�n electr�nico tendr� entre otros los siguientes
						servicios:</p>
					<p>1. Recibir notificaciones de los Actos Administrativos.</p>
					<p>2. Recibir cartas, invitaciones, boletines informativos y
						dem�s comunicaciones inherentes a la gesti�n realizada por la
						Secretar�a Distrital de Hacienda.</p>
					<p>3. Recibir respuestas a sus PQR'S.</p>

					<p>
						<b>Implementaci�n del Buz�n Electr�nico</b>
					</p>
					<p>El buz�n estar� disponible para todos los ciudadanos que
						ingresen a la Oficina Virtual y quedar� habilitado de forma
						autom�tica para disponer informaci�n relacionada con impuestos,
						comunicaciones y respuestas a PQRS.</p>
					<p>
						Para recibir Notificaciones de Actos Admirativos, ser� necesario
						que autorice desde la Oficina Virtual ingresando a la opci�n RIT,
						secci�n Buz�n y marcar la opci�n <b>"Aceptar t�rminos y
							condiciones" OK.</b>
					</p>
					<p>Autorizado el buz�n, este quedar� habilitado por un a�o y
						solo pasado este tiempo podr� cambiar el estado de autorizaci�n.</p>
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