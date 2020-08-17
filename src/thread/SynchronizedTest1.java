package thread;

public class SynchronizedTest1 {
    public static void main(String[] args) {
        TicketBook ticketBook = new TicketBook();
        Thread tb1 = new Thread(ticketBook,"p1");
        Thread tb2 = new Thread(ticketBook,"p2");

        tb1.start();
        tb2.start();
    }
}
