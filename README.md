# eatgo api 만들기


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

- @RequestBody

- @ResponseBody

- @ResponseStatus(HttpStatus.NOT_FOUND)

- @ExceptionHandler(RestaurantNotFoundException.class)
     
- @GetMapping("/restaurants/{id}")

- @PostMapping("/restaurants")

- @PatchMapping("/restaurants/{id}")

- @Mock

- @Before

- @Test

- @RunWith(SpringRunner.class)

- @WebMvcTest(MenuItemController.class)

- @MockBean

### 프로젝트 구조
- application layer 
    - service 관리

- domain layer 
    - model과 repository 관리

- interfaces layer 
    - controller 관리

### api 사용법

* READ
 ```java
http GET localhot:8080/restaurants
http GET localhot:8080/restaurants/1
http POST localhot:8080/restaurants name="Bob Zip" address=Seoul
```

* CREATE
```java
http PATCH localhost:8080/restaurants/1/menuitems < menuitems.json
```

* UPDATE / DELETE
```java
http PATCH localhost:8080/restaurants/1/menuitems < menuitems2.json
```

### TODO

- 현재 backend에서 menuitems.json파일을 사용하여 crud만 했는데  
  front에서 json형식의 데이터를 주고받을수 있게 CRUD 처리하기 