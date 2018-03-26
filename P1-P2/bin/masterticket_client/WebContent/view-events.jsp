<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.*" %>
<%@page import="java.util.List,java.util.ArrayList" %>
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
		<% String categoria = (String)request.getAttribute("categoria"); %>
		<% String categoria_url = (String)request.getAttribute("categoria_url"); %>
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1><%= categoria %></h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li><%= categoria %></li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <div id="content">
            <div class="container">
                <p class="text-muted lead text-center">¡Los mejores <%= categoria.toLowerCase() %> de tu ciudad!</p>

                

                <div class="clearfix" id="search-event">

                        <div class="box clearfix">
                            <div class="heading">
                                <h3 class="text-uppercase">Filtrar <%= categoria.toLowerCase() %></h3>
                            </div>

                            <form action="filterevents?categoria=<%=categoria_url%>" method="GET" accept-charset="utf-8" id="form-filtrar">
                                <div class="form-group">
                                    <label for="name">Título</label>
                                    <input name="titulo" type="text" class="form-control" id="name">
                                </div>
                                <div class="form-group">
                                    <label for="lugar">Localización</label>
                                    <input name="lugar" type="text" class="form-control" id="lugar">
                                </div>
                                <div class="form-group">
                                    <label for="estado">Estado</label>
                                    <select class="form-control" id="type" name="estado">
                                        <option value="disponible">Disponible</option>
                                        <option value="completo">Completo</option>
                                        <option value="terminado">Terminado</option>
                                        <option value="cancelado">Cancelado</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="fecha">Fecha del evento</label>
                                    <input name="fecha" type="date" class="form-control" id="fecha">
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main" onclick="filtrar()"><i class="fa fa-search"></i> Buscar</button>
                                </div>
                            </form>

                        </div>
                    </div>

                <div class="row products" id="zona_eventos">

                    <% ArrayList<Evento> eventos = (ArrayList<Evento>) request.getAttribute("eventos"); %>

                    <% if (eventos.isEmpty()) { %>
                            <p class="text-muted lead text-center">No hay eventos registrados con estos datos</p>
                    <% } else { %>
                        <% for(Evento viewevent : eventos) { %>
                            <div class="col-md-3 col-sm-4">
                                <div class="product">
                                    <div class="image">
                                    <% byte[] b_foto = viewevent.getFoto().getBytes(); %>
                                        <a href="viewevent?id=<%= viewevent.getId()%>">
                                            <img alt="" class="img-responsive image1" src="visualizarImagen?id=<%= viewevent.getId() %>">
                                        </a>
                                    </div>
                                    <!-- /.image -->
                                    <div class="text">
                                    
                                    
                                        <h3><a href="viewevent?id=<%= viewevent.getId()%>"><%= viewevent.getTitulo() %></a></h3>
                                        <p class="price"><%= viewevent.getPrecioEntradas() %> <i class="fa fa-eur" aria-hidden="true"></i></p>
                                        <p class="buttons">
                                            <a href="viewevent?id=<%= viewevent.getId()%>" class="btn btn-default">Ver evento</a>
                                            <a href="addbasket?id=<%= viewevent.getId()%>" class="btn btn-template-main"><i class="fa fa-shopping-cart"></i>Añadir al carrito</a>
                                        </p>
                                    </div>
                                    <!-- /.text -->

                                    <% if(viewevent.getEstado().equals("disponible")) { %>
                                        <div class="ribbon new">
                                            <div class="theribbon" style="width:100px !important;">Disponible</div>
                                            <div class="ribbon-background"></div>
                                        </div>
                                    <% } else if(viewevent.getEstado().equals("completo")) { %>
                                        <div class="ribbon sale" style="color:yellow;">
                                            <div class="theribbon" style="width:100px !important;">Completo</div>
                                            <div class="ribbon-background"></div>
                                        </div>
                                    <% } else if(viewevent.getEstado().equals("terminado")) { %>
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
                                <!-- /.product -->
                            </div>
                        <% } %>
                    <% } %>

                </div>

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

<script>
    function filtrar(){
        var form = $('#form-filtrar');
        $.ajax({
                data:  form.serialize(),
                url:   form.attr('action'),
                type:  'get',
                beforeSend: function () {
                    $("#zona_eventos").html('<div id="ajax_loader" style="text-align:center;height:350px;padding-top:80px;"><p><b>Cargando</b></p><br/><img src="img/Spinner.gif" style="margin:0 auto;"/></div>');
                },
                success:  function (response) {
                    $("#zona_eventos").html(response);
                },
                error:  function(request, settings)
                {
                    $("#zona_eventos").html("<p>Se ha producido un error</p>");
                }
        });
    }
    
    $("#form-filtrar").submit(function(e){
        return false;
    });
</script>

<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>