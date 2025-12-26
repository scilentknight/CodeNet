// 2. Implement a time server client application using socket channel. (2022_14_Prakash)
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SocketChannelTimeClient {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();

            // connect to the localhost at server port
            int port = 2000;
            InetAddress addr = InetAddress.getLocalHost();
            SocketAddress address = new InetSocketAddress(addr, port);
            channel.connect(address);

            // read from the server
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            channel.read(readBuffer);

            // convert the byteBuffer to string and display
            byte[] arr = readBuffer.array();
            String content = new String(arr, StandardCharsets.US_ASCII);
            System.out.println("Server send the time: " + content);
            channel.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
