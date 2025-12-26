// 2. Implement a secured client server chat application. (2022_14_Prakash)
import java.io.*;
import java.security.KeyStore;
import java.util.Scanner;

import javax.net.ssl.*;

public class SSLClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    private static final String TRUSTSTORE_PATH = "client.truststore";
    private static final String TRUSTSTORE_PASSWORD = "codex123";

    public static void main(String[] args) {
        try {
            // Load truststore
            KeyStore ts = KeyStore.getInstance("JKS");
            ts.load(new FileInputStream(TRUSTSTORE_PATH),
                    TRUSTSTORE_PASSWORD.toCharArray());

            // Trust manager
            TrustManagerFactory tmf =
                    TrustManagerFactory.getInstance("SunX509");
            tmf.init(ts);

            // SSL context
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, tmf.getTrustManagers(), null);

            // Client socket
            SSLSocketFactory ssf = sc.getSocketFactory();
            SSLSocket socket =
                    (SSLSocket) ssf.createSocket(HOST, PORT);

            System.out.println(" Connected to SSL Server");

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            String clientMsg, serverReply;

            // 2-way chat loop
            while (true) {
                System.out.print("Client: ");
                clientMsg = scanner.nextLine();
                out.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    break;
                }

                serverReply = in.readLine();
                if (serverReply == null || serverReply.equalsIgnoreCase("bye")) {
                    break;
                }

                System.out.println("Server: " + serverReply);
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
