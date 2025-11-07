// 2. Write a program that checks the protocols a virtual machine support.
// [ex: http, https, ftp, telnet, mailto, gopher] (2022_14_Prakash)
package CheckProtocols;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckProtocols {
    public static void main(String[] args) {
        // List of common protocols to check
        String[] protocols = {"http", "https", "ftp", "telnet", "mailto", "gopher"};
        System.out.println("Checking supported protocols in this virtual machine:\n");

        for (String protocol : protocols) {
            try {
                // Try to create a URL object using the protocol
                URL url = new URL(protocol + "://example.com");
                System.out.println(protocol.toUpperCase() + " : Supported ✅");
            } catch (MalformedURLException e) {
                System.out.println(protocol.toUpperCase() + " : Not Supported ❌");
            }
        }
        System.out.println("\nProtocol check completed.");
    }
}

