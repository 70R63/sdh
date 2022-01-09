<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme
						code="sobre.vehiculo.declaracion.vehiculo.info.title" /></span>
			</h2>
		</div>
	</div>



	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.objcontra" /></label><input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.placa}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
	
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.clase" /></label> <input
						name="numresol" class="newalto form-control td_clase"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.clase}"
						maxlength="30" disabled="disabled">
						<input id="clase td_clase" type="hidden" value="${vehiculosFormDeclaracion.clase}"/>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.carroceria" /></label> <input
						name="numresol" class="newalto form-control td_carroceria"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.carroceria}"
						maxlength="30" disabled="disabled">
						<input class="td_carroceria" id="carroceria" type="hidden" value="${vehiculosFormDeclaracion.carroceria}"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.marca" /></label> <input
						id="marca_descripcion" name="numresol" class="newalto form-control td_marca"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.marca}"
						maxlength="30" disabled="disabled">
						<input class="td_marca" id="marca" type="hidden" value="${vehiculosFormDeclaracion.marca}"/>
				</div>
			</div>
		
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.tipvehi" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value='<spring:theme code="vehiculos.detalle.tipoVeh.${vehiculosFormDeclaracion.tipoVeh}"/>'
						maxlength="30" disabled="disabled">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.modelo" /></label> <input
						id="modelo" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.modelo}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
	
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.blindado" /></label> <input
						id="blindado" name="blindado" class="newalto form-control td_blindado"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.blindado}"
						maxlength="30" disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.clasant" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value='<spring:theme code="vehiculos.detalle.clasicoAntig.${vehiculosFormDeclaracion.clasicoAntig}"/>'
						maxlength="30" disabled="disabled">
				</div>
			</div>
		

			</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.idservicio" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value='<spring:theme code="vehiculos.detalle.idServicio.${vehiculosFormDeclaracion.idServicio}"/>'
						maxlength="30" disabled="disabled">
				</div>
			</div>
		
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.fecfactura" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.info.watts" /></label> <input
						id="numresol" name="numresol" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.watts}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
		</div>
		<!-- 		<div class="row"> -->
		<!-- 			<div class="col-md-3"> -->
		<!-- 				<div class="form-group"> -->
		<%-- 					<label class="control-label"><spring:theme --%>
		<%-- 							code="sobre.vehiculo.declaracion.vehiculo.liq.clasdh" /></label> <input --%>
		<!-- 						id="" name="" class="newalto form-control" aria-required="true" -->
		<!-- 						type="text" value="" maxlength="30" disabled="disabled"> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 			<div class="col-md-3"> -->
		<!-- 				<div class="form-group"> -->
		<%-- 					<label class="control-label"><spring:theme --%>
		<%-- 							code="sobre.vehiculo.declaracion.vehiculo.liq.linhomo" /></label> <input --%>
		<!-- 						id="" name="" class="newalto form-control" aria-required="true" -->
		<!-- 						type="text" value="" maxlength="30" disabled="disabled"> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
		<!-- 		<div class="row"> -->
		<!-- 			<div class="col-md-3"> -->
		<!-- 				<div class="form-group"> -->
		<%-- 					<label class="control-label"><spring:theme --%>
		<%-- 							code="sobre.vehiculo.declaracion.vehiculo.liq.tipvesdh" /></label> <input --%>
		<!-- 						id="" name="" class="newalto form-control" aria-required="true" -->
		<!-- 						type="text" value="" maxlength="30" disabled="disabled"> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 			<div class="col-md-3"> -->
		<!-- 				<div class="form-group"> -->
		<%-- 					<label class="control-label"><spring:theme --%>
		<%-- 							code="sobre.vehiculo.declaracion.vehiculo.liq.fuenhomo" /></label> <input --%>
		<!-- 						id="" name="" class="newalto form-control" aria-required="true" -->
		<!-- 						type="text" value="" maxlength="30" disabled> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
	</form:form>
</div>

