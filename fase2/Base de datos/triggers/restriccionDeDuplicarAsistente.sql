create or replace trigger restriccionDeDuplicarAsistente 
before insert or update on asistente 
for each row 
begin 
datoPersona.idPersona := :new.id_persona;
end;