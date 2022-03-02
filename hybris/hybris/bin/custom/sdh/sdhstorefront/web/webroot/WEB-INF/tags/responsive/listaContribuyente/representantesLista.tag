<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page" style="display: none">
    <form:form action="">
        <div class="row">
            <div class="col-md-12">
                    <h2>
                        <span class="col-md-10 "><spring:theme
                                code="contribuyente.listaRepresentantes.titulo" /></span>
                    </h2>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-8">
                <form:form action="">
                    <div class="table-responsive text-center">
                        <table class="table table-bordered tabPaginacion" >
                            <thead>
                                <tr>
                                    <td><label class="control-label labeltabletd "><spring:theme code="contribuyente.listaRepresentantes.documentType" /></label></td>
                                    <td><label class="control-label labeltabletd "><spring:theme code="contribuyente.listaRepresentantes.documentNumber" /></label></td>
                                    <td><label class="control-label labeltabletd "><spring:theme code="contribuyente.listaRepresentantes.name" /></label></td>
                                    <td><label class="control-label labeltabletd "><spring:theme code="contribuyente.listaRepresentantes.as" /></label></td>
                                    <td><label class="control-label labeltabletd "><spring:theme code="contribuyente.listaRepresentantes.refentTo" /></label></td>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${empty contibForm.representados}">
                                        <tr>
                                            <td><input class="inputtextnew " disabled="disabled" type="text" size="30" value="" /></td>
                                            <td><input class="inputtextnew " disabled="disabled" type="text" size="40" value="" /></td>
                                            <td><input class="inputtextnew " disabled="disabled" type="text" size="40" value="" /></td>
                                            <td><input class="inputtextnew " disabled="disabled" type="text" size="30" value="" /></td>
                                            <td><input class="inputtextnew " disabled="disabled" type="text" size="30" value="" /></td>                                            
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${contibForm.representados}" var="eachRepresentados">
                                            <tr>
                                                <td><input class="inputtextnew " disabled="disabled" type="text" size="30" value="${eachRepresentados.tipoDoc}" /></td>
                                                <td><input class="inputtextnew " disabled="disabled" type="text" size="40" value="<spring:theme code="${eachRepresentados.numDoc}" />" /></td>
                                                <td><input class="inputtextnew " disabled="disabled" type="text" size="40" value="${eachRepresentados.nomCompleto}" /></td>
                                                <td><input class="inputtextnew " disabled="disabled" type="text" size="30" value='<spring:theme code="${eachRepresentados.funcionInterl}" />' /></td>
                                                <td><input class="inputtextnew " disabled="disabled" type="text" size="30" value='<spring:theme code="${eachRepresentados.impuesto}"/>' /></td>
                                            </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>
    </form:form>    
</div>