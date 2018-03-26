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
<% Usuario ususesion = (Usuario)session.getAttribute("User"); %>
<% ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios"); %>
        <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>Mensajería con usuarios</h1>
                    </div>
                    <div class="col-md-6">
                        <ul class="breadcrumb">

                            <li><a href="index.jsp">Inicio</a>
                            </li>
                            <li>Mensajería con usuarios</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div id="content" class="clearfix">

            <div class="container">

                <div class="row">

                    <!-- *** LEFT COLUMN ***
			 _________________________________________________________ -->

                    <div class="col-md-9 clearfix" id="customer-account">

                        <p class="lead">Puede comunicarse con los usuarios del sistema.</p>

                        <table id="tabusers">
                          <tr class="header">
                            <th style="width:10%;">Nombre</th>
                            <th style="width:20%;">Apellidos</th>
                            <th style="width:10%;">Tipo</th>
                            <th style="width:30%;">E-mail</th>
                            <th style="width:30%;">Opciones</th>
                          </tr>
                          <% if (usuarios.isEmpty()) { %>
                            <tr>
                              <td colspan="5">No hay usuarios registrados en el sistema</td>
                            </tr>
                          <% } else { %>
                            <% for(Usuario viewuser : usuarios) { %>
                              <tr>
                                <td style="width:10%;"><%= viewuser.getNombre() %></td>
                                <td style="width:20%;"><%= viewuser.getApellidos() %></td>
                                  <% if(viewuser.getTipo().compareTo("admin") == 0){ %>
                                    <td style="width:10%;">Administrador</td>
                                  <% } else { %>
                                    <td style="width:10%;">Cliente</td>
                                  <% } %>
                                <td style="width:30%;"><%= viewuser.getEmail() %></td>
                                <td style="width:30%;">
                                  <a href="messages?id=<%= viewuser.getId() %>">
                                    <button type="button" class="btn btn-xs btn-template-main" style="margin-right:5px;"><i class="fa fa-comment" aria-hidden="true"></i> Enviar mensaje</button>
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
