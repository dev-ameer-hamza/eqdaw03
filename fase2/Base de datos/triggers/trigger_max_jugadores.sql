/* TRIGGER para calcular que no haya mas de 6 jugadores en cada equipo */

create or replace trigger max_6_jugadores
before insert on jugador
for each row
declare
    numJugadores number(10) := 0;
    maximoJugadoresExp Exception;
begin
    numjugadores := jugadores_en_equipo(:new.id_equipo);
    if numJugadores >= 6 then
    RAISE maximoJugadoresExp;
    end if;

exception
    when maximoJugadoresExp then
    raise_application_error(-20001, 'Error, no puede haber mas de 6 personas en cada equipo.');
end;

alter  trigger max_6_jugadores disable;


/* PRUEBAS */

insert into persona(nombre, apellido) VALUES ('nombre28', 'apellido28');
insert into persona(nombre, apellido) VALUES ('nombre29', 'apellido29');
insert into persona(nombre, apellido) VALUES ('nombre30', 'apellido30');
insert into persona(nombre, apellido) VALUES ('nombre31', 'apellido31');
insert into persona(nombre, apellido) VALUES ('nombre32', 'apellido32');
insert into persona(nombre, apellido) VALUES ('nombre32', 'apellido32');

select * from persona;

insert into jugador VALUES (28, 'apodo28', 'rol28', 1100, 1); 
insert into jugador VALUES (29, 'apodo29', 'rol29', 1100, 1);
insert into jugador VALUES (30, 'apodo30', 'rol30', 1100, 1);
insert into jugador VALUES (31, 'apodo31', 'rol31', 1100, 1);
insert into jugador VALUES (32, 'apodo32', 'rol32', 1100, 1);

delete from jugador where id_persona=31;
delete from jugador where id_persona=32;
delete from jugador where id_persona=4;
delete from jugador where id_persona=6;
delete from jugador where id_persona=8;


select count(*) from jugador where id_equipo=1;

select count(*) from jugador group by id_equipo;