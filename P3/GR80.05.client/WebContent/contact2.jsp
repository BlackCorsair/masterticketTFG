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
                                            <p>One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown
                                                belly, slightly domed and divided by arches into stiff sections.</p>
                                        </div>
                                        <div class="bottom">
                                            <div class="icon"><i class="fa fa-quote-left"></i>
                                            </div>
                                            <div class="name-picture">
                                                <img class="" alt="" src="img/person-1.jpg">
                                                <h5>John McIntyre</h5>
                                                <p>CEO, TransTech</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="testimonial same-height-always">
                                        <div class="text">
                                            <p>The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. "What's happened
                                                to me? " he thought. It wasn't a dream.</p>
                                        </div>
                                        <div class="bottom">
                                            <div class="icon"><i class="fa fa-quote-left"></i>
                                            </div>
                                            <div class="name-picture">
                                                <img class="" alt="" src="img/person-2.jpg">
                                                <h5>John McIntyre</h5>
                                                <p>CEO, TransTech</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="testimonial same-height-always">
                                        <div class="text">
                                            <p>His room, a proper human room although a little too small, lay peacefully between its four familiar walls.</p>

                                            <p>A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice,
                                                gilded frame.</p>
                                        </div>
                                        <div class="bottom">
                                            <div class="icon"><i class="fa fa-quote-left"></i>
                                            </div>
                                            <div class="name-picture">
                                                <img class="" alt="" src="img/person-3.png">
                                                <h5>John McIntyre</h5>
                                                <p>CEO, TransTech</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="testimonial same-height-always">
                                        <div class="text">
                                            <p>It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towards the viewer. Gregor then turned to look out the window at the dull
                                                weather. Drops of rain could be heard hitting the pane, which made him feel quite sad.</p>
                                        </div>

                                        <div class="bottom">
                                            <div class="icon"><i class="fa fa-quote-left"></i>
                                            </div>
                                            <div class="name-picture">
                                                <img class="" alt="" src="img/person-4.jpg">
                                                <h5>John McIntyre</h5>
                                                <p>CEO, TransTech</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="testimonial same-height-always">
                                        <div class="text">
                                            <p>It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towards the viewer. Gregor then turned to look out the window at the dull
                                                weather. Drops of rain could be heard hitting the pane, which made him feel quite sad. Gregor then turned to look out the window at the dull weather. Drops of rain could be heard hitting the pane, which
                                                made him feel quite sad.</p>
                                        </div>

                                        <div class="bottom">
                                            <div class="icon"><i class="fa fa-quote-left"></i>
                                            </div>
                                            <div class="name-picture">
                                                <img class="" alt="" src="img/person-4.jpg">
                                                <h5>John McIntyre</h5>
                                                <p>CEO, TransTech</p>
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