// 2. Implement a secured client server chat application. (2022_14_Prakash)
import java.io.*;
import java.security.KeyStore;
import java.util.Scanner;

import javax.net.ssl.*;

public class SSLServer {

    private static final int PORT = 8888;
    private static final String KEYSTORE_PATH = "server.keystore";
    private static final String KEYSTORE_PASSWORD = "codex123";

    public static void main(String[] args) {
        try {
            // Load keystore
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(KEYSTORE_PATH),
                    KEYSTORE_PASSWORD.toCharArray());

            // Key manager
            KeyManagerFactory kmf =
                    KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, KEYSTORE_PASSWORD.toCharArray());

            // SSL context
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(kmf.getKeyManagers(), null, null);

            // Server socket
            SSLServerSocketFactory ssf = sc.getServerSocketFactory();
            SSLServerSocket serverSocket =
                    (SSLServerSocket) ssf.createServerSocket(PORT);

            System.out.println(" SSL Server started on port " + PORT);

            SSLSocket socket = (SSLSocket) serverSocket.accept();
            System.out.println(" Client connected");

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            String clientMsg, serverMsg;

            // 2-way chat loop
            while (true) {
                clientMsg = in.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected");
                    break;
                }

                System.out.println("Client: " + clientMsg);

                System.out.print("Server: ");
                serverMsg = scanner.nextLine();
                out.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
