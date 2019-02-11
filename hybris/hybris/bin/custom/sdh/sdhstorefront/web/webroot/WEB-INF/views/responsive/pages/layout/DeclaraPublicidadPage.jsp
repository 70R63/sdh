<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="DeclaraPubli"
	tagdir="/WEB-INF/tags/responsive/DeclaraPubli"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="row">
	<div class="container">
		<div class="account-section-content">
			<div class="account-section-form">
				<form:form
					action="${pageContext.request.contextPath}/contribuyentes/publicidadexterior/declaracion"
					method="post" commandName="declaPublicidadForm">
					<DeclaraPubli:DecPuGeneral />
					<DeclaraPubli:DecPuInfoValla />
					<DeclaraPubli:DecPuTotalPag />
					<DeclaraPubli:DecPuFirmDecl />
					<DeclaraPubli:DecPuPago />
				</form:form>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		eliminaCampos();
		eliminaCampos2();
		llenacampo(value);
		llenacampoRes(value);
	}
</script>

<script type="text/javascript">
	function llenacampo(luginst) {

		var x = document.getElementById("orValla");
		var y = document.getElementById("basegrav");

		if (luginst == "01") { //Predio
			var option1 = document.createElement("option");
			option1.text = "Oriente/Occidente";
			option1.value = "01";
			x.add(option1);

			var option2 = document.createElement("option");
			option2.text = "Occidente/Oriente";
			option2.value = "02";
			x.add(option2);

			var option3 = document.createElement("option");
			option3.text = "Norte/sur";
			option3.value = "03";
			x.add(option3);

			var option4 = document.createElement("option");
			option4.text = "Sur/Norte";
			option4.value = "04";
			x.add(option4);
		}
		if (luginst == "02") { //Vehículo
			var option5 = document.createElement("option");
			option5.text = "Derecha";
			option5.value = "05";
			x.add(option5);

			var option6 = document.createElement("option");
			option6.text = "Izquierda";
			option6.value = "06";
			x.add(option6);

			var option7 = document.createElement("option");
			option7.text = "Ambos Sentidos";
			option7.value = "07";
			x.add(option7);
		}

	}
</script>

<script type="text/javascript">
	function llenacampoRes(luginst) {

		var x = document.getElementById("basegrav");

		if (luginst == "01") { //Predio
			var option1 = document.createElement("option");
			option1.text = "Vallas de mas de 8 m2 hasta 24 m2";
			option1.value = "01";
			x.add(option1);

			var option2 = document.createElement("option");
			option2.text = "Vallas de mas de 24 m2";
			option2.value = "02";
			x.add(option2);

			var option3 = document.createElement("option");
			option3.text = "Vallas de propiedad de constructores de mas de 8 m2";
			option3.value = "03";
			x.add(option3);
		}
		if (luginst == "02") { //Vehículo
			var option4 = document.createElement("option");
			option4.text = "Valla en Vehiculos automotores con "
					+ "dimension superior a 8m2";
			option4.value = "04";
			x.add(option4);
		}

	}
</script>


<script type="text/javascript">
	function eliminaCampos() {

		var x = document.getElementById("orValla");
		while (x.length) {
			x.remove(0);
		}
	}
</script>

<script type="text/javascript">
	function eliminaCampos2() {

		var x = document.getElementById("basegrav");
		while (x.length) {
			x.remove(0);
		}
	}
</script>