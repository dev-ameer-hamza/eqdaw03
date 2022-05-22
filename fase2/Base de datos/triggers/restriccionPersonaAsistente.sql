create or replace  trigger restriccionDeDuplicarPersonaAsistente 
before insert or update on asistente 
for each row 
begin 
datoPersona.idPersona := :new.id_persona;
end;

create or replace trigger restriccionDeDuplicarPersonaAsistenteSen
after insert or update on asistente
begin
if yaexistepersona(datoPersona.idPersona,'jugador') or yaexistepersona(datoPersona.idPersona,'duenyo') or yaexistepersona(datoPersona.idPersona,'asistente') or yaexistepersona(datoPersona.idPersona,'entrenador') then
raise_application_error('20061','Persona con id ' || to_char(datoPersona.idPersona) || 'ya esta relacionada con otra entidad' );
end if;
end;