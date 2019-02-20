<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6 headline">
		<h2>
			<span><spring:theme code="predial.unificado.consulta.title" /></span>
		</h2>
	</div>
</div>

<sf:form>
	<div>
		<br>
		<div class="container">
			<div class="col-md-3">
				<label class="control-label "><spring:theme
						code="predial.unificado.consulta.anigrav" /></label>
			</div>
			<div class="col-md-2">
				<select id="an" class="form-control " name=" " onchange=" ">
					<option value="2019">2019</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
				</select>
			</div>
			<div class="col-md-3 col-md-offset-3 center">
				<div class="form-group">
					<button action="" type="submit" class="btn btn-primary btn-block"
						id="" name="" value="declarar">
						<spring:theme code="predial.unificado.consulta.search" />
					</button>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-3 center">

				<button action="" type="" class="btn btn-primary btn-block" id=""
					name="" value="declarar">
					<spring:theme code="predial.unificado.consulta.regresar" />
				</button>
			</div>

			<div class="col-md-3 center">

				<button action="" type="submit" class="btn btn-primary btn-block"
					id="" name="" value="declarar">
					<spring:theme code="predial.unificado.consulta.descu" />
				</button>

			</div>
			<div class="col-md-3 center">

				<button action="" type="submit" class="btn btn-primary btn-block"
					id="" name="" value="declarar">
					<spring:theme code="predial.unificado.consulta.desfactura" />
				</button>

			</div>
			<div class="col-md-3 center">

				<button action="" type="submit" class="btn btn-primary btn-block"
					id="" name="" value="declarar">
					<spring:theme code="predial.unificado.consulta.presdec" />
				</button>
			</div>
		</div>
	</div>

</sf:form>
