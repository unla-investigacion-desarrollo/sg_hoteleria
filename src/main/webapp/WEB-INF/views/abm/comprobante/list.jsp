<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%
	request.setAttribute("success", request.getParameter("success"));
	request.setAttribute("nroComprobante", request.getParameter("nroComprobante"));
	request.setAttribute("titulo", "Lista de Comprobantes");
%>

<%@include file="../../header.jsp"%>
<div class="block-header">
	<h2>
		COMPROBANTES <small>Lista de comprobantes guardados</a></small>
	</h2>
</div>
<c:choose>
	<c:when test="${nroComprobante != null}">
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">�</span></button>
		    <strong>Comprobante Emitido!</strong> El comprobante Nro ${nroComprobante} se ha emitido y guardado correctamente.
		</div>
	</c:when>
</c:choose>
<!-- Basic Examples -->
<div class="row clearfix">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="card">
			<div class="header">
                <sec:authorize access="hasRole('ADMIN')">
					<a href="<c:url value='newComprobante' />"
						class="btn btn-primary waves-effect">Crear Comprobante</a>
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
							<th>Nro</th>
							<th>Tipo</th>
							<th>Cliente</th>
							<th>Moneda</th>
							<th>Forma de Pago</th>
							<th>Importe Total</th>
							<th>CAE</th>
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
								<td>${entity.nroComprobante}</td>
								<td>${entity.tipoComprobante.descripcion}</td>
								<td>${entity.clienteComprobante.nombre}</td>
								<td>${entity.moneda.descripcion}</td>
								<td>${entity.formaDePago.descripcion}</td>
								<td>${entity.importeTotal}</td>
								<td>${entity.cae}</td>
							

								<%
									/* ******************************************************************************** *
											  *********************** FIN DE LOS CAMPOS DE LA ENTIDAD ************************ *
											  ******************************************************************************** */
								%>
								<td>
								<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
								<c:choose>
									<c:when test="${entity.cae != null}">
										<button type="button" onclick="window.open('<c:url value='Download/${entity.id}' />')" class="btn btn-success btn-circle waves-effect waves-circle waves-float">
										    <i class="material-icons">file_download</i>											
										</button>
									</c:when>
								</c:choose>
								</sec:authorize>
								<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
									<button type="button" onclick="javascript:location.href='<c:url value='editComprobante-${entity.id}' />'" class="btn btn-default btn-circle waves-effect waves-circle waves-float">
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
	
	
	
	
