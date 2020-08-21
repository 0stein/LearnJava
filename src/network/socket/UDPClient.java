package network.socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    private void start(){
        try{
            InetAddress inetAddress = InetAddress.getByName("localhost");
            DatagramSocket datagramSocket = new DatagramSocket(3000);
            Scanner sc = new Scanner(System.in);

            System.out.println("전송할 메시지:");
            String sendData = sc.next();

            byte[] sendBuffer = sendData.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(sendBuffer, sendBuffer.length,inetAddress,4000);
            datagramSocket.send(datagramPacket);

            byte[] receiveBuffer = new byte[600];
            datagramPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UDPClient udpClient = new UDPClient();
        udpClient.start();
    }
}
