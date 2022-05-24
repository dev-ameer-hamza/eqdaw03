-- Todas las jornadas --- 

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
  --type datoUltimaJornada is ref cursor;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'select j.id_jornada, cp1.nombre_equipo as equipo_1,cp2.nombre_equipo as equipo_2,
                cp3.nombre_equipo as equipo_Ganador
                from partido, equipo cp1,equipo cp2,equipo cp3, jornada j
                where partido.id_equipo1=cp1.id_equipo and partido.id_equipo2=cp2.id_equipo and 
                partido.equipo_ganador=cp3.id_equipo and j.id_jornada=partido.id_jornada
                order by partido.id_jornada asc');
			  
  -- Set the name of the document root element. The default name is ROWSET			  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'partidos');
  
  -- Set the row header to be EMPLOYEE
  DBMS_XMLGEN.setRowTag(qryCtx, 'partido');
  
  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO xml(RESULTADOS_TODAS_LAS_JORNADAS) VALUES(result);
  
  --Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;



desc xml;


-- Ultima jornada --- 

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
  --type datoUltimaJornada is ref cursor;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'select * from todos_partidos where id_jornada = (SELECT MAX(id_jornada) from todos_partidos)');
			  
  -- Set the name of the document root element. The default name is ROWSET			  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'partidos');
  
  -- Set the row header to be EMPLOYEE
  DBMS_XMLGEN.setRowTag(qryCtx, 'partido');
  
  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO xml(RESULTADO_ULTIMA_JORNADA) VALUES(result);
  
  --Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;



-- Clasificacion --- 

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
  --type datoUltimaJornada is ref cursor;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'select id_equipo, nombre_equipo, puntos, partidos_jugados, partidos_ganados, partidos_perdidos from equipo order by puntos desc');
			  
  -- Set the name of the document root element. The default name is ROWSET			  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'clasificacion');
  
  -- Set the row header to be EMPLOYEE
  DBMS_XMLGEN.setRowTag(qryCtx, 'equipo');
  
  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO xml(CLASIFICACION) VALUES(result);
  
  --Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;





select * from xml;