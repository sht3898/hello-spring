**07 수강중**

# 실행

`src>main>java>hello.hellospring>HelloSpringApplication`파일 Run 하면 서버 실행됨

`localhost:8080` 접속하여 확인

`Ctrl Shift Enter` 하면 `;`이 저절로 붙어서 한줄 띄어짐

`Alt Insert` => `Getter/Setter` 자동완성 가능



# 06 MVC와 템플릿 엔진

```html
<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello ' + ${name}">hello! empty</p>
</body>
</html>
```

* hello! empty는 추후에 `th:text="'hello ' + ${name}"`에 들어가는 단어들로 바뀜



# 07 API

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



## XML vs JSON

* XML

  ```<html>hello</html>``` 형태

* JSON은 간단한 형태(객체)로 반환할 수 있기 때문에 최근에는 JSON 방식으로 통일됨

