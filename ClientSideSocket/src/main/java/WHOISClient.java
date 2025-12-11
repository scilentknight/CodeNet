// 3. WAP a JAVA SWING application to perform as WHOIS client. (2022_14_Prakash)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class WHOISClient extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WHOISClient client = new WHOISClient();
            client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            client.pack();
            client.setVisible(true);
        });
    }

    private JTextField domainField;
    private JTextArea resultArea;
    private JButton queryButton;

    public WHOISClient() {
        super("WHOIS Client");

        domainField = new JTextField(30);
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        queryButton = new JButton("Lookup");

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Domain: "));
        topPanel.add(domainField);
        topPanel.add(queryButton);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        queryButton.addActionListener((ActionEvent e) -> {
            String domain = domainField.getText().trim();
            if (!domain.isEmpty()) {
                performWhoisQuery(domain);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a domain name.");
            }
        });
    }

    private void performWhoisQuery(String domain) {
        try {
            resultArea.setText("Querying WHOIS server...\n");

            Socket socket = new Socket("whois.internic.net", 43);
            OutputStream out = socket.getOutputStream();
            out.write((domain + "\r\n").getBytes());
            out.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            resultArea.setText("");

            while ((line = reader.readLine()) != null) {
                resultArea.append(line + "\n");
            }

            reader.close();
            socket.close();
        } catch (Exception ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }
}
