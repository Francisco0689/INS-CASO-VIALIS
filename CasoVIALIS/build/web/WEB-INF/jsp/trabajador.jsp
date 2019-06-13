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
        <title>Ingresar Trabajador</title>
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
        <h1>INGRESAR TRABAJADOR</h1>
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
        <form action="agregar-trabajador" method="POST">
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtNombre">Nombres Trabajador</label>
                        <input type="text" name="txtNombre" id="txtNombre" class="form-control" placeholder="Nombres Trabajador" required="true">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtApellido">Apellidos Trabajador</label>
                        <input type="text" name="txtApellido" id="txtApellido" class="form-control" placeholder="Apellidos Trabajador" required="true">
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <label for="txtRut">Rut Trabajador</label>
                        <input type="number" name="txtRut" id="txtRut" class="form-control" placeholder="Rut Trabajador" required="true">
                    </div>
                    <div class="col-6">
                        <label for="txtDv">-</label>
                        <input type="text" name="txtDv" id="txtDv" class="form-control" placeholder="DV Trabajador" required="true">
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group col-6">
                        <div class="container">
                            <div class="row">
                                <label for="cboEstadoCivil">Estado Civil Trabajador</label>
                                <select class="form-control" name="cboEstadoCivil" id="cboEstadoCivil" required="true">
                                    <option value="">Seleccionar</option>
                                    <option value="SOLTERO">Soltero</option>
                                    <option value="CASADO">Casado</option>
                                    <option value="VIUDO">Viudo</option>
                                    <option value="SEPARADO">Separado</option>
                                </select>

                            </div>
                        </div>
                    </div>
                    <div class="form-group col-6">
                        <label for="txtDireccion">Direccion Trabajador</label>
                        <input type="text" name="txtDireccion" id="txtDireccion" class="form-control" placeholder="Direccion Trabajador" required="true">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtTelefono">Telefono Trabajador</label>
                        <input type="number" name="txtTelefono" id="txtTelefono" class="form-control" placeholder="Telefono Trabajador" required="true">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtNacionalidad">Nacionalidad Trabajador</label>
                        <input type="text" name="txtNacionalidad" id="txtNacionalidad" class="form-control" placeholder="Nacionalidad Trabajador" required="true">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtEstadoExtranjero">Estado Trabajador Extranjero</label>
                        <input type="text" name="txtEstadoExtranjero" id="txtEstadoExtranjero" class="form-control" placeholder="Estado Extranjero" required="true">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtEspecialidad">Especialidad Trabajador</label>
                        <input type="text" name="txtEspecialidad" id="txtEspecialidad" class="form-control" placeholder="Especialidad Trabajador" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <center>
                        <button type="submit" Style="background-color: #007bff; font-weight: bold;" class="btn btn-primary btn-block">Agregar Trabajador</button>
                    </center>
                </div>
            </div>
            <div class="container col-12">
                <br/><br/><br/>
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
