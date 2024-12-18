CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(400) NOT NULL,
    mensaje VARCHAR(1000) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(100) NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_topicos_autor FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    CONSTRAINT fk_topicos_curso FOREIGN KEY (curso_id) REFERENCES cursos (id)
);
