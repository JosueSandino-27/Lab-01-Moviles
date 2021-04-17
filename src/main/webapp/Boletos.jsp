<%-- 
    Document   : Boletos
    Created on : Apr 13, 2021, 8:24:22 PM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <script src="js/usuario/usuario_seleccion.js" type="text/javascript"></script>
        <script src="js/usuario/popup.js" type="text/javascript"></script>
    </head>
    <body>
          <h1 id="Boleto">Boleto 1</h1>
          <div class="row" id="row">
              <div class="col-md-6">
                  <div class="form-group">
                      <input type="text" class="form-control" id="nombre" placeholder="Name">
                  </div>
              </div>
              <div class="col-md-6">
                  <div class="form-group">Forma de Pago: 
                      <select name="example" id="pago">
                          <option value="2">Tarjeta</option>
                          <option value="3">Efectivo</option>
                      </select>
                  </div>
              </div>
              <div class="col-md-12">
                  <div class="form-group">
                      <input type="text" class="form-control" id="apellido" placeholder="Last name">
                  </div>
              </div>
              <div class="col-md-12">
                  <button onclick="cargar_form()" type="button" class="btn btn-primary full-width">Confirmar</button>
              </div>
          </div> 

        <div id="pop">
            
            <div class="popupk" id="popupk">
                <p>Se compraron los asientos con éxito!</p>
                <a href="index.jsp" onclick="hide('popupk')">Ok</a>
            </div>
        </div>

    </body>
</html>
