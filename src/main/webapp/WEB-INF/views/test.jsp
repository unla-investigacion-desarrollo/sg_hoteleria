<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<!-- EJEMPLO EN https://developers.google.com/chart/interactive/docs/gallery/timeline -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ocupacion del Hotel</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/buttons.dataTables.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/jquery.dataTables.min.css' />" rel="stylesheet"></link>

<script src=" <c:url value= '/static/js/loader.js'/>" type="text/javascript"></script>
<script src=" <c:url value= '/static/js/jquery-1.12.4.js'/>" type="text/javascript"></script>


<script type="text/javascript">

	function generarStringFecha(fecha) {
	    var dia;
	    if (fecha.getDate()<10){
	    	dia = "0"+ fecha.getDate();
	    } else{
	    	dia = fecha.getDate();
	    }

	    var mes;
	    if ((fecha.getMonth() + 1)<10){
	    	mes = "0"+ (fecha.getMonth() + 1);
	    } else{
	    	mes = (fecha.getMonth() + 1);
	    }
	    var año = fecha.getFullYear();

	    var string = año + "-" + mes + "-" + dia;

	  return string;
	}

	function dibujarTabla(desde,hasta){
		//Delete the datable object first
				$('#tablaOcupacion-container').empty();

				var colData = [];

				<c:forEach items="${fechas}" var="fechas">
					colData.push("${fechas}");
				</c:forEach>

			    var rowData = [];

				<c:forEach items="${vista}" var="vista">

					var fila = ["${vista.habitacion.descripcion}"];

					<c:forEach items="${vista.ocupaciones}" var="ocupaciones">
						fila["${ocupaciones.columna}"] = "${ocupaciones.estadoEstadia}";
					</c:forEach>

					rowData.push(fila);

				</c:forEach>


			    var data = {"Cols":colData, "Rows":rowData};

			    var table = $('<table/>').attr("id", "tablaOcupacion").addClass("table table-striped table-bordered").attr("cellspacing", "0").attr("width", "100%");

			    var tr = $('<tr/>');
			    table.append('<thead>').children('thead').append(tr);

			    for (var i=0; i< data.Cols.length; i++) {
			      tr.append('<td>'+data.Cols[i]+'</td>');
			    }

			    for(var r=0; r < data.Rows.length; r++){
			        var tr = $('<tr/>');
			        table.append(tr);
			        //loop through cols for each row...
			        for(var c=0; c < data.Cols.length; c++){

			        	if(data.Rows[r][c]){
			        		var info = data.Rows[r][c];
			        	}
			        	else{
			        		var info = "";
			        	}
			            tr.append('<td>'+info+'</td>');
			        }
			    }

			    $('#tablaOcupacion-container').append(table);

			    var dataTable = $('#tablaOcupacion').removeAttr('width').DataTable( {
			    	scrollY:        "300px",
			        scrollX:        true,
			        scrollCollapse: true,
			        paging:         false,
			        columnDefs: [
			                     { width: 82, targets: 0 }
			                 ],
			        fixedColumns:   {
			            leftColumns: 1
			        },
			        responsive: true,
			    	retrieve: true,
					"language" : {
						"sProcessing" : "Procesando...",
						"sLengthMenu" : "Mostrar _MENU_ registros",
						"sZeroRecords" : "No se encontraron resultados",
						"sEmptyTable" : "Ningún dato disponible en esta tabla",
						"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
						"sInfoEmpty" : "Mostrando un total de 0 habitaciones",
						"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
						"sInfoPostFix" : "",
						"sSearch" : "Buscar:",
						"sUrl" : "",
						"sInfoThousands" : ",",
						"sLoadingRecords" : "Cargando...",
						"oPaginate" : {
							"sFirst" : "Primero",
							"sLast" : "Último",
							"sNext" : "Siguiente",
							"sPrevious" : "Anterior"
						}
					}
				});

			    $('#tablaOcupacion tbody').on('click', 'tr', function() {
					var codigo = $('td', this).eq(0).text();

					var nombre = $('td', this).eq(1).text();
					alert('Código del cliente ' + codigo + ' ' + 'Nombre ' + nombre);

				});


	}

	$(document).ready(function() {
		$( "#fechas" ).submit(function(e) {
			location.reload();

			e.preventDefault();
		});


		var hoy = new Date();
		var millisPorDia = 1000 * 60 * 60 * 24;

		var desde = new Date(hoy.getTime() - (2 * millisPorDia));
		var hasta = new Date(hoy.getTime() + (15 * millisPorDia));

		$("#desde").attr("value", generarStringFecha(desde));
		$("#hasta").attr("value", generarStringFecha(hasta));

		dibujarTabla(document.getElementById("desde").value, document.getElementById("hasta").value);

	});

</script>

</head>
<body>
	<div class="generic-container">
		<%@include file="authheader.jsp"%>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Ocupacion del Hotel</span>
			</div>
		</div>

		<sec:authorize access="hasRole('ADMIN')">
			<div>
				<form id="fechas" >
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="desde">Desde</label>
							<div class="col-md-7">
								<input type="date" path="desde" id="desde" class=" form-control input-sm" />
							</div>
						</div>

						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="hasta">Hasta</label>
							<div class="col-md-7">
								<input type="date" path="hasta" id="hasta"class=" form-control input-sm"/>
							</div>
						</div>

						<div class="form-actions floatRight">
							<input type="submit" value="Volver a consultar" class="btn btn-primary btn-sm" />
							<a target="_blank" href="<c:url value='/estadia/list'/>"
						class="btn btn-success btn-sm">Adm. Estadias</a>
						<a target="_blank" href="<c:url value='/panelInicial'/>"
						class="btn btn-success btn-sm">Panel Principal</a>
						</div>
					</div>
				</form>

			</div>
		</sec:authorize>
	</div>

	<div class="generic-container">
		<sec:authorize access="hasRole('ADMIN')">
			<div>
				<div id="tablaOcupacion-container"></div>
			</div>
	</sec:authorize>
	</div>


</body>

<script src=" <c:url value= '/static/js/jquery.dataTables.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/dataTables.bootstrap.min.js'/>"
	type="text/javascript"></script>

<script src=" <c:url value= '/static/js/dataTables.fixedColumns.min.js'/>"
	type="text/javascript"></script>


<script src=" <c:url value= '/static/js/datatables.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= 'static/js/dataTables.buttons.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/jszip.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/pdfmake.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/vfs_fonts.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/buttons.html5.min.js'/>"
	type="text/javascript"></script>
</html>
