# 🏥 MediCare

A full-stack platform to manage the activity of a **medical practice** — handling patient records, doctor appointments, consultations tracking and smart availability management to prevent double bookings.

---

## 🛠️ Tech Stack

| Layer      | Technology            | Role                              |
|------------|-----------------------|-----------------------------------|
| Frontend   | Next.js + TypeScript  | UI, routing, SSR                  |
| Backend    | NestJS / Express.js   | REST API, business logic          |
| Database   | MongoDB / PostgreSQL  | Data persistence                  |
| Auth       | JWT                   | Secure role-based access          |

---

## ✨ Features

### 🧑‍⚕️ Patient Management
- Create, update and view patient records
- Store medical history and consultation notes
- Search and filter patients

### 📅 Appointment Scheduling
- Book appointments with available doctors
- Real-time availability check — no double bookings
- View, reschedule or cancel appointments

### 🩺 Consultation Tracking
- Log consultation details and outcomes
- Link consultations to patient records
- Track history of visits per patient

### 👨‍⚕️ Doctor Dashboard
- Manage personal schedule and availability
- View upcoming appointments
- Access patient consultation history

---

## 🗂️ Project Structure

```
MediCare/
├── frontend/                → Next.js app
│   ├── app/                 → App Router pages
│   ├── components/          → Reusable UI components
│   └── lib/                 → API calls, utilities
├── backend/                 → REST API
│   ├── src/
│   │   ├── auth/            → JWT authentication
│   │   ├── patients/        → Patient records module
│   │   ├── appointments/    → Scheduling & availability
│   │   ├── consultations/   → Consultation tracking
│   │   └── doctors/         → Doctor profiles & schedules
├── demo/                    → Demo assets & screenshots
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Node.js >= 18
- npm or yarn
- A running database instance

### 1 — Clone the repo

```bash
git clone https://github.com/rouamansour/MediCare.git
cd MediCare
```

### 2 — Setup the backend

```bash
cd backend
npm install
```

Create a `.env` file in `backend/`:

```env
PORT=5000
DATABASE_URL=your_database_url
JWT_SECRET=your_jwt_secret
```

```bash
npm run start:dev
```

API running at → `http://localhost:5000`

### 3 — Setup the frontend

```bash
cd ../frontend
npm install
```

Create a `.env.local` file in `frontend/`:

```env
NEXT_PUBLIC_API_URL=http://localhost:5000
```

```bash
npm run dev
```

App running at → `http://localhost:3000`

---

## 🔌 API Overview

| Method | Endpoint                     | Description                        |
|--------|------------------------------|------------------------------------|
| POST   | `/auth/register`             | Register a new user                |
| POST   | `/auth/login`                | Login & get JWT token              |
| GET    | `/patients`                  | List all patients                  |
| POST   | `/patients`                  | Create a patient record            |
| GET    | `/appointments`              | List all appointments              |
| POST   | `/appointments`              | Book a new appointment             |
| PATCH  | `/appointments/:id`          | Update or cancel appointment       |
| GET    | `/doctors/:id/availability`  | Get doctor availability slots      |
| POST   | `/consultations`             | Log a new consultation             |
| GET    | `/consultations/:patientId`  | Get consultation history           |

---

## 🖼️ Demo

Screenshots and demo assets are available in the [`/demo`](./demo) folder.

---

## 📚 Resources

- [Next.js Docs](https://nextjs.org/docs)
- [NestJS Docs](https://docs.nestjs.com)
- [JWT Docs](https://jwt.io/introduction)
