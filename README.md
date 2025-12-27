# Account Service – Quarkus

Microservicio desarrollado con **Quarkus**.

---

## Arquitectura

- Microservicio independiente
- Exposición de endpoints REST
- Seguridad basada en **JWT (RS256)**
- Observabilidad con **Health Checks** y **Métricas Prometheus**
- Persistencia con **Hibernate ORM + Panache**

---

## Tecnologías

- Java 21
- Quarkus
- Hibernate ORM with Panache
- SmallRye JWT
- MicroProfile Metrics
- PostgreSQL
- Maven

---

## Funcionalidad Implementada (RF2)

### RF2: Consulta de cuentas

✔ Endpoint REST para obtener una cuenta por el accountNumber  
✔ Obtener una lista de cuentas por customerId 
✔ Manejo de excepciones personalizado  
✔ Uso de DTOs y Mappers  
✔ Métricas personalizadas  
✔ Endpoint protegido con JWT  
✔ Health check habilitado

---

## Endpoints Disponibles

### Obtener cuenta por accountNumber
```http
GET http://localhost:8082/accounts/{accountNumber}
```

### Obtener lista de cuentas por customerId
```http
GET http://localhost:8082/accounts/customer/{customerId}
```

### Health Check
```http
GET http://localhost:8082/q/health
```

### Obtener metricas
```http
GET http://localhost:8082/q/metrics
```

