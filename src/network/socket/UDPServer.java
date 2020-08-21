package network.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    DatagramSocket dsocket;
    int portNumber;

    public void receive(){
        try{
            dsocket = new DatagramSocket(4000);
            while (true){
                byte []receiveSize = new byte[600];
                DatagramPacket dpacket = new DatagramPacket(receiveSize, receiveSize.length);
                dsocket.receive(dpacket);
                String msg = new String(dpacket.getData());
                System.out.println("클라이언트로부터 메시지:"+msg);
                InetAddress iadress = dpacket.getAddress();
                portNumber = dpacket.getPort();
                dpacket = new DatagramPacket(dpacket.getData(),dpacket.getData().length,iadress,portNumber);
                dsocket.send(dpacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UDPServer udpServer = new UDPServer();
        udpServer.receive();
    }
}
