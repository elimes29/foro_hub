<h1 align="center">?? Foro Hub - API REST para Gesti��n de T��picos ??</h1>

<p align="center">
    Bienvenido a <strong>Foro Hub</strong>, un proyecto que replica el funcionamiento de un foro en el que los usuarios pueden interactuar mediante t��picos y respuestas. Este desaf��o de back-end utiliza <strong>Spring Boot</strong> para implementar una API REST funcional y bien estructurada.
</p>

<p align="center">
    <a href="#-descripci��n-del-proyecto">Descripci��n</a> ?
    <a href="#-funcionalidades">Funcionalidades</a> ?
    <a href="#-tecnolog��as-utilizadas">Tecnolog��as</a> ?
    <a href="#-instalaci��n-y-configuraci��n">Instalaci��n</a> ?
    <a href="#-documentaci��n-de-la-api">Documentaci��n</a> ?
    <a href="#-uso-de-la-aplicaci��n">Uso</a> ?
    <a href="#-pruebas">Pruebas</a> ?
    <a href="#-contribuciones">Contribuciones</a> ?
    <a href="#-contacto">Contacto</a>
</p>

---

## ?? Descripci��n del Proyecto

Foro Hub es una API REST dise?ada para replicar el funcionamiento del back-end de un foro. Los usuarios pueden crear, leer, actualizar y eliminar t��picos, lo que permite gestionar de manera eficiente las interacciones de una comunidad.

El proyecto se enfoca en:

- **Persistencia de datos** en una base de datos relacional.
- **Validaciones** de las reglas de negocio.
- **Autenticaci��n y autorizaci��n** para proteger los datos.
- **Documentaci��n din��mica** generada con Swagger.

---

## ?? Funcionalidades

- **?? CRUD de T��picos**:
  - **Crear un nuevo t��pico**.
  - **Listar todos los t��picos creados**.
  - **Consultar un t��pico espec��fico**.
  - **Actualizar un t��pico existente**.
  - **Eliminar un t��pico**.

- **?? Autenticaci��n y Autorizaci��n**:
  - Acceso restringido a ciertas funcionalidades seg��n el rol del usuario.

- **? Validaciones**:
  - Validaciones espec��ficas basadas en reglas de negocio.

- **?? Persistencia**:
  - Almacenamiento de datos en una base de datos relacional.

- **?? Documentaci��n Autom��tica**:
  - Swagger para exponer la documentaci��n interactiva de la API.

---

## ?? Tecnolog��as Utilizadas

- **Java** - versi��n 17
- **Spring Boot** - versi��n 3.2.4
- **Spring Data JPA** - para operaciones de persistencia
- **PostgreSQL** - base de datos relacional
- **Spring Security** - para autenticaci��n y autorizaci��n
- **Swagger** - para generaci��n de documentaci��n interactiva
- **Trello** - para organizaci��n y seguimiento del proyecto

---

## ?? Instalaci��n y Configuraci��n

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/tu-usuario/foro-hub.git
   cd foro-hub
   
2. **Configura la base de datos**:
Aseg��rate de tener PostgreSQL instalado y crea una base de datos para el proyecto. Configura las credenciales en el archivo application.properties de Spring Boot:

properties
Copiar c��digo
spring.datasource.url=jdbc:postgresql://localhost:5432/foroHubDB
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contrase?a

3. **Ejecuta el proyecto**:

Utiliza Maven para correr el proyecto:

bash
Copiar c��digo
./mvnw spring-boot:run

##?? Documentaci��n de la API
La documentaci��n completa de la API REST est�� disponible y es accesible a trav��s de Swagger en la siguiente URL:

- **Swagger UI**: http://localhost:8080/swagger-ui/index.html
En esta documentaci��n, encontrar��s todas las rutas disponibles, ejemplos de solicitudes y respuestas, y detalles sobre los par��metros esperados.

##??? Uso de la Aplicaci��n
La API REST de Foro Hub incluye las siguientes rutas principales:

##?? Rutas Disponibles
-**POST /topicos**
Crear un nuevo t��pico.

-**GET /topicos**
Listar todos los t��picos registrados.

-**GET /topicos/{id}**
Consultar un t��pico espec��fico por su ID.

-**PUT /topicos/{id}**
Actualizar un t��pico existente.

-**DELETE /topicos/{id}**
Eliminar un t��pico por su ID.

##? Pruebas
Para ejecutar las pruebas unitarias del proyecto:

bash
./mvnw test
Pruebas incluidas:

**Verificaci��n del funcionamiento de las rutas CRUD.**
Validaciones de las reglas de negocio.
Pruebas de seguridad para autenticaci��n y autorizaci��n.

##?? Contribuciones
?Tu colaboraci��n es bienvenida! Sigue estos pasos para contribuir:

Haz un fork del repositorio.

Crea una nueva rama para tu funcionalidad:

bash
Copiar c��digo
git checkout -b feature/mi-feature
Realiza tus cambios y haz commit:

bash
Copiar c��digo
git commit -m 'Agrega mi-feature'
Env��a tus cambios:

bash
Copiar c��digo
git push origin feature/mi-feature
Crea un Pull Request y describe tus cambios.

##?? Contacto
Para dudas o sugerencias, puedes contactar a [Tu Nombre]:

-**GitHub:** https://github.com/elimes29
-**LinkedIn:** Elimes Rodr��guez


