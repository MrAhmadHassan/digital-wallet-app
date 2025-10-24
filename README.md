```markdown
# 💳 Digital Wallet API

A **modular Spring Boot application** built from scratch — step by step — following a production-grade architecture.  
Currently, the project includes a **manual JWT authentication** mechanism (without Spring Security yet).  
Future phases will integrate **Spring Security**, **microservices**, and **Kubernetes deployment** for a full-scale enterprise setup.

---

## 🚀 Current Progress

### ✅ Phase 1 — Manual JWT Authentication (Completed)
We’ve successfully implemented a **JWT-based authentication system** manually, without relying on Spring Security, to deeply understand the authentication workflow.

### 🔒 Current Modules
- **User Registration & Login**
- **JWT Token Generation and Validation**
- **Secure Endpoints using Token Verification**

---

## ⚙️ Tech Stack

| Layer | Technology |
|-------|-------------|
| Language | Java 21 |
| Framework | Spring Boot 3+ |
| Build Tool | Maven |
| Database | MySQL |
| Authentication | JWT (Manual Implementation) |
| API Testing | Postman |
| IDE | IntelliJ IDEA / VS Code |

---

## 🧠 Authentication Flow

1. **User registers or logs in** using the authentication endpoints.
2. The server validates credentials and **generates a JWT token**.
3. The client sends this token in the `Authorization` header when accessing secure routes.
4. The backend **validates the token manually** using a custom filter/interceptor.

### Example:
```

Authorization: Bearer <your_jwt_token>

```

---

## 📡 API Endpoints

### 🔐 Authentication
| Method | Endpoint | Description |
|---------|-----------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Authenticate a user and receive a JWT token |

### 🧩 Secure Test Endpoint
| Method | Endpoint | Description |
|---------|-----------|-------------|
| `GET` | `/api/test/secure` | Access a protected route (requires a valid token) |

---

## 🧱 Project Structure

```

src/main/java/com/digitalwallet/
├── config/                # Configuration files (CORS, Beans, etc.)
├── controller/            # REST Controllers (AuthController, TestController)
├── model/                 # Entity and DTO classes
├── repository/            # Database Repositories (UserRepository)
├── security/              # JWT utilities and filters
├── service/               # Business logic (UserService, AuthService)
└── DigitalWalletApplication.java

````

---

## 🧾 Example Requests (Postman)

### Register a User
**POST** `http://localhost:8080/api/auth/register`  
**Body (JSON):**
```json
{
  "username": "ahmad",
  "email": "ahmad@example.com",
  "password": "password123"
}
````

---

### Login User

**POST** `http://localhost:8080/api/auth/login`
**Body (JSON):**

```json
{
  "username": "ahmad",
  "password": "password123"
}
```

**Response:**

```json
{
  "token": "<jwt_token_here>"
}
```

---

### Access Secure Endpoint

**GET** `http://localhost:8080/api/test/secure`
**Headers:**

```
Authorization: Bearer <jwt_token_here>
```

**Response (if valid token):**

```json
{
  "message": "Secure content accessed successfully!"
}
```

**Response (if invalid or missing token):**

```json
{
  "error": "403 Forbidden"
}
```

---

## 🧭 Next Steps (Upcoming)

### 🔜 Phase 2 — Integrate Spring Security

* Replace manual JWT checks with **Spring Security filters**.
* Implement **Role-Based Access Control (RBAC)**.
* Secure endpoints based on roles (e.g., ADMIN, USER).
* Harden security for **production deployment**.

### 🧩 Future Modules

* Wallet management (balance, transactions)
* Transaction history & audit trail
* Microservices communication
* Kubernetes deployment with ConfigMaps and Secrets
* CI/CD setup using Argo CD

---

## 🧰 Local Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/<your-username>/digital-wallet.git
cd digital-wallet
```

### 2️⃣ Configure Database

Edit your `application.yml` or `application.properties`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/digital_wallet
    username: root
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
```

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

### 4️⃣ Test Endpoints in Postman

Use the sample requests above to test authentication and secure routes.

---

## ✨ Notes

* This documentation will expand as we develop each module.
* Each phase focuses on **deep understanding before automation**.
* Production-grade configurations (like Spring Security, Docker, and Kubernetes) will follow in subsequent stages.

---

## 🧑‍💻 Author

**Ahmad Hassan**
Java Backend Engineer | Fintech | Microservices | Kubernetes
```

