package IO.RamdomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFIleTest {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("random.txt","rw")){
            System.out.println("시작 파일 포인터:"+raf.getFilePointer());
            raf.writeInt(75);
            raf.writeBoolean(false);
            raf.writeChar('A');
            raf.writeLong(100);

            System.out.println("데이터 출력 후 파일 포인터:"+raf.getFilePointer());
            raf.seek(0);
            System.out.println("int 값 출력:"+raf.readInt());
            System.out.println("boolean 값 출력:"+raf.readBoolean());

            raf.skipBytes(2);
            System.out.println("long 값 출력:"+raf.readLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
