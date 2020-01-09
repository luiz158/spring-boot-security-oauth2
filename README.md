# spring-boot-security-oauth2


## 프로젝트 이력

https://github.com/only2dhir/spring-boot-security-oauth2
프로젝트를 fork함.

1. pom.xml 파일 변경
* Spring Boot 1.5.8.RELEASE --> 2.2.2.RELEASE 로 변경함
* org.springframework.security.oauth:spring-security-oauth2 버전을 2.4.0.RELEASE로 명시함
* commons-dbcp:commons-dbcp 의존성에서 제거
2. 로컬에서 mysql 서버를 띄우기 위한 docker-compose-mysql.yml 파일 추가
3. o.s.s.c.bcrypt.BCryptPasswordEncoder     : Encoded password does not look like BCrypt
에러로 인한 
AuthorizationServerConfig.java secret(passwordEncoder.encode(CLIENT_SECRET))으로 변경


## 사용법
1. MySQL 서버 실행
```
> docker-compse -f docker-compose-mysql.yml up -d
```
2. MySQL 서버 확인 및 접속
```
> docker ps
> docker exec -it spring-boot-security-oauth2_mysql_1 bash
```
3. MySQL Database 생성
```
/# mysql -u root -p
Enter password: example
mysql> CREATE DATABASE oauth2_sample;
```
4. Spring Boot 애플리케이션 실행
5. MySQL user 데이터 입력
```
mysql> USE oauth2_sample;
mysql> SHOW tables;
mysql> INSERT INTO user (id, username, password, salary, age) VALUES (1, 'Alex123', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 3456, 33);
mysql> INSERT INTO user (id, username, password, salary, age) VALUES (2, 'Tom234', '$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK', 7823, 23);
mysql> INSERT INTO user (id, username, password, salary, age) VALUES (3, 'Adam', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 4234, 45);
```
6. Postman을 통한 API 확인

