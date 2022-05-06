create or replace trigger restriccionDeActualizarJugador 
before update on jugador 
for each row 
declare 
enfrentamientos number(5); 
begin 
select count(*) into enfrentamientos from partido where id_equipo1=:old.id_equipo or id_equipo2=:old.id_equipo; 
 
if enfrentamientos > 0 then 
raise_application_error(-20002,'ahora no puedes cambiar los datos del jugador porque los enfrentamientos del equipo a que el pertenece han sido creados'); 
end if; 
 
end restriccionDeActualizarJugador;

alter trigger restriccionDeActualizarJugador disable;



create or replace trigger restriccionDeActualizarEquipo 
before update on equipo 
for each row 
declare 
enfrentamientos number(5); 
begin 
select count(*) into enfrentamientos from partido where id_equipo1=:old.id_equipo or id_equipo2=:old.id_equipo; 
 
if enfrentamientos > 0 then 
raise_application_error(-20003,'ahora no puedes cambiar los datos del equipo porque los enfrentamientos del equipo han sido creados'); 
end if; 
 
end restriccionDeActualizarEquipo;


alter trigger restriccionDeActualizarEquipo disable;


/* PRUEBAS */

update jugador
SET apodo = 'paco'
WHERE id_equipo = 1;

update equipo
SET nombre_equipo = 'equipoPaco'
WHERE id_equipo = 1;





