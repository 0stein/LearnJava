package thread;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class DressingRoom implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            for(int i=5; i>0; i--){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(currentThread().getName());
                System.out.println("dressing 종료 "+(i*10)+"초 전..");
            }
            System.out.println(currentThread().getName()+"dressing 완료");
        }
    }
}
