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
            <div class="container col-11">
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtNombre">Nombres Trabajador</label>
                        <input type="text" name="txtNombre" id="txtNombre" class="form-control" placeholder="Nombres Trabajador">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtApellido">Apellidos Trabajador</label>
                        <input type="text" name="txtApellido" id="txtApellido" class="form-control" placeholder="Apellidos Trabajador">
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <label for="txtRut">Rut Trabajador</label>
                        <input type="text" name="txtRut" id="txtRut" class="form-control" placeholder="Rut Trabajador">
                    </div>
                    <div class="col-6">
                        <label for="txtDv">-</label>
                        <input type="text" name="txtDv" id="txtDv" class="form-control" placeholder="DV Trabajador">
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="form-group col-6">
                        <div class="container">
                            <div class="row">
                                <label for="cboEstadoCivil">Estado Civil Trabajador</label>
                                <select class="form-control" id="cboEstadoCivil">
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
                        <input type="text" name="txtDireccion" id="txtDireccion" class="form-control" placeholder="Direccion Trabajador">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtTelefono">Telefono Trabajador</label>
                        <input type="text" name="txtTelefono" id="txtTelefono" class="form-control" placeholder="Telefono Trabajador">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtNacionalidad">Nacionalidad Trabajador</label>
                        <input type="text" name="txtNacionalidad" id="txtNacionalidad" class="form-control" placeholder="Nacionalidad Trabajador">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="txtEstadoExtranjero">Estado Trabajador Extranjero</label>
                        <input type="text" name="txtEstadoExtranjero" id="txtEstadoExtranjero" class="form-control" placeholder="Estado Extranjero">
                    </div>
                    <div class="form-group col-6">
                        <label for="txtEspecialidad">Especialidad Trabajador</label>
                        <input type="text" name="txtEspecialidad" id="txtEspecialidad" class="form-control" placeholder="Especialidad Trabajador">
                    </div>
                </div>
                <div class="form-group">
                    <center>
                        <button type="submit" class="btn btn-primary btn-block">Agregar Trabajador</button>
                    </center>
                </div>

            </div>
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
                    <td><b>${tra.idTrabajador}</b></td>
                    <td>${tra.nombreTrabajador}</td>
                    <td>${tra.apellidoTrabajador}</td>
                    <td><a href="eliminar-trabajador?rutTrabajador=${tra.rutTrabajador}">Eliminar</a></td>
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
