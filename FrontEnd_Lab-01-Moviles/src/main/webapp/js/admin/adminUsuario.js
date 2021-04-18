var wsUri = "ws://" + document.location.host + "/LabMoviles01/" + "usuario";
var websocket = new WebSocket(wsUri);

websocket.onopen = function (evt) {
    console.log("Connected to " + wsUri + JSON.stringify(evt));
};

websocket.onmessage = function (evt) {
    console.log("Message -> " + evt.data);
    validarMensaje(evt);
};

function insertarUsuario() {
    var json = JSON.stringify({
        "action": "insertar_usuario",
        "nombre": document.getElementById("nombre").value,
        "apellido": document.getElementById("apellido").value,
        "email": document.getElementById("email").value,
        "nacimiento": document.getElementById("nacimiento").value,
        "direccion": document.getElementById("direccion").value,
        "trabajo": document.getElementById("trabajo").value,
        "casa": document.getElementById("casa").value,
        "idUsuario": document.getElementById("idUsuario").value,
        "contrasena": document.getElementById("contrasena").value
    });

    websocket.send(json);
    
    window.location.replace("index.jsp");

}

