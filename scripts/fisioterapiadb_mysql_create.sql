CREATE TABLE paciente (
	id INT NOT NULL AUTO_INCREMENT,
	ds_nome varchar(200) NOT NULL,
	sg_estado_civil varchar(3) NOT NULL,
	sg_sexo varchar(1) NOT NULL,
	ds_ocupacao varchar(200) NOT NULL,
	nr_telefone varchar(11) NOT NULL,
	cpf varchar(11) NOT NULL,
	id_endereco INT(10) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE endereco (
	id INT NOT NULL AUTO_INCREMENT,
	ds_endereco varchar(200) NOT NULL,
	cep varchar(8) NOT NULL,
	ds_complemento varchar(50) NOT NULL,
	id_cidade INT(10) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE cidade (
	id INT NOT NULL AUTO_INCREMENT,
	ds_nome varchar(200) NOT NULL,
	id_estado INT(10) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE estado (
	id INT NOT NULL AUTO_INCREMENT,
	sg_estado varchar(2) NOT NULL,
	ds_nome varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE paciente ADD CONSTRAINT paciente_fk0 FOREIGN KEY (id_endereco) REFERENCES endereco(id);

ALTER TABLE endereco ADD CONSTRAINT endereco_fk0 FOREIGN KEY (id_cidade) REFERENCES cidade(id);

ALTER TABLE cidade ADD CONSTRAINT cidade_fk0 FOREIGN KEY (id_estado) REFERENCES estado(id);