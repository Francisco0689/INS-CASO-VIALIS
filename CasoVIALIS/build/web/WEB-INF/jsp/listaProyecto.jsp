<%-- 
    Document   : listaTrabajador
    Created on : 23-05-2019, 19:45:37
    Author     : fmaldonc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Proyectos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/util.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/select2.min.css">
        <link rel="stylesheet" href="css/perfect-scrollbar.css">
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>

        <style type="text/css">
            #div1 {
                overflow:scroll;
                height:500px;
            }
            h1 {
                font-family: "Avant Garde", Avantgarde, "Century Gothic", CenturyGothic, "AppleGothic", sans-serif;
                font-size: 45px;
                padding-top: 25px;
                text-align: center;
                text-transform: uppercase;
                text-rendering: optimizeLegibility; 
                color: linen;
            }
        </style>
    </head>
    <body style="background-image: url(img/street.jpg); font-weight: bold;">
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
        <h1>Proyectos Ingresados</h1>
        <div class="container col-12">
            <br/><br/>
        </div>
        <div class="container col-11">
            <div id="div1" class="table100 ver5 m-b-110">
                <table data-vertable="ver5">
                    <thead>
                        <tr class="row100 head">
                            <th Style="background-color: #167890;" class="column100 column1" data-column="column1">Código Interno</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Nombre Proyecto</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Tipo Proyecto</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Estado Proyecto</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Encargado Proyecto</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Dirección Proyecto</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9" colspan="2"><center>Hitos</center></th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pro" 
                                   items="${proyectos}"
                                   varStatus="status">
                            <tr class="row100">
                                <td style="font-size: 13px;" class="column100 column1" data-column="column1">${pro.idProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${pro.nombreProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${pro.tipoProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${pro.estadoProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${pro.encargadoProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${pro.direccionProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9" colspan="2">
                                    <ul>
                                        <c:forEach var="hito" 
                                                   items="${pro.hitos}"
                                                   varStatus="status">
                                            <li>
                                                * ${hito.nombreHito} | Día: ${hito.fechaHito}
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

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
