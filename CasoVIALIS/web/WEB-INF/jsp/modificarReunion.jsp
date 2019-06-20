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
        <title>Modificar Reunion</title>
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
        <h1>GESTIONAR REUNIÓN</h1>
        <div class="container col-12">
            <br/>
        </div>
        <c:if test="${not empty mensaje}">
            <div class="container col-12">
                <div class="alert alert-success" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <center><h3 class="alert-heading">CONSTRUCTORA VIALIS</h3></center>
                    <hr>
                    <center><p>${mensaje}</p></center>
                    <hr>
                </div>
            </div>
        </c:if>
        <form action="buscar-reunion" method="POST">
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-3">
                        <center><label for="txtBuscarReunion">Buscar Reunión Agendada</label></center>
                        <input type="number" name="txtBuscarReunion" id="txtBuscarReunion" class="form-control" placeholder="Código de Reunión Agendada" required="true">
                    </div>
                    <div class="form-group col-3">
                        <center>
                            <label for="btnBuscar">-</label>
                            <button style="background: #ffc107; font-weight: bold;" type="submit" name="btnBuscar" class="btn btn-primary btn-block">Buscar Reunión Agendada</button>
                        </center>
                    </div>
                </div>
            </div>
        </form>
        <div class="container col-12">
            <br/><br/><br/>
        </div>
        <c:if test="${empty reunion.getIdReunion()}">
            <h1>CONSTRUCTORA VIALIS</h1>
        </c:if>
        <c:if test="${not empty reunion.getIdReunion()}">
            <form action="modificar-reunion" method="POST">
                <div class="container col-11">
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtEstadoReunion">Estado de Reunión</label>
                            <input type="text" value="${reunion.getEstadoReunion()}" name="txtEstadoReunion" id="txtEstadoReunion" class="form-control" placeholder="Estado de Reunión" required="true">
                            <input type="hidden" value="${reunion.getIdReunion()}" name="txtIdReunion" id="txtIdReunion">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtLugar">Lugar de Reunión</label>
                            <input type="txtLugar" value="${reunion.getLugarReunion()}" name="txtLugar" id="txtLugar" class="form-control" placeholder="Lugar de Reunión" required="true">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label for="txtFechaReunion">Fecha de Reunión</label>
                            <input type="date" value="${reunion.getFechaReunion()}" min="${fechaActual}" name="txtFechaReunion" id="txtFechaReunion" class="form-control" placeholder="Fecha de Reunión">
                        </div>
                        <div class="col-3">
                            <label for="txtHoraReunion">Hora de Reunión</label>
                            <input type="number" value="${reunion.getHora()}" min="${hora}" max="24" name="txtHoraReunion" id="txtHoraReunion" class="form-control" placeholder="Hrs." required="true">
                        </div>
                        <div class="col-3">
                            <label for="txtMinutoReunion">Min.</label>
                            <input type="number" value="${reunion.getMin()}" min="00" max="59" name="txtMinutoReunion" id="txtMinutoReunion" class="form-control" placeholder="Min." required="true">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtEncargado">Encargado de Reunión</label>
                            <input type="text" value="${reunion.getEncargadoReunion()}" name="txtEncargado" id="txtEncargado" placeholder="Encargado de Reunión" class="form-control" required="true">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtTemaReunion">Tema de Reunión</label>
                            <input disabled="true" type="txtTemaReunion" value="${reunion.getDescripcionInicial()}" name="txtTemaReunion" id="txtTemaReunion" class="form-control" placeholder="Tema de Reunión" required="true">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-12">
                            <label for="txtProyectoAsociado">Proyecto Asociado</label>
                            <input type="text" disabled="true" value="${reunion.getNombreProyecto()}" name="txtProyectoAsociado" id="txtProyectoAsociado" class="form-control" placeholder="Proyecto Relacionado">
                            <input type="hidden" value="${reunion.getNombreProyecto()}" name="txtProyectoAsociado" id="txtProyectoAsociado" class="form-control" placeholder="Proyecto Relacionado">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-12">
                            <label for="txtAcuerdo">Acuerdos de la Reunión</label>
                        </div>
                        <div class="form-group col-12">
                            <textarea name="txtAcuerdo" id="txtAcuerdo" rows="5" cols="169" placeholder="Acuerdos de la reunión...">${reunion.getDescripcionFinal()}</textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <center>
                            <button style="background: #218838; font-weight: bold;" type="submit" class="btn btn-success btn-block">Modificar Reunión</button>
                        </center>
                    </div>
                    <div class="container col-12">
                        <br/><br/><br/><br/><br/>
                    </div>
                </div>
            </form>
        </c:if>
        <script src="js/jquery-3.2.1.min.js"></script>	
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script>
            window.setTimeout(function () {
                $(".alert").fadeTo(500, 0).slideUp(500, function () {
                    $(this).remove();
                });
            }, 4000);

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
