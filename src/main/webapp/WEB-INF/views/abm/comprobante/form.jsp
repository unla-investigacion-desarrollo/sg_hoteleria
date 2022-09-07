<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="../../header.jsp"%>
<c:choose>
	<c:when test="${facturado != null}">
		<div class="alert alert-success alert-dismissible">${facturado}</div>
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${observacionesComprobante != null}">
		<c:forEach varStatus="i" var="observacionComprobante"
			items="${observacionesComprobante}">
			<div class="alert alert-warning alert-dismissible">
				${observacionComprobante}</div>
		</c:forEach>
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${erroresComprobante != null}">
		<c:forEach varStatus="i" var="errorComprobante"
			items="${erroresComprobante}">
			<div class="alert alert-danger alert-dismissible">${errorComprobante}</div>
		</c:forEach>
	</c:when>
</c:choose>

<form:form method="POST" modelAttribute="entity" class="">
	<%
		/* ******************************************************************************** *
		   ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
		   ******************************************************************************** */
	%>
	<form:input type="hidden" path="idComprobante" id="id" />
	<input type="hidden" id="facturar" name="facturar" value="false" />

	<div class="row clearfix">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="card">
				<div class="header bg-blue">
					<h2>DATOS DEL CLIENTE</h2>
				</div>
				<div class="body">
					<div class="row clearfix">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<label for="email_address_2">Cliente</label>
						</div>
						<div class="col-md-10">
							<form:select path="clienteComprobante"
								items="${clienteComprobante}" multiple="false"
								itemValue="idClienteComprobante" itemLabel="nombre"
								class="form-control show-tick" data-live-search="true" />
							<div class="has-error">
								<form:errors path="clienteComprobante" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="row clearfix">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="card">
				<div class="header bg-blue">
					<h2>DATOS DEL COMPROBANTE</h2>
				</div>
				<div class="body">
					<div class="row clearfix">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
							<label for="email_address_2">Tipo</label>
						</div>
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
							<form:select path="tipoComprobante" items="${tipoComprobante}"
								multiple="false" itemValue="idTipoComprobante"
								itemLabel="descripcion" class="form-control show-tick"
								data-live-search="true" />
							<div class="has-error">
								<form:errors path="tipoComprobante" class="help-inline" />
							</div>
						</div>
					</div>
					<c:choose>
						<c:when test="${entity.nroComprobante != 0}">
							<div class="row clearfix">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-4">
									<label for="">Nro</label>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-8">
									<div class="form-group">
										<div class="form-line">${entity.nroComprobante}</div>
									</div>

								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-4">
									<label for="">Punto de Venta</label>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-8">
									<div class="form-group">
										<div class="form-line">${entity.ptoVenta}</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="row clearfix">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="ptoVenta">Punto de Venta</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="number" min="1" max="99998" step="1" required="true" path="ptoVenta" id="ptoVenta"
												class="form-control" />
										</div>
									</div>
									<div class="has-error">
										<form:errors path="ptoVenta" class="help-inline" />
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="row clearfix">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
							<label for="email_address_2">Fecha Comprobante</label>
						</div>
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
							<div class="form-group">
								<div class="form-line">
									<form:input type="text" path="fechaComprobante"
										id="fechaComprobante" required="true" placeholder="Fecha del comprobante"
										class="datepicker form-control" />
									<div class="has-error">
										<form:errors path="fechaComprobante" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="card">
				<div class="header bg-blue">
					<h2>DATOS DEL PAGO</h2>
				</div>
				<div class="body">
					<div class="row clearfix">
						<div
							class="col-lg-3 col-md-3 col-sm-3 col-xs-3 form-control-label">
							<label for="email_address_2">Conceptos</label>
						</div>
						<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
							<form:select path="conceptosAIncluir"
								items="${conceptosAIncluir}" multiple="false"
								itemValue="idConceptosAIncluir" itemLabel="descripcion"
								class="form-control show-tick" data-live-search="true" />
							<div class="has-error">
								<form:errors path="conceptosAIncluir" class="help-inline" />
							</div>
						</div>
						<div
							class="col-lg-3 col-md-3 col-sm-3 col-xs-3 form-control-label">
							<label for="email_address_2">Forma Pago</label>
						</div>
						<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
							<form:select path="formaDePago" items="${formaDePago}"
								multiple="false" itemValue="idFormaDePago"
								itemLabel="descripcion" class="form-control show-tick"
								data-live-search="true" />
							<div class="has-error">
								<form:errors path="formaDePago" class="help-inline" />
							</div>
						</div>
						<div
							class="col-lg-3 col-md-3 col-sm-3 col-xs-3 form-control-label">
							<label for="email_address_2">Moneda</label>
						</div>
						<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
							<form:select path="moneda" items="${moneda}" multiple="false"
								itemValue="idMoneda" itemLabel="descripcion"
								class="form-control show-tick" data-live-search="true" />
							<div class="has-error">
								<form:errors path="moneda" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 			<div class="col-md-12"> -->
	<!-- 				<div class="panel panel-primary"> -->
	<!-- 					<div class="panel-heading"> -->
	<!-- 						<h3 class="panel-title">Fechas del Comprobante</h3> -->
	<!-- 					</div> -->
	<!-- 					<div class="panel-body"> -->
	<!-- 						<div class="col-md-12"> -->
	<!-- 							<div class="form-group col-md-4"> -->
	<!-- 								<label class="col-md-5 control-label" for="fechaFacturadoDesde">Fecha -->
	<!-- 									Facturado Desde</label> -->
	<!-- 								<div class="col-md-7"> -->
	<%-- 									<form:input type="date" path="fechaFacturadoDesde" --%>
	<%-- 										id="fechaFacturadoDesde" class=" form-control input-sm" /> --%>
	<!-- 									<div class="has-error"> -->
	<%-- 										<form:errors path="fechaFacturadoDesde" class="help-inline" /> --%>
	<!-- 									</div> -->
	<!-- 								</div> -->
	<!-- 							</div> -->
	<!-- 							<div class="form-group col-md-4"> -->
	<!-- 								<label class="col-md-5 control-label" for="fechaFacturadoHasta">Fecha -->
	<!-- 									Facturado Hasta</label> -->
	<!-- 								<div class="col-md-7"> -->
	<%-- 									<form:input type="date" path="fechaFacturadoHasta" --%>
	<%-- 										id="fechaFacturadoHasta" class=" form-control input-sm" /> --%>
	<!-- 									<div class="has-error"> -->
	<%-- 										<form:errors path="fechaFacturadoHasta" class="help-inline" /> --%>
	<!-- 									</div> -->
	<!-- 								</div> -->
	<!-- 							</div> -->
	<!-- 							<div class="form-group col-md-4"> -->
	<!-- 								<label class="col-md-5 control-label" for="vencimientoPago">Vencimiento -->
	<!-- 									Pago</label> -->
	<!-- 								<div class="col-md-7"> -->
	<%-- 									<form:input type="date" path="vencimientoPago" --%>
	<%-- 										id="vencimientoPago" class=" form-control input-sm" /> --%>
	<!-- 									<div class="has-error"> -->
	<%-- 										<form:errors path="vencimientoPago" class="help-inline" /> --%>
	<!-- 									</div> -->
	<!-- 								</div> -->
	<!-- 							</div> -->
	<!-- 						</div> -->
	<!-- 					</div> -->
	<!-- 				</div> -->
	<!-- 			</div> -->

	<div class="row clearfix">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="card">
				<div class="header bg-blue">
					<h2>CONTENIDO DEL COMPROBANTE</h2>
				</div>
				<div class="body">
					<ul class="nav nav-tabs tab-nav-right" id="myTab" role="tablist">
						<li class="active" role="presentation"><a id="conceptos-tab"
							data-toggle="tab" href="#conceptos-tab-pane" role="tab"
							aria-controls="conceptos">CONCEPTOS</a></li>
