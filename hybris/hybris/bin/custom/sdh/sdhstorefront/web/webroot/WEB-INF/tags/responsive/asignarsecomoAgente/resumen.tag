<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head5">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse5" aria-expanded="true"
					aria-controls="collapse5">
					<h4>
						<span tabindex="0"><spring:theme
								code="autorizado.asignarse.resumen.titulo" text="" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse5" class="collapse" aria-ladelledby="head5"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row" style="margin-top: 10px">
					<div class="col-md-12"
						style="background: #d2d2d2; margin-top: 20px !important;">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="autorizado.asignarse.resumen.nota1" /></label>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: 10px; border: 1px solid #d2d2d2">
					<div class="col-md-12">
						<div class="form-group ">
							<label class="control-label" for="numDoc"> <spring:theme
									code="autorizado.asignarse.resumen.nomcont" />
							</label> <input id="" name="" class="newalto form-control"
								aria-required="true" type="text" value="" maxlength="240">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group ">
							<label class="control-label" for="numDoc"> <spring:theme
									code="autorizado.asignarse.resumen.tipdoc" />
							</label> <input id="" name="" class="newalto form-control"
								aria-required="true" type="text" value="" maxlength="240">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group ">
							<label class="control-label" for="numDoc"> <spring:theme
									code="autorizado.asignarse.resumen.numdoc" />
							</label> <input id="" name="" class="newalto form-control"
								aria-required="true" type="text" value="" maxlength="240">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group ">
							<label class="control-label" for="numDoc"> <spring:theme
									code="autorizado.asignarse.resumen.calidad" />
							</label> <input id="" name="" class="newalto form-control"
								aria-required="true" type="text" value="" maxlength="240">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group ">
							<label class="control-label" for="numDoc"> <spring:theme
									code="autorizado.asignarse.resumen.nomagente" />
							</label> <input id="" name="" class="newalto form-control"
								aria-required="true" type="text" value="" maxlength="240">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group ">
							<label class="control-label" for="numDoc"> <spring:theme
									code="autorizado.asignarse.resumen.permisos" />
							</label>
						</div>
					</div>
				</div>

				<div class="row" style="margin-top: 10px;">
					<div class="col-md-2">
						<button class="btn btn-secondary" type="button" id="">
							<spring:theme code="autorizado.asignarse.resumen.cancelar" />
						</button>
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" type="button" id="">
							<spring:theme code="autorizado.asignarse.resumen.guardar" />
						</button>
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" type="button" id="">
							<spring:theme code="autorizado.asignarse.resumen.revisar" />
						</button>
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" type="button" id="">
							<spring:theme code="autorizado.asignarse.resumen.enviar" />
						</button>
					</div>
					<div class="col-md-3">
						<button class="btn btn-primary" type="button" id="">
							<spring:theme code="autorizado.asignarse.resumen.addcalidad" />
						</button>
					</div>

				</div>

				<div class="row" style="margin-top: 10px border: 1px solid #d2d2d2"">
					<div class="col-md-12"
						style="background: #d2d2d2; margin-top: 20px !important;">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="autorizado.asignarse.resumen.nota2" /></label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

