package finalproject;

import java.awt.*;
import javax.swing.*;

public class JPanelSB extends JPanel {
    JButton test = new JButton("TEST");
    int totalTime;
    int totalScore;
    JLabel finalTime = new JLabel("final time:");
    JLabel finalScore = new JLabel("final score:");
    JLabel gameOver = new JLabel("GAME OVER");
    Font font = new Font("TimesRoman",30,40);
    Font fontTwo = new Font("TimesRoman",60,90);
    public JPanelSB() {
        super();
        setLayout(null);
        setBackground(Color.BLACK);
        test.setBounds(new Rectangle(1000,500,200,100));
        test.setFont(font);
        add(test);
        finalTime.setFont(font);
        finalTime.setForeground(Color.BLUE);
        finalScore.setFont(font);
        finalScore.setForeground(Color.BLUE);
        gameOver.setFont(fontTwo);
        gameOver.setForeground(Color.WHITE);
    }
}
