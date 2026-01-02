// 2. WAP to implement UDP chat server client using DatagramSocket.(2022_14_Prakash)
package UDPEchoClientServer;

import java.net.*;
public class UDPEchoServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(2013);
        System.out.println("UDP Echo Server started on port 2013");

        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            // Echo back the same data
            DatagramPacket response = new DatagramPacket(
                    request.getData(),
                    request.getLength(),
                    request.getAddress(),
                    request.getPort()
            );

            socket.send(response);
        }
    }
}
