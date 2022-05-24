create or replace trigger restriccionDeActualizarEquipo 
before insert or delete on equipo 
for each row 
declare 
estadoLiga liga.estado%type;
begin 

select estado into estadoLiga from liga;
if estadoliga = 'CERRADO' then
raise_application_error(-20003,'ahora no puedes cambiar los datos del equipo porque los enfrentamientos del equipo han sido creados'); 
end if;

end restriccionDeActualizarEquipo;