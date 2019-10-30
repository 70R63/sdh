<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<spring:htmlEscape defaultHtmlEscape="true" />	

<div class="loader"></div>
<template:page>


<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1 d-flex align-items-center">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme code="conciliaciones.header.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="conciliaciones.header.description" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="row">
			<div class="headline">
				<h2 align="center">
					<span><spring:theme code="obligacion.inicial.titulo" /></span>

				</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 text-center">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="obligacion.inicial.buscarpor" /></label>
				</div>
			</div>
		</div>

	<div class="container">
		CONCILIACIONES!
		<c:url var="importConciliacion" value="/conciliaciones/upload" />
		
		 <form:form commandName="importConciliacionForm" enctype="multipart/form-data" method="post" action="${importConciliacion}" class="">
		 	<div class="form-group">
			    <label for="exampleInputFile">File input</label>
			    <input type="file" id="" name="conciliacionFile" >
			    <p class="help-block">Example block-level help text here.</p>
			  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		 
         </form:form>
		  
	</div>
	<div id="dialogConciliaciones" title="Conciliaciones" ><div id="conciliacionesDialogContent"></div></div>
</div>
	
	
	<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>
</template:page>