<!-- 						<li role="presentation"><a id="alicuotas-tab" -->
<!-- 							data-toggle="tab" href="#alicuotas-tab-pane" role="tab" -->
<!-- 							aria-controls="alicuotas">ALICUOTAS</a></li> -->
						<!-- 							<li role="presentation"><a id="tributos-tab" -->
						<!-- 								data-toggle="tab" href="#tributos-tab-pane" role="tab" -->
						<!-- 								aria-controls="tributos">Tributos</a></li> -->
					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
						<div class="tab-pane fade in active" id="conceptos-tab-pane"
							role="tabpanel" aria-labelledby="conceptos-tab">
							<br>
							<div class="body table-responsive">
								<table id="tablaConceptos"
									class="table table-condensed table-hover">
									<thead>
										<tr>
											<th>Cantidad</th>
											<th>Desripcion</th>
											<th>Precio</th>
											<th>IVA</th>
											<th>Subtotal</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="conceptos-tbody">
										<c:forEach varStatus="i" var="conceptos"
											items="${entity.conceptos}">
											<tr id="row-concepto-${i.index}">
												<c:choose>
													<c:when test="${conceptos.preTicket != null}">
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<input type="number" class="form-control"
																	id="cantidad-${i.index}" min="1"
																	name="conceptos[${i.index}].cantidad" readonly
																	onchange="calcularSubtotal(${i.index})"
																	value="${conceptos.cantidad}" />
															</div></td>
														<td class="col-md-4"><div
																class="form-group form-group-sm">
																<input type="text" class="form-control" 
																	id="descripcion-${i.index}"
																	name="conceptos[${i.index}].descripcion" readonly
																	value="${conceptos.descripcion}" />
															</div></td>
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<input type="number" step=".01" class="form-control"
																	id="precio-${i.index}" min="0"
																	name="conceptos[${i.index}].precio" readonly
																	onchange="calcularSubtotal(${i.index})"
																	value="${conceptos.precio}" step="any" />
															</div></td>
														<td class="col-md-2"><select id="tipoIva-${i.index}"
															name="conceptos[${i.index}].tipoIva"
															onchange="calcularSubtotal(${i.index})"
															value="${conceptos.tipoIva}"
															class="form-control input-sm selectTipoIva">
																<option value="1">No Gravado</option>
																<option value="2">Excento</option>
																<option value="3">0 %</option>
																<option value="4">10,50 %</option>
																<option selected value="5">21 %</option>
																<option value="6">27 %</option>
														</select></td>
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<input type="number" step=".01" class="form-control input-sm"
																	id="subtotal-${i.index}" readonly
																	name="subtotal-${i.index}" value="" />
															</div></td>
														<td class="col-md-3"><span
															class="label label-success">Pre-Ticket</span>
															<button type="button" class="btn btn-default btn-circle waves-effect waves-circle waves-float"
																	onclick="verItemsPreTicket(${conceptos.preTicket.idPreTicket})">
																	<i class="material-icons" aria-hidden="true">storage</i>
															</button>
															<button type="button"
																onclick="eliminarConcepto(${i.index})"
																class="btn btn-danger btn-circle waves-effect waves-circle waves-float">
																<i class="material-icons">delete</i>
															</button> <input type="hidden"
															id="conceptos[${i.index}].preTicket"
															name="conceptos[${i.index}].preTicket"
															value="${conceptos.preTicket.idPreTicket}" />
													</c:when>
													<c:otherwise>
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<div class="form-line">
																	<input type="number" class="form-control"
																		id="cantidad-${i.index}" min="1"
																		name="conceptos[${i.index}].cantidad"
																		onchange="calcularSubtotal(${i.index})"
																		required
																		value="${conceptos.cantidad}" />
																</div>
															</div></td>
														<td class="col-md-4"><div
																class="form-group form-group-sm">
																<div class="form-line">
																	<input type="text" class="form-control"
																		required
																		id="descripcion-${i.index}"
																		name="conceptos[${i.index}].descripcion"
																		value="${conceptos.descripcion}" />
																</div>
															</div></td>
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<div class="form-line">
																	<input type="number" class="form-control"
																		id="precio-${i.index}" step=".01" min="0"
																		name="conceptos[${i.index}].precio"
																		required
																		onchange="calcularSubtotal(${i.index})"
																		value="${conceptos.precio}" step="any" />
																</div>
															</div></td>
														<td class="col-md-2"><select id="tipoIva-${i.index}"
															name="conceptos[${i.index}].tipoIva"
															onchange="calcularSubtotal(${i.index})"
															value="${conceptos.tipoIva}"
															class="form-control selectTipoIva">
																<option value="1">No Gravado</option>
																<option value="2">Excento</option>
																<option value="3">0 %</option>
																<option value="4">10,50 %</option>
																<option selected value="5">21 %</option>
																<option value="6">27 %</option>
														</select></td>
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<div class="form-line">
																	<input type="number" class="form-control" step=".01"
																		id="subtotal-${i.index}" readonly
																		name="subtotal-${i.index}" value="" />
																</div>
															</div></td>
														<td class="col-md-3">
															<button type="button"
																onclick="eliminarConcepto(${i.index})"
																class="btn btn-danger btn-circle waves-effect waves-circle waves-float">
																<i class="material-icons">delete</i>
															</button>
														</td>
													</c:otherwise>
												</c:choose>
											</tr>

										</c:forEach>
									</tbody>
								</table>
								<input type="hidden" id="indiceConceptos" name="indiceConceptos"
									value="${entity.conceptos.size()}" />
							</div>
							<button type="button" class="btn btn-primary waves-effect"
								onclick="agregarConcepto()">Agregar Concepto</button>
							<button type="button" class="btn btn-primary waves-effect"
								onclick="agregarPreTicket()">Agregar Pre-Ticket</button>
							<!-- 							<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
							  Agregar Concepto
							</button> -->



						</div>
						<div class="tab-pane fade" id="alicuotas-tab-pane" role="tabpanel"
							aria-labelledby="alicuotas-tab">
							<br>
							<div class="col-md-8">
								<div class="table-responsive">
									<table id="tablaAlicuotas" class="table table-hover">
										<thead>
											<tr>
												<th>Alicuota</th>
												<th>Base Imponible</th>
												<th>Importe IVA</th>
											</tr>
										</thead>
										<tbody id="alicuotas-tbody">
											<tr>

											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group col-md-12">
									<label class="col-md-5 control-label" for="importeNeto">Importe
										Neto</label>
									<div class="col-md-7">
										<form:input type="number" path="importeNeto" id="importeNeto"
											class="form-control input-sm" />
										<div class="has-error">
											<form:errors path="importeNeto" class="help-inline" />
										</div>
									</div>
								</div>
								<div class="form-group col-md-12">
									<label class="col-md-5 control-label" for="importeNoGravado">Importe
										No Gravado</label>
									<div class="col-md-7">
										<form:input type="number" path="importeNoGravado"
											id="importeNoGravado" class="form-control input-sm" />
										<div class="has-error">
											<form:errors path="importeNoGravado" class="help-inline" />
										</div>
									</div>
								</div>
								<div class="form-group col-md-12">
									<label class="col-md-5 control-label" for="importeExcento">Importe
										Excento</label>
									<div class="col-md-7">
										<form:input type="number" path="importeExcento"
											id="importeExcento" class="form-control input-sm" />
										<div class="has-error">
											<form:errors path="importeExcento" class="help-inline" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 							<div class="tab-pane fade" id="tributos-tab-pane" role="tabpanel" -->
						<!-- 								aria-labelledby="tributos-tab"></div> -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row clearfix">
		<c:choose>
			<c:when test="${entity.cae != null}">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="card">
						<div class="header bg-blue">
							<h2>RESULTADO</h2>
						</div>
						<div class="body">
							<div class="row clearfix">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Nro</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">${entity.cae}</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Vencimiento Cae</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">${entity.vencimientoCae}</div>
									</div>
								</div>

								<div class="col-md-6">
									<a class="btn btn-block btn-lg btn-primary waves-effect"
										target="_blank"
										href="<c:url value='/comprobante/Download/${entity.idComprobante}'/>">Descargar
										Comprobante</a>
								</div>
								
								<div class="col-md-6">
									<a class="btn btn-block btn-lg btn-primary waves-effect" onclick="enviarComprobante(${entity.idComprobante})">Enviar por Email </a>
								</div>
								<div  id ="loaderMail">
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>
			</c:otherwise>
		</c:choose>



		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="card">
				<div class="header bg-blue">
					<h2>TOTALES</h2>
				</div>
				<div class="body">
					<div class="row clearfix">
						<!-- 							<div class="form-group col-md-12"> -->
						<!-- 								<label class="col-md-5 control-label" for="importeTributos">Importe -->
						<!-- 									Tributos</label> -->
						<!-- 								<div class="col-md-7"> -->
						<%-- 									<form:input type="number" step="any" path="importeTributos" --%>
						<%-- 										id="importeTributos" class="form-control input-sm" /> --%>
						<!-- 									<div class="has-error"> -->
						<%-- 										<form:errors path="importeTributos" class="help-inline" /> --%>
						<!-- 									</div> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<label class="col-lg-5 col-md-5 col-sm-5 col-xs-5 control-label" for="totalIva">Importe
								IVA</label>
							<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
								<form:input type="number" step=".01" path="totalIva"
									id="totalIva" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="totalIva" class="help-inline" />
								</div>
							</div>
						</div>
						<div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<label class="col-lg-5 col-md-5 col-sm-5 col-xs-5 control-label" for="importeTotal">Importe
								Total</label>
							<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
								<form:input type="number" step=".01" path="importeTotal"
									id="importeTotal" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="importeTotal" class="help-inline" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<input id="valoriva1" name="valoriva1" type="hidden" value="excento">
	<input id="valoriva2" name="valoriva2" type="hidden" value="nogravado">
	<input id="valoriva3" name="valoriva3" type="hidden" value="0">
	<input id="valoriva4" name="valoriva4" type="hidden" value="10.5">
	<input id="valoriva5" name="valoriva5" type="hidden" value="21">
	<input id="valoriva6" name="valoriva6" type="hidden" value="27">


	<%
		/* ******************************************************************************** *
															  ********************** FIN DE LOS CAMPOS DEL FORMULATION *********************** *
															  ******************************************************************************** */
	%>

	<div class="row clearfix">
		<c:choose>
			<c:when test="${edit}">
				<div class="row clearfix">
					<c:choose>
						<c:when test="${entity.cae == null}">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 m-b-20">
								<a class="btn btn-block btn-lg btn-success waves-effect"
									onclick="facturar()">GUARDAR Y EMITIR</a>
							</div>
						</c:when>
					</c:choose>
				</div>
				<div class="row clearfix">
					<c:choose>
						<c:when test="${entity.cae == null}">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
								<a class="btn btn-block btn-lg btn-default waves-effect"
									href="<c:url value='list' />">VOLVER</a>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
								<a class="btn btn-block btn-lg btn-primary waves-effect"
									onclick="guardar()">GUARDAR</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 m-b-20">
								<a class="btn btn-block btn-lg btn-default waves-effect"
									href="<c:url value='list' />">VOLVER</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row clearfix">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 m-b-20">
						<a class="btn btn-block btn-lg btn-success waves-effect"
							onclick="facturar()">GUARDAR Y EMITIR</a>
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						<a class="btn btn-block btn-lg btn-default waves-effect"
							href="<c:url value='list' />">VOLVER</a>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						<a class="btn btn-block btn-lg btn-primary waves-effect"
									onclick="guardar()">GUARDAR</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</form:form>

<!-- Modal Conceptos-->
<div class="modal fade" id="modalPreTickets" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Agregar Pre-Tickets</h4>
			</div>
			<div class="modal-body" id="pretickets-modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-link waves-effect"
					data-dismiss="modal">CERRAR</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Conceptos-->
<div class="modal fade" id="modalItemsPreTicket" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabelItems">Listado de Items del Pre-Ticket</h4>
			</div>
			<div class="modal-body" id="itemspreticket-modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-link waves-effect"
					data-dismiss="modal">CERRAR</button>
			</div>
		</div>
	</div>
</div>

<%@include file="../../footer.jsp"%>
<script src=" <c:url value= '/static/material/plugins/jquery-validation/jquery.validate.js'/>"
	type="text/javascript"></script>
	
<script src=" <c:url value= '/static/material/plugins/jquery-validation/localization/messages_es_AR.js'/>"
	type="text/javascript"></script>

<script src=" <c:url value= '/static/js/comprobante.js'/>"
	type="text/javascript"></script>