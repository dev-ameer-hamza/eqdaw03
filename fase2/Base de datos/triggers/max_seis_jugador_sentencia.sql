create or replace trigger max_seis_jugador_sentencia
after insert or update on jugador
declare
numJugadores number(10) := 0;
maximoJugadoresExp Exception;
begin
select jugadores_en_equipo(pcq_jugador.idEquipo) into numJugadores from dual;
if numJugadores >= 6 then
raise maximoJugadoresExp;
end if;
Exception
when maximoJugadoresExp then
 raise_application_error(-20001, 'Error, no puede haber mas de 6 personas en cada equipo. tonto');
end;