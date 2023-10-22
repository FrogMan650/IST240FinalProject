package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class JPanelWC extends JPanel  implements ActionListener {
    ImageIcon sourceImage1 = new ImageIcon("src/pictures/clouds.jpg");
    Image clouds = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    Border whiteLine;
    JButton special,help,help2,Jtest,box;
    int score = 0;
    int time = 60;
    Font font;
    Timer gameTimer;
    int delay;
    int done = 0;
    int playerSize = 100;
    public JPanelWC() {
        setLayout(null);
        setBackground(Color.blue);
        delay = 1000; //milliseconds
        gameTimer = new Timer(delay, this);
        font = new Font("TimesRoman",20,50);
        whiteLine = BorderFactory.createLineBorder(Color.WHITE,3);
        setBackground(Color.BLUE);
        setBorder(whiteLine);
        special = new JButton();
        special.setBounds(0,620,100,100);
        special.setBorder(whiteLine);
        special.setBackground(Color.BLUE);
        special.setForeground(Color.WHITE);
        special.setFont(font);
        special.setFocusable(false);
        add(special);
        help = new JButton("?");
        help.setBounds(1180,620,100,100);
        help.setBorder(whiteLine);
        help.setBackground(Color.RED);
        help.setFont(font);
        help.setFocusable(false);
        add(help);
        help2 = new JButton("?");
        help2.setBounds(1180,620,100,100);
        help2.setBorder(whiteLine);
        help2.setBackground(Color.RED);
        help2.setFont(font);
        help2.setFocusable(false);
        Jtest = new JButton("Test");
        Jtest.setBounds(1000,500,100,75);
        Jtest.setFocusable(false);
        Jtest.addActionListener(this);
        add(Jtest);
        box = new JButton();
        box.setBounds(50,50,playerSize,playerSize);
        box.setFocusable(false);
        box.addActionListener(this);
        add(box);
    }
    public void paintComponent(Graphics g) {
            g.drawImage(clouds, 0, 0, this); }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj == gameTimer) {
            time+=-1; }
        if(obj == Jtest) {
            time = 2; 
            gameTimer.start(); }
    }
}
