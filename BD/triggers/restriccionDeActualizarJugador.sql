create or replace trigger restriccionDeActualizarJugador 
before insert or update or delete on jugador 
for each row 
declare 
estadoLiga liga.estado%type;
begin 

select estado into estadoLiga from liga;
if estadoliga = 'CERRADO' then
raise_application_error(-20003,'ahora no puedes cambiar los datos del equipo porque los enfrentamientos del equipo han sido creados'); 
end if;

end restriccionDeActualizarEquipo;