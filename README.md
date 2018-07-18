# spring-boot-security-oauth2
This code is based on the tutorial given by DEVGLAN -> https://www.devglan.com/spring-security/spring-boot-security-oauth2-example

This article aims to provide a working example of spring boot security oauth2. To ge started with this project just checkout the project
and set up the database configuration as per application.properties and run Application.java as a java application and you are done.
The complete explanation is provided on my blog - [spring security oauth2 example](http://www.devglan.com/spring-security/spring-boot-security-oauth2-example)
This project uses
1. Spring Boot 1.5.8.RELEASE
2. Java 8
3. Postgresql

Objectives:
1 - Convert to Spring boot 2.0 latest version
2 - Avoid to use the same refresh token always
3 - Token store goes to database
4 - Add postman collection with all working
5 - Change token generation to JWT
6 - Revoke tokens
7 - ???