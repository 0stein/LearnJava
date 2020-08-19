package IO.Reader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader("testforio")){
           int readChar = -1;
           while((readChar = fr.read()) != -1){
               System.out.print((char)readChar);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
