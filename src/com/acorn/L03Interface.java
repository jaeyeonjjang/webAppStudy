package com.acorn;

interface  InterTest1 {
    void a();
}
@FunctionalInterface // 추상메서드가 오직 한 개인 것만 정의 가능
interface InterTest2 {
    void a();
}
class InterTestImpl implements InterTest1, InterTest2 {
    @Override
    public void a() {

    }
}
public class L03Interface {
    public static void main(String[] args) {
        // 인터페이스 : 엄청 추상화된 설계도 (이렇게 이렇게 하세요~ 설명해주는 느낌 ㅋ)

        // 설계도를 추상화 하는 이유!!
        // - 설계도를 모두 구체화 되어 있으면 파악하기 어렵다.
        // - 추상화된 설계도를 재사용하기 용이하다. => 유지보수가 용이
        // - 다른 설계도와 중복되어도 문제가 되지 않는다.

        // InterTest1 interTest1=new InterTest1();
        // 설계도를 객체로 생성할 수 없다.
        InterTestImpl interTest = new InterTestImpl(); // 객체생성1
        // 인터페이스나 추상클래스를 객체로 생성하려면 인스턴스 생성과 동시에 구현하면 된다.
        // 클래스를 만들고 추상메서드를 구현하는 행위를 생략해도 jvm(자바버추어머신) 이 자동으로 익명클래스를 만든다
        InterTest1 interTest1 = new InterTest1() {
            @Override
            public void a() {

            }
        }; // 객체생성2
        // jvm 이 자동으로 하는 일
        // L03Interface 의 내부클래스로 1을 생성(익명클래스)
        // 익명클래스는 추상 메서드나 추상 클래스를 구현할 때 생긴다.
        // class 1 implement InterTest1 {public void a(){}} => new 1()

        // 이게 바로 람다식 (문법적 설탕 (Static sugar) : 문법만 존재하고 실존하지 않다.)
        // 람다식은 추상 메서드가 1개 있는 인터페이스에 @FunctionalInterface 명시하면 작성 가능
        InterTest2 interTest2 =() ->{}; //a 함수. 1번 2번과 같다

    }
}
