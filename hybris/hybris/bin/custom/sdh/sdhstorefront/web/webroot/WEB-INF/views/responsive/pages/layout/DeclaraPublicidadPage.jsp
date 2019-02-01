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
<form:form action="DeclaraPublicidadPage" method="post"
					commandName="declaraPublicidadpage">
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

<!--<form:form
					action="${pageContext.request.contextPath}/contribuyentes/publicidadexterior/declaracion"
					method="post" commandName="declaPublicidadForm">-->

<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		eliminaCampos();
		eliminaCampos2();
		if (value == 0) {
			llenacampo();
			llenacampo2();

		} else {
			llenacampoRes();
			llenacampoRes2();
		}

	}
</script>

<script type="text/javascript">
	function llenacampoRes() {

		var x = document.getElementById("orValla");

		var option = document.createElement("option");
		option.text = "Derecha";
		x.add(option);

		var option = document.createElement("option");
		option.text = "Izquierda";
		x.add(option);

		var option = document.createElement("option");
		option.text = "Ambos Sentidos";
		x.add(option);
	}
</script>


<script type="text/javascript">
	function llenacampo() {
		var x = document.getElementById("orValla");

		var option = document.createElement("option");
		option.text = "Oriente/Occidente";
		x.add(option);

		var optionA = document.createElement("option");
		optionA.text = "Occidente/Oriente";
		x.add(optionA);

		var optionB = document.createElement("option");
		optionB.text = "Norte/sur";
		x.add(optionB);

		var optionC = document.createElement("option");
		optionC.text = "Sur/Norte";
		x.add(optionC);

	}
</script>

<script type="text/javascript">
	function llenacampoRes2() {
		var x = document.getElementById("basegrav");

		var option = document.createElement("option");
		option.text = "Valla en Vehiculos automotores con "
				+ "dimension superior a 8m2";
		x.add(option);

	}
</script>


<script type="text/javascript">
	function llenacampo2() {

		var x = document.getElementById("basegrav");

		var option = document.createElement("option");
		option.text = "Vallas de mas de 8 m2 hasta 24 m2";
		x.add(option);

		var optionA = document.createElement("option");
		optionA.text = "Vallas de mas de 24 m2";
		x.add(optionA);

		var optionB = document.createElement("option");
		optionB.text = "Vallas de propiedad de constructores de mas de 8 m2";
		x.add(optionB);

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