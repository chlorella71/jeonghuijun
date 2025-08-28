# Jeonghuijun Spring Boot Project

Spring Boot 3.5.5 기반의 멤버 관리 시스템입니다.

## 🚀 기술 스택

- **Java**: 21
- **Spring Boot**: 3.5.5
- **Spring Data JPA**: 데이터 접근 계층
- **H2 Database**: 인메모리 데이터베이스
- **Lombok**: 보일러플레이트 코드 제거
- **Spring Validation**: 입력 데이터 검증

## 📋 요구사항

- Java 21 이상
- Gradle 8.0 이상

## 🛠️ 설치 및 실행

### 1. 프로젝트 클론
```bash
git clone <repository-url>
cd jeonghuijun
```

### 2. 프로젝트 빌드
```bash
./gradlew build
```

### 3. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 4. 접속 확인
- **애플리케이션**: http://localhost:8080
- **H2 Console**: http://localhost:8080/h2-console (설정 시)

## 📚 API 문서

### 멤버 관리 API

#### 멤버 생성
```http
POST /api/members
Content-Type: application/json

{
  "email": "user@example.com",
  "name": "홍길동"
}
```

#### 멤버 조회
```http
GET /api/members/{id}
```

#### 멤버 목록 조회
```http
GET /api/members
```

#### 멤버 비활성화
```http
POST /api/members/{id}/deactivate
```

#### 멤버 삭제
```http
DELETE /api/members/{id}
```

## 🗄️ 데이터베이스

### H2 인메모리 데이터베이스
- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (없음)

### 테이블 구조
```sql
CREATE TABLE members (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(320) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    status VARCHAR(16) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);
```

## 🏗️ 프로젝트 구조

```
src/main/java/com/jeonghuijun/jeonghuijun/
├── JeonghuijunApplication.java          # 메인 애플리케이션 클래스
└── member/
    ├── controller/
    │   ├── dto/
    │   │   ├── MemberCreateRequest.java # 멤버 생성 요청 DTO
    │   │   └── MemberResponse.java      # 멤버 응답 DTO
    │   └── MemberController.java        # 멤버 컨트롤러
    ├── entity/
    │   ├── Member.java                  # 멤버 엔티티
    │   └── MemberStatus.java            # 멤버 상태 enum
    ├── repository/
    │   └── MemberRepository.java        # 멤버 리포지토리
    └── service/
        └── MemberService.java           # 멤버 서비스
```

## 🔧 개발 환경 설정

### IntelliJ IDEA
1. 프로젝트를 IntelliJ IDEA에서 열기
2. Gradle 프로젝트로 인식되도록 설정
3. Java 21 SDK 설정
4. Lombok 플러그인 설치 및 활성화

### VS Code
1. Java Extension Pack 설치
2. Spring Boot Extension Pack 설치
3. Gradle for Java 설치

## 🧪 테스트

### 단위 테스트 실행
```bash
./gradlew test
```

### 통합 테스트 실행
```bash
./gradlew integrationTest
```

## 📝 API 응답 예시

### 멤버 생성 성공 응답
```json
{
  "id": 1,
  "email": "user@example.com",
  "name": "홍길동",
  "status": "ACTIVE",
  "createdAt": "2024-01-01T00:00:00Z",
  "updatedAt": "2024-01-01T00:00:00Z"
}
```

### 에러 응답
```json
{
  "timestamp": "2024-01-01T00:00:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "이미 가입된 이메일입니다."
}
```

## 🚨 주의사항

1. **H2 데이터베이스**: 현재 인메모리 모드로 설정되어 있어 애플리케이션 재시작 시 데이터가 초기화됩니다.
2. **이메일 중복**: 동일한 이메일로 중복 가입이 불가능합니다.
3. **멤버 삭제**: 실제로 데이터를 삭제하지 않고 상태만 `DELETED`로 변경합니다.

## 📖 문서

- **API 문서**: `docs/API.md`
- **개발 가이드**: `docs/DEVELOPMENT.md`
- **Swagger 설정 가이드**: `docs/SWAGGER_SETUP.md`

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 `LICENSE` 파일을 참조하세요.

## 📞 연락처

- **이름**: Jeonghuijun
- **이메일**: jeonghuijun@example.com
- **GitHub**: [@jeonghuijun](https://github.com/jeonghuijun)

## 🙏 감사의 말

- Spring Boot 팀
- H2 Database 팀
- 모든 오픈소스 기여자들
