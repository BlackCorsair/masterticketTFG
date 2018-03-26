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
<% Usuario ususesion = (Usuario)session.getAttribute("User"); %>
<% Usuario editar = (Usuario)session.getAttribute("editar"); %>
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Mi cuenta</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li>Mi cuenta</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div id="content" class="clearfix">

            <div class="container">

                <div class="row">

                    <!-- *** LEFT COLUMN ***
			 _________________________________________________________ -->

                    <div class="col-md-9 clearfix" id="customer-account">

                        <p class="lead">Puede cambiar su contraseña, sus datos personales o dar de baja su cuenta.</p>

                        <div class="box">

                            <div class="heading">
                                <h3 class="text-uppercase">Cambio de contraseña</h3>
                            </div>

                            <form action="changepassword?id=<%=ususesion.getId()%>" method="POST">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="password_old">Contraseña vieja</label>
                                            <input type="password" class="form-control" id="password_old" name="password_old" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="password_1">Nueva contraseña</label>
                                            <input type="password" class="form-control" id="password_1" name="password_1" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="password_2">Repetir contraseña</label>
                                            <input type="password" class="form-control" id="password_2" name="password_2" required>
                                        </div>
                                    </div>
                                    <input type="hidden" name="country" value="<%=ususesion.getId()%>">
                                </div>
                                <!-- /.row -->

                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-save"></i> Guardar nueva contraseña</button>
                                </div>
                            </form>

                        </div>
                        <!-- /.box -->


                        <div class="box clearfix">
                            <div class="heading">
                                <h3 class="text-uppercase">Detalles personales</h3>
                            </div>

                            <form action="editaccount?id=<%=ususesion.getId()%>" method="POST" accept-charset="utf-8">
                                <div class="form-group">
                                    <label for="name-login">Nombre</label>
                                    <input name="nombre" value="<%=editar.getNombre()%>" type="text" class="form-control" id="name-login" required>
                                </div>
                                <div class="form-group">
                                    <label for="name-login">Apellidos</label>
                                    <input name="apellidos" value="<%=editar.getApellidos()%>" type="text" class="form-control" id="apellidos-login" required>
                                </div>
                                <div class="form-group">
                                    <label for="state">Cuenta</label>
                                    <select class="form-control" id="type" name="tipo" value="<%=editar.getTipo()%>" >
                                        <option value="admin" <%if(editar.getTipo().equals("admin")){ %>selected<%}%>>Administrador</option>
                                        <option value="admin" <%if(editar.getTipo().equals("comprador")){ %>selected<%}%>>Cuenta cliente</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="email-login">Email</label>
                                    <input type="text" name="email" value="<%=editar.getEmail()%>"  class="form-control" id="email-login" required>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i> Guardar cambios</button>
                                </div>
                            </form>

                        </div>

                        <div class="box clearfix">
                            <div class="heading">
                                <h3 class="text-uppercase">Baja en la plataforma</h3>
                            </div>
                                <div class="text-center">
                                    <a href="darbaja?id=<%= ususesion.getId() %>">
                                        <button type="submit" class="btn btn-template-main"><i class="fa fa-minus-circle"></i> Darse de baja</button>
                                    </a>
                                </div>

                        </div>

                    </div>
                    <!-- /.col-md-9 -->

                    <!-- *** LEFT COLUMN END *** -->

                    <%@ include file="/layouts/menu.jsp" %>

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>