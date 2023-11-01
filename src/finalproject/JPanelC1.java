package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;

public class JPanelC1 extends JPanel implements ActionListener, KeyListener {
    ImageIcon sourceImage1 = new ImageIcon("src/pictures/clouds.jpg");
    Image clouds = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    Border whiteLine;
    JButton special,help,help2,player,bouncer,block1,block2,Jtest;
    int score = 0;
    int time = 60;
    int x = 1;
    int y = -1;
    int X = 450;
    int Y = 520;
    Font font;
    Timer gameTimer,buttonTimer;
    int delay,delay2,playerx,playerx2;
    int specialUses = 2;
    int Playerx = 400;
    int done = 0;
    int toggleArray[] = new int[50];//1 timer start
    public JPanelC1() {
        setLayout(null);
        setBackground(Color.blue);
        delay = 1000; //milliseconds
        delay2 = 5;
        gameTimer = new Timer(delay, this);
        buttonTimer = new Timer(delay2, this);
        font = new Font("TimesRoman",20,50);
        whiteLine = BorderFactory.createLineBorder(Color.WHITE,3);
        setBackground(Color.BLUE);
        setBorder(whiteLine);
        setFocusable(true);
        addKeyListener(this);
        //=========================================score buttons
        special = new JButton();
        special.setBounds(0,620,100,100);
        special.setBorder(whiteLine);
        special.setBackground(Color.BLUE);
        special.setForeground(Color.WHITE);
        special.setFont(font);
        special.setFocusable(false);
        special.setText(""+specialUses);
        special.addActionListener(this);
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
        //=======================================game buttons
        player = new JButton();
        player.setBorder(whiteLine);
        player.setBackground(Color.BLUE);
        player.setFocusable(false);
        bouncer = new JButton();
        bouncer.setBounds(450,520,50,50);
        bouncer.setBorder(whiteLine);
        bouncer.setBackground(Color.orange);
        bouncer.setFocusable(false);
        bouncer.addActionListener(this);
        add(bouncer);
        block1 = new JButton();
        block1.setBounds(193,200,307,50);
        block1.setBorder(whiteLine);
        block1.setBackground(Color.BLUE);
        block1.setFocusable(false);
        add(block1);
        block2 = new JButton();
        block2.setBounds(773,200,307,50);
        block2.setBorder(whiteLine);
        block2.setBackground(Color.BLUE);
        block2.setFocusable(false);
        add(block2);
        Jtest = new JButton("Test");
        Jtest.setBounds(1000,500,100,75);
        Jtest.setFocusable(false);
        Jtest.addActionListener(this);
        //add(Jtest);
    }
    public void paintComponent(Graphics g) {
            g.drawImage(clouds, 0, 0, this); }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj == gameTimer) {
            time+=-1; }
        if(obj == bouncer && toggleArray[0]==0) {
            gameTimer.start();
            buttonTimer.start(); 
            toggleArray[0]=1;   }
        if(obj == special) {
            if(specialUses>=1) {
                specialUses-=1;
                x*=-1;
                y*=-1; } }
        if(obj == Jtest) {
            time = 2; 
            toggleArray[0]=1;
            gameTimer.start(); }
        if(obj == buttonTimer) {
            special.setText(""+specialUses);
            //===================================bouncer window triggers
            if(X>0 && X<1230 && Y<570 && Y>0) {
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==0 && Y==0) {
                x = 1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==1230 && Y==570) {
                score+=-1;
                x = -1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==0 && Y<570 && Y>0) {
                x = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X>0 && X<1230 && Y==0) {
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==1230 && Y<570 && Y>0) {
                x = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X>0 && X<1230 && Y==570) {
                score+=-1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==0 && Y==570) {
                score+=-1;
                x = 1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==1230 && Y==0) {
                x = -1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            //===================================player bouncer triggers
            if(X==(Playerx-50) && Y==530) {
                x = -1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(Playerx+playerx) && Y==530) {
                x = 1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(Playerx-50) && Y<620 && Y>530) {
                x = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(Playerx+playerx) && Y<620 && Y>530) {
                x = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(Y==530 && X<(Playerx+playerx) && X>(Playerx-50)) {
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            //===================================block1 bouncer triggers
            if(X==143 && Y==150) {
                score+=1;
                x = -1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==500 && Y==250) {
                score+=1;
                x = 1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==143 && Y==250) {
                score+=1;
                x = -1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==500 && Y==150) {
                score+=1;
                x = 1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==143 && Y<=250 && Y>=150) {
                score+=1;
                x = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==500 && Y<=250 && Y>=150) {
                score+=1;
                x = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(Y==150 && X<=500 && X>=143) {
                score+=1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(Y==250 && X<=500 && X>=143) {
                score+=1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            //===================================block2 bouncer triggers
            if(X==723 && Y==150) {
                score+=1;
                x = -1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==1080 && Y==250) {
                score+=1;
                x = 1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==723 && Y==250) {
                score+=1;
                x = -1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==1080 && Y==150) {
                score+=1;
                x = 1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==723 && Y<=250 && Y>=150) {
                score+=1;
                x = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==1080 && Y<=250 && Y>=150) {
                score+=1;
                x = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(Y==150 && X<=1080 && X>=723) {
                score+=1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(Y==250 && X<=1080 && X>=723) {
                score+=1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) { }

    @Override
    public void keyPressed(KeyEvent evt) { 
        int kk = evt.getKeyCode();
        if(kk ==  evt.VK_LEFT) {
            Playerx+=-playerx2;
            player.setBounds(Playerx,580,playerx,20); }
        if(kk ==  evt.VK_RIGHT) {
            Playerx+=playerx2;
            player.setBounds(Playerx,580,playerx,20); }
        if(kk ==  evt.VK_LEFT && toggleArray[0]==0) {
            Playerx+=-playerx2;
            X-=playerx2*2;
            bouncer.setBounds(X,Y,50,50);
            player.setBounds(Playerx,580,playerx,20); }
        if(kk ==  evt.VK_RIGHT && toggleArray[0]==0) {
            Playerx+=playerx2;
            X+=playerx2*2;
            bouncer.setBounds(X,Y,50,50);
            player.setBounds(Playerx,580,playerx,20); } }

    @Override
    public void keyReleased(KeyEvent ke) { }
}
