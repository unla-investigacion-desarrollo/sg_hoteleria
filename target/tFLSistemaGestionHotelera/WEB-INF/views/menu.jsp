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
      <span class="sr-only">Expand navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="<c:url value="/" />">SGH</a>
  </div>

  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li><a href="<c:url value='/panelOcupacion/' />">Hotel Occupancy</a></li>

      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
          Clients <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/pasajero/' />">Passengers</a></li>
          <li><a href="<c:url value='/organizacion/' />">Organizations</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
          Management of Stays <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/servicio/' />">Services</a></li>
          <li><a href="<c:url value='/planAlojamiento/' />">Lodging Plan</a></li>
          <li><a href="<c:url value='/estadia/' />">Stay</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
         Settings <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/usuarios/' />">Users</a></li>
          <li class="divider"></li>
          <li><a href="<c:url value='/tipoDocumento/' />">Document Types</a></li>
          <li><a href="<c:url value='/caracteristicaPasajero/' />">Passenger Characteristics</a></li>
          <li class="divider"></li>
          <li><a href="<c:url value='/hotel/' />">Hotels</a></li>
          <li><a href="<c:url value='/tipoHabitacion/' />">Room Types</a></li>
          <li><a href="<c:url value='/caracteristicaHabitacion/' />">Room Features</a></li>
          <li><a href="<c:url value='/estadoHabitacion/' />">Room Status</a></li>
          <li><a href="<c:url value='/habitacion/' />">Rooms</a></li>
          <li><a href="<c:url value='/tipoServicio/' />">Types of Services</a></li>
          <li><a href="<c:url value='/estadoEstadia/' />">States Stay</a></li>

        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">
          Billing <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/comprobante/' />">Vouchers</a></li>
          <li><a href="<c:url value='/preticket/' />">Pre-Tickets</a></li>
          <li class="divider"></li>
          <li><a href="<c:url value='/tipoComprobante/' />">Types of Vouchers</a></li>
          <li><a href="<c:url value='/conceptosAIncluir/' />">Concepts</a></li>
          <li><a href="<c:url value='/formaDePago/' />">Payment Methods</a></li>
          <li><a href="<c:url value='/moneda/' />">Coins</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>