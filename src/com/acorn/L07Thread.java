package com.acorn;

import java.util.Scanner;

public class L07Thread {
    public static void main(String[] args) throws InterruptedException {
        // 스레드 : 일의 단위
        // java.lang.Thread : 스레드를 생성할 수 있는 객체
        // main() : 실행하는 일의 집합으로 기본 1개의 스레드를 갖는다.
        // 순차적언어 : main 에 작성한 코드가 한개의 스레드에 의해서 순서대로 실행된다.

        int index=10;   // 1초에 한 번씩 0까지 1씩 줄이면서 콘솔에 출력하는 카운터 어플
        boolean start=true;

        System.out.println("0 을 누르면 카운터가 종료됩니다.");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine(); // 콘솔창에서 입력하는 문자열과 jvm 이 통신에서 받아오는 결과는 무조건 문자열이다.
        System.out.println("누른 번호는 :"+num);

        if(num.equals("0"))start=false;
        // 입력이 오는 것을 계속 대기하는 무한반복문이기 때문에 다음 코드는 입력할 때까지 실행되지 않는다.

        while (index>=0) {
            System.out.println(index--);
            Thread.sleep(1000); //밀리세컨즈 1/1000초
        }
        System.out.println("타이머 종료");

    }
}
