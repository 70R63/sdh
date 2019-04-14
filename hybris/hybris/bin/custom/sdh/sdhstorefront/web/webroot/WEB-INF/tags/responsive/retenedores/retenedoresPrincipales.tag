<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="retenedor.servicio.principales.titulo" /></span>
				</h2>
			</div>

			<form:form action="">
				<div class="row mt-3">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="retenedor.servicio.principales.tipdoc" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="retenedor.servicio.principales.calagente" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="retenedor.servicio.principales.numdoc" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="retenedor.servicio.principales.fecdesde" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="retenedor.servicio.principales.nombre" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="retenedor.servicio.principales.fechasta" /></label> <input
								disabled id="" name="" class="form-control" disabled type="text"
								value="" maxlength="240"></input>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
