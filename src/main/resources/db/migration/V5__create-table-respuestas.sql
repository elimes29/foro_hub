CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR(1000) NOT NULL,
    topico_id BIGINT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    autor BIGINT NOT NULL,
    solucion VARCHAR(1000),
    PRIMARY KEY (id),
    CONSTRAINT fk_respuestas_topico FOREIGN KEY (topico_id) REFERENCES topicos (id),
    CONSTRAINT fk_respuestas_autor FOREIGN KEY (autor) REFERENCES usuarios (id)
);
