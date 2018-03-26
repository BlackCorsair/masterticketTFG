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
                    <div class="col-md-6">
                        <h1>Mensajería con usuarios</h1>
                    </div>
                    <div class="col-md-6">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li>Mensajería con usuarios</li>
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

                        <p class="lead">Puede comunicarse con los usuarios del sistema.</p>

                        <div class="box">

                            <div class="heading">
                                <h3 class="text-uppercase">Enviar mensaje</h3>
                            </div>

							<% if (request.getAttribute("faltandatos") != null) {%>
    							<div class="alert alert-success alert-dismissible" role="alert">
        		                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        		                            </button>
        		                            Tu mensaje se ha enviado con éxito
        		                </div>
    		                <% } %>


                            <form action="sendMessage" method="POST">
                                <textarea rows="2" cols="64" name="message"></textarea>
								<br>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-comment" aria-hidden="true"></i> Enviar mensaje</button>
                                </div>
                            </form>
							<a href="readMessage"><button type="submit" class="btn btn-template-main"><i class="fa fa-inbox" aria-hidden="true"></i> Ver mensajes recibidos</button></a>
                        </div>
                        <!-- /.box -->

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




