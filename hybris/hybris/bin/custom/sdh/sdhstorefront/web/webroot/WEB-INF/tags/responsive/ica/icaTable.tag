<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="avisoheadline">
			<h3>
				<span class="p"><spring:theme code="ica.table.title"
						text="Publicidad Exterior" /></span>
			</h3>
		</div>
		<p class="avisobody">
			<spring:theme code="ica.table.descripcionp1" />
		</p>
	</div>

	<br>

	<div class="row">
		<br>
		<div class="row">
			<div class="table-responsive">
				<table class="table col-md-2 table-bordered" id="example">
					<thead>
						<tr>
							<th><label class="control-label " for=""><spring:theme
										code="ica.table.tipdc" /></label></th>
							<th><label class="control-label " for=""> <spring:theme
										code="ica.table.nodoc" /></label></th>
							<th><label class="control-label " for=""> <spring:theme
										code="ica.table.selec" /></label></th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td><c:out value=""></c:out></td>
							<td><c:out value=""></c:out></td>
							<td><input id="action"
								style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" type="radio"></td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="col-md-offset-3">
			<div class="row">
				<div class="col-md-4">
					<button class="btn btn-primary btn-block" type="button">
						<spring:theme code="ica.table.descfac" />
					</button>
				</div>
				<div class="col-md-4">
					<button class="btn btn-primary btn-block" type="button">
						<spring:theme code="ica.table.predec" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<button class="btn btn-primary btn-block" type="button">
						<spring:theme code="ica.table.reexfact" />
					</button>
				</div>
				<div class="col-md-4">
					<button class="btn btn-primary btn-block" type="button">
						<spring:theme code="ica.table.pse" />
					</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<button class="btn btn-primary btn-block" type="button">
						<spring:theme code="ica.table.rop" />
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="headline">
			<h2>
				<span class="col-md-10 "><spring:theme
						code="ica.table.detalle" /></span>
			</h2>
		</div>
	</div>
	<div class="row">

		<div class="col-md-4">
			<div class="form-group">

				<label class="control-label"><spring:theme
						code="ica.table.selecanio" /></label> <select id="" name=""
					class="form-control">
					<option>Seleccionar</option>
					<option>2019</option>
					<option>2018</option>
					<option>2017</option>
					<option>2016</option>
				</select>
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">

				<label class="control-label"><spring:theme
						code="ica.table.selecper" /></label> <select id="" name=""
					class="form-control">
					<option value="">Seleccionar</option>
					<option value="1">1. Ene / Feb</option>
					<option value="2">2. Mar / Abr</option>
					<option value="3">3. May / Jun</option>
					<option value="4">4. Jul / Ago</option>
					<option value="5">5. Sep / Oct</option>
					<option value="6">6. Nov / Dic</option>
				</select>
			</div>
		</div>
		<div class="col-md-2">
			<button class="btn btn-primary btn-block" type="button"
				onclick="myFunction()">
				<spring:theme code="ica.table.buscar" />
			</button>
		</div>
	</div>
</div>



