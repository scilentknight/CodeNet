// WAP to display all the header fields and values from a webpage [kathford.edu.np] response. (2022_14_Prakash)

import java.net.*;
import java.io.*;
import java.util.*;

public class HeaderDisplay {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://pathakprakash.com.np");
            URLConnection con = url.openConnection();
            // method 1
//            Map<String, List<String>> contents = con.getHeaderFields();
//            for (String key : contents.keySet()) {
//                System.out.println(key + "=" + con.getHeaderField(key));
//            }
//            System.out.println("Header completed.");

            // method 2
            for (int i = 0; ; i++) {
                String value = con.getHeaderField(i);
                if (value == null)
                    break;
                System.out.println(con.getHeaderFieldKey(i) + " = " + value);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
