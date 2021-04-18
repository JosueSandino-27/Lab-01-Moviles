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
    <body onload='cargar_vuelos()'>

        <div>
            <p id="or">Origen: <input autocomplete="off" id="origen" type="text" size="20"  name="Origen"/></p>
            <p id="des">Destino: <input autocomplete="off" id="destino" type="text" size="20" name="Destino"/></p>
            <p id="d">Dia: <select name="dia" id="dia">
                    <option value="Lunes">Lunes</option>
                    <option value="Martes">Martes</option>
                    <option value="Miercoles">Miercoles</option>
                    <option value="Jueves">Jueves</option>
                    <option value="Viernes">Viernes</option>
                    <option value="Sabado">Sabado</option>
                    <option value="Domingo">Domingo</option>
                </select>
            </p>

            <button type="button" id="buscar" onclick="buscar_ID()">Buscar</button>
        </div>
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