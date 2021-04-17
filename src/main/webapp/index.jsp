<%-- 
    Document   : index
    Created on : Apr 16, 2021, 11:53:22 PM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="header.jsp"/>
        <link href="style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/usuario/vuelos.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    </head>
    <body onload='cargar_vuelos("1")'>

        <p id="or">Origen: <input autocomplete="off" id="origen" type="text" size="20"  name="Origen"/></p>
        <p id="des">Destino: <input autocomplete="off" id="destino" type="text" size="20" name="Destino"/></p>
        <p id="d">Dia: <select name="dia" id="dia">
                <option value="1">Lunes</option>
                <option value="2">Martes</option>
                <option value="3">Miercoles</option>
                <option value="4">Jueves</option>
                <option value="5">Viernes</option>
                <option value="6">Sabado</option>
                <option value="7">Domingo</option>
            </select>
        </p>

        <button type="button" id="buscar" onclick="buscar_ID()">Buscar</button>

        <table id="tabla" class="table table-striped">
            <thead>
                <tr class="bg-primary text-white">
                    <th>Dia</th>
                    <th>Hora Salida</th>
                    <th>Avion</th>
                    <th>Hora LLegada</th>
                    <th>Ciudad Origen</th>
                    <th>Ciudad Destino</th>
                    <th></th>
                </tr>
            </thead>
            <tbody id="tbody_vuelo">

            </tbody>
        </table>
    </body>
</html>
