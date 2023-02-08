<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%
	request.setAttribute("success", request.getParameter("success"));
	request.setAttribute("titulo", "Lista de Tipos de Comprobantes");
%>

<%@include file="../../header.jsp"%>
<div class="block-header">
	<h2>
		TIPOS DE COMPROBANTES <small>Lista de Tipos de Comprobantes</a></small>
	</h2>
</div>
<c:choose>
	<c:when test="${success != null}">
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
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
						class="btn btn-primary waves-effect">Crear Tipo de Comprobante</a>
				</sec:authorize>
            </div>
			<div class="body">
			<div class="table-responsive">
				<table
					class="table table-bordered table-striped table-hover js-basic-example dataTable">
					<thead>
						<tr>

<% /* ******************************************************************************** *
	  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
	  ******************************************************************************** */ %>
				        <th>Codigo</th>
				        <th>Descripcion</th>
				        <th>Acciones</th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${entities}" var="entity">
					<tr>

<% /* ******************************************************************************** *
	  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
	  ******************************************************************************** */ %>
						<td>${entity.codigo}</td>
						<td>${entity.descripcion}</td>

<% /* ******************************************************************************** *
	  *********************** FIN DE LOS CAMPOS DE LA ENTIDAD ************************ *
	  ******************************************************************************** */ %>
<%
									/* ******************************************************************************** *
											  *********************** FIN DE LOS CAMPOS DE LA ENTIDAD ************************ *
											  ******************************************************************************** */
								%>
						<td>
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
</div>

<%@include file="../../footer.jsp"%>
<!-- Jquery DataTable Plugin Js -->
<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/jquery.dataTables.js'/>"
	type="text/javascript"></script>
<script
	src=" <c:url value= '/static/material/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/comprobante.js'/>"
	type="text/javascript"></script>
