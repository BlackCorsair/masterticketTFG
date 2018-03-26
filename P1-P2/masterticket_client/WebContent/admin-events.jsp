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
                            <li>Gestión de eventos
                            </li>
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

                  <% ArrayList<Evento> eventos = (ArrayList<Evento>) request.getAttribute("eventos"); %>
                  
                    <div class="col-md-9 clearfix" id="customer-order">
                    
                    	<a href="addevent">
	                      <button type="button" class="btn btn-xs btn-template-main"><i class="fa fa-plus" aria-hidden="true"></i> Nuevo evento</button>
	                    </a>

                      <br>
                      <br>
                    
                        <input type="text" id="myInput" onkeyup="filterusers()" placeholder="Buscar por título..">

                        <table id="tabevents">
                          <tr class="header">
                            <th style="width:10%;">Título</th>
                            <th style="width:20%;">Categoría</th>
                            <th style="width:30%;">Estado</th>
                            <th style="width:10%;">Fecha</th>
                            <th style="width:30%;">Lugar</th>
                            <th style="width:30%;">Opciones</th>
                          </tr>
                          <% if (eventos.isEmpty()) { %>
                            <tr>
                              <td colspan="6">No hay eventos registrados en el sistema</td>
                            </tr>
                          <% } else { %>
                            <% for(Evento viewevent : eventos) { %>
                              <tr>
                                <td style="width:10%;"><%= viewevent.getTitulo() %></td>
                                <td style="width:20%;"><%= viewevent.getCategoria() %></td>
                                  <% if(viewevent.getEstado().compareTo("disponible") == 0){ %>
                                    <td style="width:30%;">
                                      <div style="background-color:#228b22 !important;border-color: white !important;color:white;" class="btn btn-xs btn-template-main">
                                        <i class="fa fa-check" style="color:white;" aria-hidden="true"></i> Disponible
                                      </div>
                                    </td>
                                  <% } else if(viewevent.getEstado().compareTo("completo") == 0) { %>
                                    <td style="width:30%;">
                                      <div style="background-color:#e6e600 !important;border-color: white !important;color:white;" class="btn btn-xs btn-template-main">
                                        <i class="fa fa fa-users" style="color:white;" aria-hidden="true"></i> Completo
                                      </div>
                                    </td>
                                  <% } else if(viewevent.getEstado().compareTo("terminado") == 0) { %>
                                    <td style="width:30%;">
                                      <div style="background-color:#1e90ff !important;border-color: white !important;color:white;" class="btn btn-xs btn-template-main">
                                        <i class="fa fa fa-calendar-o" style="color:white;" aria-hidden="true"></i> Terminado
                                      </div>
                                    </td>
                                  <% } else { %>
                                    <td style="width:30%;">
                                      <div style="background-color:#e60000 !important;border-color: white !important;color:white;" class="btn btn-xs btn-template-main">
                                        <i class="fa fa fa-ban" style="color:white;" aria-hidden="true"></i> Cancelado
                                      </div>
                                    </td>
                                  <% } %>

                                <%
                                  java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
                                  String date = df.format(viewevent.getFecha());
    
                                %>
                                <td style="width:10%;"><%= date %></td>
                                <td style="width:30%;"><%= viewevent.getLugar() %></td>
                                <td style="width:30%;">
                                  <a href="editevent?id=<%= viewevent.getId() %>">
                                    <button type="button" class="btn btn-xs btn-template-main" style="margin-right:5px;"><i class="fa fa-pencil" aria-hidden="true"></i> Editar</button>
                                  </a>
                                  <a href="deleteevent?id=<%= viewevent.getId() %>">
                                    <button type="button" class="btn btn-xs btn-template-main"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                                  </a>
                                </td>
                              </tr>
                            <% } %>
                          <% } %>
                          
                        </table> 
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