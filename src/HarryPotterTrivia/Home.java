/** Main menu/Home for The Trivia Game */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;

@SuppressWarnings("serial")
public class Home extends JPanel {
	
   //Data field
   private static final long serialVersionUID = 1L;
   private final Color bg = Color.black;
   private JLabel welcome, theme;
   private JButton play, gamemode, history, next, previous, menu;
   private FrameManager fm;
   private boolean gmSelect;
   private String[] gms = {"Harry Potter", "Disney", "Percy Jackson", "Game of Thrones", "Star Wars", "Marvel", "Muscials", "General"};
   private JPanel jp;
   private int count = 0;
   private String game = gms[count];


	/** Constructor for WelcomePanel*/
   public Home(){
   	
      this.fm = fm;
      setLayout(null);
      setBackground(bg);
      setPreferredSize(new Dimension(1000, 800));
   	
   	// Welcome Message attributes
      welcome = new JLabel();
      welcome.setSize(new Dimension(800, 75));
      welcome.setLocation(100, 30);
      welcome.setFont(new Font("Serif", Font.PLAIN, 100));
      welcome.setForeground(Color.white);
      welcome.setHorizontalAlignment(SwingConstants.CENTER);
      welcome.setVerticalAlignment(SwingConstants.CENTER);
      welcome.setText("<html><div text-align: center>" + "The Trivia Game!" + "</div></html>");
      add(welcome);
   	
      //Internal JPanel
      jp = new JPanel();
      jp.setBackground(new Color(50, 50, 50));
      jp.setBorder(BorderFactory.createLineBorder(Color.white));
      jp.setLayout(null);
      jp.setLocation(250, 175);
      jp.setSize(500, 500);
   	
   	/* JButtons */
   	// Login button attributes
      play = new JButton("Play");
      play.setLocation(100, 90);
      play.setSize(new Dimension(300, 75));
      play.setForeground(Color.white);
      play.setBackground(new Color(100, 100, 100));
      play.setOpaque(true);
      play.setFont(new Font("Serif", Font.PLAIN, 40));
      play.setBorder(BorderFactory.createLineBorder(Color.white));
      jp.add(play);
   	
   	// Register button attributes
      gamemode = new JButton("Gamemode");
      gamemode.setLocation(100, 215);
      gamemode.setSize(new Dimension(300, 75));
      gamemode.setForeground(Color.white);
      gamemode.setBackground(new Color(100, 100, 100));
      gamemode.setOpaque(true);
      gamemode.setFont(new Font("Serif", Font.PLAIN, 40));
      gamemode.setBorder(BorderFactory.createLineBorder(Color.white));
      jp.add(gamemode);
   	
   	// History button attributes
      history = new JButton("History");
      history.setLocation(100, 340);
      history.setSize(new Dimension(300, 75));
      history.setForeground(Color.white);
      history.setBackground(new Color(100, 100, 100));
      history.setFont(new Font("Serif", Font.PLAIN, 40));
      history.setOpaque(true);
      history.setBorder(BorderFactory.createLineBorder(Color.white));
      jp.add(history);
      
      // Previous button attributes
      previous = new JButton("Previous");
      previous.setSize(75, 50);
      previous.setForeground(Color.white);
      previous.setBackground(new Color(150, 150, 150));
      previous.setOpaque(true);
      previous.setBorder(BorderFactory.createLineBorder(Color.white));
      previous.setLocation(25, 325);
      jp.add(previous);
      previous.setVisible(false);
      
      // Next button attributes
      next = new JButton("Next");
      next.setSize(75, 50);
      next.setForeground(Color.white);
      next.setBackground(new Color(150, 150, 150));
      next.setOpaque(true);
      next.setBorder(BorderFactory.createLineBorder(Color.white));
      next.setLocation(400, 325);
      jp.add(next);
      next.setVisible(false);
      
      // Menu button attributes
      menu = new JButton("Save");
      menu.setSize(150, 65);
      menu.setForeground(Color.white);
      menu.setBackground(Color.black);
      menu.setOpaque(true);
      menu.setBorder(BorderFactory.createLineBorder(Color.blue));
      menu.setLocation(175, 318);
      jp.add(menu);
      menu.setVisible(false);
   	
      add(jp);
      
      // Button Listners
      ButtonListener bListener = new ButtonListener();
      play.addActionListener(bListener);
      gamemode.addActionListener(bListener);
      history.addActionListener(bListener);
      next.addActionListener(bListener);
      previous.addActionListener(bListener);
      menu.addActionListener(bListener);
   }
   
   /** presentGamemodes method displays a GUI to allow you to select which Trivia you are playing */
   public void presentGamemodes(){
      gmSelect = true;
      play.setVisible(false);
      gamemode.setVisible(false);
      history.setVisible(false);
      
      previous.setVisible(true);
      next.setVisible(true);
      menu.setVisible(true);
      jp.setSize(500, 400);
      jp.setLocation(250, 225);
      
      jp.repaint();
   
      theme = new JLabel();
      theme.setSize(new Dimension(400, 200));
      theme.setLocation(50, 50);
      theme.setFont(new Font("Serif", Font.PLAIN, 100));
      theme.setForeground(Color.white);
      theme.setText("<html><div text-align: center>" + gms[count] + "</div></html>");
      theme.setHorizontalAlignment(SwingConstants.CENTER);
      theme.setVerticalAlignment(SwingConstants.CENTER);
      jp.add(theme);
      
      
      
   }
   
   /***************** Clears Display *****************/
   public void clear(){
      FrameManager f1 = new FrameManager(game);
      JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
      frame.dispose();
      
   }
	
   /** ButtonListner Class controls actions of pressing buttons */
   private class ButtonListener implements ActionListener{
   
      @Override
      public void actionPerformed(ActionEvent e) {
         //Gamemode button
         if(e.getSource() == gamemode && !gmSelect) {
            presentGamemodes();
         }
         //Play button
         if(e.getSource() == play && !gmSelect) {
         	clear();
         }
         //Next button
         if(e.getSource() == next && count != gms.length-1){
            count++;
            theme.setText("<html><div text-align: center>" + gms[count] + "</div></html>");
            game = gms[count];
         }
         //Previous button
         if(e.getSource() == previous && count != 0){
            count--;
            theme.setText("<html><div text-align: center>" + gms[count] + "</div></html>");
            game = gms[count];
         }
         if(e.getSource() == menu){
            play.setVisible(true);
            gamemode.setVisible(true);
            history.setVisible(true);
            
            theme.setText("");
            
            previous.setVisible(false);
            next.setVisible(false);
            menu.setVisible(false);
            
            jp.setLocation(250, 175);
            jp.setSize(500, 500);
            
            gmSelect = false;
            
            jp.repaint();
            
            
         }
      }
   }

}
