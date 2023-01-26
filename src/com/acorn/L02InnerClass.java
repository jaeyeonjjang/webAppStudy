package com.acorn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 작명 규칙
// 1. 숫자로 시작하면 안됨
// 2. 연산을 사용하지 않는다(-+=/%)(몇 개의 특수문자는 가능 근데 잘 안씀 #은 private 한 이름에 씀 $는 필드. 회사 규칙을 따르는 것이 좋다)
// 파스칼 : 대명사, class 명, 프로젝트 이름
// 카멜케이스 : 변수
// 스네이크(대문자) : 상수
// 스네이크(소문자) : 폴더명(대소문자 구분을 못하는 운영체제에서), 패키지명

class BtnActionHandler implements ActionListener {
    int index;
    @Override
    public void actionPerformed(ActionEvent e) { // 버튼을 누를때 마다 해당 메소드를 실행
        // ActionEvent e : 이벤트와 관련된 정보가 포함되어 있다.
        Object btnObj = e.getSource(); // 이벤트 대상을 반환. 이것이 바로 타입의 다형성
        JButton btn = (JButton)btnObj;
        btn.setText(++index+" 명"); // 누를 때 마다 index 가 늘어남.
        System.out.println("버튼이 눌렸어요!!"); // 콘솔창에 실행
    }
    // 인터페이스 : 모든 메서드가 추상이어야 한다.
    // 클래스 : 모든 메서드가 추상일 수 없다. (인터페이스를 implements 하면 모든 추상 메서드를 구현({})(바디를 작성) 해야한다.
}

public class L02InnerClass {
    static int index =0;
    /*
    class 1 implement ActionListener {
         @Override
            public void actionPerformed(ActionEvent e) {
                btn.setText(++index+""); // 연산을 하면 index 가 참조하는 수가 연산한 값을 ㅗ바뀐다. (상수의 규칙에서 벗어난다)
                // 자료형 btn의 내부 필드가 바뀌는 것을 상수가 허용한다.
                // 내부 클래스로 만들어졌기 때문에 main 함수의 지역변수 btn 을 참조할 수 없는 것이 정상이지만
                // 마치 부모클래스의 필드처럼 접근할 수 있도록 컴파일러가 구현해놓는다. 하지만 상수로 정의되어있다!!
            }
     */
    public static void main(String[] args) {
//      J는 버전업을 의미한다.
        JFrame f = new JFrame("awt window 안녕!");
        JButton btn = new JButton("안뇽!");

//        BtnActionHandler btnActionHandler = new BtnActionHandler();
//        btn.addActionListener(btnActionHandler);
//        int index =0;
        btn.addActionListener(new ActionListener() { // 위에거와 같다.
            int n=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setText(++L02InnerClass.index+"명 입니다.");
            }
        });
        f.add(btn); // JFrame 에 버튼 넣기
        f.setBounds(0,0,200,200);
        f.setVisible(true);
        // 하이레벨 VS 로우레벨
        // 하이레벨 - 인간과 가까운 언어
        // 로우레벨 - 기계에 가까운 언어
        // 플랫폼(os)이 하는 일 : 컴퓨터의 재원을 관리 및 동작


        // GUI ( 마우스를 이용한 Mac 이 GUI 최초다. 마이크로 소프트가 애플의 Mac 을 따라서 만들기 시작)
        // GUI (마우스 이벤트가 중요하다)

        // 플랫폼에 독립적이다!
        // - window 나 mac 에서 자바를 실행시켜서 동작한다 (x) <- 반은 맞고 반은 틀린 말
        // - 자바가(jvm)이 class 를 플랫폼 위에서 실행(class 를 플랫폼이 언어로 변환)하면서 플랫폼의 자원을 동작 (o) -이게 젤 중요!!

        // 자바가 유명하게 된 이유와 frame
        // - window 에서 GUI 앱을 개발하는 패키지를 제공했는데 어렵고 복잡해서 개발 난이도가 높았다.
        // - window 용 앱을 만들고 다시 mac 이나 리눅스용 앱을 만들려면 각 플랫폼에서 제공하는 GUI 패키지를 공부해야했다... 좋지않음
        // - Java 가 통합 GUI 패키지를 제공 (java,awt.*) 하면서 더 엄청 유명해졌다.
        // ==> 시간이 지날수록 java.awt 에서 제공하는 컴포넌트가 플랫폼마다 다르게 동작하기 시작
        // ==> java.swing 패키지로 업데이트
        // ==> javaFX : 컴포너트의 레이아웃이 제한적으로 배치되고 swing 패키지가 오래되어서 새롭게 등장한 gui 패키지 (html 처럼 컴포너트를 배치가능.)
    }
}
