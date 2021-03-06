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
        <title>Lista de Trabajadores</title>
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
        <h1>TRABAJADORES REGISTRADOS</h1>
        <div class="container col-12">
            <br/><br/><br/>
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
        <div class="container col-11">
            <div id="div1" class="table100 ver5 m-b-110">
                <table data-vertable="ver5">
                    <thead>
                        <tr class="row100 head">
                            <th Style="background-color: #167890;" class="column100 column1" data-column="column1">Código Interno</th>
                            <th Style="background-color: #167890;" class="column100 column1" data-column="column1"></th>
                            <th Style="background-color: #167890;" class="column100 column2" data-column="column2"> Nombres</th>
                            <th Style="background-color: #167890;" class="column100 column3" data-column="column3">Apellidos</th>
                            <th Style="background-color: #167890;" class="column100 column4" data-column="column4">Rut</th>
                            <th Style="background-color: #167890;" class="column100 column5" data-column="column5">Estado Civil</th>
                            <th Style="background-color: #167890;" class="column100 column6" data-column="column6">Dirección</th>
                            <th Style="background-color: #167890;" class="column100 column7" data-column="column7">Telefono</th>
                            <th Style="background-color: #167890;" class="column100 column8" data-column="column8">Estado Actual</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Nacionalidad</th>
                            <th Style="background-color: #167890;" class="column100 column10" data-column="column10">Condicion Extranjero</th>
                            <th Style="background-color: #167890;" class="column100 column11" data-column="column11">Especialidad</th>
                            <th Style="background-color: #167890;" class="column100 column12" data-column="column12">Editar Trabajador</th>
                            <th Style="background-color: #167890;" class="column100 column13" data-column="column13">Eliminar Trabajador</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tra" 
                                   items="${trabajadores}"
                                   varStatus="status">
                            <tr class="row100">
                                <td class="column100 column1" data-column="column1">${tra.idTrabajador}</td>
                                <td class="column100 column1" data-column="column1"><img src="img/man.png" alt=""/></td>
                                <td class="column100 column2" data-column="column2">${tra.nombreTrabajador}</td>
                                <td class="column100 column3" data-column="column3">${tra.apellidoTrabajador}</td>
                                <td class="column100 column4" data-column="column4">${tra.rutTrabajador} - ${tra.dvTrabajador}</td>
                                <td class="column100 column5" data-column="column5">${tra.estadoCivilTrabajador}</td>
                                <td class="column100 column6" data-column="column6">${tra.direccionTrabajador}</td>
                                <td class="column100 column7" data-column="column7">${tra.telefonoTrabajador}</td>
                                <td class="column100 column8" data-column="column8">${tra.estadoTrabajador}</td>
                                <td class="column100 column9" data-column="column9">${tra.nacionalidadTrabajador}</td>
                                <td class="column100 column10" data-column="column10">${tra.condicionExtranjeroTrabajador}</td>
                                <td class="column100 column11" data-column="column11">${tra.especialidadTrabajador}</td>
                                <td class="column100 column13" data-column="column13"><a href="modificarTrabajadorDesdeListar?txtBuscarRut=${tra.rutTrabajador}"><img src="img/edit.png" alt=""/></a></td>
                                <td class="column100 column12" data-column="column12"><a href="eliminar-trabajador?rutTrabajador=${tra.rutTrabajador}"><img src="img/remove.png" alt=""/></a></td>
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
                responsive: {0: {
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
