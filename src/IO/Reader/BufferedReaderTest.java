package IO.Reader;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        try (
                FileInputStream fi = new FileInputStream("testforio");
                InputStreamReader isr = new InputStreamReader(fi);
                BufferedReader bfr = new BufferedReader(isr)
                ){
            String str = null;
            while ((str = bfr.readLine()) != null){
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
