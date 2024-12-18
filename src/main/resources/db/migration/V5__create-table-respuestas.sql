CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR(1000) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    topico BIGINT NOT NULL,
    usuario BIGINT NOT NULL,
    solucion VARCHAR(1000),
    PRIMARY KEY (id),
    CONSTRAINT fk_respuestas_topico FOREIGN KEY (topico) REFERENCES topicos (id),
    CONSTRAINT fk_respuestas_usuario FOREIGN KEY (usuario) REFERENCES usuarios (id)
);
