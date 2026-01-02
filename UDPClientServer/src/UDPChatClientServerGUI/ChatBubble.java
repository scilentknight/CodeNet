package UDPChatClientServerGUI;

import javax.swing.*;
import java.awt.*;

public class ChatBubble extends JPanel {

    public ChatBubble(String text, boolean isSender) {

        setLayout(new FlowLayout(
                isSender ? FlowLayout.RIGHT : FlowLayout.LEFT,
                5,   // horizontal gap
                2    // vertical gap (VERY IMPORTANT)
        ));

        setOpaque(false);

        JLabel message = new JLabel(
                "<html><div style='max-width:220px;'>" + text + "</div></html>"
        );

        message.setOpaque(true);
        message.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));

        if (isSender) {
            message.setBackground(new Color(0, 132, 255));
            message.setForeground(Color.WHITE);
        } else {
            message.setBackground(new Color(230, 230, 230));
            message.setForeground(Color.BLACK);
        }

        add(message);
    }
}
