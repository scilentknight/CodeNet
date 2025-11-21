// WAP to guess the MIME content type of a webpage, a PDF and a PNG files. (2022_14_Prakash)

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GuessMimeType {
    public static void main(String[] args) {
        String urlPage = "https://pathakprakash.com.np";
        String urlPNG =  "https://khemrajbahadurraut.com.np/main-logo/logo.png";
        String urlCSS =  "https://khemrajbahadurraut.com.np/assets/index-DB79lPpZ.css";
        String urlICON =  "https://khemrajbahadurraut.com.np/carousel/carousel1.jpg";
        String fileName = "myfile.pdf";

        try {
            URL url1 = new URL(urlPage);
            URL url2 = new URL(urlPNG);
            URL url3 = new URL(urlCSS);
            URL url4 = new URL(urlICON);

            URLConnection con1 = url1.openConnection();
            URLConnection con2 = url2.openConnection();
            URLConnection con3 = url3.openConnection();
            URLConnection con4 = url4.openConnection();

            System.out.println("The MIME type of web is " + con1.getContentType());
            System.out.println("The MIME type of png is " + con2.getContentType());
            System.out.println("The MIME type of css is " + con3.getContentType());
            System.out.println("The MIME type of icon is " + con4.getContentType());

            System.out.println("The MIME type of my file is " + URLConnection.guessContentTypeFromName(fileName));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
