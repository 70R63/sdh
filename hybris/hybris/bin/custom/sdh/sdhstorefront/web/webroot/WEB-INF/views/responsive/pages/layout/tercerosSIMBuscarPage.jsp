<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="terceros"
	tagdir="/WEB-INF/tags/responsive/terceroautorizado"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="loader"></div>

<terceros:terceroSIMBuscar/>
<terceros:tercero_predial/>
<terceros:tercero_ica/>
<terceros:tercero_reteica/>
<terceros:tercero_vehicular/>
<terceros:tercero_delineacion/>
<terceros:tercero_gasolina/>
<terceros:tercero_publicidad/>


<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>
