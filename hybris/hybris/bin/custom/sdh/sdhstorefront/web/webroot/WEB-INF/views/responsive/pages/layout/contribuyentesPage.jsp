<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="cont"
	tagdir="/WEB-INF/tags/responsive/listaContribuyente"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<template:page pageTitle="${pageTitle}">
<cont:contribuyentesLista/>
</template:page>
