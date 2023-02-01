<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1> Web App과 Web App Server</h1>
    <h2> 동적 리소스 네이베이션</h2>
    <ul>
        <li><a href="sum.do?a=10&b=33">sum(a+b) 동적리소스</a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
    </ul>
    <a href="hello-servlet">Hello Servlet</a>

    <h2>톰캣과 Web App Server와 Web App</h2>
    <ul>
        <li>Web App Server : 동적리소스를 반환하는 웹서버</li>
        <li>톰캣 : 자바를 동적 리소스로 하는 웹 서버</li>
        <li>Web App : 톰캣에서 실행하는 프로젝트, 톰캣에서 배포하는 동적리소스의 집합, 웹 앱 개발자의 산물, 동적 리소스 (네이버)</li>
    </ul>
    <h2>아파치와 Web Server</h2>
    <ul>
        <li>Web Serber : http 통신을 하는 서버로 정적리소스를 반환</li>
        <li>http : HyperText Transfer Protocol html 주고받는 통식 규약(웹의 통신규약)</li>
        <li>아파치 : 가장 많이 사용하는 http 서버 중 하나</li>
    </ul>
    <h2>아팟치 톰캣</h2>
    <p>정적 리소스는 아파치가 동적 리소스를 톰캣이 실행</p>

    <h2>메이븐 Maven 프로젝트</h2>
    <ul>
        <li>프로젝트를 빌드하는 도구이자 구조</li>
        <li>저장소(.m2 repository)에서 라이브러리의 종속성 관리(dependency)</li>
        <li>Junit 으로 단위 테스트를 할 수 있도록 제공 => 테스트 주도개발</li>
        <li>Gradle : 메이븐과 아주 유사한데 관리하는 파일 형식이 json 이고 성능이 좋다.</li>
    </ul>
    <h2>Servlet 과 동적 리소스</h2>
    <ul>
        <li>동적 리소스 : 리소스를 요청할 때 마다 내용이 바뀔 수 있는 것(웹앱서버가 동적 리소스를 실행하고 반환)</li>
        <li>정적 리소스 : 내용이 바뀌지 않는 리소스 (html,css,js(문서는 똑같은데 브라우저가 실행)),mp3,mp4,png,...</li>
        <li>Servlet : 톰캣에서 실행되는 동적리소스로 java 로 되어있다. </li>
    </ul>
    <h2>톰캣의 웹앱에서 동적리소스와 정적리소스의 경로!</h2>
    <ul>
        <li>동적 리소스경로 : src>main>java>*(전부) 인데 web.xml에 동적리소스라 명시한 것들</li>
        <li>정적 리소스경로 : src>main>webapp>* 인데 WEB-INF와 jsp 파일은 제외 (요청하면 바로 배포)</li>
        <li>WEB-INF : 배포되지 않는 경로로 설정파일이 존재</li>
        <li>web.xml : DD Development Descriptor 배포서술자로 배포할 동적리소스를 서술 및 웹앱 설정하는곳</li>
        <li>jsp : 동적리소스가 정적리소스인척하는 파일로 템플릿엔진이라 부른다.
            (코드는 자바로 작성하지만 컴파일러 따로 존재해서 스크립트처럼 문자열을 그대로 실행)</li>
        <li>@WebServlet : 컴파일시 자동으로 web.xml 에 해당 서블릿을 배포하도록 설정한다.</li>
    </ul>

</body>
</html>