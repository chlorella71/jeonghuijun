# jeonghuijun
### 2025.08.27(wed)
Spring boot 프로젝트 시작
- spring boot verson: 3.5.5
- java version: 21
- dependencies
  - spring-boot-stater-data-jpa
  - spring-boot-stater-web
  - spring-boot-devtools
  - lombok
  - database:h2

### 2025.08.28(thu)
- Member Enity 생성
create table members (
    id bigint primary key,
    email varchar(320) not null unique,
    name varchar(50) not null,
    status varchar(16) not null default 'ACTIVE',
    created_at timestamp with time zone not null default now(),
    updated_at timestamp with time zone not null default now()
);

-- 인덱스 (UniqueConstraint)
create unique index ux_members_email on members (email);

- 패키지 구조
  - entity
  - controller
    - dto
  - service
  - repository
 
- API
  - url: http://localhost:8080
  - path variable: /api/members
  - POST
    - {
        "email" : "huijun@example.com",
        "name" : "희준"
      }
  - GET
    - path variable: /api/members/{id}
    - {
        "id" : 1,
        "email" : "huijun@example.com",
        "name" : "희준",
        "createdAt" : "2025-08-28T12:34:56+09:00",
        "updatedAt" : "2025-08-28T12:34:56+09:00"
      }
  - DELETE
  
