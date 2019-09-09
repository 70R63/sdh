<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="predial.unificado.table.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="predial.unificado.table.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>



<sf:form>
	<br>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.chip" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.matinmobi" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.factura" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.tipdirec" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.direcpred" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.codpostal" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.codLocalidad" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.estpredio" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.nomconarren" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.fecinactiva" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code="predial.unificado.table.indicador" /></label></th>
						<th><label class="control-label labeltabletd"><spring:theme
									code=" " /></label></th>

					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="chip"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="matInmobi"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="factura"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="Tipdireccion"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="Direccion"></c:out>"
							maxlength="240" style="width: 150px !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="CodPostal"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="Localidad"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="Estatus"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="Arrendamiento"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="FecInac"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="text"
							readonly="readonly" value="<c:out value="Indcador"></c:out>"
							maxlength="240" style="width: 100% !important;"></td>
						<td><input id="" name="" class="inputtextnew" type="submit"
							value="<c:out value="Ver detalle"></c:out>" maxlength="240"
							style="width: 100% !important;"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</sf:form>


