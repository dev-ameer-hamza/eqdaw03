/* prueba del procedimiento datosEquipos (un equipo especifico)  */
set serveroutput on;
declare
datoEquipo datos_liga.tcursor;
reg_equi equipo%rowtype;
begin
datos_liga.datosEquipos(1,datoEquipo);
fetch datoEquipo into reg_equi;
if(datoEquipo%notfound) then
 dbms_output.put_line('no hay datos');
 else
dbms_output.put_line(reg_equi.nombre_equipo);
end if;
end;

/* prueba del procedimiento lista_jugadores (de un equipo especifico)  */
declare
datoJugador datos_liga.tcursor;
datoPersona datos_liga.tcursor;
reg_persona persona%rowtype;
reg_jugador jugador%rowtype;
begin
datos_liga.lista_jugadores(1,datoJugador,datoPersona);
FETCH datoJugador into reg_jugador;
FETCH datoPersona into reg_persona;
if datoJugador%notfound then
 dbms_output.put_line('no hay datos');
 else
 while(datoJugador%found) loop
 dbms_output.put_line(reg_persona.id_persona || reg_persona.nombre || reg_persona.apellido || reg_jugador.apodo || reg_jugador.rol || reg_jugador.sueldo || reg_jugador.id_equipo);
 fetch datoJugador into reg_jugador;
 fetch datoPersona into reg_persona;
 end loop;
end if;
end;

set serveroutput on;

/* prueba del procedimiento lista_ultima_jornada   */
declare
datoJornada datos_liga.tcursor;
reg_emp partido%rowtype;
begin
datos_liga.lista_ultima_jornada(datoJornada);
fetch datoJornada into reg_emp;
if datoJornada%notfound then
dbms_output.put_line(datoJornada%rowcount);
dbms_output.put_line('no hay datos');
 else
 while datoJornada%found loop
 dbms_output.put_line(reg_emp.id_partido || '-' || reg_emp.id_equipo1 || '-' || reg_emp.id_equipo2 || '-' || reg_emp.equipo_ganador);
 fetch datoJornada into reg_emp;
 end loop;
end if;
end;

select * from partido where id_jornada=(select max(id_jornada) from jornada);

/* prueba del procedimiento lista_todas_jornadas   */
declare
todasJornadas datos_liga.tcursor;
losPartidos datos_liga.tcursor;
cadaJornada jornada%rowtype;
cadaPartido partido%rowtype;
begin
datos_liga.lista_todas_jornadas(todasJornadas);
fetch todasJornadas into cadaJornada;
if todasJornadas%notfound then
dbms_output.put_line('no hay datos');
else
while todasJornadas%found loop
dbms_output.put_line(cadaJornada.fecha ||' tabla jornada ' || cadaJornada.id_jornada);
datos_liga.partidosDeCadaJornada(cadaJornada.id_jornada,losPartidos);
fetch losPartidos into cadaPartido;
if lospartidos%notfound then
dbms_output.put_line('no hay partidos en jornada ' || cadaJornada.id_jornada);
else
while lospartidos%found loop
dbms_output.put_line('partido ' || cadaPartido.equipo_ganador);
fetch losPartidos into cadaPartido;
end loop;
end if;

fetch todasJornadas into cadaJornada;
end loop;
end if;

end;

/* prueba del procedimiento lista_clasificacion  */
declare
laClasificacion datos_liga.tcursor;
idEquipo equipo.id_equipo%type;
nombre equipo.nombre_equipo%type;
puntos equipo.puntos%type;
partidosJ equipo.partidos_jugados%type;
partidosG equipo.partidos_ganados%type;
partidosP equipo.partidos_perdidos%type;
begin
datos_liga.lista_clasificacion(laClasificacion);
fetch laClasificacion into idequipo,nombre,puntos,partidosj,partidosg,partidosp;
if laclasificacion%notfound then
dbms_output.put_line('no hay datos');
else
while laclasificacion%found loop
dbms_output.put_line('Equipo ' || idequipo || ' Nombre Equipo ' || nombre || 
' Puntos ' || puntos || ' Partidos Jugados ' ||partidosj || ' Partidos Ganados' || partidosg || ' Partidos Perdidos ' || partidosp);
fetch laClasificacion into idequipo,nombre,puntos,partidosj,partidosg,partidosp;
end loop;
end if;
end;


/* prueba del procedimiento lista_equipo */
declare
datoEquiposC datos_liga.tcursor;
idE equipo.id_equipo%type;
nomE equipo.nombre_equipo%type;
nomEnt persona.nombre%type;
nomDu persona.nombre%type;
begin
datos_liga.lista_equipos(datoEquiposC);
fetch datoEquiposC into idE,nomE,nomEnt,nomDu;
while datoequiposc%found loop
dbms_output.put_line('Id Equipo ' ||idE || ' Nombre Equipo ' || nomE 
|| ' Nombre Entrenador ' || nomEnt || ' Nombre Dueño ' || nomDu);
fetch datoEquiposC into idE,nomE,nomEnt,nomDu;
end loop;
end;
