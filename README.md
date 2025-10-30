🚀 Spire Wallet — Backend
💡 Overview

The Spire Wallet backend is a secure and modular financial service built with Spring Boot (Java 21).
It provides APIs for user registration, authentication, and wallet balance management with clean architecture and JWT-based authentication.

🧱 Tech Stack
Layer	Technology
Backend Framework	Spring Boot
Language	Java 21
Database	MySQL
ORM	Spring Data JPA
Security	Spring Security + JWT
Build Tool	Maven
Testing Tool	Postman / cURL
⚙️ Module 1 — Core App Setup & Authentication
📖 Overview

This module sets up the Spring Boot project structure, integrates Spring Security, and configures JWT-based authentication for secure API access.

🔑 Features

✅ Spring Boot + JPA setup
✅ User entity and repository configuration
✅ JWT-based authentication
✅ Token filter for secure routes
✅ Global exception handling

📁 Endpoints
1️⃣ Health Check

GET /api/health

Verifies that the application is running.

Response:

{
  "status": "UP"
}

2️⃣ Login (JWT Token Generation)

POST /api/auth/login

Authenticates user and returns JWT token.

Request Body:

{
  "email": "john@example.com",
  "password": "123456"
}


Response:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

3️⃣ Token Validation

All protected routes (like /api/wallets, /api/users/me) require a valid JWT token in headers:

Authorization: Bearer <token>

👤 Module 2 — User Management
📖 Overview

The User Management Module handles user registration, authentication, and retrieval.
It also auto-creates a wallet for each new user.

🔑 Features

✅ Register users
✅ Authenticate and generate JWT
✅ Retrieve user details
✅ Auto-create wallet upon registration

📁 Endpoints
1️⃣ Register User

POST /api/users/register

Request Body:

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "123456"
}


Response:

{
  "message": "User registered successfully!",
  "walletId": 1
}

2️⃣ Login User

POST /api/users/login

Request Body:

{
  "email": "john@example.com",
  "password": "123456"
}


Response:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
}

3️⃣ Get Logged-in User Details

GET /api/users/me

Headers:

Authorization: Bearer <JWT_TOKEN>


Response:

{
  "id": 1,
  "username": "john_doe",
  "email": "john@example.com"
}

💰 Module 3 — Wallet Management
📖 Overview

The Wallet Management Module manages wallet balances linked to each user.
It provides functionality to add funds, deduct funds safely, and retrieve wallet details.

🔑 Features

✅ Auto-created wallet for new users
✅ Add or deduct balance (using BigDecimal)
✅ Prevent negative balances
✅ JWT-secured wallet operations

📁 Endpoints
1️⃣ Get Wallet Details

GET /api/wallets

Headers:

Authorization: Bearer <JWT_TOKEN>


Response:

{
  "walletId": 1,
  "userId": 1,
  "balance": 1000.00
}

2️⃣ Add Balance

POST /api/wallets/add

Headers:

Authorization: Bearer <JWT_TOKEN>


Request Body:

{
  "amount": 500.00
}


Response:

{
  "message": "Balance added successfully",
  "newBalance": 1500.00
}

3️⃣ Deduct Balance

POST /api/wallets/deduct

Headers:

Authorization: Bearer <JWT_TOKEN>


Request Body:

{
  "amount": 200.00
}


Response (Success):

{
  "message": "Balance deducted successfully",
  "newBalance": 1300.00
}


Response (Failure - Insufficient Funds):

{
  "error": "Insufficient balance. Transaction declined."
}

🧠 Technical Highlights

Atomic Transactions: Wallet balance updates are transactional.

Precision Safe: Uses BigDecimal for accurate monetary calculations.

Auto Wallet Creation: Triggered after successful user registration.

JWT Authorization: Ensures only wallet owners can access their data.

🧪 Testing the APIs

You can test using Postman or cURL.

Example Header:

Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI...

🧭 Folder Structure
spire-wallet/
 ┣ src/
 ┃ ┣ main/
 ┃ ┃ ┣ java/com/spire/wallet/
 ┃ ┃ ┃ ┣ controller/
 ┃ ┃ ┃ ┣ model/
 ┃ ┃ ┃ ┣ repository/
 ┃ ┃ ┃ ┣ service/
 ┃ ┃ ┃ ┗ security/
 ┃ ┃ ┗ resources/
 ┃ ┃     ┗ application.yml
 ┗ pom.xml