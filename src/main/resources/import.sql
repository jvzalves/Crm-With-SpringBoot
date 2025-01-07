INSERT INTO tb_responsible (responsible_user) VALUES ('Joao Vitor');

INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Nike', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Adidas', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Puma', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Penalt', 1);
INSERT INTO tb_enterprise (name_enterprise, responsible_id) VALUES ('Olympikus', 1);

INSERT INTO tb_contact (full_name, email, url, linkedin, phone, responsible_id, enterprise_id) VALUES ('Joao Eduardo', 'joao@nike.com', 'nike.com', 'www.linkedin.com/in/joao-eduardo', '9900225566', 1, 1);
INSERT INTO tb_contact (full_name, email, url, linkedin, phone, responsible_id, enterprise_id) VALUES ('Maria Silva', 'maria@adidas.com', 'adidas.com', 'www.linkedin.com/in/maria-silva', '9900335566', 1, 2);
INSERT INTO tb_contact (full_name, email, url, linkedin, phone, responsible_id, enterprise_id) VALUES ('Carlos Pereira', 'carlos@puma.com', 'puma.com', 'www.linkedin.com/in/carlos-pereira', '9900445566', 1, 3);
INSERT INTO tb_contact (full_name, email, url, linkedin, phone, responsible_id, enterprise_id) VALUES ('Ana Souza', 'ana@penalt.com', 'penalt.com', 'www.linkedin.com/in/ana-souza', '9900555566', 1, 4);
INSERT INTO tb_contact (full_name, email, url, linkedin, phone, responsible_id, enterprise_id) VALUES ('Pedro Santos', 'pedro@olympikus.com', 'olympikus.com', 'www.linkedin.com/in/pedro-santos', '9900665566', 1, 5);
;
