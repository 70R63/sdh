
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />


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
	</div>
	<div class="row">
		<div class="noticias">
			<div class="row">
				<div class="col-md-4 recom1">
					<h1 class="title_not">Noticias de Interés</h1>
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
					</div>
				</div>
				<div class="col-md-4">
					<div class="noticia">
						<h1 class="">Cursos</h1>
						<div class="contenido">
							<p>Se impartira un curso de Inteligencia Emocional el 27 de
								diciembre de 2080</p>
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
					</div>
					<div class="row">
						<div class="field-content buttons redes_sociales">
							<span class="a2a_kit a2a_kit_size_32 addtoany_list"
								data-a2a-url="https://bogota.gov.co/mi-ciudad/educacion/enrique-penalosa-entrego-jardin-infantil-el-nogal-de-la-esperanza"
								data-a2a-title="¿Un jardín infantil artístico? ¡Sí! Listo y entregado en Barrios Unidos"
								style="line-height: 32px;"><a class="a2a_button_facebook"
								role="button" title="Comparte en Facebook"
								aria-label="Comparte en Facebook" target="_blank"
								href="https://www.addtoany.com/add_to/facebook?linkurl=https%3A%2F%2Fbogota.gov.co%2Fmi-ciudad%2Feducacion%2Fenrique-penalosa-entrego-jardin-infantil-el-nogal-de-la-esperanza&amp;linkname=%C2%BFUn%20jard%C3%ADn%20infantil%20art%C3%ADstico%3F%20%C2%A1S%C3%AD!%20Listo%20y%20entregado%20en%20Barrios%20Unidos&amp;linknote="
								rel="nofollow noopener"><svg class="redes-bogotema"
										enable-background="new 0 0 32 32" version="1.1"
										viewBox="0 0 32 32" xml:space="preserve"
										xmlns="http://www.w3.org/2000/svg">
								<g>
								<path class="redes-bogotema"
											d="M13.892,24.123h3.357v-8.124h2.239l0.297-2.799h-2.536l0.003-1.402c0-0.73,0.07-1.121,1.117-1.121h1.4v-2.8 h-2.24c-2.69,0-3.637,1.358-3.637,3.642V13.2h-1.677V16h1.677V24.123z"
											fill="#414752"></path>
								<g>
								<g>
								<g>
								<g>
								<g>
								<g>
								<path class="redes-bogotema"
											d="M16,1c8.271,0,15,6.729,15,15s-6.729,15-15,15S1,24.271,1,16S7.729,1,16,1 M16,0 C7.163,0,0,7.163,0,16s7.163,16,16,16s16-7.163,16-16S24.837,0,16,0L16,0z"
											fill="#414752"></path></g></g></g></g></g></g></g></svg></a><a class="a2a_button_twitter"
								role="button" title="Comparte en Twitter"
								aria-label="Comparte en Twitter" target="_blank"
								href="https://www.addtoany.com/add_to/twitter?linkurl=https%3A%2F%2Fbogota.gov.co%2Fmi-ciudad%2Feducacion%2Fenrique-penalosa-entrego-jardin-infantil-el-nogal-de-la-esperanza&amp;linkname=%C2%BFUn%20jard%C3%ADn%20infantil%20art%C3%ADstico%3F%20%C2%A1S%C3%AD!%20Listo%20y%20entregado%20en%20Barrios%20Unidos&amp;linknote="
								rel="nofollow noopener"><svg class="redes-bogotema"
										enable-background="new 0 0 32 32" version="1.1"
										viewBox="0 0 32 32" xml:space="preserve"
										xmlns="http://www.w3.org/2000/svg">
								<g>
								<path class="redes-bogotema"
											d="M18.014,9.564c-1.439,0.523-2.348,1.874-2.244,3.351l0.035,0.57l-0.576-0.07 c-2.094-0.268-3.925-1.175-5.479-2.7L8.99,9.959l-0.196,0.559c-0.414,1.245-0.149,2.56,0.714,3.445 c0.46,0.489,0.356,0.559-0.437,0.268c-0.276-0.093-0.518-0.163-0.541-0.128c-0.08,0.082,0.196,1.14,0.414,1.559 c0.299,0.582,0.909,1.152,1.577,1.49l0.564,0.268l-0.667,0.012c-0.644,0-0.667,0.012-0.598,0.257 c0.23,0.756,1.139,1.559,2.152,1.909l0.714,0.244l-0.621,0.372c-0.921,0.536-2.003,0.838-3.085,0.861 c-0.519,0.012-0.944,0.058-0.944,0.093c0,0.116,1.405,0.767,2.221,1.024c2.451,0.756,5.364,0.43,7.551-0.861 c1.554-0.92,3.107-2.746,3.833-4.516c0.392-0.942,0.783-2.665,0.783-3.49c0-0.536,0.035-0.605,0.679-1.245 c0.38-0.372,0.737-0.779,0.806-0.896c0.115-0.221,0.103-0.221-0.483-0.024c-0.978,0.349-1.117,0.303-0.633-0.221 c0.356-0.372,0.783-1.047,0.783-1.245c0-0.035-0.172,0.023-0.369,0.128c-0.207,0.116-0.667,0.291-1.013,0.395l-0.621,0.198 l-0.564-0.385c-0.311-0.209-0.748-0.442-0.978-0.512C19.442,9.355,18.544,9.378,18.014,9.564z"
											fill="#414752"></path>
								<g>
								<g>
								<g>
								<g>
								<g>
								<g>
								<path class="redes-bogotema"
											d="M16,1c8.271,0,15,6.729,15,15s-6.729,15-15,15S1,24.271,1,16S7.729,1,16,1 M16,0 C7.163,0,0,7.164,0,16s7.163,16,16,16s16-7.164,16-16S24.837,0,16,0L16,0z"
											fill="#414752"></path></g></g></g></g></g></g></g></svg></a><a
								class="a2a_button_whatsapp visible-xs" role="button"
								title="Comparte en Whatsapp" aria-label="Comparte en Whatsapp"
								target="_blank" href="/#whatsapp" rel="nofollow noopener"><svg
										class="redes-bogotema" enable-background="new 0 0 32 32"
										version="1.1" viewBox="0 0 32 32" xml:space="preserve"
										xmlns="http://www.w3.org/2000/svg">
								<g>
								<g>
								<path class="redes-bogotema"
											d="M15.338,15.833c-0.421-0.389-0.888-0.935-1.091-1.419c-0.031-0.062-0.093-0.218,0-0.343 c0.187-0.249,0.218-0.265,0.421-0.499c0.14-0.172,0.249-0.327,0.203-0.468l-0.701-1.824c-0.063-0.125-0.249-0.14-0.468-0.156 c-0.187,0-0.389,0-0.53,0.031c-0.312,0.109-0.95,0.951-1.028,1.559c-0.172,1.325,1.028,3.087,2.228,4.178 c1.2,1.107,3.054,2.152,4.363,1.855c0.608-0.14,1.387-0.842,1.449-1.169c0.031-0.14,0.016-0.343-0.016-0.53 c-0.016-0.218-0.062-0.374-0.187-0.436l-1.589-0.733c-0.141-0.078-0.281-0.016-0.421,0.156c-0.171,0.234-0.25,0.327-0.452,0.577 c-0.109,0.14-0.187,0.234-0.311,0.249c-0.141,0.031-0.327-0.047-0.359-0.047C16.35,16.644,15.774,16.223,15.338,15.833 L15.338,15.833z M10.102,21.431l0.904-2.292C10.008,17.985,9.4,16.472,9.4,14.82c0-3.648,2.961-6.595,6.608-6.595 c3.646,0,6.591,2.947,6.591,6.595c0,3.648-2.945,6.611-6.591,6.611c-1.465,0-2.805-0.468-3.896-1.278L10.102,21.431z M8.995,19.185l-1.247,4.989l4.457-2.027c1.138,0.592,2.431,0.936,3.803,0.936c4.55,0,8.243-3.695,8.243-8.264 c0-4.552-3.694-8.248-8.243-8.248c-4.566,0-8.259,3.695-8.259,8.248C7.749,16.426,8.216,17.923,8.995,19.185L8.995,19.185z"
											fill="#414752"></path></g>
								<g>
								<g>
								<g>
								<g>
								<g>
								<g>
								<path class="redes-bogotema"
											d="M16,1c8.271,0,15,6.729,15,15s-6.729,15-15,15S1,24.271,1,16S7.729,1,16,1 M16,0 C7.163,0,0,7.164,0,16s7.164,16,16,16s16-7.163,16-16S24.836,0,16,0L16,0z"
											fill="#414752"></path></g></g></g></g></g></g></g></svg></a></span>
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
		const fileName = "Guía_trato_usuarios.pdf";

		downloadLink.href = linkSource;
		downloadLink.download = fileName;
		downloadLink.click();

	}
	downloadPDF('${miRitCertificacionForm.rit.stringRIT}')
</script>

