<%-- 
    Document   : trabajador
    Created on : 09-05-2019, 16:21:53
    Author     : fmaldonc
--%>

<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style.css">
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>
        <title>Modificar Trabajador</title>
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
        <h1>GESTIONAR CONTRATO LABORAL</h1>
        <div class="container col-12">
            <br/><br/>
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
                        <h5 for="txtNombre">Gestionar Contrato Laboral a : ${trabajador.nombreTrabajador} ${trabajador.apellidoTrabajador}</h5>
                    </div>
                </div>
            </div>
        </form>
        <div class="container col-12">
            <br/><br/>
        </div>

        <c:if test="${empty trabajador.idTrabajador}">
            <h1>INGRESE RUT DE TRABAJADOR PARA GESTIONAR CONTRATO LABORAL...</h1>
        </c:if>
        <c:if test="${not empty trabajador.idTrabajador}">
            <form action="gestionar-contrato" method="POST" enctype="multipart/form-data">  <!--enctype="multipart/form-data"-->
                <div class="container col-11">
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtNombreDocumento">Nombre De Documento</label>
                            <input type="text" name="txtNombreDocumento" id="txtNombreDocumento" class="form-control" placeholder="Nombre de Documento" required="true">
                            <input type="hidden" name="txtIdTrabajador" value="${trabajador.idTrabajador}" id="txtIdTrabajador" class="form-control">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtTipoDocumento">Tipo de Documento</label>
                            <input type="text" name="txtTipoDocumento" id="txtTipoDocumento" placeholder="Tipo de Documento" class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtDocumento">Documento</label>
                            <input type="file" size="50" name="txtDocumento" id="txtDocumento" placeholder="Documento" class="form-control" required="true">
                        </div>
                        <div class="form-group col-6">
                            <label for="cboProyecto">Proyecto Asociado</label>
                            <select class="form-control" name="cboProyecto" id="cboProyecto" required="true">
                                <option value="0">SIN PROYECTO ASOCIADO</option>
                                <c:forEach items="${proyectos}" var="pro">
                                    <option value="${pro.getIdProyecto()}">${pro.getNombreProyecto()}</option>
                                </c:forEach>
                            </select>    
                        </div>
                    </div>
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
        </c:if>
    </div>
</body>
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
