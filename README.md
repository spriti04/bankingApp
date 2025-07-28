# 🏦 Banking App

A full-featured Banking Application built using **Java**, **Spring Boot**, **Spring Security**, and **MySQL**. This app simulates real-world banking operations including user registration, deposit, withdrawal, and admin functionalities such as managing users and viewing account details.

---

## 📌 Project Description

The **Banking App** is a simple yet robust banking management system designed to simulate real-world banking operations. The application supports two roles — **Admin** and **User** — each with their own responsibilities. Admins can manage user data and view all bank accounts, while users can securely perform transactions like deposits and withdrawals.

---

## 🧰 Technologies Used

- **Backend:**
  - Java
  - Spring Boot
  - Spring Security
- **Database:**
  - MySQL
- **Others:**
  - Hibernate (for ORM)
  - Maven (for dependency management)
  - Lombok (for boilerplate code reduction)

---

## ✨ Features

### 👨‍💼 Admin
- ✅ Register and Login securely
- ✅ View all user bank accounts
- ✅ Access specific user bank details
- ✅ Assist users with deposit and withdrawal transactions

### 👤 User
- ✅ Register and Login securely
- ✅ Deposit money into their account
- ✅ Withdraw money from their account
- ✅ View current balance and account details

---

## 🔐 Authentication & Authorization

The app uses **Spring Security** for authentication and role-based authorization:
- Admin and User roles have different access levels.
- Passwords are encrypted before being stored in the database.

---

## 🗂️ Project Structure

