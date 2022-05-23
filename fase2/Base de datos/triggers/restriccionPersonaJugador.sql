create or replace PACKAGE datoPersona
as
idPersona number(5);
end;

create or replace function yaExistePersona(idPersona in number,nombreTable in varchar2) return boolean
is
hayPersona boolean;
persona number(3);
begin
if nombreTable = 'jugador' then
select id_persona into persona from jugador where id_persona=idPersona;
elsif nombreTable = 'duenyo' then
select id_persona into persona from duenyo where id_persona=idPersona;
elsif nombreTable = 'asistente' then
select id_persona into persona from asistente where id_persona=idPersona;
else
select id_persona into persona from entrenador where id_persona=idPersona;
end if;
return true;

exception
when no_data_found then
return false;
end;

create or replace  trigger restriccionDeDuplicarPersonaJugador 
before insert or update on jugador 
for each row 
begin 
datoPersona.idPersona := :new.id_persona;
end;

create or replace trigger restriccionDeDuplicarPersonaJugadorSen
after insert or update on jugador
begin
if yaexistepersona(datoPersona.idPersona,'jugador') or yaexistepersona(datoPersona.idPersona,'duenyo') or yaexistepersona(datoPersona.idPersona,'asistente') or yaexistepersona(datoPersona.idPersona,'entrenador') then
raise_application_error('20061','Persona con id ' || to_char(datoPersona.idPersona) || 'ya esta relacionada con otra entidad' );
end if;
end;