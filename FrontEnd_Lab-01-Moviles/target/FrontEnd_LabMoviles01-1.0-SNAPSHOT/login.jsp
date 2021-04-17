<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/websocket.js" type="text/javascript"></script>
        <link href="style/login.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>


        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->

                <!-- Icon -->
                <div class="fadeIn first">
                    <h2>Login</h2>
                </div>

                <!-- Login Form -->
                <form>
                    <input type="text" class="fadeIn second" id="username" name="username" autocomplete="off" placeholder="Nombre de Usuario">
                    <input type="text" class="fadeIn third" id="password" name="password" autocomplete="off" placeholder="Contraseña">

                </form>
                <button class="btn btn-primary fadeIn fourth" onclick="login()">Iniciar sesion</button>

                <div id="formFooter">
                    <a class="underlineHover" href="#">Registrarse</a>
                </div>

            </div>
        </div>
    </body>
</html>
