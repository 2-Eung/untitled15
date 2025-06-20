import java.util.Arrays;                    // 메서드 체이닝
import java.util.List;                      // a.method1();     a.method1()
import java.util.stream.Stream;             // a.method2(); ==>  .method1()
                                            // a.method3();      .method3()
public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);       // ArrayList 임
//        Stream<Integer> stream = numbers.stream();            // stream 의 기본 형태는 Stream

//        Integer[] abc = {1,2,3};                              // 이건 배열 임
//        Stream<Integer> s = Arrays.stream(abc);
        int result = numbers.stream()                           // 2, 4 (조건에 맞는것을 남긴다)
                            .filter((n) -> n % 2 == 0)   // 형태는 스트림으로 되어 있다.
                            .mapToInt(x-> x.intValue())  // 그래서 여기서 int로 바꿈
                            .sum();                             // mapToInt, sum 은 ppt 참고
        int result1 = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                result1 += number;
            }
        }
        System.out.println(result);
        System.out.println(result1);
    }
}