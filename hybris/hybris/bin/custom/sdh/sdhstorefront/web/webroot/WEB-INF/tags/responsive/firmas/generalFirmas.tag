<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="firmaContribuyenteRedirection" required="false" type="java.lang.String" %>
<spring:htmlEscape defaultHtmlEscape="true"/>

<input type="hidden" id="taxTypeRedirection" value="${firmaContribuyenteRedirection}">

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL" htmlEscape="false"/>

<div id="dialogFirmas" title="Firmas">
    <div id="firmasDialogContent"></div>
</div>

<div class="row mt-3 representante">
        <div class="col-md-12 mt-3">
            <div class="">
                <h2>
                    <span><spring:theme code="publicidad.declaracion.firma.titulo"/></span>
                </h2>
            </div>


            <div class="row mt-3">
                <div class="col-md-2">
                    <div class="form-group">
                        <label class="control-label"><spring:theme code=""/></label>
                        <input disabled id="firmInterFunct" name="firmInterFunct" class="form-control PEFirmInterFunct" disabled type="text" value="Declarante" maxlength="240" placeholder="Declarante" style="margin-top:4px">
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="form-group">
                        <label class="control-label">
                        <spring:theme code="publicidad.declaracion.firma.nombre"/></label>
                        <input disabled id="firmCompleteName" name="firmCompleteName" class="form-control" disabled type="text" value="${contribuyente.completeName}" maxlength="240"></input>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="form-group">
                        <label class="control-label"><spring:theme code="publicidad.declaracion.firma.tipoiden"/></label>
                        <input disabled  class="form-control FirmTipoId" disabled type="text" value="${contribuyente.documentType}" maxlength="240"></input>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="form-group">
                        <label class="control-label"><spring:theme code="publicidad.declaracion.firma.numide"/></label>
                        <input disabled  class="form-control FirmNumId" disabled type="text" value="${contribuyente.documentNumber}" maxlength="240"></input>
                    </div>
                </div>

                <div class="col-md-2">
                    <div class="form-group">
                        <label class="control-label"><spring:theme code="publicidad.declaracion.firma.numtarjeta"/></label>
                        <input disabled class="form-control FirmTarjetaProf" disabled type="text" value="${contribuyente.numBP}" maxlength="240"></input>
                    </div>
                </div>
                <c:if test="${contribuyente.documentNumber eq currentUser.documentNumber}">
                    <div class="col-md-1">
                        <label class="control-label"><spring:theme code=""/></label>
                        <button type="button"  class="btn btn-primary justFirm"  style="margin-top:4px">Solo Firmar
                        </button>
                    </div>
                    <div class="col-md-1">
                        <label class="control-label"><spring:theme code=""/></label>
                        <button type="button" class="btn btn-primary firmAndAdd"  style="margin-top:4px">Firmar y Agregar
                        </button>
                    </div>
                </c:if>
            </div>

        </div>
    </div>


