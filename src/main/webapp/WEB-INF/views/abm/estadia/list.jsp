<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%
request.setAttribute("success", request.getParameter("success"));
request.setAttribute("titulo", "Sistema de Gestion Hotelera");

%>

<%@include file="../../header.jsp"%>
<div class="block-header">
	<h2>
		ESTADIA <small>Lista de estad&iacute;as</a></small>
	</h2>
</div>
<c:choose>
	<c:when test="${success != null}">
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">x</span></button>
		    ${success}
		</div>
	</c:when>
</c:choose>

<!-- Basic Examples -->
<div class="row clearfix">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="card">
			<div class="header">
                <sec:authorize access="hasRole('ADMIN')">
					<a href="<c:url value='new' />"
						class="btn btn-primary waves-effect">Crear Estad&iacute;a</a>
				</sec:authorize>
            </div>
			<div class="body table-responsive">
				<table
					class="table table-bordered table-striped table-hover js-exportable dataTable">
					<thead>
						<tr>

							<%
								/* ******************************************************************************** *
								  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
								  ******************************************************************************** */
							%>
							<th>ID</th>
                            <th>Estado</th>
                            <th>Plan Alojamiento</th>
                            <th>Precio por Noche</th>
                            <th>Check In</th>
                            <th>Check Out</th>
							<th>Comentario</th>
							<th>Pasajeros</th>


							<th class="noExport">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${entities}" var="entity">
							<tr>

								<%
									/* ******************************************************************************** *
											  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
											  ******************************************************************************** */
								%>
								<td>${entity.idEstadia}</td>
                                <td>${entity.estadoEstadia.estado}</td>
                                <td>${entity.planAlojamiento.plan}</td>
                                <td>${entity.precioPorNoche}</td>
                                <td>${entity.diaCheckIn}</td>
                                <td>${entity.diaCheckOut}</td>
								<td>${entity.comentario}</td>

								<td><div><c:forEach items="${pasajerosfiltrados}" var="pasajero1">
									<c:if test="${entity.idEstadia == pasajero1.idEstadia}">
										<c:forEach items="${pasajero1.pasajerosConEstadia}" var="pasajero2">
											${pasajero2.nombre}
											${pasajero2.apellido}
											<c:if test = "${not empty pasajero2.nombre}">
												<br>
											</c:if>

										</c:forEach>
									</c:if>


								</c:forEach></div></td>







								<%
									/* ******************************************************************************** *
											  *********************** FIN DE LOS CAMPOS DE LA ENTIDAD ************************ *
											  ******************************************************************************** */
								%>
								<td>
								<sec:authorize access="hasAnyRole('ADMIN', 'USER','DBA')">
							      <button type="button" onclick="javascript:location.href='<c:url value='/pasajeroEstadia/list?idEstadia=${entity.id}' />'" class="btn bg-green btn-circle waves-effect waves-circle waves-float">
                                  		 <i class="material-icons">hotel</i>
                                  </button>
						        </sec:authorize>
								<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
									<button type="button" onclick="javascript:location.href='<c:url value='edit-${entity.id}' />'" class="btn btn-default btn-circle waves-effect waves-circle waves-float">
									    <i class="material-icons">mode_edit</i>
									</button>
								</sec:authorize>
								<sec:authorize access="hasRole('ADMIN')">
									<button type="button" onclick="javascript:location.href='<c:url value='delete-${entity.id}' />'" class="btn bg-red btn-circle waves-effect waves-circle waves-float">
									    <i class="material-icons">delete</i>
									</button>
								</sec:authorize>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<%@include file="../../footer.jsp"%>
<!-- Jquery DataTable Plugin Js -->
<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/jquery.dataTables.js'/>"
	type="text/javascript"></script>
<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js'/>"
	type="text/javascript"></script>

	<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js'/>"
	type="text/javascript"></script>
	<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/extensions/export/buttons.flash.min.js'/>"
	type="text/javascript"></script>
	<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/extensions/export/jszip.min.js'/>"
	type="text/javascript"></script>
	<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/extensions/export/pdfmake.min.js'/>"
	type="text/javascript"></script>
	<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/extensions/export/vfs_fonts.js'/>"
	type="text/javascript"></script>
	<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/extensions/export/buttons.html5.min.js'/>"
	type="text/javascript"></script>
	<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/extensions/export/buttons.print.min.js'/>"
	type="text/javascript"></script>

<script src=" <c:url value= '/static/js/comprobante.js'/>"
	type="text/javascript"></script>

