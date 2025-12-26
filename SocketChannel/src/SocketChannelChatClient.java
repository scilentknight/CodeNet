// 3. Implement a client server chat application using socket channel. (2022_14_Prakash)
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketChannelChatClient {

    public static void main(String[] args) {
        int port = 3000;

        try (SocketChannel channel = SocketChannel.open()) {

            InetAddress addr = InetAddress.getLocalHost();
            channel.connect(new InetSocketAddress(addr, port));
            System.out.println("Connected to Chat Server");

            Scanner scanner = new Scanner(System.in);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {

                // Send message to server
                System.out.print("Client: ");
                String msg = scanner.nextLine();
                buffer.clear();
                buffer.put(msg.getBytes(StandardCharsets.US_ASCII));
                buffer.flip();
                channel.write(buffer);

                // Read reply from server
                buffer.clear();
                channel.read(buffer);
                buffer.flip();
                String serverMsg =
                        StandardCharsets.US_ASCII.decode(buffer).toString();
                System.out.println("Server: " + serverMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}