package com.acorn;
import com.mysql.cj.jdbc.Driver;
// java.sql*JDBC lib : jdk 에 포함되어있다.

import java.sql.*;

public class L16JDBC {
    public static void main(String[] args) {
        // JDBC : Java DataBase Connect : 자바로 db 서버에 접속 하는 것 (java.sql* 객체를 제공)
        // JDBC 로 db 서버에 접속하려면 해당 db(mysql)에서 제공하는 커넥터 객체를 사용해야한다.
        String url="jdbc:mysql://localhost:3306/SCOTT";
        String user="root";
        String pw = "mysql123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection(url,user,pw); // Connect 에서 db 접쇽하는 개채
            // DriverManager : jdbc db 접속 객체로 접속 성공시 Connection(접속을 유지) 객체를 반환
            // 동적로딩 : DriverManager 가 mysql 에 접속할 때 mysql 에서 제공하는 Driver 를 객체로 생성해서 사용하는데 동적로딩이라는 방식이 사용됨
            // 터미널 mysql -uroot -pmysql123
            // user SCOTT

            Statement stmt =conn.createStatement(); // Statement : 쿼리를 실행하는 객체
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMP"); // executeQuery : 질의어(select,DQL)를 실행하는 함수
            // ResultSet ; table 의 자료 구조 (Iterator 로 출력확인 가능 next)

            while (rs.next()){
                int empno=rs.getInt("empno");
                String ename=rs.getString("ename");
                String job=rs.getString("job");
                int sal=rs.getInt("sal");

                System.out.println(empno+"\t|\t"+ename+"\t|\t"+job+"\t|\t"+sal);
            }

            System.out.println(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
