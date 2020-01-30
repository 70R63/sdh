<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="predial.inicial.table.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="predial.inicial.table.descripcion" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<form:form>
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="predial.inicial.table.buscar" /></label> <input id="" name=""
						class="newalto form-control" disabled type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-10 d-flex align-items-center">
				<div class="table-responsive">
					<table class="table" id="example">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="predial.inicial.table.chip" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="predial.inicial.table.matinmo" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.table.dir" /></label></td>
								<td><label class="control-label labeltabletd "><spring:theme
											code="predial.inicial.table.nocotrato" /></label></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${predial}" var="current">
								<tr>
									<td><c:out value="${current.CHIP}" /></td>
									<td><c:out value="${current.matrInmobiliaria}" /></td>
									<td></td>
									<td><c:out value="${current.contratoArrenda}" /></td>
									<td><label style="color: #0358d8 !important"
										class="text-capitalize !important" onclick="mostrar()">
											<spring:theme code="predial.inicial.table.ver" />
									</label></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</form:form>
</div>

<script>
	function datatable(e) {
		debugger;
		if ($.fn.dataTable.isDataTable('#example')) {
			table = $('#example').DataTable();
			table.destroy();
		}
		var tabla = $("#example")
				.DataTable(
						{
							"sPaginationType" : "full_numbers",
							"oLanguage" : {
								"oPaginate" : {
									"sPrevious" : " Anterior ",
									"sNext" : " Siguiente ",
									"sLast" : " Última ",
									"sFirst" : " Primera "
								},
								"sLengthMenu" : 'Mostrar <select>'

								+ '<option value="10">10</option>'
										+ '<option value="20">20</option>'
										+ '<option value="30">30</option>'
										+ '</select> registros',
								"sInfo" : "Mostrando _START_ al _END_ de _TOTAL_ registros",
								"sInfoFiltered" : " Filtrados de MAX registros",
								"sInfoEmpty" : " ",
								"sZeroRecords" : "No se encontraron registros",
								"sProcessing" : "Espere, por favor...",
								"sSearch" : "Buscar:",
							}
						});
	}
</script>


