package RelativeURLDemo;

import java.net.*;

public class URLEncodeDecode {
    public static void main(String[] args) {
        try {
            String data = "Hello World! Java @ URL Encoding";

            // Encode
            String encoded = URLEncoder.encode(data, "UTF-8");
            System.out.println("Encoded URL: " + encoded);

            // Decode
            String decoded = URLDecoder.decode(encoded, "UTF-8");
            System.out.println("Decoded URL: " + decoded);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
