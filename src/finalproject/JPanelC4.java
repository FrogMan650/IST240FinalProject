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

public class JPanelC4 extends JPanel  implements ActionListener, KeyListener {
    ImageIcon sourceImage1 = new ImageIcon("src/pictures/clouds.jpg");
    Image clouds = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    Border whiteLine;
    JButton special,help,help2,Jtest,player,playerNot,obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8;
    int score = 0;
    int time = 60;
    Font font;
    Timer gameTimer,buttonTimer,specialTimer;
    int playerSize = 40;
    int playerSpeed = 5;
    int playerx = 600;
    int playery = 575;
    int delay,delay2;
    int done = 0;
    int randomNumber;
    int specialUses = 2;
    int specialPause;
    int toggleArray[] = new int[50];//0 game start,1 special toggle
    int arrayX[] = new int[50];
    int arrayY[] = new int[50];
    public JPanelC4() {
        setLayout(null);
        setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);
        delay = 1000; //milliseconds
        delay2 = 10;
        gameTimer = new Timer(delay, this);
        buttonTimer = new Timer(delay2, this);
        specialTimer = new Timer(delay,this);
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
        player = new JButton();
        player.setBounds(playerx,playery,playerSize,playerSize);
        player.setFocusable(false);
        player.addActionListener(this);
        add(player);
        playerNot = new JButton();
        playerNot.setBounds(playerx,playery,playerSize,playerSize);
        playerNot.setFocusable(false);
        playerNot.setEnabled(false);
        obj1 = new JButton();
        obj1.setBounds(arrayX[0],arrayY[0],300,100);
        obj1.setFocusable(false);
        obj2 = new JButton();
        obj2.setBounds(arrayX[1],arrayY[1],100,300);
        obj2.setFocusable(false);
        obj3 = new JButton();
        obj3.setBounds(arrayX[2],arrayY[2],100,100);
        obj3.setFocusable(false);
        obj4 = new JButton();
        obj4.setBounds(arrayX[3],arrayY[3],200,50);
        obj4.setFocusable(false);
        obj5 = new JButton();
        obj5.setBounds(arrayX[4],arrayY[4],100,200);
        obj5.setFocusable(false);
        obj6 = new JButton();
        obj6.setBounds(arrayX[5],arrayY[5],100,250);
        obj6.setFocusable(false);
        obj7 = new JButton();
        obj7.setBounds(arrayX[6],arrayY[6],300,300);
        obj7.setFocusable(false);
        obj8 = new JButton();
        obj8.setBounds(arrayX[7],arrayY[7],400,50);
        obj8.setFocusable(false);
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
        if(obj == special && toggleArray[0]==1) {
            if(specialUses>=1) {
                toggleArray[1]=1;
                remove(player);
                add(playerNot);
                specialUses-=1;
                specialTimer.start(); } }
        if(obj == specialTimer) {
            specialPause+=1; }
        if(obj == specialTimer && specialPause == 3) {
            toggleArray[1]=0;
            specialTimer.stop();
            specialPause=0;
            remove(playerNot);
            add(player); }
        if(obj == player && toggleArray[0]==0) {
            gameTimer.start(); 
            buttonTimer.start();
            toggleArray[0]=1;
            arrayX[0]=randomNum();
            arrayX[1]=randomNum();
            arrayX[2]=randomNum();
            arrayX[3]=randomNum();
            arrayX[4]=randomNum();
            arrayX[5]=randomNum();
            arrayX[6]=randomNum();
            arrayX[7]=randomNum();
            arrayY[0]=-110;
            arrayY[1]=-360;
            arrayY[2]=-210;
            arrayY[3]=-210;
            arrayY[4]=-410;
            arrayY[5]=-660;
            arrayY[6]=-610;
            arrayY[7]=-410;
            add(obj1);
            add(obj2);
            add(obj3);
            add(obj4);
            add(obj5);
            add(obj6);
            add(obj7);
            add(obj8);
        }
        if(obj == buttonTimer) {
            special.setText(""+specialUses);
            arrayY[0]+=1;
            arrayY[1]+=1;
            arrayY[2]+=1;
            arrayY[3]+=1;
            arrayY[4]+=1;
            arrayY[5]+=1;
            arrayY[6]+=1;
            arrayY[7]+=1;
            obj1.setBounds(arrayX[0],arrayY[0],300,100);
            obj2.setBounds(arrayX[1],arrayY[1],100,300);
            obj3.setBounds(arrayX[2],arrayY[2],100,100);
            obj4.setBounds(arrayX[3],arrayY[3],200,50);
            obj5.setBounds(arrayX[4],arrayY[4],100,200);
            obj6.setBounds(arrayX[5],arrayY[5],150,400);
            obj7.setBounds(arrayX[6],arrayY[6],300,300);
            obj8.setBounds(arrayX[7],arrayY[7],400,50);
            if(arrayY[0]+100==620) {
                arrayY[0]=-110;
                arrayX[0]=randomNum(); }
            if(arrayY[1]+300==620) {
                arrayY[1]=-310;
                arrayX[1]=randomNum(); }
            if(arrayY[2]+100==620) {
                arrayY[2]=-110;
                arrayX[2]=randomNum(); }
            if(arrayY[3]+50==620) {
                arrayY[3]=-60;
                arrayX[3]=randomNum(); }
            if(arrayY[4]+200==620) {
                arrayY[4]=-210;
                arrayX[4]=randomNum(); }
            if(arrayY[5]+400==620) {
                arrayY[5]=-410;
                arrayX[5]=randomNum(); }
            if(arrayY[6]+300==620) {
                arrayY[6]=-310;
                arrayX[6]=randomNum(); }
            if(arrayY[7]+50==620) {
                arrayY[7]=-60;
                arrayX[7]=randomNum(); }
            if(playerx>=arrayX[0]-playerSize && playerx<=arrayX[0]+300 && playery>=arrayY[0] && playery<=arrayY[0]+100 && toggleArray[1]==0) {
                arrayY[0]=-110;
                arrayX[0]=randomNum();
                score+=-1; }
            if(playerx>=arrayX[1]-playerSize && playerx<=arrayX[1]+100 && playery>=arrayY[1] && playery<=arrayY[1]+300 && toggleArray[1]==0) {
                arrayY[1]=-310;
                arrayX[1]=randomNum();
                score+=-1; }
            if(playerx>=arrayX[2]-playerSize && playerx<=arrayX[2]+100 && playery>=arrayY[2] && playery<=arrayY[2]+100 && toggleArray[1]==0) {
                arrayY[2]=-110;
                arrayX[2]=randomNum();
                score+=-1; }
            if(playerx>=arrayX[3]-playerSize && playerx<=arrayX[3]+200 && playery>=arrayY[3] && playery<=arrayY[3]+50 && toggleArray[1]==0) {
                arrayY[3]=-60;
                arrayX[3]=randomNum();
                score+=-1; }
            if(playerx>=arrayX[4]-playerSize && playerx<=arrayX[4]+100 && playery>=arrayY[4] && playery<=arrayY[4]+200 && toggleArray[1]==0) {
                arrayY[4]=-210;
                arrayX[4]=randomNum();
                score+=-1; }
            if(playerx>=arrayX[5]-playerSize && playerx<=arrayX[5]+150 && playery>=arrayY[5] && playery<=arrayY[5]+400 && toggleArray[1]==0) {
                arrayY[5]=-410;
                arrayX[5]=randomNum();
                score+=-1; }
            if(playerx>=arrayX[6]-playerSize && playerx<=arrayX[6]+300 && playery>=arrayY[6] && playery<=arrayY[6]+300 && toggleArray[1]==0) {
                arrayY[6]=-310;
                arrayX[6]=randomNum();
                score+=-1; }
            if(playerx>=arrayX[7]-playerSize && playerx<=arrayX[7]+400 && playery>=arrayY[7] && playery<=arrayY[7]+50 && toggleArray[1]==0) {
                arrayY[7]=-60;
                arrayX[7]=randomNum();
                score+=-1; }
        }
    }
    @Override
    public void keyTyped(KeyEvent ke) { }

    @Override
    public void keyPressed(KeyEvent evt) { 
        int kk = evt.getKeyCode();
        if(kk ==  evt.VK_LEFT && playerx <=0 && toggleArray[0]==1) {
            playerNot.setBounds(0,playery,playerSize,playerSize);
            player.setBounds(0,playery,playerSize,playerSize); }
        else if(kk ==  evt.VK_RIGHT && playerx >=1280-playerSize && toggleArray[0]==1) {
            playerNot.setBounds(1280-playerSize,playery,playerSize,playerSize);
            player.setBounds(1280-playerSize,playery,playerSize,playerSize); } 
        else if(kk ==  evt.VK_LEFT && toggleArray[0]==1) {
            playerx+=-playerSpeed;
            playerNot.setBounds(playerx,playery,playerSize,playerSize);
            player.setBounds(playerx,playery,playerSize,playerSize); }
        else if(kk ==  evt.VK_RIGHT && toggleArray[0]==1) {
            playerx+=playerSpeed;
            playerNot.setBounds(playerx,playery,playerSize,playerSize);
            player.setBounds(playerx,playery,playerSize,playerSize); } 
    }

    @Override
    public void keyReleased(KeyEvent ke) { }
    
    int randomNum() {
        double r = Math.random();
        randomNumber = (int)(r*1280);
        return(randomNumber); }
}
