public class Worker extends Thread {
    private int x;
    private Object o;

    public Worker(int x, Object o) {
        this.x = x;
        this.o = o;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(x);
            x += 2;
        }
    }

}
