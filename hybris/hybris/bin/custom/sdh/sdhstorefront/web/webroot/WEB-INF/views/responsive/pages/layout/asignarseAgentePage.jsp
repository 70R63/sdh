<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="asigna"
	tagdir="/WEB-INF/tags/responsive/asignarsecomoAgente"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<div id="success" class="alert alert-success" style="display: none"></div>
<div id="danger" class="alert alert-danger" style="display: none"></div>

<asigna:buscarContrib />
<div id="IdDetalleCrear" style="display: none">
	<asigna:selecCalidad />
	<asigna:selecImpuesto />
	<asigna:selecTramiteGeneral />
	<asigna:adjDocumentos />
<%-- 	<asigna:resumen /> --%>
</div>


<script type="text/javascript">

window.onload = function() {
	
	var cosas = $(":input");
	var tam = cosas.length;
	if (false){
		for (var i = 0; i < tam; i++) {
			var valor = cosas[i].value;
			if (valor == "") {
				cosas[i].value = "-";

			}
		}
	}
	$(".loader").fadeOut("slow");
}
function detalleBP() {
    var t = $('#contribuyenteTable').DataTable();
    $("#contribuyenteTable tr>td").remove();
    $.ajax({
        url: "/sdhstorefront/es/agentesAut/getBp?"+
            "tipoId="+ $("#documentType").val() +
            "&numId="+ $("#documentNumber").val() +
            "&fechaExp=" + $("#issuedDate").val(),
        data:{},
        type: "GET",
        success: function(dataResponse){
            t.row.add( [dataResponse.tipoId, dataResponse.numDoc,
                dataResponse.nomAgen, dataResponse.tipoPers
            ] ).draw( false );
        },
        error: function(){}
    });
    var det = document.getElementById('IdDetalleCrear');
    det.style.display='block';
}

function continuar(){
    var calidadChecked = getSelectedChecks(10,180,10,3,"TZRE"); //Calidad
    var impuestoChecked = getSelectedChecks(1,7,1,4,""); //Impuestos
    var autorizaChecked = getSelectedChecks(1,8,1,2,"ZM"); //Autorizaciones

    console.log(calidadChecked);
    console.log(impuestoChecked);
    console.log(autorizaChecked);

    $.ajax({
        url: "/sdhstorefront/es/agentesAut/createAgente?"+
            "calidades="+ calidadChecked +
            "&impuestos="+ impuestoChecked +
            "&autorizaciones=" + autorizaChecked,
        data:{},
        type: "GET",
        success: function(dataResponse){
            console.log(dataResponse);
            document.getElementById("success").style.display = "block";
            document.getElementById("danger").style.display = "none";
            document.getElementById("success").innerHTML = "";
            document.getElementById("success").innerHTML +=  dataResponse.idTramite;
            window.scrollTo(0, 0);
        },
        error: function(){
            document.getElementById("success").style.display = "none";
            document.getElementById("danger").style.display = "block";
            document.getElementById("danger").innerHTML = "";
            document.getElementById("danger").innerHTML += "Ocurrio un error";
            window.scrollTo(0, 0);
        }
    });
}

function getSelectedChecks(iFirst, iLast, incrementBy, padding, prefix){
    var i; var checkedIds = ""; var currentId;
    for(i=iFirst; i<=iLast; i=i+incrementBy){
       currentId = prefix + (i).pad(padding);
       if($("#"+currentId).is(':checked')){checkedIds=currentId+" "+checkedIds;}
    }
    return checkedIds;
}

Number.prototype.pad = function(size) {
  var s = String(this);
  while (s.length < (size || 2)) {s = "0" + s;}
  return s;
}

function fechaExpedicion(doc){
	
	var tip=doc;
	var tipDoc =  tip.value;
	
	if(tipDoc.includes("CC")){
	
	 document.getElementById("fechaExpedicion").style.display = "block";
	}else{
		document.getElementById("fechaExpedicion").style.display = "none";
		document.getElementById("fechaExpedicion").value = "";
	}
}
</script>