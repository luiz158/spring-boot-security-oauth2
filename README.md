# spring-boot-security-oauth2
This article aims to provide a working example of spring boot security oauth2. To ge started with this project just checkout the project
and set up the database configuration as per application.properties and run Application.java as a java application and you are done.
The complete explanation is provided on my blog - [spring security oauth2 example](http://www.devglan.com/spring-security/spring-boot-security-oauth2-example)
This project uses
1. Spring Boot 1.5.8.RELEASE
2. Java 8
3. MySql

Visit [spring security](http://www.devglan.com/tutorial/topics/spring-security) for other similar articles on spring security.


Make sure you have a mysql db as configured in application.properties

And insert the following rows,

INSERT INTO User (id, username, password, salary, age) VALUES (1, 'Alex123', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 3456, 33);
INSERT INTO User (id, username, password, salary, age) VALUES (2, 'Tom234', '$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK', 7823, 23);
INSERT INTO User (id, username, password, salary, age) VALUES (3, 'Adam', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 4234, 45);
