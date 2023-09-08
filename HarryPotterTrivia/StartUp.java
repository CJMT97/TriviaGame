/** Class for asking users team names*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;

public class StartUp extends JPanel{

//DataField
   private String team1Name, team2Name, version;
   private JLabel title, message1, message2, team1, team2;
   private JTextField enter1, enter2;
   private JButton submit;
   private Tally t;
   private int width, height;
  // private ButtonListener bListener;

/***************** Constuctor *****************/
   public StartUp(int width, int height, String version){
      this.width = width;
      this.height = height;
      this.version = version;
      
   //Panel color and Dimension and layout
      setLayout(null);
      setPreferredSize(new Dimension(1200, 800));
      setBackground(new Color(0, 0, 0));
      Border blackline = BorderFactory.createLineBorder(Color.white);
      setBorder(blackline);
   
   /***************** Panel JLabels *****************/
   //Title
      title = new JLabel("*" + version + " Trivia*");
      title.setSize(width, 100);
      title.setFont(new Font("Serif", Font.PLAIN, 100));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setVerticalAlignment(SwingConstants.CENTER);
      title.setLocation(0, 0);
      title.setForeground(Color.white);
      this.title = title;
   
   //Message1
      message1 = new JLabel("Enter Team 1 Name:");
      message1.setSize(width/2, 100);
      message1.setFont(new Font("Serif", Font.PLAIN, 50));
      message1.setLocation(300, 250);
      message1.setForeground(Color.white);
      this.message1 = message1;
   
   //Message2
      message2 = new JLabel("Enter Team 2 Name:");
      message2.setSize(700, 100);
      message2.setFont(new Font("Serif", Font.PLAIN, 50));
   
      message2.setLocation(300, 450);
      message2.setForeground(Color.white);
      this.message2 = message2;
   
   /***************** Panel JTextField *****************/
   //Enter1
      enter1 = new JTextField(10);
      enter1.setSize(200, 50);
      enter1.setLocation(750, 275);
      enter1.setFont(new Font("Serif", Font.PLAIN, 40));
      this.enter1 = enter1;
   
   //Enter2
      enter2 = new JTextField(10);
      enter2.setSize(200, 50);
      enter2.setLocation(750, 475);
      enter2.setFont(new Font("Serif", Font.PLAIN, 40));
      this.enter2 = enter2;
      
   /***************** Panel JButton *****************/
   //Submit
      submit = new JButton("Submit");
      submit.setSize(200, 100);
      submit.setFont(new Font("Serif", Font.PLAIN, 40));
      submit.setLocation(500, 600);
      this.submit = submit;
   
   /***************** Panel ButtonListener *****************/
      ButtonListener bListener = new ButtonListener();
      submit.addActionListener(bListener);
      
      add(this.title);
      add(this.message1);
      add(this.message2);
      add(this.enter1);
      add(this.enter2);
      add(this.submit);
   }
 
   /***************** Clears Display *****************/
   public void clear(){
      
      JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
      FrameManager f1 = new FrameManager(1, version);
      frame.dispose();
      f1.beginGame(team1, team2);
   }
   
   /***************** createTeamLabels *****************/
   public void createTeamLabels(){
   //Team1 Label
      if(team1Name.length() <= 10){
         team1 = new JLabel();
         team1.setText("<html><u>"+ team1Name +"</u></html>");
         team1.setFont(new Font("Serif", Font.PLAIN, 50)); 
         this.team1 = team1;
      }else if(team1Name.length() > 10 && team1Name.length() <= 21){
         team1 = new JLabel();
         team1.setText("<html><u>"+ team1Name +"</u></html>");
         team1.setFont(new Font("Serif", Font.PLAIN, 25)); 
         this.team1 = team1;
      }else if(team1Name.length() > 21){
         team1 = new JLabel();
         team1.setText("<html><u>"+ team1Name +"</u></html>");
         team1.setFont(new Font("Serif", Font.PLAIN, 15)); 
         this.team1 = team1;
      }
      
   //Team2 Label
      if(team2Name.length() <= 10){
         team2 = new JLabel();
         team2.setText("<html><u>" + team2Name +"</u></html>");
         team2.setFont(new Font("Serif", Font.PLAIN, 50));
         this.team2 = team2;
      }else if(team2Name.length() > 10 && team2Name.length() <= 21){
         team2 = new JLabel();
         team2.setText("<html><u>"+ team2Name +"</u></html>");
         team2.setFont(new Font("Serif", Font.PLAIN, 25)); 
         this.team2 = team2;
      }else if(team2Name.length() > 21){
         team2 = new JLabel();
         team2.setText("<html><u>"+ team2Name +"</u></html>");
         team2.setFont(new Font("Serif", Font.PLAIN, 15)); 
         this.team2 = team2;
      }
      
   }
   
   /***************** getTeamNameLabels *****************/
   public JLabel getTeam1NameLabel(){
      return team1;
   }
   
   public JLabel getTeam2NameLabel(){
      return team2;
   }
   
   /***************** Button Listener Class *****************/
   private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent ae){
      
         if(ae.getSource() == submit){             
            try{
               System.out.println("D");
               team1Name = enter1.getText();
               team2Name = enter2.getText();
               enter1.setText("");
               enter2.setText("");
               createTeamLabels();
               clear();
            }catch(NumberFormatException ex){}
         }
      }
   }
}