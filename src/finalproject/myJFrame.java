package finalproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.border.Border;

public class myJFrame extends JFrame implements ActionListener {
    	mapJPanel mjpMap;
        JPanelC1 mjpC1;
        JPanelC2 mjpC2;
        JPanelC3 mjpC3;
        JPanelC4 mjpC4;
        JPanelC5 mjpC5;
        JPanelWC mjpWC;
        JPanelSB mjpSB;
        JPanelCS mjpCS;
        JPanelSP mjpSP;
        JPanelD mjpD;
        JPanelI mjpI;
        JPanelT mjpT;
        XMLEncoder xe;
        Timer gameTimer,checkTimer;
        Border whiteLine,blackLine,pinkLine;
        int delay,delay2,totalTime,totalScore;
        int toggleArray[] = new int[50]; //0-5 map button toggles,6-11 mjpSP currentTime & currentScore updaters, 12-17 game close toggles,18 Game end
	public myJFrame () {
		super ("PENN STATE CAMPUS GAME");
                setLayout(null);
                whiteLine = BorderFactory.createLineBorder(Color.WHITE,3);
                blackLine = BorderFactory.createLineBorder(Color.BLACK,3);
                pinkLine = BorderFactory.createLineBorder(Color.MAGENTA,3);
                totalTime = 0;
                totalScore = 0;
                mjpMap = new mapJPanel();
                mjpMap.setBounds(0,0,1280,720);
                mjpC1 = new JPanelC1();
                mjpC1.setBounds(0,0,1280,720);
                mjpC2 = new JPanelC2();
                mjpC2.setBounds(0,0,1280,720);
                mjpC3 = new JPanelC3();
                mjpC3.setBounds(0,0,1280,720);
                mjpC4 = new JPanelC4();
                mjpC4.setBounds(0,0,1280,720);
                mjpC5 = new JPanelC5();
                mjpC5.setBounds(0,0,1280,720);
                mjpWC = new JPanelWC();
                mjpWC.setBounds(0,0,1280,720);
                mjpSB = new JPanelSB();
                mjpSB.setBounds(0,0,1280,720);
                mjpCS = new JPanelCS();
                mjpCS.setBounds(0,0,1280,720);
                mjpT = new JPanelT();
                mjpT.setBounds(0,0,1280,720);
                mjpSP = new JPanelSP();
                mjpSP.setFocusable(false);
                mjpSP.setBounds(100,620,1080,100);
                mjpD = new JPanelD();
                mjpD.setBounds(0,0,1280,720);
                mjpI = new JPanelI();
                mjpI.setFocusable(false);
                mjpI.setBounds(465,200,800,400);
		getContentPane().setLayout(null);
		getContentPane().add(mjpD);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (1295, 758);
		setVisible(true);
                delay = 1000; //milliseconds
                delay2 = 10; //milliseconds
  		gameTimer = new Timer(delay, this);
                checkTimer = new Timer(delay2, this);
                //========================================================listeners
                mjpCS.Char1.addActionListener(this);
                mjpCS.Char2.addActionListener(this);
                mjpCS.Char3.addActionListener(this);
                mjpT.Char1.addActionListener(this);
                mjpT.Char2.addActionListener(this);
                mjpT.Char3.addActionListener(this);
                mjpD.go.addActionListener(this);
                mjpC1.special.addActionListener(this);
                mjpC2.special.addActionListener(this);
                mjpC3.special.addActionListener(this);
                mjpC4.special.addActionListener(this);
                mjpC5.special.addActionListener(this);
                mjpWC.special.addActionListener(this);
                mjpC1.help.addActionListener(this);
                mjpC1.help2.addActionListener(this);
                mjpC2.help.addActionListener(this);
                mjpC2.help2.addActionListener(this);
                mjpC3.help.addActionListener(this);
                mjpC3.help2.addActionListener(this);
                mjpC4.help.addActionListener(this);
                mjpC4.help2.addActionListener(this);
                mjpC5.help.addActionListener(this);
                mjpC5.help2.addActionListener(this);
                mjpWC.help.addActionListener(this);
                mjpWC.help2.addActionListener(this);
                //========================================================
                checkTimer.start();
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        //========================================================mjpC1 buttons
        if(obj == mjpC1.help) {
             mjpI.info.setText("<html>In this game you bounce the button around the screen and try to hit the blocks in the middle as many times as you can.  If the button hits the bottom of the screen you lose one point.  "
                     + "Move your character left and right with the arrow keys.  Here, the special button reverses the movement of the button (two uses).  "
                     + "When you're ready to start, move the button where you'd like to start and click on the orange button.  The button will start moving up and right."
                     + "You'll have one minute to get as many points as possible.");
             mjpI.charInfo.setText("<html>Character 1 can move their character twice as fast.<br>Character 2 is bigger, making it easier to hit the box.<br>Character 3 gets 5 uses of the special.");
             getContentPane().add(mjpI);
             mjpC1.remove(mjpC1.help);
             mjpC1.add(mjpC1.help2);
             validate();
             repaint(); }
        if(obj == mjpC1.help2) {
             getContentPane().remove(mjpI);
             mjpC1.remove(mjpC1.help2);
             mjpC1.add(mjpC1.help);
             validate();
             repaint(); }
        //========================================================mjpC2 buttons
        if(obj == mjpC2.help) {
             mjpI.info.setText("<html>In this game your goal is to hit the orange button into the others that appear around the screen.  Move your character with the arrow keys.  "
                     + "Here, the special button will pause the movement of the button for 2 seconds (two uses).  When you're ready to start, move your character where you'd like to start and click on the orange button.  The button will start moving up and right.  "
                     + "You get one point for each block you hit and you'll have one minute to get as many points as you can.");
             mjpI.charInfo.setText("<html>Character 1 can move around faster.<br>Character 2 is a bit bigger, making it easier to hit the box.<br>Character 3 gets 5 uses of the special.");
             getContentPane().add(mjpI);
             mjpC2.remove(mjpC2.help);
             mjpC2.add(mjpC2.help2);
             validate();
             repaint(); }
        if(obj == mjpC2.help2) {
             getContentPane().remove(mjpI);
             mjpC2.remove(mjpC2.help2);
             mjpC2.add(mjpC2.help);
             validate();
             repaint(); }
        //========================================================mjpC3 buttons
        if(obj == mjpC3.help) {
             mjpI.info.setText("<html>In this game the goal is to get to the right side of the screen without hitting any of the boxes.  If you do hit them you get put back right before that column of boxes.  Use the arrow keys to move your character."
                     + "  Each time you can get to the right side you get one point.  Here, your special lets you slow down the boxes for five seconds, making it easier to pass them (two uses).  When you're ready, click your character to start.");
             mjpI.charInfo.setText("<html>Character 1 can move faster.<br>Character 2 is a bit smaller.<br>Character 3 can use the special 5 times.");
             getContentPane().add(mjpI);
             mjpC3.remove(mjpC3.help);
             mjpC3.add(mjpC3.help2);
             validate();
             repaint(); }
        if(obj == mjpC3.help2) {
             getContentPane().remove(mjpI);
             mjpC3.remove(mjpC3.help2);
             mjpC3.add(mjpC3.help);
             validate();
             repaint(); }
        //========================================================mjpC4 buttons
        if(obj == mjpC4.help) {
             mjpI.info.setText("<html>In this game you need to dodge the objects falling from the top of the screen.  Move your character left and right with the arrow keys.  There is no way to gain points, but if you can make it to the end without getting hit you'll"
                     + " get ten points.  Each time you get hit, you lose one point.  Here, the special makes you invincible for 5 seconds (two uses).  When you're ready to start click on your character.");
             mjpI.charInfo.setText("<html>Character 1 gets to move faster.<br>Character 2 is smaller.<br>Character 3 can use the special 5 times.");
             getContentPane().add(mjpI);
             mjpC4.remove(mjpC4.help);
             mjpC4.add(mjpC4.help2);
             validate();
             repaint(); }
        if(obj == mjpC4.help2) {
             getContentPane().remove(mjpI);
             mjpC4.remove(mjpC4.help2);
             mjpC4.add(mjpC4.help);
             validate();
             repaint(); }
        //========================================================mjpC5 buttons
        if(obj == mjpC5.help) {
             mjpI.info.setText("<html>In this game your goal is to get to the end portal.  Each portal will take you to a new room with new portals.  Each portal will be linked with one other, and they will have the same color.  To move between rooms"
                     + " click on the portal you would like to take.  Here, your special will @@@@@@.  When you're ready to start click on any of the visible portals.");
             mjpI.charInfo.setText("<html>Character 1 can move so quickly they get more time to finish.<br>Character 2 is so big they can see the end portal room from the start.<br>Character 3 can use the special @ times.");
             getContentPane().add(mjpI);
             mjpC5.remove(mjpC5.help);
             mjpC5.add(mjpC5.help2);
             validate();
             repaint(); }
        if(obj == mjpC5.help2) {
             getContentPane().remove(mjpI);
             mjpC5.remove(mjpC5.help2);
             mjpC5.add(mjpC5.help);
             validate();
             repaint(); }
        //========================================================mjpWC buttons
        if(obj == mjpWC.help) {
             mjpI.info.setText("<html>In this game your goal is to click as many boxes as possible.  Boxes will appear randomly around the screen and you'll get one point per box clicked.  Here, your special pauses the game timer for 5 seconds allowing you to click "
                     + "more boxes (one use).");
             mjpI.charInfo.setText("<html>Character 1 moves so quickly they get more time to play the game.<br>Character 2 makes themselves smaller, so the boxes appear to be bigger.<br>Character 3 can use the special 3 times.");
             getContentPane().add(mjpI);
             mjpWC.remove(mjpWC.help);
             mjpWC.add(mjpWC.help2);
             validate();
             repaint(); }
        if(obj == mjpWC.help2) {
             getContentPane().remove(mjpI);
             mjpWC.remove(mjpWC.help2);
             mjpWC.add(mjpWC.help);
             validate();
             repaint(); }
        //====================================================================================================================================mjpMap panel triggers
            if(mjpMap.playerx>=510 && mjpMap.playerx<=600 && mjpMap.playery>=320 && mjpMap.playery<=390 && toggleArray[0]==0) {//UP
                toggleArray[0]=1;
                toggleArray[6]=1;
                mjpMap.up.setEnabled(false);
                mjpC1.done=1;
                //mjpSP.currentScore.setText("Score: "+mjpC1.score);
                //mjpSP.currentTime.setText("Time: "+mjpC1.time);
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC1);
                mjpC1.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpMap.playerx>=0 && mjpMap.playerx<=90 && mjpMap.playery>=10 && mjpMap.playery<=80 && toggleArray[1]==0) {//erie
                toggleArray[1]=1;
                toggleArray[7]=1;
                mjpMap.erie.setEnabled(false);
                mjpC2.done=1;
                //mjpSP.currentScore.setText("Score: "+mjpC2.score);
                //mjpSP.currentTime.setText("Time: "+mjpC2.time);
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpC2);
                getContentPane().add(mjpSP);
                mjpC2.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpMap.playerx>=650 && mjpMap.playerx<=740 && mjpMap.playery>=570 && mjpMap.playery<=640 && toggleArray[2]==0) {//york
                toggleArray[2]=1;
                toggleArray[8]=1;
                mjpMap.york.setEnabled(false);
                mjpC3.done=1;
                //mjpSP.currentScore.setText("Score: "+mjpC3.score);
                //mjpSP.currentTime.setText("Time: "+mjpC4.time);
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC3);
                mjpC3.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpMap.playerx>=900 && mjpMap.playerx<=990 && mjpMap.playery>=170 && mjpMap.playery<=240 && toggleArray[3]==0) {//scranton
                toggleArray[3]=1;
                toggleArray[9]=1;
                mjpMap.scranton.setEnabled(false);
                mjpC4.done=1;
                //mjpSP.currentScore.setText("Score: "+mjpC4.score);
                //mjpSP.currentTime.setText("Time: "+mjpC4.time);
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC4);
                mjpC4.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpMap.playerx>=300 && mjpMap.playerx<=390 && mjpMap.playery>=420 && mjpMap.playery<=490 && toggleArray[4]==0) {//altoona
                toggleArray[4]=1;
                toggleArray[10]=1;
                mjpMap.altoona.setEnabled(false);
                mjpC5.done=1;
                //mjpSP.currentScore.setText("Score: "+mjpC5.score);
                //mjpSP.currentTime.setText("Time: "+mjpC5.time);
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC5);
                mjpC5.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpMap.playerx>=480 && mjpMap.playerx<=710 && mjpMap.playery>=-20 && mjpMap.playery<=50 && toggleArray[5]==0) {//wc
                toggleArray[5]=1;
                toggleArray[11]=1;
                mjpMap.wc.setEnabled(false);
                mjpWC.done=1;
                //mjpSP.currentScore.setText("Score: "+mjpWC.score);
                //mjpSP.currentTime.setText("Time: "+mjpWC.time);
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpWC);
                mjpWC.requestFocusInWindow();
                validate();
                repaint(); }
            //====================================================================================================================================
        if(obj == gameTimer) {
            totalTime+=1; }
        //========================================mjpCS character variable changers
        if(obj == mjpCS.Char1) {//SPEED
            mjpC1.playerx = 150;
            mjpC1.playerx2 = 20;
            mjpC1.specialUses = 2;
            mjpC1.player.setBounds(400,580,mjpC1.playerx,20);
            mjpC1.add(mjpC1.player);
            mjpC2.playerSpeed = 10;
            mjpC2.add(mjpC2.player);
            mjpC3.playerSpeed = 10;
            mjpC4.playerSpeed = 10;
            mjpWC.time = 70;
            getContentPane().remove(mjpCS);
            getContentPane().add(mjpT);
            validate();
            repaint(); }
        if(obj == mjpCS.Char2) {//TRANSFORMATION
            mjpC1.playerx = 300;
            mjpC1.playerx2 = 10;
            mjpC1.specialUses = 2;
            mjpC1.player.setBounds(400,580,mjpC1.playerx,20);
            mjpC1.add(mjpC1.player);
            mjpC2.playerSize = 50;
            mjpC2.add(mjpC2.player);
            mjpC3.playerSize = 10;
            mjpC4.playerSize = 20;
            mjpWC.playerSize = 150;
            getContentPane().remove(mjpCS);
            getContentPane().add(mjpT);
            validate();
            repaint(); }
        if(obj == mjpCS.Char3) {//SKILLED
            mjpC1.playerx = 150;
            mjpC1.playerx2 = 10;
            mjpC1.specialUses = 5;
            mjpC1.player.setBounds(400,580,mjpC1.playerx,20);
            mjpC1.add(mjpC1.player);
            mjpC2.specialUses = 5;
            mjpC2.add(mjpC2.player);
            mjpC3.specialUses = 3;
            mjpC4.specialUses = 4;
            mjpWC.specialUses = 3;
            getContentPane().remove(mjpCS);
            getContentPane().add(mjpT);
            validate();
            repaint(); }
        //========================================mjpT theme variable changers
        if(obj == mjpT.Char1) {//BLUE/WHITE
            gameTimer.start();
            mjpC1.player.setBackground(Color.BLUE);
            mjpC1.player.setBorder(whiteLine);
            mjpC1.block1.setBackground(Color.BLUE);
            mjpC1.block1.setBorder(whiteLine);
            mjpC1.block2.setBackground(Color.BLUE);
            mjpC1.block2.setBorder(whiteLine);
            mjpC2.player.setBackground(Color.BLUE);
            mjpC2.player.setBorder(whiteLine);
            mjpC2.target.setBackground(Color.BLUE);
            mjpC2.target.setBorder(whiteLine);
            mjpC3.player.setBackground(Color.BLUE);
            mjpC3.player.setBorder(whiteLine);
            mjpC3.m1.setBackground(Color.BLUE);
            mjpC3.m1.setBorder(whiteLine);
            mjpC3.m2.setBackground(Color.BLUE);
            mjpC3.m2.setBorder(whiteLine);
            mjpC3.m21.setBackground(Color.BLUE);
            mjpC3.m21.setBorder(whiteLine);
            mjpC3.m3.setBackground(Color.BLUE);
            mjpC3.m3.setBorder(whiteLine);
            mjpC3.m31.setBackground(Color.BLUE);
            mjpC3.m31.setBorder(whiteLine);
            mjpC3.m32.setBackground(Color.BLUE);
            mjpC3.m32.setBorder(whiteLine);
            mjpC3.m4.setBackground(Color.BLUE);
            mjpC3.m4.setBorder(whiteLine);
            mjpC3.m41.setBackground(Color.BLUE);
            mjpC3.m41.setBorder(whiteLine);
            mjpC3.m42.setBackground(Color.BLUE);
            mjpC3.m42.setBorder(whiteLine);
            mjpC3.m43.setBackground(Color.BLUE);
            mjpC3.m43.setBorder(whiteLine);
            mjpC4.player.setBackground(Color.BLUE);
            mjpC4.player.setBorder(whiteLine);
            mjpC4.obj1.setBackground(Color.BLUE);
            mjpC4.obj1.setBorder(whiteLine);
            mjpC4.obj2.setBackground(Color.BLUE);
            mjpC4.obj2.setBorder(whiteLine);
            mjpC4.obj3.setBackground(Color.BLUE);
            mjpC4.obj3.setBorder(whiteLine);
            mjpC4.obj4.setBackground(Color.BLUE);
            mjpC4.obj4.setBorder(whiteLine);
            mjpC4.obj5.setBackground(Color.BLUE);
            mjpC4.obj5.setBorder(whiteLine);
            mjpC4.obj6.setBackground(Color.BLUE);
            mjpC4.obj6.setBorder(whiteLine);
            mjpC4.obj7.setBackground(Color.BLUE);
            mjpC4.obj7.setBorder(whiteLine);
            mjpC4.obj8.setBackground(Color.BLUE);
            mjpC4.obj8.setBorder(whiteLine);
            mjpWC.box.setBackground(Color.BLUE);
            mjpWC.box.setBorder(whiteLine);
            getContentPane().remove(mjpT);
            getContentPane().add(mjpMap);
            validate();
            repaint();
            mjpMap.requestFocusInWindow(); }
        if(obj == mjpT.Char2) {//GREEN/PINK
            gameTimer.start();
            mjpC1.player.setBackground(Color.green);
            mjpC1.player.setBorder(pinkLine);
            mjpC1.block1.setBackground(Color.green);
            mjpC1.block1.setBorder(pinkLine);
            mjpC1.block2.setBackground(Color.green);
            mjpC1.block2.setBorder(pinkLine);
            mjpC2.player.setBackground(Color.green);
            mjpC2.player.setBorder(pinkLine);
            mjpC2.target.setBackground(Color.green);
            mjpC2.target.setBorder(pinkLine);
            mjpC3.player.setBackground(Color.green);
            mjpC3.player.setBorder(pinkLine);
            mjpC3.m1.setBackground(Color.green);
            mjpC3.m1.setBorder(pinkLine);
            mjpC3.m2.setBackground(Color.green);
            mjpC3.m2.setBorder(pinkLine);
            mjpC3.m21.setBackground(Color.green);
            mjpC3.m21.setBorder(pinkLine);
            mjpC3.m3.setBackground(Color.green);
            mjpC3.m3.setBorder(pinkLine);
            mjpC3.m31.setBackground(Color.green);
            mjpC3.m31.setBorder(pinkLine);
            mjpC3.m32.setBackground(Color.green);
            mjpC3.m32.setBorder(pinkLine);
            mjpC3.m4.setBackground(Color.green);
            mjpC3.m4.setBorder(pinkLine);
            mjpC3.m41.setBackground(Color.green);
            mjpC3.m41.setBorder(pinkLine);
            mjpC3.m42.setBackground(Color.green);
            mjpC3.m42.setBorder(pinkLine);
            mjpC3.m43.setBackground(Color.green);
            mjpC3.m43.setBorder(pinkLine);
            mjpC4.player.setBackground(Color.green);
            mjpC4.player.setBorder(pinkLine);
            mjpC4.obj1.setBackground(Color.green);
            mjpC4.obj1.setBorder(pinkLine);
            mjpC4.obj2.setBackground(Color.green);
            mjpC4.obj2.setBorder(pinkLine);
            mjpC4.obj3.setBackground(Color.green);
            mjpC4.obj3.setBorder(pinkLine);
            mjpC4.obj4.setBackground(Color.green);
            mjpC4.obj4.setBorder(pinkLine);
            mjpC4.obj5.setBackground(Color.green);
            mjpC4.obj5.setBorder(pinkLine);
            mjpC4.obj6.setBackground(Color.green);
            mjpC4.obj6.setBorder(pinkLine);
            mjpC4.obj7.setBackground(Color.green);
            mjpC4.obj7.setBorder(pinkLine);
            mjpC4.obj8.setBackground(Color.green);
            mjpC4.obj8.setBorder(pinkLine);
            mjpWC.box.setBackground(Color.green);
            mjpWC.box.setBorder(pinkLine);
            getContentPane().remove(mjpT);
            getContentPane().add(mjpMap);
            validate();
            repaint();
            mjpMap.requestFocusInWindow(); }
        if(obj == mjpT.Char3) {//WHITE/BLACK
            gameTimer.start();
            mjpC1.player.setBackground(Color.WHITE);
            mjpC1.player.setBorder(blackLine);
            mjpC1.block1.setBackground(Color.WHITE);
            mjpC1.block1.setBorder(blackLine);
            mjpC1.block2.setBackground(Color.WHITE);
            mjpC1.block2.setBorder(blackLine);
            mjpC2.player.setBackground(Color.WHITE);
            mjpC2.player.setBorder(blackLine);
            mjpC2.target.setBackground(Color.WHITE);
            mjpC2.target.setBorder(blackLine);
            mjpC3.player.setBackground(Color.WHITE);
            mjpC3.player.setBorder(blackLine);
            mjpC3.m1.setBackground(Color.WHITE);
            mjpC3.m1.setBorder(blackLine);
            mjpC3.m2.setBackground(Color.WHITE);
            mjpC3.m2.setBorder(blackLine);
            mjpC3.m21.setBackground(Color.WHITE);
            mjpC3.m21.setBorder(blackLine);
            mjpC3.m3.setBackground(Color.WHITE);
            mjpC3.m3.setBorder(blackLine);
            mjpC3.m31.setBackground(Color.WHITE);
            mjpC3.m31.setBorder(blackLine);
            mjpC3.m32.setBackground(Color.WHITE);
            mjpC3.m32.setBorder(blackLine);
            mjpC3.m4.setBackground(Color.WHITE);
            mjpC3.m4.setBorder(blackLine);
            mjpC3.m41.setBackground(Color.WHITE);
            mjpC3.m41.setBorder(blackLine);
            mjpC3.m42.setBackground(Color.WHITE);
            mjpC3.m42.setBorder(blackLine);
            mjpC3.m43.setBackground(Color.WHITE);
            mjpC3.m43.setBorder(blackLine);
            mjpC4.player.setBackground(Color.WHITE);
            mjpC4.player.setBorder(blackLine);
            mjpC4.obj1.setBackground(Color.WHITE);
            mjpC4.obj1.setBorder(blackLine);
            mjpC4.obj2.setBackground(Color.WHITE);
            mjpC4.obj2.setBorder(blackLine);
            mjpC4.obj3.setBackground(Color.WHITE);
            mjpC4.obj3.setBorder(blackLine);
            mjpC4.obj4.setBackground(Color.WHITE);
            mjpC4.obj4.setBorder(blackLine);
            mjpC4.obj5.setBackground(Color.WHITE);
            mjpC4.obj5.setBorder(blackLine);
            mjpC4.obj6.setBackground(Color.WHITE);
            mjpC4.obj6.setBorder(blackLine);
            mjpC4.obj7.setBackground(Color.WHITE);
            mjpC4.obj7.setBorder(blackLine);
            mjpC4.obj8.setBackground(Color.WHITE);
            mjpC4.obj8.setBorder(blackLine);
            mjpWC.box.setBackground(Color.WHITE);
            mjpWC.box.setBorder(blackLine);
            getContentPane().remove(mjpT);
            getContentPane().add(mjpMap);
            validate();
            repaint();
            mjpMap.requestFocusInWindow(); }
        //========================================
        if(obj == mjpD.go) {
                getContentPane().remove(mjpD);
                getContentPane().add(mjpCS);
                validate();
                repaint(); }
        if(obj == checkTimer) {
            mjpSP.repaint();
            mjpI.repaint();
            mjpMap.TotalScore.setText("Score: "+totalScore);
            mjpMap.TotalTime.setText("Time: "+totalTime); 
            mjpSP.Totalscore.setText("Score: "+totalScore);
            mjpSP.Totaltime.setText("Time: "+totalTime);
            //================================================================mjpSP campus specific updaters
            if(toggleArray[6]==1 && mjpC1.done==1) {
                mjpSP.currentScore.setText("Score: "+mjpC1.score);
                mjpSP.currentTime.setText("Time: "+mjpC1.time); }
            if(toggleArray[7]==1 && mjpC2.done==1) {
                mjpSP.currentScore.setText("Score: "+mjpC2.score);
                mjpSP.currentTime.setText("Time: "+mjpC2.time); }
            if(toggleArray[8]==1 && mjpC3.done==1) {
                mjpSP.currentScore.setText("Score: "+mjpC3.score);
                mjpSP.currentTime.setText("Time: "+mjpC3.time); }
            if(toggleArray[9]==1 && mjpC4.done==1) {
                mjpSP.currentScore.setText("Score: "+mjpC4.score);
                mjpSP.currentTime.setText("Time: "+mjpC4.time); }
            if(toggleArray[10]==1 && mjpC5.done==1) {
                mjpSP.currentScore.setText("Score: "+mjpC5.score);
                mjpSP.currentTime.setText("Time: "+mjpC5.time); }
            if(toggleArray[11]==1 && mjpWC.done==1) {
                mjpSP.currentScore.setText("Score: "+mjpWC.score);
                mjpSP.currentTime.setText("Time: "+mjpWC.time); }
            //================================================================Campus game end triggers andf scores
            if(mjpC1.time==0 && toggleArray[12]==0) {
                toggleArray[12]=1;
                mjpC1.gameTimer.stop();
                mjpC1.buttonTimer.stop();
                totalScore+=mjpC1.score;
                mjpC1.done=2;
                getContentPane().remove(mjpC1);
                getContentPane().remove(mjpSP);
                getContentPane().remove(mjpI);
                getContentPane().add(mjpMap);
                mjpMap.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpC2.time==0 && toggleArray[13]==0) {
                toggleArray[13]=1;
                mjpC2.gameTimer.stop();
                totalScore+=mjpC2.score;
                mjpC2.done=2;
                getContentPane().remove(mjpC2);
                getContentPane().remove(mjpSP);
                getContentPane().remove(mjpI);
                getContentPane().add(mjpMap);
                mjpMap.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpC3.time==0 && toggleArray[14]==0) {
                toggleArray[14]=1;
                mjpC3.gameTimer.stop();
                totalScore+=mjpC3.score;
                mjpC3.done=2;
                getContentPane().remove(mjpC3);
                getContentPane().remove(mjpSP);
                getContentPane().remove(mjpI);
                getContentPane().add(mjpMap);
                mjpMap.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpC4.time==0 && toggleArray[15]==0) {
                toggleArray[15]=1;
                mjpC4.gameTimer.stop();
                totalScore+=mjpC4.score+10;
                mjpC4.done=2;
                getContentPane().remove(mjpC4);
                getContentPane().remove(mjpSP);
                getContentPane().remove(mjpI);
                getContentPane().add(mjpMap);
                mjpMap.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpC5.time==0 && toggleArray[16]==0) {
                toggleArray[16]=1;
                mjpC5.gameTimer.stop();
                totalScore+=mjpC5.score;
                mjpC5.done=2;
                getContentPane().remove(mjpC5);
                getContentPane().remove(mjpSP);
                getContentPane().remove(mjpI);
                getContentPane().add(mjpMap);
                mjpMap.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpWC.time==0 && toggleArray[17]==0) {
                toggleArray[17]=1;
                mjpWC.gameTimer.stop();
                totalScore+=mjpWC.score;
                mjpWC.done=2;
                getContentPane().remove(mjpWC);
                getContentPane().remove(mjpSP);
                getContentPane().remove(mjpI);
                getContentPane().add(mjpMap);
                mjpMap.requestFocusInWindow();
                validate();
                repaint(); }
            if(mjpC1.done+mjpC2.done+mjpC3.done+mjpC4.done+mjpC5.done+mjpWC.done == 10 && toggleArray[18]==0) {
                gameTimer.stop();
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSB);
            try {
                xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("info.xml"))); } 
            catch (Exception xx) {
                xx.printStackTrace(); }
            try {
                xe.writeObject(totalTime);
                xe.writeObject(totalScore); } 
            catch (Exception xx) {
                xx.printStackTrace(); }
            try {
                xe.close(); } 
            catch (Exception xx) {
                xx.printStackTrace(); }
                toggleArray[18]=1; }
        }
    }
    
}

