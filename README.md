# App-Recordatorio

Una aplicación Java Spring Boot para gestionar recordatorios y tareas de forma eficiente.

## 📋 Descripción

**App-Recordatorio** es una aplicación web desarrollada con Spring Boot que permite a los usuarios crear, gestionar y organizar recordatorios personalizados. La aplicación proporciona una interfaz intuitiva para mantener un seguimiento de tareas importantes.

## 🚀 Características

- ✅ Crear, editar y eliminar recordatorios
- ✅ Autenticación y seguridad de usuarios
- ✅ Validación de datos robusta
- ✅ Persistencia de datos con base de datos PostgreSQL
- ✅ API REST completa
- ✅ Control de acceso basado en roles

## 🛠️ Tecnologías Utilizadas

- **Java 17** - Lenguaje de programación
- **Spring Boot 4.0.6** - Framework principal
- **Spring Security** - Autenticación y autorización
- **Spring Data JPA** - Acceso a datos
- **PostgreSQL** - Base de datos
- **Maven** - Gestor de dependencias
- **Lombok** - Generación de código boilerplate

# 📁Estructura
App-Recordatorio/
├── App/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/mi_proyecto/App/
│   │   │   │       └── (Código fuente principal)
│   │   │   └── resources/
│   │   │       └── (Configuraciones)
│   │   └── test/
│   │       └── (Pruebas unitarias)
│   ├── pom.xml
│   └── mvnw
└── README.md

🔐 Autenticación
La aplicación utiliza Spring Security para proteger los endpoints. Asegúrate de proporcionar las credenciales necesarias en las solicitudes autenticadas.

👨‍💻 Autor
TyroneJos3

### Dependencias Principales

```xml
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-validation
- spring-boot-starter-webmvc
- postgresql
- lombok

