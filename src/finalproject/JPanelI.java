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
public class JPanelI extends JPanel {
    Border blackLine;
    Font font;
    JLabel info,charInfo;
    public JPanelI() {
        setLayout(null);
        setBackground(Color.BLUE);
        font = new Font("TimesRoman",20,20);
        blackLine = BorderFactory.createLineBorder(Color.BLACK,3);
        setBorder(blackLine);
        info = new JLabel("<html>Info for the game");
        info.setBounds(5,5,790,310);
        info.setFont(font);
        info.setForeground(Color.WHITE);
        add(info);
        charInfo = new JLabel("<html>Special 1:<br>Special 2:<br>Special 3:");
        charInfo.setBounds(5,310,790,95);
        charInfo.setFont(font);
        charInfo.setForeground(Color.yellow);
        add(charInfo);
    }
    
}
