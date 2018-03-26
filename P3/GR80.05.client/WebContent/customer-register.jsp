<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>
<!-- Include layout -->
<%@ include file="/layouts/top.jsp" %>

        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Nueva cuenta / Registro</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li>Nueva cuenta / Registro</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <div id="content">
            <div class="container">

                <div class="row">
                    <div class="col-md-6">
                        <div class="box">
                            <h2 class="text-uppercase">Nueva cuenta</h2>

                            <p class="lead">¿No dispones de cuenta?</p>
                            <p>Regístrate en menos de un minuto!</p>
                            <p class="text-muted">Si tienes alguna duda, <a href="contact.jsp">contáctanos</a>, nuestro servicio técnico está disponible las 24 horas.</p>

                            <hr>
                            <% if (request.getAttribute("faltandatos") != null) {%>
    							<div class="alert alert-danger alert-dismissible" role="alert">
    		                        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
    		                        </button>
    		                        Los datos introducidos no son correctos
    		                    </div>
    		                <% } %>
    		                
    		               <% if (request.getAttribute("nocoinciden") != null) {%>
    							<div class="alert alert-danger alert-dismissible" role="alert">
    		                        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
    		                        </button>
    		                        Las contraseñas introducidas no coinciden
    		                    </div>
    		                <% } %>
    		                
    		                <% if (request.getAttribute("emailnovalido") != null) {%>
    							<div class="alert alert-danger alert-dismissible" role="alert">
    		                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
    		                            </button>
    		                            El email debe tener la forma aaa@aaa.ccc
    		                    </div>
    		                <% } %>

                            <% if (request.getAttribute("registrocorrecto") != null) { %>
        							<div class="alert alert-success alert-dismissible" role="alert">
        		                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        		                            </button>
        		                            Te has registrado correctamente, accede desde el formulario de Login
        		                    </div>
                            <% } %>

                            <form action="registro" method="post">
                                <div class="form-group">
                                    <label for="name-login">Nombre</label>
                                    <input name="nombre" type="text" class="form-control" id="name-login" required>
                                </div>
                                <div class="form-group">
                                    <label for="name-login">Apellidos</label>
                                    <input name="apellidos" type="text" class="form-control" id="apellidos-login" required>
                                </div>
                                <div class="form-group">
                                    <label for="email-login">Email</label>
                                    <input type="text"name="email" class="form-control" id="email-login" required>
                                </div>
                                <div class="form-group">
                                    <label for="password-login">Contraseña</label>
                                    <input type="password" name="password" class="form-control" id="password-login" required>
                                </div>
                                <div class="form-group">
                                    <label for="password-login">Repetir contraseña</label>
                                    <input type="password" name="password2" class="form-control" id="password2-login" required>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i> Registrarse</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="col-md-6">
                    
                        <div class="box">
                            <h2 class="text-uppercase">Login</h2>

                            <p class="lead">¿Ya dispones de cuenta?</p>

                            <hr>
                            
                            <% if (request.getAttribute("fallo") != null) { %>
    							<div class="alert alert-danger alert-dismissible" role="alert">
    		                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
    		                            </button>
    		                            Los datos introducidos no son correctos
    		                    </div>
    		                <% } %>


                            <form action="login" method="post">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input name="email" type="text" class="form-control" id="email" required>
                                </div>
                                <div class="form-group">
                                    <label for="password">Contraseña</label>
                                    <input name="password" type="password" class="form-control" id="password" required>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-sign-in"></i> Log in</button>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>