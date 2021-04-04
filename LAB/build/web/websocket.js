var wsUri = "ws://" + document.location.host + document.location.pathname + "endpoint";
var websocket = new WebSocket(wsUri);


// ON OPEN
websocket.onopen = function(evt) { onOpen(evt); };

function onOpen() {
    writeToScreen("Connected to " + wsUri);
}

// ON MESSAGE
websocket.onmessage = function(evt) {  onMessage(evt); };

function onMessage(evt){
      writeToScreen("OnMessage -> "+ evt.data);
}

// SENT 
function login(){
    var json = JSON.stringify({
        "username":document.getElementById("username").value,
        "password":document.getElementById("password").value
    });
    sendText(json);
}

function sendText(message) {
    websocket.send(message);
}


// OTHER

function writeToScreen(message) {
    console.log(message);
};

// ON ERROR
websocket.onerror = function(evt) { onError(evt); };

function onError(evt) {
    writeToScreen("Error -> " + evt.data);
}