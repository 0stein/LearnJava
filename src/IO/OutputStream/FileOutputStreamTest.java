package IO.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream fo = null;
        String msg = "FileOutputStream Test";
        byte[] byteArray = msg.getBytes();

        try {
            fo = new FileOutputStream("C:\\file\\FileOutput.txt");
            fo.write(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fo != null) {
                    fo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
