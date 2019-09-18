<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="mibuzon.inicial.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="mibuzon.inicial.descripcion" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<sf:form>
	<br>
	<div class="container">
		<div class="col-md-5 col-md-offset-4 center">
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="mibuzon.inicial.verdetalle" /></label>
			</div>
		</div>
		<br> <br>
		<div>
			<div class="row">

				<!-- 				<div class="col-md-4 col-md-offset-4 center"> -->
				<!-- 					<table class="table table-responsive" id=""> -->
				<!-- 						<thead> -->
				<!-- 							<tr> -->
				<!-- 								<th style="text-align: center"><label -->
				<!-- 									class="control-label " for="" -->
				<%-- 									style="text-transform: capitalize !important"><spring:theme --%>
				<%-- 											code="mibuzon.inicial.tipmsn" /></label></th> --%>
				<!-- 								<th style="text-align: center"><label class="control-label" -->
				<%-- 									for=""> <spring:theme code="mibuzon.inicial.numero" /></label></th> --%>
				<!-- 							</tr> -->
				<!-- 						</thead> -->
				<!-- 						<tbody> -->
				<!-- 							<tr> -->
				<!-- 								<td><label class="control-label" -->
				<%-- 									style="text-transform: capitalize !important"><spring:theme --%>
				<%-- 											code="mibuzon.inicial.noti" /></label></td> --%>
				<!-- 								<td><input id="notificaciones" name="notificaciones" -->
				<!-- 									class="inputtextnew" aria-required="true" type="text" -->
				<!-- 									readonly="readonly" -->
				<%-- 									value="<c:out value="notificaciones"></c:out>" maxlength="240" --%>
				<!-- 									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important" -->
				<!-- 									onclick="myFunction(1)"></td> -->

				<!-- 							</tr> -->
				<!-- 							<tr> -->
				<!-- 								<td><label class="control-label" -->
				<%-- 									style="text-transform: capitalize !important"><spring:theme --%>
				<%-- 											code="mibuzon.inicial.mns" /></label></td> --%>
				<!-- 								<td><input id="" name="" class="inputtextnew" -->
				<!-- 									aria-required="true" type="text" readonly="readonly" -->
				<%-- 									value="<c:out value="mensajes"></c:out>" maxlength="240" --%>
				<!-- 									style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important" -->
				<!-- 									onclick="myFunction(2)"></td> -->
				<!-- 							</tr> -->
				<!-- 						</tbody> -->
				<!-- 					</table> -->
				<!-- 				</div> -->
				<div class="col">
					<ul class="nav nav-tabs">
						<li class="nav-item new_tab"><a href="#tab1" class="nav-link active new_active"
							data-toggle="tab"><span><spring:theme
										code="mibuzon.mensajes.mensajes" /></span><span class="badge badge-light">12</span></a></li>
										
						<li class="nav-item new_tab"><a href="#tab2" class="nav-link new_active"
							data-toggle="tab"><span><spring:theme
										code="mibuzon.notificaciones.notifica" /></span><span class="badge badge-light">1</span></a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active class=" mt-3"" id="tab1"
							role="tabpanel">
							<div class="container">

								<sf:form>
									<div style="aling-items: center; justify-content: center">
										<div class="row">
											<div class="col-md-6 col-md-offset-3 center headline">
												<h2>
													<span><spring:theme code="mibuzon.mensajes.nuevos" /></span>
												</h2>
											</div>
										</div>
										<div>
											<div class="row">

												<div class="col-md-7 col-md-offset-3 center">
													<table class="table table-responsive" id="">
														<thead>
															<tr>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for=""><spring:theme
																			code="mibuzon.mensajes.identi" /></label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.autoridad" />
																</label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.asunto" />
																</label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.fecnoti" />
																</label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.papelera" />
																</label></th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="identifi"></c:out>"
																	maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="autoridad"></c:out>"
																	maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="asunto"></c:out>" maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="fechanotificacion"></c:out>"
																	maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><img
																	src="${themeResourcePath}/images/papeleranuevos.png"
																	style="width: 30px"></img></td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>


										<div class="row">
											<div class="col-md-6 col-md-offset-3 headline">
												<h2>
													<span><spring:theme code="mibuzon.mensajes.leidos" /></span>
												</h2>
											</div>
										</div>
										<div>
											<div class="row">

												<div class="col-md-7 col-md-offset-3 center">
													<table class="table table-responsive" id="">
														<thead>
															<tr>
																<th style="text-align: center"><label
																	class="control-label "
																	style="text-transform: capitalize !important" for=""><spring:theme
																			code="mibuzon.mensajes.identi" /></label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.autoridad" />
																</label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.asunto" />
																</label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.fecnoti" />
																</label></th>
																<th style="text-align: center"><label
																	class="control-label"
																	style="text-transform: capitalize !important" for="">
																		<spring:theme code="mibuzon.mensajes.papelera" />
																</label></th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="identifi"></c:out>"
																	maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="autoridad"></c:out>"
																	maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="asunto"></c:out>" maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><input id="" name="" class="inputtextnew"
																	aria-required="true" type="text" readonly="readonly"
																	value="<c:out value="fechanotificacion"></c:out>"
																	maxlength="240"
																	style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
																<td><img
																	src="${themeResourcePath}/images/papeleraleidos.png"
																	style="width: 20px"></img></td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</sf:form>
							</div>

						</div>


						<!-- 					inicio de notificaciones -->
						<div class="tab-pane" id="tab2" role="tabpanel">
							<div class="container">
								<sf:form>
									<div class="row">
										<div class="col-md-4 col-md-offset-3 center headline">
											<h2>
												<span><spring:theme
														code="mibuzon.notificaciones.nuevos" /></span>
											</h2>
										</div>
									</div>
									<div>
										<div class="row">

											<div class="col-md-7 col-md-offset-3 center">
												<table class="table table-responsive" id="">
													<thead>
														<tr>
															<th style="text-align: center;"><label
																class="control-label"
																style="text-transform: capitalize !important" for=""><spring:theme
																		code="mibuzon.notificaciones.identi" /></label></th>
															<th style="text-align: center"><label
																class="control-label"
																style="text-transform: capitalize !important" for="">
																	<spring:theme code="mibuzon.notificaciones.autoridad" />
															</label></th>
															<th style="text-align: center"><label
																class="control-label"
																style="text-transform: capitalize !important" for="">
																	<spring:theme code="mibuzon.notificaciones.asunto" />
															</label></th>
															<th style="text-align: center"><label
																class="control-label"
																style="text-transform: capitalize !important" for="">
																	<spring:theme code="mibuzon.notificaciones.fecnoti" />
															</label></th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="identifi"></c:out>" maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="autoridad"></c:out>"
																maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="asunto"></c:out>" maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="fechanotificacion"></c:out>"
																maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-md-6 col-md-offset-3 headline">
											<h2>
												<span><spring:theme
														code="mibuzon.notificaciones.leidos" /></span>
											</h2>
										</div>
									</div>
									<div>
										<div class="row">

											<div class="col-md-7 col-md-offset-3 center">
												<table class="table table-responsive" id="">
													<thead>
														<tr>
															<th style="text-align: center"><label
																class="control-label "
																style="text-transform: capitalize !important" for=""><spring:theme
																		code="mibuzon.notificaciones.identi" /></label></th>
															<th style="text-align: center"><label
																class="control-label"
																style="text-transform: capitalize !important" for="">
																	<spring:theme code="mibuzon.notificaciones.autoridad" />
															</label></th>
															<th style="text-align: center"><label
																class="control-label"
																style="text-transform: capitalize !important" for="">
																	<spring:theme code="mibuzon.notificaciones.asunto" />
															</label></th>
															<th style="text-align: center"><label
																class="control-label"
																style="text-transform: capitalize !important" for="">
																	<spring:theme code="mibuzon.notificaciones.fecnoti" />
															</label></th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="identifi"></c:out>" maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="autoridad"></c:out>"
																maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="asunto"></c:out>" maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
															<td><input id="" name="" class="inputtextnew"
																aria-required="true" type="text" readonly="readonly"
																value="<c:out value="fechanotificacion"></c:out>"
																maxlength="240"
																style="width: 100% !important; padding-left: 1px !important; padding-right: 1px !important"></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</sf:form>
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</sf:form>
