# 🪙 WalletX – Smart Wallet Management System

## 📘 Project Description

**WalletX** is a secure and modular **Spring Boot application** designed to handle user registration, authentication, and wallet transactions seamlessly.
It uses **JWT (JSON Web Token)** for authentication and authorization, ensuring secure access to APIs.
Each registered user automatically gets a wallet, enabling **balance management (credit/debit)** with **transaction safety and validation**.

This project demonstrates **production-ready authentication**, **modular structure**, and **clean separation of concerns** following Spring Boot best practices — suitable for fintech or backend microservice-ready systems.

---

## 🔐 Authentication Module

The authentication module ensures that only legitimate users can access the system.

### **Key Features**

* **JWT-based Authentication**:
  Upon successful login, a **JWT token** is generated and returned to the user.
* **Stateless Security**:
  Every request is verified through the JWT — no session is stored on the server.
* **Token Validation**:
  All secured endpoints are protected through a JWT filter that validates tokens before granting access.
* **Unauthorized Handling**:
  Custom `AuthenticationEntryPoint` returns an HTTP 401 response with `"Unauthorized or invalid token"`.

### **Authentication Flow**

1. User registers through `/api/auth/register`
2. User logs in via `/api/auth/login` → receives JWT token
3. Client includes JWT in the `Authorization` header for all secured endpoints
   Example:

   ```
   Authorization: Bearer <jwt_token>
   ```
4. Server validates token and provides access to wallet and transaction endpoints

---

## 👤 User Module

Handles **user registration and authentication** logic.

### **Key Responsibilities**

* Register new users with credentials (username, password)
* Passwords are securely stored using **BCrypt hashing**
* Auto-create wallet for each registered user
* Generate JWT tokens during login

### **Endpoints**

| Method | Endpoint             | Description                         | Auth Required |
| ------ | -------------------- | ----------------------------------- | ------------- |
| `POST` | `/api/auth/register` | Register new user                   | ❌             |
| `POST` | `/api/auth/login`    | Authenticate user and get JWT token | ❌             |

---

## 💼 Wallet Module

Each user has a **dedicated wallet** that stores their balance.
A wallet is automatically created when the user registers.

### **Key Features**

* Auto-create wallet on user registration
* Retrieve wallet details for logged-in user
* Prevent transactions that result in **negative balance**

### **Endpoints**

| Method | Endpoint             | Description                       | Auth Required |
| ------ | -------------------- | --------------------------------- | ------------- |
| `GET`  | `/api/wallet`        | Get current wallet details        | ✅             |
| `POST` | `/api/wallet/credit` | Add amount to wallet balance      | ✅             |
| `POST` | `/api/wallet/debit`  | Deduct amount from wallet balance | ✅             |

### **Validation Rules**

* Credit amount must be **positive**
* Debit not allowed if `balance < amount`
* Balance is stored as `BigDecimal` for precision

---

## 💳 Transaction Module

Handles all **wallet transactions** — credit and debit operations.

### **Key Features**

* Perform balance credit and debit securely
* Prevent overdraft (negative balance)
* Log every transaction for audit trail
* Ensure ACID safety using **Spring Data JPA**

### **Flow**

1. User sends a request (credit/debit)
2. System fetches wallet and verifies the balance
3. Updates balance atomically
4. Returns updated balance in response

### **Sample Response**

```json
{
  "walletId": 1,
  "userId": 2,
  "balance": 1250.50,
  "message": "Balance updated successfully"
}
```

---

## 🧠 Summary

| Module             | Purpose                                 |
| ------------------ | --------------------------------------- |
| **Authentication** | Secure user login using JWT             |
| **User**           | Manage user registration & credentials  |
| **Wallet**         | Store and manage wallet balances        |
| **Transaction**    | Credit/Debit operations with validation |

---

