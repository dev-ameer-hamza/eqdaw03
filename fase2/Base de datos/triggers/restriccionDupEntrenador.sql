create or replace trigger restriccionDupEntrenador
before insert or update on entrenador 
for each row 
begin 
datoPersona.idPersona := :new.id_persona;
end;