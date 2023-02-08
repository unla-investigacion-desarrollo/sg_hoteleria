<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%
	request.setAttribute("success", request.getParameter("success"));
%>
<div class="row clearfix">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="body">
					<table class="table table-bordered table-striped table-hover">
						<thead class="bg-blue">
							<tr>
								<th>Cantidad</th>
								<th>Descripcion</th>
								<th>Precio</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${itemsPreTicket}" var="entity">
								<tr>
									<td>${entity.cantidad}</td>
									<td>${entity.descripcion}</td>
									<td>${entity.precio}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
	</div>
</div>
