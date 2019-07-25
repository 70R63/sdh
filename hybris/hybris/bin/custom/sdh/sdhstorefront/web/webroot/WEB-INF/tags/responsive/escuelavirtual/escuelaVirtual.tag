
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />


<style>
.jumbotron {
	background: #960505;
	font-color: #ffffff !important;
}

.trespasos {
	background: #fbd7bf !important;
	padding: 5px 5px;
}


.jumbotron p {
	font-size: 20px;
	font-weight: 300;
	color: #fff;
}

.newtitle {
	color: #fff;
}

.card_esc {
	border: 1px solid #156ab5 !important;
	background: none;
	font-size: 14 px !important;
	padding: 2px 7px;
	margin-bottom: 5px !important;
	display: inline-block;
	width: 100%;
	margin-right: 5px !important;
}

.center {
	text-align: center;
}

.card-img-top {
	width: 100%;
	height: 315;
}

.card-title:hover {
	background: #5a0741;
	color: #fff;
}

.download-link {
	text-decoration: none;
	border: 1px solid #ccc;
	padding: .5em;
	font-family: Helvetica;
	color: #c00;
	display: block;
	text-align: center;
	margin: 1em 0;
}

.card-columns {
	-webkit-column-count: 2;
	-moz-column-count: 2;
	column-count: 2;
	-webkit-column-gap: 1.25rem;
	-moz-column-gap: 1.25rem;
	column-gap: 1.25rem;
	orphans: 1;
	widows: 1;
}
.trespasos_title{
font-size: 48px;
font-weight: 800;

}
</style>


