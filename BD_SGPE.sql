CREATE DATABASE SGPE;

USE SGPE;

CREATE TABLE PlanEstudio(
  NumeroPlan VARCHAR (50) NOT NULL,
  FechaEntradaVigencia DATE NOT NULL,
  PRIMARY KEY (NumeroPlan)
);

CREATE TABLE EscuelaOArea(
  IDEscuela VARCHAR (50) NOT NULL,
  Nombre VARCHAR (50) NOT NULL,
  PRIMARY KEY (IDEscuela)
);

CREATE TABLE Curso(
  IDCurso VARCHAR (50) NOT NULL,
  Nombre VARCHAR (50) NOT NULL,
  Creditos INT NOT NULL,
  Horas_Lectivas INT NOT NULL,
  PRIMARY KEY (IDCurso)
);

CREATE TABLE Escuela_PlanEstudio(
  IDEscuela VARCHAR (50) NOT NULL,
  NumeroPlan VARCHAR (50) NOT NULL,
  PRIMARY KEY (IDEscuela, NumeroPlan),
  FOREIGN KEY (IDEscuela) REFERENCES EscuelaOArea (IDEscuela),
  FOREIGN KEY (NumeroPlan) REFERENCES PlanEstudio (NumeroPlan),
);

CREATE TABLE PlanEstudio_Curso(
  IDCurso VARCHAR (50) NOT NULL,
  NumeroPlan VARCHAR (50) NOT NULL,
  NumeroBloque INT NOT NULL,
  PRIMARY KEY (IDCurso, NumeroPlan),
  FOREIGN KEY (IDCurso) REFERENCES Curso (IDCurso),
  FOREIGN KEY (NumeroPlan) REFERENCES PlanEstudio (NumeroPlan),
);

CREATE TABLE Requisitos_Curso(
  IDCursoConsultado VARCHAR (50) NOT NULL,
  IDCursoRequisito VARCHAR (50) NOT NULL,
  PRIMARY KEY (IDCursoConsultado, IDCursoRequisito),
  FOREIGN KEY (IDCursoConsultado) REFERENCES Curso (IDCurso),
  FOREIGN KEY (IDCursoRequisito) REFERENCES Curso (IDCurso),
);

CREATE TABLE Correquisitos_Curso(
  IDCursoConsultado VARCHAR (50) NOT NULL,
  IDCursoCorrequisito VARCHAR (50) NOT NULL,
  PRIMARY KEY (IDCursoConsultado, IDCursoCorrequisito),
  FOREIGN KEY (IDCursoConsultado) REFERENCES Curso (IDCurso),
  FOREIGN KEY (IDCursoCorrequisito) REFERENCES Curso (IDCurso),
);

----- PROCEDIMIENTOS DE INSERCIÓN DE LA BASE DE DATOS
--- INSERTAR ESCUELA

GO
CREATE PROCEDURE Insertar_Escuela 
	@IDEscuela VARCHAR (50),
    @Nombre VARCHAR (50) 
AS
	BEGIN
		INSERT INTO EscuelaOArea VALUES (@IDEscuela, @Nombre)
	END

--- INSERTAR PLAN DE ESTUDIOS

GO
CREATE PROCEDURE Insertar_Plan 
	@NumeroPlan VARCHAR (50),
    @FechaEntradaVigencia DATE
AS
	BEGIN
		INSERT INTO PlanEstudio VALUES (@NumeroPlan, @FechaEntradaVigencia)
	END

--- INSERTAR CURSOS

GO
CREATE PROCEDURE Insertar_Curso 
	@IDCurso VARCHAR (50),
    @Nombre VARCHAR (50),
    @Creditos INT,
    @Horas_Lectivas INT
AS
	BEGIN
		INSERT INTO Curso VALUES (@IDCurso, @Nombre, @Creditos, @Horas_Lectivas)
	END

--- INSERTAR REQUISITOS CURSOS

GO
CREATE PROCEDURE Insertar_Requisitos_Curso 
	@IDCursoConsulta VARCHAR (50),
    @IDCursoRequisito VARCHAR (50)
AS
	BEGIN
		INSERT INTO Requisitos_Curso VALUES (@IDCursoConsulta, @IDCursoRequisito)
	END

--- INSERTAR CORREQUISITOS CURSOS

GO
CREATE PROCEDURE Insertar_Correquisitos_Curso 
	@IDCursoConsulta VARCHAR (50),
    @IDCursoCorrequisito VARCHAR (50)
AS
	BEGIN
		INSERT INTO Correquisitos_Curso VALUES (@IDCursoConsulta, @IDCursoCorrequisito)
	END

--- INSERTAR RELACIÓN ESCUELA_PLANESTUDIO

GO
CREATE PROCEDURE Insertar_Escuela_PlanEstudio 
	@IDEscuela VARCHAR (50),
    @NumeroPlan VARCHAR (50)
AS
	BEGIN
		INSERT INTO Escuela_PlanEstudio VALUES (@IDEscuela, @NumeroPlan)
	END

