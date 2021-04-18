<%-- 
    Document   : Registrarse
    Created on : Apr 15, 2021, 11:12:20 PM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
        <script src="js/admin/adminUsuario.js" type="text/javascript"></script>
        <link href="style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row" id="row">
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" id="nombre" placeholder="Nombre">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group"> 
                    <input type="text" class="form-control" id="apellido" placeholder="Apellido">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" id="email" placeholder="email">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">Fecha de Nacimiento:
                    <input type="date" class="form-control" id="nacimiento" placeholder="Fecha de Nacimiento">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group"> 
                    <input type="text" class="form-control" id="direccion" placeholder="Direccion">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" id="trabajo" placeholder="Telefono Trabajo">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" id="casa" placeholder="Celular">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" id="idUsuario" placeholder="Id de Usuario">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" id="contrasena" placeholder="Contreseña">
                </div>
            </div>
            <div class="col-md-12">
                <button onclick="insertarUsuario()" type="button" class="btn btn-primary full-width">Registrarse</button>
            </div>
        </div>
    </body>
</html>
