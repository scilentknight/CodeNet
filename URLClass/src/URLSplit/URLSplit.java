// 1. Write a program that splits the parts of a URL
// [ex: https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-]
package URLSplit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class URLSplit {
    public static void main(String[] args) {
        try{
            String urlStr = "https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-";
            URL url = new URL(urlStr);
            // split into parts
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Hostname: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Filename: " + url.getFile());
            System.out.println("UserInfo: " + url.getUserInfo());
            System.out.println("Query String: " + url.getQuery());
            System.out.println("Fragment Id: " + url.getRef());

        } catch (MalformedURLException e){
            Logger.getLogger(URLSplit.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
