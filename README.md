# curly-octo-fiesta
A Spring Boot REST API for managing users with full CRUD operations, built using Java, Spring Data JPA, and MySQL.

#  User Management System - Spring Boot

This project is a backend application developed using **Spring Boot** that provides RESTful APIs to manage user data. It supports full CRUD (Create, Read, Update, Delete) operations and demonstrates real-world backend development practices.

---

##  Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* REST APIs

---

##  Features

* Create new users
* Fetch all users / user by ID
* Update user details
* Delete users
* JSON-based request and response handling
* Database integration using JPA & Hibernate
* Exception handling and API validation

---

##  Key Learnings

* Understanding of REST API design principles
* Handling JSON ↔ Object conversion using Jackson
* Difference between primitive (`int`) and wrapper (`Integer`) types
* Debugging common API errors like **400 Bad Request**
* Integration of Spring Boot with MySQL database

---

##  API Endpoints

| Method | Endpoint   | Description       |
| ------ | ---------- | ----------------- |
| POST   | /user      | Create a new user |
| GET    | /user      | Get all users     |
| GET    | /user/{id} | Get user by ID    |
| PUT    | /user/{id} | Update user       |
| DELETE | /user/{id} | Delete user       |

---

##  How to Run

1. Clone the repository
2. Configure MySQL database in `application.properties`
3. Run the Spring Boot application
4. Test APIs using Postman

---

##  Future Improvements

* Add authentication (JWT)
* Build frontend (React/Angular)
* Add validation & pagination

---

##  Author

Vikas Maurya

