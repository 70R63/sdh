<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<link href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js"></script>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
    <div class="row">
        <form:form method="post" commandName="tercerosAutForm" action="buscar">
            <div class="col-sm-3">
                <formElement:formSelectBox idKey="tipdoc" labelKey="terceros.notario.buscar.tipdoc"
                    path="tipdoc" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"
                    items="${documentTypes}" selectCSSClass="form-control" disabled="false"/>

             </div>
             <div class="col-sm-3">
                 <formElement:formSelectBox idKey="impuesto" labelKey="terceros.notario.buscar.impuesto"
                                 path="impuesto" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"
                                 items="${tercerosAutForm.listaImpuestos}" selectCSSClass="form-control" disabled="false"/>
             </div>
             <div class="col-sm-3">
                <formElement:formInputBox idKey="numdoc" labelKey="terceros.notario.buscar.numdoc" path="numdoc" />
             </div>
             <div class="col-sm-3">
                    </br>
                    <ycommerce:testId code="login_forgotPasswordSubmit_button">
                        <button class="btn btn-primary btn-lg" type="submit">
                            <spring:theme code="register.send"/>
                        </button>
                        <button class="btn btn-secondary btn-lg" type="submit">
                            <spring:theme code="register.cancel"/>
                        </button>
                    </ycommerce:testId>
             </div>
         </form:form>
     </div>
     <div class="row">
        <div class="col-sm-12">
             <table id="example" class="sdhTable sdhTable-striped sdhTable-bordered" style="width:100%">
                 <thead>
                     <tr>
                         <th><spring:theme code="sdh.tercerosAut.chip.table.header"/></th>
                         <th><spring:theme code="sdh.tercerosAut.matriculaInmobiliaria.table.header"/></th>
                         <th><spring:theme code="sdh.tercerosAut.direccion.table.header"/></th>
                         <th><spring:theme code="sdh.tercerosAut.anioGravable.table.header"/></th>
                         <th><spring:theme code="sdh.tercerosAut.estadoObligacion.table.header"/></th>
                     </tr>
                 </thead>
                 <tbody>
                    <c:forEach items="${tercerosAutTable.obligacionesPredios}" var="obligacion">
                        <tr>
                            <td><c:out value="${obligacion.chip}"/></td>
                            <td><c:out value="${obligacion.matriculaInmobiliaria}"/></td>
                            <td><c:out value="${obligacion.direccion}"/></td>
                            <td><c:out value="${obligacion.anoGravable}"/></td>
                            <td><c:out value="${obligacion.estadoObligacion}"/></td>
                        </tr>
                    </c:forEach>
                 </tbody>
             </table>
        </div>
     </div>
</div>