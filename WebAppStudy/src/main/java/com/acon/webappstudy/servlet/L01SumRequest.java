package com.acon.webappstudy.servlet;

import com.acon.webappstudy.HelloServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 자바 파일이 동적리소스가 되려면 HttpServlet 타입이어야한다.
// 톰캣이 동적리소스를 실행할때 HttpServlet  객체만 실행가능
// 해당 서블릿을 DD에 등록해야 동적리소스로 배포가능해진다.
public class L01SumRequest extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 해당 동적 페이지를 브라우저에서 url로 호출하면 doGet이 실행된다.
        // 실행의 결과는 매개변수의 response.out 필드 작성하면 문서로 반환 된다.
        // Reader 문자열을 입력하는 객체, Writer 문자열을 출력하는 객체
        // request : 요청에 대한 정보를 담는 객체 url, 파라미터, 요청하는 브라우저 정보,.....
        String paramA=request.getParameter("a");
        String paramB=request.getParameter("b");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter(); // 문자열을 출력하는 객체
        out.append("<h2>안녕!</h2>");
        out.append("a+b=" +(Double.parseDouble(paramA)+Double.parseDouble(paramB)));
        out.append("<p>파라미터 a와 b에 의해서 출력될 결과가 바뀌는 동적페이입니다.</p>");
    }
}
