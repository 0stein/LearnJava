package network.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread{
    private InputStream is;
    private OutputStream os;
    private ServerSocket serverSocket;
    private ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket socket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(5000);
            while (true){
                System.out.println("요청 대기(5000port)");
                socket = serverSocket.accept();
                System.out.println("접속한 클라이언트:"+socket.getInetAddress());
                is = socket.getInputStream();
                os = socket.getOutputStream();
                ois = new ObjectInputStream(is);
                oos = new ObjectOutputStream(os);
                String msg = (String)ois.readObject();
                System.out.println("클라이언트에서 보낸 메시지 : "+msg);
                String retMsg="서버로 부터 되돌아온 메시지 : " +msg;
                oos.writeObject(retMsg);
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPServer().start();
    }
}
