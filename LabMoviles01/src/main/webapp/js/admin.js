var wsUri = "ws://" + document.location.host + "/LabMoviles01/" + "controller_paises";
var websocket = new WebSocket(wsUri);
var paises = {};

websocket.onopen = function (evt) {
    console.log("Connected to " + wsUri + JSON.stringify(evt));
};

websocket.onmessage = function (evt) {
    console.log("Messge -> " + evt.data);
    validarMensaje(evt);
};


function validarMensaje(evt) {

    if (evt.data.length > 3) {
        if (evt.data !== "Coneccion Establecida") {
            var paises = JSON.parse(evt.data);
            console.log(paises);
            cargarLista(paises);
        }
    }
}


//-------------------------------------CRUD
function cargar_paises() {
    var json = JSON.stringify({
        "action": "cargar_lista"
    });
    websocket.send(json);
}

function insertarPais() {
    var json = JSON.stringify({
        "action": "insertar_pais",
        "siglas": document.getElementById("siglas_i").value,
        "nombrePais": document.getElementById("nombrePais_i").value
    });

    websocket.send(json);
    $("#modal_insert_paises").modal("hide");
    location.reload();

}

function eliminarPais(siglas) {

    var json = JSON.stringify({
        "action": "eliminar_pais",
        "siglas": siglas.id
    });
    
    websocket.send(json);
    $("#modal_paises").modal("hide");
    location.reload();
}

function reload(){
    location.reload();
}

function cargarLista(paises) {
    
    var list = $("#tbody123");

    for (var i = 0; i < paises.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + paises[i].siglas + "</td>" +
                "<td>" + paises[i].nombrePais + "</td>" +
                "<td><a href='#' onclick='eliminarPais(" + paises[i].siglas + ")' class'btn btn-primary' id='" + paises[i].siglas + "'>" + "Eliminar" + "</a></td>");
        list.append(tr);
    }
}


$(document).ready(function () {

    $("#a_aviones").click(function () {
        $("#modal_aviones").modal("show");
    });

    $("#a_paises").click(function () {
        $("#modal_paises").modal("show");
    });

    $("#a_ciudades").click(function () {
        $("#modal_ciudades").modal("show");
    });

    $("#a_vuelos").click(function () {
        $("#modal_vuelos").modal("show");
    });

    $("#a_tipoAviones").click(function () {
        $("#modal_tipoAviones").modal("show");
    });

    $("#btn_insert_pais").click(function () {
        $("#modal_insert_paises").modal("show");
        $("#modal_paises").modal("hide");
    });





});

