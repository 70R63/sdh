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
								code="autorizado.asignarse.tramgen.titulo" text="" /></span>
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
									code="autorizado.asignarse.tramgen.nota1" /></label>
						</div>
					</div>
				</div>
				<div class="row">

					<!-- 				primera columna representaci�n-->
					<div class="col-md-2 ">

						<label class="control-label"><spring:theme
								code="autorizado.asignarse.tramgen.represen.titulo" /></label>
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.represen.general" />
								</label>
							</div>
						</div>
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="control-label chkagent"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.represen.proceso" />
								</label>
							</div>
						</div>
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.represen.tramites" />
								</label>
							</div>
						</div>
					</div>

					<!-- 					segunda columna proceso -->
					<div class="col-md-2 ">

						<label class="control-label">
						    <spring:theme code="autorizado.asignarse.tramgen.proce.titulo" />
						</label>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM01" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.todos" />
                                </label>
                            </div>
                        </div>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM02" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.miRit" />
                                </label>
                            </div>
                        </div>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM03" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.miBuzon" />
                                </label>
                            </div>
                        </div>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM04" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.impuestos" />
                                </label>
                            </div>
                        </div>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM05" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.tramites" />
                                </label>
                            </div>
                        </div>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM06" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.facturacion" />
                                </label>
                            </div>
                        </div>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM07" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.declaraciones" />
                                </label>
                            </div>
                        </div>
                        <div class=" fomchk form-group ">
                            <div class="checkbox chkagent" role="checkbox"
                                aria-checked="false">
                                <label tabindex="0" class="chkagent control-label  "> <input
                                    id="ZM08" name="" type="checkbox" value="true"> <input
                                    type="hidden" name="_consentForm.consentGiven" value="on">
                                    <spring:theme code="autorizado.crear.tramgen.proce.consultas" />
                                </label>
                            </div>
                        </div>

						<!--
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.proce.todos" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.proce.cobco" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.proce.cobprej" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.proce.fisca" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.proce.liqui" />
								</label>
							</div>
						</div>

						-->
					</div>

					<!-- 					tercer columna tramites 1 -->
					<div class="col-md-2 ">

						<label class="control-label"><spring:theme
								code="autorizado.asignarse.tramgen.tramite.titulo" /></label>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.todos" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.actut" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.actnov" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.acpro" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.ajfact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.ancuenta" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.anfact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.aptitt" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.audec" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.autdecla" />
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.cadacc" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.cerres" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.capact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.declar" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.demba" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.desglo" />
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
										code="autorizado.asignarse.tramgen.tramite.devoluciones" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.excep" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.expedi" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.facpag" />
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.incidente" />
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
										code="autorizado.asignarse.tramgen.tramite.informacion" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.insrit" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.invali" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.modfact" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.nulidad" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.presc" />
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
										code="autorizado.asignarse.tramgen.tramite.recreconsi" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.recrepos" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.redsan" />
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.reexfac" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.remisi" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.retbole" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox chkagent"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.revdirec" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox chkagent"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.sanea" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.solicitud" />
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
										code="autorizado.asignarse.tramgen.tramite.sucesiones" />
								</label>
							</div>
						</div>
						<div class="fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.tramgen.tramite.susproces" />
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
									code="autorizado.asignarse.tramgen.nota2" /></label>
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.todos" />
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.2018" />
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.2017" />
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.2016" />
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
									<spring:theme code="autorizado.asignarse.tramgen.tramite.2015" />
								</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>