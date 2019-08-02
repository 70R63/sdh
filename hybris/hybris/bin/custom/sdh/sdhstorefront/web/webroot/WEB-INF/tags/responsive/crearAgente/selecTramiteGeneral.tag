<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head3">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse3" aria-expanded="true"
					aria-controls="collapse3">
					<h4>
						<span tabindex="0"><spring:theme
								code="autorizado.crear.tramgen.titulo" text="" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse3" class="collapse" aria-ladelledby="head3"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row mt-3">
					<div class="col-md-12"
						style="background: #d2d2d2; margin-top: 20px !important;">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="autorizado.crear.tramgen.nota1" /></label>
						</div>
					</div>
				</div>
				<div class="row">

					<!-- 				primera columna representación-->
					<div class="col-md-2 ">

						<label class="control-label"><spring:theme
								code="autorizado.crear.tramgen.represen.titulo" /></label>
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.represen.general" />
								</label>
							</div>
						</div>
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="control-label chkagent"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.represen.proceso" />
								</label>
							</div>
						</div>
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.represen.tramites" />
								</label>
							</div>
						</div>
					</div>

					<!-- 					segunda columna proceso -->
					<div class="col-md-2 ">

						<label class="control-label"><spring:theme
								code="autorizado.crear.tramgen.proce.titulo" /></label>
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.todos" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.cobco" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.cobprej" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.fisca" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.liqui" />
								</label>
							</div>
						</div>
					</div>

					<!-- 					tercer columna tramites 1 -->
					<div class="col-md-2 ">

						<label class="control-label"><spring:theme
								code="autorizado.crear.tramgen.tramite.titulo" /></label>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.todos" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.actut" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.actnov" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.acpro" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.ajfact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.ancuenta" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.anfact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.aptitt" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.audec" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.autdecla" />
								</label>
							</div>
						</div>
					</div>



					<!-- 					tercer columna tramites 2 -->
					<div class="col-md-2 ">
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.cadacc" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.cerres" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.capact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.declar" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.demba" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.desglo" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme
										code="autorizado.crear.tramgen.tramite.devoluciones" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.excep" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.expedi" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.facpag" />
								</label>
							</div>
						</div>
					</div>

					<!-- 					tercer columna tramites 3 -->
					<div class="col-md-2 ">
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.incidente" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme
										code="autorizado.crear.tramgen.tramite.informacion" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.insrit" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.invali" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.modfact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.nulidad" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.presc" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme
										code="autorizado.crear.tramgen.tramite.recreconsi" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.recrepos" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.redsan" />
								</label>
							</div>
						</div>
					</div>

					<!-- 					tercer columna tramites 4 -->
					<div class="col-md-2 ">
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.reexfac" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.remisi" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.retbole" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox chkagent"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.revdirec" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox chkagent"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.sanea" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.solicitud" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme
										code="autorizado.crear.tramgen.tramite.sucesiones" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.susproces" />
								</label>
							</div>
						</div>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-md-12"
						style="background: #d2d2d2; margin-top: 20px !important;">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="autorizado.crear.tramgen.nota2" /></label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-1">
						<div class="fomchk  form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.todos" />
								</label>
							</div>
						</div>
					</div>

					<div class="col-md-1">
						<div class="fomchk  form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.2018" />
								</label>
							</div>
						</div>
					</div>

					<div class="col-md-1">
						<div class="fomchk  form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.2017" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-1">
						<div class="fomchk  form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.2016" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-1">
						<div class="fomchk  form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.tramite.2015" />
								</label>
							</div>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
</div>