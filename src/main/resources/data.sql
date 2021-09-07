create database hospital;

use hospital;

show tables;
DROP TABLES patient;
DROP TABLES doctor;
SELECT * FROM doctor;
SELECT * FROM patient;

INSERT INTO doctor (employee_id, department, name, status) 
VALUES('356712','CARDIOLOGY','Alonso Flores','ON_CALL'),
	('564134','IMMUNOLOGY','Sam Ortega','ON'),
	('761527','CARDIOLOGY','German Ruiz','OFF'),
	('166552','PULMONARY','Maria Lin','ON'),
	('156545','ORTHOPAEDIC','Paolo Rodriguez','ON_CALL'),
	('172456','PSYCHIATRIC','John Paul Armes','OFF');

INSERT INTO patient (name, date_of_birth, admitted_by)
values ('Jaime Jordan','1984-03-02','564134'),
	('Marian Garcia','1972-01-12','564134'),
	('Julia Dusterdieck','1954-06-11','356712'),
	('Steve McDuck','1931-11-10','761527'),
	('Marian Garcia','1999-02-15','172456');
    

