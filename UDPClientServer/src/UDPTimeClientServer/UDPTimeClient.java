// 1. WAP to implement UDP time server client using DatagramSocket.(2022_14_Prakash)
package UDPTimeClientServer;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPTimeClient {
    public static void main(String[] args) {
        try {

            DatagramSocket socket = new DatagramSocket(0);
            System.out.println("The client is running at: " + socket.getLocalPort());
            // prepare request
            InetAddress server = InetAddress.getByName("localhost");
            DatagramPacket request = new DatagramPacket(new byte[1], 1, server, 2013);
            // send request
            socket.send(request);

            // retrieve response
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.receive(response);

            // get content from response
            String content = new String(response.getData(), 0, response.getLength(), StandardCharsets.US_ASCII);
            // display the content
            System.out.println("Received from server: " + content);

            // close the socked
            socket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
