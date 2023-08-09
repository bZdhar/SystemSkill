-- CREATE DATABASE
-- CREATE DATABASE SistemaSkill;

-- CREATE SEQUENCES
CREATE SEQUENCE IF NOT EXISTS usuario_seq START 1;
CREATE SEQUENCE IF NOT EXISTS skill_seq START 1;
CREATE SEQUENCE IF NOT EXISTS level_seq START 1;

-- CREATE TABLES
CREATE TABLE IF NOT EXISTS usuario(
    usuario_id INT PRIMARY KEY,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS skill(
    skill_id INT PRIMARY KEY,
    name_skill VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS nivel(
    nivel_id INT PRIMARY KEY,
    name_nivel VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario_skill(
    usuario_id int NOT NULL references usuario,
    skill_id int NOT NULL references skill,
    nivel_id int NOT NULL references nivel,
    PRIMARY KEY(usuario_id, skill_id)
);

-- ADD VALUES TO SKILL
INSERT INTO skill(skill_id, name_skill)
  VALUES(nextval('skill_seq'), 'Javascript'),
  (nextval('skill_seq'), 'React'),
  (nextval('skill_seq'), 'ReactNative'),
  (nextval('skill_seq'), 'PHP'),
  (nextval('skill_seq'), 'Java'),
  (nextval('skill_seq'), 'Typescript'),
  (nextval('skill_seq'), 'Python'),
  (nextval('skill_seq'), 'C#'),
  (nextval('skill_seq'), 'C++'),
  (nextval('skill_seq'), 'Ruby'),
  (nextval('skill_seq'), 'Swift'),
  (nextval('skill_seq'), 'Kotlin'),
  (nextval('skill_seq'), 'Rust'),
  (nextval('skill_seq'), 'Go');

-- ADD VALUES TO LEVEL
INSERT INTO nivel(nivel_id, name_nivel)
    VALUES(nextval('level_seq'), 'Iniciante'),
    (nextval('level_seq'), 'Intermediário'),
    (nextval('level_seq'), 'Avançado');

