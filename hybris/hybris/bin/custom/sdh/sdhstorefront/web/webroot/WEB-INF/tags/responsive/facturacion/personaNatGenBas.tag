<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<sf:form modelAttribute="dataForm">
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<tbody>
						<tr class="avisobody">
							<td><spring:theme code="facturacion.descuento1PC.inicial.nota" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	
	
		<div class="row">
		<div class="col-md-6">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="facturacion.descuento1PC.inicial.datosBasicos.titulo" /></span>
				</h2>
			</div>
		</div>
		<div class="col-md-6">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="facturacion.descuento1PC.inicial.datosGenerales.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>
	
	

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.tipoDocumento" /></label> 
					<sf:select id="tipoDocumento" path="customerData.documentType" items="${dataForm.catalogos.tipoId}" referenceData="${dataForm.catalogos.tipoId}" class="newalto form-control" disabled="true" readonly="true" ></sf:select>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.tratamiento" /></label> 
					<input id="tratamiento" name="tratamiento" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.title}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.numeroDocumento" /></label> 
					<input id="numeroDocumento" name="numeroDocumento" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.documentNumber}"/>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.fechaNacimiento" /></label> 
					<input id="fechaNacimiento" name="fechaNacimiento" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.birthDate}"/>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.primerNombre" /></label> 
					<input id="primerNombre" name="primerNombre" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.firstName}"/>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.sexo" /></label> 
					<input id="sexo" name="sexo" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.sex}"/>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.segundoNombre" /></label> 
					<input id="segundoNombre" name="segundoNombre" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.middleName}"/>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.paisOrigen" /></label> 
					<input id="paisOrigen" name="paisOrigen" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.originCountry}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.primerApellido" /></label> 
					<input id="primerApellido" name="primerApellido" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.lastName}"/>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.claseIC" /></label> 
					<input id="claseIC" name="claseIC" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.segundoApellido" /></label> 
					<input id="primerNombre" name="primerNombre" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.secondLastName}"/>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.nacionalidad" /></label> 
					<input id="nacionalidad" name="nacionalidad" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.nationality}"/>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.fechaExpedicion" /></label> 
					<input id="fechaExpedicion" name="fechaExpedicion" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.documentExpeditionDate}"/>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosBasicos.lugarNacimiento" /></label> 
					<input id="lugarNacimiento" name="lugarNacimiento" class="newalto form-control" disabled type="text" maxlength="240" value="${dataForm.customerData.birthPlace}"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-6">
				<div class="form-group">
					<button id="actualizarNombre" class="btn btn-primary btn-lg" type="button" onclick="actualizarNombre()">
						<spring:theme code="facturacion.descuento1PC.inicial.actualizarNombre" />
					</button>
				</div>
			</div>
		</div>

	</sf:form>
</div>



