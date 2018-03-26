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
                        <h1>Quienes somos</h1>
                    </div>
                    <div class="col-md-5">
                        <ul class="breadcrumb">
                            <li><a href="index.html">Contacto</a>
                            </li>
                            <li>Quienes somos</li>
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
                                <h2>Te presentamos al equipo de Masterticket</h2>
                            </div>

                            <p class="lead">Seleccionamos a las personas adecuadas para cada puesto fomentando un clima de trabajo en equipo que promueve el diálogo abierto, sin dejar de tener claras las expectativas. Facultamos al equipo de trabajo para la ación y facilitamos los recursos necesarios para llevarlo a cabo. Lo más importante para nuestro equipo es la comunicación porque así es como cumplimos los objetivos propuestos.</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-3 col-sm-3">
                            <div class="team-member" data-animate="fadeInUp">
                                <div class="image">
                                    <a href="team-member.html">
                                        <img src="img/LuisC.png" alt="" class="img-responsive img-circle">
                                    </a>
                                </div>
                                <h3><a href="team-member.html">Luis Cabrero</a></h3>
                                <p class="role">Fundador</p>
                                <div class="social">
                                    <a href="#" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                    <a href="#" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                                    <a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
                                    <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                                </div>
                                <div class="text">
                                    <p>“No pretendas que las cosas cambien si siempre haces lo mismo”</p>
                                </div>
                            </div>
                            <!-- /.team-member -->
                        </div>
                        <div class="col-md-3 col-sm-3" data-animate="fadeInUp">
                            <div class="team-member">
                                <div class="image">
                                    <a href="team-member.html">
                                        <img src="img/Moha.jpg" alt="" class="img-responsive img-circle">
                                    </a>
                                </div>
                                <h3><a href="team-member.html">Moha Zariohi</a></h3>
                                <p class="role">Gerente</p>

                                <div class="social">
                                    <a href="#" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                    <a href="#" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                                    <a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
                                    <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                                </div>
                                <div class="text">
                                    <p>“La jubilación es para los que se pasan la vida trabajando en algo que no les gusta”</p>
                                </div>
                            </div>
                            <!-- /.team-member -->
                        </div>
                        <div class="col-md-3 col-sm-3" data-animate="fadeInUp">
                            <div class="team-member">
                                <div class="image">
                                    <a href="team-member.html">
                                        <img src="img/person-1.jpg" alt="" class="img-responsive img-circle">
                                    </a>
                                </div>
                                <h3><a href="team-member.html">Jorge Hevia</a></h3>
                                <p class="role">Team Leader</p>
                                <div class="social">
                                    <a href="#" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                    <a href="#" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                                    <a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
                                    <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                                </div>
                                <div class="text">
                                    <p>“Un líder sabe qué se debe hacer. Un administrador sólo sabe cómo hacerlo”</p>
                                </div>
                            </div>
                            <!-- /.team-member -->
                        </div>
                        <div class="col-md-3 col-sm-3" data-animate="fadeInUp">
                            <div class="team-member">
                                <div class="image">
                                    <a href="team-member.html">
                                        <img src="img/person-4.jpg" alt="" class="img-responsive img-circle">
                                    </a>
                                </div>
                                <h3><a href="team-member.html">Carlos Dumont</a></h3>
                                <p class="role">Manager</p>
                                <div class="social">
                                    <a href="#" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                    <a href="#" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                                    <a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
                                    <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                                </div>
                                <div class="text">
                                    <p>“El único lugar donde el éxito viene antes que el trabajo es en el diccionario”</p>
                                </div>
                            </div>
                            <!-- /.team-member -->
                        </div>
                    </div>
                    

                </section>

            </div>
            <!-- /.container -->

            <section class="bar background-gray no-mb">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="heading text-center">
                                <h2>Los que nos conocen opinan</h2>
                            </div>

                            <p class="lead">Echa un vistazo a las opiniones que han dejado los clientes con los que trabajamos, la satisfacción de los mismos es la meta del equipo en todo momento</p>


                            <!-- *** TESTIMONIALS CAROUSEL ***
 _________________________________________________________ -->

                            <ul class="owl-carousel testimonials same-height-row">
                            <li class="item">
                                <div class="testimonial same-height-always">
                                    <div class="text">
                                        <p>Estamos acostumbrados a tratar con reventas y masterticket es absolutamente la plataforma definitiva en cuanto a seguridad para evitar las compras masivas de tickets. Su equipo se preocupa por los fans y eso nos hace confiar en ellos para sacar a la venta nuestros packs. El trato siempre ha sido excelente y estoy al corriente de que es una de las plataformas favoritas de nuestros clientes.</p>
                                    </div>
                                    <div class="bottom">
                                        <div class="icon"><i class="fa fa-quote-left"></i>
                                        </div>
                                        <div class="name-picture">
                                            <img class="" alt="" src="img/person-1.jpg">
                                            <h5>John Hash</h5>
                                            <p>Promotor</p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="item">
                                <div class="testimonial same-height-always">
                                    <div class="text">
                                        <p>Masterticket es justo lo que siempre había esperado de una página de venta de entradas. Tengo garantizado el precio justo por la entrada que me gusta y si hay algún problema siempre puedo ponerme en contacto con el staff y me solucionan el problema. Un 10 para ellos.</p>
                                    </div>
                                    <div class="bottom">
                                        <div class="icon"><i class="fa fa-quote-left"></i>
                                        </div>
                                        <div class="name-picture">
                                            <img class="" alt="" src="img/person-3.png">
                                            <h5>Ana Martínez</h5>
                                            <p>Usuario de masterticket</p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="item">
                                <div class="testimonial same-height-always">
                                    <div class="text">
                                        <p>Cuando conocí masterticket creí que no iba a ser posible que una plataforma tan joven fuese capaz de gestionar entradas a tantísimos eventos, desde eventos depotivos hasta la ópera. La verdad es que me sorprendió muchísimo y siempre que tengo que comprar un ticket acudo a masterticket.</p>
                                    </div>
                                    <div class="bottom">
                                        <div class="icon"><i class="fa fa-quote-left"></i>
                                        </div>
                                        <div class="name-picture">
                                            <img class="" alt="" src="img/person-2.jpg">
                                            <h5>Albert Luque</h5>
                                            <p>Usuario de masterticket</p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="item">
                                <div class="testimonial same-height-always">
                                    <div class="text">
                                        <p>He usado masterticket por primera vez para comprar mi entrada de un festival, la verdad es que no lo conocía pero ahora no pienso comprar en otro. No solo vale para efectuar la compra, sino que si no sabesqué eventos hay cerca de ti también te vale para inspirarte.</p>
                                    </div>

                                    <div class="bottom">
                                        <div class="icon"><i class="fa fa-quote-left"></i>
                                        </div>
                                        <div class="name-picture">
                                            <img class="" alt="" src="img/person-4.jpg">
                                            <h5>Moha Z</h5>
                                            <p>Estudiante</p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="item">
                                <div class="testimonial same-height-always">
                                    <div class="text">
                                        <p>Para mi lo más importante de cualquier servicio es la atención al cliente, tras tener unas dudas sobre un evento llamé al equipo de atención al cliente y me aclararon todas las dudas en una sola  llamada, he quedado muy satifecha. Por eso recomiendo esta página a todos los que le dan importancia al servicio de atención al cliente.</p>
                                    </div>

                                    <div class="bottom">
                                        <div class="icon"><i class="fa fa-quote-left"></i>
                                        </div>
                                        <div class="name-picture">
                                            <img class="" alt="" src="img/person-3.png">
                                            <h5>Sara Hernandez</h5>
                                            <p>Usuario de masterticket</p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                            <!-- /.owl-carousel -->

                            <!-- *** TESTIMONIALS CAROUSEL END *** -->
                        </div>

                    </div>
                </div>
            </section>
            <!-- /.bar -->

        </div>
        <!-- /#content -->
        <div id="map">

        </div>

<section class="bar background-gray no-mb">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="heading text-center">
                                <h2>Algunos de nuestros clientes</h2>
                            </div>

                            <ul class="owl-carousel customers">
                                  <li class="item">
                                    <img src="img/Customer-7.jpeg" alt="" class="img-responsive">
                                </li>
                                <li class="item">
                                    <img src="img/Customer-8.jpeg" alt="" class="img-responsive">
                                </li>
                                <li class="item">
                                    <img src="img/Customer-9.jpeg" alt="" class="img-responsive">
                                </li>
                                <li class="item">
                                    <img src="img/customer-1.png" alt="" class="img-responsive">
                                </li>
                                <li class="item">
                                    <img src="img/customer-2.png" alt="" class="img-responsive">
                                </li>
                                <li class="item">
                                    <img src="img/customer-3.png" alt="" class="img-responsive">
                                </li>
                              
                                <li class="item">
                                    <img src="img/customer-5.png" alt="" class="img-responsive">
                                </li>
                                <li class="item">
                                    <img src="img/customer-6.png" alt="" class="img-responsive">
                                </li>
                              
                            </ul>
                            <!-- /.owl-carousel -->
                        </div>

                    </div>
                </div>
            </section>


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