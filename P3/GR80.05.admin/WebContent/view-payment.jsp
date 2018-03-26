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
                        <h1>Método de pago</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li>Método de pago</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

		<% int precio = Integer.parseInt((String)request.getAttribute("precio")); %>
		<% int id_usuario = Integer.parseInt((String)request.getAttribute("id_usuario")); %>

        <div id="content">
            <div class="container">

                <div class="row">

                    <div class="col-md-9 clearfix" id="checkout">

                        <div class="box">
                            <form method="post" action="viewpayment">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="viewbasket"><i class="fa fa-eye"></i><br>Carrito de la compra</a>
                                    </li>
                                    <li class="active"><a href="shop-checkout3.jsp"><i class="fa fa-money"></i><br>Método de pago</a>
                                    </li>
                                </ul>

                                <div class="content">
                                    <form action="viewpayment" method="post">
                                    	<input name="id_usuario" type="hidden" value="<%= id_usuario %>" id="id_usuario">
                                    	<input name="precio" type="hidden" value="<%= precio %>" id="precio">
                                        <div class="form-group">
                                            <label for="numero_tarjeta">Número de la tarjeta</label>
                                            <input maxlength="16" name="numero_tarjeta" type="text" class="form-control" id="numero_tarjeta">
                                        </div>
                                        <div class="form-group">
                                            <label for="cvv_tarjeta">CVV Tarjeta</label>
                                            <input maxlength="3" name="cvv_tarjeta" type="text" class="form-control" id="cvv_tarjeta">
                                        </div>
                                        <div class="form-group">
                                            <label for="fecha_caducidad">Fecha de caducidad</label>
                                            <input name="fecha_caducidad" type="date" class="form-control" id="fecha_caducidad">
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-template-main"><i class="fa fa fa-credit-card-alt"></i> Realizar el pedido</button>
                                        </div>
                                    </form>

                                </div>
                                <!-- /.content -->

                                <div class="box-footer">
                                    <div class="pull-left">
                                        <a href="viewbasket" class="btn btn-default"><i class="fa fa-chevron-left"></i>Volver al Carrito</a>
                                    </div>
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
                                            <th><%= precio %> <i class="fa fa-eur" aria-hidden="true"></i></th>
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
                                            <th><%= precio %> <i class="fa fa-eur" aria-hidden="true"></i></th>
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