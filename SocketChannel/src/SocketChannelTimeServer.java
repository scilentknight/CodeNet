// 2. Implement a time server client application using socket channel. (2022_14_Prakash)
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class SocketChannelTimeServer {

    public static void main(String[] args) {
        int port = 2000;

        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {

            // Bind the server to the port
            SocketAddress address = new InetSocketAddress(port);
            serverChannel.bind(address);

            System.out.println("Time server started on port " + port);

            while (true) {
                // Accept incoming client connection
                try (SocketChannel client = serverChannel.accept()) {

                    System.out.println("Connected to client: " + client.getRemoteAddress());

                    // Prepare content to send
                    String time = new Date().toString();
                    ByteBuffer buffer = ByteBuffer.wrap(time.getBytes(StandardCharsets.US_ASCII));

                    // Write to client
                    client.write(buffer);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
