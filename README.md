# 🏫 Smart Community API

학생 1:1 맞춤 관리용 백엔드 프로토타입
Spring Boot 기반 RESTful API와 간단 UI를 통해 학원/과외 운영자가 소규모 학습자를 효과적으로 관리할 수 있도록 설계되었습니다.

---

## 🚀 주요 기능

- **학생 인증·등록**: 회원 가입 및 로그인 (임시 비밀번호 인코딩))
- **학생 프로필 조회**: `GET /api/users/{id}`
- **숙제 관리**: CRUD (`/api/homeworks`)
- **시험 성적 관리**: CRUD (`/api/examscores`)
- **약점(Weakness) 관리**: CRUD (`/api/weaknesses`)
- **질문 시스템**: 질문 등록·조회·답변 (`/api/questions`)
- **간단 UI 프로토타입**: `static/index.html` + Fetch API 연동

---

## ⚙️ 기술 스택

| 구분       | 기술 및 버전             |
|-----------|-----------------------|
| 언어       | Java 17               |
| 프레임워크  | Spring Boot 3.4.4     |
| ORM·DB     | Spring Data JPA, H2   |
| 빌드 도구   | Maven                 |
| UI 테스트  | Static HTML + Fetch API |

---

## 📂 프로젝트 구조

```
src/
├─ main/
│  ├─ java/com/academy/smartcommunity/
│  │  ├─ controller/        # REST 컨트롤러
│  │  ├─ service/           # 비즈니스 로직
│  │  ├─ repository/        # JPA 레포지토리
│  │  ├─ model/             # 엔티티 정의
│  │  └─ dto/               # 외부 노출 DTO
│  └─ resources/
│     └─ static/index.html  # 간단 UI 프로토타입
└─ test/                    # 통합 테스트
```

---

## 🛠️ 설치 & 실행

```bash
# 1. 코드 클론
git clone https://github.com/Greenapple0101/smart-community-api.git
cd smart-community-api

# 2. 빌드 & 실행
./mvnw clean package
./mvnw spring-boot:run
```

브라우저에서 `http://localhost:8080/` 접속 시 UI, 혹은 Postman/cURL로 REST API 테스트 가능

---

## 📑 API 사용 예시

```bash
# 학생 등록
POST /api/auth/register?username=student1&password=pass123

# 숙제 생성
POST /api/homeworks
{ "title":"Math", "description":"Ch3","dueDate":"2025-05-01","student":{"id":1} }

# 시험 성적 등록
POST /api/examscores
{ "subject":"Science","score":90,"examDate":"2025-05-10","student":{"id":1} }

# 약점 생성
POST /api/weaknesses
{ "description":"Fractions","priority":2,"student":{"id":1} }

# 질문 등록
POST /api/questions
{ "title":"Q1","content":"내용","student":{"id":1} }
```

---

## 📈 향후 개선 계획

- JWT 기반 인증·인가 적용
- MySQL, 프로덕션 프로파일 연동
- Swagger/OpenAPI 문서화
- Docker 컨테이너화 & CI/CD 파이프라인 구축
- React/Vue 프론트엔드 통합

---

## 👤 개발자

**백서연 (Seoyeon Baek)**
- GitHub: [Greenapple0101](https://github.com/Greenapple0101)
- Email: yorange50@gmail.com

---

© 2025 Seoyeon Baek. MIT License.

