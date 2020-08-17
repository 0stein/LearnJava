package thread;

public class Main {
    public static void main(String []args){
        MyThread myThread = new MyThread("thread1");
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2,"thread2");

        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.start();
    }
}
