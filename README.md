# Lab-01-Moviles


DELIMITER // 
create PROCEDURE insertar_Pais(
IN  AUX_siglas varchar(20), 
IN AUX_nombrePais varchar(20))
begin
insert into proyecto2.pais(siglas,nombrePais)
VALUES (AUX_siglas,AUX_nombrePais);
end //
