create or replace package datos_liga as  
TYPE tcursor IS REF CURSOR; 
    -- function partidosGanados(equipo in number) return number;  
    function buscarEquipo(id in number) return boolean;
    
    procedure datosEquipos(equipo in number,datosEquipo out tcursor);
    
    procedure lista_jugadores(equipo in number, datoJugador out tcursor, datoPersona out tcursor);
    
    procedure lista_ultima_jornada(datoUltimaJornada out tcursor);
    
    procedure lista_todas_jornadas(todasLasJornadas out tcursor);
    
    procedure partidosDeCadaJornada(idJornada in number,losPartidos out tcursor);
    
    procedure lista_clasificacion(datoClasificacion out tcursor);
    
    procedure lista_equipos(datoEquipos out tcursor);
    
    --function estado_equipo(id_equipo in number) return varchar2;
    

end datos_liga;





create or replace package body datos_liga as

function buscarEquipo(id in number) return boolean
as
elEquipo equipo%rowtype;
begin
select * into elEquipo from equipo where id_equipo=id;
return true;
exception
when no_data_found then
return false;
when others then
return false;
end buscarEquipo;

procedure datosEquipos(equipo in number,datosEquipo out tcursor)
as
equipoNoExisteExcep Exception;
begin
if buscarEquipo(equipo) then
open datosEquipo for select * from equipo where id_equipo=equipo;
else
raise equipoNoExisteExcep;
end if;
EXCEPTION
when equipoNoExisteExcep then
raise_application_error(-20011,'Error, el equipo con id ' || to_char(equipo) || ' no existe');
when others then
raise_application_error(-20012,'Error desconocido SQLCODE ' || to_char(sqlcode) ||' SQLM ' || sqlerrm);
end datosEquipos; -- el procedure datosEquipos termina aqui

procedure lista_jugadores(equipo in number, datoJugador out tcursor, datoPersona out tcursor)
as
equipoNoExisteExcep Exception;
begin
if buscarEquipo(equipo) then
open datoJugador for select * from jugador where id_equipo=equipo;
open datoPersona for select p.id_persona,p.nombre,p.apellido from persona p, jugador j
where p.id_persona=j.id_persona and j.id_equipo=equipo;
else
raise equipoNoExisteExcep;
end if;
EXCEPTION
when equipoNoExisteExcep then
raise_application_error(-20011,'Error, el equipo con id ' || to_char(equipo) || ' no existe');
when others then
raise_application_error(-20012,'Error desconocido SQLCODE ' || to_char(sqlcode) ||' SQLM ' || sqlerrm);
end lista_jugadores; -- el procedure lista_jugadores termina aqui

procedure lista_ultima_jornada(datoUltimaJornada out tcursor) as
--cursor partidos is select * from partido where id_jornada=(select max(id_jornada) from jornada);
--reg_partido partido%rowtype;
ultimaJornada jornada.id_jornada%type;
jornadaNoExiste Exception;
begin

select max(id_jornada) into ultimaJornada from jornada;
if ultimaJornada is null then
raise jornadaNoExiste;
else
open datoUltimaJornada for select * from partido where id_jornada=ultimaJornada;
end if;
exception
when jornadaNoExiste then
raise_application_error(-20013, 'No hay jornadas');

end lista_ultima_jornada; -- el procedure lista_ultima_jornada termina aqui

procedure lista_todas_jornadas(todasLasJornadas out tcursor) as

begin
open todasLasJornadas for select * from jornada;
end lista_todas_jornadas;

procedure partidosDeCadaJornada(idJornada in number,losPartidos out tcursor)
as

begin
open lospartidos for select *from partido where id_jornada=idJornada;
end partidosDeCadaJornada;

procedure lista_clasificacion(datoClasificacion out tcursor) as
begin
open datoclasificacion for select id_equipo,nombre_equipo,puntos,
partidos_jugados,partidos_ganados,partidos_perdidos from equipo order by puntos desc;
end lista_clasificacion;

procedure lista_equipos(datoEquipos out tcursor) as

begin
 open datoEquipos for select eq.id_equipo "ID",eq.nombre_equipo "Nombre Equipo",
enp.nombre "Entrenador",dep.nombre "Dueño" from entrenador e
,persona enp,persona dep,duenyo d,equipo eq
where (e.id_persona=enp.id_persona and d.id_persona=dep.id_persona) and 
(e.id_equipo=eq.id_equipo and e.id_equipo=d.id_equipo);
end lista_equipos;

end datos_liga; -- termina el procedure aqui




