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

public class JPanelC2 extends JPanel  implements ActionListener, KeyListener {
    ImageIcon sourceImage1 = new ImageIcon(this.getClass().getResource("/pictures/clouds.jpg"));
    Image clouds = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    Border whiteLine;
    JButton special,help,help2,player,bouncer,target,Jtest;
    int score = 0;
    int time = 60;
    Font font;
    Timer gameTimer,buttonTimer,specialTimer;
    int delay,delay2;
    int x = 1;
    int y = -1;
    int X = 450;
    int Y = 520;
    int playerx = 500;
    int playery = 300;
    int targetx = 10;
    int targety = 10;
    int playerSize = 25;
    int playerSpeed = 5;
    int specialUses = 2;
    int specialPause;
    int done = 0;
    int toggleArray[] = new int[10];//0 timer start,1 - 7 button score toggles
    public JPanelC2() {
        setLayout(null);
        setBackground(Color.blue);
        delay = 1000; //milliseconds
        delay2 = 10;
        gameTimer = new Timer(delay, this);
        buttonTimer = new Timer(delay2, this);
        specialTimer = new Timer(delay,this);
        font = new Font("TimesRoman",20,50);
        whiteLine = BorderFactory.createLineBorder(Color.WHITE,3);
        setBackground(Color.BLUE);
        setBorder(whiteLine);
        setFocusable(true);
        addKeyListener(this);
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
        player.setBorder(whiteLine);
        player.setBackground(Color.BLUE);
        player.setFocusable(false);
        player.setBounds(playerx,playery,playerSize,playerSize);
        bouncer = new JButton();
        bouncer.setBounds(450,520,50,50);
        bouncer.setBorder(whiteLine);
        bouncer.setBackground(Color.orange);
        bouncer.setFocusable(false);
        bouncer.addActionListener(this);
        add(bouncer);
        target = new JButton();
        target.setBounds(targetx,targety,100,100);
        target.setBorder(whiteLine);
        target.setBackground(Color.BLUE);
        target.setFocusable(false);
        add(target);
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
        if(obj == specialTimer) {
            specialPause+=1; }
        if(obj == specialTimer && specialPause == 3) {
            specialTimer.stop();
            specialPause=0;
            buttonTimer.start();
            repaint(); }
        if(obj == Jtest) {
            time = 2; 
            gameTimer.start(); }
        if(obj == bouncer && toggleArray[0]==0) {
            toggleArray[0]=1;
            toggleArray[1]=1;
            special.setText(""+specialUses);
            gameTimer.start();
            buttonTimer.start(); }
        if(obj == special && toggleArray[0]==1) {
            if(specialUses>=1) {
                specialUses-=1;
                buttonTimer.stop();
                special.setText(""+specialUses);
                specialTimer.start(); } }
        if(obj == buttonTimer) {
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
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==0 && Y==570) {
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
            if(X==(playerx-50) && Y==(playery-50)) {
                x = -1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(playerx+playerSize) && Y==(playery-50)) {
                x = 1;
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(playerx+playerSize) && Y==(playery+playerSize)) {
                x = 1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(playerx-50) && Y==(playery+playerSize)) {
                x = -1;
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(Y==(playery-50) && X<(playerx+playerSize) && X>(playerx-50)) {
                y = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(Y==(playery+playerSize) && X<(playerx+playerSize) && X>(playerx-50)) {
                y = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(playerx-50) && Y<(playery+playerSize) && Y>(playery-50)) {
                x = -1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            if(X==(playerx+playerSize) && Y<(playery+playerSize) && Y>(playery-50)) {
                x = 1;
                X = X+x;
                Y = Y+y;
                bouncer.setBounds(X,Y,50,50); }
            //=============================================================================target bouncer triggers
            if(X<(targetx+100) && X>(targetx-50) && Y<(targety+100) && Y>(targety-50) && toggleArray[1]==1) {
                toggleArray[1]=0;
                score+=1;
                remove(target);
                targetx = 1050;
                targety = 220;
                toggleArray[2]=1;
                target.setBounds(targetx,targety,100,100);
                add(target);
                repaint(); }
            if(X<(targetx+100) && X>(targetx-50) && Y<(targety+100) && Y>(targety-50) && toggleArray[2]==1) {
                toggleArray[2]=0;
                score+=1;
                remove(target);
                targetx = 45;
                targety = 450;
                toggleArray[3]=1;
                target.setBounds(targetx,targety,100,100);
                add(target);
                repaint(); }
            if(X<(targetx+100) && X>(targetx-50) && Y<(targety+100) && Y>(targety-50) && toggleArray[3]==1) {
                toggleArray[3]=0;
                score+=1;
                remove(target);
                targetx = 300;
                targety = 278;
                toggleArray[4]=1;
                target.setBounds(targetx,targety,100,100);
                add(target);
                repaint(); }
            if(X<(targetx+100) && X>(targetx-50) && Y<(targety+100) && Y>(targety-50) && toggleArray[4]==1) {
                toggleArray[4]=0;
                score+=1;
                remove(target);
                targetx = 821;
                targety = 357;
                toggleArray[5]=1;
                target.setBounds(targetx,targety,100,100);
                add(target);
                repaint(); }
            if(X<(targetx+100) && X>(targetx-50) && Y<(targety+100) && Y>(targety-50) && toggleArray[5]==1) {
                toggleArray[5]=0;
                score+=1;
                remove(target);
                targetx = 10;
                targety = 10;
                toggleArray[6]=1;
                target.setBounds(targetx,targety,100,100);
                add(target);
                repaint(); }
            if(X<(targetx+100) && X>(targetx-50) && Y<(targety+100) && Y>(targety-50) && toggleArray[6]==1) {
                toggleArray[7]=0;
                score+=1;
                remove(target);
                targetx = 640;
                targety = 350;
                toggleArray[1]=1;
                target.setBounds(targetx,targety,100,100);
                add(target);
                repaint(); }
            if(X<(targetx+100) && X>(targetx-50) && Y<(targety+100) && Y>(targety-50) && toggleArray[7]==1) {
                toggleArray[1]=0;
                score+=1;
                remove(target);
                targetx = 128;
                targety = 356;
                toggleArray[1]=1;
                target.setBounds(targetx,targety,100,100);
                add(target);
                repaint(); }
    }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) { }

    @Override
    public void keyPressed(KeyEvent evt) { 
        int kk = evt.getKeyCode();
        if(kk ==  evt.VK_LEFT) {
            playerx+=-playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); }
        if(kk ==  evt.VK_RIGHT) {
            playerx+=playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); } 
        if(kk ==  evt.VK_DOWN) {
            playery+=playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); }
        if(kk ==  evt.VK_UP) {
            playery+=-playerSpeed;
            player.setBounds(playerx,playery,playerSize,playerSize); }
    }

    @Override
    public void keyReleased(KeyEvent ke) { }
}
