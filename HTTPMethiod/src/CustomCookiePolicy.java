// Write a program that shows a simple CookiePolicy that blocks cookies from any .edu.np, but allows others. (2022_14_Prakash)

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javax.swing.UIManager.put;

public class CustomCookiePolicy implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        if (uri.getHost().contains(".com.np")) {
            System.out.println("The cookie is allowed for the domain : " + uri.getHost());
            return true;
        }
        System.out.println("The cookie is blocked for this domain : " + uri.getHost());
        return false;
    }

    public static void main(String[] args) {
        CustomCookiePolicy customCookiePolicy = new CustomCookiePolicy();
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(customCookiePolicy);

        try {
            URI uri1 = new URI("http://www.tu.edu.np");
            URI uri2 = new URI("http://www.pathakprakash.com.np");

            List<String> myCookie = new ArrayList<String>();
            myCookie.add("key=value");

            HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>() {
                {
                    put("Set-Cookie", myCookie);
                }
            };

            // check policy
            cookieManager.put(uri1, hashMap);
            cookieManager.put(uri2, hashMap);

        } catch (URISyntaxException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

