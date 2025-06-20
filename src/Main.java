class SumRunnable implements Runnable {
    private final int[] numbers; // 이것만 쓰면 빨간줄이 뜨는데 private 에 final 이라 값을 달라고 뜨는거
                                 // 이중배열이 아닌 배열쓰는이유 : 한줄씩 꺼내서 합 할거라 배열이어도 충분
    public  SumRunnable (int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        int sum = 0;

        for (int n : numbers) {
            sum += n;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Sum " + sum);
    }
}
public class Main {
    public static void main(String[] args) {
        int[][] dataSets = {
                {1, 2, 3, 4, 5},
                {10, 20, 30},
                {7, 14, 21, 28},
                {100, 200, 300, 400}
        };      // dataSets[i].length : 이중배열 안쪽의 갯수
        for (int i = 0; i < dataSets.length; i++) {           // 반복문으로 sumThread 를 여러개 만들어준다.
            Thread sumThread = new Thread(new SumRunnable(dataSets[i])); // SumRunnable 은 생성자를 필요로 한다.

            sumThread.start(); // 이때 배열 순서대로 출력되지 않는다. 쓰레드에서 연산이 끝난 순서대로 출력된다.
        }                       // 만약 이 순서를 조절하고 싶다면 오케스트라 (지휘자?) 역할을 하는것이 필요하다.
//        System.out.println(Thread.currentThread().getName()); // 현재 작동되는 Thread 이름 출력 현재 main
    }
}