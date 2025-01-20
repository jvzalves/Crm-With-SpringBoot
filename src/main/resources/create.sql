CREATE TABLE tb_responsible (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    responsible_user VARCHAR(255)
);

CREATE TABLE tb_enterprise (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_enterprise VARCHAR(255),
    responsible_id BIGINT,
    CONSTRAINT fk_enterprise_responsible FOREIGN KEY (responsible_id) REFERENCES tb_responsible(id)
);

CREATE TABLE tb_contact (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    email VARCHAR(255), 
    url VARCHAR(255),
    linkedin VARCHAR(255),
    position VARCHAR(255),
    phone VARCHAR(255),
    enterprise_id BIGINT,
    responsible_id BIGINT,
    CONSTRAINT fk_contact_enterprise FOREIGN KEY (enterprise_id) REFERENCES tb_enterprise(id),
    CONSTRAINT fk_contact_responsible FOREIGN KEY (responsible_id) REFERENCES tb_responsible(id)
);

INSERT INTO tb_responsible (responsible_user) VALUES ('Joao Vitor');

INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Nike', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Adidas', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Puma', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Penalt', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Olympikus', 1);

INSERT INTO tb_contact (full_name, email, url, linkedin, phone, responsible_id, enterprise_id) 
VALUES 
('Joao Eduardo', 'joao@nike.com', 'nike.com', 'www.linkedin.com/in/joao-eduardo', '9900225566', 1, 1),
('Maria Silva', 'maria@adidas.com', 'adidas.com', 'www.linkedin.com/in/maria-silva', '9900335566', 1, 2),
('Carlos Pereira', 'carlos@puma.com', 'puma.com', 'www.linkedin.com/in/carlos-pereira', '9900445566', 1, 3),
('Ana Souza', 'ana@penalt.com', 'penalt.com', 'www.linkedin.com/in/ana-souza', '9900555566', 1, 4),
('Pedro Santos', 'pedro@olympikus.com', 'olympikus.com', 'www.linkedin.com/in/pedro-santos', '9900665566', 1, 5);
