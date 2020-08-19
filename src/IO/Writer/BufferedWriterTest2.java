package IO.Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest2 {
    public static void main(String[] args) {
        try (
                BufferedWriter buW = new BufferedWriter
                        (new FileWriter("bufferWriter.txt"),4)
                //버퍼의 크기가 4로, 4바이트를 넘어갈시 flush 되어 출력됨.
        ){
            buW.write("여러 라인 출력 예시 1");
            buW.newLine();
            buW.write("여러 라인 출력 예시 1");
            buW.newLine();
            buW.write("여러 라인 출력 예시 1");
            buW.newLine();
            buW.write("여러 라인 출력 예시 1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
