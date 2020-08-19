package IO.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamTest {
    public static void main(String[] args) {
        FileInputStream file1 = null;
        FileInputStream file2 = null;
        FileInputStream file3 = null;
        SequenceInputStream si1 = null;
        SequenceInputStream si2 = null;

        try{
            file1 = new FileInputStream("C:\\file\\test1.txt");
            file2 = new FileInputStream("C:\\file\\test2.txt");
            file3 = new FileInputStream("C:\\file\\test3.txt");

            Vector v = new Vector();
            v.add(file1);
            v.add(file2);
            v.add(file3);

            Enumeration files = v.elements();
            si1 = new SequenceInputStream(files);
            int var_readbyte = -1;
            while((var_readbyte = si1.read()) != -1){
                System.out.print((char)var_readbyte);
            }
            System.out.println();

            file1 = new FileInputStream("C:\\file\\test1.txt");
            file2 = new FileInputStream("C:\\file\\test2.txt");

            si2 = new SequenceInputStream(file1, file2);
            while((var_readbyte = si2.read())!=-1){
                System.out.print((char)var_readbyte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                si1.close();
                si2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
