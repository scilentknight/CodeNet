package DomainIPFinder;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class DomainIPFinder {
    public static void main(String[] args) {
        String host = "fohss.tu.edu.np";
        InetAddress address = null;
        try{
            address = InetAddress.getByName(host);
            System.out.println("Host Address: " + address.getHostAddress());
            System.out.println("Host Address: " + InetAddress.getByName("kathford.edu.np").getCanonicalHostName());
        }
        catch(UnknownHostException e)
        {
            System.out.println("Host not found: " + host);
            System.exit(1);
        }
    }
}
