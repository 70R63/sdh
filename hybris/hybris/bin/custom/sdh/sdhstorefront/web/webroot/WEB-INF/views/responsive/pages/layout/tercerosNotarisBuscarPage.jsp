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

<terceros:terceroNotarioBuscar/>
<br>
<terceros:tercero_predial/>
<br>
<terceros:tercero_ica/>
<br>
<terceros:tercero_reteica/>
<br>
<terceros:tercero_vehicular/>
<br>
<terceros:tercero_delineacion/>
<br>
<terceros:tercero_gasolina/>
<br>
<terceros:tercero_publicidad/>


<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>

