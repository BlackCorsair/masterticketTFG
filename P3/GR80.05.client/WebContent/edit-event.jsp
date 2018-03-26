<%@page import="masterticket.auxiliar.DateFormatter"%>
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
                            <li>Modificar evento
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div id="content">
            <div class="container">
            
            <% Evento modifiedEvent = (Evento) session.getAttribute("modifiedEvent");%>
            
               <div class="col-md-9 clearfix" id="customer-order">
                        <div class="box">
                            <h2 class="text-uppercase">Modificar evento</h2>
                            <hr>
                                                   
                            <!-- <form action="editevent" method="post" enctype="application/x-www-form-urlencoded"> -->
                            <form action="editevent" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="titulo-event">Título del evento</label>
                                    <input name="titulo" value="<%=modifiedEvent.getTitulo()%>" class="form-control" id="titulo-event">
                                </div>
                                <div class="form-group">
									<label for="estado">Estado</label>
                                    <select class="form-control" id="type" name="estado">
                                    <%if(modifiedEvent.getEstado() == "disponible"){%>
	                              	    <option value="disponible" selected>Disponible</option>
	                              	    <option value="completo">Completo</option>
	                              	    <option value="terminado">Terminado</option>
	                              	    <option value="cancelado">Cancelado</option>
                              	    <%}else{ 
                              	    	if(modifiedEvent.getEstado() == "completo"){%>
	                              	    	<option value="disponible">Disponible</option>
	                              	    	<option value="completo" selected>Completo</option>
	                              	    	<option value="terminado">Terminado</option>
	                              	    	<option value="cancelado">Cancelado</option>
                              		    <%}else{
                              		    	if(modifiedEvent.getEstado() == "terminado"){%>
    	                              	    	<option value="disponible">Disponible</option>
    	                              	    	<option value="completo">Completo</option>
    	                              	    	<option value="terminado" selected>Terminado</option>
    	                              	    	<option value="cancelado">Cancelado</option>
                                  	    	<%}else{%>
                              		    		<option value="disponible">Disponible</option>
    	                              	    	<option value="completo">Completo</option>
    	                              	    	<option value="terminado">Terminado</option>
    	                              	    	<option value="cancelado" selected>Cancelado</option>
    		                         	   <%}
    		                         	}
    		                        }%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="categoria">Categoría</label>
                                    <select class="form-control" id="type" name="categoria">
                                        <option value="concierto" <%if(modifiedEvent.getCategoria() == "concierto"){ %>selected<%}%>>Concierto</option>
                                        <option value="festival" <%if(modifiedEvent.getCategoria() == "festival"){ %>selected<%}%>>Festival</option>
                                        <option value="musical" <%if(modifiedEvent.getCategoria() == "musical"){ %>selected<%}%>>Musical</option>
                                        <option value="teatro" <%if(modifiedEvent.getCategoria() == "teatro"){ %>selected<%}%>>Teatro</option>
                                        <option value="monólogo" <%if(modifiedEvent.getCategoria() == "monólogo"){ %>selected<%}%>>Monólogo</option>
                                        <option value="ballet" <%if(modifiedEvent.getCategoria() == "ballet"){ %>selected<%}%>>Ballet</option>
                                        <option value="ópera" <%if(modifiedEvent.getCategoria() == "ópera"){ %>selected<%}%>>Ópera</option>
                                        <option value="turismo" <%if(modifiedEvent.getCategoria() == "turismo"){ %>selected<%}%>>Turismo</option>
                                        <option value="museo" <%if(modifiedEvent.getCategoria() == "museo"){ %>selected<%}%>>Museo</option>
                                        <option value="profesional" <%if(modifiedEvent.getCategoria() == "profesional"){ %>selected<%}%>>Profesional</option>
                                        <option value="deportivo" <%if(modifiedEvent.getCategoria() == "deportivo"){ %>selected<%}%>>Deportivo</option>
                                        <option value="curso" <%if(modifiedEvent.getCategoria() == "curso"){ %>selected<%}%>>Curso</option>
                                        <option value="circo" <%if(modifiedEvent.getCategoria() == "circo"){ %>selected<%}%>>Circo</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="foto">Fotografía del evento</label>
                                    <input name="foto" id="imagen" type=file accept=".jpg, .jpeg, .png">
                                </div>
                                <div class="form-group">
                                    <label for="precio_entrada">Precio de una entrada</label>
                                    <input name="precio_entrada" value="<%=modifiedEvent.getPrecioEntrada()%>" type="text" class="form-control" id="precio_entrada">
                                </div>
                                <div class="form-group">
                                    <label for="fecha">Fecha del evento</label>
                                    <%String fechaDTLocal = (DateFormatter.DBDateToDTLocal(modifiedEvent.getFecha()));%>
                                    <input name="fecha" value="<%=fechaDTLocal%>" type="datetime-local" class="form-control" id="fecha">
                                </div>
                                <div class="form-group">
                                    <label for="lugar">Lugar</label>
                                    <input name="lugar" value="<%=modifiedEvent.getPrecioEntrada()%>" type="text" class="form-control" id="lugar">
                                </div>
                                <div class="form-group">
                                    <label for="descripcion">Descripción</label>
                                    <input name="descripcion" value="<%=modifiedEvent.getDescripcion()%>" type="text" class="form-control" id="descripcion">
                                </div>
                                <div class="form-group">
                                    <label for="numero_entradas">Número de entradas disponibles</label>                                  
                                    <input name="numero_entradas" value="<%=modifiedEvent.getNumeroEntradas()%>" type="text" class="form-control" id="numero_entradas">
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-template-main"><i class="fa fa-plus-circle"></i> Modificar evento</button>
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