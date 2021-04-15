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
    validarMensaje(evt);
};


function validarMensaje(evt) {

    if (evt.data.length > 3) {
        if (evt.data !== "Coneccion Establecida") {
            x = JSON.parse(evt.data);

            if (x[0].siglas !== undefined) {
                console.log("Cargando Paises");
                var paises = JSON.parse(evt.data);
                cargarLista_paises(paises);
            }
            if (x[0].Pais !== undefined && x[0].nombre !== undefined) {
                console.log("Cargando Ciudades");
                var ciudades = JSON.parse(evt.data);
                cargarLista_ciudades(ciudades);
            }


        }
    }
}

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
            window.location.replace("Boletos.jsp");
        }
    } else {
        alert("Llene los espacios en blanco");
        window.location.replace("Boletos.jsp")
    }

}

function enviar_reservas() {
    var json = JSON.stringify({
        "action": "insertar_pais",
        "siglas": document.getElementById("siglas_i").value,
        "nombrePais": document.getElementById("nombrePais_i").value
    });

    websocket.send(json);
    $("#modal_insert_paises").modal("hide");
    location.reload();

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

//-------------------------------------CRUD Ciudades

function cargar_ciudades() {

    var json = JSON.stringify({
        "action": "cargar_lista_ciudades"
    });
    websocket.send(json);
}

function cargarLista_ciudades(ciudades) {

    var list = $("#tbody_ciudad");

    for (var i = 0; i < ciudades.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + ciudades[i].nombre + "</td>" +
                "<td>" + ciudades[i].Pais + "</td>" +
                "<td><a href='#' onclick='eliminarCiudad(" + ciudades[i].nombre + ")' class'btn btn-primary' id='" + ciudades[i].nombre + "'>" + "Eliminar" + "</a></td>");
        list.append(tr);
    }
}

function insertarCiudad() {
    var json = JSON.stringify({
        "action": "insertar_ciudad",
        "nombre": document.getElementById("nombre_i").value,
        "Pais": document.getElementById("Pais_i").value
    });

    websocket.send(json);
    $("#modal_insert_ciudades").modal("hide");
    location.reload();

}

function eliminarCiudad(siglas) {

    var json = JSON.stringify({
        "action": "eliminar_ciudad",
        "nombre": siglas.id
    });

    console.log(json);
    websocket.send(json);
    $("#modal_ciudades").modal("hide");
    location.reload();
}



function reload() {
    location.reload();
}



