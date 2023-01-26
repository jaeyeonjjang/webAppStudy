package com.acorn;

import java.io.Console;
import java.util.Scanner;
import java.util.Timer;

class ConsoleTimer implements Runnable {
    int index=10;
    boolean start = true;
    @Override
    public void run() {
        while (index>0 && start) {
            System.out.println(index--);
            try { Thread.sleep(1000);} catch (InterruptedException e) {}
        }
        System.out.println("타이머 종료!");
    } // 멀티 스레드로 생성되려면 Runnable 을 구현해야함.
}
public class L08MultiThread {
    public static void main(String[] args) {
        //일꾼1
        ConsoleTimer consoleTimer = new ConsoleTimer();
        new Thread(consoleTimer).start(); // 구현한 run 메소드를 스레드 생성 후 실행
        // 이거는 멀티쓰레드 영역이라서 이거랑 별개로 스캐너를 입력받을 수 있음.

        //일꾼2
        Scanner scanner = new Scanner(System.in);
        System.out.println("0을 입력하면 타이머가 종료");
        String num = scanner.nextLine();
        System.out.println("입력한 번호 :" + num);
        if (num.equals("0")) consoleTimer.start=false;
    }
}
