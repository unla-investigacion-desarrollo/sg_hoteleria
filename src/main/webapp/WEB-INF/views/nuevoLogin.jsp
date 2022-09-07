<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Sistema de Gestion Hotelera</title>
    <!-- Favicon-->
    <link rel="icon" href="<c:url value='/static/material/images/favicon.ico' />" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="<c:url value='/static/material/plugins/bootstrap/css/bootstrap.css' />" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="<c:url value='/static/material/plugins/node-waves/waves.css' />" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="<c:url value='/static/material/plugins/animate-css/animate.css' />" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="<c:url value='/static/material/css/style.css' />" rel="stylesheet">
</head>

<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <a href="javascript:void(0);">Sistema de Gestión Hotelera</a>
            <small>Nuevo diseño</small>
        </div>
        <div class="card">
            <div class="body">
               		<c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post">
                    <div class="msg">Ingrese sus credenciales para iniciar sesión</div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="ssoId" id="usuario" placeholder="Usuario" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                        </div>
                    </div>
                    <c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>El Usuario/Contraseña no son validos.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>La sesión finalizó correctamente.</p>
						</div>
					</c:if>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                            <label for="rememberme">Recordarme</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">Ingresar</button>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                    </div>
                </form>
            </div>
        </div>
    </div>
    
     <!-- Jquery Core Js -->
    <script src="<c:url value='/static/material/plugins/jquery/jquery.min.js' />"></script>

    <!-- Bootstrap Core Js -->
    <script src="<c:url value='/static/material/plugins/bootstrap/js/bootstrap.js' />"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="<c:url value='/static/material/plugins/node-waves/waves.js' />"></script>

    <!-- Validation Plugin Js -->
    <script src="<c:url value='/static/material/plugins/jquery-validation/jquery.validate.js' />"></script>
    
    <!-- Custom Js -->
    <script src="<c:url value='/static/material/js/admin.js' />"></script>

    <!-- Demo Js -->
    <script src="<c:url value='/static/material/js/pages/examples/sign-in.js' />"></script>
    
    
    
</body>

</html>