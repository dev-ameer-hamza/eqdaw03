create or replace procedure todosPartidos(cur out sys_refcursor)
as 
begin
open cur for select j.id_jornada, cp1.nombre_equipo as equipo_local,cp2.nombre_equipo as equipo_Visitante,
cp3.nombre_equipo as equipo_Ganador
from partido, equipo cp1,equipo cp2,equipo cp3, jornada j
where partido.id_equipo1=cp1.id_equipo and partido.id_equipo2=cp2.id_equipo and 
partido.equipo_ganador=cp3.id_equipo and j.id_jornada=partido.id_jornada
order by partido.id_jornada asc;
Exception
when no_data_found then
raise_application_error('20071','ERROR ORACLE - ' || ' No hay datos ');
when others then
raise_application_error('20081','ERROR ORACLE ' || TO_CHAR(SQLCODE) ||', ' || SQLERRM);
end;