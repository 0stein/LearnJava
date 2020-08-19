package IO.DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamTest {
    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("dataFile.txt");
                FileInputStream fis = new FileInputStream("dataFile.txt");
                DataOutputStream dos = new DataOutputStream(fos);
                DataInputStream dis = new DataInputStream(fis)
                ){
            dos.writeShort(-1);
            dos.writeByte(2);
            dos.writeDouble(3.14);
            dos.writeLong(30);
            dos.writeUTF("datastream test");

            System.out.println(dis.readUnsignedShort());
            dis.skip(1);
            System.out.println(dis.readDouble());
            System.out.println(dis.readLong());
            System.out.println(dis.readUTF());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
