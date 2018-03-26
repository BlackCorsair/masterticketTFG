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

    #tabusers {
        border-collapse: collapse; /* Collapse borders */
        width: 100%; /* Full-width */
        border: 1px solid #ddd; /* Add a grey border */
        font-size: 18px; /* Increase font-size */
        margin-bottom:50px;
    }

    #tabusers th, #tabusers td {
        text-align: left; /* Left-align text */
        padding: 12px; /* Add padding */
    }

    #tabusers tr {
        /* Add a bottom border to all table rows */
        border-bottom: 1px solid #ddd;
    }

    #tabusers tr.header, #tabusers tr:hover {
        /* Add a grey background color to the table header and on hover */
        background-color: #f1f1f1;
    }

</style>
		
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Gestión de usuarios</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li>Gestión de usuarios
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

                  <% ArrayList<String> mensajesRecibidos = (ArrayList<String>) request.getAttribute("mensajesRecibidos"); %>
                  
                  	

                    <div class="col-md-9 clearfix" id="customer-order">
                    
                         <input type="text" id="myInput" onkeyup="filterusers()" placeholder="Buscar por nombre..">

                        <table id="tabusers">
                          <tr class="header">
                            <th style="width:100%;">Mensaje recibido</th>
                          </tr>
                          <% if (mensajesRecibidos.isEmpty()) { %>
                            <tr>
                              <td>No hay ningún mensaje</td>
                            </tr>
                          <% } else { %>
                            <% for(String mensaje : mensajesRecibidos) { %>
                              <tr>
                                <td style="width:10%;"><%= mensaje %></td>
                              </tr>
                            <% } %>
                          <% } %>
                          
                        </table> 
                        
                        <a href="comunications.jsp">
                           <button type="button" class="btn btn-xs btn-template-main"><i class="fa fa-angle-left" aria-hidden="true"></i> Volver a la mensajería</button>
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

<script>
function filterusers() {
  // Declare variables
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("tabusers");
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