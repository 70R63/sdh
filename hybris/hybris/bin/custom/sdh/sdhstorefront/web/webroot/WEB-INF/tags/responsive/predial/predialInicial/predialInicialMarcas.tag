<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<form:form>
		<div class="row">
			<div class="col-md-12">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="predial.inicial.marcas.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-10 d-flex align-items-center">
				<div class="table-responsive text-center">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="predial.inicial.marcas.marca" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="predial.inicial.marcas.tipmarca" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.marcas.pormarca" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.marcas.valex" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.marcas.conservacion" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value=""
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value=""
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value=""
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value=""
									maxlength="240"></td>
								<td><input id="" name="" class="inputtextnew tablefechas"
									aria-required="true" type="text" readonly="readonly" value=""
									maxlength="240"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="col-md-12 centercol-md-8 text-center">
			<button style="margin-top: 3px;" id="" class="btn btn-secondary btn-lg"
				type="button">
				<spring:theme code="predial.inicial.marcas.btnregresar" />
			</button>

			<button class="btn btn-primary btn-lg" type="submit" id="action"
				name="pagar" value="pagar">
				<spring:theme code="predial.inicial.marcas.btndescar" />
			</button>
			
			
			<button class="btn btn-primary btn-lg" type="submit" id="action"
				name="pagar" value="pagar">
				<spring:theme code="predial.inicial.marcas.generar" />
			</button>

		</div>
		</div>
	</form:form>
</div>



