package IO.InputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("C:\\file\\test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int var_read = -1;
        if(fin!= null) {
            try {
                while ((var_read = fin.read()) != -1) {
                    System.out.print((char)var_read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
