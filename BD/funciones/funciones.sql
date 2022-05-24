create or replace function yaExistePersonaJugador(idPersona in number) return boolean
is
gente number(3);
begin

select id_persona into gente from jugador where id_persona=idPersona;

return true;

exception
when no_data_found then
return false;
end;


create or replace function yaExistePersonaAsistente(idPersona in number) return boolean
is
gente number(3);
begin

select id_persona into gente from asistente where id_persona=idPersona;

return true;

exception
when no_data_found then
return false;
end;


create or replace function yaExistePersonaDuenyo(idPersona in number) return boolean
is
gente number(3);
begin

select id_persona into gente from duenyo where id_persona=idPersona;

return true;

exception
when no_data_found then
return false;
end;


create or replace function yaExistePersonaEntrenador(idPersona in number) return boolean
is
gente number(3);
begin

select id_persona into gente from entrenador where id_persona=idPersona;

return true;

exception
when no_data_found then
return false;
end;


create or replace function jugadores_en_equipo (equipo in number) return number
is
numJugadores number(5);
begin
select count(*) into numJugadores from jugador where id_equipo=equipo;
return numJugadores;
end;