create or replace trigger restriccionDupEntrenadorSen
after insert or update on entrenador
begin
if yaexistepersonajugador(datoPersona.idPersona) or yaexistepersonaduenyo(datoPersona.idPersona) or yaexistepersonaasistente(datoPersona.idPersona) or yaexistepersonaentrenador(datoPersona.idPersona) then
raise_application_error(-20062,'Persona con id ' || to_char(datoPersona.idPersona) || 'ya esta relacionada con otra entidad' );
end if;
end;