<div class="container_new_page">

	<div class="jumbotron">
		<div class="container">
			<h2 class="display-3 mb-3 newtitle">
				<spring:theme code="Escuela Virtual" />
			</h2>
			<p class="mb-4">
				<spring:theme
					code="En esta sección podrás mantenerte al día con cursos y videos que te ayuden a mejorar tu trabajo del día a día. etc etc.........." />
			</p>

			<!-- 			<div class=""> -->
			<!-- 				<a href="#" class="btn btn-success">Más información</a> -->
			<!-- 			</div> -->
		</div>
	</div>


	<div class="row my-3">

		<div class="card-columns">

			<div class="card_esc">
				<h3 class="center card-title">
					<spring:theme code="Bogotá Digital" />
				</h3>
				<iframe width="100%" height="315"
					src="https://www.youtube.com/embed/T-LaaNiXqb0" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
				<div class="card-body">
					<p class="card-text">En este video podrás conocer lo que se
						esta planenado en la Secretaría de Hacienda Bogotá</p>
					<!-- 						<button class="btn btn-primary btn-block">Boton</button> -->
				</div>
			</div>

			<div class="card_esc">
				<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
					class="card-img-top img-fluid">
				<div class="card-body">
					<h3 class="card-title">Cómo aplicar el descuento para
						Vehículos</h3>
					<p class="card-text">Aquí podrás conocer como aplicar el
						descuento para vehículos y en que ocaciones aplica</p>
					<a target="_blank" href="http://www.shd.gov.co/shd/"
						class="btn btn-success btn-block">Ir al post</a>
				</div>
			</div>

			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">¿Qué es ICA?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realización directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicción del Distrito Capital de Bogotá, ya sea que se cumplan
						de forma permanente u ocasional, en inmueble determinado, con
						establecimiento de comercio o sin ellos.</p>
				</div>
				<iframe width="100%" height="315"
					src="https://www.youtube.com/embed/ThgRwuLGIdw" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>

			<div class="card_esc">
				<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
					class="card-img-top img-fluid">
				<div class="card-body">
					<h3 class="card-title">¿Cómo tratar a los usuario?</h3>
					<p class="card-text">La parte más importante de nuestro día a
						dái como funcionarios públicos, es el trato hacia los usuarios,
						por lo que te dejamos una Guía con los principales puntos a
						tratar.</p>
					<button class="btn btn-primary btn-block" onclick="downloadPDF()">Descargar
						Guía</button>
				</div>
			</div>

			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">¿Qué es ICA?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realización directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicción del Distrito Capital de Bogotá, ya sea que se cumplan
						de forma permanente u ocasional, en inmueble determinado, con
						establecimiento de comercio o sin ellos.</p>
				</div>
				<iframe width="100%" height="315"
					src="https://www.youtube.com/embed/ThgRwuLGIdw" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">¿Cómo hablar en público?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realización directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicción del Distrito Capital de Bogotá, ya sea que se cumplan
						de forma permanente u ocasional, en inmueble determinado, con
						establecimiento de comercio o sin ellos.</p>
				</div>
				<a target="_blank"
					href="http://www.amamex.org.mx/comunicacion/2199_curso_como_causar_un_alto_impacto_en_su_audiencia.html"
					class="btn btn-success btn-block">Ir al post</a>
			</div>

		</div>
	</div>

	<div class="trespasos">
		<div class="container">
		<div class="col-md-4 text-center">
			<h2 class="trespasos_title">
				<spring:theme code="Nuevo" /><br><spring:theme code="Contenido" />
			</h2>
			</div>
			<div class="col-md-4 text-center">
			<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
					class="card-img-top img-fluid">
			<h3 class="card-title">¿Cómo tratar a los usuario?</h3>
					<p class="card-text">La parte más importante de nuestro día a
						dái como funcionarios públicos, es el trato hacia los usuarios,
						por lo que te dejamos una Guía con los principales puntos a
						tratar.</p>
					<button class="btn btn-primary btn-block" onclick="downloadPDF()">Descargar
						Guía</button>
			</div>
			<div class="col-md-4 text-center">
			<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
					class="card-img-top img-fluid">
				
					<h3 class="card-title">Cómo aplicar el descuento para
						Vehículos</h3>
					<p class="card-text">Aquí podrás conocer como aplicar el
						descuento para vehículos y en que ocaciones aplica</p>
					<a target="_blank" href="http://www.shd.gov.co/shd/"
						class="btn btn-success btn-block">Ir al post</a>
			</div>
			
		</div>
	</div>
	<div class="card-columns">

			<div class="card_esc">
				<h3 class="center card-title">
					<spring:theme code="Bogotá Digital" />
				</h3>
				<iframe width="100%" height="315"
					src="https://www.youtube.com/embed/T-LaaNiXqb0" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
				<div class="card-body">
					<p class="card-text">En este video podrás conocer lo que se
						esta planenado en la Secretaría de Hacienda Bogotá</p>
					<!-- 						<button class="btn btn-primary btn-block">Boton</button> -->
				</div>
			</div>

			<div class="card_esc">
				<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
					class="card-img-top img-fluid">
				<div class="card-body">
					<h3 class="card-title">Cómo aplicar el descuento para
						Vehículos</h3>
					<p class="card-text">Aquí podrás conocer como aplicar el
						descuento para vehículos y en que ocaciones aplica</p>
					<a target="_blank" href="http://www.shd.gov.co/shd/"
						class="btn btn-success btn-block">Ir al post</a>
				</div>
			</div>

			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">¿Qué es ICA?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realización directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicción del Distrito Capital de Bogotá, ya sea que se cumplan
						de forma permanente u ocasional, en inmueble determinado, con
						establecimiento de comercio o sin ellos.</p>
				</div>
				<iframe width="100%" height="315"
					src="https://www.youtube.com/embed/ThgRwuLGIdw" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>

			<div class="card_esc">
				<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
					class="card-img-top img-fluid">
				<div class="card-body">
					<h3 class="card-title">¿Cómo tratar a los usuario?</h3>
					<p class="card-text">La parte más importante de nuestro día a
						dái como funcionarios públicos, es el trato hacia los usuarios,
						por lo que te dejamos una Guía con los principales puntos a
						tratar.</p>
					<button class="btn btn-primary btn-block" onclick="downloadPDF()">Descargar
						Guía</button>
				</div>
			</div>

			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">¿Qué es ICA?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realización directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicción del Distrito Capital de Bogotá, ya sea que se cumplan
						de forma permanente u ocasional, en inmueble determinado, con
						establecimiento de comercio o sin ellos.</p>
				</div>
				<iframe width="100%" height="315"
					src="https://www.youtube.com/embed/ThgRwuLGIdw" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">¿Cómo hablar en público?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realización directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicción del Distrito Capital de Bogotá, ya sea que se cumplan
						de forma permanente u ocasional, en inmueble determinado, con
						establecimiento de comercio o sin ellos.</p>
				</div>
				<a target="_blank"
					href="http://www.amamex.org.mx/comunicacion/2199_curso_como_causar_un_alto_impacto_en_su_audiencia.html"
					class="btn btn-success btn-block">Ir al post</a>
			</div>

		</div>

</div>




<div id="pdfRenderer"></div>

<script>
	$(function() {
		function downloadLink(id) {
			var ajaxOptions = {
				url : 'http://httpbin.org/status/' + id
			};

			var res = $.ajax(ajaxOptions);

			function onAjaxDone(data) {

				location.href = 'http://httpbin.org/bytes/1024';
			}

			function onAjaxFail() {
				alert('Bad ID');
			}

			res.done(onAjaxDone).fail(onAjaxFail);
		}

		function onDownloadLinkClick(e) {
			e.preventDefault();
			var $this = $(this);
			var id = $this.data('id');
			downloadLink(id);
		}

		$('.download-link').on('click', onDownloadLinkClick);
	});

	function downloadPDF() {

		const linkSource = '${themeResourcePath}/pdf/Factsheet-Mobile-Module-EN.pdf';
		const downloadLink = document.createElement("a");
		const fileName = "Guía_trato_usuarios.pdf";

		downloadLink.href = linkSource;
		downloadLink.download = fileName;
		downloadLink.click();

	}
	downloadPDF('${miRitCertificacionForm.rit.stringRIT}')
</script>

