// 1. WAP to read content from server time.nist.gov at port 80 using socket. (2022_14_Prakash)

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketRead {
    public static void main(String[] args) {
        String host = "time.nist.gov";
        int port = 13;
        try {
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(100000);
            InputStream inputStream = socket.getInputStream();
            // display socket information
            System.out.println("Server address: " + socket.getInetAddress());
            System.out.println("Server port: " + socket.getPort());
            System.out.println("Local address: " + socket.getLocalSocketAddress());
            System.out.println("Local port: " + socket.getLocalPort());

            InputStreamReader reader = new InputStreamReader(inputStream, "ASCII");
            StringBuilder content = new StringBuilder();
            for (int n = reader.read(); n != -1; n = reader.read()) {
                content.append((char) n);
            }
            System.out.println("Server content: " + content);
            socket.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
