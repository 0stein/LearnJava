package IO.OutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
    public static void main(String[] args) {
        String msg = "가나다라마바사";
        ByteArrayOutputStream bao = null;
        try {
            bao = new ByteArrayOutputStream();
            bao.write(msg.getBytes());
            System.out.println("bao = "+bao);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bao != null) {
                    bao.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
