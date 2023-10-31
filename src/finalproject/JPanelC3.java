package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;

public class JPanelC3 extends JPanel  implements ActionListener, KeyListener {
    ImageIcon sourceImage1 = new ImageIcon("src/pictures/clouds.jpg");
    Image clouds = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    Border whiteLine;
    JButton special,help,help2;
    JButton player,m1,m2,m21,m3,m31,m32,m4,m41,m42,m43,Jtest;
    int score = 0;
    int time = 60;
    Font font;
    Timer gameTimer,buttonTimer,specialTimer;
    int specialPause;
    int delay,delay2;
    int done = 0;
    int playerSize = 25;
    int playerSpeed = 5;
    int playerx = 10;
    int playery = 350;
    int boxy = 0;
    int boxy2 = 0;
    int y = 1;
    int y2 = -1;
    int specialUses = 2;
    int toggleArray[] = new int[50];//0 game start
    public JPanelC3() {
        setLayout(null);
        setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);
        delay = 1000; //milliseconds
        delay2 = 20;
        gameTimer = new Timer(delay, this);
        buttonTimer = new Timer(delay2, this);
        specialTimer = new Timer(delay, this);
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
        special.addActionListener(this);
        special.setText(""+specialUses);
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
        player = new JButton();
        player.setFocusable(false);
        player.setBounds(playerx,playery,playerSize,playerSize);
        player.addActionListener(this);
        add(player);
        m1 = new JButton();
        m1.setFocusable(false);
        m1.setBounds(250,boxy,20,570);
        add(m1);
        m2 = new JButton();
        m2.setFocusable(false);
        m2.setBounds(500,boxy,20,260);
        add(m2);
        m21 = new JButton();
        m21.setFocusable(false);
        m21.setBounds(500,boxy2+360,20,260);
        add(m21);
        m3 = new JButton();
        m3.setFocusable(false);
        m3.setBounds(750,boxy,20,156);
        add(m3);
        m31 = new JButton();
        m31.setFocusable(false);
        m31.setBounds(750,boxy2+256,20,156);
        add(m31);
        m32 = new JButton();
        m32.setFocusable(false);
        m32.setBounds(750,boxy+412,20,156);
        add(m32);
        m4 = new JButton();
        m4.setFocusable(false);
        m4.setBounds(1000,boxy,20,105);
        add(m4);
        m41 = new JButton();
        m41.setFocusable(false);
        m41.setBounds(1000,boxy2+205,20,105);
        add(m41);
        m42 = new JButton();
        m42.setFocusable(false);
        m42.setBounds(1000,boxy+310,20,105);
        add(m42);
        m43 = new JButton();
        m43.setFocusable(false);
        m43.setBounds(1000,boxy2+515,20,105);
        add(m43);
        Jtest = new JButton("Test");
        Jtest.setBounds(1000,500,100,75);
        Jtest.setFocusable(false);
        Jtest.addActionListener(this);
        add(Jtest);
    }
    public void paintComponent(Graphics g) {
            g.drawImage(clouds, 0, 0, this); }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj == gameTimer) {
            time+=-1; }
        if(obj == special) {
            if(specialUses > 0) {
                specialUses-=1;
                buttonTimer.stop();
                specialTimer.start(); 
                special.setText(""+specialUses); } }
        if(obj == specialTimer && specialPause == 4) {
            specialTimer.stop();
            specialPause = 0;
            buttonTimer.start(); }
        if(obj == specialTimer) {
            specialPause+=1; }
        if(obj == buttonTimer) {
            boxy = boxy+y;
            boxy2 = boxy2+y2;
            m1.setBounds(250,boxy,20,570);
            m2.setBounds(500,boxy,20,260);
            m21.setBounds(500,boxy2+360,20,260);
            m3.setBounds(750,boxy,20,156);
            m31.setBounds(750,boxy2+256,20,156);
            m32.setBounds(750,boxy+412,20,156);
            m4.setBounds(1000,boxy,20,105);
            m41.setBounds(1000,boxy2+205,20,105);
            m42.setBounds(1000,boxy+310,20,105);
            m43.setBounds(1000,boxy2+515,20,105);
            if(boxy <= 0) {
            y = 1;
            y2 = -1; }
            if(boxy >= 50) {
            y = -1;
            y2 = 1; } 
            if(playerx>=1280-playerSize) {
                playerx = 10;
                playery = 350;
                score+=1;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=250-playerSize && playerx<=270 && playery>=boxy-playerSize && playery<=boxy+570) {
                playerx = 10;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=500-playerSize && playerx<=520 && playery>=boxy-playerSize && playery<=boxy+260) {
                playerx = 375;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=500-playerSize && playerx<=520 && playery>=(boxy2+360)-playerSize && playery<=(boxy2+360)+260) {
                playerx = 375;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=750-playerSize && playerx<=770 && playery>=(boxy+0)-playerSize && playery<=(boxy+0)+156) {
                playerx = 675;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=750-playerSize && playerx<=770 && playery>=(boxy2+256)-playerSize && playery<=(boxy2+256)+156) {
                playerx = 675;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=750-playerSize && playerx<=770 && playery>=(boxy+412)-playerSize && playery<=(boxy+412)+156) {
                playerx = 675;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=1000-playerSize && playerx<=1020 && playery>=(boxy+0)-playerSize && playery<=(boxy+0)+105) {
                playerx = 875;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=1000-playerSize && playerx<=1020 && playery>=(boxy2+205)-playerSize && playery<=(boxy2+205)+105) {
                playerx = 875;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=1000-playerSize && playerx<=1020 && playery>=(boxy+310)-playerSize && playery<=(boxy+310)+105) {
                playerx = 875;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
            if(playerx>=1000-playerSize && playerx<=1020 && playery>=(boxy2+515)-playerSize && playery<=(boxy2+515)+105) {
                playerx = 875;
                playery = 350;
                player.setBounds(playerx,playery,playerSize,playerSize); }
        }
        if(obj == player && toggleArray[0]==0) {
            buttonTimer.start();
            gameTimer.start();
            toggleArray[0]=1;
            }
        if(obj == Jtest) {
            time = 2; 
            gameTimer.start(); }
    }
    @Override
    public void keyTyped(KeyEvent ke) { }

    @Override
    public void keyPressed(KeyEvent evt) { 
        int kk = evt.getKeyCode();
        if(kk ==  evt.VK_LEFT && playerx <=0 && toggleArray[0]==1) {
            player.setBounds(0,playery,playerSize,playerSize); }
        else if(kk ==  evt.VK_RIGHT && playerx >=1280-playerSize && toggleArray[0]==1) {
            player.setBounds(1280-playerSize,playery,playerSize,playerSize); } 
        else if(kk ==  evt.VK_UP && playery <=0 && toggleArray[0]==1) {
            player.setBounds(playerx,0,playerSize,playerSize); }
        else if(kk ==  evt.VK_DOWN && playery >=620-playerSize && toggleArray[0]==1) {
            player.setBounds(playerx,620-playerSize,playerSize,playerSize); } 
        else if(kk ==  evt.VK_LEFT && toggleArray[0]==1) {
            playerx+=-playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); }
        else if(kk ==  evt.VK_RIGHT && toggleArray[0]==1) {
            playerx+=playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); } 
        else if(kk ==  evt.VK_DOWN && toggleArray[0]==1) {
            playery+=playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); }
        else if(kk ==  evt.VK_UP && toggleArray[0]==1) {
            playery+=-playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); }
    }

    @Override
    public void keyReleased(KeyEvent ke) { }
}
