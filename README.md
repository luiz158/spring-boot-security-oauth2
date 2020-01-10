# spring-boot-security-oauth2


## 프로젝트 이력

https://github.com/only2dhir/spring-boot-security-oauth2
프로젝트를 fork함.

[Spring Boot 2로 변경]
https://github.com/woozoo73/spring-boot-security-oauth2/commit/b0f7dff39c006ffad776c2c9bd03c9b8036f644f

1. pom.xml 파일 변경
* Spring Boot 1.5.8.RELEASE --> 2.2.2.RELEASE 로 변경함
* org.springframework.security.oauth:spring-security-oauth2 버전을 2.4.0.RELEASE로 명시함
* commons-dbcp:commons-dbcp 의존성에서 제거
2. application.properties 파일 설정 변경
3. 로컬에서 mysql 서버를 띄우기 위한 docker-compose-mysql.yml 파일 추가
4. o.s.s.c.bcrypt.BCryptPasswordEncoder     : Encoded password does not look like BCrypt
에러로 인한 
AuthorizationServerConfig.java secret(passwordEncoder.encode(CLIENT_SECRET))으로 변경

[사용자 정보 자동 입력]
1. 서버 기동시 사용자 정보를 추가하도록 수정함
https://github.com/woozoo73/spring-boot-security-oauth2/commit/18865d08c32983ab6e0d8dc7d3dc1f007a6eef56


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
3. Spring Boot 애플리케이션 실행
  아래와 같이 서버 기동시 사용자 정보가 추가됩니다.

```
package com.devglan.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devglan.dao.UserDao;
import com.devglan.model.User;

@Service
public class UserInit {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@PostConstruct
	public void printEndocedPassword() {
		User alex = user(1L, "Alex123", "password", 3456, 33);
		User tom = user(2L, "Tom234", "password", 7823, 23);
		User adam = user(3L, "Adam", "password", 4234, 45);
		User hazin = user(4L, "hazin", "woo", 52, 9);

		userDao.save(alex);
		userDao.save(tom);
		userDao.save(adam);
		userDao.save(hazin);
	}

	private User user(long id, String username, String password, long salary, int age) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setSalary(salary);
		user.setAge(age);

		return user;
	}

}
```

4. Postman을 통한 API 확인

* token 요청(Authorization 설정)
![postman-01.png](https://github.com/woozoo73/spring-boot-security-oauth2/blob/master/postman-01.png "postman-01")

* token 요청(Body 설정)
![postman-02.png](https://github.com/woozoo73/spring-boot-security-oauth2/blob/master/postman-02.png "postman-02")

* token 요청(결과)
![postman-03.png](https://github.com/woozoo73/spring-boot-security-oauth2/blob/master/postman-03.png "postman-03")

* token을 통한 자원 접근
![postman-04.png](https://github.com/woozoo73/spring-boot-security-oauth2/blob/master/postman-04.png "postman-04")
