# Bank Management System

A **Bank Management System** built with **Java** and **Hibernate ORM**.  
This project provides a robust solution for managing customers, accounts, loans, and transactions with well-defined entity relationships.

## ✨ Features
- **Entity Relationships**: Supports one-to-one, one-to-many, and many-to-many mappings for flexible data modeling.
- **Customer Management**: Add, update, remove, and list customers with their associated accounts and loans.
- **Account Management**: Create and manage bank accounts, link them to customers, and handle CRUD operations.
- **Loan Management**: Manage customer loans with proper relational mapping.
- **Transactions**: Secure fund transfers between accounts with transaction handling.
- **Database Integration**: Seamless integration with relational databases using Hibernate ORM.
- **Scalability**: Designed with modular repositories and entity classes for easy extension.

## 🛠️ Tech Stack
- **Java** (Core application logic)
- **Hibernate ORM** (Entity mapping and persistence)
- **JPA** (Standardized persistence API)
- **Relational Database** (e.g., MySQL/PostgreSQL)

## 📂 Project Structure
- `com.entity` → Entity classes (`Customer`, `Account`, `Loan`, etc.)
- `com.repository` → Repository classes for CRUD operations
- `com.database` → Hibernate connection and configuration

## 🚀 Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Bank-Management-System.git
