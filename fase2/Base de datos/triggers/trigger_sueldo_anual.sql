/* TRIGGER para calcular que no haya mas del maximo de  */

create or replace trigger salario_equipo_anual
before insert on jugador
for each row
declare
salarioAnual number(8);
salarioAnualExcep Exception;
begin
select sum(sueldo)*12+:new.sueldo*12 into salarioAnual from jugador where id_equipo=:new.id_equipo;
if salarioAnual > 200000 then
raise salarioAnualExcep;
end if;

exception
when salarioAnualExcep then
raise_application_error(-20007,'el salario anual de los jugadores del equipo ' || :new.id_equipo || ' no puede superar 200,000 euros');
end;

alter trigger salario_equipo_anual disable;

select * from jugador where id_equipo=1;
insert into jugador VALUES (31, 'apodo32', 'rol32', 919000, 1);