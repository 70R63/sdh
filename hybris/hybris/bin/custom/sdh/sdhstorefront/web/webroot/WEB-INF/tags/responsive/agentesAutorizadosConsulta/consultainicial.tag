<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="avisoheadline text-center " style="width: auto; height: 35px;">
				<h2>
					<span class="p"><spring:theme
							code="autorizado.consultas.inicial.titulo" /></span>
				</h2>
			</div>
			<p class="avisobody" style="width: auto; height: auto;">
				<spring:theme code="autorizado.consultas.inicial.descripcion" />
			</p>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 headline text-center">
			<h1>
				<span><spring:theme
						code="autorizado.consultas.inicial.consultas" /></span>
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 text-center">
			<label class="control-label" style="text-transform: none; font-weight: 400 !important"><spring:theme
					code="autorizado.consultas.inicial.seccion" /></label>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12 headline">
			<h2>
				<span><spring:theme
						code="autorizado.consultas.inicial.consulestados" /></span>
			</h2>
		</div>
	</div>
	<form action="">
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="autorizado.consultas.inicial.idenvio" /></label> <input id="" name=""
						class="newalto form-control" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="autorizado.consultas.inicial.nosecuencia" /></label> <input id=""
						name="" class="newalto form-control" type="text" value="" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="autorizado.consultas.inicial.tiparchivo" /></label> <select
						class="newalto form-control">
						<option>Seleccionar</option>
					</select>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<div class="form-check form-check-inline">
						<label class="form-check-label" style="text-transform:none !important; font-weight: 400 !important; font-size: 14px !importat;"><spring:theme
								code="autorizado.consultas.inicial.tipresultado" /></label> <label
							class="form-check-label" style="text-transform:none !important; font-weight: 400 !important; font-size: 14px !importat;"> <input type="radio"
							name="tiporesultado" id="" value="" style="min-height: 0px !important; visibility: visible !important; margin-left: 20px !important;"> <spring:theme
								code="autorizado.consultas.inicial.aceptado" /></label> <label
							class="form-check-label" style="text-transform:none !important; font-weight: 400 !important; font-size: 14px !importat;"> <input type="radio"
							name="tiporesultado" id="" value="" style="min-height: 0px !important; visibility: visible !important; margin-left: 20px !important;"> <spring:theme
								code="autorizado.consultas.inicial.rechazado" /></label> <label
							class="form-check-label" style="text-transform:none !important; font-weight: 400 !important; font-size: 14px !importat;"> <input type="radio"
							name="tiporesultado" id="" value="" style="min-height: 0px !important; visibility: visible !important; margin-left: 20px !important;"> <spring:theme
								code="autorizado.consultas.inicial.pendiente" /></label>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="autorizado.consultas.inicial.fecenvio" /></label> <input id=""
						name="" class="newalto form-control" type="text" value="" maxlength="240"
						placeholder="dd/mm/aaaa">
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="autorizado.consultas.inicial.fecnoti" /></label> <input id="" name=""
						class="newalto form-control" type="text" value="" maxlength="240"
						placeholder="dd/mm/aaaa">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<button type="button" class="btn btn-secondary" id="" name=""
				value="regresar" onclick="goBack()">
				<spring:theme code="autorizado.consultas.inicial.regresar" />
			</button>
			</div>
				<div class=" col-md-2">
					<button type="button" class="btn btn-primary btn-lg" id="" name=""
						value="" onclick="window.location.href ='<c:url value='/autorizados' />';">
						<spring:theme code="autorizado.consultas.inicial.cancelar" />
					</button>
				</div>
				<div class="col-md-2">
				<button type="button" class="btn btn-primary btn-lg" id="" name=""
				value="Buscar" onclick="show()">
				<spring:theme code="autorizado.consultas.inicial.buscar" />
			</button>
			</div>
		</div>
		
	</form>



</div>
