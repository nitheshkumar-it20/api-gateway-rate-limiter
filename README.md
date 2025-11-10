# API Gateway Rate Limiter Platform

A microservice-based backend system built using **Spring Boot**, **Redis**, and **Spring Cloud Gateway** to handle request routing, authentication, and rate limiting between multiple services.  
This platform demonstrates how an API Gateway can manage traffic flow and protect microservices using Redis-backed rate limiting and JWT-based authentication.

---

## 🚀 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Cloud Gateway**
- **Redis** (for rate limiting)
- **MySQL** (for persistence)
- **JPA / Hibernate**
- **JWT Authentication**
- **Prometheus** (for monitoring)
- **Maven**
- **Postman / SoapUI** (for API testing)

---

## 🧠 Overview

The system is designed with a modular microservice architecture:

| Module | Description |
|:--|:--|
| **api-gateway** | Handles request routing and rate limiting using Redis. Secures endpoints with JWT. |
| **auth-service** | Provides login and JWT token generation. Validates user credentials. |
| **appointment-service** | Manages appointment scheduling between patients and doctors. |
| **doctor-service** | Handles doctor details, availability, and profile management. |
| **patient-service** | Manages patient data and records. |
| **common-library** | Shared models, DTOs, and utilities used across services. |

---

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/nitheshkumar-it20/api-gateway-rate-limiter.git
cd api-gateway-rate-limiter
```

### 2. Start Redis and MySQL
Make sure Redis and MySQL are running locally before starting the services.

- Redis default port → `6379`
- MySQL default port → `3306`

### 3. Configure `application.yml`
Each service has its own `application.yml` under:
```
src/main/resources/application.yml
```
Update DB credentials and Redis host if needed.

### 4. Build the Project
```bash
mvn clean install
```

### 5. Run the Services
Run each module one by one (in IntelliJ or via command line):
```bash
cd api-gateway
mvn spring-boot:run
```
Do the same for:
```
auth-service
appointment-service
doctor-service
patient-service
```

---

## 🔐 API Gateway Rate Limiting

- Implemented using **RedisRateLimiter** in `api-gateway`.
- Configurable via `application.yml`:
  ```yaml
  spring:
    cloud:
      gateway:
        routes:
          - id: appointment-service
            uri: http://localhost:8082
            predicates:
              - Path=/appointments/**
            filters:
              - name: RequestRateLimiter
                args:
                  redis-rate-limiter.replenishRate: 5
                  redis-rate-limiter.burstCapacity: 10
  ```
- Limits each client to a fixed number of requests per second.

---

## 🧪 Testing

Use **Postman** or **SoapUI** to test:
1. Login via `auth-service` → get JWT token.
2. Use the token in `Authorization: Bearer <token>` header for subsequent API requests.
3. Check rate limiting by sending multiple requests rapidly — the gateway should return `429 Too Many Requests`.

---

## 📊 Monitoring

Integrated **Prometheus** metrics endpoint at:
```
/actuator/prometheus
```
Use it for performance and traffic analysis.

---

## 👨‍💻 Author

**Nithesh Kumar**  
B.Tech Information Technology – Bannari Amman Institute of Technology  
[LinkedIn](https://linkedin.com/in/nithesh-kumar-491933208) | [GitHub](https://github.com/nitheshkumar-it20)

---

## 🏁 Summary

This project showcases:
- Microservice communication via API Gateway  
- Distributed rate limiting with Redis  
- Secure JWT-based authentication  
- Clean layered architecture and modular structure  
- End-to-end setup with Spring Boot and Maven
