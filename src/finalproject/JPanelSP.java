package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.border.*;
import javax.swing.*;

public class JPanelSP extends JPanel {
    ImageIcon sourceImage1 = new ImageIcon("src/pictures/bar1.jpg");
    Image clouds = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    Border whiteLine;
    JLabel Totaltime,Totalscore,overall,current,currentTime,currentScore;
    Font font = new Font("TimesRoman",20,30);
    public JPanelSP() {
        setLayout(null);
        Totaltime = new JLabel("Time: 0");
        Totaltime.setBounds(20,50,300,50);
        Totaltime.setFont(font);
        add(Totaltime);
        Totalscore = new JLabel("Score: 0");
        Totalscore.setBounds(300,50,300,50);
        Totalscore.setFont(font);
        add(Totalscore);
        overall = new JLabel("Overall");
        overall.setBounds(150,0,300,50);
        overall.setFont(font);
        add(overall);
        current = new JLabel("This Campus");
        current.setBounds(700,0,300,50);
        current.setFont(font);
        add(current);
        currentTime = new JLabel("Time: 0");
        currentTime.setBounds(600,50,300,50);
        currentTime.setFont(font);
        add(currentTime);
        currentScore = new JLabel("Score: 0");
        currentScore.setBounds(900,50,300,50);
        currentScore.setFont(font);
        add(currentScore);
        whiteLine = BorderFactory.createLineBorder(Color.WHITE,3);
        setBackground(Color.BLUE);
        setBorder(whiteLine);
    }
    public void paintComponent(Graphics g) {
        g.drawImage(clouds, 0, 0, this); }
}
