package thread;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class TicketBook implements Runnable{
    int ticketNum = 10;
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try{
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            getTicket();
        }
    }

    private synchronized void getTicket() {
        ticketNum -= 1;
        if(ticketNum <= 0){
            System.out.print(currentThread().getName() + ",");
            System.out.println("잔여 좌석이 없습니다.");
            return;
        }
        System.out.print(currentThread().getName() + ",");
        System.out.println("현재 잔여좌석 "+ticketNum+"좌석입니다.");
    }
}
