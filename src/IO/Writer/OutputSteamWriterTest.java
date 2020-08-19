package IO.Writer;

import java.io.*;

public class OutputSteamWriterTest {
    public static void main(String[] args) {
        try (BufferedWriter buffW = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("outputStream.txt")
                ))
        ){
            buffW.write("outputStreamWriter 테스트");
            buffW.newLine();
            buffW.write("outputStreamWriter 테스트");
            buffW.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
