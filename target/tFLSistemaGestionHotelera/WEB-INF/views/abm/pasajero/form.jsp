<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setAttribute("titulo", "Passenger Loading Form");
%>
<%@include file="../../header.jsp"%>

<form:form method="POST" modelAttribute="entity" class="">
			<%
				/* ******************************************************************************** *
												  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
												  ******************************************************************************** */
			%>
			<form:input type="hidden" path="idContacto" id="id" />

			<div class="row clearfix">
				<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header bg-blue">
							<h2>PASSENGER</h2>
						</div>
						<div class="body">
							<div class="row clearfix">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Name</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="nombre" id="nombre" class="form-control" />
											<div class="has-error">
												<form:errors path="nombre" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Last name</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="apellido" id="apellido" class="form-control" />
											<div class="has-error">
												<form:errors path="apellido" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Telephone</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="telefono" id="telefono" class="form-control" />
											<div class="has-error">
												<form:errors path="telefono" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Email</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="email" id="email" class="form-control" />
											<div class="has-error">
												<form:errors path="email" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Document Type</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:select path="tipoDocumento" items="${tipoDocumento}" multiple="false" itemValue="idTipoDocumento" itemLabel="descripcion" class="form-control input-sm" />
											<div class="has-error">
												<form:errors path="tipoDocumento" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Document</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="documento" id="documento" class="form-control" />
											<div class="has-error">
												<form:errors path="documento" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Birth Date</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="date" path="fechaDeNacimiento" id="fechaDeNacimiento" class=" form-control input-sm" />
											<div class="has-error">
												<form:errors path="fechaDeNacimiento" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Features</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:select path="caracteristicas" items="${caracteristicaPasajero}" multiple="true"
                                                    itemValue="idCaracteristicaPasajero" itemLabel="descripcion"
                                                    hidden="false" class="form-control input-sm" />
											<div class="has-error">
												<form:errors path="caracteristicas" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

							</div>

							<c:choose>
								<c:when test="${edit}">
						             <div class="row clearfix">
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">

						                     <input type="submit" id="btnSubmit" value="SAVE" class="btn btn-block btn-lg btn-primary waves-effect" />
						                 </div>
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						                    <a class="btn btn-block btn-lg btn-default waves-effect" href="<c:url value='list' />">BACK</a>
						                 </div>
						             </div>
								</c:when>
								<c:otherwise>
						             <div class="row clearfix">

						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						                     <input type="submit" id="btnSubmit" value="CREATE" class="btn btn-block btn-lg btn-primary waves-effect" />
						                 </div>
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
						                    <a class="btn btn-block btn-lg btn-default waves-effect" href="<c:url value='list' />">BACK</a>
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
