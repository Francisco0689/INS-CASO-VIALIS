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
        <h1>GESTIONAR TRABAJADOR</h1>
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
        <form action="buscar-trabajador" method="POST">
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-4">
                        <center><label for="txtBuscarRut">Buscar Trabajador (Ingrese rut sin DV)</label></center>
                        <input type="number" name="txtBuscarRut" id="txtBuscarRut" class="form-control" placeholder="Rut Trabajador sin DV" required="true">
                    </div>
                    <div class="form-group col-2">
                        <center>
                            <label for="btnBuscar">-</label>
                            <button style="background: #ffc107; font-weight: bold;" type="submit" name="btnBuscar" class="btn btn-primary btn-block">Buscar Trabajador</button>
                        </center>
                    </div>
                </div>
            </div>
        </form>
        <div class="container col-12">
            <br/><br/>
        </div>
        <c:if test="${empty trabajador.rutTrabajador}">
            <h1>Constructora VIALIS</h1>
        </c:if>
        <c:if test="${not empty trabajador.rutTrabajador}">
            <form action="modificar-trabajador" method="POST">
                <div class="container col-11">
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtNombre">Nombres Trabajador</label>
                            <input type="text" value="${trabajador.nombreTrabajador}" name="txtNombre" id="txtNombre" class="form-control" placeholder="Nombres Trabajador" required="true">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtApellido">Apellidos Trabajador</label>
                            <input type="text" value="${trabajador.apellidoTrabajador}" name="txtApellido" id="txtApellido" class="form-control" placeholder="Apellidos Trabajador" required="true">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label for="txtRut">Rut Trabajador</label>
                            <input type="number" disabled="true" value="${trabajador.rutTrabajador}" name="txtRut" id="txtRut" class="form-control" placeholder="Rut Trabajador">
                            <input type="hidden" value="${trabajador.rutTrabajador}" name="txtRut" id="txtRut" class="form-control" placeholder="Rut Trabajador" required="true">
                        </div>
                        <div class="col-6">
                            <label for="txtDv">-</label>
                            <input type="text" disabled="true" value="${trabajador.dvTrabajador}" name="txtDv" id="txtDv" class="form-control" placeholder="DV Trabajador">
                            <input type="hidden" value="${trabajador.dvTrabajador}" name="txtDv" id="txtDv" class="form-control" placeholder="DV Trabajador" required="true">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="cboEstadoCivil">Estado Civil</label>
                            <input type="text" value="${trabajador.estadoCivilTrabajador}" name="cboEstadoCivil" id="cboEstadoCivil" class="form-control" placeholder="Estado Civil" required="true">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtDireccion">Direccion Trabajador</label>
                            <input type="text" value="${trabajador.direccionTrabajador}" name="txtDireccion" id="txtDireccion" class="form-control" placeholder="Direccion Trabajador" required="true">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtTelefono">Telefono Trabajador</label>
                            <input type="number" value="${trabajador.telefonoTrabajador}" name="txtTelefono" id="txtTelefono" class="form-control" placeholder="Telefono Trabajador" required="true">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtNacionalidad">Nacionalidad Trabajador</label>
                            <input type="text" value="${trabajador.nacionalidadTrabajador}" name="txtNacionalidad" id="txtNacionalidad" class="form-control" placeholder="Nacionalidad Trabajador" required="true">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtEstadoExtranjero">Estado Trabajador Extranjero</label>
                            <input type="text" value="${trabajador.condicionExtranjeroTrabajador}" name="txtEstadoExtranjero" id="txtEstadoExtranjero" class="form-control" placeholder="Estado Extranjero" required="true">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtEspecialidad">Especialidad Trabajador</label>
                            <input type="text" value="${trabajador.especialidadTrabajador}" name="txtEspecialidad" id="txtEspecialidad" class="form-control" placeholder="Especialidad Trabajador" required="true">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="txtResponsabilidad">Responsabilidad Trabajador</label>
                            <input type="text" name="txtResponsabilidad" value="${trabajador.responsabilidadTrabajador}" id="txtResponsabilidad" class="form-control" placeholder="Responsabilidad" required="true">
                        </div>
                        <div class="form-group col-6">
                            <label for="txtSueldo">Sueldo Trabajador</label>
                            <input type="text" name="txtSueldo" value="${trabajador.sueldoTrabajador}" id="txtSueldo" class="form-control" placeholder="Sueldo Trabajador" required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <center>
                            <button style="background: #ffc107; font-weight: bold;" type="submit" class="btn btn-primary btn-block">Modificar Trabajador</button>
                        </center>
                    </div>
                </div>
                <div class="container col-12">
                    <br/><br/>
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
