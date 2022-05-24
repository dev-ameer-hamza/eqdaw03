CREATE OR REPLACE VIEW todos_partidos AS
select j.id_jornada, cp1.nombre_equipo as equipo_local,cp2.nombre_equipo as equipo_Visitante,
cp3.nombre_equipo as equipo_Ganador
from partido, equipo cp1,equipo cp2,equipo cp3, jornada j
where partido.id_equipo1=cp1.id_equipo and partido.id_equipo2=cp2.id_equipo and 
partido.equipo_ganador=cp3.id_equipo and j.id_jornada=partido.id_jornada
order by partido.id_jornada asc;


DROP VIEW todos_partidos;


/* PRUEBAS */

select * from todos_partidos where equipo_local='equipo1';
desc todos_partidos;


insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 3,1,4,1);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 3,2,3,2);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 3,6,5,6);