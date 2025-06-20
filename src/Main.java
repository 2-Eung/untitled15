import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Double> values = Arrays.asList(10.0, 20.0, 30.0);

        double avg = values.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);   // 안전장치 : 값이 없을 경우 0 으로 나눠버릴수 있어서
                                      // 0.0 은 기본값
        System.out.println(avg);

    }
}