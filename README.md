# eatgo api 만들기

[![Build Status](https://travis-ci.org/shlee0882/eatgo-springboot.svg?branch=master)](https://travis-ci.org/shlee0882/eatgo-springboot)

### 용어 정리

- 의존성 주입(Dependency Injection)이란?

    - 의존성 주입은 의존관계를 의미한다.  
      의존관계는 둘이상이 협력하는 것이다.  
      예를 들어 A,B 객체가 있다.  
      A는 B에 의존한다는 것은 A는 B를 사용한다는 것을 의미한다.  
      B의 변화가 A의 영향을 끼치게 된다.  

    - Controller는 Repository에 의존한다.  
      Controller가 Repository 생성하는데 객체 생성하는 책임을 Controller가 갖게 된다.   
      우리가 자주쓰는 @Autowired, @Component가 대표적인 DI이다.  

- Spring IOC 컨테이너가 하는 역할?  
    - 스프링이 직접 관리하여 @Component 등록을 통해 new 생성자 없이 @Autowired로 호출할수 있다.

- JPA Hibernate
    - JPA에선 Hibernate라는 라이브러리가 있다. 모델에서 @Entity를 선언하여 사용한다.

- @Getter, @Setter
    - get set 메소드 자동생성해준다.

- @Builder
    - 생성자 메소드로 모델에 get set을 쉽게 도와준다.
    - MenuItem.builder().name("item1").address("seoul").build();

- @NoArgsConstructor
    - 모델의 기본생성자를 생성 해준다. 
    
- @AllArgsConstructor
    - 모델의 선언된 값이 인자로 들어오는 것을 허용하는 생성자를 생성해준다.

- @CrossOrigin?
    - 프론트에서 다른 환경의 api를 호출할때 cross origin 오류가 발생하는데 spring에서 
     @CrossOrigin 어노테이션을 사용해 간단하게 처리해줄수 있다.
     
- @Id, @GeneratedValue
    - ID 인 변수 위에 선언해주고 id값이 자동생성되게 만들어준다.
    
- @Transient
    - 필드를 만들고 싶지 않다면 사용한다. 

- @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    - 해당값의 json data가 null이 나올경우 출력되지 않는다. 
    
- @RestController
    - rest api를 구성하는 controller에 선언해준다.

- @PathVariable
    - 경로에 path변수를 넣어준다.

- @RequestBody
    - HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할을 한다.
    
- @ResponseBody
    - 자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할을 한다.
   
- @ResponseStatus(HttpStatus.NOT_FOUND)
    - 응답상태를 반환한다.

- @ExceptionHandler(RestaurantNotFoundException.class)
    - exception 발생시 error를 핸들해 준다.
    
- @GetMapping("/restaurants/{id}")
    - 해당경로의 id값을 받은 url GET 요청을 받는다.
     
- @PostMapping("/restaurants")
    - 해당경로 url POST 요청을 받는다.

- @PatchMapping("/restaurants/{id}")
    - 해당경로 url POST 요청을 받는다.

- @Mock
    - mock객체를 선언 생성한다.

- @Before
    - test어노테이션 전에 미리 실행해준다. 사전 setup으로 사용된다.
    
- @Test
    - test 실행 어노테이션이다.

- @RunWith(SpringRunner.class)
    - controller test에서 사용된다.
    
- @WebMvcTest(MenuItemController.class)
    - 사용할 컨트롤러 클래스를 명시해주고 사용한다. 
    
- @MockBean
    - 선언할 테스트 서비스명에 사용한다.

- @Configuration
    - 환경 설정에 사용한다.
    
- @EnableWebSecurity
    - 스프링시큐리티 적용 시 사용한다.

### 프로젝트 구조
- application layer 
    - service 관리

- domain layer 
    - model과 repository 관리

- interfaces layer 
    - controller 관리

- SecurityJavaConfig
    - 스프링 시큐리티 설정파일
    
- EmailExistedException
    - 이메일 기등록 파악 exception
    
- JSON Web Tokens
    - 적절한 토큰 생성 가능
    - Header
    - Payload(Claims) 정보를 담음
    - Signature 서명데이터 검증
    - Base64 URL Encoding
    
    
### api 사용법

* READ
 ```java

User 
http GET localhost:8080/users
http POST localhost:8080/uesrs email=tester@example.com name=Tester password="tester"
http DELETE localhost:8080/users/{id}
http PATCH localhost:8080/users/{id} name="" eamil="" level=1

Restaurant
http GET localhot:8080/restaurants
http GET localhot:8080/restaurants/{id}
http POST localhot:8080/restaurants name="" address="" categoryId=1
http PATCH localhot:8080/restaurants/{id} name="" address="" 

Region
http GET localhost:8080/regions
http POST localhost:8080/regions name=seoul

MenuItem
http GET localhost:8080//restaurants/{restaurantId}/menuitems
http PATCH localhost:8080/restaurants/{restaurantId}/menuitems < menuitems.json
http PATCH localhost:8080/restaurants/{restaurantId}/menuitems < menuitems2.json

Category
http GET localhost:8080/categories
http POST localhost:8080/categories name="korean food"

Review
http GET localhost:8080/reviews
http POST localhost:8080/restaurants/{restaurantId}/reviewsname="sanghyun" score="3" description="good"
http POST localhost:8080/restaurants/68/reviews score=3 description="좋아요" "Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb2huIn0.8hm6ZOJykSINHxL-rf0yV882fApL3hyQ9-WGlJUyo2A"

Session
http POST localhost:8080/session email="shlee0882@gmail.com" password="sanghyun"

Reservation
http GET localhost:8080/reservations "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjE2MiwibmFtZSI6IuqwgOqyjOyjvOyduCIsInJlc3RhdXJhbnRJZCI6MX0.91Z5lu9uIy29urhgEKxmKh7laeuEFEkMo88AOOSuRns"
http POST localhost:8080/restaurants/1/reservations date="2020-12-24" time="23:00" partySize=4 "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjE2MSwibmFtZSI6InRlc3RlciJ9.n9A2wAduxEsiNP3Op5q5KcTzuiVts-GZcIKwq-3btn8"

```

### h2 db 접속

```
http://localhost:8080/h2-console/
```

### JWT

```
https://jwt.io/
```

### TODO

- 현재 backend에서 menuitems.json파일을 사용하여 crud만 했는데  
  front에서 json형식의 데이터를 주고받을수 있게 CRUD 처리하기 
  
- 각 api마다 추가로 필요한 정보가 있다면 넣어주기

- junit으로 토큰값 생성 및 테스트
