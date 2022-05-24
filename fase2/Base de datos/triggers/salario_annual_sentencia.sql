create or replace trigger salario_annual_sentencia
after insert or update on jugador
declare
salarioAnual number(8);
salarioAnualExcep Exception;
begin
select sum(sueldo)*12+pcq_sueldo_anual.sueldoAnual*12 into salarioAnual from jugador where id_equipo=pcq_sueldo_anual.idequipo;
if salarioAnual > 200000 then
raise salarioAnualExcep;
end if;
exception
when salarioAnualExcep then
raise_application_error(-20007,'el salario anual de los jugadores del equipo ' || pcq_jugador.idequipo || ' no puede superar 200,000 euros');
end;