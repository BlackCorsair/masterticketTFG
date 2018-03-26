<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
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
                        <h1>Carrito de la compra</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li>Carrito de la compra</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <% ArrayList<Evento> eventosCarrito = (ArrayList<Evento>) request.getAttribute("eventosCarrito"); %>
        <% ArrayList<Carrito> carritoCompra = (ArrayList<Carrito>) request.getAttribute("carritoCompra"); %>
        <div id="content">
            <div class="container">

                <div class="row">

                    <div class="col-md-9 clearfix" id="checkout">

                        <div class="box">
                            <form method="get" action="viewpayment">
                                <ul class="nav nav-pills nav-justified">
                                    <li class="active"><a href="#"><i class="fa fa-eye"></i><br>Carrito de la compra</a>
                                    </li>
                                    <% if(carritoCompra == null){ %>
                                    	<li class="disabled"><a href="viewpayment"><i class="fa fa-money"></i><br>Método de pago</a>
                                    	</li>
                                    <% } else { %>
                                    	<li><a href="viewpayment"><i class="fa fa-money"></i><br>Método de pago</a>
                                    	</li>
                                    <% } %>
                                </ul>

                                <div class="content">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th colspan="2">Producto</th>
                                                    <th>Cantidad</th>
                                                    <th>Precio por entrada</th>
                                                    <th>Descuento</th>
                                                    <th>Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <% int contador_precio = 0; %>
                                           		<% if(carritoCompra != null){ %>
	                                                
	                                                <% for (int i = 0; i < eventosCarrito.size(); i++) { %>
	                                                    <% Evento ev = eventosCarrito.get(i); %>
	                                                    <% Carrito cr = carritoCompra.get(i); %>
	                                                    <tr>
	                                                        <td>
	                                                            <a href="#">
	                                                                <img src="visualizarImagen?id=<%= ev.getId() %>" alt="<%=ev.getTitulo()%>">
	                                                            </a>
	                                                        </td>
	                                                        <td><a href="viewevent?id=<%=ev.getId()%>"><%=ev.getTitulo()%></a>
	                                                        </td>
	                                                        <td><%=cr.getNumEntradas()%></td>
	                                                        <td><%=ev.getPrecioEntrada()%> <i class="fa fa-eur" aria-hidden="true"></i></td>
	                                                        <td>0 <i class="fa fa-eur" aria-hidden="true"></i></td>
	                                                        <td><%=cr.getNumEntradas()*cr.getPrecioEntradas()%> <i class="fa fa-eur" aria-hidden="true"></i></td>
	                                                        <% contador_precio += cr.getNumEntradas()*cr.getPrecioEntradas(); %>
	                                                    </tr>
	                                                <% } %>
	                                            <% } else { %>
	                                           				<td colspan="6">
	                                                            No hay eventos en el carrito
	                                                        </td>
	                                            <% } %>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th colspan="5">Total</th>
                                                    <% if (contador_precio != 0){ %>
                                                        <th><%= contador_precio %> <i class="fa fa-eur" aria-hidden="true"></i></th>
                                                    <% } else { %>
                                                        <th>0 <i class="fa fa-eur" aria-hidden="true"></i></th>
                                                    <% } %>
                                                </tr>
                                            </tfoot>
                                        </table>

                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.content -->

                                <div class="box-footer">
                                	<% if (contador_precio != 0){ %>
	                                    <div class="pull-right">
	                                        <button type="submit" class="btn btn-template-main">Continuar con la forma de pago<i class="fa fa-chevron-right"></i>
	                                        </button>
	                                    </div>
	                                <% } %>
                                </div>
                            </form>
                        </div>
                        <!-- /.box -->


                    </div>
                    <!-- /.col-md-9 -->

                    <div class="col-md-3">

                        <div class="box" id="order-summary">
                            <div class="box-header">
                                <h3>Resumen del pedido</h3>
                            </div>

                            <div class="table-responsive">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <td>Subtotal</td>
                                            <th><%= contador_precio %> <i class="fa fa-eur" aria-hidden="true"></i></th>
                                        </tr>
                                        <tr>
                                            <td>Gastos de envío</td>
                                            <th>0 <i class="fa fa-eur" aria-hidden="true"></i></th>
                                        </tr>
                                        <tr>
                                            <td>Impuestos</td>
                                            <th>0 <i class="fa fa-eur" aria-hidden="true"></i></th>
                                        </tr>
                                        <tr class="total">
                                            <td>Total</td>
                                            <th><%= contador_precio %> <i class="fa fa-eur" aria-hidden="true"></i></th>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>

                    </div>
                    <!-- /.col-md-3 -->

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->


<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>