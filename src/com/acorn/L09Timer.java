package com.acorn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class SwingTimer extends JFrame {
    // 패널에 그리드 레이아웃 써서 삼등분함 start, stop, init
    // 레이아웃을 없애버려서 크기와 위치를 지정
    int count =100;
    boolean start = false;
    JButton startBtn = new JButton("시작");
    JButton stopBtn = new JButton("멈춤");
    JButton initBtn = new JButton("초기화");
    Panel btnP = new Panel();
    JLabel screen = new JLabel((this.count/10.0)+"");

    public SwingTimer(){
        // 객체지향 문법은 매개변수의 타입을 지정해야한다.
        // (함수형 언어는 함수가 타입이라 함수를 매개변수로 작성가능) (객체지향 문어는 클래스만 타입이다)
        // (e)->{} : 람다식은 타입 생성을 컴파일러가 자동으로 하는 static sugar 문법적 설탕 (함수형 언어인 척 하는 문법)
        screen.setHorizontalAlignment(JLabel.CENTER);
        this.add(screen);
        btnP.setLayout(new GridLayout());
        btnP.add(startBtn);
        startBtn.addActionListener(new StartBtnHandler()); // 버튼을 누를때 행동을 재정의
        btnP.add(stopBtn);
        stopBtn.addActionListener((e)->{
            start=false;
        });
        btnP.add(initBtn);
        initBtn.addActionListener((e)-> {
            start=false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            screen.setText((count=100)/10.0+"");
        });

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 자동 window 꺼짐 설정

        this.add(btnP,BorderLayout.SOUTH);
        this.setBounds(0,0,300,300);
        this.setVisible(true);
    }
    class StartBtnHandler implements ActionListener { // 카운터를 구현
        // new Thread(()->{}); //Runnable 을 재정의 없이 람다식을 바로 사용가능
        // addEventListener 가 ActionListener 타입이 될 수 있는 것은 객체지향의 상속받은 부모의 타입이 될 수 있는 타입의 다형성 때문이다.
        // addEventListener(ActionListener al) : ActionListener 를 구현하도록 강제해서 타입을 명확하게 한다. (오류를 줄인다)
        // 해당 버튼 종료될 때까지 컴포넌트의 스레드를 독점하고 있어서 GUI 가 바뀌지 않는다.

        @Override
        public void actionPerformed(ActionEvent e) {
    /*
            start = true;
            new Thread(()-> {
                while (count > 0 && start) {
                    System.out.println(count);
                    screen.setText(--count + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }).start();
            System.out.println("스레드 생성완료");
*/

            if (!start) {
                start = true;
            }else { // start 가 true 이면 카운트를 하는 중
                return;
            }
            Runnable runnable = () -> {
                // 버튼을 여러번 누르면 스레드가 여러개 생성되어서 스레드의 시간차가 발생하면서 추가적으로 더 카운트 된다.
                    while (count > 0 && start) {
                    // swing 의 이벤트 리스너는 1개의 스레드가 모든 컴포넌트의 이벤트를 감시합니다 (js 멀티스레드가 아니다)
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException();
                        }
                        count--;
                        screen.setText((count/10.0) + "");
                    }
                };
                new Thread(runnable).start();
            }



        }
    }

    /*
    class StopBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            start = false;
        }
    }
    class InitBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText((count=10)+"");
            start=false;
        }
    }

     */





public class L09Timer {
    public static void main(String[] args) {
        // JVM 과 클래스 로더와 메소드 영역
        // main 이 실행되면 main 을 포함하는 패키지 내부에 있는 모든 클래스를 로드해서 메소드 영역에 저장함!
        // import 하고 있는 클래스를 로드해서 메소드 영역에 저장!
        new SwingTimer();
    }
}
