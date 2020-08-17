package thread;

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    public void run(){
        for(int i=0; i<10; i++){
            try {
                sleep(100);
                System.out.print("*");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
