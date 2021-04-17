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
    <body onload="cargar_vuelos()">

        Origen: <input id="origen" type="text" size="30" id="username" name="Origen" name="Origen"/>

        Destino: <input id="destino" type="text" size="30" id="Destino" name="Destino"/>

        Dia: <input id="dia" type="text" size="30" id="Dia" name="Dia"/>


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
