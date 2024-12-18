CREATE TABLE usuarios_perfiles (
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    CONSTRAINT fk_usuarios FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    CONSTRAINT fk_perfiles FOREIGN KEY (perfil_id) REFERENCES perfiles (id)
);
