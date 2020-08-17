package thread;

public class PriorityTest {
    public static void main(String[] args){
        MaxPriorityThread maxPriorityThread = new MaxPriorityThread("thread1");
        maxPriorityThread.setPriority(Thread.MAX_PRIORITY);
        MinPriorityThread minPriorityThread = new MinPriorityThread("thread2");
        minPriorityThread.setPriority(Thread.MIN_PRIORITY);

        maxPriorityThread.start();
        minPriorityThread.start();
    }
}
