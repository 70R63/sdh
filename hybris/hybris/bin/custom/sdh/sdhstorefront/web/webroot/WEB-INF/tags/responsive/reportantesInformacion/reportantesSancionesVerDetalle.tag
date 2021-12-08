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
		<div class="col-md-6">
			<table class="table border">
				<thead style="cellspacing: 10 !important">
					<tr>
						<th style="text-align: center"></th>
						<th style="text-align: center"><label class="control-label"
							for=""> <spring:theme
									code="Objeto de la sanción" /></label></th>
						<th style="text-align: center"><label class="control-label "
							for=""><spring:theme
									code="Sanción persuasiva" /></label></th>
					</tr>
				</thead>
				<tbody>

					<tr>

						<td style="text-align: center !important"><label class="form-check-label" style="text-transform: capitalize">
							<input type="checkbox" name="" id=""
							class="form-check-input mr-2"
							style="visibility: visible !important; min-height: 4px !important; margin-left: 12px">
							<spring:theme code="" />
						</label></td>
						<td></td>
						<td
							style="text-align: center !important; color: #0358d8 !important"><label
							class="control-label" for=""
							style="text-align: center !important; color: #0358d8 !important" onclick="showLiquidador()">
								<spring:theme code="Liquidador" />
						</label></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

