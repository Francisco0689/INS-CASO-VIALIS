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
        <title>Trabajador</title>
    </head>
    <body>
        <h1>Trabajador CRUD</h1>
        <div class="alert alert-primary" role="alert">
            ${mensaje}
        </div>
        <form action="agregar-trabajador" method="POST">
            <table>
                <div class="form-group" align="center">
                    <label for="txtNombre">Nombres Trabajador</label>
                    <input type="text" name="txtNombre" id="txtNombre" class="form-control" placeholder="Nombres">
                </div>
                <div class="form-group" align="center">
                    <label for="txtApellido">Apellidos Trabajador</label>
                    <input type="text" name="txtApellido" id="txtApellido" class="form-control" placeholder="Apellidos">
                </div>
                <div class="form-group" align="center">
                    <label for="txtRut">Rut Trabajador</label>
                    <input type="text" name="txtRut" id="txtRut" class="form-control" placeholder="Rut">
                    <label for="txtDv">-</label>
                    <input type="text" name="txtDv" id="txtDv" class="form-control" placeholder="DV">
                </div>
                <div class="form-group" align="center">
                    <label for="cboEstadoCivil">Estado Civil Trabajador</label>
                    <select name="cboEstadoCivil" id="cboEstadoCivil" class="selectpicker">
                        <option value="">Seleccionar</option>
                        <option value="SOLTERO">Soltero</option>
                        <option value="CASADO">Casado</option>
                        <option value="VIUDO">Viudo</option>
                        <option value="SEPARADO">Separado</option>
                    </select>
                </div>
                <div class="form-group" align="center">
                    <label for="txtDireccion">Direccion Trabajador</label>
                    <input type="text" name="txtDireccion" id="txtDireccion" class="form-control" placeholder="Direccion">
                </div>
                <div class="form-group" align="center">
                    <label for="txtTelefono">Telefono Trabajador</label>
                    <input type="text" name="txtTelefono" id="txtTelefono" class="form-control" placeholder="Telefono">
                </div>
                <div class="form-group" align="center">
                    <label for="txtNacionalidad">Nacionalidad Trabajador</label>
                    <input type="text" name="txtNacionalidad" id="txtNacionalidad" class="form-control" placeholder="Nacionalidad">
                </div>
                <div class="form-group" align="center">
                    <label for="txtEstadoExtranjero">Estado Trabajador Extranjero</label>
                    <input type="text" name="txtEstadoExtranjero" id="txtEstadoExtranjero" class="form-control" placeholder="Estado Extranjero">
                </div>
                <div class="form-group" align="center">
                    <label for="txtEspecialidad">Especialidad Trabajador</label>
                    <input type="text" name="txtEspecialidad" id="txtEspecialidad" class="form-control" placeholder="Especialidad">
                </div>
                <center>
                    <button type="submit" class="btn btn-primary">Agregar Trabajador</button>
                </center>
        </form>
        <table>
            <tr>
                <th>Código Trabajador</th>
                <th>Nombre Trabajador</th>
                <th>Apellido Trabajador</th>
                <th>Opciones</th>
            </tr>
            <c:forEach var="tra" 
                       items="${trabajadores}"
                       varStatus="status">
                <tr>
                    <td><b>${tra.id}</b></td>
                    <td>${tra.nombreTrabajador}</td>
                    <td>${tra.apellidoTrabajador}</td>
                    <td><a href="eliminar-trabajador?id=${tra.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>

        <hr>
        <hr>
        <hr>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
