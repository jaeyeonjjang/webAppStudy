package com.acorn;

class A {    // A.java 문서를 만드는 것과 같지만 배포할 수 없다. 배포는 public class 만 가능ㅎ다ㅏ.
    // 팔의 골격
    public void a(){
        System.out.println("A.a 입니다.");
    }
}
class B extends A {
    public void b(){}; // 손가락

    // 빨간줄이 의미하는 것 : 컴파일에러
    @Override // 어노테이션이 : 컴파일 시 동작 (검사(Override), 자동세팅, 명시)
    public void a() {
        super.a(); // 부모재원이 필요할 때
        System.out.println("B.a 로 재정의 합니다."); // 부모재원이 필요 없어서 재정의
    }
}
class C extends B{ // 로봇 팔
    public void c(){}
    public void c(int a) {} // 오버로드 : 함수의 이름은 같은데 매개변수가 달라서(타입과 수) 다르게 동작
}

// 상속을 하는 이유 : 물려받으려고. 재사용하기 편함.
// 객체지향 문법의 상속은 무엇인가요? : 상속 받은 부모클래스의 재원을 사용하거나 재정의(오버라이드) 하는 것. 부모가 좀 부족해서 재정의함

public class L01Inherit { //public class 는 java 문서의 주인이면서 배포가능한 클래스다.

    public L01Inherit() { // 생성자만들기 단축기 cmd + n
        A a = new A(); // 내부클래스를 정의하는 이유 (배포될 필요는 없고 내부적으로만 정의하는 클래스)
    }

    class A {} // 내부클래스 (inner class)로 L01Inherit&A,class 로 컴파일된다.
    // () 부모 클래스를 인스턴스로 생성해야 내부 클래스를 생성할 수 있다.

    public static void main(String[] args) {
        // public class : 임폴트 가능한 클래스. java 문서의 주인 (발행되는)
        // java 컴파일이란 : java 문서를 class 파일로 변환 => JAVAC(JDK(개발자도구)에 포함되어있음)가 해준다.
        // JVM : class 파일을 플랫폼에 맞게 해석해서 실행하는 가상 머신(자바는 플랫폼에 독립적이다)
        // L01Inherit.java 를 컴파일하면 생기는 클래스 .class 문서는 몇개일까 => 3개?

//      L01Inherit.A a = new A(); // 이렇게 못 함.
        L01Inherit.A inA = new L01Inherit().new A(); // 이렇게 해야 함. 근데 보통 이렇게 사용되지 않고 부모 내부에서 내부클래스를 생성해서 쓴다.


        C c = new C();
        B b = c;
        com.acorn.A a = c;
        Object o= c;
        c=(C)o; // int =(int)13.3; (둘은 동작 원리가 다르다.)
        // 타입의 다형성 : 객체가 부모의 타입이 될 수 있는 것

        // 객체지항 문법에서 상속은 무엇인가요? : 상속 받은 부모의 재원을 사용하거나 재정의(오버라이드) 하는 것.

        // 객체 재사용의 전략: 추상화, 모듈화

        // 객체지향 문법에서 다형성(1개의 이름이 여러가지 일을 하는 것)은 무엇인가요??
        // 프로그램 언어 각 요소들(상수, 변수, 식, 객체, 메소드 등)이 다양한 자료형(type)에 속하는 것이 허가되는 성질을 가리킴.
        // 프로그래밍을 간편하게 하는 장치 중 하나. 이름 1개에 다양한 역할을 부여해서 코드 작성을 편리하게 하는 문법이다.
        // 이중에 오버로드, 오버라이드, 타입의 다형성이 있다.
        // 오버로드는 함수의 이름은 같은데 매개변수를 다르게 지정해서 다르게 동작하는 것 처럼 보이게 한다. (이름짓기를 편리하게 한거)
        // 오버라이드는 부모의 메서드를 자식이 재정의 해서 자식 메서드가 호출되게 하는 것
        // 객체를 부모의 타입으로 참조할 수 있어서 변수의 타입을 복잡하게 정의할 필요가 없다.
        // 다형성을 하는 이유는 편하려고
        // 다형성의 문제점?? 객체지향에서 타입의 다형성을 너무 많이 쓰는 것을 권장하지 않는다 왜 ?? => 캐스팅 형변환 시 오류를 야기할 수 있다. 제네릭이 등장.
        // 객체지향에서는 타입이 명확한 것을 좋아한다.
        // 오버라이딩과 오버로딩은 문제점이 없음.


        Object iObj = "13";
        int i = (int)iObj;

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("안녕!");
//                try { Thread.sleep(millis:1000);
//            }catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//        }

    }
}
