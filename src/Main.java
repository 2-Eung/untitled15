//class Counter {                  // 만약 이대로 한다면, count 를 읽을때 언제
//    private int count = 0;       // 어느 순간에 읽느냐에 따라 다른 값이 나오게 된다.
//                                 // 쓰레드는 서로 관련없이 제각각 진행중이므로

//    public void increment() {    // ++ 하는 도중에 저장해버리고 저장하고있는도중에 읽어버리고 하는등
//        count++;                 //의도와 다르게 카운트가 될 수 있다. // 경쟁 조건(Race Condition)
//    }
//    public int getCount() {     // 게터
//        return count;
//    }
//}
class Counter {
    private int count = 0;
                                                // increment() 메서드에 synchronized 키워드를 붙이면,
    public synchronized void increment() {      // 한 번에 하나의 스레드만 이 메서드를 실행할 수 있어 값이 엉키는 문제를 막는다.
        count++;                                // 즉, 동시에 접근하는 스레드간의 충돌을 막는다.
    }
    // 그렇다면 단일스레드와의 차이는 어떨까?? 미리 와서 대기하고 있다는 측면에서보면 조금 빠를것 같아 보이지만,
    // 대기를 시키는데 소모되는 것이 전자보다 훨씬 차이를 발생시켜 단일스레드보다 느리다.
    public int getCount() {
        return count;
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Counter counter = new Counter();
                                                // 람다식
        Runnable task = () -> {                 // Runnable 이라는 인터페이스를 상속받는 클래스 인데 이게
            for(int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };
        Thread[] threads = new Thread[5]; // 쓰레드를 껍데기만 만들어 놓음
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);  // 껍데기에 task 집어넣고
            threads[i].start();             // 작동!
        }
        for (Thread t : threads) {          // threads 의 취합결과를 합쳐준다.
            t.join();                       // 근데 InterruptedException 이 일어날 수도 있어서
        }                                   // main 에 throws InterruptedException 를 넣는다.
        // join : 쓰레드가 끝날때까지 기다려라.

        // t.join 이 없으면 1000번대에 머물고 있으면 10000번대에 머문다.
        // count++ 포함하는 메서드에 synchronized 붙이면 50000 이 잘 나온다.
        System.out.println("Final count : " + counter.getCount());

    }
}