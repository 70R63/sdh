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

					<!-- 				primera columna representaci�n-->
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.todos" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="control-label chkagent"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.miRit" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.miBuzon" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class=" fomchk form-group ">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.crear.tramgen.proce.impuestos" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false" onclick="showActos()" id="selectActos">
								<label tabindex="0" class="chkagent control-label"> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme
										code="autorizado.crear.tramgen.proce.actosOficiales" />
								</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2 ">
					<div class="fomchk  form-group">
						<div class="checkbox chkagent" role="checkbox"
							aria-checked="false">
							<label tabindex="0" class="chkagent control-label"> <input
								id="" name="" type="checkbox" value="true"> <input
								type="hidden" name="_consentForm.consentGiven" value="on">
								<spring:theme code="autorizado.crear.tramgen.proce.tramites" />
							</label>
						</div>
					</div>
				</div>
				<div class="col-md-2 ">
					<div class=" fomchk form-group ">
						<div class="checkbox chkagent" role="checkbox"
							aria-checked="false">
							<label tabindex="0" class="control-label chkagent"> <input
								id="" name="" type="checkbox" value="true"> <input
								type="hidden" name="_consentForm.consentGiven" value="on">
								<spring:theme code="autorizado.crear.tramgen.proce.facturacion" />
							</label>
						</div>
					</div>
				</div>
				<div class="col-md-2 ">
					<div class=" fomchk form-group ">
						<div class="checkbox chkagent" role="checkbox"
							aria-checked="false">
							<label tabindex="0" class="chkagent control-label"> <input
								id="" name="" type="checkbox" value="true"> <input
								type="hidden" name="_consentForm.consentGiven" value="on">
								<spring:theme
									code="autorizado.crear.tramgen.proce.declaraciones" />
							</label>
						</div>
					</div>
				</div>
				<div class="col-md-2 ">
					<div class=" fomchk form-group ">
						<div class="checkbox chkagent" role="checkbox"
							aria-checked="false">
							<label tabindex="0" class="chkagent control-label"> <input
								id="" name="" type="checkbox" value="true"> <input
								type="hidden" name="_consentForm.consentGiven" value="on">
								<spring:theme code="autorizado.crear.tramgen.proce.consultas" />
							</label>
						</div>
					</div>
				</div>
			</div>

			<!-- 			Seccion de actos oficiales -->
			<div id="actosOficiales" class="row justify-content-center"
				style="display: none">
				<div class="row justify-content-center">
					<div class="col-md-12 col-md-offset-3"
						style="background: #d2d2d2; margin-top: 20px !important; width: 50% !important">
						<div class="form-group">
							<br> <br>
						</div>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-md-6">
						<div style="text-align: end; padding: 17px;">
							<label class="control-label"><spring:theme
									code="autorizado.crear.tramgen.proce.actosOficiales" /></label>
						</div>
					</div>
					<div class="col-md-6">
						<div style="padding: 17px;">
							<label class="control-label"><spring:theme
									code="autorizado.crear.tramgen.proce.idacto" /><input
								id="inputActos" class="form-control"
								style="min-height: 12px !important;" /></label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

function showActos() {
	var selectActos =  document.getElementById("selectActos");
	var divActos = document.getElementById("actosOficiales");
	var inputActos = document.getElementById("inputActos");
	var seleccionado = selectActos.ariaChecked;
	
	if(seleccionado != "true"){
		divActos.style.display="none";
		inputActos.value="";
		
		
	}else{
		divActos.style.display="block";
		inputActos.value="";		
	}

}
</script>
