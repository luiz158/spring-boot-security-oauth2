# spring-boot-security-oauth2
This code is based on the tutorial given by DEVGLAN -> https://www.devglan.com/spring-security/spring-boot-security-oauth2-example

This article aims to provide a working example of spring boot security oauth2. To ge started with this project just checkout the project
and set up the database configuration as per application.properties and run Application.java as a java application and you are done.
The complete explanation is provided on my blog - [spring security oauth2 example](http://www.devglan.com/spring-security/spring-boot-security-oauth2-example)
This project uses
1. Spring Boot 1.5.8.RELEASE
2. Java 8
3. Postgresql

### Query to create some users on DB
INSERT INTO Userdb (id, username, password, salary, age) VALUES (1, 'Alex123', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 3456, 33);
INSERT INTO Userdb (id, username, password, salary, age) VALUES (2, 'Tom234', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 7823, 23);
INSERT INTO Userdb (id, username, password, salary, age) VALUES (3, 'Adam', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 4234, 45);

## Objectives:
1 - Convert to Spring boot 2.0 latest version - DONE
2 - Avoid to use the same refresh token always
3 - Token store goes to database - DONE
4 - Add postman collection with all working
5 - Change token generation to JWT
6 - Revoke refresh tokens - DONE
7 - Enable client_id and client_secret DB configuration
8 - ??? TBD

### Token Store goes to database
Create tables
```
create table if not exists oauth_access_token (
  token_id VARCHAR(255),
  token BYTEA,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BYTEA,
  refresh_token VARCHAR(255)
);
create table if not exists oauth_refresh_token (
  token_id VARCHAR(255),
  token BYTEA,
  authentication BYTEA
);
```