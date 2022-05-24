create or replace trigger restriccionDeDupDuenyo 
before insert or update on duenyo 
for each row 
begin 
datoPersona.idPersona := :new.id_persona;
end;