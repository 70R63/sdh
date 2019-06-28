<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div id="acordeon" class="container_new">
	<div class="card cardmirit ">
		<div class="card-header" id="head1" style="background: #f2f2f2">
			<h5 class="mb-0">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse1" aria-expanded="true"
					aria-controls="collapse1">
					<h4>
						<span tabindex="0"><spring:theme
								code="mirit.generalData.title" text="Mis datos generales" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse1" class="collapse" aria-ladelledby="head1"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row">
					<!--  First column of form -->
					<div class="col-md-3">
						<!-- 				<div class="form-group "> -->
						<!-- 					<label class="control-label required" for="tratamiento"> -->
						<%-- 						<spring:theme code="mirit.generalData.treatment"/> --%>
						<!-- 					</label>  -->
						<!-- 					<select id="tratamiento" name="tratamiento" class="form-control" disabled=""> -->
						<%-- 		                <option value="${miRitForm.tratamiento}" ><spring:theme code="rit.tratamiento.t${miRitForm.tratamiento}" /></option> --%>
						<!-- 		              </select> -->
						<!-- 					<div class="help-block"> -->
						<!-- 						<span id="lastName.errors" class="hidden">Seleccione un tipo de documento</span> -->
						<!-- 					</div> -->
						<!-- 				</div> -->
						<div class="form-group ">
							<label class="control-label required" for="sexo"> <spring:theme
									code="mirit.generalData.gender" />
							</label> <input id="sexo" name="sexo" class="newalto form-control"
								disabled="disabled" aria-required="true" type="text"
								value="<spring:theme code="rit.sexo.s${miRitForm.sexo}" />"
								maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un
									tipo de documento</span>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label required" for="birthDate"> <spring:theme
									code="mirit.generalData.birthDate" />
							</label> <input id="birthDate" name="birthDate" class="newalto form-control"
								disabled="disabled" aria-required="true" type="text"
								value="${miRitForm.fechaNacimiento}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un
									tipo de documento</span>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label required" for="paisOrigen"> <spring:theme
									code="mirit.generalData.originCountry" />
							</label> <input id="paisOrigen" name="paisOrigen" class="newalto form-control "
								disabled="disabled" aria-required="true" type="text"
								value="<spring:theme code="rit.pais.p${miRitForm.paisOrigen}" />"
								maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un
									tipo de documento</span>
							</div>
						</div>

					</div>


					<!--  Second column of form -->
					<div class="col-md-3">
						<div class="form-group ">
							<label class="control-label required" for="claseIC"> <spring:theme
									code="mirit.generalData.classIC" />
							</label> <select id="claseIC" name="claseIC" class="newalto form-control"
								disabled="disabled">
								<option value="${miRitForm.claseIC}"><spring:theme
										code="rit.claseIC.c${miRitForm.claseIC}" /></option>
							</select>
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un
									tipo de documento</span>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label required" for="nacionalidad">
								<spring:theme code="mirit.generalData.nationality" />
							</label> <input id="nacionalidad" name="nacionalidad" disabled="disabled"
								class="newalto form-control  " aria-required="true" type="text"
								value="<spring:theme code="rit.pais.p${miRitForm.nacionalidad}" />"
								maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un
									tipo de documento</span>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label required" for="lugarNacimiento">
								<spring:theme code="mirit.generalData.birthPlace" />
							</label> <input id="lugarNacimiento" name="lugarNacimiento"
								class="newalto form-control  " disabled="disabled" aria-required="true"
								type="text" value="${miRitForm.lugarNacimiento}" maxlength="240">
							<div class="help-block">
								<span id="lastName.errors" class="hidden">Seleccione un
									tipo de documento</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
