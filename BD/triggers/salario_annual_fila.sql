create or replace trigger salario_annual_fila
before insert or update on jugador
for each row
begin
pcq_sueldo_anual.idequipo := :new.id_equipo;
pcq_sueldo_anual.sueldoAnual := :new.sueldo;
end;