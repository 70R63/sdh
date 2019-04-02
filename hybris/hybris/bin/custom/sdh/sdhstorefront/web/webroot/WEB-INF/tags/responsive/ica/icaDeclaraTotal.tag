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
										value="113 - Cultivo de hortalizas, raíces y tubérculos">113
										- Cultivo de hortalizas, raíces y tubérculos</option>
									<option value="114 - Cultivo de tabaco">114 - Cultivo
										de tabaco</option>
									<option value="115 - Cultivo de plantas textiles">115
										- Cultivo de plantas textiles</option>
									<option value="119 - Otros cultivos transitorios n.c.p.">119
										- Otros cultivos transitorios n.c.p.</option>
									<option
										value="121 - Cultivo de frutas tropicales y subtropicales">121
										- Cultivo de frutas tropicales y subtropicales</option>
									<option value="122 - Cultivo de plátano y banano">122
										- Cultivo de plátano y banano</option>
									<option value="123 - Cultivo de café">123 - Cultivo de
										café</option>
									<option value="124 - Cultivo de caña de azúcar">124 -
										Cultivo de caña de azúcar</option>
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
										value="128 - Cultivo de especias y de plantas aromáticas y medicinales">128
										- Cultivo de especias y de plantas aromáticas y medicinales</option>
									<option value="129 - Otros cultivos permanentes n.c.p.">129
										- Otros cultivos permanentes n.c.p.</option>
									<option
										value="130 - Propagación de plantas (actividades de los viveros, excepto viveros forestales)">130
										- Propagación de plantas (actividades de los viveros, excepto
										viveros forestales)</option>
									<option value="141 - Cría de ganado bovino y bufalino">141
										- Cría de ganado bovino y bufalino</option>
									<option value="142 - Cría de caballos y otros equinos">142
										- Cría de caballos y otros equinos</option>
									<option value="143 - Cría de ovejas y cabras">143 -
										Cría de ovejas y cabras</option>
									<option value="144 - Cría de ganado porcino">144 -
										Cría de ganado porcino</option>
									<option value="145 - Cría de aves de corral">145 -
										Cría de aves de corral</option>
									<option value="149 - Cría de otros animales n.c.p.">149
										- Cría de otros animales n.c.p.</option>
									<option
										value="150 - Explotación primaria mixta (agrícola y pecuaria)">150
										- Explotación primaria mixta (agrícola y pecuaria)</option>
									<option value="161 - Actividades de apoyo a la agricultura">161
										- Actividades de apoyo a la agricultura</option>
									<option value="162 - Actividades de apoyo a la ganadería">162
										- Actividades de apoyo a la ganadería</option>
									<option value="163 - Actividades posteriores a la cosecha">163
										- Actividades posteriores a la cosecha</option>
									<option value="164 - Tratamiento de semillas para propagación">164
										- Tratamiento de semillas para propagación</option>
									<option
										value="170 - Caza ordinaria y mediante trampas y actividades de servicios conexas">170
										- Caza ordinaria y mediante trampas y actividades de servicios
										conexas</option>
									<option
										value="210 - Silvicultura y otras actividades forestales">210
										- Silvicultura y otras actividades forestales</option>
									<option value="220 - Extracción de madera">220 -
										Extracción de madera</option>
									<option
										value="230 - Recolección de productos forestales diferentes a la madera">230
										- Recolección de productos forestales diferentes a la madera</option>
									<option value="240 - Servicios de apoyo a la silvicultura">240
										- Servicios de apoyo a la silvicultura</option>
									<option value="311 - Pesca marítima">311 - Pesca
										marítima</option>
									<option value="312 - Pesca de agua dulce">312 - Pesca
										de agua dulce</option>
									<option value="321 - Acuicultura marítima">321 -
										Acuicultura marítima</option>
									<option value="322 - Acuicultura de agua dulce">322 -
										Acuicultura de agua dulce</option>
									<option value="510 - Extracción de hulla (carbón de piedra)">510
										- Extracción de hulla (carbón de piedra)</option>
									<option value="520 - Extracción de carbón lignito">520
										- Extracción de carbón lignito</option>
									<option value="610 - Extracción de petróleo crudo">610
										- Extracción de petróleo crudo</option>
									<option value="620 - Extracción de gas natural">620 -
										Extracción de gas natural</option>
									<option value="710 - Extracción de minerales de hierro">710
										- Extracción de minerales de hierro</option>
									<option
										value="721 - Extracción de minerales de uranio y de torio">721
										- Extracción de minerales de uranio y de torio</option>
									<option
										value="722 - Extracción de oro y otros metales preciosos">722
										- Extracción de oro y otros metales preciosos</option>
									<option value="723 - Extracción de minerales de níquel">723
										- Extracción de minerales de níquel</option>
									<option
										value="729 - Extracción de otros minerales metalíferos no ferrosos n.c.p.">729
										- Extracción de otros minerales metalíferos no ferrosos n.c.p.</option>
									<option
										value="811 - Extracción de piedra, arena, arcillas comunes, yeso y anhidrita">811
										- Extracción de piedra, arena, arcillas comunes, yeso y
										anhidrita</option>
									<option
										value="812 - Extracción de arcillas de uso industrial, caliza, caolín y bentonitas">812
										- Extracción de arcillas de uso industrial, caliza, caolín y
										bentonitas</option>
									<option
										value="820 - Extracción de esmeraldas, piedras preciosas y semipreciosas">820
										- Extracción de esmeraldas, piedras preciosas y semipreciosas</option>
									<option
										value="891 - Extracción de minerales para la fabricación de abonos y productos químicos">891
										- Extracción de minerales para la fabricación de abonos y
										productos químicos</option>
									<option value="892 - Extracción de halita (sal)">892 -
										Extracción de halita (sal)</option>
									<option
										value="899 - Extracción de otros minerales no metálicos n.c.p.">899
										- Extracción de otros minerales no metálicos n.c.p.</option>
									<option
										value="910 - Actividades de apoyo para la extracción de petróleo y de gas natural">910
										- Actividades de apoyo para la extracción de petróleo y de gas
										natural</option>
									<option
										value="990 - Actividades de apoyo para otras actividades de explotación de minas y canteras">990
										- Actividades de apoyo para otras actividades de explotación
										de minas y canteras</option>
									<option
										value="1011 - Procesamiento y conservación de carne y productos cárnicos">1011
										- Procesamiento y conservación de carne y productos cárnicos</option>
									<option
										value="1012 - Procesamiento y conservación de pescados, crustáceos y moluscos">1012
										- Procesamiento y conservación de pescados, crustáceos y
										moluscos</option>
									<option
										value="1030 - Elaboración de aceites y grasas de origen vegetal y animal">1030
										- Elaboración de aceites y grasas de origen vegetal y animal</option>
									<option value="1051 - Elaboración de productos de molinería">1051
										- Elaboración de productos de molinería</option>
									<option
										value="1052 - Elaboración de almidones y productos derivados del almidón">1052
										- Elaboración de almidones y productos derivados del almidón</option>
									<option value="1061 - Trilla de café">1061 - Trilla de
										café</option>
									<option
										value="1062 - Descafeinado, tostión y molienda del café">1062
										- Descafeinado, tostión y molienda del café</option>
									<option value="1063 - Elaboración de otros derivados del café">1063
										- Elaboración de otros derivados del café</option>
									<option value="1071 - Elaboración y refinación de azúcar">1071
										- Elaboración y refinación de azúcar</option>
									<option value="1072 - Elaboración de panela">1072 -
										Elaboración de panela</option>
									<option value="1081 - Elaboración de productos de panadería">1081
										- Elaboración de productos de panadería</option>
									<option
										value="1082 - Elaboración de cacao, chocolate y productos de confitería">1082
										- Elaboración de cacao, chocolate y productos de confitería</option>
									<option
										value="1083 - Elaboración de macarrones, fideos, alcuzcuz y productos farináceos similares">1083
										- Elaboración de macarrones, fideos, alcuzcuz y productos
										farináceos similares</option>
									<option
										value="1084 - Elaboración de comidas y platos preparados">1084
										- Elaboración de comidas y platos preparados</option>
									<option
										value="1089 - Elaboración de otros productos alimenticios n.c.p.">1089
										- Elaboración de otros productos alimenticios n.c.p.</option>
									<option
										value="1090 - Elaboración de alimentos preparados para animales">1090
										- Elaboración de alimentos preparados para animales</option>
									<option
										value="1101 - Destilación, rectificación y mezcla de bebidas alcohólicas">1101
										- Destilación, rectificación y mezcla de bebidas alcohólicas</option>
									<option
										value="1102 - Elaboración de bebidas fermentadas no destiladas">1102
										- Elaboración de bebidas fermentadas no destiladas</option>
									<option
										value="1103 - Producción de malta, elaboración de cervezas y otras bebidas malteadas">1103
										- Producción de malta, elaboración de cervezas y otras bebidas
										malteadas</option>
									<option
										value="1104 - Elaboración de bebidas no alcohólicas, producción de aguas minerales y de otras aguas embotelladas">1104
										- Elaboración de bebidas no alcohólicas, producción de aguas
										minerales y de otras aguas embotelladas</option>
									<option value="1200 - Elaboración de productos de tabaco">1200
										- Elaboración de productos de tabaco</option>
									<option
										value="1311 - Preparación e hilatura de fibras textiles">1311
										- Preparación e hilatura de fibras textiles</option>
									<option value="1312 - Tejeduría de productos textiles">1312
										- Tejeduría de productos textiles</option>
									<option value="1313 - Acabado de productos textiles">1313
										- Acabado de productos textiles</option>
									<option
										value="1391 - Fabricación de tejidos de punto y ganchillo">1391
										- Fabricación de tejidos de punto y ganchillo</option>
									<option
										value="1392 - Confección de artículos con materiales textiles, excepto prendas de vestir">1392
										- Confección de artículos con materiales textiles, excepto
										prendas de vestir</option>
									<option
										value="1393 - Fabricación de tapetes y alfombras para pisos">1393
										- Fabricación de tapetes y alfombras para pisos</option>
									<option
										value="1394 - Fabricación de cuerdas, cordeles, cables, bramantes y redes">1394
										- Fabricación de cuerdas, cordeles, cables, bramantes y redes</option>
									<option
										value="1399 - Fabricación de otros artículos textiles n.c.p.">1399
										- Fabricación de otros artículos textiles n.c.p.</option>
									<option
										value="1410 - Confección de prendas de vestir, excepto prendas de piel">1410
										- Confección de prendas de vestir, excepto prendas de piel</option>
									<option
										value="1511 - Curtido y recurtido de cueros; recurtido y teñido de pieles.">1511
										- Curtido y recurtido de cueros; recurtido y teñido de pieles.</option>
									<option
										value="1512 - Fabricación de artículos de viaje, bolsos de mano y artículos similares elaborados en cuero, y fabricación de artículos de talab">1512
										- Fabricación de artículos de viaje, bolsos de mano y
										artículos similares elaborados en cuero, y fabricación de
										artículos de talab</option>
									<option
										value="1513 - Fabricación de artículos de viaje, bolsos de mano y artículos similares; artículos de talabartería y guarnicionería elaborados e">1513
										- Fabricación de artículos de viaje, bolsos de mano y
										artículos similares; artículos de talabartería y
										guarnicionería elaborados e</option>
									<option
										value="1521 - Fabricación de calzado de cuero y piel, con cualquier tipo de suela">1521
										- Fabricación de calzado de cuero y piel, con cualquier tipo
										de suela</option>
									<option
										value="1522 - Fabricación de otros tipos de calzado, excepto calzado de cuero y piel">1522
										- Fabricación de otros tipos de calzado, excepto calzado de
										cuero y piel</option>
									<option value="1523 - Fabricación de partes del calzado">1523
										- Fabricación de partes del calzado</option>
									<option
										value="1610 - Aserrado, acepillado e impregnación de la madera">1610
										- Aserrado, acepillado e impregnación de la madera</option>
									<option
										value="1620 - Fabricación de hojas de madera para enchapado; fabricación de tableros contrachapados, tableros laminados, tableros de partícula">1620
										- Fabricación de hojas de madera para enchapado; fabricación
										de tableros contrachapados, tableros laminados, tableros de
										partícula</option>
									<option
										value="1630 - Fabricación de partes y piezas de madera, de carpintería y ebanistería para la construcción y para edificios">1630
										- Fabricación de partes y piezas de madera, de carpintería y
										ebanistería para la construcción y para edificios</option>
									<option value="1640 - Fabricación de recipientes de madera">1640
										- Fabricación de recipientes de madera</option>
									<option
										value="1690 - Fabricación de otros productos de madera; fabricación de artículos de corcho, cestería y espartería">1690
										- Fabricación de otros productos de madera; fabricación de
										artículos de corcho, cestería y espartería</option>
									<option
										value="1701 - Fabricación de pulpas (pastas) celulósicas; papel y cartón">1701
										- Fabricación de pulpas (pastas) celulósicas; papel y cartón</option>
									<option
										value="1702 - Fabricación de papel y cartón ondulado (corrugado); fabricación de envases, empaques y de embalajes de papel y cartón.">1702
										- Fabricación de papel y cartón ondulado (corrugado);
										fabricación de envases, empaques y de embalajes de papel y
										cartón.</option>
									<option
										value="1709 - Fabricación de otros artículos de papel y cartón">1709
										- Fabricación de otros artículos de papel y cartón</option>
									<option value="1811 - Actividades de impresión">1811 -
										Actividades de impresión</option>
									<option
										value="1812 - Actividades de servicios relacionados con la impresión">1812
										- Actividades de servicios relacionados con la impresión</option>
									<option
										value="1820 - Producción de copias a partir de grabaciones originales">1820
										- Producción de copias a partir de grabaciones originales</option>
									<option
										value="1910 - Fabricación de productos de hornos de coque">1910
										- Fabricación de productos de hornos de coque</option>
									<option
										value="1921 - Fabricación de productos de la refinación del petróleo">1921
										- Fabricación de productos de la refinación del petróleo</option>
									<option value="1922 - Actividad de mezcla de combustibles">1922
										- Actividad de mezcla de combustibles</option>
									<option
										value="2011 - Fabricación de sustancias y productos químicos básicos">2011
										- Fabricación de sustancias y productos químicos básicos</option>
									<option
										value="2012 - Fabricación de abonos y compuestos inorgánicos nitrogenados">2012
										- Fabricación de abonos y compuestos inorgánicos nitrogenados</option>
									<option
										value="2013 - Fabricación de plásticos en formas primarias">2013
										- Fabricación de plásticos en formas primarias</option>
									<option
										value="2014 - Fabricación de caucho sintético en formas primarias">2014
										- Fabricación de caucho sintético en formas primarias</option>
									<option
										value="2021 - Fabricación de plaguicidas y otros productos químicos de uso agropecuario">2021
										- Fabricación de plaguicidas y otros productos químicos de uso
										agropecuario</option>
									<option
										value="2022 - Fabricación de pinturas, barnices y revestimientos similares, tintas para impresión y masillas">2022
										- Fabricación de pinturas, barnices y revestimientos
										similares, tintas para impresión y masillas</option>
									<option
										value="2023 - Fabricación de jabones y detergentes, preparados para limpiar y pulir; perfumes y preparados de tocador">2023
										- Fabricación de jabones y detergentes, preparados para
										limpiar y pulir; perfumes y preparados de tocador</option>
									<option
										value="2029 - Fabricación de otros productos químicos n.c.p.">2029
										- Fabricación de otros productos químicos n.c.p.</option>
									<option
										value="2030 - Fabricación de fibras sintéticas y artificiales">2030
										- Fabricación de fibras sintéticas y artificiales</option>
									<option
										value="2100 - Fabricación de productos farmacéuticos, sustancias químicas medicinales y productos botánicos de uso farmacéutico">2100
										- Fabricación de productos farmacéuticos, sustancias químicas
										medicinales y productos botánicos de uso farmacéutico</option>
									<option
										value="2211 - Fabricación de llantas y neumáticos de caucho">2211
										- Fabricación de llantas y neumáticos de caucho</option>
									<option value="2212 - Reencauche de llantas usadas">2212
										- Reencauche de llantas usadas</option>
									<option
										value="2219 - Fabricación de formas básicas de caucho y otros productos de caucho n.c.p.">2219
										- Fabricación de formas básicas de caucho y otros productos de
										caucho n.c.p.</option>
									<option
										value="2221 - Fabricación de formas básicas de plástico">2221
										- Fabricación de formas básicas de plástico</option>
									<option
										value="2229 - Fabricación de artículos de plástico n.c.p.">2229
										- Fabricación de artículos de plástico n.c.p.</option>
									<option
										value="2310 - Fabricación de vidrio y productos de vidrio">2310
										- Fabricación de vidrio y productos de vidrio</option>
									<option value="2391 - Fabricación de productos refractarios">2391
										- Fabricación de productos refractarios</option>
									<option
										value="2392 - Fabricación de materiales de arcilla para la construcción">2392
										- Fabricación de materiales de arcilla para la construcción</option>
									<option
										value="2393 - Fabricación de otros productos de cerámica y porcelana">2393
										- Fabricación de otros productos de cerámica y porcelana</option>
									<option value="2394 - Fabricación de cemento, cal y yeso">2394
										- Fabricación de cemento, cal y yeso</option>
									<option
										value="2395 - Fabricación de artículos de hormigón, cemento y yeso">2395
										- Fabricación de artículos de hormigón, cemento y yeso</option>
									<option value="2396 - Corte, tallado y acabado de la piedra">2396
										- Corte, tallado y acabado de la piedra</option>
									<option
										value="2399 - Fabricación de otros productos minerales no metálicos n.c.p.">2399
										- Fabricación de otros productos minerales no metálicos n.c.p.</option>
									<option value="2410 - Industrias básicas de hierro y de acero">2410
										- Industrias básicas de hierro y de acero</option>
									<option value="2421 - Industrias básicas de metales preciosos">2421
										- Industrias básicas de metales preciosos</option>
									<option
										value="2429 - Industrias básicas de otros metales no ferrosos">2429
										- Industrias básicas de otros metales no ferrosos</option>
									<option value="2431 - Fundición de hierro y de acero">2431
										- Fundición de hierro y de acero</option>
									<option value="2432 - Fundición de metales no ferrosos">2432
										- Fundición de metales no ferrosos</option>
									<option
										value="2511 - Fabricación de productos metálicos para uso estructural">2511
										- Fabricación de productos metálicos para uso estructural</option>
									<option
										value="2512 - Fabricación de tanques, depósitos y recipientes de metal, excepto los utilizados para el envase o transporte de mercancías">2512
										- Fabricación de tanques, depósitos y recipientes de metal,
										excepto los utilizados para el envase o transporte de
										mercancías</option>
									<option
										value="2513 - Fabricación de generadores de vapor, excepto calderas de agua caliente para calefacción central">2513
										- Fabricación de generadores de vapor, excepto calderas de
										agua caliente para calefacción central</option>
									<option value="2520 - Fabricación de armas y municiones">2520
										- Fabricación de armas y municiones</option>
									<option
										value="2591 - Forja, prensado, estampado y laminado de metal; pulvimetalurgia">2591
										- Forja, prensado, estampado y laminado de metal;
										pulvimetalurgia</option>
									<option
										value="2592 - Tratamiento y revestimiento de metales; mecanizado">2592
										- Tratamiento y revestimiento de metales; mecanizado</option>
									<option
										value="2593 - Fabricación de artículos de cuchillería, herramientas de mano y artículos de ferretería">2593
										- Fabricación de artículos de cuchillería, herramientas de
										mano y artículos de ferretería</option>
									<option
										value="2599 - Fabricación de otros productos elaborados de metal n.c.p.">2599
										- Fabricación de otros productos elaborados de metal n.c.p.</option>
									<option
										value="2610 - Fabricación de componentes y tableros electrónicos">2610
										- Fabricación de componentes y tableros electrónicos</option>
									<option
										value="2620 - Fabricación de computadoras y de equipo periférico">2620
										- Fabricación de computadoras y de equipo periférico</option>
									<option value="2630 - Fabricación de equipos de comunicación">2630
										- Fabricación de equipos de comunicación</option>
									<option
										value="2640 - Fabricación de aparatos electrónicos de consumo">2640
										- Fabricación de aparatos electrónicos de consumo</option>
									<option
										value="2651 - Fabricación de equipo de medición, prueba, navegación y control">2651
										- Fabricación de equipo de medición, prueba, navegación y
										control</option>
									<option value="2652 - Fabricación de relojes">2652 -
										Fabricación de relojes</option>
									<option
										value="2660 - Fabricación de equipo de irradiación y equipo electrónico de uso médico y terapéutico">2660
										- Fabricación de equipo de irradiación y equipo electrónico de
										uso médico y terapéutico</option>
									<option
										value="2670 - Fabricación de instrumentos ópticos y equipo fotográfico">2670
										- Fabricación de instrumentos ópticos y equipo fotográfico</option>
									<option
										value="2680 - Fabricación de soportes magnéticos y ópticos">2680
										- Fabricación de soportes magnéticos y ópticos</option>
									<option
										value="2711 - Fabricación de motores, generadores y transformadores eléctricos.">2711
										- Fabricación de motores, generadores y transformadores
										eléctricos.</option>
									<option
										value="2712 - Fabricación de aparatos de distribución y control de la energía eléctrica">2712
										- Fabricación de aparatos de distribución y control de la
										energía eléctrica</option>
									<option
										value="2720 - Fabricación de pilas, baterías y acumuladores eléctricos">2720
										- Fabricación de pilas, baterías y acumuladores eléctricos</option>
									<option
										value="2731 - Fabricación de hilos y cables eléctricos y de fibra óptica">2731
										- Fabricación de hilos y cables eléctricos y de fibra óptica</option>
									<option value="2732 - Fabricación de dispositivos de cableado">2732
										- Fabricación de dispositivos de cableado</option>
									<option
										value="2740 - Fabricación de equipos eléctricos de iluminación">2740
										- Fabricación de equipos eléctricos de iluminación</option>
									<option value="2750 - Fabricación de aparatos de uso domestico">2750
										- Fabricación de aparatos de uso domestico</option>
									<option
										value="2790 - Fabricación de otros tipos de equipo eléctrico n.c.p.">2790
										- Fabricación de otros tipos de equipo eléctrico n.c.p.</option>
									<option
										value="2811 - Fabricación de motores, turbinas, y partes para motores de combustión interna">2811
										- Fabricación de motores, turbinas, y partes para motores de
										combustión interna</option>
									<option
										value="2812 - Fabricación de equipos de potencia hidráulica y neumática">2812
										- Fabricación de equipos de potencia hidráulica y neumática</option>
									<option
										value="2813 - Fabricación de otras bombas, compresores, grifos y válvulas">2813
										- Fabricación de otras bombas, compresores, grifos y válvulas</option>
									<option
										value="2814 - Fabricación de cojinetes, engranajes, trenes de engranajes y piezas de transmisión">2814
										- Fabricación de cojinetes, engranajes, trenes de engranajes y
										piezas de transmisión</option>
									<option
										value="2815 - Fabricación de hornos, hogares y quemadores industriales">2815
										- Fabricación de hornos, hogares y quemadores industriales</option>
									<option
										value="2816 - Fabricación de equipo de elevación y manipulación">2816
										- Fabricación de equipo de elevación y manipulación</option>
									<option
										value="2817 - Fabricación de maquinaria y equipo de oficina (excepto computadoras y equipo periférico)">2817
										- Fabricación de maquinaria y equipo de oficina (excepto
										computadoras y equipo periférico)</option>
									<option
										value="2818 - Fabricación de herramientas manuales con motor">2818
										- Fabricación de herramientas manuales con motor</option>
									<option
										value="2819 - Fabricación de otros tipos de maquinaria y equipo de uso general n.c.p.">2819
										- Fabricación de otros tipos de maquinaria y equipo de uso
										general n.c.p.</option>
									<option
										value="2821 - Fabricación de maquinaria agropecuaria y forestal">2821
										- Fabricación de maquinaria agropecuaria y forestal</option>
									<option
										value="2822 - Fabricación de máquinas formadoras de metal y de máquinas herramienta">2822
										- Fabricación de máquinas formadoras de metal y de máquinas
										herramienta</option>
									<option
										value="2823 - Fabricación de maquinaria para la metalurgia">2823
										- Fabricación de maquinaria para la metalurgia</option>
									<option
										value="2824 - Fabricación de maquinaria para explotación de minas y canteras y para obras de construcción">2824
										- Fabricación de maquinaria para explotación de minas y
										canteras y para obras de construcción</option>
									<option
										value="2825 - Fabricación de maquinaria para la elaboración de alimentos, bebidas y tabaco">2825
										- Fabricación de maquinaria para la elaboración de alimentos,
										bebidas y tabaco</option>
									<option
										value="2826 - Fabricación de maquinaria para la elaboración de productos textiles, prendas de vestir y cueros">2826
										- Fabricación de maquinaria para la elaboración de productos
										textiles, prendas de vestir y cueros</option>
									<option
										value="2829 - Fabricación de otros tipos de maquinaria y equipo de uso especial n.c.p.">2829
										- Fabricación de otros tipos de maquinaria y equipo de uso
										especial n.c.p.</option>
									<option
										value="2910 - Fabricación de vehículos automotores y sus motores">2910
										- Fabricación de vehículos automotores y sus motores</option>
									<option
										value="2920 - Fabricación de carrocerías para vehículos automotores; fabricación de remolques y semirremolques">2920
										- Fabricación de carrocerías para vehículos automotores;
										fabricación de remolques y semirremolques</option>
									<option
										value="2930 - Fabricación de partes, piezas (autopartes) y accesorios (lujos) para vehículos automotores">2930
										- Fabricación de partes, piezas (autopartes) y accesorios
										(lujos) para vehículos automotores</option>
									<option
										value="3011 - Construcción de barcos y de estructuras flotantes">3011
										- Construcción de barcos y de estructuras flotantes</option>
									<option
										value="3012 - Construcción de embarcaciones de recreo y deporte">3012
										- Construcción de embarcaciones de recreo y deporte</option>
									<option
										value="3020 - Fabricación de locomotoras y de material rodante para ferrocarriles">3020
										- Fabricación de locomotoras y de material rodante para
										ferrocarriles</option>
									<option
										value="3030 - Fabricación de aeronaves, naves espaciales y de maquinaria conexa">3030
										- Fabricación de aeronaves, naves espaciales y de maquinaria
										conexa</option>
									<option
										value="3040 - Fabricación de vehículos militares de combate">3040
										- Fabricación de vehículos militares de combate</option>
									<option value="3091 - Fabricación de motocicletas">3091
										- Fabricación de motocicletas</option>
									<option
										value="3092 - Fabricación de bicicletas y de sillas de ruedas para personas con discapacidad">3092
										- Fabricación de bicicletas y de sillas de ruedas para
										personas con discapacidad</option>
									<option
										value="3099 - Fabricación de otros tipos de equipo de transporte n.c.p.">3099
										- Fabricación de otros tipos de equipo de transporte n.c.p.</option>
									<option value="3110 - Fabricación de muebles">3110 -
										Fabricación de muebles</option>
									<option value="3120 - Fabricación de colchones y somieres">3120
										- Fabricación de colchones y somieres</option>
									<option
										value="3210 - Fabricación de joyas, bisutería y artículos conexos">3210
										- Fabricación de joyas, bisutería y artículos conexos</option>
									<option value="3220 - Fabricación de instrumentos musicales">3220
										- Fabricación de instrumentos musicales</option>
									<option
										value="3230 - Fabricación de artículos y equipo para la práctica del deporte   (excepto prendas de vestir y calzado)">3230
										- Fabricación de artículos y equipo para la práctica del
										deporte&nbsp;&nbsp; (excepto prendas de vestir y calzado)</option>
									<option
										value="3240 - Fabricación de juegos, juguetes y rompecabezas">3240
										- Fabricación de juegos, juguetes y rompecabezas</option>
									<option
										value="3250 - Fabricación de instrumentos, aparatos y materiales médicos y odontológicos (incluido mobiliario)">3250
										- Fabricación de instrumentos, aparatos y materiales médicos y
										odontológicos (incluido mobiliario)</option>
									<option value="3290 - Otras industrias manufactureras n.c.p.">3290
										- Otras industrias manufactureras n.c.p.</option>
									<option
										value="3311 - Mantenimiento y reparación especializado de productos elaborados en metal">3311
										- Mantenimiento y reparación especializado de productos
										elaborados en metal</option>
									<option
										value="3312 - Mantenimiento y reparación especializado de maquinaria y equipo">3312
										- Mantenimiento y reparación especializado de maquinaria y
										equipo</option>
									<option
										value="3313 - Mantenimiento y reparación especializado de equipo electrónico y óptico">3313
										- Mantenimiento y reparación especializado de equipo
										electrónico y óptico</option>
									<option
										value="3314 - Mantenimiento y reparación especializado de equipo eléctrico">3314
										- Mantenimiento y reparación especializado de equipo eléctrico</option>
									<option
										value="3315 - Mantenimiento y reparación especializado de equipo de transporte, excepto los vehículos automotores, motocicletas y bicicletas">3315
										- Mantenimiento y reparación especializado de equipo de
										transporte, excepto los vehículos automotores, motocicletas y
										bicicletas</option>
									<option
										value="3319 - Mantenimiento y reparación de otros tipos de equipos y sus componentes n.c.p.">3319
										- Mantenimiento y reparación de otros tipos de equipos y sus
										componentes n.c.p.</option>
									<option
										value="3320 - Instalación especializada de maquinaria y equipo industrial">3320
										- Instalación especializada de maquinaria y equipo industrial</option>
									<option value="3511 - Generación de energía eléctrica">3511
										- Generación de energía eléctrica</option>
									<option value="3512 - Transmisión de energía eléctrica">3512
										- Transmisión de energía eléctrica</option>
									<option value="3513 - Distribución de energía eléctrica">3513
										- Distribución de energía eléctrica</option>
									<option value="3514 - Comercialización de energía eléctrica">3514
										- Comercialización de energía eléctrica</option>
									<option value="3530 - Suministro de vapor y aire acondicionado">3530
										- Suministro de vapor y aire acondicionado</option>
									<option
										value="3700 - Evacuación y tratamiento de aguas residuales">3700
										- Evacuación y tratamiento de aguas residuales</option>
									<option value="3811 - Recolección de desechos no peligrosos">3811
										- Recolección de desechos no peligrosos</option>
									<option value="3812 - Recolección de desechos peligrosos">3812
										- Recolección de desechos peligrosos</option>
									<option
										value="3821 - Tratamiento y disposición de desechos no peligrosos">3821
										- Tratamiento y disposición de desechos no peligrosos</option>
									<option
										value="3822 - Tratamiento y disposición de desechos peligrosos">3822
										- Tratamiento y disposición de desechos peligrosos</option>
									<option value="3830 - Recuperación de materiales">3830
										- Recuperación de materiales</option>
									<option value="4111 - Construcción de edificios residenciales">4111
										- Construcción de edificios residenciales</option>
									<option
										value="4112 - Construcción de edificios no residenciales">4112
										- Construcción de edificios no residenciales</option>
									<option
										value="4210 - Construcción de carreteras y vías de ferrocarril">4210
										- Construcción de carreteras y vías de ferrocarril</option>
									<option
										value="4220 - Construcción de proyectos de servicio público">4220
										- Construcción de proyectos de servicio público</option>
									<option
										value="4290 - Construcción de otras obras de ingeniería civil">4290
										- Construcción de otras obras de ingeniería civil</option>
									<option value="4311 - Demolición">4311 - Demolición</option>
									<option value="4312 - Preparación del terreno">4312 -
										Preparación del terreno</option>
									<option
										value="4321 - Instalaciones eléctricas de la construcción">4321
										- Instalaciones eléctricas de la construcción</option>
									<option
										value="4322 - Instalaciones de fontanería, calefacción y aire acondicionado de la construcción">4322
										- Instalaciones de fontanería, calefacción y aire
										acondicionado de la construcción</option>
									<option
										value="4329 - Otras instalaciones especializadas de la construcción">4329
										- Otras instalaciones especializadas de la construcción</option>
									<option
										value="4330 - Terminación y acabado de edificios y obras de ingeniería civil">4330
										- Terminación y acabado de edificios y obras de ingeniería
										civil</option>
									<option
										value="4390 - Otras actividades especializadas para la construcción de edificios y obras de ingeniería civil">4390
										- Otras actividades especializadas para la construcción de
										edificios y obras de ingeniería civil</option>
									<option value="4511 - Comercio de vehículos automotores nuevos">4511
										- Comercio de vehículos automotores nuevos</option>
									<option value="4512 - Comercio de vehículos automotores usados">4512
										- Comercio de vehículos automotores usados</option>
									<option
										value="4520 - Mantenimiento y reparación de vehículos automotores.">4520
										- Mantenimiento y reparación de vehículos automotores.</option>
									<option
										value="4530 - Comercio de partes, piezas (autopartes) y accesorios (lujos) para vehículos automotores">4530
										- Comercio de partes, piezas (autopartes) y accesorios (lujos)
										para vehículos automotores</option>
									<option
										value="4542 - Mantenimiento y reparación de motocicletas y de sus partes y piezas">4542
										- Mantenimiento y reparación de motocicletas y de sus partes y
										piezas</option>
									<option
										value="4610 - Comercio al por mayor a cambio de una retribución o por contrata">4610
										- Comercio al por mayor a cambio de una retribución o por
										contrata</option>
									<option
										value="4631 - Comercio al por mayor de productos alimenticios">4631
										- Comercio al por mayor de productos alimenticios</option>
									<option
										value="4641 - Comercio al por mayor de productos textiles y productos confeccionados para uso doméstico">4641
										- Comercio al por mayor de productos textiles y productos
										confeccionados para uso doméstico</option>
									<option
										value="4642 - Comercio al por mayor de prendas de vestir">4642
										- Comercio al por mayor de prendas de vestir</option>
									<option value="4643 - Comercio al por mayor de calzado">4643
										- Comercio al por mayor de calzado</option>
									<option
										value="4644 - Comercio al por mayor de aparatos y equipo de uso doméstico">4644
										- Comercio al por mayor de aparatos y equipo de uso doméstico</option>
									<option
										value="4651 - Comercio al por mayor de computadores, equipo periférico y programas de informática">4651
										- Comercio al por mayor de computadores, equipo periférico y
										programas de informática</option>
									<option
										value="4652 - Comercio al por mayor de equipo, partes y piezas electrónicos y de telecomunicaciones">4652
										- Comercio al por mayor de equipo, partes y piezas
										electrónicos y de telecomunicaciones</option>
									<option
										value="4653 - Comercio al por mayor de maquinaria y equipo agropecuarios">4653
										- Comercio al por mayor de maquinaria y equipo agropecuarios</option>
									<option
										value="4659 - Comercio al por mayor de otros tipos de maquinaria y equipo n.c.p.">4659
										- Comercio al por mayor de otros tipos de maquinaria y equipo
										n.c.p.</option>
									<option
										value="4662 - Comercio al por mayor de metales y productos metalíferos">4662
										- Comercio al por mayor de metales y productos metalíferos</option>
									<option
										value="4664 - Comercio al por mayor de productos químicos básicos, cauchos y plásticos en formas primarias y productos químicos de uso agropec">4664
										- Comercio al por mayor de productos químicos básicos, cauchos
										y plásticos en formas primarias y productos químicos de uso
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
										value="4721 - Comercio al por menor de productos agrícolas para el consumo en establecimientos especializados">4721
										- Comercio al por menor de productos agrícolas para el consumo
										en establecimientos especializados</option>
									<option
										value="4722 - Comercio al por menor de leche, productos lácteos y huevos, en establecimientos especializados">4722
										- Comercio al por menor de leche, productos lácteos y huevos,
										en establecimientos especializados</option>
									<option
										value="4723 - Comercio al por menor de carnes (incluye aves de corral), productos cárnicos, pescados y productos de mar, en establecimientos e">4723
										- Comercio al por menor de carnes (incluye aves de corral),
										productos cárnicos, pescados y productos de mar, en
										establecimientos e</option>
									<option
										value="4729 - Comercio al por menor de otros productos alimenticios n.c.p., en establecimientos especializados">4729
										- Comercio al por menor de otros productos alimenticios
										n.c.p., en establecimientos especializados</option>
									<option
										value="4731 - Comercio al por menor de combustible para automotores">4731
										- Comercio al por menor de combustible para automotores</option>
									<option
										value="4732 - Comercio al por menor de lubricantes (aceites, grasas), aditivos y productos de limpieza para vehículos automotores">4732
										- Comercio al por menor de lubricantes (aceites, grasas),
										aditivos y productos de limpieza para vehículos automotores</option>
									<option
										value="4741 - Comercio al por menor de computadores, equipos periféricos, programas de informática y equipos de telecomunicaciones en establec">4741
										- Comercio al por menor de computadores, equipos periféricos,
										programas de informática y equipos de telecomunicaciones en
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
										value="4754 - Comercio al por menor de electrodomésticos y gasodomesticos de uso doméstico, muebles y equipos de iluminación">4754
										- Comercio al por menor de electrodomésticos y gasodomesticos
										de uso doméstico, muebles y equipos de iluminación</option>
									<option
										value="4755 - Comercio al por menor de artículos y utensilios de uso domestico">4755
										- Comercio al por menor de artículos y utensilios de uso
										domestico</option>
									<option
										value="4759 - Comercio al por menor de otros artículos domésticos en establecimientos especializados">4759
										- Comercio al por menor de otros artículos domésticos en
										establecimientos especializados</option>
									<option
										value="4762 - Comercio al por menor de artículos deportivos, en establecimientos especializados">4762
										- Comercio al por menor de artículos deportivos, en
										establecimientos especializados</option>
									<option
										value="4769 - Comercio al por menor de otros artículos culturales y de entretenimiento n.c.p. en establecimientos especializados">4769
										- Comercio al por menor de otros artículos culturales y de
										entretenimiento n.c.p. en establecimientos especializados</option>
									<option
										value="4771 - Comercio al por menor de prendas de vestir y sus accesorios (incluye artículos de piel) en establecimientos especializados">4771
										- Comercio al por menor de prendas de vestir y sus accesorios
										(incluye artículos de piel) en establecimientos especializados</option>
									<option
										value="4772 - Comercio al por menor de todo tipo de calzado y artículos de cuero y sucedáneos del cuero en establecimientos especializados.">4772
										- Comercio al por menor de todo tipo de calzado y artículos de
										cuero y sucedáneos del cuero en establecimientos
										especializados.</option>
									<option
										value="4774 - Comercio al por menor de otros productos nuevos en establecimientos especializados">4774
										- Comercio al por menor de otros productos nuevos en
										establecimientos especializados</option>
									<option
										value="4775 - Comercio al por menor de artículos de segunda mano">4775
										- Comercio al por menor de artículos de segunda mano</option>
									<option
										value="4782 - Comercio al por menor de productos textiles, prendas de vestir y calzado, en puestos de venta móviles">4782
										- Comercio al por menor de productos textiles, prendas de
										vestir y calzado, en puestos de venta móviles</option>
									<option
										value="4789 - Comercio al por menor de otros productos en puestos de venta móviles">4789
										- Comercio al por menor de otros productos en puestos de venta
										móviles</option>
									<option value="4911 - Transporte férreo de pasajeros">4911
										- Transporte férreo de pasajeros</option>
									<option value="4912 - Transporte férreo de carga">4912
										- Transporte férreo de carga</option>
									<option value="4921 - Transporte de pasajeros">4921 -
										Transporte de pasajeros</option>
									<option value="4922 - Transporte mixto">4922 -
										Transporte mixto</option>
									<option value="4923 - Transporte de carga por carretera">4923
										- Transporte de carga por carretera</option>
									<option value="4930 - Transporte por tuberías">4930 -
										Transporte por tuberías</option>
									<option
										value="5011 - Transporte de pasajeros marítimo y de cabotaje">5011
										- Transporte de pasajeros marítimo y de cabotaje</option>
									<option
										value="5012 - Transporte de carga marítimo y de cabotaje">5012
										- Transporte de carga marítimo y de cabotaje</option>
									<option value="5021 - Transporte fluvial de pasajeros">5021
										- Transporte fluvial de pasajeros</option>
									<option value="5022 - Transporte fluvial de carga">5022
										- Transporte fluvial de carga</option>
									<option value="5111 - Transporte aéreo nacional de pasajeros">5111
										- Transporte aéreo nacional de pasajeros</option>
									<option
										value="5112 - Transporte aéreo internacional de pasajeros">5112
										- Transporte aéreo internacional de pasajeros</option>
									<option value="5121 - Transporte aéreo nacional de carga">5121
										- Transporte aéreo nacional de carga</option>
									<option value="5122 - Transporte aéreo internacional de carga">5122
										- Transporte aéreo internacional de carga</option>
									<option value="5210 - Almacenamiento y depósito">5210
										- Almacenamiento y depósito</option>
									<option
										value="5221 - Actividades de estaciones, vías y servicios complementarios para el transporte terrestre">5221
										- Actividades de estaciones, vías y servicios complementarios
										para el transporte terrestre</option>
									<option
										value="5222 - Actividades de puertos y servicios complementarios para el transporte acuático">5222
										- Actividades de puertos y servicios complementarios para el
										transporte acuático</option>
									<option
										value="5223 - Actividades de aeropuertos, servicios de navegación aérea y demás actividades conexas al transporte aéreo">5223
										- Actividades de aeropuertos, servicios de navegación aérea y
										demás actividades conexas al transporte aéreo</option>
									<option value="5224 - Manipulación de carga">5224 -
										Manipulación de carga</option>
									<option
										value="5229 - Otras actividades complementarias al transporte">5229
										- Otras actividades complementarias al transporte</option>
									<option value="5310 - Actividades postales nacionales">5310
										- Actividades postales nacionales</option>
									<option value="5320 - Actividades de mensajería">5320
										- Actividades de mensajería</option>
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
										value="5520 - Actividades de zonas de camping y parques para vehículos recreacionales">5520
										- Actividades de zonas de camping y parques para vehículos
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
										value="5613 - Expendio de comidas preparadas en cafeterías">5613
										- Expendio de comidas preparadas en cafeterías</option>
									<option
										value="5619 - Otros tipos de expendio de comidas preparadas n.c.p.">5619
										- Otros tipos de expendio de comidas preparadas n.c.p.</option>
									<option value="5621 - Catering para eventos">5621 -
										Catering para eventos</option>
									<option
										value="5629 - Actividades de otros servicios de comidas">5629
										- Actividades de otros servicios de comidas</option>
									<option
										value="5630 - Expendio de bebidas alcohólicas para el consumo dentro del establecimiento">5630
										- Expendio de bebidas alcohólicas para el consumo dentro del
										establecimiento</option>
									<option
										value="5812 - Edición de directorios y listas de correo">5812
										- Edición de directorios y listas de correo</option>
									<option
										value="5813 - Edición de periódicos, revistas y otras publicaciones periódicas">5813
										- Edición de periódicos, revistas y otras publicaciones
										periódicas</option>
									<option value="5819 - Otros trabajos de edición">5819
										- Otros trabajos de edición</option>
									<option
										value="5820 - Edición de programas de informática (software)">5820
										- Edición de programas de informática (software)</option>
									<option
										value="5911 - Actividades de producción de películas cinematográficas, videos, programas, anuncios y comerciales de televisión (excepto progra">5911
										- Actividades de producción de películas cinematográficas,
										videos, programas, anuncios y comerciales de televisión
										(excepto progra</option>
									<option
										value="5912 - Actividades de postproducción de películas cinematográficas, videos, programas, anuncios y comerciales de televisión  (excepto p">5912
										- Actividades de postproducción de películas cinematográficas,
										videos, programas, anuncios y comerciales de televisión&nbsp;
										(excepto p</option>
									<option
										value="5913 - Actividades de distribución de películas cinematográficas, videos, programas, anuncios y comerciales de televisión">5913
										- Actividades de distribución de películas cinematográficas,
										videos, programas, anuncios y comerciales de televisión</option>
									<option
										value="5914 - Actividades de exhibición de películas cinematográficas y videos">5914
										- Actividades de exhibición de películas cinematográficas y
										videos</option>
									<option
										value="5920 - Actividades de grabación de sonido y edición de música">5920
										- Actividades de grabación de sonido y edición de música</option>
									<option
										value="6010 - Actividades de programación y transmisión en el servicio de radiodifusión sonora">6010
										- Actividades de programación y transmisión en el servicio de
										radiodifusión sonora</option>
									<option
										value="6020 - Actividades de programación y transmisión de televisión">6020
										- Actividades de programación y transmisión de televisión</option>
									<option
										value="6110 - Actividades de telecomunicaciones alámbricas">6110
										- Actividades de telecomunicaciones alámbricas</option>
									<option
										value="6120 - Actividades de telecomunicaciones inalámbricas">6120
										- Actividades de telecomunicaciones inalámbricas</option>
									<option
										value="6130 - Actividades de telecomunicación satelital">6130
										- Actividades de telecomunicación satelital</option>
									<option value="6190 - Otras actividades de telecomunicaciones">6190
										- Otras actividades de telecomunicaciones</option>
									<option
										value="6201 - Actividades de desarrollo de sistemas informáticos (planificación, análisis, diseño, programación, pruebas)">6201
										- Actividades de desarrollo de sistemas informáticos
										(planificación, análisis, diseño, programación, pruebas)</option>
									<option
										value="6202 - Actividades de consultoría informática y actividades de administración de instalaciones informáticas">6202
										- Actividades de consultoría informática y actividades de
										administración de instalaciones informáticas</option>
									<option
										value="6209 - Otras actividades de tecnologías de información y actividades de servicios informáticos">6209
										- Otras actividades de tecnologías de información y
										actividades de servicios informáticos</option>
									<option
										value="6311 - Procesamiento de datos, alojamiento (hosting) y actividades relacionadas">6311
										- Procesamiento de datos, alojamiento (hosting) y actividades
										relacionadas</option>
									<option value="6312 - Portales Web">6312 - Portales
										Web</option>
									<option value="6391 - Actividades de agencias de noticias">6391
										- Actividades de agencias de noticias</option>
									<option
										value="6399 - Otras actividades de servicio de información n.c.p.">6399
										- Otras actividades de servicio de información n.c.p.</option>
									<option value="6411 - Banca Central">6411 - Banca
										Central</option>
									<option value="6412 - Bancos comerciales">6412 -
										Bancos comerciales</option>
									<option
										value="6421 - Actividades de las corporaciones financieras">6421
										- Actividades de las corporaciones financieras</option>
									<option
										value="6422 - Actividades de las compañías de financiamiento">6422
										- Actividades de las compañías de financiamiento</option>
									<option value="6423 - Banca de segundo piso">6423 -
										Banca de segundo piso</option>
									<option
										value="6424 - Actividades de las cooperativas financieras">6424
										- Actividades de las cooperativas financieras</option>
									<option
										value="6431 - Fideicomisos, fondos y entidades financieras similares">6431
										- Fideicomisos, fondos y entidades financieras similares</option>
									<option value="6432 - Fondos de cesantías">6432 -
										Fondos de cesantías</option>
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
										value="6494 - Otras actividades de distribución de fondos">6494
										- Otras actividades de distribución de fondos</option>
									<option value="6495 - Instituciones especiales oficiales">6495
										- Instituciones especiales oficiales</option>
									<option value="6511 - Seguros generales">6511 -
										Seguros generales</option>
									<option value="6512 - Seguros de vida">6512 - Seguros
										de vida</option>
									<option value="6513 - Reaseguros">6513 - Reaseguros</option>
									<option value="6514 - Capitalización">6514 -
										Capitalización</option>
									<option value="6521 - Servicios de seguros sociales de salud">6521
										- Servicios de seguros sociales de salud</option>
									<option
										value="6522 - Servicios de seguros sociales de riesgos profesionales">6522
										- Servicios de seguros sociales de riesgos profesionales</option>
									<option
										value="6531 - Régimen de prima media con prestación definida (RPM)">6531
										- Régimen de prima media con prestación definida (RPM)</option>
									<option value="6532 - Régimen de ahorro individual (RAI)">6532
										- Régimen de ahorro individual (RAI)</option>
									<option
										value="6612 - Corretaje de valores y de contratos de productos básicos">6612
										- Corretaje de valores y de contratos de productos básicos</option>
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
										value="6629 - Evaluación de riesgos y daños, y otras actividades de servicios auxiliares">6629
										- Evaluación de riesgos y daños, y otras actividades de
										servicios auxiliares</option>
									<option value="6630 - Actividades de administración de fondos">6630
										- Actividades de administración de fondos</option>
									<option
										value="6810 - Actividades inmobiliarias realizadas con bienes propios o arrendados">6810
										- Actividades inmobiliarias realizadas con bienes propios o
										arrendados</option>
									<option
										value="6820 - Actividades inmobiliarias realizadas a cambio de una retribución o por contrata">6820
										- Actividades inmobiliarias realizadas a cambio de una
										retribución o por contrata</option>
									<option value="7310 - Publicidad">7310 - Publicidad</option>
									<option value="7420 - Actividades de fotografía">7420
										- Actividades de fotografía</option>
									<option value="7500 - Actividades veterinarias">7500 -
										Actividades veterinarias</option>
									<option
										value="7710 - Alquiler y arrendamiento de vehículos automotores">7710
										- Alquiler y arrendamiento de vehículos automotores</option>
									<option
										value="7721 - Alquiler y arrendamiento de equipo recreativo y deportivo">7721
										- Alquiler y arrendamiento de equipo recreativo y deportivo</option>
									<option value="7722 - Alquiler de videos y discos">7722
										- Alquiler de videos y discos</option>
									<option
										value="7729 - Alquiler y arrendamiento de otros efectos personales y enseres domésticos n.c.p.">7729
										- Alquiler y arrendamiento de otros efectos personales y
										enseres domésticos n.c.p.</option>
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
									<option value="7912 - Actividades de operadores turísticos">7912
										- Actividades de operadores turísticos</option>
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
										value="8219 - Fotocopiado, preparación de documentos y otras actividades especializadas de apoyo a oficina">8219
										- Fotocopiado, preparación de documentos y otras actividades
										especializadas de apoyo a oficina</option>
									<option
										value="8220 - Actividades de centros de llamadas (Call center)">8220
										- Actividades de centros de llamadas (Call center)</option>
									<option
										value="8230 - Organización de convenciones y eventos comerciales">8230
										- Organización de convenciones y eventos comerciales</option>
									<option
										value="8291 - Actividades de agencias de cobranza y oficinas de calificación crediticia">8291
										- Actividades de agencias de cobranza y oficinas de
										calificación crediticia</option>
									<option value="8292 - Actividades de envase y empaque">8292
										- Actividades de envase y empaque</option>
									<option
										value="8299 - Otras actividades de servicio de apoyo a las empresas n.c.p.">8299
										- Otras actividades de servicio de apoyo a las empresas n.c.p.</option>
									<option
										value="8411 - Actividades legislativas de la administración pública">8411
										- Actividades legislativas de la administración pública</option>
									<option
										value="8412 - Actividades ejecutivas de la administración pública">8412
										- Actividades ejecutivas de la administración pública</option>
									<option
										value="8413 - Regulación de las actividades de organismos que prestan servicios de salud, educativos, culturales y otros servicios sociales, e">8413
										- Regulación de las actividades de organismos que prestan
										servicios de salud, educativos, culturales y otros servicios
										sociales, e</option>
									<option
										value="8414 - Actividades reguladoras y facilitadoras de la actividad económica">8414
										- Actividades reguladoras y facilitadoras de la actividad
										económica</option>
									<option
										value="8415 - Actividades de los otros órganos de control">8415
										- Actividades de los otros órganos de control</option>
									<option value="8421 - Relaciones exteriores">8421 -
										Relaciones exteriores</option>
									<option value="8422 - Actividades de defensa">8422 -
										Actividades de defensa</option>
									<option
										value="8423 - Orden público y actividades de seguridad publica">8423
										- Orden público y actividades de seguridad publica</option>
									<option value="8424 - Administración de justicia">8424
										- Administración de justicia</option>
									<option
										value="8430 - Actividades de planes de Seguridad Social de afiliación obligatoria">8430
										- Actividades de planes de Seguridad Social de afiliación
										obligatoria</option>
									<option value="8511 - Educación de la primera infancia">8511
										- Educación de la primera infancia</option>
									<option value="8512 - Educación preescolar">8512 -
										Educación preescolar</option>
									<option value="8513 - Educación básica primaria">8513
										- Educación básica primaria</option>
									<option value="8521 - Educación básica secundaria">8521
										- Educación básica secundaria</option>
									<option value="8522 - Educación media académica">8522
										- Educación media académica</option>
									<option
										value="8530 - Establecimientos que combinan diferentes niveles de educación inicial, preescolar, básica primaria, básica secundaria y media">8530
										- Establecimientos que combinan diferentes niveles de
										educación inicial, preescolar, básica primaria, básica
										secundaria y media</option>
									<option value="8541 - Educación técnica profesional">8541
										- Educación técnica profesional</option>
									<option value="8542 - Educación tecnológica">8542 -
										Educación tecnológica</option>
									<option
										value="8543 - Educación de instituciones universitarias o de escuelas tecnológicas">8543
										- Educación de instituciones universitarias o de escuelas
										tecnológicas</option>
									<option value="8544 - Educación de universidades">8544
										- Educación de universidades</option>
									<option value="8552 - Enseñanza deportiva y recreativa">8552
										- Enseñanza deportiva y recreativa</option>
									<option value="8553 - Enseñanza cultural">8553 -
										Enseñanza cultural</option>
									<option value="8559 - Otros tipos de educación n.c.p.">8559
										- Otros tipos de educación n.c.p.</option>
									<option value="8560 - Actividades de apoyo a la educación">8560
										- Actividades de apoyo a la educación</option>
									<option
										value="8610 - Actividades de hospitales y clínicas, con internación">8610
										- Actividades de hospitales y clínicas, con internación</option>
									<option
										value="8720 - Actividades de atención residencial, para el cuidado de pacientes con retardo mental, enfermedad mental y consumo de sustancias">8720
										- Actividades de atención residencial, para el cuidado de
										pacientes con retardo mental, enfermedad mental y consumo de
										sustancias</option>
									<option
										value="8730 - Actividades de atención en instituciones para el cuidado de personas mayores y/o discapacitadas">8730
										- Actividades de atención en instituciones para el cuidado de
										personas mayores y/o discapacitadas</option>
									<option
										value="8790 - Otras actividades de atención en instituciones con alojamiento">8790
										- Otras actividades de atención en instituciones con
										alojamiento</option>
									<option
										value="8810 - Actividades de asistencia social sin alojamiento para personas mayores y discapacitadas">8810
										- Actividades de asistencia social sin alojamiento para
										personas mayores y discapacitadas</option>
									<option
										value="8890 - Otras actividades de asistencia social sin alojamiento">8890
										- Otras actividades de asistencia social sin alojamiento</option>
									<option value="9001 - Creación literaria">9001 -
										Creación literaria</option>
									<option value="9002 - Creación musical">9002 -
										Creación musical</option>
									<option value="9003 - Creación teatral">9003 -
										Creación teatral</option>
									<option value="9004 - Creación audiovisual">9004 -
										Creación audiovisual</option>
									<option value="9005 - Artes plásticas y visuales">9005
										- Artes plásticas y visuales</option>
									<option value="9006 - Actividades teatrales">9006 -
										Actividades teatrales</option>
									<option
										value="9007 - Actividades de espectáculos musicales en vivo">9007
										- Actividades de espectáculos musicales en vivo</option>
									<option
										value="9008 - Otras actividades de espectáculos en vivo">9008
										- Otras actividades de espectáculos en vivo</option>
									<option value="9101 - Actividades de Bibliotecas y archivos">9101
										- Actividades de Bibliotecas y archivos</option>
									<option
										value="9102 - Actividades y funcionamiento de museos, conservación de edificios y sitios históricos">9102
										- Actividades y funcionamiento de museos, conservación de
										edificios y sitios históricos</option>
									<option
										value="9103 - Actividades de jardines botánicos, zoológicos y reservas naturales">9103
										- Actividades de jardines botánicos, zoológicos y reservas
										naturales</option>
									<option value="9311 - Gestión de instalaciones deportivas">9311
										- Gestión de instalaciones deportivas</option>
									<option value="9312 - Actividades de clubes deportivos">9312
										- Actividades de clubes deportivos</option>
									<option value="9319 - Otras actividades deportivas">9319
										- Otras actividades deportivas</option>
									<option
										value="9321 - Actividades de parques de atracciones y parques temáticos">9321
										- Actividades de parques de atracciones y parques temáticos</option>
									<option
										value="9411 - Actividades de asociaciones empresariales y de empleadores">9411
										- Actividades de asociaciones empresariales y de empleadores</option>
									<option
										value="9412 - Actividades de asociaciones profesionales y gremiales sin ánimo de lucro">9412
										- Actividades de asociaciones profesionales y gremiales sin
										ánimo de lucro</option>
									<option value="9420 - Actividades de sindicatos">9420
										- Actividades de sindicatos</option>
									<option value="9491 - Actividades de asociaciones religiosas">9491
										- Actividades de asociaciones religiosas</option>
									<option value="9492 - Actividades de partidos políticos">9492
										- Actividades de partidos políticos</option>
									<option value="9499 - Actividades de otras asociaciones n.c.p.">9499
										- Actividades de otras asociaciones n.c.p.</option>
									<option
										value="9511 - Mantenimiento y reparación de computadores y de equipo periférico">9511
										- Mantenimiento y reparación de computadores y de equipo
										periférico</option>
									<option
										value="9512 - Mantenimiento y reparación de equipos de comunicación">9512
										- Mantenimiento y reparación de equipos de comunicación</option>
									<option
										value="9521 - Mantenimiento y reparación de aparatos electrónicos de consumo">9521
										- Mantenimiento y reparación de aparatos electrónicos de
										consumo</option>
									<option
										value="9522 - Mantenimiento y reparación de aparatos domésticos y equipos domésticos y de jardinería">9522
										- Mantenimiento y reparación de aparatos domésticos y equipos
										domésticos y de jardinería</option>
									<option
										value="9523 - Reparación de calzado y artículos de cuero">9523
										- Reparación de calzado y artículos de cuero</option>
									<option
										value="9524 - Reparación de muebles y accesorios para el hogar">9524
										- Reparación de muebles y accesorios para el hogar</option>
									<option
										value="9529 - Mantenimiento y reparación de otros efectos personales y enseres domésticos">9529
										- Mantenimiento y reparación de otros efectos personales y
										enseres domésticos</option>
									<option
										value="9601 - Lavado y limpieza, incluso la limpieza en seco, de productos textiles y de piel">9601
										- Lavado y limpieza, incluso la limpieza en seco, de productos
										textiles y de piel</option>
									<option
										value="9602 - Peluquería y otros tratamientos de belleza">9602
										- Peluquería y otros tratamientos de belleza</option>
									<option
										value="9603 - Pompas fúnebres y actividades relacionadas">9603
										- Pompas fúnebres y actividades relacionadas</option>
									<option
										value="9609 - Otras actividades de servicios personales n.c.p.">9609
										- Otras actividades de servicios personales n.c.p.</option>
									<option
										value="9700 - Actividades de los hogares individuales como empleadores de personal doméstico">9700
										- Actividades de los hogares individuales como empleadores de
										personal doméstico</option>
									<option
										value="9810 - Actividades no diferenciadas de los hogares individuales como productores de bienes para uso propio">9810
										- Actividades no diferenciadas de los hogares individuales
										como productores de bienes para uso propio</option>
									<option
										value="9820 - Actividades no diferenciadas de los hogares individuales como productores de servicios para uso propio">9820
										- Actividades no diferenciadas de los hogares individuales
										como productores de servicios para uso propio</option>
									<option
										value="9900 - Actividades de organizaciones y entidades extraterritoriales signatarios de la Convención de Viena">9900
										- Actividades de organizaciones y entidades extraterritoriales
										signatarios de la Convención de Viena</option>
									<option
										value="10201 - Procesamiento y conservación de frutas, legumbres, hortalizas y tubérculos (excepto elaboración de jugos de frutas)">10201
										- Procesamiento y conservación de frutas, legumbres,
										hortalizas y tubérculos (excepto elaboración de jugos de
										frutas)</option>
									<option value="10202 - Elaboración de jugos de frutas">10202
										- Elaboración de jugos de frutas</option>
									<option
										value="10401 - Elaboración de productos lácteos (excepto bebidas)">10401
										- Elaboración de productos lácteos (excepto bebidas)</option>
									<option value="10402 - Elaboración de bebidas lácteas">10402
										- Elaboración de bebidas lácteas</option>
									<option
										value="14201 - Fabricación de prendas de vestir de piel">14201
										- Fabricación de prendas de vestir de piel</option>
									<option
										value="14202 - Fabricación de artículos de piel (excepto prendas de vestir)">14202
										- Fabricación de artículos de piel (excepto prendas de vestir)</option>
									<option
										value="14301 - Fabricación de prendas de vestir  de punto y ganchillo">14301
										- Fabricación de prendas de vestir&nbsp; de punto y ganchillo</option>
									<option
										value="14302 - Fabricación de artículos de punto y ganchillo (excepto prendas de vestir)">14302
										- Fabricación de artículos de punto y ganchillo (excepto
										prendas de vestir)</option>
									<option value="35201 - Producción de gas">35201 -
										Producción de gas</option>
									<option
										value="35202 - Distribución de combustibles gaseosos por tuberías">35202
										- Distribución de combustibles gaseosos por tuberías</option>
									<option value="36001 - Captación y tratamiento de agua">36001
										- Captación y tratamiento de agua</option>
									<option value="36002 - Distribución de agua">36002 -
										Distribución de agua</option>
									<option
										value="39001 - Actividades de saneamiento ambiental y otros servicios de gestión de desechos (excepto los servicios prestados por contratistas">39001
										- Actividades de saneamiento ambiental y otros servicios de
										gestión de desechos (excepto los servicios prestados por
										contratistas</option>
									<option
										value="39002 - Actividades de saneamiento ambiental y otros servicios de gestión de desechos prestados por contratistas de construcción, constr">39002
										- Actividades de saneamiento ambiental y otros servicios de
										gestión de desechos prestados por contratistas de
										construcción, constr</option>
									<option value="45411 - Comercio de motocicletas">45411
										- Comercio de motocicletas</option>
									<option
										value="45412 - Comercio de partes, piezas y accesorios de motocicletas">45412
										- Comercio de partes, piezas y accesorios de motocicletas</option>
									<option
										value="46201 - Comercio al por mayor de materias primas agrícolas en bruto (alimentos)">46201
										- Comercio al por mayor de materias primas agrícolas en bruto
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
										value="46451 - Comercio al por mayor de productos farmacéuticos y medicinales">46451
										- Comercio al por mayor de productos farmacéuticos y
										medicinales</option>
									<option
										value="46452 - Comercio al por mayor de productos cosméticos y de tocador (excepto productos farmacéuticos y medicinales)">46452
										- Comercio al por mayor de productos cosméticos y de tocador
										(excepto productos farmacéuticos y medicinales)</option>
									<option
										value="46491 - Comercio al por mayor de otros utensilios domésticos n.c.p. (excepto joyas)">46491
										- Comercio al por mayor de otros utensilios domésticos n.c.p.
										(excepto joyas)</option>
									<option value="46492 - Venta de joyas">46492 - Venta
										de joyas</option>
									<option
										value="46611 - Comercio al por mayor de combustibles sólidos, líquidos, gaseosos y productos conexos (excepto combustibles derivados del petról">46611
										- Comercio al por mayor de combustibles sólidos, líquidos,
										gaseosos y productos conexos (excepto combustibles derivados
										del petról</option>
									<option
										value="46612 - Comercio al por mayor de combustibles  derivados del petróleo">46612
										- Comercio al por mayor de combustibles&nbsp; derivados del
										petróleo</option>
									<option
										value="46631 - Comercio al por mayor de materiales de construcción">46631
										- Comercio al por mayor de materiales de construcción</option>
									<option
										value="46632 - Comercio al por mayor de  artículos de ferretería, pinturas, productos de vidrio, equipo y materiales de fontanería y calefacció">46632
										- Comercio al por mayor de&nbsp; artículos de ferretería,
										pinturas, productos de vidrio, equipo y materiales de
										fontanería y calefacció</option>
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
										value="47521 - Comercio al por menor de materiales de construcción">47521
										- Comercio al por menor de materiales de construcción</option>
									<option
										value="47522 - Comercio al por menor de artículos de ferretería, pinturas y productos de vidrio en establecimientos especializados (excepto mat">47522
										- Comercio al por menor de artículos de ferretería, pinturas y
										productos de vidrio en establecimientos especializados
										(excepto mat</option>
									<option
										value="47611 - Comercio al por menor de libros, textos escolares y cuadernos">47611
										- Comercio al por menor de libros, textos escolares y
										cuadernos</option>
									<option
										value="47612 - Comercio al por menor de periódicos, materiales y artículos de papelería y escritorio, en establecimientos especializados (excep">47612
										- Comercio al por menor de periódicos, materiales y artículos
										de papelería y escritorio, en establecimientos especializados
										(excep</option>
									<option
										value="47731 - Comercio al por menor de productos farmacéuticos y medicinales en establecimientos especializados">47731
										- Comercio al por menor de productos farmacéuticos y
										medicinales en establecimientos especializados</option>
									<option
										value="47732 - Comercio al por menor de productos cosméticos y artículos de tocador en establecimientos especializados (excepto productos  farm">47732
										- Comercio al por menor de productos cosméticos y artículos de
										tocador en establecimientos especializados (excepto
										productos&nbsp; farm</option>
									<option
										value="47811 - Comercio al por menor de alimentos en puestos de venta móviles">47811
										- Comercio al por menor de alimentos en puestos de venta
										móviles</option>
									<option
										value="47812 - Comercio al por menor de  bebidas y tabaco en puestos de venta móviles (excepto licores y cigarrillos)">47812
										- Comercio al por menor de&nbsp; bebidas y tabaco en puestos
										de venta móviles (excepto licores y cigarrillos)</option>
									<option
										value="47813 - Comercio al por menor de cigarrillos y licores en puestos de venta móviles">47813
										- Comercio al por menor de cigarrillos y licores en puestos de
										venta móviles</option>
									<option
										value="47911 - Comercio al por menor de alimentos y productos agrícolas en bruto; venta de textos escolares y libros (incluye cuadernos escolar">47911
										- Comercio al por menor de alimentos y productos agrícolas en
										bruto; venta de textos escolares y libros (incluye cuadernos
										escolar</option>
									<option
										value="47912 - Comercio al por menor de madera y materiales para construcción; venta de automotores (incluidas motocicletas)  realizado a travé">47912
										- Comercio al por menor de madera y materiales para
										construcción; venta de automotores (incluidas
										motocicletas)&nbsp; realizado a travé</option>
									<option
										value="47913 - Comercio al por menor de cigarrillos y licores; venta de combustibles derivados del petróleo y venta de joyas  realizado a travé">47913
										- Comercio al por menor de cigarrillos y licores; venta de
										combustibles derivados del petróleo y venta de joyas&nbsp;
										realizado a travé</option>
									<option
										value="47914 - Comercio al por menor de demás productos n.c.p.  realizado a través de internet">47914
										- Comercio al por menor de demás productos n.c.p.&nbsp;
										realizado a través de internet</option>
									<option
										value="47921 - Comercio al por menor de alimentos y productos agrícolas en bruto; venta de textos escolares y libros (incluye cuadernos escolar">47921
										- Comercio al por menor de alimentos y productos agrícolas en
										bruto; venta de textos escolares y libros (incluye cuadernos
										escolar</option>
									<option
										value="47922 - Comercio al por menor de madera y materiales para construcción; venta de automotores (incluidas motocicletas)  realizado a travé">47922
										- Comercio al por menor de madera y materiales para
										construcción; venta de automotores (incluidas
										motocicletas)&nbsp; realizado a travé</option>
									<option
										value="47923 - Comercio al por menor de cigarrillos y licores; venta de combustibles derivados del petróleo y venta de joyas  realizado a travé">47923
										- Comercio al por menor de cigarrillos y licores; venta de
										combustibles derivados del petróleo y venta de joyas&nbsp;
										realizado a travé</option>
									<option
										value="47924 - Comercio al por menor de demás productos n.c.p.  realizado a través de casas de venta o por correo">47924
										- Comercio al por menor de demás productos n.c.p.&nbsp;
										realizado a través de casas de venta o por correo</option>
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
										value="47994 - Otros tipos de comercio al por menor no realizado en establecimientos, puestos de venta o mercados de demás productos n.c.p.">47994
										- Otros tipos de comercio al por menor no realizado en
										establecimientos, puestos de venta o mercados de demás
										productos n.c.p.</option>
									<option value="58111 - Servicio de edición de libros">58111
										- Servicio de edición de libros</option>
									<option value="58112 - Edición y publicación de libros">58112
										- Edición y publicación de libros</option>
									<option
										value="58113 - Edición y publicación de libros (Tarifa especial para los contribuyentes que cumplen condiciones del Acuerdo 98 de 2003)">58113
										- Edición y publicación de libros (Tarifa especial para los
										contribuyentes que cumplen condiciones del Acuerdo 98 de 2003)</option>
									<option
										value="60201 - Actividades de programación de televisión">60201
										- Actividades de programación de televisión</option>
									<option
										value="60202 - Actividades de transmisión de televisión">60202
										- Actividades de transmisión de televisión</option>
									<option
										value="64991 - Otras actividades de servicio financiero, excepto las de seguros y pensiones n.c.p.">64991
										- Otras actividades de servicio financiero, excepto las de
										seguros y pensiones n.c.p.</option>
									<option
										value="64992 - Actividades comerciales de las casas de empeño o compraventa">64992
										- Actividades comerciales de las casas de empeño o compraventa</option>
									<option
										value="64993 - Servicios de las casas de empeño o compraventas">64993
										- Servicios de las casas de empeño o compraventas</option>
									<option
										value="66111 - Administración de mercados financieros (excepto actividades de las bolsas de valores)">66111
										- Administración de mercados financieros (excepto actividades
										de las bolsas de valores)</option>
									<option value="66112 - Actividades de las bolsas de valores">66112
										- Actividades de las bolsas de valores</option>
									<option
										value="69101 - Actividades jurídicas como consultoría profesional">69101
										- Actividades jurídicas como consultoría profesional</option>
									<option
										value="69102 - Actividades jurídicas en el ejercicio de una profesión liberal">69102
										- Actividades jurídicas en el ejercicio de una profesión
										liberal</option>
									<option
										value="69201 - Actividades de contabilidad, teneduría de libros, auditoría financiera y asesoría tributaria como consultoría profesional">69201
										- Actividades de contabilidad, teneduría de libros, auditoría
										financiera y asesoría tributaria como consultoría profesional</option>
									<option
										value="69202 - Actividades de contabilidad, teneduría de libros, auditoría financiera y asesoría tributaria en el ejercicio de una profesión li">69202
										- Actividades de contabilidad, teneduría de libros, auditoría
										financiera y asesoría tributaria en el ejercicio de una
										profesión li</option>
									<option
										value="70101 - Actividades de administración empresarial como consultoría profesional">70101
										- Actividades de administración empresarial como consultoría
										profesional</option>
									<option
										value="70102 - Actividades de administración empresarial en el ejercicio de una profesión liberal">70102
										- Actividades de administración empresarial en el ejercicio de
										una profesión liberal</option>
									<option value="70201 - Actividades de consultoría de gestión">70201
										- Actividades de consultoría de gestión</option>
									<option
										value="70202 - Actividades de  gestión en el ejercicio de una profesión liberal">70202
										- Actividades de&nbsp; gestión en el ejercicio de una
										profesión liberal</option>
									<option
										value="71101 - Actividades de arquitectura e ingeniería y otras actividades conexas de consultoría técnica">71101
										- Actividades de arquitectura e ingeniería y otras actividades
										conexas de consultoría técnica</option>
									<option
										value="71102 - Actividades de arquitectura e ingeniería y otras actividades conexas en el ejercicio de una profesión liberal">71102
										- Actividades de arquitectura e ingeniería y otras actividades
										conexas en el ejercicio de una profesión liberal</option>
									<option
										value="71201 - Ensayos y análisis técnicos como consultoría profesional">71201
										- Ensayos y análisis técnicos como consultoría profesional</option>
									<option
										value="71202 - Ensayos y análisis técnicos como consultoría profesional en el ejercicio de una profesión liberal">71202
										- Ensayos y análisis técnicos como consultoría profesional en
										el ejercicio de una profesión liberal</option>
									<option
										value="72101 - Investigaciones y desarrollo experimental en el campo de las ciencias naturales y la ingeniería  como consultoría profesional">72101
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias naturales y la ingeniería&nbsp; como consultoría
										profesional</option>
									<option
										value="72102 - Investigaciones y desarrollo experimental en el campo de las ciencias naturales y la ingeniería  en el ejercicio de una profesió">72102
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias naturales y la ingeniería&nbsp; en el ejercicio de
										una profesió</option>
									<option
										value="72201 - Investigaciones y desarrollo experimental en el campo de las ciencias sociales y las humanidades  como consultoría profesional">72201
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias sociales y las humanidades&nbsp; como consultoría
										profesional</option>
									<option
										value="72202 - Investigaciones y desarrollo experimental en el campo de las ciencias sociales y las humanidades  en el ejercicio de una profesi">72202
										- Investigaciones y desarrollo experimental en el campo de las
										ciencias sociales y las humanidades&nbsp; en el ejercicio de
										una profesi</option>
									<option
										value="73201 - Estudios de mercado y realización de encuestas de opinión pública como consultoría profesional">73201
										- Estudios de mercado y realización de encuestas de opinión
										pública como consultoría profesional</option>
									<option
										value="73202 - Estudios de mercado y realización de encuestas de opinión pública en el ejercicio de una profesión liberal">73202
										- Estudios de mercado y realización de encuestas de opinión
										pública en el ejercicio de una profesión liberal</option>
									<option
										value="74101 - Actividades especializadas de diseño como consultoría profesional">74101
										- Actividades especializadas de diseño como consultoría
										profesional</option>
									<option
										value="74102 - Actividades especializadas de diseño en el ejercicio de una profesión liberal">74102
										- Actividades especializadas de diseño en el ejercicio de una
										profesión liberal</option>
									<option
										value="74901 - Otras actividades profesionales, científicas y técnicas n.c.p. como consultoría profesional (incluye actividades de periodistas)">74901
										- Otras actividades profesionales, científicas y técnicas
										n.c.p. como consultoría profesional (incluye actividades de
										periodistas)</option>
									<option
										value="74902 - Otras actividades profesionales, científicas y técnicas n.c.p. en el ejercicio de una profesión liberal">74902
										- Otras actividades profesionales, científicas y técnicas
										n.c.p. en el ejercicio de una profesión liberal</option>
									<option value="85231 - Educación media técnica.">85231
										- Educación media técnica.</option>
									<option value="85232 - Educación de formación laboral">85232
										- Educación de formación laboral</option>
									<option
										value="85511 - Educación académica no formal (excepto programas de educación básica primaria, básica secundaria y media no gradual con fines de">85511
										- Educación académica no formal (excepto programas de
										educación básica primaria, básica secundaria y media no
										gradual con fines de</option>
									<option
										value="85512 - Educación académica no formal impartida mediante programas de educación básica primaria, básica secundaria y media no gradual co">85512
										- Educación académica no formal impartida mediante programas
										de educación básica primaria, básica secundaria y media no
										gradual co</option>
									<option
										value="86211 - Actividades de la práctica médica, sin internación (excepto entidades e instituciones promotoras y prestadoras de servicios de s">86211
										- Actividades de la práctica médica, sin internación (excepto
										entidades e instituciones promotoras y prestadoras de
										servicios de s</option>
									<option
										value="86221 - Actividades de la práctica odontológica, sin internación (excepto entidades e instituciones promotoras y prestadoras de servicio">86221
										- Actividades de la práctica odontológica, sin internación
										(excepto entidades e instituciones promotoras y prestadoras de
										servicio</option>
									<option
										value="86911 - Actividades de apoyo diagnóstico (excepto entidades e instituciones promotoras y prestadoras de servicios de salud, de naturalez">86911
										- Actividades de apoyo diagnóstico (excepto entidades e
										instituciones promotoras y prestadoras de servicios de salud,
										de naturalez</option>
									<option
										value="86921 - Actividades de apoyo terapéutico (excepto entidades e instituciones promotoras y prestadoras de servicios de salud, de naturalez">86921
										- Actividades de apoyo terapéutico (excepto entidades e
										instituciones promotoras y prestadoras de servicios de salud,
										de naturalez</option>
									<option
										value="86991 - Otras actividades de atención de la salud humana (excepto entidades e instituciones promotoras y prestadoras de servicios de sal">86991
										- Otras actividades de atención de la salud humana (excepto
										entidades e instituciones promotoras y prestadoras de
										servicios de sal</option>
									<option
										value="87101 - Actividades de atención residencial medicalizada de tipo general (excepto entidades e instituciones promotoras y prestadoras de">87101
										- Actividades de atención residencial medicalizada de tipo
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