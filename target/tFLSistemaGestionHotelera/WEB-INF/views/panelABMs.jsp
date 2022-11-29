<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Configurations Panel</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>
		<div class="panel panel-default" >
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Configurations Panel</span></div>
		</div>
	 	<sec:authorize access="hasRole('ADMIN')" >
	 		<div class="well">
	 			<h3> Security Module</h3>
		 		<a href="<c:url value='/usuarios/' />">Users</a>
		 	</div>
		 	<div class="well">
		 		<h3> Customer Management</h3>
	 			<a href="<c:url value='/tipoDocumento/' />">Type of Document</a><br>
	 			<a href="<c:url value='/caracteristicaPasajero/' />">Passenger Characteristics</a><br>
	 			<a href="<c:url value='/pasajero/' />">Passenger</a><br>
	 			<a href="<c:url value='/organizacion/' />">Organization</a>
		 	</div>
		 	<div class="well">
		 		<h3> Management of Stay</h3>
		 		<a href="<c:url value='/hotel/' />">Hotels</a><br>
		 		<a href="<c:url value='/tipoHabitacion/' />">Room Types</a><br>
		 		<a href="<c:url value='/caracteristicaHabitacion/' />">Room Features</a><br>
		 		<a href="<c:url value='/estadoHabitacion/' />">Room Statuses</a><br>
	 			<a href="<c:url value='/habitacion/' />">Rooms</a><br>
	 			<a href="<c:url value='/tipoServicio/' />">Type of Services</a><br>
	 			<a href="<c:url value='/servicio/' />">Services</a><br>
	 			<a href="<c:url value='/planAlojamiento/' />">Lodging Plan</a><br>
	 			<a href="<c:url value='/estadoEstadia/' />">Status Stay</a><br>
		 		<a href="<c:url value='/estadia/' />">Stay</a><br>
		 		<a href="<c:url value='/pasajeroEstadia/' />">Passengers per Stay</a>
		 	</div>



	 	</sec:authorize>
   	</div>
</body>
</html>