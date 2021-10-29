<%@ taglib prefix="obligaciones"
	tagdir="/WEB-INF/tags/responsive/obligacionesPendi"%>

<a id="downloadHelper" target="_blank"></a>
<div id="dialogDeclaracion" title="Declaracion">
	<div id="declaracionDialogContent"></div>
</div>

<script type="text/javascript">
function pagarEnLinea(tipoImpuesto,anoGravable,periodo,numObjeto,chip){
	
	var numBP = "${customerData.numBP}";
	var numDoc = "${customerData.documentNumber}";
	var tipoDoc = "${customerData.documentType}";
	var clavePeriodo = anoGravable.substr(2,2).concat("A1");
	var dv = "${customerData.digVer}";
		
	ACC.opcionDeclaraciones.llamarPrepararPagoPSE(tipoImpuesto,numBP,numDoc,tipoDoc,anoGravable,periodo,clavePeriodo,dv,numObjeto,chip);		
}
</script>


<obligaciones:obliPendientesPagar />