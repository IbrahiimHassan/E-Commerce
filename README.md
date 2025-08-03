This is a Spring Boot-based backend system for managing an e-commerce application. It provides REST APIs for handling customers, products, and orders, and integrates with a Microsoft SQL Server database.
## Tech Stack

- **Java 17**
- **Spring Boot 3.2.4**
- **Spring Web, Spring Data JPA**
- **Microsoft SQL Server**
- **Hibernate**
- **Lombok**
- **Swagger/OpenAPI**
---

## Project Structure
├── controller/ # REST controllers for API endpoints
├── dto/ # Data Transfer Objects (DTOs)
├── entity/ # JPA entity classes
├── repository/ # Spring Data JPA repositories
├── service/ # Business logic layer
└── DemoApplication.java
---
## ✅ Features

- CRUD operations for:
  - 👤 Customers
  - 📦 Products
  - 📄 Orders
- DTO abstraction for cleaner APIs
- Swagger UI for testing endpoints
- SQL Server integration via JDBC
---
## Configuration
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=ECommerce;encrypt=true;trustServerCertificate=true
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
