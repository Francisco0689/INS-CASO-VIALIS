<%-- 
    Document   : trabajador
    Created on : 09-05-2019, 16:21:53
    Author     : fmaldonc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style.css">
        <title>Reunion</title>
    </head>
    <body Style="font-weight: bold; background: #fff; color:#000; background-image: url(img/hero-2.png);">
        <!-- ================Offcanvus Menu Area =================-->
        <div class="side_menu">
            <ul class="list menu_right">
                <li>
                    <a href="/CasoVIALIS/">Home</a>
                </li>
                <li>
                    <a href="#">Gestión de Trabajadores</a>
                    <ul class="list">
                        <li>
                            <a href="/CasoVIALIS/listaTrabajador">Lista de Trabajadores</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/trabajador">Agregar Trabajador</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/modificarTrabajador">Modificar Trabajador</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Gestión de Proyectos</a>
                    <ul class="list">
                        <li>
                            <a href="#">Lista de Proyectos</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/proyecto">Agregar Proyecto</a>
                        </li>
                        <li>
                            <a href="#">Modificar Proyecto</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Gestión de Reuniones</a>
                    <ul class="list">
                        <li>
                            <a href="#">Lista de Reuniones</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/reunion">Agendar Reunión</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/modificarReunion">Modificar Reunión</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Sobre Nosotros</a>
                </li>
                <li>
                    <a href="/CasoVIALIS/login">Salir</a>
                </li>
            </ul>
        </div>
        <!--================End Offcanvus Menu Area =================-->
        <!--================Canvus Menu Area =================-->
        <div class="canvus_menu">
            <div class="container">
                <div class="float-right">
                    <div class="toggle_icon" title="Menu Bar">
                        <span></span>
                    </div>
                </div>
            </div>
        </div>
        <!--================End Canvus Menu Area =================-->
        <h1>Agendar Reunion</h1>
        ${mensaje}
        <div class="container col-12">
            <br/><br/><br/><br/><br/>
        </div>
        <form action="agendar-reunion" method="POST">
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtEstadoReunion">Estado de Reunión</label>
                        <input type="text" disabled="true" value="AGENDADA" name="txtEstadoReunion" id="txtEstadoReunion" class="form-control" required="true">
                        <input type="hidden" value="AGENDADA" name="txtEstadoReunion" id="txtEstadoReunion" class="form-control" required="true">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtLugar">Lugar de Reunión</label>
                        <input type="txtLugar" name="txtLugar" id="txtLugar" class="form-control" placeholder="Lugar de Reunión" required="true">
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <label for="txtFechaReunion">Fecha de Reunión</label>
                        <input type="date" min="${fechaActual}" name="txtFechaReunion" id="txtFechaReunion" class="form-control" placeholder="Fecha de Reunión">
                    </div>
                    <div class="col-3">
                        <label for="txtHoraReunion">Hora de Reunión</label>
                        <input type="number" min="00" max="24" name="txtHoraReunion" id="txtHoraReunion" class="form-control" placeholder="Hrs." required="true">
                    </div>
                    <div class="col-3">
                        <label for="txtMinutoReunion">Min.</label>
                        <input type="number" min="00" max="59" name="txtMinutoReunion" id="txtMinutoReunion" class="form-control" placeholder="Min." required="true">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtEncargado">Encargado de Reunión</label>
                        <input type="text" name="txtEncargado" id="txtEncargado" placeholder="Encargado de Reunión" class="form-control" required="true">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtTemaReunion">Tema de Reunión</label>
                        <input type="txtTemaReunion" name="txtTemaReunion" id="txtTemaReunion" class="form-control" placeholder="Tema de Reunión" required="true">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-12">
                        <label for="cboProyecto">Proyecto Asociado</label>
                        <select class="form-control" name="cboProyecto" id="cboProyecto" required="true">
                            <option>Seleccionar Proyecto Asociado a Reunión</option>
                            <c:forEach items="${proyectos}" var="pro">
                                <option value="${pro.getIdProyecto()}">${pro.getNombreProyecto()}</option>
                            </c:forEach>
                        </select>    
                    </div>
                </div>

                <div class="form-group">
                    <center>
                        <button style="background: #218838; font-weight: bold;" type="submit" class="btn btn-success btn-block">Agendar Reunión</button>
                    </center>
                </div>
                
            </div>
        </form>
        <script src="js/jquery-3.2.1.min.js"></script>	
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script>
            var heroCarousel = $('.heroCarousel');
            heroCarousel.owlCarousel({
                loop: true,
                margin: 10,
                nav: false,
                startPosition: 1,
                responsiveClass: true,
                responsive: {
                    0: {
                        items: 1
                    }
                }
            });

            var dropToggle = $('.menu_right > li').has('ul').children('a');
            dropToggle.on('click', function () {
                dropToggle.not(this).closest('li').find('ul').slideUp(200);
                $(this).closest('li').children('ul').slideToggle(200);
                return false;
            });

            $(".toggle_icon").on('click', function () {
                $('body').toggleClass("open");
            });
        </script>
    </body>
</html>
