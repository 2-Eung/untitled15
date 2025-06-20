
public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
                System.out.println("Runnable 실행중");

        for (int i = 1; i<=5; i++) {
            try {
                Thread.sleep(5000);
                System.out.println(i);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        }).start();
    }
}