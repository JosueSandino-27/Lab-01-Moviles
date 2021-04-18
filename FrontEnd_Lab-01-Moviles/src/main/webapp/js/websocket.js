var wsUri = "ws://" + document.location.host + "/LabMoviles01/endpoint";
var websocket = new WebSocket(wsUri);


// ON OPEN
websocket.onopen = function(evt) { console.log("Connected to " + wsUri + JSON.stringify(evt)); };

// ON MESSAGE
websocket.onmessage = function(evt) {  
    console.log("Messge -> " + evt.data);    
    validarMensaje(evt);
};

// ON ERROR
websocket.onerror = function(evt) { console.log("Error -> "+ evt.data); };

// SENT 
function login(){
    console.log(document.getElementById("username").value);
    console.log(document.getElementById("password").value);
    var json = JSON.stringify({
        "username":document.getElementById("username").value,
        "password":document.getElementById("password").value
    });
    sendText(json);
}

function sendText(message) {
    websocket.send(message);
}

function validarMensaje(evt){
    if(evt.data === "1"){
        window.location.replace("admin.html");
    }
    if(evt.data === "0"){
        window.location.replace("index.jsp?isAdmin=0");
        
    }   
}

//COMMIT