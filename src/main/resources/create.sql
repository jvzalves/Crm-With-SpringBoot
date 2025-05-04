CREATE TABLE tb_enterprise (
    id BIGINT NOT NULL PRIMARY KEY,
    name_enterprise VARCHAR(255) NOT NULL
);

CREATE TABLE tb_contact (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255), 
    url VARCHAR(255),
    linkedin VARCHAR(255),
    phone VARCHAR(255),
    enterprise_id BIGINT,
    CONSTRAINT fk_contact_enterprise FOREIGN KEY (enterprise_id) REFERENCES tb_enterprise(id)
);

INSERT INTO tb_enterprise (id, name_enterprise) VALUES

(1, 'Nike'),
(2, 'Adidas'),
(3, 'Puma'),
(4, 'Penalt'),
(5, 'Olympikus');

INSERT INTO tb_contact (full_name, email, url, linkedin, phone, enterprise_id) VALUES 

('Joao Eduardo', 'joao@nike.com', 'nike.com', 'www.linkedin.com/in/joao-eduardo', '9900225566', 1),
('Maria Silva', 'maria@adidas.com', 'adidas.com', 'www.linkedin.com/in/maria-silva', '9900335566', 2),
('Carlos Pereira', 'carlos@puma.com', 'puma.com', 'www.linkedin.com/in/carlos-pereira', '9900445566', 3),
('Ana Souza', 'ana@penalt.com', 'penalt.com', 'www.linkedin.com/in/ana-souza', '9900555566', 4),
('Pedro Santos', 'pedro@olympikus.com', 'olympikus.com', 'www.linkedin.com/in/pedro-santos', '9900665566', 5);
