<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-md-3 col-md-offset-8" style="display: none" id="btnGenImprimirRep">
    <div class="row">
		<button type="button" data-claveImpuesto="" class="btn btn-primary btn-lg !important" style="margin-top: 3px"
			onclick="imprimePDF()">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
</div>



<script>
function imprimePDF(opcionBusqueda) {

	var claveImpuesto = $("#btnGenImprimirRep").data("claveImpuesto");
	var nombreArchivo = "Reporte.pdf";
	
	switch (claveImpuesto) {
	  case "0001":
		  nombreArchivo = "predialReporte.pdf";
	    break;
	  case "0002":
		  nombreArchivo = "vehicularReporte.pdf";
	    break;
	  case "0003":
		  nombreArchivo = "icaReporte.pdf";
	    break;
	  case "0004":
// 		  nombreArchivo = "vehicularReporte.pdf";  //Reteica
	    break;
	  case "0005":
		  nombreArchivo = "sobGasolinaReporte.pdf";
	    break;
	  case "0006":
		  nombreArchivo = "delUrbanaReporte.pdf";
	    break;
	  case "0007":
		  nombreArchivo = "pubExteriorReporte.pdf";
	    break;
	  default:
		  nombreArchivo = "Reporte.pdf";
	    break;
	}
	
	ACC.oblipend.bindTrmPdf(claveImpuesto,'4',nombreArchivo);


}
</script>