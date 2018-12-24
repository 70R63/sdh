<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="col-xs-12 col-sm-6 row">
    <h2 class="pull-left">
        <span tabindex="0"><strong>${ycommerce:sanitizeHTML(bill.billDescription)}</strong></span>
    </h2>
    <div class="card bill-section col-xs-12 col-sm-8">
        <div class="row">
            <div class="col-xs-6" tabindex="0">
                <strong><spring:theme code="bill.pay.amountDue" /> <br />${ycommerce:sanitizeHTML(bill.currency.symbol)} <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.outstandingBillAmount}" /></strong>
            </div>
            <div class="col-xs-6 pull-right" tabindex="0">
                <spring:theme code="bill.pay.billTotal" />
                <br />${ycommerce:sanitizeHTML(bill.currency.symbol)}
                <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bill.totalBillAmount}" />
            </div>
        </div>
    </div>

    <div class="col-md-12">
        <div class="row">
            <div class="col-xs-6" tabindex="0">
                <spring:theme code="bill.pay.issueDate" />
                <br />
                <fmt:formatDate value="${bill.billDate}" dateStyle="MEDIUM" timeStyle="short" type="date" />
            </div>
            <div class="col-xs-6 pull-right" tabindex="0">
                <strong><spring:theme code="bill.pay.dueDate" /> <br /> <fmt:formatDate value="${bill.billDueDate}" dateStyle="MEDIUM" timeStyle="short" type="date" /></strong>
            </div>
        </div>
    </div>

    <div class="card bill-section col-xs-12 col-sm-8 hr-space">
        <div class="row">
            <div class="col-xs-6" tabindex="0">
                <spring:theme code="bill.pay.billId" />
                <br /> ${ycommerce:encodeHTML(bill.billId)}
            </div>
            <div class="col-xs-6 pull-right" tabindex="0">
                <span class="icon-file-pdf gi-1.5x"></span><a href="${bill.fullBillUrl}" target="_blank"> <spring:theme code="bill.pay.downloadBillPdf" /></a>
            </div>
        </div>
    </div>
</div>
