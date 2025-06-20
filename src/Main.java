class MyRunnable implements Runnable {  // Runnable 을 implements 시 빨간줄이 뜨는데
    @Override                           // Runnable 내의 추상 메소드인 run(); 때문이다.
    public void run() {                 // 그래서 run(); 을 오버라이딩 해주면 없어진다.
        System.out.println("Runnable 실행중");

        for (int i = 1; i<=5; i++) {
            try {
                Thread.sleep(5000);
                System.out.println(i);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "CountThread"); // thread 에다가 우리가 만든 MyRunnable() 을 집어넣는다.
                                                                           // 인스턴스 선언시 이름지을수도 있다.
        thread.setName("고장없이 잘 돌아가는 최신 쓰레드");  // 세터, 이름을 정하는 세터
                                                        // thread 0 -> ~~~
        thread.start();
        System.out.println(thread.getName());           // 게터

    }
}