<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container_new_page">
	<div class="row">
		<div class="col-md-10 col-md-offset-9">
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
			<h2 class="titulo-caja--ser-rel color-sr3 paso3">Categoria</h2>
			<p class="pasoClase3 metrophobic" style="margin-bottom: 0px">Busqueda</p>
			<div class="caja--ser-rel color-sr3">
				<p class="pasoClase3 metrophobic" style="margin-bottom: 0px">Categoria:
				</p>
				<!-- 				<select id="categoriaBuscar" class="new_alto form-control " name="categoria" onchange="showquestion(this)"> -->
				<select id="categoriaBuscar" class="new_alto form-control "
					name="categoria">
					<option value="00">Seleccionar</option>
					<c:forEach items="${sdhFAQsCategories}" var="category">
						<option value="${category.code}"><c:out
								value="${category.description}" /></option>
					</c:forEach>
				</select> <br>

				<p class="pasoClase3 metrophobic" style="margin-bottom: 0px">Palabra
					Clave</p>
				<input type="text" id="faqKeyWord" name="faqKeyWord"
					class="new_alto form-control " minlength="4" maxlength="8"
					size="10">

				<button class="btn btn-primary" id="keyWordSearch">Buscar
					palabra clave:</button>
			</div>
		</div>

		<c:choose>
			<c:when test="${faqDataList != null}">
				<div id="acordeon" class="col-md-7 col-xs-12 mb-20 no-marginleft">
					<c:forEach items="${faqDataList}" var="faqs">

						<div class="card cardmirit ">
							<div class="card-header" id="head4">
								<h5 class="mb-0 cardtitle">
									<button class="btn btn-link miritmenu" data-toggle="collapse"
										data-target="#collapse${faqs.code}" aria-expanded="true"
										aria-controls="collapse4">
										<h4>
											<span tabindex="0"><spring:theme
													code="${faqs.question}" text="${faqs.question}" /></span>
										</h4>
									</button>
								</h5>
							</div>
							<div id="collapse${faqs.code}" class="collapse"
								aria-ladelledby="head4" data-parent="#acordeon">
								<div class="card-body">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group ">
												<label class="text-justify control-label required">
													<spring:theme code="${faqs.answer}" />
												</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>

	</div>