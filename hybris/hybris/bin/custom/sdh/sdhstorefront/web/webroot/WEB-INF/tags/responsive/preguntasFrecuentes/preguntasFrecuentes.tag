<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container_new_page">
	<div class="row">
		<div class="col-md-12 col-md-offset-10">
			<input id="" name="" class="newalto form-control" disabled
				type="text" value=" ${preguntasForm.fecha}" maxlength="240"
				style="background: #fff; border: 0px;"></input>

		</div>
	</div>



	<div class="row">
		<div class="col-md-12 col-md-offset-5 headline">
			<h2>
				<span><spring:theme code="preguntas.frecuentes.title" /></span>
			</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3 col-xs-12 mb-20 no-marginleft Catego"
			id="categoria">
			<span class="paso--tres pasos color-sr3 rajdhani">1</span>
			<h2 class="titulo-caja--ser-rel color-sr3 paso3">Categoría</h2>
			<p class="pasoClase3 metrophobic" style="margin-bottom: 0px">Selecciona la categoría.</p>
			<div class="caja--ser-rel color-sr3">
				<select id="categoriaBuscar" class="new_alto form-control "
					name="categoria">
					<option value="00">Seleccionar</option>
					<option value="01">Impuesto Predial</option>
					<option value="02">Dudores morosos</option>
					<option value="03">Vehicular</option>
					<option value="04">Medios mágneticos</option>
				</select> <br>
				<button class="btn btn-primary" onclick="showquestion()">Buscar</button>
			</div>
		</div>

		<div class="col-md-7 col-xs-12 mb-20 no-marginleft" id="PregPredial"
			style="margin-left: 50px; display: none; margin-top: 50px">
			<div class="preguntas">
				<hr>
				<div class="preguntas_body">
					<p class="pregunta">
						<span><spring:theme code="¿Cuándo puedo pagar mi predial?" /></span>
					</p>
					<p class="respuesta">El predial se puede pagar cada inicio de
						año</p>

					<!-- 					<div class="botones text-right"> -->
					<!-- 						<a href="#">Responder</a> <a href="#">Editar</a> <a href="#">Borrar</a> -->
					<!-- 					</div> -->

				</div>
				<hr>
				<div class="preguntas_body">
					<p class="pregunta">
						<span><spring:theme code="¿Cuándo puedo pagar mi predial?" /></span>
					</p>
					<p class="respuesta">El predial se puede pagar cada inicio de
						año</p>

					<!-- 					<div class="botones text-right"> -->
					<!-- 						<a href="#">Responder</a> <a href="#">Editar</a> <a href="#">Borrar</a> -->
					<!-- 					</div> -->

				</div>
			</div>
		</div>
	</div>

	<script>
		function showquestion() {
			debugger;
			var cate = document.getElementById('categoriaBuscar').value;
			var pred = document.getElementById('PregPredial');

			if (cate == "01") {
				pred.style.display = 'block';
			} else {
				pred.style.display = 'none';
			}
		}
	</script>