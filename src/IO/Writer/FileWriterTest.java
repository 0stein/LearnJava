package IO.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        String msg = "FileWriter 테스트 입니다. \r\n";
        try (FileWriter fw = new FileWriter("fileWriter.txt",true)){
            fw.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
