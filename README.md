# AGENCIA VENTA DE VEHÍCULOS

Este repositorio contiene el proyecto **Agencia Venta de Vehículos**, una aplicación backend diseñada para la gestión y venta de vehículos. Está construido utilizando **SPRINGBOOT** **Java** y tecnologías relacionadas, con un enfoque en buenas prácticas de desarrollo, arquitectura limpia y principios de diseño.

---

## Tabla de Contenidos

1. [Descripción](#descripción)
2. [Características](#características)
3. [Tecnologías Utilizadas](#tecnologías-utilizadas)
4. [Requisitos Previos](#requisitos-previos)
5. [Instalación y Configuración](#instalación-y-configuración)
6. [Uso](#uso)
7. [Arquitectura](#arquitectura)
8. [Contacto](#contacto)

---

## Descripción

El proyecto **Agencia Venta de Vehículos** es una solución backend diseñada para cubrir las necesidades de administración de una agencia de autos. Permite gestionar vehículos, clientes y ventas, proporcionando una API RESTful que puede integrarse con aplicaciones frontend o móviles.

### Objetivos del Proyecto:

- Gestionar el inventario de vehículos disponibles.
- Registrar información de clientes.
- Administrar las ventas de vehículos.
- Asegurar una experiencia de desarrollo escalable y mantenible.

---

## Características

- Gestión CRUD para vehículos, clientes y ventas.
- API RESTful con endpoints documentados.
- Validación y manejo de errores.
- Persistencia de datos con una base de datos relacional.
- Uso de principios SOLID y buenas prácticas de desarrollo.

---

## Tecnologías Utilizadas

- **Lenguaje:** Java 17+
- **Framework Backend:** Spring Boot
- **Base de Datos:** MySQL / H2 (configuración en memoria para pruebas)
- **Dependencias Principales:**
  - Spring Data JPA
  - Spring Web
  - Spring Validation
- **Herramientas:** Maven, Postman (para pruebas de API)
- **Control de Versiones:** Git

---

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

1. **Java Development Kit (JDK)** 17 o superior.
2. **Maven** para la gestión de dependencias.
3. **MySQL** (o una base de datos compatible, si se configura localmente).
4. **Postman** o cualquier cliente HTTP para probar la API (opcional).

---

## Instalación y Configuración

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/matiasborneman/AGENCIA-VENTA-DE-VEHICULOS.git
   cd AGENCIA-VENTA-DE-VEHICULOS
   # AGENCIA VENTA DE VEHÍCULOS


---

## Uso

### Endpoints Principales:

- **Vehículos:**
  - GET `/vehiculos`: Listar vehículos.
  - POST `/vehiculos`: Crear un nuevo vehículo.
  - PUT `/vehiculos/{id}`: Actualizar un vehículo.
  - DELETE `/vehiculos/{id}`: Eliminar un vehículo.

- **Clientes:**
  - GET `/clientes`: Listar clientes.
  - POST `/clientes`: Crear un nuevo cliente.
  - PUT `/clientes/{id}`: Actualizar un cliente.
  - DELETE `/clientes/{id}`: Eliminar un cliente.

- **Ventas:**
  - GET `/ventas`: Listar ventas.
  - POST `/ventas`: Registrar una nueva venta.

Consulta la documentación de la API para más detalles sobre los parámetros y formatos de las solicitudes.

---

## Arquitectura

El proyecto sigue una arquitectura **MVC (Modelo-Vista-Controlador)** con las siguientes capas principales:

- **Controladores:** Gestión de las solicitudes HTTP y respuestas.
- **Servicios:** Lógica de negocio.
- **Repositorios:** Interacción con la base de datos utilizando Spring Data JPA.
- **Modelos:** Representación de las entidades de datos.

---

## Contacto

**Autor:** Matias Ezequiel Borneman  
**Email:** [matias_borneman@hotmail.com](mailto:matias_borneman@hotmail.com)  
**GitHub:** [matiasborneman](https://github.com/matiasborneman)

Si tienes alguna duda o sugerencia sobre el proyecto, no dudes en contactarme.

