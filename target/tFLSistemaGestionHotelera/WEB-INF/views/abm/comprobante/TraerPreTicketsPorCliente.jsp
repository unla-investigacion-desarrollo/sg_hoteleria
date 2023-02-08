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
								<th>Descripcion</th>
								<th>Total</th>
								<th>Fecha</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${preTickets}" var="entity">
								<tr>
									<td>${entity.descripcion}</td>
									<td>${entity.calcularTotal()}</td>
									<td>${entity.fecha}</td>
									<td class="col-md-3">
										<button class="btn btn-default btn-circle waves-effect waves-circle waves-float"
												onclick="verItemsPreTicket(${entity.idPreTicket})">
												<i class="material-icons" aria-hidden="true">storage</i>
										</button>
										<button class="btn bg-green btn-circle waves-effect waves-circle waves-float"
											onclick="preTicketSeleccionado(${entity.idPreTicket},'${entity.descripcion}',${entity.calcularTotal()})">
											<i class="material-icons" aria-hidden="true">add</i>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
	</div>
</div>
