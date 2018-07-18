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
INSERT INTO Userdb (id, username, password, salary, age) VALUES (2, 'Tom234', '$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK', 7823, 23);
INSERT INTO Userdb (id, username, password, salary, age) VALUES (3, 'Adam', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 4234, 45);

## Objectives:
1 - Convert to Spring boot 2.0 latest version
2 - Avoid to use the same refresh token always
3 - Token store goes to database
4 - Add postman collection with all working
5 - Change token generation to JWT
6 - Revoke tokens
7 - ??? TBD