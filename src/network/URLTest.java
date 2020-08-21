package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class URLTest {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.example.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url != null) {
            try (
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)
                    )
            ) {
                String str;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
