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
<link href="css/custom_event_creator.css" rel="stylesheet">

 <div id="heading-breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <h1>Gestión de Eventos</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.html">Inicio</a>
                            </li>
                            <li>Gestión de eventos</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <section>
            <div class="container">

                <div class="row">
                   
                    <div class="col-md-9 col-md-offset-3">

                        <!-- Crear / Modificar Evento -->
                        <h3 class="section-title">Crear / Modificar Evento</h3> 
                        <div class="row">
                            <div class="col-md-9">
                                <div class="tabs menu_gestion">
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a href="#tab4-crear" data-toggle="tab"><i class="icon-star"></i>Crear</a>
                                        </li>
                                        <li class=""><a href="#tab4-modificar" data-toggle="tab">Modificar</a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane active menu_crear_evento" id="tab4-crear">
                                           <h3 class="col-md-12">Crear Evento</h3>
                                            <div class="contenido-gestion" id="crear">
                                                <!--TODO: Hacer servlets-->
                                                
                                                <form method="post" action="EventCreatorServlet">                                                     
                                                    <div class="col-md-12 opcion_creador">
                                                        <div class="col-md-4">
                                                            <h4>Título del evento</h4>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <input name="titulo" value="" maxlength="50" size="30" autofocus="autofocus">
                                                        </div>
                                                    </div>
                                                     <div class="col-md-12 opcion_creador">
                                                        <div class="col-md-4">
                                                            <h4>Categoría</h4>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <select name="categoria">
                                                                <option value="indefinido" selected>Elija una categoría</option> 
                                                                <option value="conciertos">Conciertos</option>
                                                                <option value="festivales">Festivales</option>
                                                                <option value="teatro">Teatro</option>
                                                                <option value="monologos">Monólogos</option>
                                                                <option value="ballet">Ballet</option>
                                                                <option value="opera">Ópera</option>
                                                                <option value="exposiciones y museos">Exposiciones y Museos</option>
                                                                <option value="eventos profesionales">Eventos Profesionales</option>
                                                                <option value="cursos">Cursos</option>
                                                                <option value="circo">Circo</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-12 opcion_creador">
                                                        <div class="col-md-4">
                                                            <h4>Adjuntar imagen</h4>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <input name="imagen" id="imagen" type=file accept=".jpg, .jpeg, .png">
                                                        </div>
                                                    </div>
                                                     <div class="col-md-12 opcion_creador">
                                                        <div class="col-md-4">
                                                            <h4>Precio</h4>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <input name="precio" value="" maxlength="5" size="5"><span> €</span>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-12 opcion_creador">
                                                        <div class="col-md-4" id="parametro_fecha">
                                                            <h4>Fecha</h4>
                                                        </div>
                                                        <div class="col-md-6" id="parametro_fecha">
                                                            <input name="fecha" id="fecha" type="datetime-local" size="20">
                                                        </div>
                                                    </div>
                                                     <div class="col-md-12 opcion_creador">
                                                        <div class="col-md-4">
                                                            <h4>Lugar</h4>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <input name="lugar" value="" maxlength="500" size="30">
                                                        </div>
                                                    </div>
                                                     <div class="col-md-12 opcion_creador" id="opcion_descripcion">
                                                        <div class="col-md-4" id="opcion_descripcion">
                                                            <h4>Descripción</h4>
                                                        </div>
                                                        <div class="col-md-6" id="parametro_descripcion">
                                                            <!-- <input name="descripcion" value="" maxlength="500" size="30"> -->
                                                            <textarea name="descripcion" value="" rows="3" cols="30">
                                                            </textarea>
                                                        </div>
                                                    </div>
                                                     <div class="col-md-12 opcion_creador">
                                                        <div class="col-md-4">
                                                            <h4>Nº de entradas</h4>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <input name="entradas" value="" maxlength="10" size="10">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-9 col-md-offset-2" id="botones_creacion">
                                                        <input type=submit value="Crear Evento" class="btn btn-template-main">
                                                        <input type=reset value="Vaciar los campos" class="btn btn-template-main">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="tab-pane  menu_modificar_evento" id="tab4-modificar">
                                            <h3 class="col-md-12">Modificar evento</h3>
                                            <div class="contenido-gestion" id="modificar">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.tab-content -->
                                </div>
                                <!-- /.tabs -->
                            </div>
                            <!-- /.col-md-6 -->
                        </div>
                        <!-- /.row -->
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </section>

<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>