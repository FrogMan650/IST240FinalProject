/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author lek5246
 */
public class JPanelD extends JPanel{
    Font font,font2;
    JLabel info;
    Border whiteLine;
    JButton special,help, go;
    public JPanelD() {
        setLayout(null);
        setBackground(Color.BLACK);
        font = new Font("TimesRoman",20,50);
        font2 = new Font("TimesRoman",20,20);
        whiteLine = BorderFactory.createLineBorder(Color.WHITE,3);
        info = new JLabel("<html>Before we start: In this game you will be given a different game at each campus you visit.  Each game will have a set amount of time, that you can see at the "
                + "bottom of the screen.  You will also be able to gain points from each game, depending on the game rules and how well you perform in said games.  In each campus you will also "
                + "have a special ability, which you can see on the screen currently represented by a green button.  There is also a help button, which you can see on screen now, that will "
                + "give you instructions on the game, as well as what your special does.  I'd suggest checking the help button as soon as you enter the campus.  Press the \"Character Select\" "
                + "button when you're ready to start.");
        info.setFont(font2);
        info.setForeground(Color.WHITE);
        info.setBounds(250,100,800,400);
        add(info);
        special = new JButton();
        special.setBounds(0,620,100,100);
        special.setBorder(whiteLine);
        special.setBackground(Color.green);
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
        go = new JButton("Character Select");
        go.setBounds(100,620,1080,100);
        go.setBorder(whiteLine);
        go.setBackground(Color.BLUE);
        go.setForeground(Color.WHITE);
        go.setFont(font);
        go.setFocusable(false);
        add(go);
    }
    
}
