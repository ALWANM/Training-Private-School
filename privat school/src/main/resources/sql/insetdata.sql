/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  m-alwan
 * Created: Nov 12, 2017
 */

INSERT INTO COURSE(CODE,TITLE)
VALUES
        ('AG41','Optimisation et recherche operationnelle'),
        ('AG44','Graph Theory and Applications'),
        ('BD40','Systemes d information'),
        ('GL40','Interface homme/machine et perception'),
        ('LO43','Bases fondamentales de la programmation orientee objet'),
        ('IA51','Artificial intelligence for serious game'),
        ('IN41','Analyse et traitement du signal'),
        ('IN52','Traitement et analyse d images numeriques'),
        ('MI52','Systemes pour l informatique embarquee'), 
        ('RE55','Réseaux haut débit'),
        ('MT51','Mathematiques pour l image');
INSERT INTO LOCATION(CITY)
VALUES
        ('Belfort'),
        ('Sevenans'),
        ('Montbeliard');
INSERT INTO COURSE_SESSION(START_DATE,END_DATE,COURSE_CODE,LOCATION_ID)
VALUES
        ('1/9/2017','1/2/2018','AG41',1),
        ('1/9/2017','1/2/2018','AG44',2),
        ('1/9/2017','1/2/2018','BD40',3),
        ('1/9/2017','1/2/2018','GL40',1),
        ('1/9/2017','1/2/2018','LO43',2),
        ('1/9/2017','1/2/2018','IA51',3),
        ('1/3/2018','1/8/2018','IN41',1),
        ('1/3/2018','1/8/2018','IN52',2),
        ('1/3/2018','1/8/2018','MI52',3),
        ('1/3/2018','1/8/2018','MT51',1),
        ('1/3/2018','1/8/2018','RE55',2);
--ALTER TABLE COURSE ADD COLUMN NEW_COLUMN VARCHAR(220);
--UPDATE COURSE SET NEW_COLUMN=TITLE;
--ALTER TABLE COURSE DROP COLUMN TITLE;
--RENAME COLUMN COURSE.NEW_COLUMN TO TITLE;