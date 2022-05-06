/* datos jornadas */
insert into jornada(fecha) VALUES (TO_DATE('22/06/2022','dd/mm/yyyy'));
insert into jornada(fecha) VALUES (TO_DATE('26/06/2022','dd/mm/yyyy'));
insert into jornada(fecha) VALUES (TO_DATE('29/06/2022','dd/mm/yyyy'));
insert into jornada(fecha) VALUES (TO_DATE('03/07/2022','dd/mm/yyyy'));
insert into jornada(fecha) VALUES (TO_DATE('06/07/2022','dd/mm/yyyy'));


select * from jornada;

/* datos equipo */
insert into equipo(nombre_equipo, puntos, partidos_jugados, partidos_ganados, partidos_perdidos) 
VALUES ('equipo1', 18, 5, 3, 2);
insert into equipo(nombre_equipo, puntos, partidos_jugados, partidos_ganados, partidos_perdidos) 
VALUES ('equipo2', 40, 5, 2, 3);
insert into equipo(nombre_equipo, puntos, partidos_jugados, partidos_ganados, partidos_perdidos) 
VALUES ('equipo3', 12, 5, 1, 4);
insert into equipo(nombre_equipo, puntos, partidos_jugados, partidos_ganados, partidos_perdidos) 
VALUES ('equipo4', 5, 5, 5, 0);
insert into equipo(nombre_equipo, puntos, partidos_jugados, partidos_ganados, partidos_perdidos) 
VALUES ('equipo5', 8, 5, 4, 1);
insert into equipo(nombre_equipo, puntos, partidos_jugados, partidos_ganados, partidos_perdidos) 
VALUES ('equipo6', 8, 5, 4, 1);

select * from equipo;

/* datos partidos */
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 1,1,2,2);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('13:00', 1,3,4,3);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('14:00', 1,5,6,6);

insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 2,1,3,3);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 2,2,5,5);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 2,4,6,4);

insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 5,1,4,1);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 5,2,6,2);
insert into partido(hora,id_jornada,id_equipo1,id_equipo2,equipo_ganador) values('12:00', 5,4,5,4);

select * from partido;


/* datos persona */
insert into persona(nombre, apellido) VALUES ('nombre1', 'apellido1');
insert into persona(nombre, apellido) VALUES ('nombre2', 'apellido2');
insert into persona(nombre, apellido) VALUES ('nombre3', 'apellido3');
insert into persona(nombre, apellido) VALUES ('nombre4', 'apellido4');
insert into persona(nombre, apellido) VALUES ('nombre5', 'apellido5');
insert into persona(nombre, apellido) VALUES ('nombre6', 'apellido6');
insert into persona(nombre, apellido) VALUES ('nombre7', 'apellido7');
insert into persona(nombre, apellido) VALUES ('nombre8', 'apellido8');
insert into persona(nombre, apellido) VALUES ('nombre9', 'apellido9');
insert into persona(nombre, apellido) VALUES ('nombre10', 'apellido10');
insert into persona(nombre, apellido) VALUES ('nombre11', 'apellido11');
insert into persona(nombre, apellido) VALUES ('nombre12', 'apellido12');
insert into persona(nombre, apellido) VALUES ('nombre13', 'apellido13');
insert into persona(nombre, apellido) VALUES ('nombre14', 'apellido14');
insert into persona(nombre, apellido) VALUES ('nombre15', 'apellido15');
insert into persona(nombre, apellido) VALUES ('nombre16', 'apellido16');
insert into persona(nombre, apellido) VALUES ('nombre17', 'apellido17');
insert into persona(nombre, apellido) VALUES ('nombre18', 'apellido18');
insert into persona(nombre, apellido) VALUES ('nombre19', 'apellido19');
insert into persona(nombre, apellido) VALUES ('nombre20', 'apellido20');
insert into persona(nombre, apellido) VALUES ('nombre21', 'apellido21');
insert into persona(nombre, apellido) VALUES ('nombre22', 'apellido22');
insert into persona(nombre, apellido) VALUES ('nombre23', 'apellido23');
insert into persona(nombre, apellido) VALUES ('nombre24', 'apellido24');
insert into persona(nombre, apellido) VALUES ('nombre25', 'apellido25');
insert into persona(nombre, apellido) VALUES ('nombre26', 'apellido26');
insert into persona(nombre, apellido) VALUES ('nombre27', 'apellido27');


select * from persona;

/* datos jugador */
insert into jugador VALUES (1, 'apodo1', 'rol1', 1100, 1); 
insert into jugador VALUES (2, 'apodo1', 'rol1', 1100, 1);
insert into jugador VALUES (3, 'apodo1', 'rol1', 1100, 2);
insert into jugador VALUES (4, 'apodo1', 'rol1', 1100, 2);
insert into jugador VALUES (5, 'apodo1', 'rol1', 1100, 3);
insert into jugador VALUES (6, 'apodo1', 'rol1', 1100, 3);
insert into jugador VALUES (7, 'apodo1', 'rol1', 1100, 4);
insert into jugador VALUES (8, 'apodo1', 'rol1', 1100, 4);
insert into jugador VALUES (9, 'apodo1', 'rol1', 1100, 5);
insert into jugador VALUES (10, 'apodo1', 'rol1', 1100, 5);
insert into jugador VALUES (11, 'apodo1', 'rol1', 1100, 6);
insert into jugador VALUES (12, 'apodo1', 'rol1', 1100, 6);

select * from jugador;

/* datos entrenador */
insert into entrenador VALUES (13, 1);
insert into entrenador VALUES (14, 2);
insert into entrenador VALUES (15, 3);
insert into entrenador VALUES (16, 4);
insert into entrenador VALUES (17, 5);
insert into entrenador VALUES (18, 6);

select * from entrenador;

/* datos asistente */
insert into asistente VALUES (19, 1);
insert into asistente VALUES (20, 2);
insert into asistente VALUES (21, 3);

select * from asistente;

/* datos duenyo */
insert into duenyo VALUES (22, 1);
insert into duenyo VALUES (23, 2);
insert into duenyo VALUES (24, 3);
insert into duenyo VALUES (25, 4);
insert into duenyo VALUES (26, 5);
insert into duenyo VALUES (27, 6);

select * from duenyo;

/* datos login */
insert into login(usuario, contrasenya, tipo) VALUES ('user1', 'cont1', 'USER');
insert into login(usuario, contrasenya, tipo) VALUES ('user2', 'cont2', 'USER');
insert into login(usuario, contrasenya, tipo) VALUES ('user3', 'cont3', 'ADMIN');
insert into login(usuario, contrasenya, tipo) VALUES ('user4', 'cont4', 'ADMIN');

select * from login;


