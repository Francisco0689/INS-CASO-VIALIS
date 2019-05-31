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
        <title>Trabajador</title>
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
                    </ul>
                </li>
                <li>
                    <a href="#">Gestión de Proyectos</a>
                    <ul class="list">
                        <li>
                            <a href="#">Lista de Proyectos</a>
                        </li>
                        <li>
                            <a href="/CasoVIALIS/proyecto">Agregar Proyecto</a>
                        </li>
                        <li>
                            <a href="#">Modificar Proyecto</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Gestión de Reuniones</a>
                    <ul class="list">
                        <li>
                            <a href="#">Lista de Reuniones</a>
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
        <h1>Trabajador MODIFICAR</h1>
        ${mensaje}
        <form action="buscar-trabajador" method="POST">
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
                </div>
            </div>
        </form>
        <div class="container col-12">
            <br/><br/><br/><br/><br/>
        </div>
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
                <div class="form-group">
                    <center>
                        <button style="background: #ffc107; font-weight: bold;" type="submit" class="btn btn-primary btn-block">Modificar Trabajador</button>
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
