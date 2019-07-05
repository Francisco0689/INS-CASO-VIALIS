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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>
        <title>Ingresar Cotizacion</title>
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
                    <a href="#">Gestión de Cotizaciones</a>
                    <ul class="list">
                        <li>
                            <a href="/CasoVIALIS/cotizacion">Enviar Cotización</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/modificarCotizacion">Modificar Cotización</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/listaCotizaciones">Lista de Cotizaciones</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Gestión de Usuario</a>
                    <ul class="list">
                        <li>
                            <a href="/CasoVIALIS/usuario">Ingresar Usuario</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/modificarUsuario">Modificar Usuario</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/CasoVIALIS/inspeccionTecnica">Inspección Técnica</a>
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
        <h1>GESTIONAR COTIZACIÓN</h1>
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

        <form action="agregar-cotizacion" method="POST" enctype="multipart/form-data">
            <div class="container col-12">
                <br/><br/>
            </div>
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-12">
                        <label for="cboProveedor">Agregar Proveedor Principal</label>
                        <select class="form-control" name="cboProveedor" id="cboProyecto" required="true">
                            <option value="SIN PROVEEDOR">Sin Proveedor</option>
                            <c:forEach items="${proveedores}" var="pro">
                                <option value="${pro.getNombreProveedor()}">${pro.getNombreProveedor()}</option>
                            </c:forEach>
                        </select>    
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtHerramientas">Herramientas</label>
                        <textarea name="txtHerramientas" id="txtHerramientas" rows="4" cols="80" placeholder="Ingrese Herramientas a Solicitar..." required="true"></textarea>
                    </div>
                    <div class="form-group col-6">
                        <label for="txtMateriales">Materiales</label>
                        <textarea name="txtMateriales" id="txtMateriales" rows="4" cols="80" placeholder="Ingrese Materiales a Solicitar..." required="true"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtMaquinaria">Maquinaria</label>
                        <textarea name="txtMaquinaria" id="txtMaquinaria" rows="4" cols="80" placeholder="Ingrese Maquinaria a Solicitar..." required="true"></textarea>
                    </div>
                    <div class="form-group col-6">
                        <label for="txtServicioExterno">Servicio Externo</label>
                        <textarea name="txtServicioExterno" id="txtServicioExterno" rows="4" cols="80" placeholder="Ingrese Servicios Externos..." required="true">${reunion.getDescripcionFinal()}</textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtNombreDocumento">Nombre De Documento</label>
                        <input type="text" name="txtNombreDocumento" id="txtNombreDocumento" class="form-control" placeholder="Nombre de Documento" required="true">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtTipoDocumento">Tipo de Documento</label>
                        <select class="form-control" name="txtTipoDocumento" id="txtTipoDocumento" required="true">
                            <option value="PDF">PDF</option>
                            <option value="EXCEL">EXCEL</option>
                            <option value="WORD">WORD</option>
                            <option value="POWERPOINT">POWER POINT</option>
                            <option value="TXT">TXT</option>
                            <option value="JPG">JPG</option>
                            <option value="PNG">PNG</option>
                            <option value="OTRO">OTRO</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <img src="img/fileUp.png" alt=""/>
                        <label for="txtDocumento">Subir Documento</label>
                        <img src="img/fileUp.png" alt=""/>
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
                        <button type="submit" Style="background-color: #007bff; font-weight: bold;" class="btn btn-primary btn-block">Enviar Cotización</button>
                    </center>
                </div>
                <div class="container col-12">
                    <br/><br/>
                </div>
            </div>
        </form>
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
