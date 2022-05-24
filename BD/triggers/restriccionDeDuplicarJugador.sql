create or replace trigger restriccionDeDuplicarJugador 
before insert or update on jugador 
for each row 
begin 
datoPersona.idPersona := :new.id_persona;
end;