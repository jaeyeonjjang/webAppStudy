package com.acorn;


public class L05Object {
    public L05Object() {}
    public L05Object(int a, Object o) {
        this.a = a;
        this.o = o;
    }

    int a;  // this.a 로 접근할 수 있는 해당 객체의 필드다
    public void print(){ // this.print()  // 메서드 또한 필드가 될 수 있다.
        System.out.println(this.a);
    }
    // this는 필드접근자다
    static int b=10; // this.b(x) // L05Object(o) // 정적멤버는 클래스의 이름만 사용한다.
    Object o= new Object();
    // 변수 : 데이터(기본형+자료형) 할당(참조)하는 것 (반은 정답 반은 오답)
    // 상수 : 최초에 참조한 데이터가 바뀌지 않는 것.
    // 지역변수 : 전역이 아닌 스코프(메소드, 제어문, 반복문과 같은 블럭{})에 존재하는 변수 , 해당 블럭 내에서만 참조 가능한 변수
    // 전역변수 : 해당 타입이(class) 객체가 되었을때 .으로 참조할 수 있는 것. // 객체의 재원(필드, 속성)이 되는 것
    // 매개변수(파라미터) : 생성자나 메소드를 실행할때 제공하는 데이터

    // 옛날에는 객체를 생성하고 안 쓰면 일일히 삭제해야 했는데(pointer 사용) 최근 객체지향 언어에서는 heap 메모리 사용으로 할 일이 줄어들었다.
    // 메모리 영역
    // 힙 : 인스턴스 객체가 생성되는 곳 (java 가 유명하게 된 이유), 가비키럴레션(GC)이 사용하지 않는 객체를 자동으로 지운다.
    // 스택(call Stack): 작업(main 에 작성한 코드)에 필요한 메모리 공간으로 (메소드 단위) 스택메모리 구조를 갖고 main 에서 실행할 변수와 메소드 연산을 스케줄링해서 참조
    // 메소드 : jvm 이 실행되면서 사용되는 class 를 분석해서 메소드 영역에 저장하는데 이떼 static 으로 선언된 정적멤버를 같이 생성한다.
    // 메소드 영역에는 GC가 없다.

    // static 과 정적 멤버(클래스변수)
    // 최초의 메소드 영역에 생성되기 때문에 객체생성없이 참조 가능하고 자동삭제되지 않고 남는다.
    // 주의 : 너무 많이 쓰면 안됨. 쓰지도 않는 메모리들이 남아있어서 쓸 만큼만 쓰는게 좋다. // 초기화를 하지 않기 때ㅔ문에 기대했던 값이 없을 수도 있다. <무슨말?
    // 그래서 대부분이 상수로 선언되는편

    int i = 0; // 기본형 type 은 class 가 아니다
    // class, 자료형 타입, 타입, 객체의 타입
    // 필드(Field), 속성(Attribute), 멤버 //젅체영역(최상위 블럭)에 선언된 것들(static 제외)
    // 객체, 오브젝트(object), 데이터(잘 사용하지 않는다), 인스턴스  // new 연산자로 해당 클래스의 생성자를 호출했을 때 반환하는 것
    // this : 필드접근자 // (해당 클래스가 객체가 되었을 때)
    // class Object : 개발자가 타입을 명시하고 객체를 생성할 수 있도록하는 최초의 설계

    // 메소드 : 재사용할 실행의 집합으ㅗ 매개변수를 이용하여 특정 기능을 수행하고 그 값을 반환하는 것.
    // 재사용할 실행의 집합으로 매개변수에 의해 실행을 제어하고 결과를 반환할 수 있다.

    // 생성자 : 객체를 생성할때 호출되고 필드를 초기화한다. (new 연산자가 객체를 생성한다)   객체 생성시 호출되는 생성자는 매개변수 필드를 초기화(첫세팅) 할 수 있다.
    // 생성자에 반환하는 타입을 적지 않는 이유? 생성자가 이미 반환하는 타입의 이름을 하고있다.

    public static void main(String[] args) { // 이 main 은 L05Object 클래스의 필드가 아니다.
        // main 은 함수 정적멤버기 때문에 (L05Object 의 필드가 아니기 때문에) this 사용 불가능
//        this.a;
//        this.print(); // 불가능
        System.out.println(L05Object.b); // 정적 멤버는 사용가능. 클래스명 생략가능
    }
}
