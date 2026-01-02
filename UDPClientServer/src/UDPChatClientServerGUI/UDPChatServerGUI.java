package UDPChatClientServerGUI;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPChatServerGUI extends JFrame {

    private JPanel chatPanel;
    private JTextField input;
    private DatagramSocket socket;

    private InetAddress clientAddress;
    private int clientPort;

    public UDPChatServerGUI() throws Exception {
        socket = new DatagramSocket(3000);

        setTitle("UDP Messenger - Server");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(chatPanel);
        add(scrollPane, BorderLayout.CENTER);

        input = new JTextField();
        JButton send = new JButton("Send");

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(input, BorderLayout.CENTER);
        bottom.add(send, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);

        send.addActionListener(e -> sendMessage());
        input.addActionListener(e -> sendMessage());

        setVisible(true);

        receiveMessages();
    }

    private void sendMessage() {
        try {
            if (clientAddress == null) return;

            String msg = input.getText();
            input.setText("");

            chatPanel.add(new ChatBubble(msg, true));
            chatPanel.revalidate();

            byte[] data = msg.getBytes(StandardCharsets.UTF_8);
            socket.send(new DatagramPacket(data, data.length, clientAddress, clientPort));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void receiveMessages() {
        new Thread(() -> {
            byte[] buffer = new byte[1024];

            while (true) {
                try {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);

                    clientAddress = packet.getAddress();
                    clientPort = packet.getPort();

                    String msg = new String(packet.getData(), 0, packet.getLength());

                    chatPanel.add(new ChatBubble(msg, false));
                    chatPanel.revalidate();
                } catch (Exception e) {
                    break;
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        new UDPChatServerGUI();
    }
}
