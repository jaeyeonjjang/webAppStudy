package com.acorn;

import java.sql.*;

public class L17JDBCPreparedStatement {
    public static void main(String[] args) {
        //PreparedStatement : sql injection 해킹을 방어하기 위해 등장
        String mysqlDriver="com.mysql.cj.jdbc.Driver"; //DriverManager 가 동적 로딩시 사동절
        String url="jdbc:mysql://localhost:3306/scott";
        String user="root";
        String pw="mysql123";

        Connection conn=null; // 접속하면 반환되는 객체
        PreparedStatement pstmt=null; // 쿼리를 실행하는 객체
        ResultSet rs = null; // 질의어를 실행하면 반환되는 table
        // 검색창에서 20 수를 입력받아서 여기에 넣음
        // 해커가 검색창에"20 OR 1=1; DROP TABLE EMP;" 을 입력받아서 실행 => EMP 테이블이 삭제됨
        String sql_injection="SELECT * FROM EMP WHERE DEPTNO=20 OR 1=1; DROP TABLE EMP;"; // 공격을 당한거
        // 해당 해킹은 파라미터의 타입 검사만 하면 막을 수 있다.
        String sql_prevent="SELECT * FROM EMP WHERE DEPTNO=20 OR 1=1; DROP TABLE EMP;"; // 공격을 방어한거
        String sql="SELECT * FROM EMP WHERE DEPTNO=? OR JOB=?"; // <- 저기 물음표에 파라미터를 대입하는거임.
        try {
            Class.forName(mysqlDriver); // 동적로딩 할 준비
            conn= DriverManager.getConnection(url,user,pw);
            pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1,20);
            pstmt.setString(2,"clerk");
            rs = pstmt.executeQuery(); // 질의어를 실행하는 함수
            while (rs.next()){
                int empno=rs.getInt(1); // table 의 칼럼(필드)를 정의할 때 순서대로 반영
                String ename=rs.getString(2);
                String job=rs.getString(3);
                int mgr=rs.getInt(4);

                System.out.println(empno+"|"+ename+"|"+job+"|"+mgr);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
