

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
    
    $("#btn_insert_ciudad").click(function () {
        $("#modal_insert_ciudades").modal("show");
        $("#modal_ciudades").modal("hide");
    });





});



