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
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.deducciones.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>


	<form:form action="">
		<div class="row" style="margin-top: 18px">
			<div class="col-md-10">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead style="background-color: rgb(235, 235, 228)!important">
							<tr>
								<td style="width: 10px"><label
									class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.deducciones.deduccion" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="ica.declaracion.deducciones.monto" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><select id="">
										<option value=" ">&nbsp;</option>
										<option
											value="Actividad no sujeta por la porduccion Primaria Agricola">Actividad
											no sujeta por la porduccion Primaria Agricola</option>
										<option value="Enajenacion de Activo Fijos">Enajenacion
											de Activo Fijos</option>
										<option value="Exportacion de bienes">Exportacion de
											bienes</option>
										<option value="Exportacion de Servicios">Exportacion
											de Servicios</option>
										<option
											value="Actividad no sujeta Art. 39 Decreto 352 de 2002">Actividad
											no sujeta Art. 39 Decreto 352 de 2002</option>
										<option
											value="Actividades no sujetas propias de obj.soc. de prop.horiz.">Actividades
											no sujetas propias de obj.soc. de prop.horiz.</option>
										<option
											value="Explotación de los juegos de suerte y azar (Ley 643 de 2001)">Explotación
											de los juegos de suerte y azar (Ley 643 de 2001)</option>
										<option value="Donaciones">Donaciones</option>
										<option
											value="Exen.consec.de actos terroristas o catástrofes naturales">Exen.consec.de
											actos terroristas o catástrofes naturales</option>
										<option value="Base gravable especial">Base gravable
											especial</option>
										<option
											value="Ingresos por actividades realizadas a través de Consorcios">Ingresos
											por actividades realizadas a través de Consorcios</option>
										<option
											value="Dividendos que no hacen parte del giro ordinario del negocio">Dividendos
											que no hacen parte del giro ordinario del negocio</option>
										<option
											value="Exención víctima del secuestro o de la desaparición forzada">Exención
											víctima del secuestro o de la desaparición forzada</option>
										<option
											value="Corrección monetaria y/o ajustes por inflaciones">Corrección
											monetaria y/o ajustes por inflaciones</option>
										<option value="Reintegro de costos y gastos">Reintegro
											de costos y gastos</option>
										<option value="Salarios">Salarios</option>
										<option value="Devoluciones">Devoluciones</option>
										<option value="Rebajas">Rebajas</option>
										<option value="Descuentos">Descuentos</option>
								</select></td>
								<td><input class="inputtextnew" type="text" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form:form>
</div>