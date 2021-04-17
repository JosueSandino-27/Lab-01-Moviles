var wsUri = "ws://" + document.location.host + "/LabMoviles01/" + "controller_paises";
var websocket = new WebSocket(wsUri);
var paises = {};
var ciudades = {};
var tipoAviones = {};
var aviones = {};
var vuelos = {};
var x = {};

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
            if (x[0].cantidadFilas !== undefined) {
                console.log("Cargando TipoAviones");
                tipoAviones = JSON.parse(evt.data);
                cargarLista_tipoAviones(tipoAviones);
            }
            if (x[0].tipoAvionString !== undefined) {
                console.log("Cargando Aviones");
                aviones = JSON.parse(evt.data);
                cargarLista_aviones(aviones);
            }
            if (x[0].numero !== undefined && x[0].dia !== undefined) {
                console.log("Cargando Vuelos");
                vuelos = JSON.parse(evt.data);
                cargarLista_vuelos(vuelos);
            }

        }
    }
}

//-------------------------------------CRUD Vuelos

function cargar_vuelos() {

    var json = JSON.stringify({
        "action": "cargar_lista_vuelos"
    });
    websocket.send(json);

}

function cargarLista_vuelos(lista) {
    var list = $("#tbody_vuelo");
    for (var i = 0; i < lista.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + lista[i].numero + "</td>" +
                "<td>" + lista[i].dia + "</td>" +
                "<td>" + lista[i].horaSalida1 + "</td>" +
                "<td>" + lista[i].horaLlegada1 + "</td>" +
                "<td>" + lista[i].avion1 + "</td>" +
                "<td>" + lista[i].CiudadOrigen1 + "</td>" +
                "<td>" + lista[i].CiudadDestino1 + "</td>" +
                "<td><a href='#' onclick='eliminarVuelo(" + lista[i].numero + ")' class'btn btn-primary' id='" + lista[i].numero + "'>" + "Eliminar" + "</a></td>");
        list.append(tr);
    }
}

function insertarVuelo() {
    var json = JSON.stringify({
        "action": "insertar_vuelo",
        "numero": document.getElementById("numeroV_i").value,
        "dia": document.getElementById("diaV_i").value,
        "horaSalida": document.getElementById("horaSalidaV_i").value,
        "horaLlegada": document.getElementById("horaLLegadaV_i").value,
        "avion": document.getElementById("avionV_i").value,
        "CiudadOrigen": document.getElementById("ciudadOrigenV_i").value,
        "CiudadDestino": document.getElementById("ciudadDestinoV_i").value

    });

    websocket.send(json);
    $("#modal_insert_vuelos").modal("hide");
    location.reload();

}


function eliminarVuelo(siglas) {

    var json = JSON.stringify({
        "action": "eliminar_vuelo",
        "numero": siglas.toString()
    });

    websocket.send(json);
    $("#modal_vuelos").modal("hide");
    location.reload();
}



//-------------------------------------CRUD Paises

function cargar_paises() {

    var json = JSON.stringify({
        "action": "cargar_lista_paises"
    });
    websocket.send(json);

}

function cargarLista_paises(paises) {
    var list = $("#tbody123");
    for (var i = 0; i < paises.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + paises[i].siglas + "</td>" +
                "<td>" + paises[i].nombrePais + "</td>" +
                "<td><a href='#' onclick='eliminarPais(" + paises[i].siglas + ")' class'btn btn-primary' id='" + paises[i].siglas + "'>" + "Eliminar" + "</a></td>");
        list.append(tr);
    }
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

//-------------------------------------CRUD Tipo Aviones

function cargar_tipoAviones() {

    var json = JSON.stringify({
        "action": "cargar_lista_tipoAviones"
    });
    websocket.send(json);
}

function cargarLista_tipoAviones(lista) {

    var list = $("#tbody_tipoAvion");

    for (var i = 0; i < lista.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + lista[i].codigo + "</td>" +
                "<td>" + lista[i].marca + "</td>" +
                "<td>" + lista[i].modelo + "</td>" +
                "<td>" + lista[i].cantAsientos + "</td>" +
                "<td>" + lista[i].nombreTipo + "</td>" +
                "<td>" + lista[i].cantidadFilas + "</td>" +
                "<td>" + lista[i].cantidadColumnas + "</td>" +
                "<td>" + lista[i].annio + "</td>" +
                "<td><a href='#' onclick='eliminarTipoAvion(" + lista[i].codigo + ")' class'btn btn-primary' id='" + lista[i].codigo + "'>" + "Eliminar" + "</a></td>");
        list.append(tr);
    }
}

function insertarTipoAvion() {
    var json = JSON.stringify({
        "action": "insertar_tipoAvion",
        "marca": document.getElementById("marca_i").value,
        "modelo": document.getElementById("modelo_i").value,
        "cantAsientos": document.getElementById("cA_i").value,
        "codigo": document.getElementById("codigo_i").value,
        "nombreTipo": document.getElementById("nombreTipo_i").value,
        "cantidadFilas": document.getElementById("cF_i").value,
        "annio": document.getElementById("annio_i").value,
        "cantidadColumnas": document.getElementById("cC_i").value
    });

    websocket.send(json);
    $("#modal_insert_TipoAvion").modal("hide");
    location.reload();

}

function eliminarTipoAvion(siglas) {

    var json = JSON.stringify({
        "action": "eliminar_tipoAvion",
        "codigo": siglas.toString()
    });

    console.log(json);
    websocket.send(json);
    $("#modal_tipoAviones").modal("hide");
    location.reload();
}


//-------------------------------------CRUD  Aviones

function cargar_aviones() {

    var json = JSON.stringify({
        "action": "cargar_lista_aviones"
    });
    websocket.send(json);
}

function cargarLista_aviones(lista) {

    var list = $("#tbody_avion");

    for (var i = 0; i < lista.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + lista[i].codigo + "</td>" +
                "<td>" + lista[i].nombreAvion + "</td>" +
                "<td>" + lista[i].tipoAvionString + "</td>" +
                "<td><a href='#' onclick='eliminarAvion(" + lista[i].codigo + ")' class'btn btn-primary' id='" + lista[i].codigo + "'>" + "Eliminar" + "</a></td>");
        list.append(tr);
    }
}

function insertarAvion() {
    var json = JSON.stringify({
        "action": "insertar_avion",
        "codigo": document.getElementById("codigoA_i").value,
        "nombre": document.getElementById("nombreAvionA_i").value,
        "tipo": document.getElementById("tipoAvionA_i").value
    });

    websocket.send(json);
    $("#modal_insert_aviones").modal("hide");
    location.reload();

}

function eliminarAvion(siglas) {

    var json = JSON.stringify({
        "action": "eliminar_Avion",
        "codigo": siglas.toString()
    });

    console.log(json);
    websocket.send(json);
    $("#modal_insert_aviones").modal("hide");
    location.reload();
}



function reload() {
    location.reload();
}
