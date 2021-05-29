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
			<h2 class="titulo-caja--ser-rel color-sr3 paso3">Categor�a</h2>
			<p class="pasoClase3 metrophobic" style="margin-bottom: 0px">Selecciona la categor�a.</p>
			<div class="caja--ser-rel color-sr3">
				<select id="categoriaBuscar" class="new_alto form-control " name="categoria" onchange="showquestion(this)">
					<option value="00">Seleccionar</option>
                    <c:forEach items="${sdhFAQsCategories}" var="category">
                        <option value="${category.code}"><c:out value="${category.description}"/></option>
                    </c:forEach>
				</select> <br>

                <input type="text" id="faqKeyWord" name="faqKeyWord" class="new_alto form-control "
                       minlength="4" maxlength="8" size="10">

				<button class="btn btn-primary" onclick="keyWord()">Buscar palabra clave</button>
			</div>
		</div>

		<div class="col-md-7 col-xs-12 mb-20 no-marginleft" id="PregPredial"
			style="margin-left: 50px; margin-top: 50px">
			<div id="questionsDiv" class="preguntas">
			</div>
		</div>
	</div>

	<script>
		function showquestion(selection) {
            var categoryId = selection[selection.selectedIndex].value;
            document.getElementById("questionsDiv").innerHTML = "";
			$.ajax({
                url: "faqs/getByCategory?code="+categoryId,
                type: 'GET',
                cache: false,
                success: function (faqs){
                    $.each(faqs, function(index, faq) {printFaq(faq);});
                },error: function (error){
                    console.log("Error");
                }
            });
		}

		function keyWord(selection) {
		    var keyWord = $("#faqKeyWord").val();
		    document.getElementById("questionsDiv").innerHTML = "";
            $.ajax({
                url: "faqs/getByKeyWord?keyWord="+keyWord,
                type: 'GET',
                cache: false,
                success: function (faqs){
                    $.each(faqs, function(index, faq) {printFaq(faq);});
                },error: function (error){
                    console.log("Error");
                }
            });
        }

		function printFaq(faq){
		    document.getElementById("questionsDiv").innerHTML +=
		        '<hr><div class=\"preguntas_body\"><p class=\"pregunta\"><span>' +
		        faq.question + '</span></p>' + faq.answer + '</div><hr>';
		}
	</script>