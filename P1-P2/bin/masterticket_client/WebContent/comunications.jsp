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
                        <h1>Order # 1735</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Home</a>
                            </li>
                            <li><a href="customer-orders.jsp">My orders</a>
                            </li>
                            <li>Order # 1735</li>
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

                        <p class="lead">Order #1735 was placed on <strong>22/06/2013</strong> and is currently <strong>Being prepared</strong>.</p>
                        <p class="lead text-muted">If you have any questions, please feel free to <a href="contact.jsp">contact us</a>, our customer service center is working for you 24/7.</p>

                        <div class="box">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Product</th>
                                            <th>Quantity</th>
                                            <th>Unit price</th>
                                            <th>Discount</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <a href="#">
                                                    <img src="img/detailsquare.jpg" alt="White Blouse Armani">
                                                </a>
                                            </td>
                                            <td><a href="#">White Blouse Armani</a>
                                            </td>
                                            <td>2</td>
                                            <td>$123.00</td>
                                            <td>$0.00</td>
                                            <td>$246.00</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="#">
                                                    <img src="img/basketsquare.jpg" alt="Black Blouse Armani">
                                                </a>
                                            </td>
                                            <td><a href="#">Black Blouse Armani</a>
                                            </td>
                                            <td>1</td>
                                            <td>$200.00</td>
                                            <td>$0.00</td>
                                            <td>$200.00</td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th colspan="5" class="text-right">Order subtotal</th>
                                            <th>$446.00</th>
                                        </tr>
                                        <tr>
                                            <th colspan="5" class="text-right">Shipping and handling</th>
                                            <th>$10.00</th>
                                        </tr>
                                        <tr>
                                            <th colspan="5" class="text-right">Tax</th>
                                            <th>$0.00</th>
                                        </tr>
                                        <tr>
                                            <th colspan="5" class="text-right">Total</th>
                                            <th>$456.00</th>
                                        </tr>
                                    </tfoot>
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="row addresses">
                                <div class="col-sm-6">
                                    <h3 class="text-uppercase">Invoice address</h3>
                                    <p>John Brown
                                        <br>13/25 New Avenue
                                        <br>New Heaven
                                        <br>45Y 73J
                                        <br>England
                                        <br>Great Britain</p>
                                </div>
                                <div class="col-sm-6">
                                    <h3 class="text-uppercase">Shipping address</h3>
                                    <p>John Brown
                                        <br>13/25 New Avenue
                                        <br>New Heaven
                                        <br>45Y 73J
                                        <br>England
                                        <br>Great Britain</p>
                                </div>
                            </div>
                            <!-- /.addresses -->

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