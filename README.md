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

### Realizar debito de una cuenta
```http
POST http://localhost:8082/accounts/{accountNumber}/debit
Header
Content-Type: application/json
Request Body
100.50
```

### Realizar credito de una cuenta
```http
POST http://localhost:8082/accounts/{accountNumber}/credit
Header
Content-Type: application/json
Request Body
100.50
```

### Health Check
```http
GET http://localhost:8082/q/health
```

### Obtener metricas
```http
GET http://localhost:8082/q/metrics
```

### Informacion para la base de datos(El resto de informacion esta en el application.properties)
CREATE DATABASE account_db;
CREATE USER account_user WITH PASSWORD 'account_password';
ALTER DATABASE account_db OWNER TO account_user;
INSERT INTO ACCOUNT (id, accountnumber, balance, customer_id, status, type) values(1,'988779944',1000,1,'ACTIVE','SAVINGS');
INSERT INTO ACCOUNT (id, accountnumber, balance, customer_id, status, type) values(2,'222555555',3000,2,'ACTIVE','SAVINGS');
INSERT INTO ACCOUNT (id, accountnumber, balance, customer_id, status, type) values(3,'222222222',50,1,'ACTIVE','SAVINGS');