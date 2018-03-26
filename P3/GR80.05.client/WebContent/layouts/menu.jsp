<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="masterticket.models.*" %>
<% Usuario user2 = (Usuario)session.getAttribute("User"); %>


<!-- *** RIGHT COLUMN ***
			 _________________________________________________________ -->

                    <div class="col-md-3">
                        <!-- *** CUSTOMER MENU ***
 _________________________________________________________ -->
                        <div class="panel panel-default sidebar-menu">

                            <div class="panel-heading">
                                <h3 class="panel-title">Opciones</h3>
                            </div>
                            <% 
                            String uri = request.getRequestURI();
                            String pageName = uri.substring(uri.lastIndexOf("/")+1); 
                            %>
                            
                            <% if(user2.getTipo().equals("admin")){ %>  

                                <div class="panel-body">

                                    <ul class="nav nav-pills nav-stacked">

                                        <% if(pageName.equals("admin-users.jsp") || pageName.equals("edit-user.jsp")){ %>  
                                            <li class="active">
                                                <a href="dashboard"><i class="fa fa-users"></i> Gestión de usuarios</a>
                                            </li>
                                        <% } else { %>
                                            <li>
                                                <a href="dashboard"><i class="fa fa-users"></i> Gestión de usuarios</a>
                                            </li>
                                        <% } %>
                                        <% if(pageName.equals("admin-events.jsp") || pageName.equals("add-event.jsp")){ %>  
                                            <li class="active">
                                                <a href="eventsdashboard"><i class="fa fa-calendar"></i> Gestión de eventos</a>
                                            </li>
                                        <% } else { %>
                                            <li>
                                                <a href="eventsdashboard"><i class="fa fa-calendar"></i> Gestión de eventos</a>
                                            </li>
                                        <% } %>
                                        <% if(pageName.equals("customer-account.jsp")){ %>  
                                            <li class="active">
                                                <a href="editaccount?id=<%= user2.getId() %>"><i class="fa fa-user"></i> Mi cuenta</a>
                                            </li>
                                        <% } else { %>
                                            <li>
                                                <a href="editaccount?id=<%= user2.getId() %>"><i class="fa fa-user"></i> Mi cuenta</a>
                                            </li>
                                        <% } %>
                                        <% if(pageName.equals("comunications.jsp") || pageName.equals("viewcomunications.jsp") || pageName.equals("messages.jsp")){ %>  
                                             <li class="active">
                                                <a href="comunications"><i class="fa fa-comments-o"></i> Mensajes</a>
                                            </li>
                                        <% } else { %>
                                             <li>
                                                <a href="comunications"><i class="fa fa-comments-o"></i> Mensajes</a>
                                            </li>
                                        <% } %>
                                        <li>
                                            <a href="logout"><i class="fa fa-sign-out"></i> Logout</a>
                                        </li>
                                    </ul>
                                </div>

                           <% } else { %>

                                <div class="panel-body">

                                    <ul class="nav nav-pills nav-stacked">
                                        <% if(pageName.equals("admin-events.jsp") || pageName.equals("add-event.jsp")){ %>  
                                            <li class="active">
                                                <a href="eventsdashboard"><i class="fa fa-calendar"></i> Gestión de eventos</a>
                                            </li>
                                        <% } else { %>
                                            <li>
                                                <a href="eventsdashboard"><i class="fa fa-calendar"></i> Gestión de eventos</a>
                                            </li>
                                        <% } %>
                                        <% if(pageName.equals("admin-orders.jsp")){ %>  
                                            <li class="active">
                                                <a href="adminorders"><i class="fa fa-list-ol"></i> Pedidos recibidos</a>
                                            </li>
                                        <% } else { %>
                                            <li>
                                                <a href="adminorders"><i class="fa fa-list-ol"></i> Pedidos recibidos</a>
                                            </li>
                                        <% } %>
                                        <% if(pageName.equals("customer-orders.jsp") || pageName.equals("customer-order.jsp")){ %>  
                                            <li class="active">
                                                <a href="myorders"><i class="fa fa-list"></i> Mis pedidos</a>
                                            </li>
                                        <% } else { %>
                                            <li>
                                                <a href="myorders"><i class="fa fa-list"></i> Mis pedidos</a>
                                            </li>
                                        <% } %>
                                        <% if(pageName.equals("customer-account.jsp")){ %>  
                                            <li class="active">
                                                <a href="editaccount?id=<%= user2.getId() %>"><i class="fa fa-user"></i> Mi cuenta</a>
                                            </li>
                                        <% } else { %>
                                            <li>
                                                <a href="editaccount?id=<%= user2.getId() %>"><i class="fa fa-user"></i> Mi cuenta</a>
                                            </li>
                                        <% } %>
                                        <% if(pageName.equals("comunications.jsp") || pageName.equals("viewcomunications.jsp") || pageName.equals("messages.jsp")){ %>  
                                             <li class="active">
                                                <a href="comunications"><i class="fa fa-comments-o"></i> Mensajes</a>
                                            </li>
                                        <% } else { %>
                                             <li>
                                                <a href="comunications"><i class="fa fa-comments-o"></i> Mensajes</a>
                                            </li>
                                        <% } %>
                                        <li>
                                            <a href="logout"><i class="fa fa-sign-out"></i> Logout</a>
                                        </li>
                                    </ul>
                                </div>

                            <% } %>

                        </div>
                        <!-- /.col-md-3 -->

                        <!-- *** CUSTOMER MENU END *** -->
                    </div>

                    <!-- *** RIGHT COLUMN END *** -->