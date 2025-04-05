# 스마트 커뮤니티 플랫폼 API 명세서

## 1. 사용자 관련 API

### 1.1 회원가입
- **Endpoint:** `POST /users/register`
- **설명:** 새로운 사용자를 등록합니다.
- **Request Headers:**  
  `Content-Type: application/json`
- **Request Body:**
  ```json
  {
    "username": "exampleUser",
    "email": "example@mail.com",
    "password": "pass1234"
  }


{
  "id": 1,
  "username": "exampleUser",
  "email": "example@mail.com",
  "created_at": "2025-04-02T12:00:00Z"
}


{
  "error": "이미 존재하는 이메일입니다."
}
