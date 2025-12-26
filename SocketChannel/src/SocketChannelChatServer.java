// 3. Implement a client server chat application using socket channel. (2022_14_Prakash)
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketChannelChatServer {

    public static void main(String[] args) {
        int port = 3000;

        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {

            serverChannel.bind(new InetSocketAddress(port));
            System.out.println("Chat Server started on port " + port);

            SocketChannel client = serverChannel.accept();
            System.out.println("Client connected");

            Scanner scanner = new Scanner(System.in);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {

                // Read message from client
                buffer.clear();
                client.read(buffer);
                buffer.flip();
                String clientMsg =
                        StandardCharsets.US_ASCII.decode(buffer).toString();
                System.out.println("Client: " + clientMsg);

                // Send message to client
                System.out.print("Server: ");
                String serverMsg = scanner.nextLine();
                buffer.clear();
                buffer.put(serverMsg.getBytes(StandardCharsets.US_ASCII));
                buffer.flip();
                client.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}