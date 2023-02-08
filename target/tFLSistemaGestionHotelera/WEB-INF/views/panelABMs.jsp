<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Panel Configuraciones</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>
		<div class="panel panel-default" >
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Panel Configuraciones</span></div>
		</div>
	 	<sec:authorize access="hasRole('ADMIN')" >
	 		<div class="well">
	 			<h3> Modulo Seguridad</h3>
		 		<a href="<c:url value='/usuarios/' />">Usuarios</a>
		 	</div>
		 	<div class="well">
		 		<h3> Gestion de Clientes</h3>
	 			<a href="<c:url value='/tipoDocumento/' />">Tipo de Documento</a><br>
	 			<a href="<c:url value='/caracteristicaPasajero/' />">Caracteristicas de Pasajeros</a><br>
	 			<a href="<c:url value='/pasajero/' />">Pasajero</a><br>
	 			<a href="<c:url value='/organizacion/' />">Organizacion</a>
		 	</div>
		 	<div class="well">
		 		<h3> Gestion de Estadia</h3>
		 		<a href="<c:url value='/hotel/' />">Hoteles</a><br>
		 		<a href="<c:url value='/tipoHabitacion/' />">Tipos de Habitaciones</a><br>
		 		<a href="<c:url value='/caracteristicaHabitacion/' />">Caracteristicas de Habitaciones</a><br>
		 		<a href="<c:url value='/estadoHabitacion/' />">Estados de Habitaciones</a><br>
	 			<a href="<c:url value='/habitacion/' />">Habitaciones</a><br>
	 			<a href="<c:url value='/tipoServicio/' />">Tipo de Servicios</a><br>
	 			<a href="<c:url value='/servicio/' />">Servicios</a><br>
	 			<a href="<c:url value='/planAlojamiento/' />">Plan Alojamiento</a><br>
	 			<a href="<c:url value='/estadoEstadia/' />">Estado Estadia</a><br>
		 		<a href="<c:url value='/estadia/' />">Estadia</a><br>
		 		<a href="<c:url value='/pasajeroEstadia/' />">Pasajeros por Estadia</a>
		 	</div>



	 	</sec:authorize>
   	</div>
</body>
</html>