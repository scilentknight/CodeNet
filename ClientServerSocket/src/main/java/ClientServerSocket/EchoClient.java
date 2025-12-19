// 2. Implement an echo client - server application where the client sends some text and server relays back the same content.
package ClientServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Connected to Echo Server.");
            while (true) {
                System.out.print("Enter message: ");
                String msg = scanner.nextLine();

                out.println(msg);                   // Send to server
                System.out.println(in.readLine());   // Receive echo
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
