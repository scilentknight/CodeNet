// 5. Write a program to download an object.
// [https://kathford.edu.np/wp-content/uploads/2019/05/kath-log.svg] (2022_14_Prakash)
package DownloadObject;

import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

public class DownloadObject {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://kathford.edu.np");
            Object obj = url.getContent();
            System.out.println("I got a " + obj.getClass().getName());
        } catch(MalformedURLException e){
            System.out.println(args[0] + "is not a parseable URL");
        } catch(IOException e){
            System.err.println(e);
        }
    }
}
