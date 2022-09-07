<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setAttribute("titulo", "Formulario de Registro de Usuarios");
%>
<%@include file="header.jsp"%>

<form:form method="POST" modelAttribute="user" class="">
			<%
				/* ******************************************************************************** *
												  ********************* COMIENZO DE LOS CAMPOS DE LA ENTIDAD ********************* *
												  ******************************************************************************** */
			%>
			<form:input type="hidden" path="id" id="id" />

                <div class="row clearfix">
                    <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="header bg-blue">
                                <h2>USUARIOS</h2>
                            </div>
                            <div class="body">
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <label for="">Nombre</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:input type="text" path="firstName" id="firstName" class="form-control" />
                                                <div class="has-error">
                                                    <form:errors path="firstName" class="help-inline" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <label for="">Apellido</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:input type="text" path="lastName" id="lastName" class="form-control" />
                                                <div class="has-error">
                                                    <form:errors path="lastName" class="help-inline" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <label for="">Usuario</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:input type="text" path="ssoId" id="ssoId" class="form-control" />
                                                <div class="has-error">
                                                    <form:errors path="ssoId" class="help-inline" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <label for="">Contrase&ntilde;a</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:input type="password" path="password" id="password" class="form-control" />
                                                <div class="has-error">
                                                    <form:errors path="password" class="help-inline" />
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
                                        <label for="">Roles</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
                                                <div class="has-error">
                                                    <form:errors path="userProfiles" class="help-inline" />
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
                                                <a class="btn btn-block btn-lg btn-default waves-effect" href="<c:url value='usuarios' />">VOLVER</a>
                                             </div>
                                         </div>
                                    </c:when>
                                    <c:otherwise>
                                         <div class="row clearfix">

                                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
                                                 <input type="submit" id="btnSubmit" value="CREAR" class="btn btn-block btn-lg btn-primary waves-effect" />
                                             </div>
                                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 m-b-20">
                                                <a class="btn btn-block btn-lg btn-default waves-effect" href="<c:url value='usuarios' />">VOLVER</a>
                                             </div>
                                         </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>

<%@include file="footer.jsp"%>
<script src=" <c:url value= '/static/js/comprobante.js'/>"
	type="text/javascript"></script>
