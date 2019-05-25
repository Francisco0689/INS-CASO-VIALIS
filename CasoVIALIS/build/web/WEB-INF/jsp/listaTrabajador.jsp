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
        <title>Lista</title>
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
                height:550px;
            }
        </style>
    </head>
    <body style="background-image: url(img/street.jpg)">
        <div class="container col-12">
            <br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
        <div class="container col-11">
            <div id="div1" class="table100 ver5 m-b-110">
                <table data-vertable="ver5">
                    <thead>
                        <tr class="row100 head">
                            <th Style="background-color: #167890;" class="column100 column1" data-column="column1">Código Interno</th>
                            <th Style="background-color: #167890;" class="column100 column2" data-column="column2">Nombres</th>
                            <th Style="background-color: #167890;" class="column100 column3" data-column="column3">Apellidos</th>
                            <th Style="background-color: #167890;" class="column100 column4" data-column="column4">Rut</th>
                            <th Style="background-color: #167890;" class="column100 column5" data-column="column5">Estado Civil</th>
                            <th Style="background-color: #167890;" class="column100 column6" data-column="column6">Dirección</th>
                            <th Style="background-color: #167890;" class="column100 column7" data-column="column7">Telefono</th>
                            <th Style="background-color: #167890;" class="column100 column8" data-column="column8">Estado Actual</th>
                            <th Style="background-color: #167890;" class="column100 column9" data-column="column9">Nacionalidad</th>
                            <th Style="background-color: #167890;" class="column100 column10" data-column="column10">Condicion Extranjero</th>
                            <th Style="background-color: #167890;" class="column100 column11" data-column="column11">Especialidad</th>
                            <th Style="background-color: #167890;" class="column100 column12" data-column="column12"></th>
                            <th Style="background-color: #167890;" class="column100 column13" data-column="column13"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tra" 
                                   items="${trabajadores}"
                                   varStatus="status">
                            <tr class="row100">
                                <td class="column100 column1" data-column="column1">${tra.idTrabajador}</td>
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
                                <td class="column100 column12" data-column="column12"><a href="eliminar-trabajador?rutTrabajador=${tra.rutTrabajador}">Eliminar</a></td>
                                <td class="column100 column13" data-column="column13"><a href="modificarTrabajador">Modificar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
