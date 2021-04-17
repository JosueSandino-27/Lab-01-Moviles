<%-- 
    Document   : principal
    Created on : Apr 14, 2021, 11:51:49 PM
    Author     : Carlos
--%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/websocket.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <form>
                <table id="tabla_login">
                    <tr>
                        <td>
                            <input type="text" size="30" required="required"
                                   id="username" name="username" autocomplete="off" placeholder="Nombre de Usuario"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="password" size="30" required="required"
                                   id="password" name="password" autocomplete="off" placeholder="Contraseña"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                          
                        </td>
                    </tr>
                </table>
            </form>   
              <button class="controles" onclick="login()">Iniciar sesion</button>
        
        </div>
    </body>
</html>
