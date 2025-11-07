// 3. Write a program to download a web page of a given web address
// [ex: www.kathford.edu.np] (2022_14_Prakash)
package DownloadWebPage;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;

public class DownloadWebPage {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.kathford.edu.np");
            InputStream in = url.openStream();
            int c;
            while((c = in.read())!= -1)
            {
                System.out.write(c);
            }
            in.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
