# email-otp-verification
📧 Spring Boot Email Verification with OTP
A robust Spring Boot application that handles user registration with email verification using OTP (One Time Password). This project ensures only valid users can activate their accounts by verifying their identity through an email-based OTP system.

🚀 Features

✅ User Registration with Email & Password

✅ Random OTP Generation (Numeric)

✅ Email OTP Delivery via SMTP

✅ OTP Verification Endpoint

✅ Secure & Minimal REST API

✅ Clean, Scalable Spring Boot Codebase

🧠 Enhanced Capabilities (Planned / Available)
✅ Indicates already implemented
🔜 Indicates planned for enhancement

Feature	Status
OTP Expiry Mechanism (e.g., 5 mins)	🔜 Coming Soon
Resend OTP with cooldown	🔜 Coming Soon
OTP Rate Limiting	🔜 Coming Soon
Password Encryption (BCrypt)	🔜 Coming Soon
Swagger API Docs (OpenAPI)	🔜 Coming Soon
HTML Email Templates	🔜 Coming Soon
Frontend Integration (React/Vercel)	🔜 Coming Soon
PostgreSQL support	🔜 Optional
H2 In-Memory DB for testing	✅ Ready-to-use
Clean MVC structure	✅ Implemented

🛠️ Tech Stack
Java 17+

Spring Boot

Spring Web

Spring Data JPA

H2 Database (dev)

Jakarta Persistence

Lombok (optional)

JavaMailSender (SMTP)

📬 How It Works

✅ User Registers

📤 OTP is generated & emailed


🔐 User verifies OTP via endpoint

🟢 Account marked as verified

📦 Setup Instructions
bash
Copy
Edit
# Clone the repo
git clone https://github.com/your-username/email-verification-springboot.git
cd email-verification-springboot

# Configure SMTP in application.properties
# (Gmail SMTP can be used for dev)

# Run the app
./mvnw spring-boot:run

📧 Contact
Made with ❤️ by Akshat Jain
