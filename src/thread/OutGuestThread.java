package thread;

public class OutGuestThread extends Thread{
    InOutProcess ip;

    public OutGuestThread(InOutProcess ip) {
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
