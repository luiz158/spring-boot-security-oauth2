# spring-boot-security-oauth2
This article aims to provide a working example of spring boot security oauth2. To ge started with this project just checkout the project
and set up the database configuration as per application.properties and run Application.java as a java application and you are done.
The complete explanation is provided on my blog - [spring security oauth2 example](http://www.devglan.com/spring-security/spring-boot-security-oauth2-example)

This project uses

1. Spring Boot 2.1
2. Java 8
3. MySql

Visit [spring security](http://www.devglan.com/tutorial/topics/spring-security) for other similar articles on spring security.


Make sure you have a mysql db as configured in application.properties

And insert the following rows,

INSERT INTO User (id, username, password, salary, age) VALUES (1, 'Alex123', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 3456, 33);
INSERT INTO User (id, username, password, salary, age) VALUES (2, 'Tom234', '$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK', 7823, 23);
INSERT INTO User (id, username, password, salary, age) VALUES (3, 'Adam', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 4234, 45);


Using DB to store Client Registeration details and Access Token
================================================================
in SecurityConfig,
    	
      return new JdbcTokenStore(dataSource);

In AuthServerConfig,
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.jdbc(dataSource);



Copy the following DDL (Data Definition Langauge) and DML (Data Manipulation Langauge) SQL commands in the  Database SQL editor and click the Run button.


drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

-- insert client details
INSERT INTO oauth_client_details 
   (client_id, client_secret, scope, authorized_grant_types, 
   authorities, access_token_validity, refresh_token_validity)
VALUES
   ('crmClient1', 'crmSuperSecret', 'read,write,trust', 'password,refresh_token', 
   'ROLE_CLIENT,ROLE_TRUSTED_CLIENT', 900, 2592000);

drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);
 
-- insert client details
INSERT INTO oauth_client_details 
   (client_id, client_secret, scope, authorized_grant_types, 
   authorities, access_token_validity, refresh_token_validity)
VALUES
   ('crmClient1', 'crmSuperSecret', 'read,write,trust', 'password,refresh_token', 
   'ROLE_CLIENT,ROLE_TRUSTED_CLIENT', 900, 2592000);
 


We specify the validity of the generated access token to 900 seconds, which is 15 minutes.

Creating Database Tables For Storing OAuth Tokens:
Spring Security uses several Tables for storing OAuth tokens, Refresh tokens, etc.,
Let’s run the following DDL SQL commands from the H2 Database SQL editor.


drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);

drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);

drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(256), authentication LONGVARBINARY
);

drop table if exists oauth_approvals;
create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);
drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);
 
drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);
 
drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);
 
drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(256), authentication LONGVARBINARY
);
 
drop table if exists oauth_approvals;
create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);
 
