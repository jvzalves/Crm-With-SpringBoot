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
    phone VARCHAR(255),
    enterprise_id BIGINT,
    responsible_id BIGINT,
    CONSTRAINT fk_contact_enterprise FOREIGN KEY (enterprise_id) REFERENCES tb_enterprise(id),
    CONSTRAINT fk_contact_responsible FOREIGN KEY (responsible_id) REFERENCES tb_responsible(id)
);