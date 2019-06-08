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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>
        <title>Ingresar Proyecto</title>
        <style type="text/css">
            h1 {
                font-family: "Avant Garde", Avantgarde, "Century Gothic", CenturyGothic, "AppleGothic", sans-serif;
                font-size: 45px;
                padding-top: 25px;
                text-align: center;
                text-transform: uppercase;
                text-rendering: optimizeLegibility; 
                color: steelblue;
            }
        </style>
    </head>
    <body Style="background-image: url(img/hero-2.png); color: black; font-weight: bold;">
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
                            <a href="/CasoVIALIS/listaProyecto">Lista de Proyectos</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/proyecto">Agregar Proyecto</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/modificarProyecto">Modificar Proyecto</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Gestión de Reuniones</a>
                    <ul class="list">
                        <li>
                            <a href="/CasoVIALIS/listaReunion">Lista de Reuniones</a>
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
                    <a href="/CasoVIALIS/sobreNosotros">Sobre Nosotros</a> 
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
        <h1>INGRESAR PROYECTO</h1>
        ${mensaje}
        <form action="agregar-proyecto" method="POST">
            <div class="container col-12">
                <br/><br/><br/>
            </div>
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtNombreProyecto">Nombre Proyecto</label>
                        <input type="text" name="txtNombreProyecto" id="txtNombreProyecto" class="form-control" placeholder="Nombre Proyecto" required="true">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtTipoProyecto">Tipo de Proyecto</label>
                        <select class="form-control" name="txtTipoProyecto" id="txtTipoProyecto" required="true">
                            <option value="URBANO">URBANO</option>
                            <option value="RURAL">RURAL</option>
                            <option value="AUTOPISTA">AUTOPISTA</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <label for="txtEstadoProyecto">Estado de Proyecto</label>
                        <select class="form-control" name="txtEstadoProyecto" id="txtEstadoProyecto" required="true">
                            <option value="ACTIVO">ACTIVO</option>
                            <option value="NOACTIVO">NO ACTIVO</option>
                            <option value="ENESPERA">EN ESPERA</option>
                            <option value="RECHAZADO">RECHAZADO</option>
                            <option value="FINALIZADO">FINALIZADO</option>
                        </select></div>
                    <div class="col-6">
                        <label for="txtEncargadoProyecto">Encargado de Proyecto</label>
                        <input type="text" name="txtEncargadoProyecto" id="txtEncargadoProyecto" class="form-control" placeholder="Encargado de Proyecto" required="true">
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group col-12">
                        <label for="txtDireccionProyecto">Direccion Proyecto</label>
                        <input type="text" name="txtDireccionProyecto" id="txtDireccionProyecto" class="form-control" placeholder="Direccion Proyecto" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <center>
                        <button type="submit" Style="background-color: #007bff; font-weight: bold;" class="btn btn-primary btn-block">Ingresar Proyecto</button>
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
