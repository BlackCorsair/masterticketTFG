<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<link href="css/chat.css" rel="stylesheet">
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
<% Usuario userdestino = (Usuario) request.getAttribute("userdestino"); %>
<% ArrayList<Mensaje> mensajesorigen = (ArrayList<Mensaje>) request.getAttribute("mensajesorigen"); %>
<% ArrayList<Mensaje> mensajesdestino = (ArrayList<Mensaje>) request.getAttribute("mensajesdestino"); %>
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>Mensajería con <%= userdestino.getNombre() %></h1>
                    </div>
                    <div class="col-md-6">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li><a href="comunications">Mensajería con usuarios</a>
                            </li>
                            <li>Mensajería con <%= userdestino.getNombre() %></li>
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
                    
                    	<% int size = mensajesorigen.size(); %>
                    	<% int size2 = mensajesdestino.size(); %>
                    	<%
                    	int maxsize = size;
                    	if(size2 > size){
                    		maxsize = size2;
                    	}
                    	%>
						
						<div class="container">
							<div class="row">
								<div class="col-md-9">
						    	    <div class="panel panel-primary">
						              <div class="panel-heading"><b> <%= userdestino.getNombre() %> </b></div>
						              <div class="panel-body"  id="zona_mensajes" style="background:url('http://subtlepatterns.com/patterns/geometry2.png');height: 300px; }">
						              	<% for(int i=0; i<size; i++){ %>
						              		<% Mensaje msg = mensajesorigen.get(i); %>
							                <div class="clearfix"><blockquote class="you pull-left"><%= msg.getContenido() %></blockquote></div>
							            <% } %>
							            <% for(int i=0; i<size; i++){ %>
						              		<% Mensaje msg = mensajesdestino.get(i); %>
							                <div class="clearfix"><blockquote class="me pull-right"><%= msg.getContenido() %></blockquote></div>
							            <% } %>
						              	
						              </div>
						              <form action="addmensaje" method="post" style="margin-top:20px !important;">
						              		<input type="hidden" name="idOrigen" value="<%= ususesion.getId() %>">
						              		<input type="hidden" name="idDestino" value="<%= userdestino.getId() %>">
						              		<input name="contenido" type="text" class="form-control" id="contenido">
						              		<button type="submit" class="btn btn-template-main"><i class="fa fa-paper-plane"></i> Enviar</button>
						              </form>
						            </div>
						        </div>
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




