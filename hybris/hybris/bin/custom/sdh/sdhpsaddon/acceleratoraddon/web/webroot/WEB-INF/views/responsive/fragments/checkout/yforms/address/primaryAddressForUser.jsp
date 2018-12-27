<%@ page trimDirectiveWhitespaces="true" contentType="application/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{"result": {"isPrimaryAddressAvailable": "${isPrimaryAddressAvailable}"

<c:if test="${isPrimaryAddressAvailable}">
,"addressData":{"addressline1":"${primaryAddress.line1}", "addressline2":"${primaryAddress.line2}",
      "town":"${primaryAddress.town}","postalCode":"${primaryAddress.postalCode}","country":
      "${primaryAddress.country.isocode}","phone":"${primaryAddress.phone}"
}
</c:if>
} }
