<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="../../header.jsp"%>


<form:form method="POST" modelAttribute="entity" class="">
			<%
				/* ******************************************************************************** *
												  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
												  ******************************************************************************** */
			%>
			<form:input type="hidden" path="idPreTicket" id="id" />
			
			<div class="row clearfix">
				<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header bg-blue">
							<h2>PRE-TICKET</h2>
						</div>
						<div class="body">
							<div class="row clearfix">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="email_address_2">Cliente</label>
								</div>
								<div class="col-md-8">
									<form:select path="clientePreTicket"
										items="${clienteComprobante}" multiple="false"
										itemValue="idClienteComprobante" itemLabel="nombre"
										class="form-control show-tick" data-live-search="true" />
									<div class="has-error">
										<form:errors path="clientePreTicket" class="help-inline" />
									</div>
								</div>
								
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Descripcion</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="descripcion"
												id="descripcion" class="form-control" />
											<div class="has-error">
												<form:errors path="descripcion" class="help-inline" />
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Fecha</label>
								</div>
								<div class="col-md-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="fecha"
												id="fecha" placeholder="Fecha del comprobante"
												class="datepicker form-control" />
											<div class="has-error">
												<form:errors path="fecha" class="help-inline" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row clearfix">
							<div class="body table-responsive">
								<table id="tablaItemsPreTicket"
									class="table table-condensed table-hover">
									<thead>
										<tr>
											<th>Cantidad</th>
											<th>Desripcion</th>
											<th>Precio</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="itemspreticket-tbody">
										<c:forEach varStatus="i" var="itemsPreTicket"
											items="${entity.itemsPreTicket}">
											<tr id="row-itempreticket-${i.index}">
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<input type="number" class="form-control"
																	id="cantidad-${i.index}" min="1"
																	name="itemsPreTicket[${i.index}].cantidad"
																	value="${itemsPreTicket.cantidad}" />
															</div></td>
														<td class="col-md-5"><div
																class="form-group form-group-sm">
																<input type="text" class="form-control" 
																	id="descripcion-${i.index}"
																	name="itemsPreTicket[${i.index}].descripcion" readonly
																	value="${itemsPreTicket.descripcion}" />
															</div></td>
														<td class="col-md-1"><div
																class="form-group form-group-sm">
																<input type="number" step=".01" class="form-control"
																	id="precio-${i.index}" min="0"
																	name="itemsPreTicket[${i.index}].precio"
																	value="${itemsPreTicket.precio}" step="any" />
															</div></td>
														
														<td class="col-md-2">
															<button type="button"
																onclick="eliminarItemPreTicket(${i.index})"
																class="btn btn-danger btn-circle waves-effect waves-circle waves-float">
																<i class="material-icons">delete</i>
															</button>
											</tr>

										</c:forEach>
									</tbody>
								</table>
								<input type="hidden" id="indiceItemsPreTicket" name="indiceItemsPreTicket"
									value="${entity.itemsPreTicket.size()}" />
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 m-b-20">
						                    <button type="button"  class="btn btn-primary waves-effect align-right"
								onclick="agregarItemPreTicket()">Agregar Item</button>
						                 </div>
							</div>
							<c:choose>
								<c:when test="${edit}">
						             <div class="row clearfix">
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						                     
						                     <input type="submit" id="btnSubmit" value="EDITAR" class="btn btn-block btn-lg btn-primary waves-effect" />
						                 </div>
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						                    <a class="btn btn-block btn-lg btn-default waves-effect" href="<c:url value='list' />">VOLVER</a>
						                 </div>
						             </div>
								</c:when>
								<c:otherwise>
						             <div class="row clearfix">
						                 
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						                     <input type="submit" id="btnSubmit" value="CREAR" class="btn btn-block btn-lg btn-primary waves-effect" />
						                 </div>
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						                    <a class="btn btn-block btn-lg btn-default waves-effect" href="<c:url value='list' />">VOLVER</a>
						                 </div>
						             </div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>

		</form:form>

	
<%@include file="../../footer.jsp"%>
<script src=" <c:url value= '/static/js/comprobante.js'/>"
	type="text/javascript"></script>