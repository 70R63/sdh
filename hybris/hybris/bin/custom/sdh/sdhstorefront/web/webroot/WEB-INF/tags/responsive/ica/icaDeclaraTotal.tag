<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.total.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>

<form:form action="">
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<td><label class="control-label text-capitalize !important"
								style="width: 100px;"><spring:theme
										code="ica.declaracion.total.vigencia" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.numide" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.nombre" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.codciudad" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.nomciudad" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.ciiu" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.valtotaliva" /></label></td>
							<td><label class="control-label text-capitalize !important"><spring:theme
										code="ica.declaracion.total.valtotaldev" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input class="inputtextnew" type="text"
								style="width: 100px;" /></td>
							<td><input class="inputtextnew" type="text" /></td>
							<td><input class="inputtextnew" type="text" disabled /></td>
							<td><input class="inputtextnew" type="text" /></td>
							<td><input class="inputtextnew" type="text" disabled /></td>
							<td><select id="" style="width: 150px;">
									<option value=" ">&nbsp;</option>
									<option
										value="111 - Cultivo de cereales (excepto arroz), legumbres y semillas oleaginosas">111
										- Cultivo de cereales (excepto arroz), legumbres y semillas
										oleaginosas</option>
									<option value="112 - Cultivo de arroz">112 - Cultivo
										de arroz</option>
									<option
										value="113 - Cultivo de hortalizas, ra�ces y tub�rculos">113
										- Cultivo de hortalizas, ra�ces y tub�rculos</option>
									<option value="114 - Cultivo de tabaco">114 - Cultivo
										de tabaco</option>
									<option value="115 - Cultivo de plantas textiles">115
										- Cultivo de plantas textiles</option>
									<option value="119 - Otros cultivos transitorios n.c.p.">119
										- Otros cultivos transitorios n.c.p.</option>
									<option
										value="121 - Cultivo de frutas tropicales y subtropicales">121
										- Cultivo de frutas tropicales y subtropicales</option>
									<option value="122 - Cultivo de pl�tano y banano">122
										- Cultivo de pl�tano y banano</option>
									<option value="123 - Cultivo de caf�">123 - Cultivo de
										caf�</option>
									<option value="124 - Cultivo de ca�a de az�car">124 -
										Cultivo de ca�a de az�car</option>
									<option value="125 - Cultivo de flor de corte">125 -
										Cultivo de flor de corte</option>
									<option
										value="126 - Cultivo de palma para aceite (palma africana) y otros frutos oleaginosos">126
										- Cultivo de palma para aceite (palma africana) y otros frutos
										oleaginosos</option>
									<option
										value="127 - Cultivo de plantas con las que se prepararan bebidas">127
										- Cultivo de plantas con las que se prepararan bebidas</option>
									<option
										value="128 - Cultivo de especias y de plantas arom�ticas y medicinales">128
										- Cultivo de especias y de plantas arom�ticas y medicinales</option>
									<option value="129 - Otros cultivos permanentes n.c.p.">129
										- Otros cultivos permanentes n.c.p.</option>
									<option
										value="130 - Propagaci�n de plantas (actividades de los viveros, excepto viveros forestales)">130
										- Propagaci�n de plantas (actividades de los viveros, excepto
										viveros forestales)</option>
									<option value="141 - Cr�a de ganado bovino y bufalino">141
										- Cr�a de ganado bovino y bufalino</option>
									<option value="142 - Cr�a de caballos y otros equinos">142
										- Cr�a de caballos y otros equinos</option>
									<option value="143 - Cr�a de ovejas y cabras">143 -
										Cr�a de ovejas y cabras</option>
									<option value="144 - Cr�a de ganado porcino">144 -
										Cr�a de ganado porcino</option>
									<option value="145 - Cr�a de aves de corral">145 -
										Cr�a de aves de corral</option>
									<option value="149 - Cr�a de otros animales n.c.p.">149
										- Cr�a de otros animales n.c.p.</option>
									<option
										value="150 - Explotaci�n primaria mixta (agr�cola y pecuaria)">150
										- Explotaci�n primaria mixta (agr�cola y pecuaria)</option>
									<option value="161 - Actividades de apoyo a la agricultura">161
										- Actividades de apoyo a la agricultura</option>
									<option value="162 - Actividades de apoyo a la ganader�a">162
										- Actividades de apoyo a la ganader�a</option>
									<option value="163 - Actividades posteriores a la cosecha">163
										- Actividades posteriores a la cosecha</option>
									<option value="164 - Tratamiento de semillas para propagaci�n">164
										- Tratamiento de semillas para propagaci�n</option>
									<option
										value="170 - Caza ordinaria y mediante trampas y actividades de servicios conexas">170
										- Caza ordinaria y mediante trampas y actividades de servicios
										conexas</option>
									<option
										value="210 - Silvicultura y otras actividades forestales">210
										- Silvicultura y otras actividades forestales</option>
									<option value="220 - Extracci�n de madera">220 -
										Extracci�n de madera</option>
									<option
										value="230 - Recolecci�n de productos forestales diferentes a la madera">230
										- Recolecci�n de productos forestales diferentes a la madera</option>
									<option value="240 - Servicios de apoyo a la silvicultura">240
										- Servicios de apoyo a la silvicultura</option>
									<option value="311 - Pesca mar�tima">311 - Pesca
										mar�tima</option>
									<option value="312 - Pesca de agua dulce">312 - Pesca
										de agua dulce</option>
									<option value="321 - Acuicultura mar�tima">321 -
										Acuicultura mar�tima</option>
									<option value="322 - Acuicultura de agua dulce">322 -
										Acuicultura de agua dulce</option>
									<option value="510 - Extracci�n de hulla (carb�n de piedra)">510
										- Extracci�n de hulla (carb�n de piedra)</option>
									<option value="520 - Extracci�n de carb�n lignito">520
										- Extracci�n de carb�n lignito</option>
									<option value="610 - Extracci�n de petr�leo crudo">610
										- Extracci�n de petr�leo crudo</option>
									<option value="620 - Extracci�n de gas natural">620 -
										Extracci�n de gas natural</option>
									<option value="710 - Extracci�n de minerales de hierro">710
										- Extracci�n de minerales de hierro</option>
									<option
										value="721 - Extracci�n de minerales de uranio y de torio">721
										- Extracci�n de minerales de uranio y de torio</option>
									<option
										value="722 - Extracci�n de oro y otros metales preciosos">722
										- Extracci�n de oro y otros metales preciosos</option>
									<option value="723 - Extracci�n de minerales de n�quel">723
										- Extracci�n de minerales de n�quel</option>
									<option
										value="729 - Extracci�n de otros minerales metal�feros no ferrosos n.c.p.">729
										- Extracci�n de otros minerales metal�feros no ferrosos n.c.p.</option>
									<option
										value="811 - Extracci�n de piedra, arena, arcillas comunes, yeso y anhidrita">811
										- Extracci�n de piedra, arena, arcillas comunes, yeso y
										anhidrita</option>
									<option
										value="812 - Extracci�n de arcillas de uso industrial, caliza, caol�n y bentonitas">812
										- Extracci�n de arcillas de uso industrial, caliza, caol�n y
										bentonitas</option>
									<option
										value="820 - Extracci�n de esmeraldas, piedras preciosas y semipreciosas">820
										- Extracci�n de esmeraldas, piedras preciosas y semipreciosas</option>
									<option
										value="891 - Extracci�n de minerales para la fabricaci�n de abonos y productos qu�micos">891
										- Extracci�n de minerales para la fabricaci�n de abonos y
										productos qu�micos</option>
									<option value="892 - Extracci�n de halita (sal)">892 -
										Extracci�n de halita (sal)</option>
									<option
										value="899 - Extracci�n de otros minerales no met�licos n.c.p.">899
										- Extracci�n de otros minerales no met�licos n.c.p.</option>
									<option
										value="910 - Actividades de apoyo para la extracci�n de petr�leo y de gas natural">910
										- Actividades de apoyo para la extracci�n de petr�leo y de gas
										natural</option>
									<option
										value="990 - Actividades de apoyo para otras actividades de explotaci�n de minas y canteras">990
										- Actividades de apoyo para otras actividades de explotaci�n
										de minas y canteras</option>
									<option
										value="1011 - Procesamiento y conservaci�n de carne y productos c�rnicos">1011
										- Procesamiento y conservaci�n de carne y productos c�rnicos</option>
									<option
										value="1012 - Procesamiento y conservaci�n de pescados, crust�ceos y moluscos">1012
										- Procesamiento y conservaci�n de pescados, crust�ceos y
										moluscos</option>
									<option
										value="1030 - Elaboraci�n de aceites y grasas de origen vegetal y animal">1030
										- Elaboraci�n de aceites y grasas de origen vegetal y animal</option>
									<option value="1051 - Elaboraci�n de productos de moliner�a">1051
										- Elaboraci�n de productos de moliner�a</option>
									<option
										value="1052 - Elaboraci�n de almidones y productos derivados del almid�n">1052
										- Elaboraci�n de almidones y productos derivados del almid�n</option>
									<option value="1061 - Trilla de caf�">1061 - Trilla de
										caf�</option>
									<option
										value="1062 - Descafeinado, tosti�n y molienda del caf�">1062
										- Descafeinado, tosti�n y molienda del caf�</option>
									<option value="1063 - Elaboraci�n de otros derivados del caf�">1063
										- Elaboraci�n de otros derivados del caf�</option>
									<option value="1071 - Elaboraci�n y refinaci�n de az�car">1071
										- Elaboraci�n y refinaci�n de az�car</option>
									<option value="1072 - Elaboraci�n de panela">1072 -
										Elaboraci�n de panela</option>
									<option value="1081 - Elaboraci�n de productos de panader�a">1081
										- Elaboraci�n de productos de panader�a</option>
									<option
										value="1082 - Elaboraci�n de cacao, chocolate y productos de confiter�a">1082
										- Elaboraci�n de cacao, chocolate y productos de confiter�a</option>
									<option
										value="1083 - Elaboraci�n de macarrones, fideos, alcuzcuz y productos farin�ceos similares">1083
										- Elaboraci�n de macarrones, fideos, alcuzcuz y productos
										farin�ceos similares</option>
									<option
										value="1084 - Elaboraci�n de comidas y platos preparados">1084
										- Elaboraci�n de comidas y platos preparados</option>
									<option
										value="1089 - Elaboraci�n de otros productos alimenticios n.c.p.">1089
										- Elaboraci�n de otros productos alimenticios n.c.p.</option>
									<option
										value="1090 - Elaboraci�n de alimentos preparados para animales">1090
										- Elaboraci�n de alimentos preparados para animales</option>
									<option
										value="1101 - Destilaci�n, rectificaci�n y mezcla de bebidas alcoh�licas">1101
										- Destilaci�n, rectificaci�n y mezcla de bebidas alcoh�licas</option>
									<option
										value="1102 - Elaboraci�n de bebidas fermentadas no destiladas">1102
										- Elaboraci�n de bebidas fermentadas no destiladas</option>
									<option
										value="1103 - Producci�n de malta, elaboraci�n de cervezas y otras bebidas malteadas">1103
										- Producci�n de malta, elaboraci�n de cervezas y otras bebidas
										malteadas</option>
									<option
										value="1104 - Elaboraci�n de bebidas no alcoh�licas, producci�n de aguas minerales y de otras aguas embotelladas">1104
										- Elaboraci�n de bebidas no alcoh�licas, producci�n de aguas
										minerales y de otras aguas embotelladas</option>
									<option value="1200 - Elaboraci�n de productos de tabaco">1200
										- Elaboraci�n de productos de tabaco</option>
									<option
										value="1311 - Preparaci�n e hilatura de fibras textiles">1311
										- Preparaci�n e hilatura de fibras textiles</option>
									<option value="1312 - Tejedur�a de productos textiles">1312
										- Tejedur�a de productos textiles</option>
									<option value="1313 - Acabado de productos textiles">1313
										- Acabado de productos textiles</option>
									<option
										value="1391 - Fabricaci�n de tejidos de punto y ganchillo">1391
										- Fabricaci�n de tejidos de punto y ganchillo</option>
									<option
										value="1392 - Confecci�n de art�culos con materiales textiles, excepto prendas de vestir">1392
										- Confecci�n de art�culos con materiales textiles, excepto
										prendas de vestir</option>
									<option
										value="1393 - Fabricaci�n de tapetes y alfombras para pisos">1393
										- Fabricaci�n de tapetes y alfombras para pisos</option>
									<option
										value="1394 - Fabricaci�n de cuerdas, cordeles, cables, bramantes y redes">1394
										- Fabricaci�n de cuerdas, cordeles, cables, bramantes y redes</option>
									<option
										value="1399 - Fabricaci�n de otros art�culos textiles n.c.p.">1399
										- Fabricaci�n de otros art�culos textiles n.c.p.</option>
									<option
										value="1410 - Confecci�n de prendas de vestir, excepto prendas de piel">1410
										- Confecci�n de prendas de vestir, excepto prendas de piel</option>
									<option
										value="1511 - Curtido y recurtido de cueros; recurtido y te�ido de pieles.">1511
										- Curtido y recurtido de cueros; recurtido y te�ido de pieles.</option>
									<option
										value="1512 - Fabricaci�n de art�culos de viaje, bolsos de mano y art�culos similares elaborados en cuero, y fabricaci�n de art�culos de talab">1512
										- Fabricaci�n de art�culos de viaje, bolsos de mano y
										art�culos similares elaborados en cuero, y fabricaci�n de
										art�culos de talab</option>
									<option
										value="1513 - Fabricaci�n de art�culos de viaje, bolsos de mano y art�culos similares; art�culos de talabarter�a y guarnicioner�a elaborados e">1513
										- Fabricaci�n de art�culos de viaje, bolsos de mano y
										art�culos similares; art�culos de talabarter�a y
										guarnicioner�a elaborados e</option>
									<option
										value="1521 - Fabricaci�n de calzado de cuero y piel, con cualquier tipo de suela">1521
										- Fabricaci�n de calzado de cuero y piel, con cualquier tipo
										de suela</option>
									<option
										value="1522 - Fabricaci�n de otros tipos de calzado, excepto calzado de cuero y piel">1522
										- Fabricaci�n de otros tipos de calzado, excepto calzado de
										cuero y piel</option>
									<option value="1523 - Fabricaci�n de partes del calzado">1523
										- Fabricaci�n de partes del calzado</option>
									<option
										value="1610 - Aserrado, acepillado e impregnaci�n de la madera">1610
										- Aserrado, acepillado e impregnaci�n de la madera</option>
									<option
										value="1620 - Fabricaci�n de hojas de madera para enchapado; fabricaci�n de tableros contrachapados, tableros laminados, tableros de part�cula">1620
										- Fabricaci�n de hojas de madera para enchapado; fabricaci�n
										de tableros contrachapados, tableros laminados, tableros de
										part�cula</option>
									<option
										value="1630 - Fabricaci�n de partes y piezas de madera, de carpinter�a y ebanister�a para la construcci�n y para edificios">1630
										- Fabricaci�n de partes y piezas de madera, de carpinter�a y
										ebanister�a para la construcci�n y para edificios</option>
									<option value="1640 - Fabricaci�n de recipientes de madera">1640
										- Fabricaci�n de recipientes de madera</option>
									<option
										value="1690 - Fabricaci�n de otros productos de madera; fabricaci�n de art�culos de corcho, cester�a y esparter�a">1690
										- Fabricaci�n de otros productos de madera; fabricaci�n de
										art�culos de corcho, cester�a y esparter�a</option>
									<option
										value="1701 - Fabricaci�n de pulpas (pastas) celul�sicas; papel y cart�n">1701
										- Fabricaci�n de pulpas (pastas) celul�sicas; papel y cart�n</option>
									<option
										value="1702 - Fabricaci�n de papel y cart�n ondulado (corrugado); fabricaci�n de envases, empaques y de embalajes de papel y cart�n.">1702
										- Fabricaci�n de papel y cart�n ondulado (corrugado);
										fabricaci�n de envases, empaques y de embalajes de papel y
										cart�n.</option>
									<option
										value="1709 - Fabricaci�n de otros art�culos de papel y cart�n">1709
										- Fabricaci�n de otros art�culos de papel y cart�n</option>
									<option value="1811 - Actividades de impresi�n">1811 -
										Actividades de impresi�n</option>
									<option
										value="1812 - Actividades de servicios relacionados con la impresi�n">1812
										- Actividades de servicios relacionados con la impresi�n</option>
									<option
										value="1820 - Producci�n de copias a partir de grabaciones originales">1820
										- Producci�n de copias a partir de grabaciones originales</option>
									<option
										value="1910 - Fabricaci�n de productos de hornos de coque">1910
										- Fabricaci�n de productos de hornos de coque</option>
									<option
										value="1921 - Fabricaci�n de productos de la refinaci�n del petr�leo">1921
										- Fabricaci�n de productos de la refinaci�n del petr�leo</option>
									<option value="1922 - Actividad de mezcla de combustibles">1922
										- Actividad de mezcla de combustibles</option>
									<option
										value="2011 - Fabricaci�n de sustancias y productos qu�micos b�sicos">2011
										- Fabricaci�n de sustancias y productos qu�micos b�sicos</option>
									<option
										value="2012 - Fabricaci�n de abonos y compuestos inorg�nicos nitrogenados">2012
										- Fabricaci�n de abonos y compuestos inorg�nicos nitrogenados</option>
									<option
										value="2013 - Fabricaci�n de pl�sticos en formas primarias">2013
										- Fabricaci�n de pl�sticos en formas primarias</option>
									<option
										value="2014 - Fabricaci�n de caucho sint�tico en formas primarias">2014
										- Fabricaci�n de caucho sint�tico en formas primarias</option>
									<option
										value="2021 - Fabricaci�n de plaguicidas y otros productos qu�micos de uso agropecuario">2021
										- Fabricaci�n de plaguicidas y otros productos qu�micos de uso
										agropecuario</option>
									<option
										value="2022 - Fabricaci�n de pinturas, barnices y revestimientos similares, tintas para impresi�n y masillas">2022
										- Fabricaci�n de pinturas, barnices y revestimientos
										similares, tintas para impresi�n y masillas</option>
									<option
										value="2023 - Fabricaci�n de jabones y detergentes, preparados para limpiar y pulir; perfumes y preparados de tocador">2023
										- Fabricaci�n de jabones y detergentes, preparados para
										limpiar y pulir; perfumes y preparados de tocador</option>
									<option
										value="2029 - Fabricaci�n de otros productos qu�micos n.c.p.">2029
										- Fabricaci�n de otros productos qu�micos n.c.p.</option>
									<option
										value="2030 - Fabricaci�n de fibras sint�ticas y artificiales">2030
										- Fabricaci�n de fibras sint�ticas y artificiales</option>
									<option
										value="2100 - Fabricaci�n de productos farmac�uticos, sustancias qu�micas medicinales y productos bot�nicos de uso farmac�utico">2100
										- Fabricaci�n de productos farmac�uticos, sustancias qu�micas
										medicinales y productos bot�nicos de uso farmac�utico</option>
									<option
										value="2211 - Fabricaci�n de llantas y neum�ticos de caucho">2211
										- Fabricaci�n de llantas y neum�ticos de caucho</option>
									<option value="2212 - Reencauche de llantas usadas">2212
										- Reencauche de llantas usadas</option>
									<option
										value="2219 - Fabricaci�n de formas b�sicas de caucho y otros productos de caucho n.c.p.">2219
										- Fabricaci�n de formas b�sicas de caucho y otros productos de
										caucho n.c.p.</option>
									<option
										value="2221 - Fabricaci�n de formas b�sicas de pl�stico">2221
										- Fabricaci�n de formas b�sicas de pl�stico</option>
									<option
										value="2229 - Fabricaci�n de art�culos de pl�stico n.c.p.">2229
										- Fabricaci�n de art�culos de pl�stico n.c.p.</option>
									<option
										value="2310 - Fabricaci�n de vidrio y productos de vidrio">2310
										- Fabricaci�n de vidrio y productos de vidrio</option>
									<option value="2391 - Fabricaci�n de productos refractarios">2391
										- Fabricaci�n de productos refractarios</option>
									<option
										value="2392 - Fabricaci�n de materiales de arcilla para la construcci�n">2392
										- Fabricaci�n de materiales de arcilla para la construcci�n</option>
									<option
										value="2393 - Fabricaci�n de otros productos de cer�mica y porcelana">2393
										- Fabricaci�n de otros productos de cer�mica y porcelana</option>
									<option value="2394 - Fabricaci�n de cemento, cal y yeso">2394
										- Fabricaci�n de cemento, cal y yeso</option>
									<option
										value="2395 - Fabricaci�n de art�culos de hormig�n, cemento y yeso">2395
										- Fabricaci�n de art�culos de hormig�n, cemento y yeso</option>
									<option value="2396 - Corte, tallado y acabado de la piedra">2396
										- Corte, tallado y acabado de la piedra</option>
									<option
										value="2399 - Fabricaci�n de otros productos minerales no met�licos n.c.p.">2399
										- Fabricaci�n de otros productos minerales no met�licos n.c.p.</option>
									<option value="2410 - Industrias b�sicas de hierro y de acero">2410
										- Industrias b�sicas de hierro y de acero</option>
									<option value="2421 - Industrias b�sicas de metales preciosos">2421
										- Industrias b�sicas de metales preciosos</option>
									<option
										value="2429 - Industrias b�sicas de otros metales no ferrosos">2429
										- Industrias b�sicas de otros metales no ferrosos</option>
									<option value="2431 - Fundici�n de hierro y de acero">2431
										- Fundici�n de hierro y de acero</option>
									<option value="2432 - Fundici�n de metales no ferrosos">2432
										- Fundici�n de metales no ferrosos</option>
									<option
										value="2511 - Fabricaci�n de productos met�licos para uso estructural">2511
										- Fabricaci�n de productos met�licos para uso estructural</option>
									<option
										value="2512 - Fabricaci�n de tanques, dep�sitos y recipientes de metal, excepto los utilizados para el envase o transporte de mercanc�as">2512
										- Fabricaci�n de tanques, dep�sitos y recipientes de metal,
										excepto los utilizados para el envase o transporte de
										mercanc�as</option>
									<option
										value="2513 - Fabricaci�n de generadores de vapor, excepto calderas de agua caliente para calefacci�n central">2513
										- Fabricaci�n de generadores de vapor, excepto calderas de
										agua caliente para calefacci�n central</option>
									<option value="2520 - Fabricaci�n de armas y municiones">2520
										- Fabricaci�n de armas y municiones</option>
									<option
										value="2591 - Forja, prensado, estampado y laminado de metal; pulvimetalurgia">2591
										- Forja, prensado, estampado y laminado de metal;
										pulvimetalurgia</option>
									<option
										value="2592 - Tratamiento y revestimiento de metales; mecanizado">2592
										- Tratamiento y revestimiento de metales; mecanizado</option>
									<option
										value="2593 - Fabricaci�n de art�culos de cuchiller�a, herramientas de mano y art�culos de ferreter�a">2593
										- Fabricaci�n de art�culos de cuchiller�a, herramientas de
										mano y art�culos de ferreter�a</option>
									<option
										value="2599 - Fabricaci�n de otros productos elaborados de metal n.c.p.">2599
										- Fabricaci�n de otros productos elaborados de metal n.c.p.</option>
									<option
										value="2610 - Fabricaci�n de componentes y tableros electr�nicos">2610
										- Fabricaci�n de componentes y tableros electr�nicos</option>
									<option
										value="2620 - Fabricaci�n de computadoras y de equipo perif�rico">2620
										- Fabricaci�n de computadoras y de equipo perif�rico</option>
									<option value="2630 - Fabricaci�n de equipos de comunicaci�n">2630
										- Fabricaci�n de equipos de comunicaci�n</option>
									<option
										value="2640 - Fabricaci�n de aparatos electr�nicos de consumo">2640
										- Fabricaci�n de aparatos electr�nicos de consumo</option>
									<option
										value="2651 - Fabricaci�n de equipo de medici�n, prueba, navegaci�n y control">2651
										- Fabricaci�n de equipo de medici�n, prueba, navegaci�n y
										control</option>
									<option value="2652 - Fabricaci�n de relojes">2652 -
										Fabricaci�n de relojes</option>
									<option
										value="2660 - Fabricaci�n de equipo de irradiaci�n y equipo electr�nico de uso m�dico y terap�utico">2660
										- Fabricaci�n de equipo de irradiaci�n y equipo electr�nico de
										uso m�dico y terap�utico</option>
									<option
										value="2670 - Fabricaci�n de instrumentos �pticos y equipo fotogr�fico">2670
										- Fabricaci�n de instrumentos �pticos y equipo fotogr�fico</option>
									<option
										value="2680 - Fabricaci�n de soportes magn�ticos y �pticos">2680
										- Fabricaci�n de soportes magn�ticos y �pticos</option>
									<option
										value="2711 - Fabricaci�n de motores, generadores y transformadores el�ctricos.">2711
										- Fabricaci�n de motores, generadores y transformadores
										el�ctricos.</option>
									<option
										value="2712 - Fabricaci�n de aparatos de distribuci�n y control de la energ�a el�ctrica">2712
										- Fabricaci�n de aparatos de distribuci�n y control de la
										energ�a el�ctrica</option>
									<option
										value="2720 - Fabricaci�n de pilas, bater�as y acumuladores el�ctricos">2720
										- Fabricaci�n de pilas, bater�as y acumuladores el�ctricos</option>
									<option
										value="2731 - Fabricaci�n de hilos y cables el�ctricos y de fibra �ptica">2731
										- Fabricaci�n de hilos y cables el�ctricos y de fibra �ptica</option>
									<option value="2732 - Fabricaci�n de dispositivos de cableado">2732
										- Fabricaci�n de dispositivos de cableado</option>
									<option
										value="2740 - Fabricaci�n de equipos el�ctricos de iluminaci�n">2740
										- Fabricaci�n de equipos el�ctricos de iluminaci�n</option>
									<option value="2750 - Fabricaci�n de aparatos de uso domestico">2750
										- Fabricaci�n de aparatos de uso domestico</option>
									<option
										value="2790 - Fabricaci�n de otros tipos de equipo el�ctrico n.c.p.">2790
										- Fabricaci�n de otros tipos de equipo el�ctrico n.c.p.</option>
									<option
										value="2811 - Fabricaci�n de motores, turbinas, y partes para motores de combusti�n interna">2811
										- Fabricaci�n de motores, turbinas, y partes para motores de
										combusti�n interna</option>
									<option
										value="2812 - Fabricaci�n de equipos de potencia hidr�ulica y neum�tica">2812
										- Fabricaci�n de equipos de potencia hidr�ulica y neum�tica</option>
									<option
										value="2813 - Fabricaci�n de otras bombas, compresores, grifos y v�lvulas">2813
										- Fabricaci�n de otras bombas, compresores, grifos y v�lvulas</option>
									<option
										value="2814 - Fabricaci�n de cojinetes, engranajes, trenes de engranajes y piezas de transmisi�n">2814
										- Fabricaci�n de cojinetes, engranajes, trenes de engranajes y
										piezas de transmisi�n</option>
									<option
										value="2815 - Fabricaci�n de hornos, hogares y quemadores industriales">2815
										- Fabricaci�n de hornos, hogares y quemadores industriales</option>
									<option
										value="2816 - Fabricaci�n de equipo de elevaci�n y manipulaci�n">2816
										- Fabricaci�n de equipo de elevaci�n y manipulaci�n</option>
									<option
										value="2817 - Fabricaci�n de maquinaria y equipo de oficina (excepto computadoras y equipo perif�rico)">2817
										- Fabricaci�n de maquinaria y equipo de oficina (excepto
										computadoras y equipo perif�rico)</option>
									<option
										value="2818 - Fabricaci�n de herramientas manuales con motor">2818
										- Fabricaci�n de herramientas manuales con motor</option>
									<option
										value="2819 - Fabricaci�n de otros tipos de maquinaria y equipo de uso general n.c.p.">2819
										- Fabricaci�n de otros tipos de maquinaria y equipo de uso
										general n.c.p.</option>
									<option
										value="2821 - Fabricaci�n de maquinaria agropecuaria y forestal">2821
										- Fabricaci�n de maquinaria agropecuaria y forestal</option>
									<option
										value="2822 - Fabricaci�n de m�quinas formadoras de metal y de m�quinas herramienta">2822
										- Fabricaci�n de m�quinas formadoras de metal y de m�quinas
										herramienta</option>
									<option
										value="2823 - Fabricaci�n de maquinaria para la metalurgia">2823
										- Fabricaci�n de maquinaria para la metalurgia</option>
									<option
										value="2824 - Fabricaci�n de maquinaria para explotaci�n de minas y canteras y para obras de construcci�n">2824
										- Fabricaci�n de maquinaria para explotaci�n de minas y
										canteras y para obras de construcci�n</option>
									<option
										value="2825 - Fabricaci�n de maquinaria para la elaboraci�n de alimentos, bebidas y tabaco">2825
										- Fabricaci�n de maquinaria para la elaboraci�n de alimentos,
										bebidas y tabaco</option>
									<option
										value="2826 - Fabricaci�n de maquinaria para la elaboraci�n de productos textiles, prendas de vestir y cueros">2826
										- Fabricaci�n de maquinaria para la elaboraci�n de productos
										textiles, prendas de vestir y cueros</option>
									<option
										value="2829 - Fabricaci�n de otros tipos de maquinaria y equipo de uso especial n.c.p.">2829
										- Fabricaci�n de otros tipos de maquinaria y equipo de uso
										especial n.c.p.</option>
									<option
										value="2910 - Fabricaci�n de veh�culos automotores y sus motores">2910
										- Fabricaci�n de veh�culos automotores y sus motores</option>
									<option
										value="2920 - Fabricaci�n de carrocer�as para veh�culos automotores; fabricaci�n de remolques y semirremolques">2920
										- Fabricaci�n de carrocer�as para veh�culos automotores;
										fabricaci�n de remolques y semirremolques</option>
									<option
										value="2930 - Fabricaci�n de partes, piezas (autopartes) y accesorios (lujos) para veh�culos automotores">2930
										- Fabricaci�n de partes, piezas (autopartes) y accesorios
										(lujos) para veh�culos automotores</option>
									<option
										value="3011 - Construcci�n de barcos y de estructuras flotantes">3011
										- Construcci�n de barcos y de estructuras flotantes</option>
									<option
										value="3012 - Construcci�n de embarcaciones de recreo y deporte">3012
										- Construcci�n de embarcaciones de recreo y deporte</option>
									<option
										value="3020 - Fabricaci�n de locomotoras y de material rodante para ferrocarriles">3020
										- Fabricaci�n de locomotoras y de material rodante para
										ferrocarriles</option>
									<option
										value="3030 - Fabricaci�n de aeronaves, naves espaciales y de maquinaria conexa">3030
										- Fabricaci�n de aeronaves, naves espaciales y de maquinaria
										conexa</option>
									<option
										value="3040 - Fabricaci�n de veh�culos militares de combate">3040
										- Fabricaci�n de veh�culos militares de combate</option>
									<option value="3091 - Fabricaci�n de motocicletas">3091
										- Fabricaci�n de motocicletas</option>
									<option
										value="3092 - Fabricaci�n de bicicletas y de sillas de ruedas para personas con discapacidad">3092
										- Fabricaci�n de bicicletas y de sillas de ruedas para
										personas con discapacidad</option>
									<option
										value="3099 - Fabricaci�n de otros tipos de equipo de transporte n.c.p.">3099
										- Fabricaci�n de otros tipos de equipo de transporte n.c.p.</option>
									<option value="3110 - Fabricaci�n de muebles">3110 -
										Fabricaci�n de muebles</option>
									<option value="3120 - Fabricaci�n de colchones y somieres">3120
										- Fabricaci�n de colchones y somieres</option>
									<option
										value="3210 - Fabricaci�n de joyas, bisuter�a y art�culos conexos">3210
										- Fabricaci�n de joyas, bisuter�a y art�culos conexos</option>
									<option value="3220 - Fabricaci�n de instrumentos musicales">3220
										- Fabricaci�n de instrumentos musicales</option>
									<option
										value="3230 - Fabricaci�n de art�culos y equipo para la pr�ctica del deporte   (excepto prendas de vestir y calzado)">3230
										- Fabricaci�n de art�culos y equipo para la pr�ctica del
										deporte&nbsp;&nbsp; (excepto prendas de vestir y calzado)</option>
									<option
										value="3240 - Fabricaci�n de juegos, juguetes y rompecabezas">3240
										- Fabricaci�n de juegos, juguetes y rompecabezas</option>
									<option
										value="3250 - Fabricaci�n de instrumentos, aparatos y materiales m�dicos y odontol�gicos (incluido mobiliario)">3250
										- Fabricaci�n de instrumentos, aparatos y materiales m�dicos y
										odontol�gicos (incluido mobiliario)</option>
									<option value="3290 - Otras industrias manufactureras n.c.p.">3290
										- Otras industrias manufactureras n.c.p.</option>
									<option
										value="3311 - Mantenimiento y reparaci�n especializado de productos elaborados en metal">3311
										- Mantenimiento y reparaci�n especializado de productos
										elaborados en metal</option>
									<option
										value="3312 - Mantenimiento y reparaci�n especializado de maquinaria y equipo">3312
										- Mantenimiento y reparaci�n especializado de maquinaria y
										equipo</option>
									<option
										value="3313 - Mantenimiento y reparaci�n especializado de equipo electr�nico y �ptico">3313
										- Mantenimiento y reparaci�n especializado de equipo
										electr�nico y �ptico</option>
									<option
										value="3314 - Mantenimiento y reparaci�n especializado de equipo el�ctrico">3314
										- Mantenimiento y reparaci�n especializado de equipo el�ctrico</option>
									<option
										value="3315 - Mantenimiento y reparaci�n especializado de equipo de transporte, excepto los veh�culos automotores, motocicletas y bicicletas">3315
										- Mantenimiento y reparaci�n especializado de equipo de
										transporte, excepto los veh�culos automotores, motocicletas y
										bicicletas</option>
									<option
										value="3319 - Mantenimiento y reparaci�n de otros tipos de equipos y sus componentes n.c.p.">3319
										- Mantenimiento y reparaci�n de otros tipos de equipos y sus
										componentes n.c.p.</option>
									<option
										value="3320 - Instalaci�n especializada de maquinaria y equipo industrial">3320
										- Instalaci�n especializada de maquinaria y equipo industrial</option>
									<option value="3511 - Generaci�n de energ�a el�ctrica">3511
										- Generaci�n de energ�a el�ctrica</option>
									<option value="3512 - Transmisi�n de energ�a el�ctrica">3512
										- Transmisi�n de energ�a el�ctrica</option>
									<option value="3513 - Distribuci�n de energ�a el�ctrica">3513
										- Distribuci�n de energ�a el�ctrica</option>
									<option value="3514 - Comercializaci�n de energ�a el�ctrica">3514
										- Comercializaci�n de energ�a el�ctrica</option>
									<option value="3530 - Suministro de vapor y aire acondicionado">3530
										- Suministro de vapor y aire acondicionado</option>
									<option
										value="3700 - Evacuaci�n y tratamiento de aguas residuales">3700
										- Evacuaci�n y tratamiento de aguas residuales</option>
									<option value="3811 - Recolecci�n de desechos no peligrosos">3811
										- Recolecci�n de desechos no peligrosos</option>
									<option value="3812 - Recolecci�n de desechos peligrosos">3812
										- Recolecci�n de desechos peligrosos</option>
									<option
										value="3821 - Tratamiento y disposici�n de desechos no peligrosos">3821
										- Tratamiento y disposici�n de desechos no peligrosos</option>
									<option
										value="3822 - Tratamiento y disposici�n de desechos peligrosos">3822
										- Tratamiento y disposici�n de desechos peligrosos</option>
									<option value="3830 - Recuperaci�n de materiales">3830
										- Recuperaci�n de materiales</option>
									<option value="4111 - Construcci�n de edificios residenciales">4111
										- Construcci�n de edificios residenciales</option>
									<option
										value="4112 - Construcci�n de edificios no residenciales">4112
										- Construcci�n de edificios no residenciales</option>
									<option
										value="4210 - Construcci�n de carreteras y v�as de ferrocarril">4210
										- Construcci�n de carreteras y v�as de ferrocarril</option>
									<option
										value="4220 - Construcci�n de proyectos de servicio p�blico">4220
										- Construcci�n de proyectos de servicio p�blico</option>
									<option
										value="4290 - Construcci�n de otras obras de ingenier�a civil">4290
										- Construcci�n de otras obras de ingenier�a civil</option>
									<option value="4311 - Demolici�n">4311 - Demolici�n</option>
									<option value="4312 - Preparaci�n del terreno">4312 -
										Preparaci�n del terreno</option>
									<option
										value="4321 - Instalaciones el�ctricas de la construcci�n">4321
										- Instalaciones el�ctricas de la construcci�n</option>
									<option
										value="4322 - Instalaciones de fontaner�a, calefacci�n y aire acondicionado de la construcci�n">4322
										- Instalaciones de fontaner�a, calefacci�n y aire
										acondicionado de la construcci�n</option>
									<option
										value="4329 - Otras instalaciones especializadas de la construcci�n">4329
										- Otras instalaciones especializadas de la construcci�n</option>
									<option
										value="4330 - Terminaci�n y acabado de edificios y obras de ingenier�a civil">4330
										- Terminaci�n y acabado de edificios y obras de ingenier�a
										civil</option>
									<option
										value="4390 - Otras actividades especializadas para la construcci�n de edificios y obras de ingenier�a civil">4390
										- Otras actividades especializadas para la construcci�n de
										edificios y obras de ingenier�a civil</option>
									<option value="4511 - Comercio de veh�culos automotores nuevos">4511
										- Comercio de veh�culos automotores nuevos</option>
									<option value="4512 - Comercio de veh�culos automotores usados">4512
										- Comercio de veh�culos automotores usados</option>
									<option
										value="4520 - Mantenimiento y reparaci�n de veh�culos automotores.">4520
										- Mantenimiento y reparaci�n de veh�culos automotores.</option>
									<option
										value="4530 - Comercio de partes, piezas (autopartes) y accesorios (lujos) para veh�culos automotores">4530
										- Comercio de partes, piezas (autopartes) y accesorios (lujos)
										para veh�culos automotores</option>
									<option
										value="4542 - Mantenimiento y reparaci�n de motocicletas y de sus partes y piezas">4542
										- Mantenimiento y reparaci�n de motocicletas y de sus partes y
										piezas</option>
									<option
										value="4610 - Comercio al por mayor a cambio de una retribuci�n o por contrata">4610
										- Comercio al por mayor a cambio de una retribuci�n o por
										contrata</option>
									<option
										value="4631 - Comercio al por mayor de productos alimenticios">4631
										- Comercio al por mayor de productos alimenticios</option>
									<option
										value="4641 - Comercio al por mayor de productos textiles y productos confeccionados para uso dom�stico">4641
										- Comercio al por mayor de productos textiles y productos
										confeccionados para uso dom�stico</option>
									<option
										value="4642 - Comercio al por mayor de prendas de vestir">4642
										- Comercio al por mayor de prendas de vestir</option>
									<option value="4643 - Comercio al por mayor de calzado">4643
										- Comercio al por mayor de calzado</option>
									<option
										value="4644 - Comercio al por mayor de aparatos y equipo de uso dom�stico">4644
										- Comercio al por mayor de aparatos y equipo de uso dom�stico</option>
									<option
										value="4651 - Comercio al por mayor de computadores, equipo perif�rico y programas de inform�tica">4651
										- Comercio al por mayor de computadores, equipo perif�rico y
										programas de inform�tica</option>
									<option
										value="4652 - Comercio al por mayor de equipo, partes y piezas electr�nicos y de telecomunicaciones">4652
										- Comercio al por mayor de equipo, partes y piezas
										electr�nicos y de telecomunicaciones</option>
									<option
										value="4653 - Comercio al por mayor de maquinaria y equipo agropecuarios">4653
										- Comercio al por mayor de maquinaria y equipo agropecuarios</option>
									<option
										value="4659 - Comercio al por mayor de otros tipos de maquinaria y equipo n.c.p.">4659
										- Comercio al por mayor de otros tipos de maquinaria y equipo
										n.c.p.</option>
									<option
										value="4662 - Comercio al por mayor de metales y productos metal�feros">4662
										- Comercio al por mayor de metales y productos metal�feros</option>
									<option
										value="4664 - Comercio al por mayor de productos qu�micos b�sicos, cauchos y pl�sticos en formas primarias y productos qu�micos de uso agropec">4664
										- Comercio al por mayor de productos qu�micos b�sicos, cauchos
										y pl�sticos en formas primarias y productos qu�micos de uso
										agropec</option>
									<option
										value="4665 - Comercio al por mayor de desperdicios, desechos y chatarra">4665
										- Comercio al por mayor de desperdicios, desechos y chatarra</option>
									<option
										value="4669 - Comercio al por mayor de otros productos n.c.p.">4669
										- Comercio al por mayor de otros productos n.c.p.</option>
									<option value="4690 - Comercio al por mayor no especializado">4690
										- Comercio al por mayor no especializado</option>
									<option
										value="4721 - Comercio al por menor de productos agr�colas para el consumo en establecimientos especializados">4721
										- Comercio al por menor de productos agr�colas para el consumo
										en establecimientos especializados</option>
									<option
										value="4722 - Comercio al por menor de leche, productos l�cteos y huevos, en establecimientos especializados">4722
										- Comercio al por menor de leche, productos l�cteos y huevos,
										en establecimientos especializados</option>
									<option
										value="4723 - Comercio al por menor de carnes (incluye aves de corral), productos c�rnicos, pescados y productos de mar, en establecimientos e">4723
										- Comercio al por menor de carnes (incluye aves de corral),
										productos c�rnicos, pescados y productos de mar, en
										establecimientos e</option>
									<option
										value="4729 - Comercio al por menor de otros productos alimenticios n.c.p., en establecimientos especializados">4729
										- Comercio al por menor de otros productos alimenticios
										n.c.p., en establecimientos especializados</option>
									<option
										value="4731 - Comercio al por menor de combustible para automotores">4731
										- Comercio al por menor de combustible para automotores</option>
									<option
										value="4732 - Comercio al por menor de lubricantes (aceites, grasas), aditivos y productos de limpieza para veh�culos automotores">4732
										- Comercio al por menor de lubricantes (aceites, grasas),
										aditivos y productos de limpieza para veh�culos automotores</option>
									<option
										value="4741 - Comercio al por menor de computadores, equipos perif�ricos, programas de inform�tica y equipos de telecomunicaciones en establec">4741
										- Comercio al por menor de computadores, equipos perif�ricos,
										programas de inform�tica y equipos de telecomunicaciones en
										establec</option>
									<option
										value="4742 - Comercio al por menor de equipos y aparatos de sonido y de video, en establecimientos especializados">4742
										- Comercio al por menor de equipos y aparatos de sonido y de
										video, en establecimientos especializados</option>
									<option
										value="4751 - Comercio al por menor de productos textiles en establecimientos especializados">4751
										- Comercio al por menor de productos textiles en
										establecimientos especializados</option>
									<option
										value="4753 - Comercio al por menor de tapices, alfombras y cubrimientos para paredes y pisos en establecimientos especializados.">4753
										- Comercio al por menor de tapices, alfombras y cubrimientos
										para paredes y pisos en establecimientos especializados.</option>
									<option
										value="4754 - Comercio al por menor de electrodom�sticos y gasodomesticos de uso dom�stico, muebles y equipos de iluminaci�n">4754
										- Comercio al por menor de electrodom�sticos y gasodomesticos
										de uso dom�stico, muebles y equipos de iluminaci�n</option>
									<option
										value="4755 - Comercio al por menor de art�culos y utensilios de uso domestico">4755
										- Comercio al por menor de art�culos y utensilios de uso
										domestico</option>
									<option
										value="4759 - Comercio al por menor de otros art�culos dom�sticos en establecimientos especializados">4759
										- Comercio al por menor de otros art�culos dom�sticos en
										establecimientos especializados</option>
									<option
										value="4762 - Comercio al por menor de art�culos deportivos, en establecimientos especializados">4762
										- Comercio al por menor de art�culos deportivos, en
										establecimientos especializados</option>
									<option
										value="4769 - Comercio al por menor de otros art�culos culturales y de entretenimiento n.c.p. en establecimientos especializados">4769
										- Comercio al por menor de otros art�culos culturales y de
										entretenimiento n.c.p. en establecimientos especializados</option>
									<option
										value="4771 - Comercio al por menor de prendas de vestir y sus accesorios (incluye art�culos de piel) en establecimientos especializados">4771
										- Comercio al por menor de prendas de vestir y sus accesorios
										(incluye art�culos de piel) en establecimientos especializados</option>
									<option
										value="4772 - Comercio al por menor de todo tipo de calzado y art�culos de cuero y suced�neos del cuero en establecimientos especializados.">4772
										- Comercio al por menor de todo tipo de calzado y art�culos de
										cuero y suced�neos del cuero en establecimientos
										especializados.</option>
									<option
										value="4774 - Comercio al por menor de otros productos nuevos en establecimientos especializados">4774
										- Comercio al por menor de otros productos nuevos en
										establecimientos especializados</option>
									<option
										value="4775 - Comercio al por menor de art�culos de segunda mano">4775
										- Comercio al por menor de art�culos de segunda mano</option>
									<option
										value="4782 - Comercio al por menor de productos textiles, prendas de vestir y calzado, en puestos de venta m�viles">4782
										- Comercio al por menor de productos textiles, prendas de
										vestir y calzado, en puestos de venta m�viles</option>
									<option
										value="4789 - Comercio al por menor de otros productos en puestos de venta m�viles">4789
										- Comercio al por menor de otros productos en puestos de venta
										m�viles</option>
									<option value="4911 - Transporte f�rreo de pasajeros">4911
										- Transporte f�rreo de pasajeros</option>
									<option value="4912 - Transporte f�rreo de carga">4912
										- Transporte f�rreo de carga</option>
									<option value="4921 - Transporte de pasajeros">4921 -
										Transporte de pasajeros</option>
									<option value="4922 - Transporte mixto">4922 -
										Transporte mixto</option>
									<option value="4923 - Transporte de carga por carretera">4923
										- Transporte de carga por carretera</option>
									<option value="4930 - Transporte por tuber�as">4930 -
										Transporte por tuber�as</option>
									<option
										value="5011 - Transporte de pasajeros mar�timo y de cabotaje">5011
										- Transporte de pasajeros mar�timo y de cabotaje</option>
									<option
										value="5012 - Transporte de carga mar�timo y de cabotaje">5012
										- Transporte de carga mar�timo y de cabotaje</option>
									<option value="5021 - Transporte fluvial de pasajeros">5021
										- Transporte fluvial de pasajeros</option>
									<option value="5022 - Transporte fluvial de carga">5022
										- Transporte fluvial de carga</option>
									<option value="5111 - Transporte a�reo nacional de pasajeros">5111
										- Transporte a�reo nacional de pasajeros</option>
									<option
										value="5112 - Transporte a�reo internacional de pasajeros">5112
										- Transporte a�reo internacional de pasajeros</option>
									<option value="5121 - Transporte a�reo nacional de carga">5121
										- Transporte a�reo nacional de carga</option>
									<option value="5122 - Transporte a�reo internacional de carga">5122
										- Transporte a�reo internacional de carga</option>
									<option value="5210 - Almacenamiento y dep�sito">5210
										- Almacenamiento y dep�sito</option>
									<option
										value="5221 - Actividades de estaciones, v�as y servicios complementarios para el transporte terrestre">5221
										- Actividades de estaciones, v�as y servicios complementarios
										para el transporte terrestre</option>
									<option
										value="5222 - Actividades de puertos y servicios complementarios para el transporte acu�tico">5222
										- Actividades de puertos y servicios complementarios para el
										transporte acu�tico</option>
									<option
										value="5223 - Actividades de aeropuertos, servicios de navegaci�n a�rea y dem�s actividades conexas al transporte a�reo">5223
										- Actividades de aeropuertos, servicios de navegaci�n a�rea y
										dem�s actividades conexas al transporte a�reo</option>
									<option value="5224 - Manipulaci�n de carga">5224 -
										Manipulaci�n de carga</option>
									<option
										value="5229 - Otras actividades complementarias al transporte">5229
										- Otras actividades complementarias al transporte</option>
									<option value="5310 - Actividades postales nacionales">5310
										- Actividades postales nacionales</option>
									<option value="5320 - Actividades de mensajer�a">5320
										- Actividades de mensajer�a</option>
									<option value="5511 - Alojamiento en hoteles">5511 -
										Alojamiento en hoteles</option>
									<option value="5512 - Alojamiento en aparta-hoteles">5512
										- Alojamiento en aparta-hoteles</option>
									<option value="5513 - Alojamiento en centros vacacionales">5513
										- Alojamiento en centros vacacionales</option>
									<option value="5514 - Alojamiento rural">5514 -
										Alojamiento rural</option>
									<option
										value="5519 - Otros tipos de alojamientos para visitantes">5519
										- Otros tipos de alojamientos para visitantes</option>
									<option
										value="5520 - Actividades de zonas de camping y parques para veh�culos recreacionales">5520
										- Actividades de zonas de camping y parques para veh�culos
										recreacionales</option>
									<option value="5530 - Servicio por horas  de alojamiento">5530
										- Servicio por horas&nbsp; de alojamiento</option>
									<option value="5590 - Otros tipos de alojamiento n.c.p.">5590
										- Otros tipos de alojamiento n.c.p.</option>
									<option value="5611 - Expendio a la mesa de comidas preparadas">5611
										- Expendio a la mesa de comidas preparadas</option>
									<option
										value="5612 - Expendio por autoservicio de comidas preparadas">5612
										- Expendio por autoservicio de comidas preparadas</option>
									<option
										value="5613 - Expendio de comidas preparadas en cafeter�as">5613
										- Expendio de comidas preparadas en cafeter�as</option>
									<option
										value="5619 - Otros tipos de expendio de comidas preparadas n.c.p.">5619
										- Otros tipos de expendio de comidas preparadas n.c.p.</option>
									<option value="5621 - Catering para eventos">5621 -
										Catering para eventos</option>
									<option
										value="5629 - Actividades de otros servicios de comidas">5629
										- Actividades de otros servicios de comidas</option>
									<option
										value="5630 - Expendio de bebidas alcoh�licas para el consumo dentro del establecimiento">5630
										- Expendio de bebidas alcoh�licas para el consumo dentro del
										establecimiento</option>
									<option
										value="5812 - Edici�n de directorios y listas de correo">5812
										- Edici�n de directorios y listas de correo</option>
									<option
										value="5813 - Edici�n de peri�dicos, revistas y otras publicaciones peri�dicas">5813
										- Edici�n de peri�dicos, revistas y otras publicaciones
										peri�dicas</option>
									<option value="5819 - Otros trabajos de edici�n">5819
										- Otros trabajos de edici�n</option>
									<option
										value="5820 - Edici�n de programas de inform�tica (software)">5820
										- Edici�n de programas de inform�tica (software)</option>
									<option
										value="5911 - Actividades de producci�n de pel�culas cinematogr�ficas, videos, programas, anuncios y comerciales de televisi�n (excepto progra">5911
										- Actividades de producci�n de pel�culas cinematogr�ficas,
										videos, programas, anuncios y comerciales de televisi�n
										(excepto progra</option>
									<option
										value="5912 - Actividades de postproducci�n de pel�culas cinematogr�ficas, videos, programas, anuncios y comerciales de televisi�n  (excepto p">5912
										- Actividades de postproducci�n de pel�culas cinematogr�ficas,
										videos, programas, anuncios y comerciales de televisi�n&nbsp;
										(excepto p</option>
									<option
										value="5913 - Actividades de distribuci�n de pel�culas cinematogr�ficas, videos, programas, anuncios y comerciales de televisi�n">5913
										- Actividades de distribuci�n de pel�culas cinematogr�ficas,
										videos, programas, anuncios y comerciales de televisi�n</option>
									<option
										value="5914 - Actividades de exhibici�n de pel�culas cinematogr�ficas y videos">5914
										- Actividades de exhibici�n de pel�culas cinematogr�ficas y
										videos</option>
									<option
										value="5920 - Actividades de grabaci�n de sonido y edici�n de m�sica">5920
										- Actividades de grabaci�n de sonido y edici�n de m�sica</option>
									<option
										value="6010 - Actividades de programaci�n y transmisi�n en el servicio de radiodifusi�n sonora">6010
										- Actividades de programaci�n y transmisi�n en el servicio de
										radiodifusi�n sonora</option>
									<option
										value="6020 - Actividades de programaci�n y transmisi�n de televisi�n">6020
										- Actividades de programaci�n y transmisi�n de televisi�n</option>
									<option
										value="6110 - Actividades de telecomunicaciones al�mbricas">6110
										- Actividades de telecomunicaciones al�mbricas</option>
									<option
										value="6120 - Actividades de telecomunicaciones inal�mbricas">6120
										- Actividades de telecomunicaciones inal�mbricas</option>
									<option
										value="6130 - Actividades de telecomunicaci�n satelital">6130
										- Actividades de telecomunicaci�n satelital</option>
									<option value="6190 - Otras actividades de telecomunicaciones">6190
										- Otras actividades de telecomunicaciones</option>
									<option
										value="6201 - Actividades de desarrollo de sistemas inform�ticos (planificaci�n, an�lisis, dise�o, programaci�n, pruebas)">6201
										- Actividades de desarrollo de sistemas inform�ticos
										(planificaci�n, an�lisis, dise�o, programaci�n, pruebas)</option>
									<option
										value="6202 - Actividades de consultor�a inform�tica y actividades de administraci�n de instalaciones inform�ticas">6202
										- Actividades de consultor�a inform�tica y actividades de
										administraci�n de instalaciones inform�ticas</option>
									<option
										value="6209 - Otras actividades de tecnolog�as de informaci�n y actividades de servicios inform�ticos">6209
										- Otras actividades de tecnolog�as de informaci�n y
										actividades de servicios inform�ticos</option>
									<option
										value="6311 - Procesamiento de datos, alojamiento (hosting) y actividades relacionadas">6311
										- Procesamiento de datos, alojamiento (hosting) y actividades
										relacionadas</option>
									<option value="6312 - Portales Web">6312 - Portales
										Web</option>
									<option value="6391 - Actividades de agencias de noticias">6391
										- Actividades de agencias de noticias</option>
									<option
										value="6399 - Otras actividades de servicio de informaci�n n.c.p.">6399
										- Otras actividades de servicio de informaci�n n.c.p.</option>
									<option value="6411 - Banca Central">6411 - Banca
										Central</option>
									<option value="6412 - Bancos comerciales">6412 -
										Bancos comerciales</option>
									<option
										value="6421 - Actividades de las corporaciones financieras">6421
										- Actividades de las corporaciones financieras</option>
									<option
										value="6422 - Actividades de las compa��as de financiamiento">6422
										- Actividades de las compa��as de financiamiento</option>
									<option value="6423 - Banca de segundo piso">6423 -
										Banca de segundo piso</option>
									<option
										value="6424 - Actividades de las cooperativas financieras">6424
										- Actividades de las cooperativas financieras</option>
									<option
										value="6431 - Fideicomisos, fondos y entidades financieras similares">6431
										- Fideicomisos, fondos y entidades financieras similares</option>
									<option value="6432 - Fondos de cesant�as">6432 -
										Fondos de cesant�as</option>
									<option
										value="6491 - Leasing financiero (arrendamiento financiero)">6491
										- Leasing financiero (arrendamiento financiero)</option>
									<option
										value="6492 - Actividades financieras de fondos de empleados y otras formas asociativas del sector solidario">6492
										- Actividades financieras de fondos de empleados y otras
										formas asociativas del sector solidario</option>
									<option
										value="6493 - Actividades de compra de cartera o factoring">6493
										- Actividades de compra de cartera o factoring</option>
									<option
										value="6494 - Otras actividades de distribuci�n de fondos">6494
										- Otras actividades de distribuci�n de fondos</option>
									<option value="6495 - Instituciones especiales oficiales">6495
										- Instituciones especiales oficiales</option>
									<option value="6511 - Seguros generales">6511 -
										Seguros generales</option>
									<option value="6512 - Seguros de vida">6512 - Seguros
										de vida</option>
									<option value="6513 - Reaseguros">6513 - Reaseguros</option>
									<option value="6514 - Capitalizaci�n">6514 -
										Capitalizaci�n</option>
									<option value="6521 - Servicios de seguros sociales de salud">6521
										- Servicios de seguros sociales de salud</option>
									<option
										value="6522 - Servicios de seguros sociales de riesgos profesionales">6522
										- Servicios de seguros sociales de riesgos profesionales</option>
									<option
										value="6531 - R�gimen de prima media con prestaci�n definida (RPM)">6531
										- R�gimen de prima media con prestaci�n definida (RPM)</option>
									<option value="6532 - R�gimen de ahorro individual (RAI)">6532
										- R�gimen de ahorro individual (RAI)</option>
									<option
										value="6612 - Corretaje de valores y de contratos de productos b�sicos">6612
										- Corretaje de valores y de contratos de productos b�sicos</option>
									<option
										value="6613 - Otras actividades relacionadas con el mercado de valores">6613
										- Otras actividades relacionadas con el mercado de valores</option>
									<option value="6614 - Actividades de las casas de cambio">6614
										- Actividades de las casas de cambio</option>
									<option
										value="6615 - Actividades de los profesionales de compra y venta de divisas">6615
										- Actividades de los profesionales de compra y venta de
										divisas</option>
									<option
										value="6619 - Otras actividades auxiliares de las actividades de servicios financieros n.c.p.">6619
										- Otras actividades auxiliares de las actividades de servicios
										financieros n.c.p.</option>
									<option
										value="6621 - Actividades de agentes y corredores de seguros">6621
										- Actividades de agentes y corredores de seguros</option>
									<option
										value="6629 - Evaluaci�n de riesgos y da�os, y otras actividades de servicios auxiliares">6629
										- Evaluaci�n de riesgos y da�os, y otras actividades de
										servicios auxiliares</option>
									<option value="6630 - Actividades de administraci�n de fondos">6630
										- Actividades de administraci�n de fondos</option>
									<option
										value="6810 - Actividades inmobiliarias realizadas con bienes propios o arrendados">6810
										- Actividades inmobiliarias realizadas con bienes propios o
										arrendados</option>
									<option
										value="6820 - Actividades inmobiliarias realizadas a cambio de una retribuci�n o por contrata">6820
										- Actividades inmobiliarias realizadas a cambio de una
										retribuci�n o por contrata</option>
									<option value="7310 - Publicidad">7310 - Publicidad</option>
									<option value="7420 - Actividades de fotograf�a">7420
										- Actividades de fotograf�a</option>
									<option value="7500 - Actividades veterinarias">7500 -
										Actividades veterinarias</option>
									<option
										value="7710 - Alquiler y arrendamiento de veh�culos automotores">7710
										- Alquiler y arrendamiento de veh�culos automotores</option>
									<option
										value="7721 - Alquiler y arrendamiento de equipo recreativo y deportivo">7721
										- Alquiler y arrendamiento de equipo recreativo y deportivo</option>
									<option value="7722 - Alquiler de videos y discos">7722
										- Alquiler de videos y discos</option>
									<option
										value="7729 - Alquiler y arrendamiento de otros efectos personales y enseres dom�sticos n.c.p.">7729
										- Alquiler y arrendamiento de otros efectos personales y
										enseres dom�sticos n.c.p.</option>
									<option
										value="7730 - Alquiler y arrendamiento de otros tipos de maquinaria, equipo y bienes tangibles n.c.p.">7730
										- Alquiler y arrendamiento de otros tipos de maquinaria,
										equipo y bienes tangibles n.c.p.</option>
									<option
										value="7740 - Arrendamiento de propiedad intelectual y productos similares, excepto obras protegidas por derechos de autor">7740
										- Arrendamiento de propiedad intelectual y productos
										similares, excepto obras protegidas por derechos de autor</option>
									<option value="7810 - Actividades de agencias de empleo">7810
										- Actividades de agencias de empleo</option>
									<option
										value="7820 - Actividades de agencias de empleo temporal">7820
										- Actividades de agencias de empleo temporal</option>
									<option
										value="7830 - Otras actividades de suministro de recurso humano">7830
										- Otras actividades de suministro de recurso humano</option>
									<option value="7911 - Actividades de las agencias de viaje">7911
										- Actividades de las agencias de viaje</option>
									<option value="7912 - Actividades de operadores tur�sticos">7912
										- Actividades de operadores tur�sticos</option>
									<option
										value="7990 - Otros servicios de reserva y actividades relacionadas">7990
										- Otros servicios de reserva y actividades relacionadas</option>
									<option value="8010 - Actividades de seguridad privada">8010
										- Actividades de seguridad privada</option>
									<option
										value="8020 - Actividades de servicios de sistemas de seguridad">8020
										- Actividades de servicios de sistemas de seguridad</option>
									<option
										value="8030 - Actividades de detectives e investigadores privados">8030
										- Actividades de detectives e investigadores privados</option>
									<option
										value="8110 - Actividades combinadas de apoyo a instalaciones">8110
										- Actividades combinadas de apoyo a instalaciones</option>
									<option value="8121 - Limpieza general interior de edificios">8121
										- Limpieza general interior de edificios</option>
									<option
										value="8129 - Otras actividades de limpieza de edificios e instalaciones industriales">8129
										- Otras actividades de limpieza de edificios e instalaciones
										industriales</option>
									<option
										value="8130 - Actividades de paisajismo y servicios de mantenimiento conexos">8130
										- Actividades de paisajismo y servicios de mantenimiento
										conexos</option>
									<option
										value="8211 - Actividades combinadas de servicios administrativos de oficina">8211
										- Actividades combinadas de servicios administrativos de
										oficina</option>
									<option
										value="8219 - Fotocopiado, preparaci�n de documentos y otras actividades especializadas de apoyo a oficina">8219
										- Fotocopiado, preparaci�n de documentos y otras actividades
										especializadas de apoyo a oficina</option>
									<option
										value="8220 - Actividades de centros de llamadas (Call center)">8220
										- Actividades de centros de llamadas (Call center)</option>
									<option
										value="8230 - Organizaci�n de convenciones y eventos comerciales">8230
										- Organizaci�n de convenciones y eventos comerciales</option>
									<option
										value="8291 - Actividades de agencias de cobranza y oficinas de calificaci�n crediticia">8291
										- Actividades de agencias de cobranza y oficinas de
										calificaci�n crediticia</option>
									<option value="8292 - Actividades de envase y empaque">8292
										- Actividades de envase y empaque</option>
									<option
										value="8299 - Otras actividades de servicio de apoyo a las empresas n.c.p.">8299
										- Otras actividades de servicio de apoyo a las empresas n.c.p.</option>
									<option
										value="8411 - Actividades legislativas de la administraci�n p�blica">8411
										- Actividades legislativas de la administraci�n p�blica</option>
									<option
										value="8412 - Actividades ejecutivas de la administraci�n p�blica">8412
										- Actividades ejecutivas de la administraci�n p�blica</option>
									<option
										value="8413 - Regulaci�n de las actividades de organismos que prestan servicios de salud, educativos, culturales y otros servicios sociales, e">8413
										- Regulaci�n de las actividades de organismos que prestan
										servicios de salud, educativos, culturales y otros servicios
										sociales, e</option>
									<option
										value="8414 - Actividades reguladoras y facilitadoras de la actividad econ�mica">8414
										- Actividades reguladoras y facilitadoras de la actividad
										econ�mica</option>
									<option
										value="8415 - Actividades de los otros �rganos de control">8415
										- Actividades de los otros �rganos de control</option>
									<option value="8421 - Relaciones exteriores">8421 -
										Relaciones exteriores</option>
									<option value="8422 - Actividades de defensa">8422 -
										Actividades de defensa</option>
									<option
										value="8423 - Orden p�blico y actividades de seguridad publica">8423
										- Orden p�blico y actividades de seguridad publica</option>
									<option value="8424 - Administraci�n de justicia">8424
										- Administraci�n de justicia</option>
									<option
										value="8430 - Actividades de planes de Seguridad Social de afiliaci�n obligatoria">8430
										- Actividades de planes de Seguridad Social de afiliaci�n
										obligatoria</option>
									<option value="8511 - Educaci�n de la primera infancia">8511
										- Educaci�n de la primera infancia</option>
									<option value="8512 - Educaci�n preescolar">8512 -
										Educaci�n preescolar</option>
									<option value="8513 - Educaci�n b�sica primaria">8513
										- Educaci�n b�sica primaria</option>
									<option value="8521 - Educaci�n b�sica secundaria">8521
										- Educaci�n b�sica secundaria</option>
									<option value="8522 - Educaci�n media acad�mica">8522
										- Educaci�n media acad�mica</option>
									<option
										value="8530 - Establecimientos que combinan diferentes niveles de educaci�n inicial, preescolar, b�sica primaria, b�sica secundaria y media">8530
										- Establecimientos que combinan diferentes niveles de
										educaci�n inicial, preescolar, b�sica primaria, b�sica
										secundaria y media</option>
									<option value="8541 - Educaci�n t�cnica profesional">8541
										- Educaci�n t�cnica profesional</option>
									<option value="8542 - Educaci�n tecnol�gica">8542 -
										Educaci�n tecnol�gica</option>
									<option
										value="8543 - Educaci�n de instituciones universitarias o de escuelas tecnol�gicas">8543
										- Educaci�n de instituciones universitarias o de escuelas
										tecnol�gicas</option>
									<option value="8544 - Educaci�n de universidades">8544
										- Educaci�n de universidades</option>
									<option value="8552 - Ense�anza deportiva y recreativa">8552
										- Ense�anza deportiva y recreativa</option>
									<option value="8553 - Ense�anza cultural">8553 -
										Ense�anza cultural</option>
									<option value="8559 - Otros tipos de educaci�n n.c.p.">8559
										- Otros tipos de educaci�n n.c.p.</option>
									<option value="8560 - Actividades de apoyo a la educaci�n">8560
										- Actividades de apoyo a la educaci�n</option>
									<option
										value="8610 - Actividades de hospitales y cl�nicas, con internaci�n">8610
										- Actividades de hospitales y cl�nicas, con internaci�n</option>
									<option
										value="8720 - Actividades de atenci�n residencial, para el cuidado de pacientes con retardo mental, enfermedad mental y consumo de sustancias">8720
										- Actividades de atenci�n residencial, para el cuidado de
										pacientes con retardo mental, enfermedad mental y consumo de
										sustancias</option>
									<option
										value="8730 - Actividades de atenci�n en instituciones para el cuidado de personas mayores y/o discapacitadas">8730
										- Actividades de atenci�n en instituciones para el cuidado de
										personas mayores y/o discapacitadas</option>
									<option
										value="8790 - Otras actividades de atenci�n en instituciones con alojamiento">8790
										- Otras actividades de atenci�n en instituciones con
										alojamiento</option>
									<option
										value="8810 - Actividades de asistencia social sin alojamiento para personas mayores y discapacitadas">8810
										- Actividades de asistencia social sin alojamiento para
										personas mayores y discapacitadas</option>
									<option
										value="8890 - Otras actividades de asistencia social sin alojamiento">8890
										- Otras actividades de asistencia social sin alojamiento</option>
									<option value="9001 - Creaci�n literaria">9001 -
										Creaci�n literaria</option>
									<option value="9002 - Creaci�n musical">9002 -
										Creaci�n musical</option>
									<option value="9003 - Creaci�n teatral">9003 -
										Creaci�n teatral</option>
									<option value="9004 - Creaci�n audiovisual">9004 -
										Creaci�n audiovisual</option>
									<option value="9005 - Artes pl�sticas y visuales">9005
										- Artes pl�sticas y visuales</option>
									<option value="9006 - Actividades teatrales">9006 -
										Actividades teatrales</option>
									<option
										value="9007 - Actividades de espect�culos musicales en vivo">9007
										- Actividades de espect�culos musicales en vivo</option>
									<option
										value="9008 - Otras actividades de espect�culos en vivo">9008
										- Otras actividades de espect�culos en vivo</option>
									<option value="9101 - Actividades de Bibliotecas y archivos">9101
										- Actividades de Bibliotecas y archivos</option>
									<option
										value="9102 - Actividades y funcionamiento de museos, conservaci�n de edificios y sitios hist�ricos">9102
										- Actividades y funcionamiento de museos, conservaci�n de
										edificios y sitios hist�ricos</option>
									<option
										value="9103 - Actividades de jardines bot�nicos, zool�gicos y reservas naturales">9103
										- Actividades de jardines bot�nicos, zool�gicos y reservas
										naturales</option>
									<option value="9311 - Gesti�n de instalaciones deportivas">9311
										- Gesti�n de instalaciones deportivas</option>
									<option value="9312 - Actividades de clubes deportivos">9312
										- Actividades de clubes deportivos</option>
									<option value="9319 - Otras actividades deportivas">9319
										- Otras actividades deportivas</option>
									<option
										value="9321 - Actividades de parques de atracciones y parques tem�ticos">9321
										- Actividades de parques de atracciones y parques tem�ticos</option>
									<option
										value="9411 - Actividades de asociaciones empresariales y de empleadores">9411
										- Actividades de asociaciones empresariales y de empleadores</option>
									<option
										value="9412 - Actividades de asociaciones profesionales y gremiales sin �nimo de lucro">9412
										- Actividades de asociaciones profesionales y gremiales sin
										�nimo de lucro</option>
									<option value="9420 - Actividades de sindicatos">9420
										- Actividades de sindicatos</option>
									<option value="9491 - Actividades de asociaciones religiosas">9491
										- Actividades de asociaciones religiosas</option>
									<option value="9492 - Actividades de partidos pol�ticos">9492
										- Actividades de partidos pol�ticos</option>
									<option value="9499 - Actividades de otras asociaciones n.c.p.">9499
										- Actividades de otras asociaciones n.c.p.</option>
									<option
										value="9511 - Mantenimiento y reparaci�n de computadores y de equipo perif�rico">9511
										- Mantenimiento y reparaci�n de computadores y de equipo
										perif�rico</option>
									<option
										value="9512 - Mantenimiento y reparaci�n de equipos de comunicaci�n">9512
										- Mantenimiento y reparaci�n de equipos de comunicaci�n</option>
									<option
										value="9521 - Mantenimiento y reparaci�n de aparatos electr�nicos de consumo">9521
										- Mantenimiento y reparaci�n de aparatos electr�nicos de
										consumo</option>
									<option
										value="9522 - Mantenimiento y reparaci�n de aparatos dom�sticos y equipos dom�sticos y de jardiner�a">9522
										- Mantenimiento y reparaci�n de aparatos dom�sticos y equipos
										dom�sticos y de jardiner�a</option>
									<option
										value="9523 - Reparaci�n de calzado y art�culos de cuero">9523
										- Reparaci�n de calzado y art�culos de cuero</option>
									<option
										value="9524 - Reparaci�n de muebles y accesorios para el hogar">9524
										- Reparaci�n de muebles y accesorios para el hogar</option>
									<option
										value="9529 - Mantenimiento y reparaci�n de otros efectos personales y enseres dom�sticos">9529
										- Mantenimiento y reparaci�n de otros efectos personales y
										enseres dom�sticos</option>
									<option
										value="9601 - Lavado y limpieza, incluso la limpieza en seco, de productos textiles y de piel">9601
										- Lavado y limpieza, incluso la limpieza en seco, de productos
										textiles y de piel</option>
									<option
										value="9602 - Peluquer�a y otros tratamientos de belleza">9602
										- Peluquer�a y otros tratamientos de belleza</option>
									<option
										value="9603 - Pompas f�nebres y actividades relacionadas">9603
										- Pompas f�nebres y actividades relacionadas</option>
									<option
										value="9609 - Otras actividades de servicios personales n.c.p.">9609
										- Otras actividades de servicios personales n.c.p.</option>
									<option
										value="9700 - Actividades de los hogares individuales como empleadores de personal dom�stico">9700
										- Actividades de los hogares individuales como empleadores de
										personal dom�stico</option>
									<option
										value="9810 - Actividades no diferenciadas de los hogares individuales como productores de bienes para uso propio">9810
										- Actividades no diferenciadas de los hogares individuales
										como productores de bienes para uso propio</option>
									<option
										value="9820 - Actividades no diferenciadas de los hogares individuales como productores de servicios para uso propio">9820
										- Actividades no diferenciadas de los hogares individuales
										como productores de servicios para uso propio</option>
									<option
										value="9900 - Actividades de organizaciones y entidades extraterritoriales signatarios de la Convenci�n de Viena">9900
										- Actividades de organizaciones y entidades extraterritoriales
										signatarios de la Convenci�n de Viena</option>
									<option
										value="10201 - Procesamiento y conservaci�n de frutas, legumbres, hortalizas y tub�rculos (excepto elaboraci�n de jugos de frutas)">10201
										- Procesamiento y conservaci�n de frutas, legumbres,
										hortalizas y tub�rculos (excepto elaboraci�n de jugos de
										frutas)</option>
									<option value="10202 - Elaboraci�n de jugos de frutas">10202
										- Elaboraci�n de jugos de frutas</option>
									<option
										value="10401 - Elaboraci�n de productos l�cteos (excepto bebidas)">10401
										- Elaboraci�n de productos l�cteos (excepto bebidas)</option>
									<option value="10402 - Elaboraci�n de bebidas l�cteas">10402
										- Elaboraci�n de bebidas l�cteas</option>
									<option
										value="14201 - Fabricaci�n de prendas de vestir de piel">14201
										- Fabricaci�n de prendas de vestir de piel</option>
									<option
										value="14202 - Fabricaci�n de art�culos de piel (excepto prendas de vestir)">14202
										- Fabricaci�n de art�culos de piel (excepto prendas de vestir)</option>
									<option
										value="14301 - Fabricaci�n de prendas de vestir  de punto y ganchillo">14301
										- Fabricaci�n de prendas de vestir&nbsp; de punto y ganchillo</option>
									<option
										value="14302 - Fabricaci�n de art�culos de punto y ganchillo (excepto prendas de vestir)">14302
										- Fabricaci�n de art�culos de punto y ganchillo (excepto
										prendas de vestir)</option>
									<option value="35201 - Producci�n de gas">35201 -
										Producci�n de gas</option>
									<option
										value="35202 - Distribuci�n de combustibles gaseosos por tuber�as">35202
										- Distribuci�n de combustibles gaseosos por tuber�as</option>
									<option value="36001 - Captaci�n y tratamiento de agua">36001
										- Captaci�n y tratamiento de agua</option>
									<option value="36002 - Distribuci�n de agua">36002 -
										Distribuci�n de agua</option>
									<option
										value="39001 - Actividades de saneamiento ambiental y otros servicios de gesti�n de desechos (excepto los servicios prestados por contratistas">39001
										- Actividades de saneamiento ambiental y otros servicios de
										gesti�n de desechos (excepto los servicios prestados por
										contratistas</option>
									<option
										value="39002 - Actividades de saneamiento ambiental y otros servicios de gesti�n de desechos prestados por contratistas de construcci�n, constr">39002
										- Actividades de saneamiento ambiental y otros servicios de
										gesti�n de desechos prestados por contratistas de
										construcci�n, constr</option>
									<option value="45411 - Comercio de motocicletas">45411
										- Comercio de motocicletas</option>
									<option
										value="45412 - Comercio de partes, piezas y accesorios de motocicletas">45412
										- Comercio de partes, piezas y accesorios de motocicletas</option>
									<option
										value="46201 - Comercio al por mayor de materias primas agr�colas en bruto (alimentos)">46201
										- Comercio al por mayor de materias primas agr�colas en bruto
										(alimentos)</option>
									<option
										value="46202 - Comercio al por mayor de materias primas pecuarias y animales vivos">46202
										- Comercio al por mayor de materias primas pecuarias y
										animales vivos</option>
									<option
										value="46321 - Comercio al por mayor de bebidas y tabaco (diferentes a licores y cigarrillos)">46321
										- Comercio al por mayor de bebidas y tabaco (diferentes a
										licores y cigarrillos)</option>
									<option
										value="46322 - Comercio al por mayor de licores y cigarrillos">46322
										- Comercio al por mayor de licores y cigarrillos</option>
									<option
										value="46451 - Comercio al por mayor de productos farmac�uticos y medicinales">46451
										- Comercio al por mayor de productos farmac�uticos y
										medicinales</option>
									<option
										value="46452 - Comercio al por mayor de productos cosm�ticos y de tocador (excepto productos farmac�uticos y medicinales)">46452
										- Comercio al por mayor de productos cosm�ticos y de tocador
										(excepto productos farmac�uticos y medicinales)</option>
									<option
										value="46491 - Comercio al por mayor de otros utensilios dom�sticos n.c.p. (excepto joyas)">46491
										- Comercio al por mayor de otros utensilios dom�sticos n.c.p.
										(excepto joyas)</option>
									<option value="46492 - Venta de joyas">46492 - Venta
										de joyas</option>
									<option
										value="46611 - Comercio al por mayor de combustibles s�lidos, l�quidos, gaseosos y productos conexos (excepto combustibles derivados del petr�l">46611
										- Comercio al por mayor de combustibles s�lidos, l�quidos,
										gaseosos y productos conexos (excepto combustibles derivados
										del petr�l</option>
									<option
										value="46612 - Comercio al por mayor de combustibles  derivados del petr�leo">46612
										- Comercio al por mayor de combustibles&nbsp; derivados del
										petr�leo</option>
									<option
										value="46631 - Comercio al por mayor de materiales de construcci�n">46631
										- Comercio al por mayor de materiales de construcci�n</option>
									<option
										value="46632 - Comercio al por mayor de  art�culos de ferreter�a, pinturas, productos de vidrio, equipo y materiales de fontaner�a y calefacci�">46632
										- Comercio al por mayor de&nbsp; art�culos de ferreter�a,
										pinturas, productos de vidrio, equipo y materiales de
										fontaner�a y calefacci�</option>
									<option
										value="47111 - Comercio al por menor en establecimientos no especializados con surtido compuesto principalmente por alimentos, bebidas o tabaco">47111
										- Comercio al por menor en establecimientos no especializados
										con surtido compuesto principalmente por alimentos, bebidas o
										tabaco</option>
									<option
										value="47112 - Comercio al por menor en establecimientos no especializados con surtido compuesto principalmente  por licores y cigarrillos">47112
										- Comercio al por menor en establecimientos no especializados
										con surtido compuesto principalmente&nbsp; por licores y
										cigarrillos</option>
									<option
										value="47191 - Comercio al por menor en establecimientos no especializados con surtido compuesto principalmente por productos diferentes de ali">47191
										- Comercio al por menor en establecimientos no especializados
										con surtido compuesto principalmente por productos diferentes
										de ali</option>
									<option
										value="47192 - Comercio al por menor en establecimientos no especializados, con surtido compuesto principalmente por drogas, medicamentos, text">47192
										- Comercio al por menor en establecimientos no especializados,
										con surtido compuesto principalmente por drogas, medicamentos,
										text</option>
									<option
										value="47241 - Comercio al por menor de bebidas y productos del tabaco, en establecimientos especializados  (excepto licores y cigarrillos)">47241
										- Comercio al por menor de bebidas y productos del tabaco, en
										establecimientos especializados&nbsp; (excepto licores y
										cigarrillos)</option>
									<option
										value="47242 - Comercio al por menor de licores y cigarrillos">47242
										- Comercio al por menor de licores y cigarrillos</option>
									<option
										value="47521 - Comercio al por menor de materiales de construcci�n">47521
										- Comercio al por menor de materiales de construcci�n</option>
									<option
										value="47522 - Comercio al por menor de art�culos de ferreter�a, pinturas y productos de vidrio en establecimientos especializados (excepto mat">47522
										- Comercio al por menor de art�culos de ferreter�a, pinturas y
										productos de vidrio en establecimientos especializados
										(excepto mat</option>
									<option
										value="47611 - Comercio al por menor de libros, textos escolares y cuadernos">47611
										- Comercio al por menor de libros, textos escolares y
										cuadernos</option>
									<option
										value="47612 - Comercio al por menor de peri�dicos, materiales y art�culos de papeler�a y escritorio, en establecimientos especializados (excep">47612
										- Comercio al por menor de peri�dicos, materiales y art�culos
										de papeler�a y escritorio, en establecimientos especializados
										(excep</option>
									<option
										value="47731 - Comercio al por menor de productos farmac�uticos y medicinales en establecimientos especializados">47731
										- Comercio al por menor de productos farmac�uticos y
										medicinales en establecimientos especializados</option>
									<option
										value="47732 - Comercio al por menor de productos cosm�ticos y art�culos de tocador en establecimientos especializados (excepto productos  farm">47732
										- Comercio al por menor de productos cosm�ticos y art�culos de
										tocador en establecimientos especializados (excepto
										productos&nbsp; farm</option>
									<option
										value="47811 - Comercio al por menor de alimentos en puestos de venta m�viles">47811
										- Comercio al por menor de alimentos en puestos de venta
										m�viles</option>
									<option
										value="47812 - Comercio al por menor de  bebidas y tabaco en puestos de venta m�viles (excepto licores y cigarrillos)">47812
										- Comercio al por menor de&nbsp; bebidas y tabaco en puestos
										de venta m�viles (excepto licores y cigarrillos)</option>
									<option
										value="47813 - Comercio al por menor de cigarrillos y licores en puestos de venta m�viles">47813
										- Comercio al por menor de cigarrillos y licores en puestos de
										venta m�viles</option>
									<option
										value="47911 - Comercio al por menor de alimentos y productos agr�colas en bruto; venta de textos escolares y libros (incluye cuadernos escolar">47911
										- Comercio al por menor de alimentos y productos agr�colas en
										bruto; venta de textos escolares y libros (incluye cuadernos
										escolar</option>
									<option
										value="47912 - Comercio al por menor de madera y materiales para construcci�n; venta de automotores (incluidas motocicletas)  realizado a trav�">47912
										- Comercio al por menor de madera y materiales para
										construcci�n; venta de automotores (incluidas
										motocicletas)&nbsp; realizado a trav�</option>
									<option
										value="47913 - Comercio al por menor de cigarrillos y licores; venta de combustibles derivados del petr�leo y venta de joyas  realizado a trav�">47913
										- Comercio al por menor de cigarrillos y licores; venta de
										combustibles derivados del petr�leo y venta de joyas&nbsp;
										realizado a trav�</option>
									<option
										value="47914 - Comercio al por menor de dem�s productos n.c.p.  realizado a trav�s de internet">47914
										- Comercio al por menor de dem�s productos n.c.p.&nbsp;
										realizado a trav�s de internet</option>
									<option
										value="47921 - Comercio al por menor de alimentos y productos agr�colas en bruto; venta de textos escolares y libros (incluye cuadernos escolar">47921
										- Comercio al por menor de alimentos y productos agr�colas en
										bruto; venta de textos escolares y libros (incluye cuadernos
										escolar</option>
									<option
										value="47922 - Comercio al por menor de madera y materiales para construcci�n; venta de automotores (incluidas motocicletas)  realizado a trav�">47922
										- Comercio al por menor de madera y materiales para
										construcci�n; venta de automotores (incluidas
										motocicletas)&nbsp; realizado a trav�</option>
									<option
										value="47923 - Comercio al por menor de cigarrillos y licores; venta de combustibles derivados del petr�leo y venta de joyas  realizado a trav�">47923
										- Comercio al por menor de cigarrillos y licores; venta de
										combustibles derivados del petr�leo y venta de joyas&nbsp;
										realizado a trav�</option>
									<option
										value="47924 - Comercio al por menor de dem�s productos n.c.p.  realizado a trav�s de casas de venta o por correo">47924
										- Comercio al por menor de dem�s productos n.c.p.&nbsp;
										realizado a trav�s de casas de venta o por correo</option>
									<option
										value="47991 - Otros tipos de comercio al por menor no realizado en establecimientos, puestos de venta o mercados de textos escolares y libros">47991
										- Otros tipos de comercio al por menor no realizado en
										establecimientos, puestos de venta o mercados de textos
										escolares y libros</option>
									<option
										value="47992 - Otros tipos de comercio al por menor no realizado en establecimientos, puestos de venta o mercados de  materiales para construcc">47992
										- Otros tipos de comercio al por menor no realizado en
										establecimientos, puestos de venta o mercados de&nbsp;
										materiales para construcc</option>
									<option
										value="47993 - Otros tipos de comercio al por menor no realizado en establecimientos, puestos de venta o mercados de cigarrillos y licores; ven">47993
										- Otros tipos de comercio al por menor no realizado en
										establecimientos, puestos de venta o mercados de cigarrillos y
										licores; ven</option>
									<option
										value="47994 - Otros tipos de comercio al por menor no realizado en establecimientos, puestos de venta o mercados de dem�s productos n.c.p.">47994
										- Otros tipos de comercio al por menor no realizado en
										establecimientos, puestos de venta o mercados de dem�s
										productos n.c.p.</option>
									<option value="58111 - Servicio de edici�n de libros">58111
										- Servicio de edici�n de libros</option>
									<option value="58112 - Edici�n y publicaci�n de libros">58112
										- Edici�n y publicaci�n de libros</option>
									<option
										value="58113 - Edici�n y publicaci�n de libros (Tarifa especial para los contribuyentes que cumplen condiciones del Acuerdo 98 de 2003)">58113
										- Edici�n y publicaci�n de libros (Tarifa especial para los
										contribuyentes que cumplen condiciones del Acuerdo 98 de 2003)</option>
									<option
										value="60201 - Actividades de programaci�n de televisi�n">60201
										- Actividades de programaci�n de televisi�n</option>
									<option
										value="60202 - Actividades de transmisi�n de televisi�n">60202
										- Actividades de transmisi�n de televisi�n</option>
									<option
										value="64991 - Otras actividades de servicio financiero, excepto las de seguros y pensiones n.c.p.">64991
										- Otras actividades de servicio financiero, excepto las de
										seguros y pensiones n.c.p.</option>
									<option
										value="64992 - Actividades comerciales de las casas de empe�o o compraventa">64992
										- Actividades comerciales de las casas de empe�o o compraventa</option>
									<option
										value="64993 - Servicios de las casas de empe�o o compraventas">64993
										- Servicios de las casas de empe�o o compraventas</option>
									<option
										value="66111 - Administraci�n de mercados financieros (excepto actividades de las bolsas de valores)">66111
										- Administraci�n de mercados financieros (excepto actividades
										de las bolsas de valores)</option>
									<option value="66112 - Actividades de las bolsas de valores">66112
										- Actividades de las bolsas de valores</option>
									<option
										value="69101 - Actividades jur�dicas como consultor�a profesional">69101
										- Actividades jur�dicas como consultor�a profesional</option>
									<option
										value="69102 - Actividades jur�dicas en el ejercicio de una profesi�n liberal">69102
										- Actividades jur�dicas en el ejercicio de una profesi�n
										liberal</option>
									<option
										value="69201 - Actividades de contabilidad, tenedur�a de libros, auditor�a financiera y asesor�a tributaria como consultor�a profesional">69201
										- Actividades de contabilidad, tenedur�a de libros, auditor�a
										financiera y asesor�a tributaria como consultor�a profesional</option>
									<option
										value="69202 - Actividades de contabilidad, tenedur�a de libros, auditor�a financiera y asesor�a tributaria en el ejercicio de una profesi�n li">69202
										- Actividades de contabilidad, tenedur�a de libros, auditor�a
										financiera y asesor�a tributaria en el ejercicio de una
										profesi�n li</option>
									<option
										value="70101 - Actividades de administraci�n empresarial como consultor�a profesional">70101
										- Actividades de administraci�n empresarial como consultor�a
										profesional</option>
									<option
										value="70102 - Actividades de administraci�n empresarial en el ejercicio de una profesi�n liberal">70102
										- Actividades de administraci�n empresarial en el ejercicio de
										una profesi�n liberal</option>
									<option value="70201 - Actividades de consultor�a de gesti�n">70201
										- Actividades de consultor�a de gesti�n</option>
									<option
										value="70202 - Actividades de  gesti�n en el ejercicio de una profesi�n liberal">70202
										- Actividades de&nbsp; gesti�n en el ejercicio de una
										profesi�n liberal</option>
									<option
										value="71101 - Actividades de arquitectura e ingenier�a y otras actividades conexas de consultor�a t�cnica">71101
										- Actividades de arquitectura e ingenier�a y otras actividades
										conexas de consultor�a t�cnica</option>
									<option
										value="71102 - Actividades de arquitectura e ingenier�a y otras actividades conexas en el ejercicio de una profesi�n liberal">71102
										- Actividades de arquitectura e ingenier�a y otras actividades
										conexas en el ejercicio de una profesi�n liberal</option>
									<option
										value="71201 - Ensayos y an�lisis t�cnicos como consultor�a profesional">71201
										- Ensayos y an�lisis t�cnicos como consultor�a profesional</option>
									<option
										value="71202 - Ensayos y an�lisis t�cnicos como consultor�a profesional en el ejercicio de una profesi�n liberal">71202
										- Ensayos y an�lisis t�cnicos como consultor�a profesional en
										el ejercicio de una profesi�n liberal</option>
									<option
										value="72101 - Investigaciones y desarrollo experimental en el campo de las ciencias naturales y la ingenier�a  como consultor�a profesional">72101
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias naturales y la ingenier�a&nbsp; como consultor�a
										profesional</option>
									<option
										value="72102 - Investigaciones y desarrollo experimental en el campo de las ciencias naturales y la ingenier�a  en el ejercicio de una profesi�">72102
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias naturales y la ingenier�a&nbsp; en el ejercicio de
										una profesi�</option>
									<option
										value="72201 - Investigaciones y desarrollo experimental en el campo de las ciencias sociales y las humanidades  como consultor�a profesional">72201
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias sociales y las humanidades&nbsp; como consultor�a
										profesional</option>
									<option
										value="72202 - Investigaciones y desarrollo experimental en el campo de las ciencias sociales y las humanidades  en el ejercicio de una profesi">72202
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias sociales y las humanidades&nbsp; en el ejercicio de
										una profesi</option>
									<option
										value="73201 - Estudios de mercado y realizaci�n de encuestas de opini�n p�blica como consultor�a profesional">73201
										- Estudios de mercado y realizaci�n de encuestas de opini�n
										p�blica como consultor�a profesional</option>
									<option
										value="73202 - Estudios de mercado y realizaci�n de encuestas de opini�n p�blica en el ejercicio de una profesi�n liberal">73202
										- Estudios de mercado y realizaci�n de encuestas de opini�n
										p�blica en el ejercicio de una profesi�n liberal</option>
									<option
										value="74101 - Actividades especializadas de dise�o como consultor�a profesional">74101
										- Actividades especializadas de dise�o como consultor�a
										profesional</option>
									<option
										value="74102 - Actividades especializadas de dise�o en el ejercicio de una profesi�n liberal">74102
										- Actividades especializadas de dise�o en el ejercicio de una
										profesi�n liberal</option>
									<option
										value="74901 - Otras actividades profesionales, cient�ficas y t�cnicas n.c.p. como consultor�a profesional (incluye actividades de periodistas)">74901
										- Otras actividades profesionales, cient�ficas y t�cnicas
										n.c.p. como consultor�a profesional (incluye actividades de
										periodistas)</option>
									<option
										value="74902 - Otras actividades profesionales, cient�ficas y t�cnicas n.c.p. en el ejercicio de una profesi�n liberal">74902
										- Otras actividades profesionales, cient�ficas y t�cnicas
										n.c.p. en el ejercicio de una profesi�n liberal</option>
									<option value="85231 - Educaci�n media t�cnica.">85231
										- Educaci�n media t�cnica.</option>
									<option value="85232 - Educaci�n de formaci�n laboral">85232
										- Educaci�n de formaci�n laboral</option>
									<option
										value="85511 - Educaci�n acad�mica no formal (excepto programas de educaci�n b�sica primaria, b�sica secundaria y media no gradual con fines de">85511
										- Educaci�n acad�mica no formal (excepto programas de
										educaci�n b�sica primaria, b�sica secundaria y media no
										gradual con fines de</option>
									<option
										value="85512 - Educaci�n acad�mica no formal impartida mediante programas de educaci�n b�sica primaria, b�sica secundaria y media no gradual co">85512
										- Educaci�n acad�mica no formal impartida mediante programas
										de educaci�n b�sica primaria, b�sica secundaria y media no
										gradual co</option>
									<option
										value="86211 - Actividades de la pr�ctica m�dica, sin internaci�n (excepto entidades e instituciones promotoras y prestadoras de servicios de s">86211
										- Actividades de la pr�ctica m�dica, sin internaci�n (excepto
										entidades e instituciones promotoras y prestadoras de
										servicios de s</option>
									<option
										value="86221 - Actividades de la pr�ctica odontol�gica, sin internaci�n (excepto entidades e instituciones promotoras y prestadoras de servicio">86221
										- Actividades de la pr�ctica odontol�gica, sin internaci�n
										(excepto entidades e instituciones promotoras y prestadoras de
										servicio</option>
									<option
										value="86911 - Actividades de apoyo diagn�stico (excepto entidades e instituciones promotoras y prestadoras de servicios de salud, de naturalez">86911
										- Actividades de apoyo diagn�stico (excepto entidades e
										instituciones promotoras y prestadoras de servicios de salud,
										de naturalez</option>
									<option
										value="86921 - Actividades de apoyo terap�utico (excepto entidades e instituciones promotoras y prestadoras de servicios de salud, de naturalez">86921
										- Actividades de apoyo terap�utico (excepto entidades e
										instituciones promotoras y prestadoras de servicios de salud,
										de naturalez</option>
									<option
										value="86991 - Otras actividades de atenci�n de la salud humana (excepto entidades e instituciones promotoras y prestadoras de servicios de sal">86991
										- Otras actividades de atenci�n de la salud humana (excepto
										entidades e instituciones promotoras y prestadoras de
										servicios de sal</option>
									<option
										value="87101 - Actividades de atenci�n residencial medicalizada de tipo general (excepto entidades e instituciones promotoras y prestadoras de">87101
										- Actividades de atenci�n residencial medicalizada de tipo
										general (excepto entidades e instituciones promotoras y
										prestadoras de</option>
									<option
										value="92001 - Actividades de juegos de destreza, habilidad, conocimiento y fuerza">92001
										- Actividades de juegos de destreza, habilidad, conocimiento y
										fuerza</option>
									<option
										value="93291 - Otras actividades recreativas y de esparcimiento n.c.p. (excepto juegos de suerte y azar, discotecas y similares )">93291
										- Otras actividades recreativas y de esparcimiento n.c.p.
										(excepto juegos de suerte y azar, discotecas y similares )</option>
							</select></td>
							<td><input class="inputtextnew" type="text" /></td>
							<td><input class="inputtextnew" type="text" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-2" style="margin-top: 25px">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="ica.declaracion.actifuera.descargar" />
				</button>
			</div>
			<div class="col-md-6">
				<label class="control-label" style="text-transform: capitalize"><spring:theme
						code="ica.declaracion.actifuera.ayuda" /></label><input type="file"
					class="form-control" id="exampleFormControlFile1">
			</div>
		</div>
	</div>
</form:form>
</div>