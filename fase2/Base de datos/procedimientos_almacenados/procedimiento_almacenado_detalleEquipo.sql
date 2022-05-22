create or replace procedure detalleEquipo(cur out sys_refcursor)
as
begin
open cur for select distinct e.nombre_equipo,pa.nombre asistente,pd.nombre dueño,pe.nombre entrenador from  
                equipo e,duenyo d,entrenador en,asistente a,persona pa,persona pe,persona pd
                where (
                e.id_equipo = d.id_equipo
                and +
                e.id_equipo = en.id_equipo
                and
                e.id_equipo = a.id_equipo(+)
                ) 
                and ( 
                en.id_persona = pe.id_persona 
                and 
                a.id_persona = pa.id_persona(+)
                and
                d.id_persona = pd.id_persona);
Exception
when otherS then
raise_application_error('20050','ERROR ORACLE ' || TO_CHAR(SQLCODE) || ', ' || SQLERRM);
end;