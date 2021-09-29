<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="consultas"
	tagdir="/WEB-INF/tags/responsive/edoCuenta"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
	<consultas:estadoCuentaMenu />

	<consultas:edoCuentaTodo />
	
	<consultas:edoCuentaImprimir/>

	<%-- 	<consultas:estadoCuentaImpuesto /> --%>

</sf:form>
<script type="text/javascript">
	window.onload = function() {
		var url = window.parent.location.href;
		var contenido_url = url.includes('agenteRetenedor');
		
		if(contenido_url == true){
			var contrib_select = document.getElementById('idImpuestoAgente');
			var impblock = document.getElementById('impRetenedor');
		
			if(contrib_select != null){
				contrib_select.style.display = 'block';
			}
			if(impblock != null){
				impblock.style.display = 'block';				
			}
		}else{
			var contrib_select = document.getElementById('idImpuesto');
			var impblock = document.getElementById('impContribuyente');
			var btn = document.getElementById('btnBuscar');
			
			if(contrib_select != null){
				contrib_select.style.display = 'block';
			}
			if(impblock != null){
				impblock.style.display = 'block';
			}
			if(btn != null){
				btn.style.display = 'block';
			}
		}

		$(".loader").fadeOut("slow");
	}

	function Selected(selectObject) {
		debugger;
		var value = selectObject.value;
		document.getElementById("impuesto").val() = value;
	}

	function Selectedver(selectObject) {
		var contrib_select = document.getElementById('idImpuesto');
		var impblock = document.getElementById('impContribuyente');
		
		if(contrib_select != null){
			contrib_select.style.display = 'block';			
		}
		if(impblock != null){
			impblock.style.display = 'block';			
		}
		var value = selectObject.value;
		var xx = document.getElementById('impuesto');
		var x = xx.value;

		establecerVisibles("ninguno");
		switch(x){
			case "1":
				establecerVisibles("detpred");
				break;
			case "2":
				establecerVisibles("detvehi");
				break;
			case "3":
				establecerVisibles("detica");
				break;
			case "4":
				establecerVisibles("detplubliext");
				break;
			case "5":
				establecerVisibles("detgas");
				break;
			case "6":
				establecerVisibles("detdeli");
				break;
			case "7":
				establecerVisibles("oblig");
				break;
			case "0":
				establecerVisibles("todos");
				break;
			default:
				establecerVisibles("todos");
				break;
		}

	}
	
	function establecerVisibles(opcionVisible){
		
		var detpred = document.getElementById('predial');
		var detica = document.getElementById('ica');
		var detvehi = document.getElementById('vehiculos');
		var detdeli = document.getElementById('delurbana');
		var detgas = document.getElementById('gasolina');
		var detplubliext = document.getElementById('publiext');
		var oblig = document.getElementById('obli-no-tributarias')

		
		switch(opcionVisible){
			case "ninguno":
				if(detpred != null){
					detpred.style.display = 'none';
				}
				if(detica != null){
					detica.style.display = 'none';
				}
				if(detvehi != null){
					detvehi.style.display = 'none';
				}
				if(detdeli != null){
					detdeli.style.display = 'none';
				}
				if(detgas != null){
					detgas.style.display = 'none';
				}
				if(detplubliext != null){
					detplubliext.style.display = 'none';
				}
				if(oblig != null){
					oblig.style.display = 'none';
				}
				break;
			case "todos":
				if(detpred != null){
					detpred.style.display = 'block';
				}
				if(detica != null){
					detica.style.display = 'block';
				}
				if(detvehi != null){
					detvehi.style.display = 'block';
				}
				if(detdeli != null){
					detdeli.style.display = 'block';
				}
				if(detgas != null){
					detgas.style.display = 'block';
				}
				if(detplubliext != null){
					detplubliext.style.display = 'block';
				}
				if(oblig != null){
					oblig.style.display = 'block';
				}
				break;
			case "detpred":
				if(detpred != null){
					detpred.style.display = 'block';
				}
				break;
			case "detica":
				if(detica != null){
					detica.style.display = 'block';
				}
				break;
			case "detvehi":
				if(detvehi != null){
					detvehi.style.display = 'block';
				}
				break;
			case "detdeli":
				if(detdeli != null){
					detdeli.style.display = 'block';
				}
				break;
			case "detgas":
				if(detgas != null){
					detgas.style.display = 'block';
				}
				break;
			case "detplubliext":
				if(detplubliext != null){
					detplubliext.style.display = 'block';
				}
				break;
			case "oblig":
				if(oblig != null){
					oblig.style.display = 'block';
				}
				break;
		}
	}

	function cancelfun(selectObject) {

		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;
		var tablepredial = document.getElementById('table-predial');
		var tablevehiculos = document.getElementById('table-vehiculos');
		var tableica = document.getElementById('table-ica');
		var tablepublicidad = document.getElementById('table-publicidad');
		var tabledeli = document.getElementById('table-delineacion');
		var tablegas = document.getElementById('table-gasolina');
		var taboblig = document.getElementById('table-obli-no-tributarias');
		var todo = document.getElementById('idtodos');
		var newvalor = document.getElementById('impuesto');
		var detpred = document.getElementById('detalle-predial');
		var detica = document.getElementById('detalle-ica');
		var detvehi = document.getElementById('detalle-vehiculos');
		var detdeli = document.getElementById('detalle-delurbana');
		var detgas = document.getElementById('detalle-gasolina');
		var detplubliext = document.getElementById('detalle-publiext');

		if (x == '1' || x == '2' || x == '3' || x == '4' || x == '5'
				|| x == '6' || x == '7') {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tabledeli.style.display = 'none';
			tablegas.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
			$("#impuesto").val('0')

		} else {

			tablepredial.style.display = 'none';
			tablevehiculos.style.display = 'none';
			tableica.style.display = 'none';
			tablepublicidad.style.display = 'none';
			tablegas.style.display = 'none';
			tabledeli.style.display = 'none';
			taboblig.style.display = 'none';
			todo.style.display = 'block';
			detpred.style.display = 'none';
			detica.style.display = 'none';
			detvehi.style.display = 'none';
			detdeli.style.display = 'none';
			detgas.style.display = 'none';
			detplubliext.style.display = 'none';
		}
	}
	
	function goBack() {
		window.history.back();
	}
</script>

