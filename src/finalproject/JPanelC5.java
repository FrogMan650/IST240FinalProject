package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class JPanelC5 extends JPanel  implements ActionListener {
    ImageIcon sourceImage1 = new ImageIcon("src/pictures/clouds.jpg");
    Image clouds = sourceImage1.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
    Border whiteLine;
    JButton special,help,help2,Jtest,player;
    JButton t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32; //t32 = end portal
    int score = 0;
    int time = 60;
    int specialUses = 2;
    int toggleArray[] = new int[50];//0 transformation
    Font font;
    Timer gameTimer;
    int delay;
    int done = 0;
    public JPanelC5() {
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
        Jtest.setBounds(0,0,100,75);
        Jtest.setFocusable(false);
        Jtest.addActionListener(this);
        add(Jtest);
        player = new JButton();
        player.setBounds(140,140,50,50);
        player.setFocusable(false);
        add(player);
        
//        t1 t30 default
//        t2 t14 BLACK
//        t3 t26 LIGHT_GRAY
//        t4 t13 PINK
//        t5 t29 WHITE
//        t6 t9 CYAN
//        t7 t10 DARK_GRAY
//        t8 t19 GRAY
//        t11 t21 MAGENTA
//        t12 t25 RED
//        t15 t22 GREEN
//        t16 t18 BLUE
//        t17 t23 pink
//        t20 t31 ORANGE
//        t24 t28 YELLOW
//        t27 magenta
//        t32 theme colors (end portal)
        
        t1 = new JButton();
        t1.setBounds(80,77,20,20);
        t1.setFocusable(false);
        t1.addActionListener(this);
        add(t1);
        t2 = new JButton();
        t2.setBounds(240,77,20,20);
        t2.setFocusable(false);
        t2.addActionListener(this);
        t2.setBackground(Color.BLACK);
        add(t2);
        t3 = new JButton();
        t3.setBounds(400,77,20,20);
        t3.setFocusable(false);
        t3.addActionListener(this);
        t3.setBackground(Color.LIGHT_GRAY);
        add(t3);
        t4 = new JButton();
        t4.setBounds(560,77,20,20);
        t4.setFocusable(false);
        t4.addActionListener(this);
        t4.setBackground(Color.PINK);
        add(t4);
        t5 = new JButton();
        t5.setBounds(720,77,20,20);
        t5.setFocusable(false);
        t5.addActionListener(this);
        t5.setBackground(Color.WHITE);
        add(t5);
        t6 = new JButton();
        t6.setBounds(880,77,20,20);
        t6.setFocusable(false);
        t6.addActionListener(this);
        t6.setBackground(Color.CYAN);
        add(t6);
        t7 = new JButton();
        t7.setBounds(1040,77,20,20);
        t7.setFocusable(false);
        t7.addActionListener(this);
        t7.setBackground(Color.DARK_GRAY);
        add(t7);
        t8 = new JButton();
        t8.setBounds(1200,77,20,20);
        t8.setFocusable(false);
        t8.addActionListener(this);
        t8.setBackground(Color.GRAY);
        add(t8);
        t9 = new JButton();
        t9.setBounds(80,232,20,20);
        t9.setFocusable(false);
        t9.addActionListener(this);
        t9.setBackground(Color.CYAN);
        add(t9);
        t10 = new JButton();
        t10.setBounds(240,232,20,20);
        t10.setFocusable(false);
        t10.addActionListener(this);
        t10.setBackground(Color.DARK_GRAY);
        add(t10);
        t11 = new JButton();
        t11.setBounds(400,232,20,20);
        t11.setFocusable(false);
        t11.addActionListener(this);
        t11.setBackground(Color.MAGENTA);
        add(t11);
        t12 = new JButton();
        t12.setBounds(560,232,20,20);
        t12.setFocusable(false);
        t12.addActionListener(this);
        t12.setBackground(Color.RED);
        add(t12);
        t13 = new JButton();
        t13.setBounds(720,232,20,20);
        t13.setFocusable(false);
        t13.addActionListener(this);
        t13.setBackground(Color.PINK);
        add(t13);
        t14 = new JButton();
        t14.setBounds(880,232,20,20);
        t14.setFocusable(false);
        t14.addActionListener(this);
        t14.setBackground(Color.BLACK);
        add(t14);
        t15 = new JButton();
        t15.setBounds(1040,232,20,20);
        t15.setFocusable(false);
        t15.addActionListener(this);
        t15.setBackground(Color.GREEN);
        add(t15);
        t16 = new JButton();
        t16.setBounds(1200,232,20,20);
        t16.setFocusable(false);
        t16.addActionListener(this);
        t16.setBackground(Color.BLUE);
        add(t16);
        t17 = new JButton();
        t17.setBounds(80,387,20,20);
        t17.setFocusable(false);
        t17.addActionListener(this);
        t17.setBackground(Color.pink);
        add(t17);
        t18 = new JButton();
        t18.setBounds(240,387,20,20);
        t18.setFocusable(false);
        t18.addActionListener(this);
        t18.setBackground(Color.BLUE);
        add(t18);
        t19 = new JButton();
        t19.setBounds(400,387,20,20);
        t19.setFocusable(false);
        t19.addActionListener(this);
        t19.setBackground(Color.GRAY);
        add(t19);
        t20 = new JButton();
        t20.setBounds(560,387,20,20);
        t20.setFocusable(false);
        t20.addActionListener(this);
        t20.setBackground(Color.ORANGE);
        add(t20);
        t21 = new JButton();
        t21.setBounds(720,387,20,20);
        t21.setFocusable(false);
        t21.addActionListener(this);
        t21.setBackground(Color.MAGENTA);
        add(t21);
        t22 = new JButton();
        t22.setBounds(880,387,20,20);
        t22.setFocusable(false);
        t22.addActionListener(this);
        t22.setBackground(Color.GREEN);
        add(t22);
        t23 = new JButton();
        t23.setBounds(1040,387,20,20);
        t23.setFocusable(false);
        t23.addActionListener(this);
        t23.setBackground(Color.pink);
        add(t23);
        t24 = new JButton();
        t24.setBounds(1200,387,20,20);
        t24.setFocusable(false);
        t24.addActionListener(this);
        t24.setBackground(Color.YELLOW);
        add(t24);
        t25 = new JButton();
        t25.setBounds(80,542,20,20);
        t25.setFocusable(false);
        t25.addActionListener(this);
        t25.setBackground(Color.RED);
        add(t25);
        t26 = new JButton();
        t26.setBounds(240,542,20,20);
        t26.setFocusable(false);
        t26.addActionListener(this);
        t26.setBackground(Color.LIGHT_GRAY);
        add(t26);
        t27 = new JButton();
        t27.setBounds(400,542,20,20);
        t27.setFocusable(false);
        t27.addActionListener(this);
        t27.setBackground(Color.magenta);
        add(t27);
        t28 = new JButton();
        t28.setBounds(560,542,20,20);
        t28.setFocusable(false);
        t28.addActionListener(this);
        t28.setBackground(Color.YELLOW);
        add(t28);
        t29 = new JButton();
        t29.setBounds(720,542,20,20);
        t29.setFocusable(false);
        t29.addActionListener(this);
        t29.setBackground(Color.WHITE);
        add(t29);
        t30 = new JButton();
        t30.setBounds(880,542,20,20);
        t30.setFocusable(false);
        t30.addActionListener(this);
        add(t30);
        t31 = new JButton();
        t31.setBounds(1040,542,20,20);
        t31.setFocusable(false);
        t31.addActionListener(this);
        t31.setBackground(Color.ORANGE);
        add(t31);
        t32 = new JButton();
        t32.setBounds(1200,542,20,20);
        t32.setFocusable(false);
        t32.addActionListener(this);
        add(t32);
    }
    public void paintComponent(Graphics g) {
            g.drawImage(clouds, 0, 0, this); }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj == gameTimer) {
            if(toggleArray[0] == 1 && t32.isDisplayable()) {
                add(t32); }
            time+=-1; }
        if(obj == Jtest) {
            time = 2; 
            gameTimer.start(); }
        if(obj == player) {
            gameTimer.start(); }
        if(obj == t1) {
            System.out.println("t1"); }
        if(obj == t2) {
            System.out.println("t2"); }
        if(obj == t3) {
            System.out.println("t3"); }
        if(obj == t4) {
            System.out.println("t4"); }
        if(obj == t5) {
            System.out.println("t5"); }
        if(obj == t6) {
            System.out.println("t6"); }
        if(obj == t7) {
            System.out.println("t7"); }
        if(obj == t8) {
            System.out.println("t8"); }
        if(obj == t9) {
            System.out.println("t9"); }
        if(obj == t10) {
            System.out.println("t10"); }
        if(obj == t11) {
            System.out.println("t11"); }
        if(obj == t12) {
            System.out.println("t12"); }
        if(obj == t13) {
            System.out.println("t13"); }
        if(obj == t14) {
            System.out.println("t14"); }
        if(obj == t15) {
            System.out.println("t15"); }
        if(obj == t16) {
            System.out.println("t16"); }
        if(obj == t17) {
            System.out.println("t17"); }
        if(obj == t18) {
            System.out.println("t18"); }
        if(obj == t19) {
            System.out.println("t19"); }
        if(obj == t20) {
            System.out.println("t20"); }
        if(obj == t21) {
            System.out.println("t21"); }
        if(obj == t22) {
            System.out.println("t22"); }
        if(obj == t23) {
            System.out.println("t23"); }
        if(obj == t24) {
            System.out.println("t24"); }
        if(obj == t25) {
            System.out.println("t25"); }
        if(obj == t26) {
            System.out.println("t26"); }
        if(obj == t27) {
            System.out.println("t27"); }
        if(obj == t28) {
            System.out.println("t28"); }
        if(obj == t29) {
            System.out.println("t29"); }
        if(obj == t30) {
            System.out.println("t30"); }
        if(obj == t31) {
            System.out.println("t31"); }
        if(obj == t32) {
            System.out.println("t32"); }
    }
}
