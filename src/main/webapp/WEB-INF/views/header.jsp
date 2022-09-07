<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>${titulo}</title>
    <!-- Favicon-->
    <link rel="icon" href="<c:url value='/static/material/images/favicon.ico' />" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="<c:url value='/static/material/css/fuente-roboto.css' />" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/material/css/material-icons.css' />" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="<c:url value='/static/material/plugins/bootstrap/css/bootstrap.css' />" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="<c:url value='/static/material/plugins/node-waves/waves.css' />" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="<c:url value='/static/material/plugins/animate-css/animate.css' />" rel="stylesheet" />
    
    <!-- Sweetalert Css -->
    <link href="<c:url value='/static/material/plugins/sweetalert/sweetalert.css' />" rel="stylesheet" />
    
    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="<c:url value='/static/material/css/themes/all-themes.css' />" rel="stylesheet" />
    
    <!-- Colorpicker Css -->
    <link href="<c:url value='/static/material/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css' />"  rel="stylesheet" />

    <!-- Multi Select Css -->
    <link href="<c:url value='/static/material/plugins/multi-select/css/multi-select.css' />" rel="stylesheet">

    <!-- Bootstrap Material Datetime Picker Css -->
    <link href="<c:url value='/static/material/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css' />" rel="stylesheet" />

    <!-- Bootstrap Select Css -->
    <link href="<c:url value='/static/material/plugins/bootstrap-select/css/bootstrap-select.css' />"  rel="stylesheet" />
    
    
    <!-- JQuery DataTable Css -->
     <link href="<c:url value='/static/material/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css' />"  rel="stylesheet" />
    
     <!-- Custom Css -->
    <link href="<c:url value='/static/material/css/style.css' />" rel="stylesheet">
    
     <!-- Custom SGH Css -->
    <link href="<c:url value='/static/material/css/custom.css' />" rel="stylesheet">
