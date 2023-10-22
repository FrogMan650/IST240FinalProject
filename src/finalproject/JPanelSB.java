package finalproject;

import java.awt.*;
import javax.swing.*;

public class JPanelSB extends JPanel {
    JButton test = new JButton("TEST");
    public JPanelSB() {
        super();
        setLayout(null);
        setBackground(Color.BLACK);
        test.setBounds(new Rectangle(100,100,100,100));
        add(test);
    }
}
