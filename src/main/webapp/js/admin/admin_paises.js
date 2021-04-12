var wsUri = "ws://" + document.location.host + "/LabMoviles01/" + "controller_paises";
var websocket = new WebSocket(wsUri);
var paises = {};
var ciudades = {};
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
            if(x[0].Pais !== undefined && x[0].nombre !== undefined){
                console.log("Cargando Ciudades");
                var ciudades = JSON.parse(evt.data);
                cargarLista_ciudades(ciudades);
            }
            
            
        }
    }
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



function reload() {
    location.reload();
}
