<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />


<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="relacion.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="relacion.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información.</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="headline">
			<h2>
				<span><spring:theme code="relacion.inicial.titulo" /></span>

			</h2>
		</div>
	</div>


	<sf:form>
		<div class="row">
			<div class="col-md-6"></div>
			<c:choose>
			<c:when test="${not empty Retenedor}">
						<div class="col-md-3" id="idImpuesto">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="relacion.inicial.selcimpuesto" /></label> <select id="impuesto"
						class="new_alto form-control " name="impuesto"
						onchange="Selected(this)">
						<option value="7">RETEICA</option>
					</select>
				</div>
			</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-3" id="idImpuesto">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="relacion.inicial.selcimpuesto" /></label> <select id="impuesto"
						class="new_alto form-control " name="impuesto"
						onchange="Selected(this)">
						<option value="0">Seleccionar</option>
						<option value="1">Predial Unificado</option>
						<option value="2">Vehículos</option>
						<option value="3">ICA</option>
						<option value="4">Publicidad Exterior</option>
						<option value="5">Sobretasa Gasolina</option>
						<option value="6">Delineación Urbana</option>
					</select>
				</div>
			</div>
			</c:otherwise>
			</c:choose>

		</div>

		<div class="row" id="idinputImpuesto" style="display: none;">
			<div class="col-md-6"></div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label text-right" id="labelSearch"></label><input
						class="newalto form-control" value=""
						type="text" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<button type="button" class="btn btn-secondary btn-lg" id="action"
						name="action" value="regresar" style="margin-top: 3px">
						<spring:theme code="relacion.inicial.regresar" />
					</button>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px">
						<spring:theme code="relacion.inicial.descargar" />
					</button>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-check">

				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="buscar" style="margin-top: 3px"
						onclick=" Selectedver(this)">
						<spring:theme code="relacion.inicial.buscar" />
					</button>

				</div>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-secondary btn-lg" id="action"
					name="action" value="cancelar" style="margin-top: 3px"
					onclick="cancelfun(this)">
					<spring:theme code="relacion.inicial.cancelar" />
				</button>

			</div>
		</div>
	</sf:form>
</div>
