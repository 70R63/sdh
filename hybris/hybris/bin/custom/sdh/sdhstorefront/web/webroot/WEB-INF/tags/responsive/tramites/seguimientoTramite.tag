<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
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
								code="tramites.seguimiento.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">
						<td><spring:theme code="tramites.seguimiento.inicial.descrip" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="headlinecol-md-12">

			<h2>
				<span class="col-md-10 "><spring:theme
						code="tramites.seguimiento.inicial.title" /></span>
			</h2>

			<div class="col-md-12">
				<label class="control-label" style="text-transform: none"><spring:theme
						code="tramites.seguimiento.inicial.desc" /></label>
			</div>
			<div class="col-md-12">
				<label class="control-label" style="text-transform: none"><spring:theme
						code="tramites.seguimiento.inicial.des" /></label>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.inicial.numcaso" /></label><input id="num_caso"
						name="" class="newalto form-control" type="text"
						maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.inicial.numrad" /></label><input id="radicado"
						name="" class="newalto form-control" type="text" value=""
						maxlength="240"></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-1">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg !important consCasoEnviar" type="button" >
					<spring:theme code="tramites.seguimiento.inicial.buscar" />
				</button>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<button style="margin-top: 3px;" id=""
						class="btn btn-secondary btn-lg" type="button" onclick="btnCancelar()">
						<spring:theme code="tramites.seguimiento.inicial.cancelar" />
					</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<div class="row" >
		<div class="col-md-12">
			<div class="table-responsive">
				<table id="tableInfo" style="display: none" class="table table-bordered">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tableident"><spring:theme
										code="tramites.seguimiento.tabla.numtramite" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="tramites.seguimiento.tabla.numrad" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="tramites.seguimiento.tabla.categ" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="tramites.seguimiento.tabla.estado" /></label></td>
						</tr>
					</thead>
					<tbody>
<!-- 						<tr> -->
<!-- 							<td><label class="control-label labeltabletd tableident" -->
<%-- 								onclick="showdetalle()"><spring:theme code="Ejemplo" /></label></td> --%>
<!-- 							<td><input class="inputtextnew tablenumiden" -->
<!-- 								disabled="disabled" type="text" size="30" value="" /></td> -->
<!-- 							<td><input class="inputtextnew tablenumiden" -->
<!-- 								disabled="disabled" type="text" size="30" value="" /></td> -->
<!-- 							<td><input class="inputtextnew tablenumiden" -->
<!-- 								disabled="disabled" type="text" size="30" value="" /></td> -->
<!-- 						</tr> -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div id="detalle" style="display: none">
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.numtam" /></label><input id="det_num_caso"
						name="" class="newalto form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.tiptramite" /></label><input id=""
 						  style="height: 25px !important; min-height: 25px !important; width: 100%; text-align: left !important; padding: 0px;"						
						name="" class="form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.numrad" /></label> <input id="det_num_radicado"
						name="" class="newalto form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.subtramite" /></label><input id=""
							style="height: 25px !important; min-height: 25px !important; width: 100%; text-align: left !important; padding: 0px;"
						name="" class="form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.estado" /></label> <input id="det_estatus"
							style="height: 25px !important; min-height: 25px !important; width: 100%; text-align: left !important; padding: 0px;"
						name="" class="form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.categoria" /></label><input id="det_tramite"
							style="height: 25px !important; min-height: 25px !important; width: 100%; text-align: left !important; padding: 0px;"
						name="" class="form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.justi" /></label> <input id=""
						name="" class="newalto form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.subcategoria" /></label><input id=""
							style="height: 25px !important; min-height: 25px !important; width: 100%; text-align: left !important; padding: 0px;"
						name="" class="form-control" type="text" value=""
						maxlength="240" disabled></input>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-12">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="tramites.seguimiento.detalle.texto" /></label>
					<textarea name="mensaje" id="mensaje" class="form-control"
						style="min-height: 120px; max-height: 400px; min-width: 100%; max-width: 100%;"
						disabled></textarea>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-12">
				<label class="control-label"><spring:theme
						code="tramites.seguimiento.detalle.docad" /></label>
				<div
					style="border: 1px solid #000; min-height: 120px; max-height: 400px; min-width: 100%; max-width: 100%; border-radius: 5px"></div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-12 text-center">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button" onclick="">
					<spring:theme code="tramites.seguimiento.detalle.menu" />
				</button>
			</div>
		</div>
	</div>
</div>



<script>
	function showtable() {
		var table = document.getElementById('tableInfo');
		table.style.display = 'block';
	}

	function showdetalle() {
		var deta = document.getElementById('detalle');
		deta.style.display = 'block';
	}
	
	function btnCancelar(){
		window.location.href = '<c:url value="/contibuyentes/tramites" />';
	}
</script>