# MARS - Motor de Analítica de Rendimiento y Scouting ⚽📊

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Supabase-blue?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Ready-blue?style=for-the-badge&logo=docker)
![Render](https://img.shields.io/badge/Render-Deployed-black?style=for-the-badge&logo=render)

## 🚀 Misión del Proyecto
**MARS** es una plataforma de inteligencia deportiva de vanguardia inspirada en la filosofía *Moneyball*. Su objetivo principal es optimizar el scouting de fichajes en La Liga mediante el **Índice de Eficiencia de Mercado (IEM)**. 

El sistema permite a los clubes identificar talentos infravalorados, cruzando métricas de rendimiento deportivo con datos financieros, asegurando que cada euro invertido maximice el potencial competitivo del equipo.

---

## 🛠️ Logros Técnicos

### 🔒 Validación de Datos Sensibles (Back-End)
Se ha implementado un sistema robusto de integridad de datos utilizando **Bean Validation (JSR-380)**. 
- En la entidad `Club`, el campo **presupuesto** está estrictamente validado en el servidor.
- El controlador Java utiliza la anotación `@Valid` y `BindingResult` para asegurar que ningún club sea registrado con un presupuesto inferior a **100,000€**, cumpliendo con los estándares de membresía de la plataforma MARS antes de cualquier persistencia en la base de datos.

### 🌊 Entradas de Datos Complejas (Cascada)
El **Buscador de Scouting** ofrece una experiencia de usuario dinámica y fluida mediante una lógica de **Dropdowns en Cascada**:
- **Interacción Asíncrona**: Al seleccionar un *Estilo de Juego*, el sistema activa una petición asíncrona mediante la **Fetch API** de JavaScript.
- **Endpoints JSON**: El servidor expone endpoints REST específicos que devuelven listas filtradas de jugadores en formato JSON, permitiendo que el segundo dropdown se pueble dinámicamente sin recargar la página.

---

## 💻 Stack Tecnológico

### Backend
- **Lenguaje:** Java 21
- **Framework:** Spring Boot 4.0.6
- **Persistencia:** Spring Data JPA / Hibernate

### Frontend
- **Motor de Plantillas:** Thymeleaf
- **Estilos:** Bootstrap 5 (Rich Aesthetics)
- **Lógica:** JavaScript (Fetch API)

### Infraestructura
- **Base de Datos:** PostgreSQL (Alojado en Supabase)
- **Contenedorización:** Docker (Construcción multietapa)
- **Despliegue:** Render Cloud

---

## 🌐 Enlace Oficial de Producción
Accede a la plataforma en vivo aquí:
👉 **[https://mars-admin-web.onrender.com](https://mars-admin-web.onrender.com)**

---

## 📄 Instalación y Uso
1. Clona el repositorio.
2. Configura las variables de entorno para la base de datos en `application.properties`.
3. Ejecuta `./mvnw spring-boot:run` o utiliza el `Dockerfile` proporcionado:
   ```bash
   docker build -t mars-admin .
   docker run -p 8080:8080 mars-admin
   ```

---
**Desarrollado con ❤️ para la eficiencia deportiva.**
