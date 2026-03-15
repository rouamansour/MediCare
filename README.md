# 🏥 MediCare — Medical Practice Management Platform

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![HTML5](https://img.shields.io/badge/HTML5-Frontend-E34F26?style=flat-square&logo=html5)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6-F7DF1E?style=flat-square&logo=javascript)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

> A full-stack web application for managing the day-to-day activity of a medical practice — including patient records, doctor appointments, and consultation tracking with smart availability management.

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

---

## 🩺 About the Project

**MediCare** is a platform designed to digitize and streamline the operations of a medical practice. It enables staff and doctors to efficiently manage patient records, schedule appointments, and track consultations — all while preventing scheduling conflicts through a robust availability management system.

---

## ✨ Features

- 👤 **Patient Management** — Create, update, and view detailed patient profiles
- 📅 **Appointment Scheduling** — Book appointments with doctors, linked to patient records
- 🩻 **Consultation Tracking** — Log and review consultations and medical history
- 🚫 **Double-Booking Prevention** — Smart availability checks to avoid scheduling conflicts
- 🔍 **Search & Filter** — Find patients and appointments quickly
- 📊 **Dashboard** — Overview of daily activity and upcoming appointments

---

## 🛠️ Tech Stack

### Backend
| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot 3.x | Application framework |
| Spring MVC | REST API layer |
| Spring Data JPA | Database access |
| Hibernate | ORM |
| MySQL / H2 | Database (production / dev) |
| Maven | Build tool |

### Frontend
| Technology | Purpose |
|---|---|
| HTML5 | Page structure |
| CSS3 | Styling |
| JavaScript (ES6) | Dynamic interactions |
| Fetch API / AJAX | Communication with backend |
| Bootstrap (optional) | Responsive layout |

---

## 📁 Project Structure

```
MediCare/
├── demo/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/medicare/
│   │   │   │   ├── controller/       # REST Controllers
│   │   │   │   ├── service/          # Business logic
│   │   │   │   ├── repository/       # JPA Repositories
│   │   │   │   ├── model/            # Entity classes
│   │   │   │   └── MediCareApplication.java
│   │   │   └── resources/
│   │   │       ├── static/
│   │   │       │   ├── css/          # Stylesheets
│   │   │       │   └── js/           # JavaScript files
│   │   │       ├── templates/        # HTML pages (Thymeleaf or static)
│   │   │       └── application.properties
│   │   └── test/
│   └── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL (or use embedded H2 for development)
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/rouamansour/MediCare.git
   cd MediCare/demo
   ```

2. **Configure the database**

   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/medicare_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

   > For quick dev setup, use H2 in-memory database:
   > ```properties
   > spring.datasource.url=jdbc:h2:mem:testdb
   > spring.datasource.driver-class-name=org.h2.Driver
   > spring.h2.console.enabled=true
   > ```

3. **Build and run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the application**

   Open your browser and go to:
   ```
   http://localhost:8080
   ```

---

## 📡 API Endpoints

### Patients
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/patients` | Get all patients |
| GET | `/api/patients/{id}` | Get patient by ID |
| POST | `/api/patients` | Create new patient |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |

### Appointments
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/appointments` | Get all appointments |
| GET | `/api/appointments/{id}` | Get appointment by ID |
| POST | `/api/appointments` | Schedule new appointment |
| PUT | `/api/appointments/{id}` | Update appointment |
| DELETE | `/api/appointments/{id}` | Cancel appointment |

### Consultations
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/consultations` | Get all consultations |
| GET | `/api/consultations/patient/{id}` | Get consultations by patient |
| POST | `/api/consultations` | Add new consultation record |


<p align="center">Made with ❤️ for better healthcare management</p>
