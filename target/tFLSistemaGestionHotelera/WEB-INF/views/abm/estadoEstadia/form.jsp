<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setAttribute("titulo", "Carga de Estado de Estadia");
%>
<%@include file="../../header.jsp"%>

<form:form method="POST" modelAttribute="entity" class="">
			<%
				/* ******************************************************************************** *
												  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
												  ******************************************************************************** */
			%>
			<form:input type="hidden" path="idEstadoEstadia" id="id" />

			<div class="row clearfix">
				<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header bg-blue">
							<h2>ESTADO DE ESTADIA</h2>
						</div>
						<div class="body">
							<div class="row clearfix">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Estado</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:input type="text" path="estado" id="estado" class="form-control" />
											<div class="has-error">
												<form:errors path="estado" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Color</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:select path="color" id="color" class="form-control input-sm">

                                                <form:option value="coral" label="Coral"/>
                                                <form:option value="aquamarine" label="Verde Agua"/>
                                                <form:option value="darkgreen" label="Verde Oscuro"/>
                                                <form:option value="crimson" label="Rojo Palido"/>
                                                <form:option value="dodgerBlue" label="Celeste"/>
                                                <form:option value="midnightblue" label="Azul"/>
                                                <form:option value="darkcyan" label="Cian"/>
                                                <form:option value="gray" label="Gris"/>
                                                <form:option value="red" label="Rojo"/>
                                                <form:option value="yellow" label="Amarillo"/>

                                            </form:select>
											<div class="has-error">
												<form:errors path="color" class="help-inline" />
											</div>
										</div>
									</div>
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

