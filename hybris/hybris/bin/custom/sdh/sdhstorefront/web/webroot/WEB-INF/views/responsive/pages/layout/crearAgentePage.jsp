<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="crea" tagdir="/WEB-INF/tags/responsive/crearAgente"%>

<!--script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script-->
<!--script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script-->

<div class="loader"></div>

<div id="success" class="alert alert-success" style="display: none"></div>
<div id="danger" class="alert alert-danger" style="display: none"></div>

<crea:buscarContrib />
<div id="IdDetalleCrear" style="display: none">
	<crea:selecCalidad />
	<crea:selecImpuesto />
	<crea:selecTramiteGeneral />
	<crea:adjDocumentos />
</div>

<script type="text/javascript">
window.onload = function() {
    $(".loader").fadeOut("slow");
}

function detalleBP(){
    var t = $('#contribuyenteTable').DataTable();
    $("#contribuyenteTable tr>td").remove();
    var urlConsulta = "<c:url value='/agentesAut/getBp?'/>"+
	    "tipoId="+ $("#documentType").val() +
	    "&numId="+ $("#documentNumber").val() +
	    "&fechaExp=" + $("#issuedDate").val();

//     url: "/sdhstorefront/es/agentesAut/getBp?"+
//     "tipoId="+ $("#documentType").val() +
//     "&numId="+ $("#documentNumber").val() +
//     "&fechaExp=" + $("#issuedDate").val(),    
    debugger;
    $.ajax({
        url: urlConsulta,
        data:{},
        type: "GET",
        success: function(dataResponse){
        	if(dataResponse.tipoId != undefined ){
                t.row.add( [dataResponse.tipoId, dataResponse.numDoc,
                    dataResponse.nomAgen, dataResponse.tipoPers
                ] ).draw( false );
        	}
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



</script>

