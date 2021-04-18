var wsUri = "ws://" + document.location.host + "/LabMoviles01/" + "controller_paises";
var websocket = new WebSocket(wsUri);
var paises = {};
var ciudades = {};
var tipoAviones = {};
var aviones = {};
var vuelos = {};
var viajes = {};
var reservas = {};
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
            if (x[0].fecha1 !== undefined) {
                console.log("Cargando Viajes");
                viajes = JSON.parse(evt.data);
                cargarLista_viajes(viajes);
            }
            if (x[0].tipoPagocodigoTipoPago1 !== undefined) {
                console.log("Cargando Resevas");
                reservas = JSON.parse(evt.data);
                console.log(reservas);
                cargarLista_reservas(reservas)
            }
        }
    }
}


//-------------------------------------CRUD RESERVA

function cargar_reservas() {

    var json = JSON.stringify({
        "action": "cargar_lista_reservas"
    });
    websocket.send(json);

}

function cargarLista_reservas(lista) {
    var list = $("#tbody_reservas");
    for (var i = 0; i < lista.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + lista[i].numeroReservas + "</td>" +
                "<td>" + lista[i].tipoPagocodigoTipoPago1 + "</td>" +
                "<td>" + lista[i].viajenumero1 + "</td>" +
                "<td>" + lista[i].usuarioidUsuario1 + "</td>" +
                "<td>" + lista[i].asiento + "</td>" +
                "<td>" + lista[i].viajero + "</td>" +
                "<td><a href='#' onclick='eliminarReserva(" + lista[i].numeroReservas + ")' class'btn btn-primary' id='" + lista[i].numeroReservas + "'>" + "Eliminar" + "</a></td>" +
                "<td><a href='#' onclick='modificarViaje_modal(" + lista[i].numero + ")' class'btn btn-primary' id='" + lista[i].numero + "1" + "'>" + "Modificar" + "</a></td>");

        list.append(tr);
    }
}
function insertarReserva() {
    var json = JSON.stringify({
        "action": "insertar_reserva",
//        "numeroReservas": document.getElementById("nR_i").value,
        "tipoPagocodigoTipoPago1": document.getElementById("tp_i").value,
        "viajenumero1": document.getElementById("nVR_i").value,
        "usuarioidUsuario1": document.getElementById("iduR_i").value,
        "asiento": document.getElementById("nAR_i").value,
        "viajero": document.getElementById("nVrr_i").value
    });

    websocket.send(json);
    $("#modal_insert_reservas").modal("hide");
    location.reload();

}


function eliminarReserva(siglas) {
    
    var json = JSON.stringify({
        "action": "eliminar_reserva",
        "numero": siglas.toString()
    });

    websocket.send(json);
    $("#modal_reserva").modal("hide");
    location.reload();
}




//-------------------------------------CRUD Viajes

function cargar_viajes() {

    var json = JSON.stringify({
        "action": "cargar_lista_viajes"
    });
    websocket.send(json);

}

function cargarLista_viajes(lista) {
    var list = $("#tbody_viajes");
    for (var i = 0; i < lista.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + lista[i].numero + "</td>" +
                "<td>" + lista[i].precio + "</td>" +
                "<td>" + lista[i].fecha1 + "</td>" +
                "<td>" + lista[i].asientosDisponibles + "</td>" +
                "<td>" + lista[i].vuelo1 + "</td>" +
                "<td><a href='#' onclick='eliminarViaje(" + lista[i].numero + ")' class'btn btn-primary' id='" + lista[i].numero + "'>" + "Eliminar" + "</a></td>" +
                "<td><a href='#' onclick='modificarViaje_modal(" + lista[i].numero + ")' class'btn btn-primary' id='" + lista[i].numero + "1" + "'>" + "Modificar" + "</a></td>");
        list.append(tr);
    }
}

function modificarViaje_modal(siglas) {

    document.getElementById("n_iVM").value = siglas.toString();

    $("#modal_modificar_viajes").modal("show");
    $("#modal_viajes").modal("hide");
}


function modificarViaje() {
    var json = JSON.stringify({
        "action": "modificar_pais",
        "numero": document.getElementById("n_iVM").value,
        "precio": document.getElementById("p_iVM").value,
        "fecha": document.getElementById("f_iVM").value,
        "aD": document.getElementById("ad_iVM").value,
        "vuelo": document.getElementById("v_iVM").value
    });

    websocket.send(json);
    $("#modal_modificar_viajes").modal("hide");
    location.reload();
}

function insertarViaje() {
    var json = JSON.stringify({
        "action": "insertar_viaje",
        "precio": document.getElementById("p_iV").value,
        "fecha": document.getElementById("f_iV").value,
        "aD": document.getElementById("ad_iV").value,
        "vuelo": document.getElementById("v_iV").value
    });


    websocket.send(json);
    $("#modal_insert_viajes").modal("hide");
    location.reload();

}

function eliminarViaje(siglas) {

    var json = JSON.stringify({
        "action": "eliminar_pais",
        "numero": siglas.toString()
    });

    websocket.send(json);
    $("#modal_viajes").modal("hide");
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
                "<td><a href='#' onclick='eliminarPais(" + paises[i].siglas + ")' class'btn btn-primary' id='" + paises[i].siglas + "'>" + "Eliminar" + "</a></td>" +
                "<td><a href='#' onclick='modificarPais_modal(" + paises[i].siglas + ")' class'btn btn-primary' id='" + paises[i].siglas + "1" + "'>" + "Modificar" + "</a></td>");
        list.append(tr);
    }
}

