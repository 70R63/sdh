<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row" style="margin-top: 10px !important">
		<div class="col-md-2">
			<table class="table">
				<thead>
					<tr>
						<th><label class="control-label labeltabletd" for=""><spring:theme
									code="autorizado.asignarse.table.tipdoc" /></label></th>
						<th><label class="control-label labeltabletd" for=""><spring:theme
									code="autorizado.asignarse.table.numdoc" /></label></th>
						<th><label class="control-label labeltabletd" for="">
								<spring:theme code="autorizado.asignarse.table.nombre" />
						</label></th>
						<th><label class="control-label labeltabletd" for="">
								<spring:theme code="autorizado.asignarse.table.tipperson" />
						</label></th>

					</tr>
				</thead>
				<tbody>

					<tr>
						<td><input class="inputtextnew tablefechas" maxlength="30"
							size="30" disabled="disabled" type="text"
							value="<c:out value=""></c:out>" /></td>
						<td><input class="inputtextnew tablefechas" maxlength="30"
							size="30" disabled="disabled" type="text"
							value="<c:out value=""></c:out>" /></td>
						<td><input class="inputtextnew tablefechas" maxlength="30"
							size="30" disabled="disabled" type="text"
							value="<c:out value=""></c:out>" /></td>
						<td><input class="inputtextnew tablefechas" maxlength="30"
							size="30" disabled="disabled" type="text"
							value="<c:out value=""></c:out>" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head1">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse1" aria-expanded="true"
					aria-controls="collapse1">
					<h4>
						<span tabindex="0"><spring:theme
								code="autorizado.asignarse.calidad.titulo" text="" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse1" class="collapse" aria-ladelledby="head1"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row mt-3">
					<div class="col-md-12"
						style="background: #d2d2d2; margin: 10px !important;">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="autorizado.asignarse.calidad.nota1" /></label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.admin" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.apgeneral" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.herede" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.tutor" />
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.agofici" />
								</label>
							</div>
						</div>
					</div>

					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.contador" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.liqui" />
								</label>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.agenex" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.curador" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.padres" />
								</label>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.albacea" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.dontarios" />
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="fomchk  form-group">
							<div class="checkbox chkagent" role="checkbox"
								aria-checked="false">
								<label tabindex="0" class="chkagent control-label  "> <input
									id="" name="" type="checkbox" value="true"> <input
									type="hidden" name="_consentForm.consentGiven" value="on">
									<spring:theme code="autorizado.asignarse.calidad.revfiscal" />
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="alert alert-warning">
							<spring:theme code="autorizado.asignarse.calidad.nota3" />
							<br>
							<spring:theme code="autorizado.asignarse.calidad.nota4" />
							<br>
							<spring:theme code="autorizado.asignarse.calidad.nota5" />
							<br>
							<br>
							<spring:theme code="autorizado.asignarse.calidad.nota6" />
							<br>
							<br>
							<spring:theme code="autorizado.asignarse.calidad.nota7" />
						</div>
					</div>
				</div>




			</div>
		</div>
	</div>
</div>

