<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%
request.setAttribute("success", request.getParameter("success"));
request.setAttribute("titulo", "Sistema de Gestion Hotelera");

%>

<%@include file="header.jsp"%>
<div class="block-header">
	<h2>
		Ocupacion Hotel <small>Lista de habitaciones </a></small>
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
			<div class="body table-responsive">
				<table
					class="table table-bordered table-striped table-hover js-exportable dataTable">
					<thead>
						<tr>

							<%
								/* ******************************************************************************** *
								  ********************* COMIENZO DE LOS CAMPOS DE LA HABITACION ********************* *
								  ******************************************************************************** */
							%>
							<th>ID</th>
                            <th>Tipo Habitacion</th>
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
								<td>${entity.idTipoHabitacion}</td>
                                <td>${entity.nombreTipoHabitacion}</td>
                                

								<%
									/* ******************************************************************************** *
											  *********************** FIN DE LOS CAMPOS DE LA ENTIDAD ************************ *
											  ******************************************************************************** */
								%>
								 <td>
								<sec:authorize access="hasAnyRole('ADMIN', 'USER','DBA')">
							      <a href="<c:url value='/panelOcupacion/Consulta/?idTipoHabitacion=${entity.id}' />"
										class="btn btn-primary waves-effect">Consultar Ocupacion</a>
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

<%@include file="footer.jsp"%>
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

