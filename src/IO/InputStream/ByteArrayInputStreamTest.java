package IO.InputStream;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {
    public static void main(String[] args) {
        byte[] datas = new byte[]{1,2,3,4,5};
        ByteArrayInputStream bai = new ByteArrayInputStream(datas);
        int var_readbyte = -1;

        while((var_readbyte = bai.read())!=-1){
            System.out.println(var_readbyte + "");
        }
    }
}
