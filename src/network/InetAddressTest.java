package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            System.out.println(ia);

            ia = InetAddress.getByName("www.example.com");
            System.out.println(ia);

            InetAddress[] ala = InetAddress.getAllByName("www.google.com");
            for(InetAddress p : ala){
                System.out.println(p);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