--- INSERTAR RELACIÓN PLANESTUDIO_CURSO

GO
CREATE PROCEDURE Insertar_PlanEstudio_Curso 
	@IDCurso VARCHAR (50),
    @NumeroPlan VARCHAR (50),
	@Bloque INT
AS
	BEGIN
		INSERT INTO PlanEstudio_Curso VALUES (@IDCurso, @NumeroPlan, @Bloque)
	END

----- PROCEDIMIENTOS DE CONSULTA DE LA BASE DE DATOS
--- CONSULTAR PLAN DE ESTUDIO

GO
CREATE PROCEDURE Mostrar_Plan_Estudios
	@NumeroPlan VARCHAR (50)
AS
	BEGIN
		SELECT Curso.IDCurso, Nombre, NumeroBloque, Horas_Lectivas, Creditos FROM Curso, PlanEstudio_Curso WHERE PlanEstudio_Curso.NumeroPlan = @NumeroPlan AND Curso.IDCurso = PlanEstudio_Curso.IDCurso
	END

--- CONSULTAR PLAN DE ESTUDIO CON CURSO EN COMÚN

GO
CREATE PROCEDURE Mostrar_Planes_Curso_Comun
	@IDCurso VARCHAR (50)
AS
	BEGIN
		SELECT NumeroPlan FROM PlanEstudio_Curso WHERE PlanEstudio_Curso.IDCurso = @IDCurso;
	END

--- CONSULTAR REQUISITOS DE UN CURSO

GO
CREATE PROCEDURE Mostrar_Requisitos_Curso
	@IDCursoConsultado VARCHAR (50)
AS
	BEGIN
		SELECT IDCursoRequisito, Nombre FROM Requisitos_Curso, Curso WHERE Requisitos_Curso.IDCursoConsultado = @IDCursoConsultado AND Curso.IDCurso = @IDCursoConsultado;
	END

--- CONSULTAR CORREQUISITOS DE UN CURSO

GO
CREATE PROCEDURE Mostrar_Correquisitos_Curso
	@IDCursoConsultado VARCHAR (50)
AS
	BEGIN
		SELECT IDCursoCorrequisito, Nombre FROM Correquisitos_Curso, Curso WHERE Correquisitos_Curso.IDCursoConsultado = @IDCursoConsultado AND Curso.IDCurso = @IDCursoConsultado;
	END

----- PROCEDIMIENTOS DE ELIMINACIÓN DE LA BASE DE DATOS
--- ELIMINAR UN REQUISITO DE UN CURSO

GO
CREATE PROCEDURE Eliminar_Requisito
    @IDCursoConsultado VARCHAR (50),
	@IDCursoRequisito VARCHAR (50)
AS
	BEGIN
		DELETE FROM Requisitos_Curso WHERE @IDCursoConsultado = Requisitos_Curso.IDCursoConsultado AND @IDCursoRequisito = Requisitos_Curso.IDCursoRequisito
	END

--- ELIMINAR UN CURSO DEL PLAN DE ESTUDIOS

GO
CREATE PROCEDURE Eliminar_Curso_Plan
	@IDCurso VARCHAR (50),
    @NumeroPlan VARCHAR (50)
AS
	BEGIN
		DELETE FROM PlanEstudio_Curso WHERE @NumeroPlan = PlanEstudio_Curso.NumeroPlan AND @IDCurso = PlanEstudio_Curso.IDCurso
	END

--- ELIMINAR UN CURSO

GO
CREATE PROCEDURE Eliminar_Curso
    @IDCurso VARCHAR (50)
AS
	BEGIN
		DELETE FROM Curso WHERE @IDCurso = Curso.IDCurso
	END
GO

