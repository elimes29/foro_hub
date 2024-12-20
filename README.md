<h1 align="center">?? Foro Hub - API REST para Gesti車n de T車picos ??</h1>

<p align="center">
    Bienvenido a <strong>Foro Hub</strong>, un proyecto que replica el funcionamiento de un foro en el que los usuarios pueden interactuar mediante t車picos y respuestas. Este desaf赤o de back-end utiliza <strong>Spring Boot</strong> para implementar una API REST funcional y bien estructurada.
</p>

<p align="center">
    <a href="#-descripci車n-del-proyecto">Descripci車n</a> ?
    <a href="#-funcionalidades">Funcionalidades</a> ?
    <a href="#-tecnolog赤as-utilizadas">Tecnolog赤as</a> ?
    <a href="#-instalaci車n-y-configuraci車n">Instalaci車n</a> ?
    <a href="#-documentaci車n-de-la-api">Documentaci車n</a> ?
    <a href="#-uso-de-la-aplicaci車n">Uso</a> ?
    <a href="#-pruebas">Pruebas</a> ?
    <a href="#-contribuciones">Contribuciones</a> ?
    <a href="#-contacto">Contacto</a>
</p>

---

## ?? Descripci車n del Proyecto

Foro Hub es una API REST dise?ada para replicar el funcionamiento del back-end de un foro. Los usuarios pueden crear, leer, actualizar y eliminar t車picos, lo que permite gestionar de manera eficiente las interacciones de una comunidad.

El proyecto se enfoca en:

- **Persistencia de datos** en una base de datos relacional.
- **Validaciones** de las reglas de negocio.
- **Autenticaci車n y autorizaci車n** para proteger los datos.
- **Documentaci車n din芍mica** generada con Swagger.

---

## ?? Funcionalidades

- **?? CRUD de T車picos**:
  - **Crear un nuevo t車pico**.
  - **Listar todos los t車picos creados**.
  - **Consultar un t車pico espec赤fico**.
  - **Actualizar un t車pico existente**.
  - **Eliminar un t車pico**.

- **?? Autenticaci車n y Autorizaci車n**:
  - Acceso restringido a ciertas funcionalidades seg迆n el rol del usuario.

- **? Validaciones**:
  - Validaciones espec赤ficas basadas en reglas de negocio.

- **?? Persistencia**:
  - Almacenamiento de datos en una base de datos relacional.

- **?? Documentaci車n Autom芍tica**:
  - Swagger para exponer la documentaci車n interactiva de la API.

---

## ?? Tecnolog赤as Utilizadas

- **Java** - versi車n 17
- **Spring Boot** - versi車n 3.2.4
- **Spring Data JPA** - para operaciones de persistencia
- **PostgreSQL** - base de datos relacional
- **Spring Security** - para autenticaci車n y autorizaci車n
- **Swagger** - para generaci車n de documentaci車n interactiva
- **Trello** - para organizaci車n y seguimiento del proyecto

---

## ?? Instalaci車n y Configuraci車n

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/tu-usuario/foro-hub.git
   cd foro-hub
   
2. **Configura la base de datos**:
Aseg迆rate de tener PostgreSQL instalado y crea una base de datos para el proyecto. Configura las credenciales en el archivo application.properties de Spring Boot:

properties
Copiar c車digo
spring.datasource.url=jdbc:postgresql://localhost:5432/foroHubDB
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contrase?a

3. **Ejecuta el proyecto**:

Utiliza Maven para correr el proyecto:

bash
Copiar c車digo
./mvnw spring-boot:run

##?? Documentaci車n de la API
La documentaci車n completa de la API REST est芍 disponible y es accesible a trav谷s de Swagger en la siguiente URL:

- **Swagger UI**: http://localhost:8080/swagger-ui/index.html
En esta documentaci車n, encontrar芍s todas las rutas disponibles, ejemplos de solicitudes y respuestas, y detalles sobre los par芍metros esperados.

##??? Uso de la Aplicaci車n
La API REST de Foro Hub incluye las siguientes rutas principales:

##?? Rutas Disponibles
-**POST /topicos**
Crear un nuevo t車pico.

-**GET /topicos**
Listar todos los t車picos registrados.

-**GET /topicos/{id}**
Consultar un t車pico espec赤fico por su ID.

-**PUT /topicos/{id}**
Actualizar un t車pico existente.

-**DELETE /topicos/{id}**
Eliminar un t車pico por su ID.

##? Pruebas
Para ejecutar las pruebas unitarias del proyecto:

bash
./mvnw test
Pruebas incluidas:

**Verificaci車n del funcionamiento de las rutas CRUD.**
Validaciones de las reglas de negocio.
Pruebas de seguridad para autenticaci車n y autorizaci車n.

##?? Contribuciones
?Tu colaboraci車n es bienvenida! Sigue estos pasos para contribuir:

Haz un fork del repositorio.

Crea una nueva rama para tu funcionalidad:

bash
Copiar c車digo
git checkout -b feature/mi-feature
Realiza tus cambios y haz commit:

bash
Copiar c車digo
git commit -m 'Agrega mi-feature'
Env赤a tus cambios:

bash
Copiar c車digo
git push origin feature/mi-feature
Crea un Pull Request y describe tus cambios.

##?? Contacto
Para dudas o sugerencias, puedes contactar a [Tu Nombre]:

-**GitHub:** https://github.com/elimes29
-**LinkedIn:** Elimes Rodr赤guez


