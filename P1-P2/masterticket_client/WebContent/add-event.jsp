<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.*" %>
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


<style type="text/css">
    #myInput {
        background-image: url('/css/searchicon.png'); /* Add a search icon to input */
        background-position: 10px 12px; /* Position the search icon */
        background-repeat: no-repeat; /* Do not repeat the icon image */
        width: 100%; /* Full-width */
        font-size: 16px; /* Increase font-size */
        padding: 12px 20px 12px 40px; /* Add some padding */
        border: 1px solid #ddd; /* Add a grey border */
        margin-bottom: 12px; /* Add some space below the input */
    }

    #tabevents {
        border-collapse: collapse; /* Collapse borders */
        width: 100%; /* Full-width */
        border: 1px solid #ddd; /* Add a grey border */
        font-size: 18px; /* Increase font-size */
        margin-bottom:50px;
    }

    #tabevents th, #tabevents td {
        text-align: left; /* Left-align text */
        padding: 12px; /* Add padding */
    }

    #tabevents tr {
        /* Add a bottom border to all table rows */
        border-bottom: 1px solid #ddd;
    }

    #tabevents tr.header, #tabevents tr:hover {
        /* Add a grey background color to the table header and on hover */
        background-color: #f1f1f1;
    }

</style>

        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Gestión de eventos</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li><a href="eventsdashboard">Gestión de eventos</a>
                            </li>
                            <li>Crear evento
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div id="content">
            <div class="container">

               <div class="col-md-9 clearfix" id="customer-order">
                        <div class="box">
                            <h2 class="text-uppercase">Crear evento</h2>

                            <p class="lead">Datos básicos para crear un nuevo evento</p>
                            <p>Acuérdate de proveer los datos necesarios de localización y descripción</p>
                            <p class="text-muted">Si tienes alguna duda, <a href="contact.jsp">contáctanos</a>, nuestro servicio técnico está disponible las 24 horas.</p>

                            <hr>

                            <!-- <form action="addevent" method="post" enctype="application/x-www-form-urlencoded">-->
                            <form action="addevent" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="titulo-event">Título</label>
                                    <input name="titulo" type="text" class="form-control" id="titulo-event">
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
                                    <label for="categoria">Categoría</label>
                                    <select class="form-control" id="type" name="categoria">
                                        <option value="concierto">Concierto</option>
                                        <option value="festival">Festival</option>
                                        <option value="musical">Musical</option>
                                        <option value="teatro">Teatro</option>
                                        <option value="monólogo">Monólogo</option>
                                        <option value="ballet">Ballet</option>
                                        <option value="ópera">Ópera</option>
                                        <option value="turismo">Turismo</option>
                                        <option value="museo">Museo</option>
                                        <option value="profesional">Profesional</option>
                                        <option value="deportivo">Deportivo</option>
                                        <option value="curso">Curso</option>
                                        <option value="circo">Circo</option>
                                    </select>
                                </div>
                                <div class="form-group">
	                  	        	<label for="foto">Fotografía del evento</label>
	                       			<input name="foto" id="imagen" type=file accept=".jpg, .jpeg, .png">                                 
                                </div>                          
                                <div class="form-group">
                                    <label for="precio_entrada">Precio de una entrada</label>
                                    <input name="precio_entrada" type="text" class="form-control" id="precio_entrada">
                                </div>
                                <div class="form-group">
                                    <label for="fecha">Fecha del evento</label>
                                    <input name="fecha" type="datetime-local" class="form-control" id="fecha">
                                </div>
                                <div class="form-group">
                                    <label for="lugar">Lugar</label>
                                    <input name="lugar" type="text" class="form-control" id="lugar">
                                </div>
                                <div class="form-group">
                                    <label for="descripcion">Descripción</label>
                                    <input name="descripcion" type="text" class="form-control" id="descripcion">
                                </div>
                                <div class="form-group">
                                    <label for="numero_entradas">Número de entradas disponibles</label>
                                    <input name="numero_entradas" type="text" class="form-control" id="numero_entradas">
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main" value="save"><i class="fa fa-plus-circle"></i> Crear evento</button>
                                </div>
                            </form>
                        </div>

                        <a href="eventsdashboard">
                           <button type="button" class="btn btn-xs btn-template-main"><i class="fa fa-angle-left" aria-hidden="true"></i> Volver a Gestión de Eventos</button>
                        </a>
                        <br>
                        <br>
                    </div>

                    

                    <!-- *** LEFT COLUMN END *** -->

                    <%@ include file="/layouts/menu.jsp" %>

                </div>
                <!-- /.row -->


            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

<script>
function filterusers() {
  // Declare variables
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("tabevents");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>

<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>