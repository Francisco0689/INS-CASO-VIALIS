<%-- 
    Document   : login
    Created on : 13-05-2019, 15:35:40
    Author     : fmaldonc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body style="background-image: url(img/street.jpg)">
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                <div class="login-form">
                    <div class="sign-in-htm">
                        <div class="group">
                            <label for="user" class="label">Usuario</label>
                            <input id="user" type="text" class="input">
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Contraseña</label>
                            <input id="pass" type="password" class="input" data-type="password">
                        </div>
                        <div class="group">
                            <label><span></span> </label>
                        </div>
                        <div class="hr"></div>
                        <div class="group">
                            <a href="/CasoVIALIS/">
                            <input type="submit" class="button" value="Ingresar">
                            </a>
                        </div>
                        <div class="hr"></div>
                    </div>
                    <div class="sign-up-htm">
                        <div class="group">
                            <label for="user" class="label">Usuario</label>
                            <input id="user" type="text" class="input">
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Contraseña</label>
                            <input id="pass" type="password" class="input" data-type="password">
                        </div>
                        <div class="group">
                            <label for="email" class="label">Email</label>
                            <input id="email" type="email" class="input">
                        </div>
                        <div class="group">
                            <input type="submit" class="button" value="Registrar">
                        </div>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <label for="tab-1">Estas Registrado?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
