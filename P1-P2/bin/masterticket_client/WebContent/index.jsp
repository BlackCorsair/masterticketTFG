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
      
       <section>
            <!-- *** HOMEPAGE CAROUSEL ***
 _________________________________________________________ -->

            <div class="home-carousel">

                <div class="dark-mask"></div>

                <div class="container">
                    <div class="homepage owl-carousel">
                        <div class="item">
                            <div class="row">
                                <div class="col-sm-5 right">
                                    <h1>Los mejores eventos</h1>
                                    <p>En masterticket
                                        <br />Compra. Vende. Encuentra.</p>
                                </div>
                                <div class="col-sm-7">
                                    <img class="img-responsive" src="img/concert3.png" alt="" style="border-radius:20px;">
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="row">

                                <div class="col-sm-7 text-center">
                                    <img class="img-responsive" src="img/musical.png" alt="" style="border-radius:20px;">
                                </div>

                                <div class="col-sm-5">
                                    <h2>Todo tipo de shows</h2>
                                    <ul class="list-style-none">
                                        <li>Musicales, conciertos, festivales...</li>
                                        <li>¡Todo lo que puedes imaginar!</li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="item">
                            <div class="row">
                                <div class="col-sm-5 right">
                                    <h1>Vive más intensamente</h1>
                                    <ul class="list-style-none">
                                        <li>Descubre los eventos que te emocionen</li>
                                    </ul>
                                </div>
                                <div class="col-sm-7">
                                    <img class="img-responsive" src="img/concert-blue.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.project owl-slider -->
                </div>
            </div>

            <!-- *** HOMEPAGE CAROUSEL END *** -->
        </section>

        <section class="bar background-white">
            <div class="container">
                <div class="col-md-12">


                    <div class="row">
                        <div class="col-md-4">
                            <div class="box-simple">
                                <div class="icon">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                </div>
                                <h3>Tienda online</h3>
                                <p>Entradas y tickets oficiales, garantizados</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="box-simple">
                                <div class="icon">
                                    <i class="fa fa-print"></i>
                                </div>
                                <h3>Imprime y asiste</h3>
                                <p>Imprime tu ticket y preséntalo en la entrada</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="box-simple">
                                <div class="icon">
                                    <i class="fa fa-mobile" aria-hidden="true"></i>
                                </div>
                                <h3>Usa tu smartphone</h3>
                                <p>Presenta tu entrada QR en la entrada y pasa rápidamente</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="bar background-pentagon no-mb">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heading text-center">
                            <h2>Nos recomiendan y eso nos enorgullece</h2>
                        </div>


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

        <section class="bar background-gray no-mb">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heading text-center">
                            <h2>Nuestros clientes</h2>
                        </div>

                        <ul class="owl-carousel customers">
                            <li class="item">
                                <img src="img/customer-1.png" alt="" class="img-responsive">
                            </li>
                            <li class="item">
                                <img src="img/customer-2.png" alt="" class="img-responsive" style="width:50px;height:70px;">
                            </li>
                            <li class="item">
                                <img src="img/customer-3.png" alt="" class="img-responsive" style="width:70px;height:70px;">
                            </li>
                            <li class="item">
                                <img src="img/customer-4.png" alt="" class="img-responsive" style="width:70px;height:70px;">
                            </li>
                            <li class="item">
                                <img src="img/customer-5.png" alt="" class="img-responsive" style="height:70px;">
                            </li>
                            <li class="item">
                                <img src="img/customer-6.png" alt="" class="img-responsive" style="height:70px;">
                            </li>
                        </ul>
                        <!-- /.owl-carousel -->
                    </div>

                </div>
            </div>
        </section>
        
<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>