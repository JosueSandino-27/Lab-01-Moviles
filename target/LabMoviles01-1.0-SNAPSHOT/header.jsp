<%-- 
    Document   : header
    Created on : Apr 15, 2021, 8:53:33 PM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <link href="style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://unpkg.com/ionicons@4.5.5/dist/css/ionicons.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container">
            <div id="brand"><a href="principal.jsp"><img src="style/Imagenes/logo.png" class="logo-brand" alt="logo" id="logo"></a></div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <img src="assets/images/menu.svg">
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#hero">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#portfolio">Iniciar Sesión</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Registrarse.jsp">Regitrarse</a>
                    </li>
                   
                </ul>
            </div>
        </div>
    </nav>
    </body>
</html>
