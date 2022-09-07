<!--

<sec:authorize access="hasRole('ADMIN')" >
	 		<div class="well">
		 		<a href="<c:url value='/panelOcupacion/' />">Ocupacion del Hotel</a>
		 	</div>
		 	<div class="well">
		 		<a href="<c:url value='/panelABMs/' />">Acceso a Configuraciones</a>
		 	</div>
	 	</sec:authorize>

 -->

	<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse"
            data-target=".navbar-ex1-collapse">
      <span class="sr-only">Desplegar navegación</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="<c:url value="/" />">SGH</a>
  </div>

  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li><a href="<c:url value='/panelOcupacion/' />">Ocupacion del Hotel</a></li>

      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
          Clientes <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/pasajero/' />">Pasajeros</a></li>
          <li><a href="<c:url value='/organizacion/' />">Organizaciones</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
          Gestión de Estadias <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/servicio/' />">Servicios</a></li>
          <li><a href="<c:url value='/planAlojamiento/' />">Plan Alojamiento</a></li>
          <li><a href="<c:url value='/estadia/' />">Estadia</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
          Configuraciones <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/usuarios/' />">Usuarios</a></li>
          <li class="divider"></li>
          <li><a href="<c:url value='/tipoDocumento/' />">Tipos de Documentos</a></li>
          <li><a href="<c:url value='/caracteristicaPasajero/' />">Caracteristicas de Pasajeros</a></li>
          <li class="divider"></li>
          <li><a href="<c:url value='/hotel/' />">Hoteles</a></li>
          <li><a href="<c:url value='/tipoHabitacion/' />">Tipos de Habitaciones</a></li>
          <li><a href="<c:url value='/caracteristicaHabitacion/' />">Caracteristicas de Habitaciones</a></li>
          <li><a href="<c:url value='/estadoHabitacion/' />">Estados de Habitaciones</a></li>
          <li><a href="<c:url value='/habitacion/' />">Habitaciones</a></li>
          <li><a href="<c:url value='/tipoServicio/' />">Tipos de Servicios</a></li>
          <li><a href="<c:url value='/estadoEstadia/' />">Estados Estadia</a></li>

        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
          Facturacion <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/comprobante/' />">Comprobantes</a></li>
          <li><a href="<c:url value='/preticket/' />">Pre-Tickets</a></li>
          <li class="divider"></li>
          <li><a href="<c:url value='/tipoComprobante/' />">Tipos de Comprobantes</a></li>
          <li><a href="<c:url value='/conceptosAIncluir/' />">Conceptos</a></li>
          <li><a href="<c:url value='/formaDePago/' />">Formas de Pago</a></li>
          <li><a href="<c:url value='/moneda/' />">Monedas</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>