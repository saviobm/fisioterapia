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

CREATE TABLE patologia (
	id INT NOT NULL AUTO_INCREMENT,
	sigla VARCHAR(20),
	descricao VARCHAR(300),
	PRIMARY KEY (id)
)

CREATE TABLE avaliacao (
	id INT NOT NULL AUTO_INCREMENT,
	paciente_id INT NOT NULL,	
	data_avaliacao DATETIME NOT NULL,
	patologia_id int NULL,
	cid VARCHAR(200) NULL,
	desc_uso_medicamentos TEXT NULL,
	desc_princ_queixas TEXT NULL,
	hma TEXT NULL,		
	mini_mental_id INT NOT NULL,
	desc_aspecto_secrecao VARCHAR(300) NULL,	
	PRIMARY KEY (id)
);


CREATE TABLE mini_mental(
	id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id)
)


CREATE TABLE habitos (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE habitos ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE sinal_vital (
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(200) NOT NULL,
	descricao VARCHAR(300) NOT NULL,
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE sinal_vital ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE mini_mental (
	id INT NOT NULL AUTO_INCREMENT,	
	PRIMARY KEY (id),
	avaliacao_id INT NOT NULL
)

ALTER TABLE mini_mental ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE nivel_consciencia (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE nivel_consciencia ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE estado_emocional (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE estado_emocional ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);

CREATE TABLE sistema_respiratorio (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,
	observacao VARCHAR(200) NULL,
	tem_observacao BOOLEAN NULL,
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE sistema_respiratorio ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE ritmo (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,	
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE ritmo ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE padrao_muscular_respiratorio (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,	
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE padrao_muscular_respiratorio ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE ausculta_pulmonar (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,	
	observacao VARCHAR(200) NULL,
	tem_observacao BOOLEAN NULL,
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE ausculta_pulmonar ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE tipo_tosse (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,		
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE tipo_tosse ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);


CREATE TABLE tipo_sistema_osteomiarticular (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,		
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE tipo_sistema_osteomiarticular ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);

CREATE TABLE forca_muscular (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,		
	avaliacao_id INT NOT NULL,
	membro_id INT NULL,	
	PRIMARY KEY (id)
)

ALTER TABLE forca_muscular ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (avaliacao_id) REFERENCES avaliacao(id);
ALTER TABLE membro ADD CONSTRAINT membro_fk0 FOREIGN KEY (membro_id) REFERENCES membro(id);


CREATE TABLE membros (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,			
	articulacao_id INT NULL,
	PRIMARY KEY (id)
)

ALTER TABLE articulacao ADD CONSTRAINT articulacao_fk0 FOREIGN KEY (articulacao_id) REFERENCES articulacao(id);





CREATE TABLE forca_muscular (
	id INT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	sigla VARCHAR(3) NULL,		
	avaliacao_id INT NOT NULL,
	PRIMARY KEY (id)
)






ALTER TABLE avaliacao ADD CONSTRAINT paciente_fk0 FOREIGN KEY (paciente_id) REFERENCES paciente(id);
ALTER TABLE avaliacao ADD CONSTRAINT patologia_fk0 FOREIGN KEY (patologia_id) REFERENCES patolodia(id);
ALTER TABLE avaliacao ADD CONSTRAINT mini_mental_fk0 FOREIGN KEY (mini_mental_id) REFERENCES mini_mental(id);


ALTER TABLE endereco ADD CONSTRAINT endereco_fk0 FOREIGN KEY (cidade_id) REFERENCES cidade(id);

ALTER TABLE endereco ADD CONSTRAINT endereco_fk1 FOREIGN KEY (paciente_id) REFERENCES paciente(id);

ALTER TABLE cidade ADD CONSTRAINT cidade_fk0 FOREIGN KEY (estado_id) REFERENCES estado(id);

ALTER TABLE avaliacao ADD CONSTRAINT avaliacao_fk0 FOREIGN KEY (paciente_id) REFERENCES paciente(id);

