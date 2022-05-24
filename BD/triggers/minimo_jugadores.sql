create or replace trigger minimo_jugadores
before insert or update on partido
for each row
declare
jugadoresDeEquipo1 number(5);
jugadoresDeEquipo2 number(5);
minimoJugadoresExcep1 Exception;
minimoJugadoresExcep2 Exception;
minimoJugadoresExcep1y2 Exception;
begin
jugadoresdeequipo1 := jugadores_en_equipo(:new.id_equipo1);
jugadoresdeequipo2 := jugadores_en_equipo(:new.id_equipo2);
if jugadoresdeequipo1 < 2 AND jugadoresdeequipo2 < 2 then
    raise minimoJugadoresExcep1y2;
end if;
if jugadoresdeequipo1 < 2 then
raise minimoJugadoresExcep1;
end if;
if jugadoresdeequipo2 < 2 then
raise minimoJugadoresExcep2;
end if;

exception
when minimoJugadoresExcep1y2 then
raise_application_error(-20008,'ERROR, No puede haber menos de 2 jugadores en el equipo ' || :new.id_equipo1 || ' y ' || :new.id_equipo2);
when minimoJugadoresExcep1 then
raise_application_error(-20009,'ERROR, No puede haber menos de 2 jugadores en el equipo ' || :new.id_equipo1);
when minimoJugadoresExcep2 then
raise_application_error(-20010,'ERROR, No puede haber menos de 2 jugadores en el equipo ' || :new.id_equipo2);
end;