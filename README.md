# 💳 CrediYa

**CrediYa** es una plataforma que busca **digitalizar y optimizar la gestión de solicitudes de préstamos personales**, eliminando procesos manuales y presenciales.  

El sistema ofrece una **evaluación automatizada** de las solicitudes y permite que los administradores tomen decisiones finales de manera eficiente y transparente.

---

## 🚀 Funcionalidades principales

- **Gestión de tipos de préstamos:** crear, editar y eliminar productos de crédito.  
- **Proceso de solicitud:** los solicitantes pueden enviar sus datos y el monto deseado.  
- **Capacidad de endeudamiento:** evaluación automática para aprobar o rechazar solicitudes.  
- **Gestión de usuarios:** roles diferenciados para solicitantes y administradores.  
- **Notificaciones automáticas:** avisos en tiempo real sobre el estado del crédito.  
- **Reportes de rendimiento:** informes sobre préstamos aprobados, rechazados y métricas del negocio.  

---

## 🏗️ Arquitectura y Metodología

El proyecto sigue una **arquitectura de microservicios** y un enfoque basado en buenas prácticas de desarrollo:

- Cada microservicio se gestiona en un repositorio independiente.  
- Backend basado en **arquitectura hexagonal**.  
- Desarrollo con **Spring WebFlux** (programación reactiva).  
- **GitFlow** para gestión de ramas.  
- Validación de código con **SonarLint**.  
- Documentación de APIs con **Swagger/OpenAPI**.  
- **Pruebas unitarias** para cada microservicio.  
- Comunicación asíncrona mediante **SQS (colas de mensajes)**.  
- Despliegue en **AWS ECS con Fargate y API Gateway**.  
- Bases de datos:
  - **RDS** para datos transaccionales.  
  - **DynamoDB** para datos analíticos y reportes.  
- **Docker y AWS ECR** para control de versiones y CI/CD.  

---

## 📂 Estructura del repositorio

```bash
CrediYa/
│── docs/                # Documentación del proyecto
│── services/            # Microservicios (repositorios independientes)
│── api-gateway/         # Configuración del API Gateway
│── infra/               # Infraestructura y despliegue (ECS, Fargate, etc.)
│── README.md            # Este archivo
