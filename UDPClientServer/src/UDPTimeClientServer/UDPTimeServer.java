package UDPTimeClientServer;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class UDPTimeServer {
    public static void main(String[] args) {
        try {
            // Bind server to port 2013
            DatagramSocket socket = new DatagramSocket(2013);
            System.out.println("UDP Time Server is running on port " + socket.getLocalPort());

            while (true) {
                // Receive request
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                socket.receive(request);

                System.out.println("Received request from " + request.getAddress() + ":" + request.getPort());

                // Prepare response (current time)
                String time = new Date().toString();
                byte[] buffer = time.getBytes(StandardCharsets.US_ASCII);

                DatagramPacket response = new DatagramPacket(
                        buffer,
                        buffer.length,
                        request.getAddress(),
                        request.getPort()
                );

                // Send response back to client
                socket.send(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}