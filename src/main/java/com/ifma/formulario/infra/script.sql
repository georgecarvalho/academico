CREATE DATABASE IF NOT EXISTS academico DEFAULT CHARACTER SET utf8 ;
USE academico ;

-- -----------------------------------------------------
-- Table aluno
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS aluno (
  id INT(11) NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(45) NOT NULL UNIQUE,
  nome VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NULL,
  endereco VARCHAR(45) NULL,
  rg VARCHAR(45) NULL,
  cpf VARCHAR(45) NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table curso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS curso (
  id INT(11) NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(45) NOT NULL UNIQUE,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table professor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS professor (
  id INT(11) NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(45) NOT NULL UNIQUE,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table disciplina
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS disciplina (
  id INT(11) NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(45) NOT NULL UNIQUE,
  nome VARCHAR(45) NOT NULL,
  ementa VARCHAR(45) NULL,
  cargaHoraria INT NULL,
  professor_id INT(11) UNIQUE,
  PRIMARY KEY (id),
  FOREIGN KEY (professor_id)
  REFERENCES professor(id)
);


-- -----------------------------------------------------
-- Table aluno_curso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS aluno_curso (
  aluno_id INT(11) NOT NULL,
  curso_id INT(11) NOT NULL,
  PRIMARY KEY (aluno_id, curso_id),
    FOREIGN KEY (aluno_id)
    REFERENCES aluno (id),
    FOREIGN KEY (curso_id)
    REFERENCES curso (id)
);


-- -----------------------------------------------------
-- Table curso_disciplina
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS curso_disciplina (
  curso_id INT(11) NOT NULL,
  disciplina_id INT(11) NOT NULL,
  PRIMARY KEY (curso_id, disciplina_id),
  FOREIGN KEY (curso_id)
  REFERENCES curso (id),
  FOREIGN KEY (disciplina_id)
  REFERENCES disciplina (id)
);

-- alunoDROP SCHEMA academico;
-- TRUNCATE TABLE aluno;
-- TRUNCATE TABLE curso;
-- TRUNCATE TABLE professor;
-- TRUNCATE TABLE disciplina;
-- SELECT * FROM aluno;
-- SELECT * FROM curso;
-- SELECT * FROM professor;
-- SELECT * FROM disciplina;