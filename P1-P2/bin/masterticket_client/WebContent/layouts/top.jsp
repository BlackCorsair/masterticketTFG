<!DOCTYPE jsp>
<jsp lang="en">
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="masterticket.models.*" %>
<%@ page import="java.util.List" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>
<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>masterticket</title>

    <meta name="keywords" content=""> 

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800' rel='stylesheet' type='text/css'>

    <!-- Bootstrap and Font Awesome css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Css animations  -->
    <link href="css/animate.css" rel="stylesheet">

    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- Custom stylesheet - for your changes -->
    <link href="css/custom.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

    <!-- Responsivity for older IE -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/jsp5shiv/3.7.2/jsp5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

    <!-- Favicon and apple touch icons-->
    <link rel="icon" href="img/favicon-ticket.ico?" type="image/x-icon">
    <link rel="apple-touch-icon" href="img/apple-touch-icon.png" />
    <link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="img/apple-touch-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="img/apple-touch-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="img/apple-touch-icon-152x152.png" />
    <!-- owl carousel css -->

    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
</head>

<body>

    <div id="all">

        <header>
            <div id="top">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-5 contact">
                            <p class="hidden-sm hidden-xs">Contáctenos en +34 111 222 333 o contacto@masterticket.tk </p>
                            <p class="hidden-md hidden-lg"><a href="#" data-animate-hover="pulse"><i class="fa fa-phone"></i></a>  <a href="#" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                            </p>
                        </div>
                        <div class="col-xs-7">
							
							<% Usuario user = (Usuario)session.getAttribute("User"); %>
							
							<% if(user == null) { %>
	                            <div class="login">
	                                <a href="#" data-toggle="modal" data-target="#login-modal"><i class="fa fa-sign-in"></i> <span class="hidden-xs text-uppercase">Login</span></a>
	                                <a href="registro"><i class="fa fa-user"></i> <span class="hidden-xs text-uppercase">Registrate</span></a>
	                            </div>
	                        <% } else { %>
	                        	<% if(user.getTipo().equals("admin")) { %>
		                        	<div class="login">
	                                    <a href="dashboard"><i class="fa fa-user"></i> <span class="hidden-xs text-uppercase"><%= user.getNombre() %></span></a>
	                                    <a href="dashboard"><i class="fa fa-tachometer" aria-hidden="true"></i><span class="hidden-xs text-uppercase" style="margin-left:10px;">Área personal</span></a>
	                                    <a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i><span class="hidden-xs text-uppercase" style="margin-left:10px;">Logout</span></a>
		                            </div>
	                            <% }else{ %>
	                            	<div class="login">
	                                    <a href="myorders"><i class="fa fa-user"></i> <span class="hidden-xs text-uppercase"><%= user.getNombre() %></span></a>
	                                    <a href="myorders"><i class="fa fa-tachometer" aria-hidden="true"></i><span class="hidden-xs text-uppercase" style="margin-left:10px;">Área personal</span>
                                        </a>
                                        <a href="viewbasket"><i class="fa fa-shopping-cart" aria-hidden="true"></i><span class="hidden-xs text-uppercase" style="margin-left:10px;">Carrito</span>
                                        </a>
	                                    <a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i><span class="hidden-xs text-uppercase" style="margin-left:10px;">Logout</span></a>
		                            </div>
	                            <% } %>
	                        <% } %>

                        </div>
                    </div>
                </div>
            </div>

            <div class="navbar-affixed-top" data-spy="affix" data-offset-top="200">

                <div class="navbar navbar-default yamm" role="navigation" id="navbar">

                    <div class="container">
                        <div class="navbar-header">

                            <a class="navbar-brand home" href="index.jsp">
                                <img src="img/logo-masterticket.png" alt="masterticket" class="hidden-xs hidden-sm" style="width:200px;height:50px;">
                                <img src="img/logo-masterticket.png" alt="masterticket" class="visible-xs visible-sm" style="width:200px;height:50px;"><span class="sr-only">masterticket</span>
                            </a>
                            <div class="navbar-buttons">
                                <button type="button" class="navbar-toggle btn-template-main" data-toggle="collapse" data-target="#navigation">
                                    <span class="sr-only">Navegación</span>
                                    <i class="fa fa-align-justify"></i>
                                </button>
                            </div>
                        </div>
                        <!--/.navbar-header -->

                        <div class="navbar-collapse collapse" id="navigation">

                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown active">
                                    <a href="index.jsp" class="dropdown-toggle" data-toggle="dropdown">Inicio</a>
                                </li>

                                <li class="dropdown use-yamm yamm-fw">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tickets<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <div class="yamm-content">
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <img src="img/concert.jpg" class="img-responsive hidden-xs" alt="">
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <h5>Eventos</h5>
                                                        <ul>
                                                            <li><a href="viewevents?categoria=concierto">Conciertos</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=festival">Festivales</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=musical">Musicales</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=teatro">Teatro</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=monologo">Monólogos</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=ballet">Ballet</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=opera">Ópera</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=turismo">Turismo</a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <br><br>
                                                        <ul>
                                                            <li><a href="viewevents?categoria=museo">Exposiciones y museos</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=profesional">Eventos profesionales</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=deportivo">Deportes</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=curso">Cursos</a>
                                                            </li>
                                                            <li><a href="viewevents?categoria=circo">Circo</a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="javascript: void(0)" class="dropdown-toggle" data-toggle="dropdown">Contacto <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="contact.jsp">Contacto</a>
                                        </li>
                                        <li><a href="contact2.jsp">Quienes somos</a>
                                        </li>
                                        <li><a href="contact3.jsp">Nuestra filosofía</a>
                                        </li>

                                    </ul>
                                </li>
                            </ul>

                        </div>
                        <!--/.nav-collapse -->



                        <div class="collapse clearfix" id="search">

                            <form class="navbar-form" role="search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search">
                                    <span class="input-group-btn">

                            <button type="submit" class="btn btn-template-main"><i class="fa fa-search"></i></button>

                </span>
                                </div>
                            </form>

                        </div>
                        <!--/.nav-collapse -->

                    </div>


                </div>
                <!-- /#navbar -->

            </div>

            <!-- *** NAVBAR END *** -->

        </header>

        <!-- *** LOGIN MODAL ***
_________________________________________________________ -->

        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="Login">Acceder</h4>
                    </div>
                    <div class="modal-body">
                        <form action="login" method="post">
                            <div class="form-group">
                                <input name="email" type="text" class="form-control" id="email_modal" placeholder="email" required>
                            </div>
                            <div class="form-group">
                                <input name="password" type="password" class="form-control" id="password_modal" placeholder="password" required>
                            </div>

                            <p class="text-center">
                                <button class="btn btn-template-main"><i class="fa fa-sign-in"></i> Acceder</button>
                            </p>

                        </form>

                        <p class="text-center text-muted">¿Aún no te has registrado?</p>
                        <p class="text-center text-muted"><a href="registro"><strong>Regístrate</strong></a>! Es fácil y se puede hacer en 1&nbsp;minuto, te da acceso a descuentos especiales, al club masterticket y mucho más!</p>

                    </div>
                </div>
            </div>
        </div>

        <!-- *** LOGIN MODAL END *** -->
        