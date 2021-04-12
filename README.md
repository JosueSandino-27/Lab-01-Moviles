# Lab-01-Moviles

# Procedimientos Pais

DELIMITER // 
create PROCEDURE insertar_Pais(
IN  AUX_siglas varchar(20), 
IN AUX_nombrePais varchar(20))
begin
insert into proyecto2.pais(siglas,nombrePais)
VALUES (AUX_siglas,AUX_nombrePais);
end //


-- LISTAR
DELIMITER //
create procedure listar_paises()
BEGIN 
	SELECT * FROM proyecto2.pais;
END //


DELIMITER //
create procedure eliminar_pais(
IN AUX_nombrePais varchar(20)
)
BEGIN 
	delete from proyecto2.pais 
    where nombrePais = AUX_nombrePais;
END //

DELIMITER //
create procedure modificar_pais(
IN  AUX_siglas varchar(20), 
IN AUX_nombrePais varchar(20))
BEGIN
UPDATE proyecto2.pais
SET
nombrePais = AUX_nombrePais WHERE siglas =  AUX_siglas;
END //


# Procedimientos Ciudad

DELIMITER // 
create PROCEDURE insertar_ciudad(
IN  AUX_nombre varchar(20), 
IN AUX_siglas_pais varchar(20))
begin
insert into proyecto2.ciudad(nombre,Pais)
VALUES (AUX_nombre,AUX_siglas_pais);
end //

-- LISTAR
DELIMITER //
create procedure listar_ciudades()
BEGIN 
	SELECT * FROM proyecto2.ciudad;
END //


DELIMITER //
create procedure eliminar_ciudad(
IN AUX_nombre varchar(20)
)
BEGIN 
	delete from proyecto2.ciudad 
    where nombre = AUX_nombre;
END //
