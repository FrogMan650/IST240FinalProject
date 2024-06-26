package finalproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
        int toggleArray[] = new int[20]; //0-5 map button toggles
                                         //6-11 mjpSP currentTime & currentScore updaters 
                                         //12-17 game close toggles
                                         //18 Game end
        //holds all the button to change the theme of
        JButton buttonThemeArray[] = new JButton[28];
        int overallBestTime;
        int overallBestScore;
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
                //==================================================listeners
                mjpCS.Char1.addActionListener(this);
                mjpCS.Char2.addActionListener(this);
                mjpCS.Char3.addActionListener(this);
                mjpT.Char1.addActionListener(this);
                mjpT.Char2.addActionListener(this);
                mjpT.Char3.addActionListener(this);
                mjpD.go.addActionListener(this);
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
                mjpMap.test.addActionListener(this);
                //========================================================
                checkTimer.start();
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        //========================================================mjpC1 buttons
        if(obj == mjpC1.help) {
             mjpI.info.setText("<html>Game instructions<br>"
                     + "Bounce the orange button around the screen and try to hit the blocks in the middle as many times as you can.<br>"
                     + "You get one point each time you hit a block and lose a point if the button hits the bottom of the screen.<br>"
                     + "Move your character left and right with the arrow keys.<br>  "
                     + "The special ability instantly reverses the movement of the button. (2 uses)<br>"
                     + "When you're ready to start, move the button where you'd like to start and click on the orange button.<br>"
                     + "The button will start moving up and right.<br>"
                     + "You'll have one minute to get as many points as possible.");
             mjpI.charInfo.setText("<html>Character 1 can move their character twice as fast.<br>"
                     + "Character 2 is bigger, making it easier to hit the box.<br>"
                     + "Character 3 gets 5 uses of the special ability.");
             getContentPane().add(mjpI);
             mjpC1.remove(mjpC1.help);
             mjpC1.add(mjpC1.help2);
             repaint(); }
        if(obj == mjpC1.help2) {
             getContentPane().remove(mjpI);
             mjpC1.remove(mjpC1.help2);
             mjpC1.add(mjpC1.help);
             repaint(); }
        //========================================================mjpC2 buttons
        if(obj == mjpC2.help) {
             mjpI.info.setText("<html>Game instructions<br>"
                     + "Hit the orange button into the others that appear around the screen.<br>"
                     + "You get one point for each block you hit with the orange button<br>"
                     + "Move your character with the arrow keys.<br>"
                     + "The special ability will pause the movement of the button for 2 seconds. (2 uses)<br>"
                     + "When you're ready to start, move your character where you'd like to start and click on the orange button.<br>"
                     + "The button will start moving up and right.<br>"
                     + "You'll have one minute to get as many points as you can.");
             mjpI.charInfo.setText("<html>Character 1 moves faster.<br>"
                     + "Character 2 is bigger, making it easier to hit the button.<br>"
                     + "Character 3 gets 5 uses of the special ability.");
             getContentPane().add(mjpI);
             mjpC2.remove(mjpC2.help);
             mjpC2.add(mjpC2.help2);
             repaint(); }
        if(obj == mjpC2.help2) {
             getContentPane().remove(mjpI);
             mjpC2.remove(mjpC2.help2);
             mjpC2.add(mjpC2.help);
             repaint(); }
        //========================================================mjpC3 buttons
        if(obj == mjpC3.help) {
             mjpI.info.setText("<html>Game instructions<br>"
                     + "Get to the right side of the screen without hitting any of the boxes.<br>"
                     + "If you do hit them you get put back right before that column of boxes.<br>"
                     + "Each time you can get to the right side you get one point.<br>"
                     + "Use the arrow keys to move your character.<br>"
                     + "The special ability lets you stop the boxes for five seconds. (two uses)<br>"
                     + "When you're ready, click your character to start.");
             mjpI.charInfo.setText("<html>Character 1 can move faster.<br>"
                     + "Character 2 is smaller.<br>"
                     + "Character 3 can use the special ability 5 times.");
             getContentPane().add(mjpI);
             mjpC3.remove(mjpC3.help);
             mjpC3.add(mjpC3.help2);
             repaint(); }
        if(obj == mjpC3.help2) {
             getContentPane().remove(mjpI);
             mjpC3.remove(mjpC3.help2);
             mjpC3.add(mjpC3.help);
             repaint(); }
        //========================================================mjpC4 buttons
        if(obj == mjpC4.help) {
             mjpI.info.setText("<html>Game instructions<br>"
                     + "Dodge the objects falling from the top of the screen.<br>"
                     + "Make it to the end without getting hit you'll get ten points, but each time you get hit, you lose one point.<br>"
                     + "Move your character left and right with the arrow keys.<br>"
                     + "The special ability makes you invincible for 5 seconds. (2 uses)<br>"
                     + "When you're ready to start click on your character.");
             mjpI.charInfo.setText("<html>Character 1 moves faster.<br>"
                     + "Character 2 is smaller.<br>"
                     + "Character 3 can use the special ability 5 times.");
             getContentPane().add(mjpI);
             mjpC4.remove(mjpC4.help);
             mjpC4.add(mjpC4.help2);
             repaint(); }
        if(obj == mjpC4.help2) {
             getContentPane().remove(mjpI);
             mjpC4.remove(mjpC4.help2);
             mjpC4.add(mjpC4.help);
             repaint(); }
        //========================================================mjpC5 buttons
        if(obj == mjpC5.help) {
             mjpI.info.setText("<html>Game instructions<br>"
                     + "Once the game starts you'll see 4 portals around your character.<br>"
                     + "Click one to take that portal to a different room, which will also have 4 portals.<br>"
                     + "Navigate this labyrinth of portals to find the end portal, which is colored the same as your character.<br>"
                     + "Clicking the end portal grants 10 points and ends the game.<br>"
                     + "The special ability will add 10 more seconds. (1 use)<br>"
                     + "When you're ready to start click on your character.");
             mjpI.charInfo.setText("<html>Character 1 gets 10 extra seconds to finish.<br>"
                     + "Character 2 can see the end portal from the start.<br>"
                     + "Character 3 can use the special ability 3 times.");
             getContentPane().add(mjpI);
             mjpC5.remove(mjpC5.help);
             mjpC5.add(mjpC5.help2);
             repaint(); }
        if(obj == mjpC5.help2) {
             getContentPane().remove(mjpI);
             mjpC5.remove(mjpC5.help2);
             mjpC5.add(mjpC5.help);
             repaint(); }
        //========================================================mjpWC buttons
        if(obj == mjpWC.help) {
             mjpI.info.setText("<html>Game instructions<br>"
                     + "Click as many boxes as possible.<br>"
                     + "Boxes will appear randomly around the screen and you'll get one point per box clicked.<br>"
                     + "The special ability adds 5 seconds allowing you to click more boxes.");
             mjpI.charInfo.setText("<html>Character 1 gets 5 extra seconds to play.<br>"
                     + "Character 2 the boxes are bigger.<br>"
                     + "Character 3 can use the special 3 times.");
             getContentPane().add(mjpI);
             mjpWC.remove(mjpWC.help);
             mjpWC.add(mjpWC.help2);
             repaint(); }
        if(obj == mjpWC.help2) {
             getContentPane().remove(mjpI);
             mjpWC.remove(mjpWC.help2);
             mjpWC.add(mjpWC.help);
             repaint(); }
        //====================================================================================================================================mjpMap panel triggers
            if(mjpMap.playerx>=510 && mjpMap.playerx<=600 && mjpMap.playery>=320 && mjpMap.playery<=390 && toggleArray[0]==0) {//UP
                toggleArray[0]=1;
                toggleArray[6]=1;
                mjpMap.up.setEnabled(false);
                mjpC1.done=1;
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC1);
                mjpC1.requestFocusInWindow();
                repaint(); }
            if(mjpMap.playerx>=0 && mjpMap.playerx<=90 && mjpMap.playery>=10 && mjpMap.playery<=80 && toggleArray[1]==0) {//erie
                toggleArray[1]=1;
                toggleArray[7]=1;
                mjpMap.erie.setEnabled(false);
                mjpC2.done=1;
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpC2);
                getContentPane().add(mjpSP);
                mjpC2.requestFocusInWindow();
                repaint(); }
            if(mjpMap.playerx>=650 && mjpMap.playerx<=740 && mjpMap.playery>=570 && mjpMap.playery<=640 && toggleArray[2]==0) {//york
                toggleArray[2]=1;
                toggleArray[8]=1;
                mjpMap.york.setEnabled(false);
                mjpC3.done=1;
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC3);
                mjpC3.requestFocusInWindow();
                repaint(); }
            if(mjpMap.playerx>=900 && mjpMap.playerx<=990 && mjpMap.playery>=170 && mjpMap.playery<=240 && toggleArray[3]==0) {//scranton
                toggleArray[3]=1;
                toggleArray[9]=1;
                mjpMap.scranton.setEnabled(false);
                mjpC4.done=1;
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC4);
                mjpC4.requestFocusInWindow();
                repaint(); }
            if(mjpMap.playerx>=300 && mjpMap.playerx<=390 && mjpMap.playery>=420 && mjpMap.playery<=490 && toggleArray[4]==0) {//altoona
                toggleArray[4]=1;
                toggleArray[10]=1;
                mjpMap.altoona.setEnabled(false);
                mjpC5.done=1;
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpC5);
                mjpC5.requestFocusInWindow();
                repaint(); }
            if(mjpMap.playerx>=480 && mjpMap.playerx<=710 && mjpMap.playery>=-20 && mjpMap.playery<=50 && toggleArray[5]==0) {//wc
                toggleArray[5]=1;
                toggleArray[11]=1;
                mjpMap.wc.setEnabled(false);
                mjpWC.done=1;
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSP);
                getContentPane().add(mjpWC);
                mjpWC.requestFocusInWindow();
                repaint(); }
            //==============================================================
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
            mjpC5.time = 70;
            mjpWC.time = 65;
            getContentPane().remove(mjpCS);
            getContentPane().add(mjpT);
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
            mjpC5.toggleArray[0] = 1;
            mjpWC.playerSize = 150;
            getContentPane().remove(mjpCS);
            getContentPane().add(mjpT);
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
            mjpC5.specialUses = 3;
            mjpWC.specialUses = 3;
            getContentPane().remove(mjpCS);
            getContentPane().add(mjpT);
            repaint(); }
        //========================================mjpT theme array set
        buttonThemeArray[0] = mjpC1.player;
        buttonThemeArray[1] = mjpC1.block1;
        buttonThemeArray[2] = mjpC1.block2;
        buttonThemeArray[3] = mjpC2.player;
        buttonThemeArray[4] = mjpC2.target;
        buttonThemeArray[5] = mjpC3.player;
        buttonThemeArray[6] = mjpC3.m1;
        buttonThemeArray[7] = mjpC3.m2;
        buttonThemeArray[8] = mjpC3.m21;
        buttonThemeArray[9] = mjpC3.m3;
        buttonThemeArray[10] = mjpC3.m31;
        buttonThemeArray[11] = mjpC3.m32;
        buttonThemeArray[12] = mjpC3.m4;
        buttonThemeArray[13] = mjpC3.m41;
        buttonThemeArray[14] = mjpC3.m42;
        buttonThemeArray[15] = mjpC3.m43;
        buttonThemeArray[16] = mjpC4.player;
        buttonThemeArray[17] = mjpC4.obj1;
        buttonThemeArray[18] = mjpC4.obj2;
        buttonThemeArray[19] = mjpC4.obj3;
        buttonThemeArray[20] = mjpC4.obj4;
        buttonThemeArray[21] = mjpC4.obj5;
        buttonThemeArray[22] = mjpC4.obj6;
        buttonThemeArray[23] = mjpC4.obj7;
        buttonThemeArray[24] = mjpC4.obj8;
        buttonThemeArray[25] = mjpC5.player;
        buttonThemeArray[26] = mjpC5.t32;
        buttonThemeArray[27] = mjpWC.box;
        //========================================mjpT theme variable changers
        if(obj == mjpT.Char1) {//BLUE/WHITE
            gameTimer.start();
            for(int i = 0;i < buttonThemeArray.length;i += 1) {
                buttonThemeArray[i].setBackground(Color.BLUE);
                buttonThemeArray[i].setBorder(whiteLine); }
            getContentPane().remove(mjpT);
            getContentPane().add(mjpMap);
            repaint();
            mjpMap.requestFocusInWindow(); }
        if(obj == mjpT.Char2) {//GREEN/PINK
            gameTimer.start();
            for(int i = 0;i < buttonThemeArray.length;i += 1) {
                buttonThemeArray[i].setBackground(Color.green);
                buttonThemeArray[i].setBorder(pinkLine); }
            getContentPane().remove(mjpT);
            getContentPane().add(mjpMap);
            repaint();
            mjpMap.requestFocusInWindow(); }
        if(obj == mjpT.Char3) {//WHITE/BLACK
            gameTimer.start();
            for(int i = 0;i < buttonThemeArray.length;i += 1) {
                buttonThemeArray[i].setBackground(Color.WHITE);
                buttonThemeArray[i].setBorder(blackLine); }
            getContentPane().remove(mjpT);
            getContentPane().add(mjpMap);
            repaint();
            mjpMap.requestFocusInWindow(); }
        //========================================
        if(obj == mjpD.go) {
                getContentPane().remove(mjpD);
                getContentPane().add(mjpCS);
                repaint(); }
        if(obj == mjpMap.test) { }
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
            //================================================================Campus game end triggers and scores
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
                repaint(); }
            //once 5/6 games have been finished this is triggered
            if(mjpC1.done+mjpC2.done+mjpC3.done+mjpC4.done+mjpC5.done+mjpWC.done == 10 && toggleArray[18]==0) {
                gameTimer.stop();
                getContentPane().remove(mjpMap);
                getContentPane().add(mjpSB);

                readXML();
                writeXML(overallBestTime, overallBestScore);

                //adding all the scoreboard labels
                toggleArray[18]=1;
                mjpSB.finalTime.setBounds(650,200,500,100);
                mjpSB.finalTime.setText("Total Time: "+totalTime);
                mjpSB.add(mjpSB.finalTime);
                mjpSB.finalScore.setBounds(250,200,500,100);
                mjpSB.finalScore.setText("Total Score: "+totalScore);
                mjpSB.add(mjpSB.finalScore);
                mjpSB.gameOver.setBounds(300,0,600,200);
                mjpSB.gameOver.setText("GAME OVER");
                mjpSB.add(mjpSB.gameOver);
                mjpSB.bestScore.setBounds(250,400,500,100);
                mjpSB.bestScore.setText("Best Score: "+ overallBestScore);
                mjpSB.add(mjpSB.bestScore);
                mjpSB.bestTime.setBounds(650,400,500,100);
                mjpSB.bestTime.setText("Best Time: "+ overallBestTime);
                mjpSB.add(mjpSB.bestTime);
                repaint();
            }
        }
    }

    public void readXML() {
        //opens the xml where the best time and score is stored and parses it
        //making variables for each, and making them int
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("scores.xml");
            NodeList bestStats = doc.getElementsByTagName("int");
            int xmlBestTime = Integer.parseInt(bestStats.item(0).getTextContent());
            int xmlBestScore = Integer.parseInt(bestStats.item(1).getTextContent());
            //deciding to add a new score/time
            if(xmlBestTime > totalTime || xmlBestTime == 0) {
                overallBestTime = totalTime; }
            else { overallBestTime = xmlBestTime; }
            if(xmlBestScore < totalScore) { overallBestScore = totalScore; }
            else { overallBestScore = xmlBestScore; }
        }
        catch (ParserConfigurationException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, "1", ex); }
        catch (SAXException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, "2", ex); }
        catch (IOException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, "3", ex);
            writeXML(9999, 0);
            readXML();
        }
    }

    public void writeXML(int time, int score) {
        //try to open a stream to the xml and write to it
        try {
            xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("scores.xml"))); }
        catch (Exception xx) {
            xx.printStackTrace(); }
        //writing the best time and score to the xml
        try {
            xe.writeObject(time);
            xe.writeObject(score); }
        catch (Exception xx) {
            xx.printStackTrace(); }
        try {
            xe.close(); }
        catch (Exception xx) {
            xx.printStackTrace(); }
    }
}

