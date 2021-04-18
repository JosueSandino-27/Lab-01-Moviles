var wsUri = "ws://" + document.location.host + "/LabMoviles01/" + "controller_vuelos";
var websocket = new WebSocket(wsUri);



websocket.onopen = function (evt) {
    console.log("Connected to " + wsUri + JSON.stringify(evt));
};

websocket.onmessage = function (evt) {
    console.log("Message -> " + evt.data);
    listar_vuelos(evt);
};


function listar_vuelos(evt) {

    if (evt.data === "nada") {
        alert("no se encontraron vuelos con los parametros");
    } else {
        if (evt.data.length > 3) {
            if (evt.data !== "Coneccion Establecida") {
                x = JSON.parse(evt.data);
                if (x[0].numero !== undefined && x[0].dia !== undefined) {
                    console.log("Cargando Vuelos");
                    vuelos = JSON.parse(evt.data);
                    cargarLista_vuelos(vuelos);
                }
            }
        }
    }
}

function cargar_vuelos(index, origen, destino, dia) {

    var json = JSON.stringify({
        "action": "cargar_lista_vuel",
        "index": index,
        "origen": origen,
        "destino": destino,
        "dia": dia
    });
    setTimeout(() => websocket.send(json), 150);

}


function cargarLista_vuelos(lista) {
    
    $('#tabla > tbody').empty();
    var list = $("#tbody_vuelo");
    for (var i = 0; i < lista.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + lista[i].dia + "</td>" +
                "<td>" + lista[i].horaSalida1 + "</td>" +
                "<td>" + lista[i].horaLlegada1 + "</td>" +
                "<td>" + lista[i].avion1 + "</td>" +
                "<td>" + lista[i].CiudadOrigen1 + "</td>" +
                "<td>" + lista[i].CiudadDestino1 + "</td>" +
                "<td><button onclick='comprar()'  class'btn btn-primary' id='" + lista[i].numero + "'>" + "Comprar" + "</button></td>");
        list.append(tr);
    }
}

function comprar(){
    
    var data = localStorage.getItem("isAdmin"); 
    
    if( data === "0" ){
        window.location.replace("SeleccionarAsientos.jsp");
    }
    else{
        alert("Debe iniciar sesion");
    }
    
    
}

function buscar_ID() {

    var origen = document.getElementById("origen").value;
    var destino = document.getElementById("destino").value;
    var dia = document.getElementById("dia").value;

    if (origen === "" && destino === "") {
        cargar_vuelos("1", origen, destino, dia);
    }
    if (origen !== "" && destino === "") {
        cargar_vuelos("2", origen, destino, dia);
    }
    if (origen === "" && destino !== "") {
        cargar_vuelos("3", origen, destino, dia);
    }
    if (origen !== "" && destino !== "") {
        cargar_vuelos("4", origen, destino, dia);
    }


}