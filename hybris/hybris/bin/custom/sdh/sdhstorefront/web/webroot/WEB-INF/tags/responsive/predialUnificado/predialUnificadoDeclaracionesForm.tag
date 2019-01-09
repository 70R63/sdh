<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<form >
			<div class="row">
				<div class="col-md-2">
					<label><spring:theme code="predial.unificado.declaraciones.chip" /></label>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<input id="address.surname" name="chip" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label><spring:theme code="predial.unificado.declaraciones.addresssite" /></label>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<input id="address.surname" name="license" class="form-control form-control" aria-required="true" type="text" value="" maxlength="240">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label><spring:theme code="predial.unificado.declaraciones.year" /></label>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<select id="year" name="year" class="form-control">
	                              <option selected=""  value="Seleccionar">Seleccionar</option>
	                              <option value="2018">2018</option>
	                              <option value="2017">2017</option>
	                              <option value="2016">2016</option>
	                              <option value="2015">2015</option>
	                              <option value="2014">2014</option>
	                              <option value="2013">2013</option>
	                              <option value="2012">2012</option>
	                              <option value="2011">2011</option>
	                              <option value="2010">2010</option>
	                              <option value="2009">2009</option>
	                              <option value="2008">2008</option>
	                              <option value="2007">2007</option>
	                              <option value="2006">2006</option>
	                              <option value="2005">2005</option>
	                              <option value="2004">2004</option>
	                              <option value="2003">2003</option>
	                              <option value="2002">2002</option>
	                              <option value="2001">2001</option>
	                              <option value="2000">2000</option>
	                            </select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label><spring:theme code="predial.unificado.declaraciones.action" /></label>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<select id="action" name="action" class="form-control">
	                              <option value="select">Seleccionar</option>
	                              <option value="initialDeclaration">Declaración inicial</option>
	                              <option value="retention">Declaracion Pago por Cuotas</option>
	                              <option value="correctionDeclaration">Declaracion de Correccion</option>
	                            </select>
					</div>
				</div>
			</div>
			<div class="row ">
				<div class="col-md-6 text-right">
					<button class="btn btn-secondary btn-lg" type="submit"><spring:theme code="predial.unificado.declaraciones.continue" /></button>
				</div>
			</div>
		</form>
