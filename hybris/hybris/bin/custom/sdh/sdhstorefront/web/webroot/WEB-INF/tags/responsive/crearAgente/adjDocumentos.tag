<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div id="acordeon" class="container">
	<div class="card cardmirit ">
		<div class="card-header" id="head4">
			<h5 class="mb-0 cardtitle">
				<button class="btn btn-link miritmenu" data-toggle="collapse"
					data-target="#collapse4" aria-expanded="true"
					aria-controls="collapse4">
					<h4>
						<span tabindex="0"><spring:theme
								code="autorizado.crear.documentos.titulo" text="" /></span>
					</h4>
				</button>
			</h5>
		</div>
		<div id="collapse4" class="collapse" aria-ladelledby="head4"
			data-parent="#acordeon">
			<div class="card-body">
				<div class="row" style="margin-top: 10px">
					<div class="col-md-12"
						style="background: #d2d2d2; margin-top: 20px !important;">
						<div class="form-group">
							<label class="control-label"><spring:theme
									code="autorizado.crear.documentos.nota1" /></label>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: 10px">
					<div class="col-md-12">
						<input id="" name="" class="form-control"
							aria-required="true" type="file" value="" maxlength="240">
					</div>
				</div>

				<div class="row" style="margin-top: 10px">
					<div class="col-md-2">
						<button class="btn btn-primary" type="button" id="" onclick="continuar()">
							<spring:theme code="autorizado.crear.documentos.continuar" />
						</button>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
