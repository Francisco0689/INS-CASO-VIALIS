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
        <title>Lista de Reuniones</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/util.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/select2.min.css">
        <link rel="stylesheet" href="css/perfect-scrollbar.css">

        <style type="text/css">
            #div1 {
                overflow:scroll;
                height:480px;
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
        <h1>REUNIONES AGENDADAS</h1>
        <br/>

        <form action="buscar-reuniones-por-proyecto" method="POST">
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-4">
                        <center><h4 for="txtBuscarReunion" style="color: black;">Buscar Reunión Por Código de Proyecto</h4></center>
                        <input type="number" name="txtBuscarReunion" id="txtBuscarReunion" class="form-control" placeholder="Código de Proyecto Relacionado" required="true">
                    </div>
                    <div class="form-group col-3">
                        <center>
                            <label for="btnBuscar">-</label>
                            <button style="background: #ffc107; font-weight: bold;" type="submit" name="btnBuscar" class="btn btn-primary btn-block">Buscar Reunión Agendada</button>
                        </center>
                    </div>
                    <div class="form-group col-4">
                        <center>
                            <label for="">-</label>
                            <h5><b Style="color: black;">${mensaje}</b></h5>
                        </center>
                    </div>
                </div>
            </div>
        </form>
        <div class="container col-12">
            <br/>
        </div>
        <div class="container col-11">
            <div id="div1" class="table100 ver5 m-b-110">
                <table data-vertable="ver5">
                    <thead>
                        <tr class="row100 head">
                            <th Style="background-color: #167890;" class="column100 column1" data-column="column1">Código Interno</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Estado Reunión</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Fecha Agendada</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9"></th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Lugar</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Encargado</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Tema</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9"></th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9"></th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Acuerdos</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9"></th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9"></th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Proyecto Asociado</th>
                            <th Style="background-color: #167890;" class="column100 column4" data-column="column4">Código Proyecto Asociado</th>
                            <th Style="background-color: #167890;" class="column100 column4" data-column="column4"></th>
                            <th Style="background-color: #167890;" class="column100 column4" data-column="column4"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="reu" 
                                   items="${reuniones}"
                                   varStatus="status">
                            <tr class="row100">
                                <td style="font-size: 13px;" class="column100 column1" data-column="column1">${reu.idReunion}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${reu.estadoReunion}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${reu.fechaReunion} ${reu.hora}:${reu.min} Hrs</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9" colspan="2">${reu.lugarReunion}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${reu.encargadoReunion}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${reu.descripcionInicial}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9" colspan="5">${reu.descripcionFinal}</td>
                                <td style="font-size: 13px;" class="column100 column9" data-column="column9">${reu.nombreProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column4" data-column="column4">${reu.idProyecto}</td>
                                <td style="font-size: 13px;" class="column100 column4" data-column="column4"><a href="eliminar-reunion?idReunion=${reu.idReunion}">Anular Reunión</a></td>
                                <td style="font-size: 13px;" class="column100 column4" data-column="column4"><a href="modificarReunionDesdeListar?txtBuscarReunion=${reu.idReunion}">Modificar Reunión</a></td>
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
