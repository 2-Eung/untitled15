class MyThread extends Thread {
    @Override
    public void run () {
        for (int i = 1; i <= 5; i++) {
            System.out.println("My Thread : " + i);
//            Thread.sleep(5000);            // 에러 처리를 안해서 이것만으로는 불가
            try {
                Thread.sleep(5000);     // 에러 처리해서 가능해짐
            } catch (InterruptedException e) {      // 에러는 언제 날까???
                System.out.println(e.getMessage()); // sleep 하고 있을때 누가 깨우면 안되서
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
//       thread.run();       // .run(); 으로 실행하면 일반 메소드로 실행이 됨 일반 메소드는
                            // 메인 Thread 안에서 하겠다는거니까 Thread 만든 의미가 없음
        thread.start();     // 다른 Thread (우리가 만든거) 로 하려면 .start(); 로 해야됨



    }
}