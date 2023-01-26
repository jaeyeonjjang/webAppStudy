package com.acorn;

import java.sql.SQLOutput;

public class L06Casting {
    public static void main(String[] args) {
        byte b = 127;
        System.out.println(Byte.MAX_VALUE); // byte 의 최댓값은 127이다.
//        b = 128; // 컴파일오류 (해당 타입은 byte 보다 큰 값을 참조할 수 없다.)
        b = (byte)128; // 기본형은 수를 값으로 저장하기 때문에 해당 타입보다 큰 수를 참조하는 것은 불가능하다.
        System.out.println(b); // 갑자기 - 튀어나옴;; 이런 형변환을 loss of data 라고 함. (값의 손실이 발생)
        // (byte < short < int < long 간의 형변환)

        System.out.println(Integer.MAX_VALUE);
//        long 1 = Integer.MAX_VALUE; //컴파일오류
        long l = 30392222222l; // 컴파일오류 왜? 수를 리터럴하게 선언하면 무조건 int 가 정의됨.
//       수 끝에 l을 붙여서 리터럴하게 선언해야 long 이 정의된다.

        // 왜 실수는 리터럴하게 선언하면 float 가 아니라 double 이 정이되는 것일까?
        //
        float f = 13.3f; // 실수 끝에 f를 붙이고 리터럴하게 선언하면 float 가 된다.
        double d = 13.3; // 실수를 리터럴하게 선언하면 double 이 된다.

        System.out.println(Double.MAX_VALUE); // 뒤에 e308은 0이 308개가 붙었다는 의미
        // 실수는 참조할 수 있는 수보다 큰 수를 무한대라 한다.

        // 정수가 -> 실수가 되는 방법 :  실수의 가수부가 정수로 정의하고 가수부로 표현할 수 있는 수보다 크면 지수부가 정의된다.
        // 정수가 -> 실수 : 해당정수를 지수표기법(부동소수점)으로 변경하고 가수가 표현할 수 있는 수만 가수부의 정의.
        // 2147483647 -> 2.147483647E9 지수부에 9 가수가 21474를 저장
        int i = Integer.MAX_VALUE;
        f = i; //실수가 정수보다 큰 수를 정의할 수 있기 때문에 형변환할 필요가 없ㄷ다.
        System.out.println(f);

        // 정수로 표현할 수 없는 큰 실수가 정수로 변환 : 정수타입이 정의할 수 있는 가장 큰 수로 정의
        d=12345678901234567890.0;
        System.out.println(d);
        i=(int)d;
        System.out.println("큰 실수를 정수로 변환 : " +i);
    }
}
