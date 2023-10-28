package finalproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class mapJPanel extends JPanel implements KeyListener{
    ImageIcon sourceImage1 = new ImageIcon("src/pictures/map.jpg");
    Image map = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    JButton up = new JButton("UP");
    JButton erie = new JButton("Erie");
    JButton york = new JButton("York");
    JButton scranton = new JButton("Scranton");
    JButton wc = new JButton("World Campus");
    JButton player = new JButton("ME");
    JButton altoona = new JButton("Altoona");
    JButton test = new JButton("test");
    JLabel TotalTime,TotalScore;
    int playerx = 200;
    int playery = 200;
    Border blackLine;
    Font font;
    public mapJPanel() {
        super();
        setLayout(null);
        font = new Font("TimesRoman",20,35);
        TotalTime = new JLabel();
        TotalTime.setFont(font);
        TotalTime.setText("Time: ");
        TotalTime.setBounds(800,20,200,50);
        add(TotalTime);
        TotalScore = new JLabel();
        TotalScore.setFont(font);
        TotalScore.setText("Score: ");
        TotalScore.setBounds(1050,20,200,50);
        add(TotalScore);
        blackLine = BorderFactory.createLineBorder(Color.BLACK,3);
        setBorder(blackLine);
        test.setBounds(1000,600,100,50);
        add(test);
        up.setBounds(new Rectangle(560,350,50,50));
        up.setBackground(Color.WHITE);
        up.setForeground(Color.BLUE);
        up.setFocusable(false);
        add(up);
        erie.setBounds(new Rectangle(50,40,75,50));
        erie.setBackground(Color.WHITE);
        erie.setForeground(Color.BLUE);
        erie.setFocusable(false);
        add(erie);
        york.setBounds(new Rectangle(700,600,75,50));
        york.setBackground(Color.WHITE);
        york.setForeground(Color.BLUE);
        york.setFocusable(false);
        add(york);
        scranton.setBounds(new Rectangle(950,200,100,50));
        scranton.setBackground(Color.WHITE);
        scranton.setForeground(Color.BLUE);
        scranton.setFocusable(false);
        add(scranton);
        altoona.setBounds(new Rectangle(350,450,100,50));
        altoona.setBackground(Color.WHITE);
        altoona.setForeground(Color.BLUE);
        altoona.setFocusable(false);
        add(altoona);
        wc.setBounds(new Rectangle(530,10,200,50));
        wc.setBackground(Color.WHITE);
        wc.setForeground(Color.BLUE);
        wc.setFocusable(false);
        add(wc);
        player.setBounds(new Rectangle(200,200,60,50));
        player.setBackground(Color.BLUE);
        player.setForeground(Color.WHITE);
        player.setFocusable(false);
        setFocusable(true);
        addKeyListener(this);
        add(player); }
    public void paintComponent(Graphics g) {
            g.drawImage(map, 0, 0, this); }
    @Override
    public void keyTyped(KeyEvent ke) { }
    @Override
    public void keyPressed(KeyEvent evt) { 
        int kk = evt.getKeyCode();
        if(kk ==  evt.VK_LEFT) {playerx+=-10;}
        if(kk ==  evt.VK_RIGHT) {playerx+=10;}
        if(kk ==  evt.VK_UP) {playery+=-10;}
        if(kk ==  evt.VK_DOWN) {playery+=10;}
            player.setBounds(new Rectangle(playerx,playery,60,50)); }
    @Override
    public void keyReleased(KeyEvent ke) { }
}
