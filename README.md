# 🌟 Foro Hub - API REST para Gestión de Tópicos 🌟

Bienvenido a **Foro Hub**, un proyecto que replica el funcionamiento de un foro en el que los usuarios pueden interactuar mediante tópicos y respuestas. Este desafío de back-end utiliza **Spring Boot** para implementar una API REST funcional y bien estructurada.

---

## Tabla de Contenidos

- [📋 Descripción del Proyecto](#-descripción-del-proyecto)
- [⚙️ Funcionalidades](#️-funcionalidades)
- [💻 Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [🔧 Instalación y Configuración](#-instalación-y-configuración)
- [📑 Documentación de la API](#-documentación-de-la-api)
- [🖥️ Uso de la Aplicación](#️-uso-de-la-aplicación)
- [✅ Pruebas](#-pruebas)
- [🤝 Contribuciones](#-contribuciones)
- [📬 Contacto](#-contacto)

---

## 📋 Descripción del Proyecto

Foro Hub es una API REST diseñada para replicar el funcionamiento del back-end de un foro. Los usuarios pueden crear, leer, actualizar y eliminar tópicos, lo que permite gestionar de manera eficiente las interacciones de una comunidad.

El proyecto se enfoca en:

- **Persistencia de datos** en una base de datos relacional.
- **Validaciones** de las reglas de negocio.
- **Autenticación y autorización** para proteger los datos.
- **Documentación dinámica** generada con Swagger.

---

## ⚙️ Funcionalidades

- **🔧 CRUD de Tópicos**:
  - Crear un nuevo tópico.
  - Listar todos los tópicos creados.
  - Consultar un tópico específico.
  - Actualizar un tópico existente.
  - Eliminar un tópico.

- **🔒 Autenticación y Autorización**:
  - Acceso restringido a ciertas funcionalidades según el rol del usuario.

- **✅ Validaciones**:
  - Validaciones específicas basadas en reglas de negocio.

- **📦 Persistencia**:
  - Almacenamiento de datos en una base de datos relacional.

- **📑 Documentación Automática**:
  - Swagger para exponer la documentación interactiva de la API.

---

## 💻 Tecnologías Utilizadas

- **Java** - versión 17
- **Spring Boot** - versión 3.2.4
- **Spring Data JPA** - para operaciones de persistencia
- **PostgreSQL** - base de datos relacional
- **Spring Security** - para autenticación y autorización
- **Swagger** - para generación de documentación interactiva
- **Trello** - para organización y seguimiento del proyecto

---

## 🔧 Instalación y Configuración

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/tu-usuario/foro-hub.git
   cd foro-hub

## 📑 Documentación de la API

La documentación completa de la API REST está disponible y es accesible a través de Swagger en la siguiente URL:

**Swagger UI:** http://localhost:8080/swagger-ui/index.html
En esta documentación, encontrarás todas las rutas disponibles, ejemplos de solicitudes y respuestas, y detalles sobre los parámetros esperados.

---

## 🖥️ Uso de la Aplicación
La API REST de Foro Hub incluye las siguientes rutas principales:

## 📄 Rutas Disponibles

- **POST /topicos**
Crear un nuevo tópico.

- **GET /topicos**
Listar todos los tópicos registrados.

- **GET /topicos/{id}**
Consultar un tópico específico por su ID.

- **PUT /topicos/{id}**
Actualizar un tópico existente.

- **DELETE /topicos/{id}**
Eliminar un tópico por su ID.

---

## ✅ Pruebas
Para ejecutar las pruebas unitarias del proyecto:

    ```bash
    Copiar código
    ./mvnw test

**Pruebas incluidas:**
- **Verificación del funcionamiento de las rutas CRUD.**
- **Validaciones de las reglas de negocio.**
- **Pruebas de seguridad para autenticación y autorización.**

---

🤝 Contribuciones
¡Tu colaboración es bienvenida! Sigue estos pasos para contribuir:

Haz un fork del repositorio.

- **Crea una nueva rama para tu funcionalidad:**

- **Realiza tus cambios y haz commit:**

- **Envía tus cambios:**

- **Crea un Pull Request y describe tus cambios.**

---

## 📬 Contacto
Para dudas o sugerencias, puedes contactar a Tu Nombre:

- **GitHub:** https://github.com/elimes29
- **LinkedIn:** Elimes Rodríguez
- **CorreoElectrónico:** elimesrodriguez@gmail.com elimes29@gmail.com