
  
# Lab-01-Moviles


# Procedimientos Pais
DELIMITER // create PROCEDURE insertar_Pais( IN AUX_siglas varchar(20), IN AUX_nombrePais varchar(20)) begin insert into proyecto2.pais(siglas,nombrePais) VALUES (AUX_siglas,AUX_nombrePais); end //

-- LISTAR DELIMITER // create procedure listar_paises() BEGIN SELECT * FROM proyecto2.pais; END //

DELIMITER // create procedure eliminar_pais( IN AUX_nombrePais varchar(20) ) BEGIN delete from proyecto2.pais where nombrePais = AUX_nombrePais; END //

DELIMITER // create procedure modificar_pais( IN AUX_siglas varchar(20), IN AUX_nombrePais varchar(20)) BEGIN UPDATE proyecto2.pais SET nombrePais = AUX_nombrePais WHERE siglas = AUX_siglas; END //

# Procedimientos Ciudad
DELIMITER // create PROCEDURE insertar_ciudad( IN AUX_nombre varchar(20), IN AUX_siglas_pais varchar(20)) begin insert into proyecto2.ciudad(nombre,Pais) VALUES (AUX_nombre,AUX_siglas_pais); end //

-- LISTAR DELIMITER // create procedure listar_ciudades() BEGIN SELECT * FROM proyecto2.ciudad; END //

DELIMITER // create procedure eliminar_ciudad( IN AUX_nombre varchar(20) ) BEGIN delete from proyecto2.ciudad where nombre = AUX_nombre; END //

DELIMITER // create procedure modificar_ciudad( IN AUX_nombre varchar(20), IN AUX_siglas_pais varchar(20)) BEGIN UPDATE proyecto2.ciudad SET Pais = AUX_siglas_pais WHERE nombre = AUX_nombre; END //

# Procedimientos Tipo Avion
DELIMITER // create PROCEDURE insertar_tipoAvion( IN AUX_cantidadFilas int, IN AUX_cantidadColumnas int, IN AUX_codigo varchar(45), IN AUX_nombreTipo varchar(45), IN AUX_annio int, IN AUX_marca varchar(45), IN AUX_modelo varchar(45), IN AUX_cantAsientos int) BEGIN insert into proyecto2.tipoavion(cantidadFilas, cantidadColumnas, codigo, nombreTipo, annio,marca,modelo, cantAsientos) VALUES (AUX_cantidadFilas, AUX_cantidadColumnas, AUX_codigo,AUX_nombreTipo,AUX_annio,AUX_marca, AUX_modelo,AUX_cantAsientos); END//

DELIMITER // create procedure listar_tiposAviones() BEGIN SELECT * FROM proyecto2.tipoAvion; END //

DELIMITER // create procedure eliminar_tipoAvion( IN AUX_codigo varchar(45) ) BEGIN delete from proyecto2.tipoAvion where codigo = AUX_codigo; END //

DELIMITER // create procedure modificar_tipoAvion(IN AUX_cantidadFilas int, IN AUX_cantidadColumnas int, IN AUX_codigo varchar(45), IN AUX_nombreTipo varchar(45), IN AUX_annio int, IN AUX_marca varchar(45), IN AUX_modelo varchar(45), IN AUX_cantAsientos int) BEGIN UPDATE proyecto2.tipoavion SET cantidadFilas = AUX_cantidadFilas, cantidadColumnas =AUX_cantidadColumnas, nombreTipo = AUX_nombreTipo, annio = AUX_annio, marca = AUX_marca, modelo = AUX_modelo, cantAsientos = AUX_cantAsientos WHERE codigo = AUX_codigo; END //

# Procedimientos Avion
DELIMITER // create PROCEDURE insertar_avion( IN AUX_codigo varchar(20), IN AUX_nombreAvion varchar(20), IN AUX_tipoAvion varchar(20)) begin insert into proyecto2.avion(codigo,nombreAvion, tipoavion) VALUES (AUX_codigo,AUX_nombreAvion, AUX_tipoAvion); end //

-- LISTAR DELIMITER // create procedure listar_aviones() BEGIN SELECT * FROM proyecto2.avion; END //

DELIMITER // create procedure eliminar_avion( IN AUX_codigo varchar(20) ) BEGIN delete from proyecto2.avion where codigo = AUX_codigo; END //

DELIMITER // create procedure modificar_avion( IN AUX_codigo varchar(20), IN AUX_nombreAvion varchar(20), IN AUX_tipoAvion varchar(20)) BEGIN UPDATE proyecto2.avion SET nombreAvion = AUX_nombreAvion, TipoAvion = AUX_tipoAvion WHERE codigo = AUX_codigo; END //

# Procedimientos Vuelo
DELIMITER // create PROCEDURE insertar_vuelo( IN AUX_numero int, IN AUX_dia varchar(20), IN AUX_horaSalida varchar(20), IN Avion varchar(20), IN horaLlegada time, IN CiudadOrigen varchar(20), IN CiudadDestino varchar(20)) begin insert into proyecto2.vuelo(numero,dia, horaSalida,Avion, horaLlegada, CiudadOrigen, CiudadDestino) VALUES (AUX_numero,AUX_dia, AUX_horaSalida, Avion, horaLlegada,CiudadOrigen,CiudadDestino); end //

-- LISTAR DELIMITER // create procedure listar_vuelos() BEGIN SELECT * FROM proyecto2.vuelo; END //

DELIMITER // create procedure eliminar_vuelo( IN AUX_numero varchar(20) ) BEGIN delete from proyecto2.vuelo where numero = AUX_numero; END //

DELIMITER // create procedure modificar_vuelo( IN AUX_numero int, IN AUX_dia varchar(20), IN AUX_horaSalida varchar(20), IN Avion varchar(20), IN horaLlegada time, IN CiudadOrigen varchar(20), IN CiudadDestino varchar(20)) BEGIN UPDATE proyecto2.vuelo SET dia = AUX_dia, horaSalida = AUX_horaSalida, Avion = Avion, horaLlegada = horaLlegada, CiudadOrigen = CiudadOrigen, CiudadDestino = CiudadDestino WHERE numero = AUX_numero; END //

# Procedimientos Reservas
---LISTAR RESERVAS DELIMITER // CREATE PROCEDURE insertar_reserva1( IN Tpago int, IN viaje int, IN Idusuario varchar(200), IN Asien varchar(200), IN viaj varchar(200)) begin insert into proyecto2.reserva(TipoPago_codigoTipoPago,Viaje_numero,Usuario_idUsuario,Asiento,Viajero) VALUES (Tpago,viaje,Idusuario,Asien,viaj); END //

# Procedimientos Usuario
DELIMITER //
create PROCEDURE verificar_usuario(
In AUX_nombreUsuario varchar(45),
IN AUX_contrasena varchar(45))
BEGIN
SELECT * FROM proyecto2.usuario WHERE nombreusuario = AUX_nombreUsuario  AND contrasena = AUX_contrasena; 
END//


© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
