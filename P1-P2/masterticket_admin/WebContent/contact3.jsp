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
                        <h1>Nuestra filosofía</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.html">Contacto</a>
                            </li>
                            <li>Nuestra filosofía</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <div id="content">
            <div class="container">

                <section>
                    <div class="row">
                        <div class="col-md-12">

                            <div class="heading">
                                <h2>Enfoque</h2>
                            </div>

                            <p class="lead">Es el momento de...</p>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-8">
                            <div class="panel-group accordion" id="accordionThree">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">

                                                <a data-toggle="collapse" data-parent="#accordionThree" href="#collapse3a">

                                                  Disfrutar!

                                                </a>

                                            </h4>
                                    </div>
                                    <div id="collapse3a" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <img src="img/disfrutar.png" alt="" class="img-responsive">
                                                </div>
                                                <div class="col-md-8">
                                                    <p>No esperes tenerlo todo en la vida para disfrutar, elige el momento, la compañía y nosotros te ponemos el contexto, a ti sólo te queda disfrutarlo !</p>
                                                 
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">

                                                <a data-toggle="collapse" data-parent="#accordionThree" href="#collapse3b">

                                                    Vivir!
                                                </a>

                                            </h4>
                                    </div>
                                    <div id="collapse3b" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <img src="img/vivir.png" alt="" class="img-responsive">
                                                </div>
                                                <div class="col-md-8">
                                                    <p>Qué es la vida sino momentos, recuerdos de lo que hiciste y quedó grabado. Esta no es más que otra oportunidad para grabar un momento más en tu vida, haciendo lo que más te guste, con quien te guste, cuando te guste.</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">

                                                <a data-toggle="collapse" data-parent="#accordionThree" href="#collapse3c">

                                                   Experimentar!

                                                </a>

                                            </h4>
                                    </div>
                                    <div id="collapse3c" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <p>Si eres una de esas personas que no se deciden por una cosa o la otra, siempre tendrás nuestras ideas para asistir a experiencias nuevas para ti y abrir nuevos horizontes en tu abanico de oportunidades, vive algo diferente, déjate llevar! </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="video">
                                <div class="embed-responsive embed-responsive-4by3">
                                    <iframe class="embed-responsive-item" src="https://www.youtube.com/watch?v=jpv2tMJJuz0&t=1009s"></iframe>
                                </div>

                            </div>
                        </div>
                    </div>
                </section>
                <section>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="heading">
                                <h2>Ofrecemos...</h2>
                            </div>

                            <div class="progress">
                                <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                                    Variedad de eventos
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
                                    En variedad de sitios
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                    siempre acertamos!
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="heading">
                                <h2>Nos importa</h2>
                            </div>
                            <ul class="ul-icons">
                                <li><i class="fa fa-check"></i>Que cada experiencia con nosotros sea única.</li>
                                <li><i class="fa fa-check"></i>Que cuando acudas a nosotros te encuentres como en casa.</li>
                                <li><i class="fa fa-check"></i>Que siempre te vayas contento con lo que has vivido.</li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <div class="heading">
                                <h2>Sólo te queda...</h2>
                            </div>

                            <ul class="ul-icons">
                                <li><i class="fa fa-check"></i>Buscar.</li>
                                <li><i class="fa fa-check"></i>Elegir.</li>
                                <li><i class="fa fa-check"></i>Disfrutar!</li>
                            </ul>
                        </div>
                    </div>
                </section>

            </div>
            <!-- /#contact.container -->

            <section class="bar background-pentagon">
                <div class="container">
                    <div class="row showcase">
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-play-circle-o"></i>
                                </div>
                                <h4><span class="counter">580</span><br>

        Festivales</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-futbol-o"></i>
                                </div>
                                <h4><span class="counter">213</span><br>

        Deportes</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-graduation-cap"></i>
                                </div>
                                <h4><span class="counter">165</span><br>

        Cursos</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-glass"></i>
                                </div>
                                <h4><span class="counter">321</span><br>

        Monólogos</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-plane"></i>
                                </div>
                                <h4><span class="counter">109</span><br>

        Turismo</h4>
                            </div>
                        </div>
                   
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-copy"></i>
                                </div>
                                <h4><span class="counter">101</span><br>

        Eventos profesionales</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-headphones"></i>
                                </div>
                                <h4><span class="counter">121</span><br>

        Musicales</h4>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="item">
                                <div class="icon"><i class="fa fa-users"></i>
                                </div>
                                <h4><span class="counter">923</span><br> 

        Conciertos</h4>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container -->
            </section>
            <!-- /.bar -->

            

            

           

        </div>
        <!-- /#content -->




        <!-- *** FOOTER ***
_________________________________________________________ -->


        <footer id="footer">
            <div class="container">
                <div class="col-md-3 col-sm-6">
                    <h4>Sobre nosotros</h4>

                    <p>Forma parte del grupo que más eventos ofrece y conoce a gente en tu zona.</p>

                    <hr>

                    <h4>¡Únete a nuestra NewsLetter!</h4>

                    <form>
                        <div class="input-group">

                            <input type="text" class="form-control">

                            <span class="input-group-btn">

                        <button class="btn btn-default" type="button"><i class="fa fa-send"></i></button>

                    </span>

                        </div>
                        <!-- /input-group -->
                    </form>

                    <hr class="hidden-md hidden-lg hidden-sm">

                </div>
                <!-- /.col-md-3 -->

                <div class="col-md-3 col-sm-6">

                    <h4></h4>


                    <hr class="hidden-md hidden-lg">

                </div>
                <!-- /.col-md-3 -->

                <div class="col-md-3 col-sm-6">

                    <h4>Contacto</h4>

                    <p><strong>MasterTicket.</strong>
                        <br>Av. de Gregorio Peces-Barba Martínez, 22
                        <br>28270 Colmenarejo
                        <br>Madrid
                        <br>
                        <strong>ESPAÑA</strong>
                    </p>

                    <a href="contact.html" class="btn btn-small btn-template-main">Ir a contacto</a>

                    <hr class="hidden-md hidden-lg hidden-sm">

                </div>
                <!-- /.col-md-3 -->




                <!-- /.col-md-3 -->
            </div>
            <!-- /.container -->
        </footer>
        <!-- /#footer -->

<!-- *** FOOTER END *** -->

<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>