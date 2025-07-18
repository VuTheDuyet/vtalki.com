 VTALKI - Vietnamese Language Learning Platform

> Hệ thống học ngôn ngữ toàn diện, gồm frontend ReactJS (Vite), backend Spring Boot và cơ sở dữ liệu MySQL. Dockerized để dễ chạy và triển khai.

---

## 🌐 Trang chính thức (dự kiến)

[https://vtalki.com](https://vtalki.com)

---

## 📦 Tech Stack

| Layer        | Technology                  |
|--------------|-----------------------------|
| Frontend     | ReactJS, Vite, i18next      |
| Backend      | Java 17, Spring Boot 3      |
| Database     | MySQL 8                     |
| Deployment   | Docker, Docker Compose      |
| Auth (planned) | JWT, Spring Security     |

---

## 📂 Cấu trúc thư mục

vtalki/
├── frontend/ # React + Vite (giao diện người dùng)
├── backend/ # Spring Boot (RESTful API)
├── db/ # SQL init scripts
├── docker-compose.yml # Chạy toàn bộ hệ thống
└── README.md

yaml
Copy
Edit

---

## 🚀 Hướng dẫn chạy local (Docker)

### 1. Clone project

```bash
git clone https://github.com/VuTheDuyet/vtalki.git
cd vtalki
2. Khởi động hệ thống
bash
Copy
Edit
docker-compose up --build
Frontend: http://localhost:5173

Backend: http://localhost:8080

MySQL: chạy ở port 3306 (user: root, pass: root)

🖥️ Frontend (React + Vite)
Tính năng:
Hỗ trợ đa ngôn ngữ (i18next)

Axios gọi API backend

Quản lý modal, toast, đa giao diện

Tối ưu performance với lazy load

Tự chạy tay (nếu không dùng Docker):
bash
Copy
Edit
cd frontend
npm install
npm run dev
⚙️ Backend (Spring Boot)
Tính năng:
RESTful API chuẩn hóa

Spring Data JPA + Auditing

Upload ảnh tạm

JWT (kế hoạch)

Global Exception Handler

Tự chạy tay:
bash
Copy
Edit
cd backend
./mvnw spring-boot:run
Cần đảm bảo MySQL đang chạy và application.yml khớp cấu hình DB.

