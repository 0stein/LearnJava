package IO.InputStream;

import java.io.IOException;

public class InputStreamTest {
    public static void main(String[] args) {
        int var_byte = -1;

        do{
            try {
                var_byte = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(var_byte == 10 || var_byte ==13) continue;
            if(var_byte == -1) break;
            System.out.println("읽은 값:"+var_byte);
        }while(true);

    }
}
