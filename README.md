# API REST de Certificados (Arquitectura Hexagonal + JWT)

API RESTful desarrollada en Java 17 + Spring Boot 3.3.0 para la gestión de certificados digitales, implementando seguridad con JWT y conexión a SQL Server.

## 🛠️ Tecnologías utilizadas
- **Java 17** / **Spring Boot 3.3.0**
- **Spring Security + JWT** (Stateless)
- **Spring Data JPA / Hibernate**
- **SQL Server**
- **Arquitectura Hexagonal** (Puertos y Adaptadores)
- **Maven**

## 🏗️ Arquitectura
El proyecto está dividido en capas siguiendo los principios de la arquitectura hexagonal:
- `domain`: Modelos de negocio y puertos (interfaces).
- `application`: Casos de uso y DTOs.
- `infrastructure`: Adaptadores de persistencia (JPA), seguridad (JWT) y web (Controllers).

## 🚀 Cómo ejecutar el proyecto
1. Clona este repositorio.
2. Renombra el archivo `application.example.yml` a `application.yml`.
3. Configura tus credenciales de SQL Server y tu clave secreta para JWT en el nuevo archivo.
4. Ejecuta la clase `ApiRestfullApplication`.

## 🔒 Endpoints principales
- `POST /api/auth/login`: Obtener el token JWT.
- `POST /api/certificados`: Crear un certificado (Requiere Token).
- `GET /api/certificados`: Listar certificados (Requiere Token).
- `PATCH /api/certificados/{id}/revocar`: Revocar certificado (Requiere Token).
- `DELETE /api/certificados/{id}`: Eliminar certificado (Requiere Token).
