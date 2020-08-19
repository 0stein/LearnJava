package IO.Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest1 {
    public static void main(String[] args) {
        try (
                BufferedWriter buW = new BufferedWriter
                        (new FileWriter("bufferWriter.txt"),4)
                //버퍼의 크기가 4로, 4바이트를 넘어갈시 flush 되어 출력됨.
        ){
            buW.write('A');
            buW.write('B');
            buW.write('C');
            buW.write('D');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
