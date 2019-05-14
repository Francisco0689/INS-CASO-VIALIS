CREATE USER ins_2019 IDENTIFIED BY oracle
      DEFAULT TABLESPACE users
      TEMPORARY TABLESPACE temp
      QUOTA UNLIMITED ON users;
      
GRANT CREATE session TO ins_2019;
GRANT CREATE table TO ins_2019;
GRANT CREATE view TO ins_2019;
GRANT CREATE procedure TO ins_2019;
GRANT CREATE synonym TO ins_2019;      



/

CREATE TABLE EMPLEADO 
(
  RUT VARCHAR2(20) NOT NULL 
, PASSWORD VARCHAR2(50) 
, APELLIDOS VARCHAR2(100) 
, NOMBRES VARCHAR2(100) 
, CARGO VARCHAR2(100) 
, CONSTRAINT EMPLEADO_PK PRIMARY KEY 
  (
    RUT 
  )
  ENABLE 
);

/

INSERT INTO empleado (rut, password, apellidos, nombres, cargo) VALUES
('46099060-3', '12345', 'Ruiz Benites', 'Oscar', 'Gerente');

INSERT INTO empleado (rut, password, apellidos, nombres, cargo) VALUES
('78945612-4', '54321', 'Galvez Montero', 'Angela', 'Recepción');

commit;