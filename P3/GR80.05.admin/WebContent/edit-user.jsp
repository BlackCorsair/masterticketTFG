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
                        <h1>Editar usuario</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li><a href="dashboard">Gestión de usuarios</a>
                            </li>
                            <li>Editar usuario</li>
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

                    <div class="col-md-9 clearfix" id="edit-user">

                        <div class="box clearfix">
                            <div class="heading">
                                <h3 class="text-uppercase">Detalles de la cuenta</h3>
                            </div>

                            <form action="edituser?id=<%=ususesion.getId()%>" method="POST" accept-charset="utf-8">
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
                                    <%if(editar.getTipo().equals("admin")){%>
	                              	    <option value="admin" selected>Administrador</option>
	                                    <option value="comprador">Cuenta cliente</option>                            	    
                              	    <%}else{ %>
	                              	    <option value="admin">Administrador</option>
		                                <option value="comprador" selected>Cuenta cliente</option>   
		                            <%} %>
                                    </select>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i> Guardar cambios</button>
                                </div>
                            </form>

                        </div>
						<a href="dashboard">
                           <button type="button" class="btn btn-xs btn-template-main"><i class="fa fa-angle-left" aria-hidden="true"></i> Volver a Gestión de Usuarios</button>
                        </a>
                        <br>
                        <br>
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