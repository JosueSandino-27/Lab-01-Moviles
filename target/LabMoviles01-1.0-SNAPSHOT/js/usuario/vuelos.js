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

function cargar_vuelos(index) {

    var json = JSON.stringify({
        "action": "cargar_lista_vuel",
        "valor": index
    });
    websocket.send(json);

}

function cargarLista_vuelos(lista) {
    var list = $("#tbody_vuelo");
    for (var i = 0; i < lista.length; i++) {
        var tr = $('<tr/>');
        tr.html("<td>" + lista[i].dia + "</td>" +
                "<td>" + lista[i].horaSalida1 + "</td>" +
                "<td>" + lista[i].horaLlegada1 + "</td>" +
                "<td>" + lista[i].avion1 + "</td>" +
                "<td>" + lista[i].CiudadOrigen1 + "</td>" +
                "<td>" + lista[i].CiudadDestino1 + "</td>" +
                "<td><a href='SeleccionarAsientos.jsp' class'btn btn-primary' id='" + lista[i].numero + "'>" + "Comprar" + "</a></td>");
        list.append(tr);
    }
}

function buscar_ID(){
    
    var origen = document.getElementById("origen").value;
    var destino= document.getElementById("destino").value;
    
    if(origen === "" && destino === "" ){
        cargar_vuelos("1");
    }
    if(origen !== "" && destino === ""){
        cargar_vuelos("2");
    }
    if(origen === "" && destino !== ""){
        cargar_vuelos("3");
    }
    if(origen !== "" && destino !== ""){
        cargar_vuelos("4");
    }
    
       
}

