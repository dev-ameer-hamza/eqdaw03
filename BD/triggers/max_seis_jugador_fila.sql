create or replace trigger max_seis_jugador_fila
before insert or update on jugador
for each row
begin
pcq_jugador.idEquipo := :new.id_equipo;
Exception
when others then
raise_application_error('20017','ERROR ORACLEEE');
end;