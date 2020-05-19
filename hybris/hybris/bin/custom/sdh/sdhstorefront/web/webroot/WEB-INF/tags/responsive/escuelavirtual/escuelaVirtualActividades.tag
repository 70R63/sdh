
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>

<spring:htmlEscape defaultHtmlEscape="true" />


<div class="container_new_page">
	<div class="jumbotron">
		<div class="container">
			<h2 class="display-3 mb-3 newtitle">
				<spring:theme code="Escuela Virtual" />
			</h2>
			<p class="mb-4">
				<spring:theme
					code="En esta secci�n podr�s mantenerte al d�a con cursos y videos que te ayuden a mejorar tu trabajo del d�a a d�a. etc etc.........." />
			</p>
		</div>
	</div>

	<div class="row">
		<div class="trespasos">
			<div class="container">
				<div class="col-md-4 text-center">
					<h2 class="trespasos_title">
						<spring:theme code="Nuevo" />
						<br>
						<spring:theme code="Contenido" />
					</h2>
				</div>
				<div class="col-md-4 text-center">
					<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
						class="card-img-top img-fluid">
					<h3 class="card-title">�C�mo tratar a los usuario?</h3>
					<p class="card-text">La parte m�s importante de nuestro d�a a
						d�i como funcionarios p�blicos, es el trato hacia los usuarios,
						por lo que te dejamos una Gu�a con los principales puntos a
						tratar.</p>
					<button class="btn btn-primary btn-block" onclick="downloadPDF()">Descargar
						Gu�a</button>
				</div>
				<div class="col-md-4 text-center">
					<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
						class="card-img-top img-fluid">

					<h3 class="card-title">C�mo aplicar el descuento para
						Veh�culos</h3>
					<p class="card-text">Aqu� podr�s conocer como aplicar el
						descuento para veh�culos y en que ocaciones aplica</p>
					<a target="_blank" href="http://www.shd.gov.co/shd/"
						class="btn btn-success btn-block">Ir al post</a>
				</div>

			</div>
		</div>
	</div>


	<div class="row my-3">

		<div class="card-columns">

			<div class="card_esc">
				<h3 class="center card-title">
					<spring:theme code="Bogot� Digital" />
				</h3>
				<iframe width="100%" height="315"
					src="https://www.youtube.com/embed/T-LaaNiXqb0" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
				<div class="card-body">
					<p class="card-text">En este video podr�s conocer lo que se
						esta planenado en la Secretar�a de Hacienda Bogot�</p>
					<!-- 						<button class="btn btn-primary btn-block">Boton</button> -->
				</div>
			</div>

			<div class="card_esc">
				<img src="${themeResourcePath}/images/contribuyentes_1.jpg"
					class="card-img-top img-fluid">
				<div class="card-body">
					<h3 class="card-title">C�mo aplicar el descuento para
						Veh�culos</h3>
					<p class="card-text">Aqu� podr�s conocer como aplicar el
						descuento para veh�culos y en que ocaciones aplica</p>
					<a target="_blank" href="http://www.shd.gov.co/shd/"
						class="btn btn-success btn-block">Ir al post</a>
				</div>
			</div>

			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">�Qu� es ICA?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realizaci�n directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicci�n del Distrito Capital de Bogot�, ya sea que se cumplan
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
					<h3 class="card-title">�C�mo tratar a los usuario?</h3>
					<p class="card-text">La parte m�s importante de nuestro d�a a
						d�i como funcionarios p�blicos, es el trato hacia los usuarios,
						por lo que te dejamos una Gu�a con los principales puntos a
						tratar.</p>
					<button class="btn btn-primary btn-block" onclick="downloadPDF()">Descargar
						Gu�a</button>
				</div>
			</div>

			<div class="card_esc">
				<div class="card-body">
					<h3 class="card-title">�Qu� es ICA?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realizaci�n directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicci�n del Distrito Capital de Bogot�, ya sea que se cumplan
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
					<h3 class="card-title">�C�mo hablar en p�blico?</h3>
					<p class="card-text">El impuesto de Industria y Comercio se
						genera por el ejercicio o realizaci�n directa o indirecta de
						cualquier actividad industrial, comercial o de servicios en
						jurisdicci�n del Distrito Capital de Bogot�, ya sea que se cumplan
						de forma permanente u ocasional, en inmueble determinado, con
						establecimiento de comercio o sin ellos.</p>
				</div>
				<a target="_blank"
					href="http://www.amamex.org.mx/comunicacion/2199_curso_como_causar_un_alto_impacto_en_su_audiencia.html"
					class="btn btn-success btn-block">Ir al post</a>
			</div>

		</div>
	</div>

	<div class="row">
		<div class="noticias text-center">
			<div class="row">
				<div class="col-md-4 recom1">
					<h1 class="title_not">Noticias de Inter�s</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="noticia">
						<h1 class="">Cursos</h1>
						<div class="contenido">
							<p>Se impartira un curso de Inteligencia Emocional el 27 de
								diciembre de 2080</p>
						</div>
							<div class="row">
							<div class="redes text-center">
								<hr
									style="border-top: 2px dashed #fff !important; background-color: transparent !important;">
								<p class="foot-esc">Para m�s informaci�n visita nuestras
									redes sociales</p>

								<a class="follow-us-Facebook icon"
									href="https://es-la.facebook.com/HaciendaBogota" onclick=""
									title="Facebook" target="_blank"> <span
									class="visuallyhidden">Facebook</span></a> <a
									class="follow-us-Twitter icon" target="_blank" id="twitter"
									href="https://twitter.com/HaciendaBogota" onclick=""
									title="twitter"><span class="visuallyhidden">twitter</span></a>

							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="noticia">
						<h1 class="">Cursos</h1>
						<div class="contenido">
							<p>Se impartira un curso de Inteligencia Emocional el 27 de
								diciembre de 2080</p>
						</div>
							<div class="row">
							<div class="redes text-center">
								<hr
									style="border-top: 2px dashed #fff !important; background-color: transparent !important;">
								<p class="foot-esc">Para m�s informaci�n visita nuestras
									redes sociales</p>

								<a class="follow-us-Facebook icon"
									href="https://es-la.facebook.com/HaciendaBogota" onclick=""
									title="Facebook" target="_blank"> <span
									class="visuallyhidden">Facebook</span></a> <a
									class="follow-us-Twitter icon" target="_blank" id="twitter"
									href="https://twitter.com/HaciendaBogota" onclick=""
									title="twitter"><span class="visuallyhidden">twitter</span></a>

							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="noticia">
						<h1 class="">Cursos</h1>
						<div class="contenido">
							<p>Se impartir� un curso de Inteligencia Emocional el 27 de
								diciembre de 2080</p>

						</div>

						<div class="row">
							<div class="redes text-center">
								<hr
									style="border-top: 2px dashed #fff !important; background-color: transparent !important;">
								<p class="foot-esc">Para m�s informaci�n visita nuestras
									redes sociales</p>

								<a class="follow-us-Facebook icon"
									href="https://es-la.facebook.com/HaciendaBogota" onclick=""
									title="Facebook" target="_blank"> <span
									class="visuallyhidden">Facebook</span></a> <a
									class="follow-us-Twitter icon" target="_blank" id="twitter"
									href="https://twitter.com/HaciendaBogota" onclick=""
									title="twitter"><span class="visuallyhidden">twitter</span></a>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<br>
<br>
<br>

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
		const fileName = "Gu�a_trato_usuarios.pdf";

		downloadLink.href = linkSource;
		downloadLink.download = fileName;
		downloadLink.click();

	}
	downloadPDF('${miRitCertificacionForm.rit.stringRIT}')
</script>


