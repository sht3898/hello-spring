**23 수강중**

# 실행

`src>main>java>hello.hellospring>HelloSpringApplication`파일 Run 하면 서버 실행됨

`localhost:8080` 접속하여 확인

`Ctrl + Shift + Enter` 하면 `;`이 저절로 붙어서 한줄 띄어짐

`Alt + Insert` => `Getter/Setter` 자동완성 가능

`Alt + Enter` => add on demand로 편하게 사용, static 설정 가능, replace with lambda

`Ctrl + Alt + V` => 변수 자동 추출

`Ctrl + Alt + L` => 줄 자동 정렬

`Ctrl + Alt + Shift + T` => 리팩토링 관련

`Ctrl + E` => 최근 본 파일

`Ctrl + Shift + T` => 자동으로 Test 파일 생성

# 스프링 웹 개발 기초

## MVC와 템플릿 엔진

```html
<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello ' + ${name}">hello! empty</p>
</body>
</html>
```

* hello! empty는 추후에 `th:text="'hello ' + ${name}"`에 들어가는 단어들로 바뀜



## API

```java
@GetMapping("hello-string")
@ResponseBody
public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }
```

* `ResponseBody` 때문에 HTML Body 부분에 return 부분이 그대로 들어감



```java
static class Hello{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
```

* Getter, Setter 활용



### XML vs JSON

* XML

  ```<html>hello</html>``` 형태

* JSON은 간단한 형태(객체)로 반환할 수 있기 때문에 최근에는 JSON 방식으로 통일됨



# 회원 관리 예제-백엔드 개발

* `Optional` => null을 처리할 때 유용하게 쓰이는 데 추후에 설명
* 인터페이스 생성 후 클래스로 만들 때 `implements MemberRepository`하고 `Alt + Insert` 하면 자동으로 Override 됨



## 회원 리포지토리 테스트 케이스 작성

* 매번 서버를 실행시키면서 테스트하기 어려움 => JQuery 활용하여 쉽게 만듦
* 테스트는 순서를 보장할 수 없음 => 서로 의존성이 발생하면 안되기 때문에 테스트가 끝나고 나면 데이터를 없애주는 작업을 해야함

## 회원 서비스 테스트

* `Ctrl + Shift + T` 을 `MemberService` 클래스 명에서 누르면 자동으로 Test를 생성할 수 있음

* 같은 위치에 생성됨

* 테스트는 과감하게 한글로 바꿔도 됨

* given - when- then 문법 사용하기

  ```java
  @Test
  void 회원가입() {
      
      // given
      // when
      // then
  }
  ```

  

# 스프링 빈과 의존관계

## 컴포넌트 스캔

* `@Component`로 의존성을 주입할 수 있음 => 스프링 빈에 자동 등록됨
* `@Controller`, `@Service`, `@Repository`에는 `@Component`가 자동으로 등록되어 있음

* 스캔은 같은 패키지 하위에서만 실행
* 기본으로 싱글톤으로 드옭(유일하게 하나만 등록해서 공유)



## 자바 코드로 직접 스프링 빈 등록하기

* `Controller`는 `Bean`이 아니라 그대로 사용



# 회원 관리 예제

## 화면 웹 기능

* 컨트롤러가 정적 파일 보다 우선 순위가 높기 때문에 `static/index.html` 보다 컨트롤러의 `home.html`이 먼저 뜸





# 스프링 DB 접근 기술

* 선언한 값과 return 값이 같은 `inline variable`은 `Ctrl + Shift + Alt + T`에서 추천 받거나 `Ctrl + Alt + N`으로 관리가능

```java
@Override
public List<Member> findAll() {
    List<Member> result = em.createQuery("select m from Member m", Member.class)
        .getResultList();
    return result;
}
```

```java
@Override
public List<Member> findAll() {
    return em.createQuery("select m from Member m", Member.class)
        .getResultList();
}
```



* Interface가 Interface를 상속받을때는 implements가 아닌 extends 사용

* SpringDataJpa가 자동으로 Bean에 등록해줌

* Config에서 생성자가 하나일 경우에는 Autowired 생략 가능
* 