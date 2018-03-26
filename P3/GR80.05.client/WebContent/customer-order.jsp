<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.*" %>
<%@page import="java.util.Date" %>
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

		<% Pedido pedido = (Pedido) session.getAttribute("pedido"); %>
		

        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Pedido # <%= pedido.getId() %></h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li><a href="myorders">Mis pedidos</a>
                            </li>
                            <li>Pedido # <%= pedido.getId() %></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div id="content">
            <div class="container">

                <div class="row">

                    <!-- *** LEFT COLUMN ***
			 _________________________________________________________ -->

                    <div class="col-md-9 clearfix" id="customer-order">
                        <% if (pedido.getPagado() == 1) { %>
                            <p class="lead">El pedido #<%= pedido.getId() %> está  <strong>pagado</strong>.</p>
                            <p class="lead text-muted">Si tienes alguna pregunta <a href="contact.jsp">contáctanos</a>, nuestro servicio técnico trabaja para ti 24/7.</p>
                        <% }else { %>
                            <p class="lead">El pedido #<%= pedido.getId() %> está  <strong>pendiente de pago</strong>.</p>
                            <p class="lead text-muted">Si tienes alguna pregunta <a href="contact.jsp">contáctanos</a>, nuestro servicio técnico trabaja para ti 24/7.</p>
                        <% } %>
                        
                        
                        <%
						
                        ArrayList<Eventopedido> eventopedidos = (ArrayList<Eventopedido>)session.getAttribute("eventopedidos");
                        ArrayList<Evento> eventos = (ArrayList<Evento>)session.getAttribute("eventos");
						%>
                        
                        <div class="box">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Evento</th>
                                            <th>Nº de entradas</th>
                                            <th>Precio por entrada</th>
                                            <th>Descuento</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% if (eventopedidos.isEmpty()) { %>
		                                    		<tr>
		                                            	<td>Este pedido está vacío</td>
		                                            </tr>
	                                            </tbody>
                                            </table>
                                        <% } else { %>
                                        	<% int contador_precio = 0; %>
                                        		
                                        		<% for(int i=0;i<=eventopedidos.size(); i++) { %>
			                                        <tr>
			                                            <td>
			                                                <a href="#">
			                                                    <img alt="" class="img-responsive image1" src="visualizarImagen?id=<%= eventos.get(i).getId() %>">
			                                                </a>
			                                            </td>
			                                            <td><a href="#"><%= eventos.get(i).getTitulo()%></a>
			                                            </td>
			                                            <td><%= eventopedidos.get(i).getNumEntradasCompradas() %></td>
			                                            <td><%= eventos.get(i).getPrecioEntrada() %> <i class="fa fa-eur" aria-hidden="true"></i> </td>
			                                            <td>0 <i class="fa fa-eur" aria-hidden="true"></i></td>
			                                            <td><%= eventos.get(i).getPrecioEntrada()*eventopedidos.get(i).getNumEntradasCompradas() %><i class="fa fa-eur" aria-hidden="true"></i></td>
			                                        </tr>
			                                        <% contador_precio += eventos.get(i).getPrecioEntrada()*eventopedidos.get(i).getNumEntradasCompradas(); %>
			                                    <% } %>
			                                    </tbody>
			                                    <tfoot>
			                                        <tr>
			                                            <th colspan="5" class="text-right">Subtotal del pedido</th>
			                                            <th><%= contador_precio %> <i class="fa fa-eur" aria-hidden="true"></i></th>
			                                        </tr>
			                                        <tr>
			                                            <th colspan="5" class="text-right">Gastos de envío</th>
			                                            <th>0 <i class="fa fa-eur" aria-hidden="true"></i></th>
			                                        </tr>
			                                        <tr>
			                                            <th colspan="5" class="text-right">Impuestos</th>
			                                            <th>0 <i class="fa fa-eur" aria-hidden="true"></i></th>
			                                        </tr>
			                                        <tr>
			                                            <th colspan="5" class="text-right">Total</th>
			                                            <th><%= contador_precio %> <i class="fa fa-eur" aria-hidden="true"></i></th>
			                                        </tr>
			                                    </tfoot>
			                                </table>
		                                
		                                <% } %>

                            </div>
                            <!-- /.table-responsive -->

                        </div>
                        <!-- /.box -->
                        <a href="myorders">
                           <button type="button" class="btn btn-xs btn-template-main"><i class="fa fa-angle-left" aria-hidden="true"></i> Volver a Pedidos</button>
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