function modificarPais_modal(siglas) {
    console.log(siglas.id);

    document.getElementById("siglas_M").value = siglas.id;

    $("#modal_modificar_paises").modal("show");
    $("#modal_paises").modal("hide");
}


function modificarPais() {
    var json = JSON.stringify({
        "action": "modificar_pais",
        "siglas": document.getElementById("siglas_M").value,
        "nombrePais": document.getElementById("nombrePais_M").value
    });

    websocket.send(json);
    $("#modal_modificar_paises").modal("hide");
    location.reload();
}

function insertarPais() {
    var json = JSON.stringify({
        "action": "insertar_pais",
        "siglas": document.getElementById("siglas_iA").value,
        "nombrePais": document.getElementById("nombrePais_iA").value
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
                "<td><a href='#' onclick='eliminarCiudad(" + ciudades[i].nombre + ")' class'btn btn-primary' id='" + ciudades[i].nombre + "'>" + "Eliminar" + "</a></td>" +
                "<td><a href='#' onclick='modificarCiudad_modal(" + ciudades[i].nombre + ")' class'btn btn-primary' id='" + ciudades[i].nombre + "1" + "'>" + "Modificar" + "</a></td>");
        list.append(tr);
    }
}


function modificarCiudad_modal(siglas) {
    console.log(siglas.id);

    document.getElementById("nombre_iM").value = siglas.id;

    $("#modal_modificar_ciudades").modal("show");
    $("#modal_ciudades").modal("hide");

}

function modificarCiudad() {
    var json = JSON.stringify({
        "action": "modificar_ciudad",
        "nombre": document.getElementById("nombre_iM").value,
        "Pais": document.getElementById("Pais_iM").value
    });

    websocket.send(json);
    $("#modal_modificar_ciudades").modal("hide");
    location.reload();
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
                "<td><a href='#' onclick='eliminarTipoAvion(" + lista[i].codigo + ")' class'btn btn-primary' id='" + lista[i].codigo + "'>" + "Eliminar" + "</a></td>" +
                "<td><a href='#' onclick='modificarTipoAvion_modal(" + lista[i].codigo + ")' class'btn btn-primary' id='" + lista[i].codigo + "'>" + "Modificar" + "</a></td>");
        list.append(tr);
    }
}

function modificarTipoAvion_modal(siglas) {
    document.getElementById("codigo_iM").value = siglas.toString();

    $("#modal_modificar_TipoAvion").modal("show");
    $("#modal_tipoAviones").modal("hide");

}

function modificarTipoAvion() {
    var json = JSON.stringify({
        "action": "modificar_tipoAvion",
        "marca": document.getElementById("marca_iM").value,
        "modelo": document.getElementById("modelo_iM").value,
        "cantAsientos": document.getElementById("cA_iM").value,
        "codigo": document.getElementById("codigo_iM").value,
        "nombreTipo": document.getElementById("nombreTipo_iM").value,
        "cantidadFilas": document.getElementById("cF_iM").value,
        "annio": document.getElementById("annio_iM").value,
        "cantidadColumnas": document.getElementById("cC_iM").value
    });

    websocket.send(json);
    $("#modal_modificar_TipoAvion").modal("hide");
    location.reload();
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
                "<td><a href='#' onclick='eliminarAvion(" + lista[i].codigo + ")' class'btn btn-primary' id='" + lista[i].codigo + "'>" + "Eliminar" + "</a></td>" +
                "<td><a href='#' onclick='modificarAvion_modal(" + lista[i].codigo + ")' class'btn btn-primary' id='" + lista[i].codigo + "'>" + "Modificar" + "</a></td>");
        list.append(tr);
    }
}

function modificarAvion_modal(siglas) {
    document.getElementById("codigoA_iM").value = siglas.toString();

    $("#modal_modificar_aviones").modal("show");
    $("#modal_aviones").modal("hide");

}

function modificarAvion() {
    var json = JSON.stringify({
        "action": "modificar_avion",
        "codigo": document.getElementById("codigoA_iM").value,
        "nombre": document.getElementById("nombreAvionA_iM").value,
        "tipo": document.getElementById("tipoAvionA_iM").value
    });

    websocket.send(json);
    $("#modal_modificar_aviones").modal("hide");
    location.reload();
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
                "<td><a href='#' onclick='eliminarVuelo(" + lista[i].numero + ")' class'btn btn-primary' id='" + lista[i].numero + "'>" + "Eliminar" + "</a></td>" +
                "<td><a href='#' onclick='modificarVuelo_modal(" + lista[i].numero + ")' class'btn btn-primary' id='" + lista[i].numero + "'>" + "Modificar" + "</a></td>");
        list.append(tr);
    }
}

function modificarVuelo_modal(siglas) {
    document.getElementById("numeroV_iM").value = siglas.toString();

    $("#modal_modificar_vuelo").modal("show");
    $("#modal_vuelos").modal("hide");

}

function modificarVuelo() {
    var json = JSON.stringify({
        "action": "modificar_vuelo",
        "numero": document.getElementById("numeroV_iM").value,
        "dia": document.getElementById("diaV_iM").value,
        "horaSalida": document.getElementById("horaSalidaV_iM").value,
        "horaLlegada": document.getElementById("horaLLegadaV_iM").value,
        "avion": document.getElementById("avionV_iM").value,
        "CiudadOrigen": document.getElementById("ciudadOrigenV_iM").value,
        "CiudadDestino": document.getElementById("ciudadDestinoV_iM").value
    });

    websocket.send(json);
    $("#modal_modificar_vuelo").modal("hide");
    location.reload();
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






function reload() {
    location.reload();
}
