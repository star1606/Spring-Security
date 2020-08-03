# 스프링 시큐리티 기본 V1

### MYSQL DB 및 사용자 생성
```sql

create user 'cos'@'%' identified by 'cos1234';
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
create database security;
use security;


```


```java
// protected void configure(HttpSecurity http) 함수 내부에 권한 설정법
.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')") //access 는 권한을 물어보는 것이다. or, and 사용가능
.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')") //hasRole 함수 안에는 정확히 필드에 맞게 써야 적용 됨.
.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") 
```


```java
// 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화 SecurityConfg.java에 설정
eGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) 
```

```java
// 컨트롤러에 어노테이션 거는 법
//@PostAuthorize("hasRole('ROLE_MANAGER')")
//@PreAuthorize("hasRole('ROLE_MANAGER')")
@Secured("ROLE_MANAGER")
```