<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="facturacion.descuento1PC.inicial.datosContacto.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.dirNotificacion" /></label> 
				<input id="dirNotificacion" name="dirNotificacion" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.otraDirContacto" /></label> 
				<input id="otraDirContacto" name="otraDirContacto" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.telFijo" /></label> 
				<input id="telFijo" name="telFijo" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.telExtension" /></label> 
				<input id="telExtension" name="telExtension" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.telCelular" /></label> 
				<input id="telCelular" name="telCelular" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.redSocial" /></label> 
				<select id="redSocial" name="redSocial" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.usuarioRedSocial" /></label> 
				<input id="usuarioRedSocial" name="usuarioRedSocial" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<tbody>
					<tr class="avisobody">
						<td><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.nota1" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.pais" /></label> 
				<select id="pais" name="pais" class="newalto form-control" disabled ></select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.tipoDireccion" /></label> 
				<select id="tipoDireccion" name="tipoDireccion" class="newalto form-control" disabled ></select>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.departamento" /></label> 
				<select id="departamento" name="departamento" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.municipio" /></label> 
				<select id="departamento" name="departamento" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.codigoPostal" /></label> 
				<select id="codigoPostal" name="codigoPostal" class="newalto form-control" disabled ></select>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-2">
			<div class="form-group">
				<select id="" name="" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<input id="" name="" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<select id="" name="" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<select id="" name="" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<select id="" name="" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<select id="" name="" class="newalto form-control" disabled ></select>#
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<input id="" name="" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label"><spring:theme code="facturacion.descuento1PC.inicial.datosContacto.nota2" /></label> 
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<select id="departamento" name="departamento" class="newalto form-control" disabled ></select>#
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<input id="" name="" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<select id="codigoPostal" name="codigoPostal" class="newalto form-control" disabled ></select>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<select id="departamento" name="departamento" class="newalto form-control" disabled ></select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<input id="" name="" class="newalto form-control" disabled type="text" maxlength="240" value=""/>
			</div>
		</div>
	</div>

	
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-6">
			<div class="form-group">
				<button id="aceptar" class="btn btn-primary btn-lg" type="button" onclick="aceptar()">
					<spring:theme code="facturacion.descuento1PC.inicial.datosContacto.aceptar" />
				</button>
				<button id="agregarOtraDir" class="btn btn-primary btn-lg" type="button" onclick="agregarOtraDir()">
					<spring:theme code="facturacion.descuento1PC.inicial.datosContacto.agregarOtraDir" />
				</button>
			</div>
		</div>
	</div>

</div>



