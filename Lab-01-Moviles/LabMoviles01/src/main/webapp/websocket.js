var wsUri = "ws://" + document.location.host + document.location.pathname + "endpoint";
var websocket = new WebSocket(wsUri);


// ON OPEN
websocket.onopen = function(evt) { console.log("Connected to " + wsUri + JSON.stringify(evt)); };

// ON MESSAGE
websocket.onmessage = function(evt) {  console.log("Messge -> " + evt.data); };

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
