CREATE TABLE paciente (
	id INT NOT NULL AUTO_INCREMENT,
	ds_nome varchar(200) NOT NULL,
	sg_estado_civil varchar(3) NOT NULL,
	sg_sexo varchar(1) NOT NULL,
	ds_ocupacao varchar(200) NOT NULL,
	nr_telefone varchar(11) NOT NULL,
	cpf varchar(11) NOT NULL,
	in_ativo BOOLEAN NOT NULL,
	idade INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE endereco (
	id INT NOT NULL AUTO_INCREMENT,
	ds_endereco varchar(200) NOT NULL,
	cep varchar(8) NOT NULL,
	ds_complemento varchar(50) NOT NULL,
	cidade_id INT(10) NOT NULL,
	in_ativo BOOLEAN NOT NULL,
	paciente_id INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE cidade (
	id INT NOT NULL AUTO_INCREMENT,
	ds_nome varchar(200) NOT NULL,
	estado_id INT(10) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE estado (
	id INT NOT NULL AUTO_INCREMENT,
	sg_estado varchar(2) NOT NULL,
	ds_nome varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE avaliacao (
	id INT NOT NULL AUTO_INCREMENT,
	paciente_id INT NOT NULL,
	data_avaliacao DATETIME NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE endereco ADD CONSTRAINT endereco_fk0 FOREIGN KEY (cidade_id) REFERENCES cidade(id);

ALTER TABLE endereco ADD CONSTRAINT endereco_fk1 FOREIGN KEY (paciente_id) REFERENCES paciente(id);

ALTER TABLE cidade ADD CONSTRAINT cidade_fk0 FOREIGN KEY (estado_id) REFERENCES estado(id);

ALTER TABLE avaliacao ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (paciente_id) REFERENCES paciente(id);

