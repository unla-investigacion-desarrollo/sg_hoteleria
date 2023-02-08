
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
//prevents caching at the proxy server
%>


<head>
<link href="<c:url value='/static/css/buttons.dataTables.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/jquery.dataTables.min.css' />" rel="stylesheet"></link>

<script src=" <c:url value= '/static/js/loader.js'/>" type="text/javascript"></script>
<script src=" <c:url value= '/static/js/jquery-1.12.4.js'/>" type="text/javascript"></script>


<script type="text/javascript">

	function dibujarTabla(desde,hasta){
		//Delete the datable object first
				$('#tablaOcupacion-container').empty();

				var colData = [];

				<c:forEach items="${fechas}" var="fechas">
					colData.push("${fechas}");
				</c:forEach>

			    var rowData = [];
			    var informacion = [];
			    var colores = [];

				<c:forEach items="${vista}" var="vista">

					var fila = ["${vista.habitacion.descripcion}"];
					var filaInf = ["${vista.habitacion.descripcion}"];
					var filaCol = ["${vista.habitacion.descripcion}"];
					var filaPas = ["${vista.habitacion.descripcion}"];

					<c:forEach items="${vista.ocupaciones}" var="ocupaciones">
						fila["${ocupaciones.columna}"] = "${ocupaciones.estadoEstadia}";
						filaInf["${ocupaciones.columna}"] = "${ocupaciones.informacion}";
						filaCol["${ocupaciones.columna}"] = "${ocupaciones.color}";

					</c:forEach>


					rowData.push(fila);
					informacion.push(filaInf);
					colores.push(filaCol);


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
			        		tr.append('<td id="' + r + '-' + c + '" style="font-weight: bold; background: '+colores[r][c]+'">'+info+'</td>').attr("backgraund", "red");
			        	}
			        	else{
			        		var info = "";
			        		tr.append('<td id="' + r + '-' + c + '">'+info+'</td>');
			        	}

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
			            leftColumns: 0
			        },
			        responsive: true,
			    	retrieve: true,
					"language" : {
						"sProcessing" : "Processing...",
						"sLengthMenu" : "Show _MENU_ records",
						"sZeroRecords" : "No results found",
						"sEmptyTable" : "No data available in this table.",
						"sInfo" : "Showing records of the _START_ to _END_ of a total of _TOTAL_ records",
						"sInfoEmpty" : "Showing a total of 0 rooms",
						"sInfoFiltered" : "(filtering of a total of _MAX_ records)",
						"sInfoPostFix" : "",
						"sSearch" : "Search:",
						"sUrl" : "",
						"sInfoThousands" : ",",
						"sLoadingRecords" : "Loading...",
						"oPaginate" : {
							"sFirst" : "First",
							"sLast" : "Last",
							"sNext" : "Next",
							"sPrevious" : "Previous"
						}
					}
				});


			    var prueba = $('#tablaOcupacion').DataTable();
			    $('#tablaOcupacion tbody').on('click', 'tr', function() {
					var idClickeado = $(event.target)[0].id;
					var ids = idClickeado.split('-');

					var celda = document.getElementById(idClickeado);
					if(informacion[ids[0]][ids[1]])
					{
					  alert(informacion[ids[0]][ids[1]]);

					}

				});


	}

	$(document).ready(function() {

		$( "#fechas" ).submit(function(e) {
			var desde = document.getElementById("from").value;
			var hasta = document.getElementById("to").value;
			document.location.href = "?from=" + desde +"&to=" + hasta;

			e.preventDefault();
		});

		dibujarTabla(document.getElementById("from").value, document.getElementById("to").value);

	});

</script>

</head>
<%@include file="header.jsp"%>
<div class="block-header">
	<h2>
		HOTEL OCCUPANCY
	</h2>
</div>
<div class="row clearfix">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="card">
            <sec:authorize access="hasAnyRole('ADMIN', 'USER','DBA')">
                <div>
                    <div class="header">
                        <form id="fechas" >
                            <div class="row">

								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-group col-md-12">
                                            <label class="col-md-2 control-lable" for="desde">From</label>
                                            <div class="col-md-3">
                                                <input type="date" path="desde" id="desde" class=" form-control input-sm" value="${desde}"/>
                                            </div>
                                        </div>
									</div>
								</div>


								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="form-group">
										<div class="form-group col-md-12">
                                            <label class="col-md-2 control-lable" for="hasta">To</label>
                                            <div class="col-md-3">
                                                <input type="date" path="hasta" id="hasta" class=" form-control input-sm" value="${hasta}"/>
                                            </div>
                                        </div>
									</div>
								</div>

                            </div>
                            <div class="row clearfix">
                                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-6 m-b-20">
                                        <input type="submit" id="btnSubmit" value="Volver a consultar" class="btn btn-block btn-lg btn-primary waves-effect" />
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
            </sec:authorize>


            <sec:authorize access="hasAnyRole('ADMIN', 'USER','DBA')">
                <div class="body">
                	<div class="table-responsive">
                        <div>
                            <div id="tablaOcupacion-container"></div>
                        </div>
                    </div>
                </div>
            </sec:authorize>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>


<script src=" <c:url value= '/static/js/jquery.dataTables.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/dataTables.bootstrap.min.js'/>"
	type="text/javascript"></script>

<script src=" <c:url value= '/static/js/dataTables.fixedColumns.min.js'/>"
	type="text/javascript"></script>


<script src=" <c:url value= '/static/js/datatables.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/jszip.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/pdfmake.min.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/vfs_fonts.js'/>"
	type="text/javascript"></script>
<script src=" <c:url value= '/static/js/buttons.html5.min.js'/>"
	type="text/javascript"></script>

