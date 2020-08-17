package thread;

public class InGuestThread extends Thread{
    InOutProcess ip;

    public InGuestThread(InOutProcess ip){
        this.ip = ip;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            ip.inGuest();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
