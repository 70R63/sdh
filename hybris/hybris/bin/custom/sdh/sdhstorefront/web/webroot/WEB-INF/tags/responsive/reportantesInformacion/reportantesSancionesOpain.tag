<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />


<div class="container">
	<br>
	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />

	<div class="row">
		<div class="col-md-12">
			<table class="table border">
				<thead style="cellspacing: 10 !important">
					<tr>
						<th style="text-align: center"><label class="control-label"
							for=""> <spring:theme
									code="representantes.info.sanciones.opain.objeto" /></label></th>
						<th style="text-align: center"><label class="control-label"
							for=""> <spring:theme
									code="representantes.info.sanciones.opain.valor" /></label></th>
						<th style="text-align: center"><label class="control-label "
							for=""><spring:theme
									code="representantes.info.sanciones.opain.visualizar" /></label></th>
					</tr>
				</thead>
				<tbody>

					<tr>

						<td style="text-align: center !important"><span><spring:theme
									code="representantes.info.historico.opain.resolucion" /></span>
							<p>
								<spring:theme
									code="representantes.info.historico.opain.articulo1" /></td>
						<td style="width: 416px !important;"><input type="text"
							class="form-control" id="exampleFormControlFile1" disabled></td>
						<td
							style="text-align: center !important; color: #0358d8 !important"><label
							class="control-label" for=""
							style="text-align: center !important; color: #0358d8 !important">
								<spring:theme code="representantes.info.sanciones.opain.ver" />
						</label></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
