**06 빌드하고 실행하기 까지 완료**

# 실행

`src>main>java>hello.hellospring>HelloSpringApplication`파일 Run 하면 서버 실행됨

`localhost:8080` 접속하여 확인



# 06 MVC와 템플릿 엔진

```html
<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello ' + ${name}">hello! empty</p>
</body>
</html>
```

* hello! empty는 추후에 `th:text="'hello ' + ${name}"`에 들어가는 단어들로 바뀜

