var wsUri = "ws://" + document.location.host + "/LabMoviles01/" + "controller_reservas";
var websocket = new WebSocket(wsUri);
var numeroBoletos = 0;
var x = {};
var i = 0;
var boletos = [];

websocket.onopen = function (evt) {
    console.log("Connected to " + wsUri + JSON.stringify(evt));
};

websocket.onmessage = function (evt) {
    console.log("Message -> " + evt.data);
};

//-------------------------------------CRUD reservas

function numero_boletos(){
    var checkboxes = document.querySelectorAll('input[type=checkbox]:checked');
    
    return checkboxes.length;
}

function cargar_reservas() {

    var checkboxes = document.querySelectorAll('input[type=checkbox]:checked');

    for (var i = 0; i < checkboxes.length; i++) {
        boletos.push(checkboxes[i].value);
    }
    
    localStorage.setItem("boleto", boletos);
    localStorage.setItem("boletos", checkboxes.length);

    window.location.replace("Boletos.jsp");
}

function getNumBoletos() {
    return numBoletos;
}

function cargar_form() {

    var data = localStorage.getItem("boletos");
    var bolet = localStorage.getItem("boleto");
    var res = bolet.split(",");
    var data1 = parseInt(data) - 1;
    
    if (validarCamposVacios()) {
        if (data1 > i) {
            var boleto = res[i];
            i++;
            var json = JSON.stringify({
                "action": "cargar_reservas",
                "nombre": document.getElementById("nombre").value,
                "apellido": document.getElementById("apellido").value,
                "tipoPago": document.getElementById("pago").value,
                "boleto" : boleto                     
            });

            websocket.send(json);
            let j = i + 1;
            document.getElementById("Boleto").innerHTML = "Boleto " + j;
            document.getElementById("nombre").value = "";
            document.getElementById("apellido").value = "";
        } else {
            show('popupk');
        }
    } else {
        alert("Llene los espacios en blanco");
        window.location.replace("Boletos.jsp");
    }

}



function validarCamposVacios() {

    if (document.getElementById("nombre").value === "") {
        return false;
    }
    if (document.getElementById("pago").value === "") {
        return false;
    }
    if (document.getElementById("apellido").value === "") {
        return false;
    }

    return true;
}





