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

        <div id="content">
            <div class="container">

                <div class="col-sm-6 col-sm-offset-3" id="error-page">

                    <div class="box">

                        <p class="text-center">
                            <a href="index.jsp">
                                <img src="img/logo-masterticket.png" alt="masterticket">
                            </a>
                        </p>

                        <h3>Oopss!! ..algo ha salido mal...</h3>
                        <h4 class="text-muted">Error 500</h4>

                        <p class="buttons"><a href="index.jsp" class="btn btn-template-main"><i class="fa fa-home"></i> Volver</a>
                        </p>
                    </div>


                </div>
                <!-- /.col-sm-6 -->
            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->
<!-- Include layout -->
<%@ include file="/layouts/bottom.jsp" %>