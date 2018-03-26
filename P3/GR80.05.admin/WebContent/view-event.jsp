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

	<% Evento evento = (Evento) request.getAttribute("evento"); %>
    <% Usuario user_shop = (Usuario)session.getAttribute("User"); %>          

        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1><%= evento.getTitulo() %></h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li><a href="viewevents?categoria=<%= evento.getCategoria() %>"><%= evento.getCategoria() %></a>
                            </li>
                            <li><%= evento.getTitulo() %></li>
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

                    <div class="">

                        <p class="goToDescription"><a href="#details" class="scroll-to text-uppercase">Ver más detalles<a>
                        </p>

                        <div class="row" id="productMain">
                            <div class="col-sm-6">
                                <div id="mainImage">
                                    <img src="visualizarImagen?id=<%= evento.getId() %>" alt="" class="img-responsive">
                                </div>

                                <% if(evento.getEstado().equals("disponible")) { %>
                                        <div class="ribbon new">
                                            <div class="theribbon" style="width:100px !important;">Disponible</div>
                                            <div class="ribbon-background"></div>
                                        </div>
                                    <% } else if(evento.getEstado().equals("completo")) { %>
                                        <div class="ribbon sale" style="color:yellow;">
                                            <div class="theribbon" style="width:100px !important;">Completo</div>
                                            <div class="ribbon-background"></div>
                                        </div>
                                    <% } else if(evento.getEstado().equals("terminado")) { %>
                                        <div class="ribbon sale" style="color:blue !important;">
                                            <div class="theribbon" style="width:100px !important;">Terminado</div>
                                            <div class="ribbon-background"></div>
                                        </div>
                                    <% } else { %>
                                        <div class="ribbon sale" style="color:red;">
                                            <div class="theribbon" style="width:100px !important;">Cancelado</div>
                                            <div class="ribbon-background"></div>
                                        </div>
                                    <% } %>

                            </div>
                            <div class="col-sm-6">
                                <div class="box">
                                            <h3>Entradas</h3>

                                            <form class="text-center" action="addbasket" action="POST">
											  <p>Comprar entradas:</p>
											     <p class="price"><%= evento.getPrecioEntrada() %> <i class="fa fa-eur" aria-hidden="true"></i></p>
                                              <% if(user_shop == null) { %>
                                                 <p class="text-center text-muted"><a href="registro"><strong>Inicia sesión</strong></a> para poder comprar entradas</p>
                                              <% } else { %>
                                              	 <% if(user_shop.getTipo().equals("comprador")) { %>
	                                                <label for="entradas">Número de entradas</label>
	                                                <input type="number" name="entradas" min="1" max="10" value="1">
	                                                <input type="hidden" name="id" value="<%= evento.getId() %>">
	                                                <input type="hidden" name="precio_entradas" value="<%= evento.getPrecioEntrada() %>">
	                                                <button type="submit" class="btn btn-template-main"><i class="fa fa-shopping-cart"></i> Añadir al carrito</button>
                                              	 <% } %>
                                              <% } %>
    											  
											</form>
                                </div>

                            </div>

                        </div>


                        <div class="box" id="details">
                            <p>
                                <h4>Descripción del evento</h4>
                                <p><%= evento.getDescripcion() %></p>
                                
                        </div>

                        <div class="box social" id="product-social">
                            <h4>Compartir</h4>
                            <p>
                                <a href="#" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                <a href="#" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                                <a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
                                <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                            </p>
                        </div>

                    </div>
                    <!-- /.col-md-9 -->


                    <!-- *** LEFT COLUMN END *** -->


                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>