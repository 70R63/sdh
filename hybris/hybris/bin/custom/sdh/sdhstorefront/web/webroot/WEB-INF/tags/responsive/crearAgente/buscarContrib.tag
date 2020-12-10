<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new_page">
	<div class="row mt-3">
		<div class="col-md-12 mt-3">
			<div class="headline">
				<h2>
					<span><spring:theme code="autorizado.crear.inicial.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
	<div class="row mt-3">
		<div class="col-md-12"
			style="background: #d2d2d2; margin-top: 20px !important;">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="autorizado.crear.inicial.nota" /></label>
			</div>
		</div>
	</div>
</div>
<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head0">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse0" aria-expanded="true"
					aria-controls="collapse0">
					<h4>
						<span tabindex="0"><spring:theme
								code="autorizado.crear.buscar.titulo" text="" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse0" class="collapse" aria-ladelledby="head0"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row">
					<div class="col-md-3 col-xs-2">
						<div class="form-group ">
							<label class="control-label"> <spring:theme
									code="autorizado.crear.buscar.tipdoc" text="" /></label> <select id="documentType"
								class="newalto form-control" onchange="fechaExpedicion(this)">
								<option value="CC">Seleccionar</option>
								<option value="CC">Cedula de Ciudadania</option>
								<option value="CE">Cedula de Extranjería</option>
								<option value="NIT">N.I.T</option>
								<option value="PA">Pasaporte</option>
							</select>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group " >
							<label class="control-label required" for="numDoc"> <spring:theme
									code="autorizado.crear.buscar.numdoc" />
							</label> <input id="documentNumber" name="" class="newalto form-control"
								aria-required="true" type="text" value="" maxlength="240" >
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group" style="display:none" id="fechaExpedicion">
							<label class="control-label"> <spring:theme
									code="autorizado.crear.buscar.fecexpe" />
							</label> <input id="issuedDate" name="" class="newalto form-control"
								aria-required="true" type="text" value="" maxlength="240"
								placeholder="dd/mm/aaaa">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<button class="btn btn-secondary" type="button" id="">
							<spring:theme code="autorizado.crear.buscar.cancelar" />
						</button>
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" type="button" id="" onclick="detalleBP()">
							<spring:theme code="autorizado.crear.buscar.buscar" />
						</button>
					</div>

				</div>
				<br>
				<div class="row">
				<div class="col-md-2">
						<div class="form-group ">
							<label class="control-label"> <spring:theme
									code="autorizado.crear.buscar.fechinivali" />
							</label> <input id="iniDate" name="" class="newalto form-control"
								aria-required="true" type="date" value="" maxlength="240"
								placeholder="dd/mm/aaaa">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group ">
							<label class="control-label"> <spring:theme
									code="autorizado.crear.buscar.fechfinvali" />
							</label> <input id="finDate" name="" class="newalto form-control"
								aria-required="true" type="date" value="" maxlength="240"
								placeholder="dd/mm/aaaa">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