</head>
<body class="theme-blue">
    <!-- Page Loader -->
    <div class="page-loader-wrapper">
        <div class="loader">
            <div class="preloader">
                <div class="spinner-layer pl-red">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
            </div>
            <p id="loaderText">Cargando...</p>
        </div>
    </div>
    <!-- #END# Page Loader -->
    <!-- Overlay For Sidebars -->
    <div class="overlay"></div>
    <!-- #END# Overlay For Sidebars -->
    <!-- Search Bar -->
    <div class="search-bar">
        <div class="search-icon">
            <i class="material-icons">search</i>
        </div>
        <input type="text" placeholder="START TYPING...">
        <div class="close-search">
            <i class="material-icons">close</i>
        </div>
    </div>
    <!-- #END# Search Bar -->
    <!-- Top Bar -->
    <nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                <a href="javascript:void(0);" class="bars"></a>
                <a class="navbar-brand">Sistema de Gestión Hotelera</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <!-- #END# Tasks -->
                    <li class="pull-right"><a href="javascript:void(0);" class="js-right-sidebar" data-close="true"><i class="material-icons">more_vert</i></a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- #Top Bar -->
    <section>
        <!-- Left Sidebar -->
        <aside id="leftsidebar" class="sidebar">
            <!-- User Info -->
            <div class="user-info">
                <div class="image">
                    <img src="<c:url value='/static/material/images/user.png'/>" width="48" height="48" alt="User" />
                </div>
                <div class="info-container">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${loggedinuser}</div>
                    <div class="btn-group user-helper-dropdown">
                        <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="javascript:void(0);"><i class="material-icons">person</i>Profile</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="<c:url value="/logout" />"><i class="material-icons">input</i>Sign Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- #User Info -->
            <!-- Menu -->
            <div class="menu">
                <ul class="list">
                <li class="header">MENU</li>
                    <li class="active">
                        <a class="navbar-brand" href="<c:url value="/" />">
                            <i class="material-icons">home</i>
                            <span>Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value='/panelOcupacion/' />">
                            <i class="material-icons">event</i>
                            <span>Ocupacion del Hotel</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">group</i>
                            <span>Clientes</span>
                        </a>
                        <ul class="ml-menu">
                            <li>
                                <a href="<c:url value='/pasajero/' />">Pasajeros</a>
                            </li>
                            <li>
                                <a href="<c:url value='/organizacion/' />">Organizaciones</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">library_books</i>
                            <span>Gestión del Hotel</span>
                        </a>
                        <ul class="ml-menu">
                            <li>
                                <a href="<c:url value='/servicio/' />">Servicios</a>
                            </li>
                            <li>
                                <a href="<c:url value='/planAlojamiento/' />">Plan Alojamiento</a>
                            </li>
                            <li>
                                <a href="<c:url value='/estadia/' />">Estadía</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">settings</i>
                            <span>Configuraciones</span>
                        </a>
                        <ul class="ml-menu">
                            <li>
                                <a href="<c:url value='/usuarios/' />">Usuarios</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="<c:url value='/tipoDocumento/' />">Tipos de Documentos</a>
                            </li>
                            <li>
                                <a href="<c:url value='/caracteristicaPasajero/' />">Caracteristicas de Pasajeros</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="<c:url value='/hotel/' />">Hoteles</a>
                            </li>
                            <li>
                                <a href="<c:url value='/tipoHabitacion/' />">Tipos de Habitaciones</a>
                            </li>
                            <li>
                                <a href="<c:url value='/caracteristicaHabitacion/' />">Caracteristicas de Habitaciones</a>
                            </li>
                            <li>
                                <a href="<c:url value='/estadoHabitacion/' />">Estados de Habitaciones</a>
                            </li>
                            <li>
                                <a href="<c:url value='/habitacion/' />">Habitaciones</a>
                            </li>
                            <li>
                                <a href="<c:url value='/tipoServicio/' />">Tipos de Servicios</a>
                            </li>
                            <li>
                                <a href="<c:url value='/estadoEstadia/' />">Estados Estadía</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">attach_money</i>
                            <span>Facturación</span>
                        </a>
                        <ul class="ml-menu">
                            <li>
                                <a href="<c:url value='/comprobante/' />">Comprobantes</a>
                            </li>
                            <li>
                                <a href="<c:url value='/preticket/' />">Pre-Tickets</a>
                            </li>
                            <li>
                                <a href="<c:url value='/tipoComprobante/' />">Tipos de Comprobantes</a>
                            </li>
                            <li>
                                <a href="<c:url value='/conceptosAIncluir/' />">Conceptos</a>
                            </li>
                            <li>
                                <a href="<c:url value='/formaDePago/' />">Formas de Pago</a>
                            </li>
                            <li>
                                <a href="<c:url value='/moneda/' />">Monedas</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- #Menu -->
            <!-- Footer -->
            <div class="legal">
                <div class="copyright">
                    &copy; 2018 <a href="javascript:void(0);">Sistema de Gestión Hotelera</a>.
                </div>
                <div class="version">
                    <b>Version: </b> 1.0.0
                </div>
            </div>
            <!-- #Footer -->
        </aside>
        <!-- #END# Left Sidebar -->
        <!-- Right Sidebar -->
        <aside id="rightsidebar" class="right-sidebar">
            <ul class="nav nav-tabs tab-nav-right" role="tablist">
                <li role="presentation" class="active"><a href="#skins" data-toggle="tab">SKINS</a></li>
                <li role="presentation"><a href="#settings" data-toggle="tab">SETTINGS</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active in active" id="skins">
                    <ul class="demo-choose-skin">
                        <li data-theme="red" class="active">
                            <div class="red"></div>
                            <span>Red</span>
                        </li>
                        <li data-theme="pink">
                            <div class="pink"></div>
                            <span>Pink</span>
                        </li>
                        <li data-theme="purple">
                            <div class="purple"></div>
                            <span>Purple</span>
                        </li>
                        <li data-theme="deep-purple">
                            <div class="deep-purple"></div>
                            <span>Deep Purple</span>
                        </li>
                        <li data-theme="indigo">
                            <div class="indigo"></div>
                            <span>Indigo</span>
                        </li>
                        <li data-theme="blue">
                            <div class="blue"></div>
                            <span>Blue</span>
                        </li>
                        <li data-theme="light-blue">
                            <div class="light-blue"></div>
                            <span>Light Blue</span>
                        </li>
                        <li data-theme="cyan">
                            <div class="cyan"></div>
                            <span>Cyan</span>
                        </li>
                        <li data-theme="teal">
                            <div class="teal"></div>
                            <span>Teal</span>
                        </li>
                        <li data-theme="green">
                            <div class="green"></div>
                            <span>Green</span>
                        </li>
                        <li data-theme="light-green">
                            <div class="light-green"></div>
                            <span>Light Green</span>
                        </li>
                        <li data-theme="lime">
                            <div class="lime"></div>
                            <span>Lime</span>
                        </li>
                        <li data-theme="yellow">
                            <div class="yellow"></div>
                            <span>Yellow</span>
                        </li>
                        <li data-theme="amber">
                            <div class="amber"></div>
                            <span>Amber</span>
                        </li>
                        <li data-theme="orange">
                            <div class="orange"></div>
                            <span>Orange</span>
                        </li>
                        <li data-theme="deep-orange">
                            <div class="deep-orange"></div>
                            <span>Deep Orange</span>
                        </li>
                        <li data-theme="brown">
                            <div class="brown"></div>
                            <span>Brown</span>
                        </li>
                        <li data-theme="grey">
                            <div class="grey"></div>
                            <span>Grey</span>
                        </li>
                        <li data-theme="blue-grey">
                            <div class="blue-grey"></div>
                            <span>Blue Grey</span>
                        </li>
                        <li data-theme="black">
                            <div class="black"></div>
                            <span>Black</span>
                        </li>
                    </ul>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="settings">
                    <div class="demo-settings">
                        <p>GENERAL SETTINGS</p>
                        <ul class="setting-list">
                            <li>
                                <span>Report Panel Usage</span>
                                <div class="switch">
                                    <label><input type="checkbox" checked><span class="lever"></span></label>
                                </div>
                            </li>
                            <li>
                                <span>Email Redirect</span>
                                <div class="switch">
                                    <label><input type="checkbox"><span class="lever"></span></label>
                                </div>
                            </li>
                        </ul>
                        <p>SYSTEM SETTINGS</p>
                        <ul class="setting-list">
                            <li>
                                <span>Notifications</span>
                                <div class="switch">
                                    <label><input type="checkbox" checked><span class="lever"></span></label>
                                </div>
                            </li>
                            <li>
                                <span>Auto Updates</span>
                                <div class="switch">
                                    <label><input type="checkbox" checked><span class="lever"></span></label>
                                </div>
                            </li>
                        </ul>
                        <p>ACCOUNT SETTINGS</p>
                        <ul class="setting-list">
                            <li>
                                <span>Offline</span>
                                <div class="switch">
                                    <label><input type="checkbox"><span class="lever"></span></label>
                                </div>
                            </li>
                            <li>
                                <span>Location Permission</span>
                                <div class="switch">
                                    <label><input type="checkbox" checked><span class="lever"></span></label>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </aside>
        <!-- #END# Right Sidebar -->
    </section>

    <section class="content">
        <div class="container-fluid">
