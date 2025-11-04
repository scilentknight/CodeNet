package IPCheck;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class IPCheck {
    public static void main(String[] args) {
        String host = "fohss.tu.edu.np";
        InetAddress address = null;
        try{
            address = InetAddress.getByName(host);
            String hostAdd = address.getHostAddress();
            byte[] bt = address.getAddress();
            if(bt.length == 4)
            {
                System.out.println("Host address " +hostAdd + " is IPV4 Address");
            }
            else if(bt.length == 16)
            {
                System.out.println("Host address " +hostAdd + " is IPV6 Address");
            }
        }
        catch(UnknownHostException e)
        {
            System.out.println("Host not found: " + host);
            System.exit(1);
        }
    }
}
