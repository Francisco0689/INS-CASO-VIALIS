<%-- 
    Document   : login
    Created on : 13-05-2019, 15:35:40
    Author     : fmaldonc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>
        <title>Login</title>
    </head>
    <body style="background-image: url(img/street.jpg)">
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Ingresar VIALIS</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
                <div class="login-form">
                    <form action="entrar" method="POST">
                        <div class="sign-in-htm">
                            <div class="group">
                                <label for="txtUser" class="label">Usuario</label>
                                <input id="txtUser" name="txtUser" type="text" class="input" required="true">
                            </div>
                            <div class="group">
                                <label for="txtPass" class="label">Contraseña</label>
                                <input id="txtPass" name="txtPass" type="password" class="input" data-type="password" required="true">
                            </div>
                            <div class="group">
                                <label><span></span> </label>
                            </div>
                            <div class="hr"></div>
                            <div class="group">
                                <input type="submit" class="button" value="Ingresar">
                            </div>
                            <div class="hr"></div>
                            <h4 Style="color: white;">${mensaje}</h4>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
