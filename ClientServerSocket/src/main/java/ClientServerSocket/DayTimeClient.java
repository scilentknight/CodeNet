// 1. Implement a DayTime client-server application
package ClientServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayTimeClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Server Time: " + in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
