<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<spring:htmlEscape defaultHtmlEscape="true" />	


<template:page>

	<div class="container">
		CONCILIACIONES!
		<c:url var="importConciliacion" value="/conciliaciones/upload" />
		
		 <form:form commandName="importConciliacionForm" enctype="multipart/form-data" method="post" action="${importConciliacion}" class="">
		 	<div class="form-group">
			    <label for="exampleInputFile">File input</label>
			    <input type="file" id="conciliacionFile" name="conciliacionFile" >
			    <p class="help-block">Example block-level help text here.</p>
			  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		 
         </form:form>
		  
	</div>
	<div id="dialogConsiliaciones" title="Conciliaciones" ><div id="conciliacionesDialogContent"></div></div>

	
	
	
</template:page>

