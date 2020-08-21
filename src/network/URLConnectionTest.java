package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/*
* URLConnection 클래스는 추상클래스로, 생성자를 사용해서 객체를 생성 할 수 없다.
* URL 객체의 openConnection() 메소드를 이용하여 생산한다.
* 그리고 URLConnection 객체가 생성되면 connect 메소드를 호출 하여 URL 객체에 설정 되어 있는 URL 에 연결 할 수 있다.
* 이로써 해당 URL 의 자원 뿐 아니라 헤더 정보 까지 얻어 올 수 있다.
* */

public class URLConnectionTest {
    public static void main(String[] args) {
        URLConnection con = null;
        try {
            con = new URL("http://www.example.com").openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(con != null) {
            try (
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8)
                    )
            ) {
                String str;
                String contentType = con.getContentType();
                System.out.println("Content-Type: "+contentType);
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
