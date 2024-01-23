import java.util.List;

public class Main {
    static int i = 0;
    static final Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                increment();
            }
        };

        List<Thread> list = List.of(new Thread(runnable), new Thread(runnable));
        list.forEach(Thread::start);
    }

    public static void increment() {
        synchronized (LOCK) {
            i += 1;
            System.out.println(Thread.currentThread() + ": " + i);

            LOCK.notify();

            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
