package thread;

import static java.lang.Thread.sleep;

public class MyThread2 implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                sleep(100);
                System.out.print("!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
