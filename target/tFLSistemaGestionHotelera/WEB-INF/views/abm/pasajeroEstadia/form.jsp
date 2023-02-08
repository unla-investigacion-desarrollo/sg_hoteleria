<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setAttribute("titulo", "Asignar Habitacion/Pasajero a Estadia");
	request.setAttribute("idEstadia", request.getParameter("idEstadia"));
%>
<%@include file="../../header.jsp"%>

<head>
<script type="text/javascript">
     $(document).ready(function(){
    	 var dato = <%= request.getParameter("idEstadia") %>;
    	 if(dato != null)
    	 {
    		 $("#estadia").val(<%= request.getParameter("idEstadia") %>).attr('selected', 'selected');
    		 document.getElementById("estadia").setAttribute("readonly", true);

    	 }

    	 $("#Actualizar").attr("href", "<c:url value='list?idEstadia="+dato+"'/>");
    	 $("#Guardar").attr("href", "<c:url value='list?idEstadia="+dato+"'/>");

     });
</script>
</head>

<form:form method="POST" modelAttribute="entity" class="">
			<%
				/* ******************************************************************************** *
												  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
												  ******************************************************************************** */
			%>
			<form:input type="hidden" path="idPasajeroEstadia" id="id" />

			<div class="row clearfix">
				<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header bg-blue">
							<h2>ASIGNAR HABITACION/PASAJERO A ESTADIA</h2>
						</div>
						<div class="body">
							<div class="row clearfix">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Estad&iacute;a</label>

								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<c:choose>
                                                <c:when test="${not empty param.idEstadia}">

                                                    <c:forEach items="${estadia}" var="miEstadia">
                                                        <c:if test="${miEstadia.idEstadia == param.idEstadia}">
                                                            <c:out value="${miEstadia.descripcion}"/>
                                                            <form:input type="hidden" path="estadia" value="${miEstadia.idEstadia}" />
                                                        </c:if>
                                                    </c:forEach>

                                                </c:when>
                                                <c:otherwise>

                                                        <form:select path="estadia" items="${estadia}" id="estadia"
                                                        multiple="false" itemValue="idEstadia"
                                                        itemLabel="descripcion" class="form-control input-sm"/>

                                                </c:otherwise>
                                            </c:choose>
											<div class="has-error">
												<form:errors path="estadia" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Pasajero</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<form:select path="pasajero"
                                                multiple="false" class="form-control input-sm" >
                                                <form:option  value="" />
                                                <form:options items="${pasajero}" itemValue="idContacto"
                                                itemLabel="nombreCompleto" />
                                            </form:select>
											<div class="has-error">
												<form:errors path="pasajero" class="help-inline" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label for="">Habitaci&oacute;n</label>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-line">
											<c:choose>
                                                    <c:when test="${not empty habitacion}">
                                                    <form:select path="habitacion" items="${habitacion}"
                                                        multiple="false" itemValue="idHabitacion"
                                                        itemLabel="descripcion" class="form-control input-sm" />

                                                    </c:when>
                                                    <c:otherwise>No hay habitaciones disponibles en la fecha indicada.
                                                    </c:otherwise>
                                                </c:choose>
											<div class="has-error">
												<form:errors path="habitacion" class="help-inline" />
											</div>
										</div>
									</div>
								</div>
							</div>

							<c:choose>
								<c:when test="${edit}">
						             <div class="row clearfix">
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">

						                     <input type="submit" id="Actualizar" href="<c:url value='list?idEstadia=${idEstadia}' />" value="EDITAR" class="btn btn-block btn-lg btn-primary waves-effect" />
						                 </div>
						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
<a class="btn btn-block btn-lg btn-default waves-effect" href="<c:url value='list' />">VOLVER</a>
						                 </div>
						             </div>
								</c:when>
								<c:otherwise>
						             <div class="row clearfix">

						                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
                                            <input type="submit" id="Guardar" href="<c:url value='list?idEstadia=${idEstadia}' />" value="CREAR" class="btn btn-block btn-lg btn-primary waves-effect" />
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




