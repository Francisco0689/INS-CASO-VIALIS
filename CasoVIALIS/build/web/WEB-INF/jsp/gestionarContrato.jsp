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
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>
        <title>Modificar Trabajador</title>
        <style type="text/css">
            h1,  h5 {
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
                        <li>
                            <a href="/CasoVIALIS/gestionarContrato">Gestionar Contrato Laboral</a>
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
        <h1>GESTIONAR CONTRATO LABORAL</h1>
        ${mensaje}
        <form action="buscar-trabajador-contrato" method="POST">
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-4">
                        <center><label for="txtBuscarRut">Buscar Trabajador</label></center>
                        <input type="number" name="txtBuscarRut" id="txtBuscarRut" class="form-control" placeholder="Rut Trabajador sin DV" required="true">
                    </div>
                    <div class="form-group col-2">
                        <center>
                            <label for="btnBuscar">-</label>
                            <button style="background: #ffc107; font-weight: bold;" type="submit" name="btnBuscar" class="btn btn-primary btn-block">Buscar Trabajador</button>
                        </center>
                    </div>
                    <div class="form-group col-4">
                        <br/><br/>
                        <label for="txtNombre">Gestionar Contrato Laboral a : ${trabajador.nombreTrabajador} ${trabajador.apellidoTrabajador}</label>
                    </div>
                </div>
            </div>
        </form>
        <div class="container col-12">
            <br/><br/>
        </div>
        <form action="gestionar-contrato" method="POST">
            <div class="container col-11">
                <div class="form-group">
                    <center>
                        <button style="background: steelblue; font-weight: bold;" type="submit" class="btn btn-primary btn-block"><b style="color: white;">Gestionar Contrato Laboral</b></button>
                    </center>
                </div>
            </div>
            <div class="container col-12">
                <br/><br/>
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