----- INSERCIONES DE PRUEBA (APLICANDO PROCEDIMIENTOS)
EXECUTE Insertar_Escuela 'TI', 'Administración de Tecnología de Información'
EXECUTE Insertar_Plan '2051', '2020/01/01'
EXECUTE Insertar_Curso 'CI0200', 'Examen Diagnóstico', 0, 0
EXECUTE Insertar_Curso 'CI0202', 'Inglés Básico', 2, 3
EXECUTE Insertar_Curso 'MA0101', 'Matemática General', 2, 5
EXECUTE Insertar_Curso 'CI1106', 'Comunicación Escrita', 2, 3 
EXECUTE Insertar_Curso 'MA1403', 'Matemática Discreta', 4, 4 
EXECUTE Insertar_Curso 'SE1100', 'Actividad Cultural I', 0, 2 
EXECUTE Insertar_Curso 'TI1102', 'Información Contable', 3, 9 
EXECUTE Insertar_Curso 'TI1103', 'Modelos Organizaciones y Gestión de TI', 3, 9 
EXECUTE Insertar_Curso 'TI1400', 'Introducción a la Programación', 3, 4 
EXECUTE Insertar_Curso 'TI1401', 'Taller de Programación', 3, 4
EXECUTE Insertar_Curso 'CI1107', 'Comunicación Oral', 1, 3 
EXECUTE Insertar_Curso 'FH1000', 'Centros de Formaión Humanística', 0, 2 
EXECUTE Insertar_Curso 'MA1102', 'Cálculo Diferencial e Integral', 4, 5 
EXECUTE Insertar_Curso 'SE1200', 'Actividad Deportiva', 0, 2 
EXECUTE Insertar_Curso 'TI1201', 'Comportamiento Organizacional y Talento Humano', 3, 9 
EXECUTE Insertar_Curso 'TI2402', 'Algoritmos y Estructuras de Datos', 4, 4 
EXECUTE Insertar_Curso 'TI2404', 'Organización y Arquitectura de Computadores', 3, 4 
EXECUTE Insertar_Curso 'TI4500', 'Ingeniería de Requerimientos', 3, 4 
EXECUTE Insertar_Curso 'LU2021', 'Prueba de Luis', 3, 4 
EXECUTE Insertar_Requisitos_Curso 'MA1102', 'MA0101'
EXECUTE Insertar_Requisitos_Curso 'MA1102', 'MA1403'
EXECUTE Insertar_Requisitos_Curso 'TI1201', 'TI1103'
EXECUTE Insertar_Requisitos_Curso 'TI2402', 'TI1400'
EXECUTE Insertar_Requisitos_Curso 'TI2402', 'TI1401'
EXECUTE Insertar_Requisitos_Curso 'TI2404', 'TI1401'
EXECUTE Insertar_Requisitos_Curso 'TI4500', 'TI1400'
EXECUTE Insertar_Correquisitos_Curso 'TI1401', 'TI1400'
EXECUTE Insertar_Escuela_PlanEstudio 'TI', '2051'
EXECUTE Insertar_PlanEstudio_Curso 'CI0200', '2051', 0
EXECUTE Insertar_PlanEstudio_Curso 'CI0202', '2051', 0
EXECUTE Insertar_PlanEstudio_Curso 'MA0101', '2051', 0
EXECUTE Insertar_PlanEstudio_Curso 'CI1106', '2051', 1
EXECUTE Insertar_PlanEstudio_Curso 'MA1403', '2051', 1
EXECUTE Insertar_PlanEstudio_Curso 'SE1100', '2051', 1
EXECUTE Insertar_PlanEstudio_Curso 'TI1102', '2051', 1
EXECUTE Insertar_PlanEstudio_Curso 'TI1103', '2051', 1
EXECUTE Insertar_PlanEstudio_Curso 'TI1400', '2051', 1
EXECUTE Insertar_PlanEstudio_Curso 'TI1401', '2051', 1
EXECUTE Insertar_PlanEstudio_Curso 'CI1107', '2051', 2
EXECUTE Insertar_PlanEstudio_Curso 'FH1000', '2051', 2
EXECUTE Insertar_PlanEstudio_Curso 'MA1102', '2051', 2
EXECUTE Insertar_PlanEstudio_Curso 'SE1200', '2051', 2
EXECUTE Insertar_PlanEstudio_Curso 'TI1201', '2051', 2
EXECUTE Insertar_PlanEstudio_Curso 'TI2402', '2051', 2
EXECUTE Insertar_PlanEstudio_Curso 'TI2404', '2051', 2
EXECUTE Insertar_PlanEstudio_Curso 'TI4500', '2051', 2

EXECUTE Mostrar_Plan_Estudios '2051'

EXECUTE Mostrar_Planes_Curso_Comun 'MA1403'

EXECUTE Mostrar_Requisitos_Curso 'TI2404'

EXECUTE Mostrar_Correquisitos_Curso 'TI1401'

SELECT * FROM PlanEstudio_Curso
SELECT * FROM Curso

EXECUTE Insertar_Escuela 'IC', 'Ingeniería en Computadores'
DELETE FROM EscuelaOArea WHERE EscuelaOArea.IDEscuela = 'IC';

SELECT Curso.IDCurso, Curso.Nombre, PlanEstudio_Curso.NumeroBloque, Curso.Horas_Lectivas, Curso.Creditos FROM Curso, PlanEstudio_Curso WHERE PlanEstudio_Curso.NumeroPlan = '2051' AND Curso.IDCurso = PlanEstudio_Curso.IDCurso ORDER BY NumeroBloque

SELECT EscuelaOArea.Nombre, Escuela_PlanEstudio.NumeroPlan FROM EscuelaOArea, Escuela_PlanEstudio WHERE EscuelaOArea.Nombre = 'Administración de Tecnología de Información' AND Escuela_PlanEstudio.NumeroPlan = '2051'

SELECT Curso.IDCurso, Nombre, NumeroBloque, Horas_Lectivas, Creditos FROM Curso, PlanEstudio_Curso WHERE PlanEstudio_Curso.NumeroPlan = '2051' AND Curso.IDCurso = PlanEstudio_Curso.IDCurso ORDER BY(NumeroBloque)