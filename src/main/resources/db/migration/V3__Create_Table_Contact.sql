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