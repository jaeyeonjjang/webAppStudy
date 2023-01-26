package com.acorn;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class NullCheck implements Predicate {
    @Override
    public boolean test(Object o) {
        return o != null;
    }
}
public class L12SteamIntemediate {

    public static void main(String[] args) {
//        Integer[]intArr= {1,2,3,4,5,6,7,8,9,10};
//        Stream<Integer> stream=Arrays.stream(intArr);
        //skip : 건너뛰는 연산
        //limit : 길이만큼 잘라내는 연산
        int[] intArr= {1,2,3,4,5,6,7,8,9,10};
        IntStream stream=Arrays.stream(intArr);
        //Collections 로 변환해서 사용하는 이유 : 무조건 자료형의 요소만 사용가능
        // 기본형 스트림 : IntStream, LongStream, DoubleStream 만 존재 (byte, short, float, boolean, char 없음)
        // skip(long), limit(long) : 스트림을 잘라내는 연산

        int [] intArrSkip = Arrays.stream(intArr)
                .skip(3) // 1부터 3까지 3개 삭제됨!!!!
                .toArray();
        System.out.println("skip(3) :" + Arrays.toString(intArrSkip));

        int [] intArrayLimit = Arrays.stream(intArr)
                .limit(5)
                .toArray();
        System.out.println("limit(5) :" + Arrays.toString(intArrayLimit));

        int [] result = Arrays.stream(intArr)
                .skip(3)
                .limit(4)
                .toArray();
        System.out.println(Arrays.toString(result));

        stream
                .skip(3)
                .forEach(System.out::println);

        System.out.println("limit(5)");
        Arrays.stream(intArr)
                .limit(5)
                .forEach(System.out::println);
        //skip(long),limit(long) : 스트림을 잘라내는 연산

        System.out.println("skip(3).limit(5)");
        Arrays.stream(intArr)
                .skip(3)
                .limit(5)
                .forEach(System.out::println);

        //distinct() : 중복제거 (자료형 표함)
        // filter(Predicate (e)->Boolean) : 반환값이 true 일 때만 Stream 에 담김
//        null 중복제거 첫 번째 방법!!!
        Integer[] intArr2= {1,2,2,null,3,3,4,null,5,6,null,7,7,8,9,10};
        // 배열 중에 null 필터링 불가능.. 왜 ?
        // -> 배열은 길이조절이 안 되기 때문. ArrayList 만들어서 담으면 가능.
        List<Integer> listArr2 = new ArrayList<>();
        for (Integer i : intArr2 ){ // 이렇게 하면 null 제거 가능 .ㅋ
            if (i != null) {
                listArr2.add(i);
            }
        }
        System.out.println("listArr2: "+ listArr2);

        // null 중복제거 두 번째 방법!
        // Array 의 스트림 변환 : 무조건 Arrays.stream() 으로만 변환 가능 (암기!!)
        Stream<Integer> intArratream2 = Arrays.stream(intArr2);
        List intList2 = intArratream2.
                filter((e)->{return e!=null;})
                        .collect(Collectors.toList()); // List 가 나옴 (암기!!!)
        System.out.println("filter((e)->e!=null) :" +intList2);

        // 세 번째 방법
        Stream<Integer> intArratream3 = Arrays.stream(intArr2);
        List intList3 = (List) intArratream3
                .filter(new NullCheck()) // 자바는 객체지향언어라서 함수를 매개변수로 사용 불가능
                        .collect(Collectors.toList());
        System.out.println("filter((e)->e!=null) :" +intList3);

        // 네 번째 방법
        Stream<Integer> intArratream4 = Arrays.stream(intArr2);
        List intList4 = intArratream4
                .filter(new Predicate<Integer>() { // 우리 눈에는 Predicate 가 만들어진 것 처럼 보이지만 사실은 클래스 생성된거임 (익명클래스)
                    // 추상클래스나 인터페이스는 객체가 될 수 없다 : 상식과 벗어나는 일 (단!!! 추성메서드를 생성과 동시에 구현하면 가능)
                    // 추상메서드를 구현하는 방법을 쓰면 -> 내부클래스를 익명클래스로 생성 후 인터페이스를 구현. -> 익명클래스가 객체로 생성됨.
                    @Override
                    public boolean test(Integer o) {
                        return o!=null;
                    }
                }).collect(Collectors.toList());
        System.out.println("filter((e)->e!=null) :" +intList4);

        // 다섯 번째 방법
        Stream<Integer> intArratream5 = Arrays.stream(intArr2);
        List intList5 = intArratream5
                .filter((o)->o!=null)
                        .collect(Collectors.toList());
        System.out.println("filter((e)->e!=null) :" +intList5);


        Integer[] intArr3= {1,2,2,null,3,3,4,null,5,6,null,7,7,8,9,10};
        //null 과 중복들 제거하기 문제~~~
        List intList6 = Arrays.stream(intArr3)
                .distinct()
                .filter((o)->o!=null)
                .collect(Collectors.toList());
        System.out.println("null과 중복들 제거 쌤이한거 :" + intList6);


        // 중복들 다 제거하고 더하기 (reduce(BinaryOperator))
        Stream<Integer> intArratream7 = Arrays.stream(intArr3);
        Integer sum = intArratream7
                .filter((o)->o!=null)
                .distinct()
                .reduce(0, Integer::sum);
        System.out.println("중복들 다 제거하고 더하기: " + + sum);
        // 쌤이한거
        // Optional : 결과가 null 일 수 있다고 알려주는 타입.
        Optional <Integer> sum2 = Arrays.stream(intArr3)
                .distinct()
                .filter((o)->o!=null)
                .reduce((i, i2) -> i+i2);
        System.out.println("중복들 다 제거하고 더하기: " + sum2.get());

        // map(Function) : 요소를 다른 데이터로 바꾸는 중간 연산
        // mpaTo(Int,Long,Double) : 요소를 값(기본형)으로 바꾸고 기본형 스트림으로 변환하는 중간 연산
        // IntStream, LongStream, DoubleStream : 자료형만을 요소로 사용할 수 있는 컬렉션의 한계를 극복하기 위해 만들어짐
        //boolean(0,1(boolean 은 1bit 의 기본형으로 1bit 수를 표현)), char(유니코드 표 번호)
        // 기본형(값, 수)을 정의하는 이유 : 연산을 위해
        // 기본형(값) 스트림에 연산에 유용한 최종함수를 제공 (sum(),average(),min(),max())
        // js 는 null=>0, 하지만 java 는 null=> 오류
        String [] strArr2= {"1","2","2",null,"3","3","4",null,"5","6",null,"7","7","8","9","10"};
        Optional <Integer> sum3 = Arrays.stream(strArr2)
                .filter((e)->e!=null)
                .map((e)->Integer.parseInt(e))
                .reduce((i1,i2)->i1+i2);
//                .collect(Collectors.toList());
        System.out.println("다음 배열을 정수로 바꾸고 전체의 합을 구하세요! :"+sum3.get());

        Optional <Integer> sum7 = Arrays.stream(strArr2)
                .filter((e)->e!=null)
                .map((e)->Integer.parseInt(e))
                .reduce((i1,i2)->i1+i2);
        System.out.println(sum7.get());
        // OptionalInt 쓰는 방법.
        // 기본형이 반환되는 값이 없을 때 사용 (Optional(Int, Long, Double)
        OptionalInt sum4 = Arrays.stream(strArr2)
                .filter((e)->e!=null)
//                .mapToInt(Integer.parseInt(e)); // 매개변수가 하나밖에 없으니 (e)-> 생략 가능
                .mapToInt(Integer::parseInt) // 매개변수를 함수가 실행하면서 사용할때 -> 컴파일러가 상상할 수 있을 만큼의 생략
                .reduce((i1,i2)->i1+i2);
        System.out.println("다음 배열을 정수로 바꾸고 전체의 합을 구하세요! :"+sum4.getAsInt());

        OptionalInt sum6 = Arrays.stream(strArr2)
                .filter((e)->e!=null)
                .mapToInt(Integer::parseInt)
                .reduce((i1,i2)->i1+i2);
        System.out.println(sum6.getAsInt());
        // 또 다른 방법
        int sum5 = Arrays.stream(strArr2)
                .filter((e)->e!=null)
//                .mapToInt(Integer.parseInt(e)); // 매개변수가 하나밖에 없으니 (e)-> 생략 가능
                .mapToInt(Integer::parseInt) // 매개변수를 함수가 실행하면서 사용할때 -> 컴파일러가 상상할 수 있을 만큼의 생략
                .sum();
        System.out.println("다음 배열을 정수로 바꾸고 전체의 합을 구하세요! :"+sum5);


        // 평균 구하는 방법
        OptionalDouble avg = Arrays.stream(strArr2)
                .filter((e)->e!=null)
//                .mapToInt(Integer.parseInt(e)); // 매개변수가 하나밖에 없으니 (e)-> 생략 가능
                .mapToInt(Integer::parseInt) // 매개변수를 함수가 실행하면서 사용할때 -> 컴파일러가 상상할 수 있을 만큼의 생략
                .average();
        System.out.println("다음 배열을 정수로 바꾸고 전체의 평균을 구하세요! :"+avg.getAsDouble());

        String [] strArr3= {"1","2","이",null,"3","삼","4",null,"5","6",null,"7","7","8","9","10"};


        Arrays.stream(intArr2)
                .filter((n)->n!=null&&n>5)
                .forEach(System.out::println);

        System.out.println("distinct()"); //null 도 중복제거 가능!!
        Arrays.stream(intArr2)
                .distinct()
                .filter((n)->n!=null&&n<=3)
                .forEach(System.out::println);


        //정렬하기!!!
        //sorted() : 정렬한 Stream 을 반환 (Comparator 가 정의되어야 사용가능 )
        String strArr[]= {"A","Car","ZZ","Cap","zz","ab","AA","Apple","aa"};
        List<String> strArrSorted=Arrays.stream(strArr)
                 .sorted() // 문자정렬은 아스키코드의 코드 표 번호대로 정렬한다.
                 .collect(Collectors.toList());
        System.out.println("sorted() :" + strArrSorted);

        strArrSorted = Arrays.stream(strArr)
                .sorted(String.CASE_INSENSITIVE_ORDER) // 대소문자 구분 없이
                .collect(Collectors.toList());
        System.out.println("sorted(String.CASE_INSENSITIVE_ORDER)" + strArrSorted);

        strArrSorted = Arrays.stream(strArr)
                .sorted()
                .sorted(Comparator.comparing((s)->s.length())) // 길이순
                .collect(Collectors.toList());
        System.out.println("sorted().sorted(s.length)" + strArrSorted);


        Arrays.stream(strArr)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);
        System.out.println("sorted().sorted(s.length)");

        Arrays.stream(strArr)
                .sorted()
                .sorted(Comparator.comparing((s)->((String)s).length()))
                .forEach(System.out::println);
        System.out.println("map((n)->2*n)");
        //map() :stream의 값을 변환하는 함수
        Arrays.stream(intArr2)
                .filter((n)->n!=null)
                //.peek(System.out::println)
                .distinct()
                .map((n)->(double)(2*n) ) //기존의 값을 다른 타입으로 변경 -> 변경된 스트림으로 반환됨
                .forEach(System.out::println);



    }
}