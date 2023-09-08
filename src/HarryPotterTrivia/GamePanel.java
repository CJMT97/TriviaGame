

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GamePanel extends JPanel{

//DataField
   private JLabel team1Label, team2Label, t1Q, t1A, t2Q, t2A;
   private JButton t1G, t1Y, t1R, t1B, t2G, t2Y, t2R, t2B, t1An, t2An;
   private GetQA g;
   private boolean qAsked, done1, done2, active1, active2, cB1, cB2, pressable, pressable1, pressable2;
   private String[] qAndA;
   private String color, version;
   private int team1, team;
   private Tally t;
   private Board b;
   
   public void setB(Board b){
      this.b = b;
   }
   
   public String getVersion(){
      return version;
   }
   
   /***************** GamePanel Constructor *****************/
   public GamePanel(JLabel team1Label, JLabel team2Label, Tally t, String version){
   //Set DataField
      this.version = version;
      this.team1Label = team1Label;
      this.team2Label = team2Label;
      pressable = true;
      pressable1 = true;
      pressable2 = true;
      g = new GetQA(version);
      this.g = g;
      this.t = t;
   
   //Set Panel Attributes
      setLayout(null);
      setPreferredSize(new Dimension(400, 800));
      setBackground(Color.black);
   
   /***************** Position TeamLabels *****************/
   //team1 Label
      team1Label.setSize(400, 60);
      team1Label.setHorizontalAlignment(SwingConstants.CENTER);
      team1Label.setVerticalAlignment(SwingConstants.CENTER);
      team1Label.setForeground(Color.white);
      team1Label.setLocation(0, 5);
      
      add(this.team1Label);
   
   //team2 Label
      team2Label.setSize(400, 60);
      team2Label.setHorizontalAlignment(SwingConstants.CENTER);
      team2Label.setVerticalAlignment(SwingConstants.CENTER);
      team2Label.setForeground(Color.white);
      team2Label.setLocation(0, 405);
      add(this.team2Label);
   
   //Team1 Question
      t1Q = new JLabel("");
      t1Q.setSize(350, 100);
      t1Q.setHorizontalAlignment(SwingConstants.CENTER);
      t1Q.setVerticalAlignment(SwingConstants.CENTER);
      t1Q.setForeground(Color.white);
      t1Q.setLocation(25, 100);
      add(t1Q);
      
   //Team1 Answer
      t1A = new JLabel("");
      t1A.setSize(350, 140);
      t1A.setHorizontalAlignment(SwingConstants.CENTER);
      t1A.setVerticalAlignment(SwingConstants.CENTER);
      t1A.setForeground(Color.white);
      t1A.setLocation(25, 200);
      add(t1A);
      
   //Team2 Question
      t2Q = new JLabel("");
      t2Q.setSize(350, 100);
      t2Q.setHorizontalAlignment(SwingConstants.CENTER);
      t2Q.setVerticalAlignment(SwingConstants.CENTER);
      t2Q.setForeground(Color.white);
      t2Q.setLocation(25, 500);
      add(t2Q);
      
   //Team2 Answer
      t2A = new JLabel("");
      t2A.setSize(350, 140);
      t2A.setHorizontalAlignment(SwingConstants.CENTER);
      t2A.setVerticalAlignment(SwingConstants.CENTER);
      t2A.setForeground(Color.white);
      t2A.setLocation(25, 600);
      add(t2A);
      
   /***************** Position Buttons *****************/
   //Team1 Buttons
      t1G = new JButton("Green");
      t1G.setSize(75, 20);
      t1G.setForeground(Color.white);
      t1G.setBackground(new Color(0, 150, 0));
      t1G.setOpaque(true);
      t1G.setBorder(BorderFactory.createLineBorder(Color.white));
      t1G.setLocation(40, 70);
      add(t1G);
      
      t1Y = new JButton("Yellow");
      t1Y.setSize(75, 20);
      t1Y.setForeground(Color.white);
      t1Y.setBackground(new Color(175, 175, 0));
      t1Y.setOpaque(true);
      t1Y.setBorder(BorderFactory.createLineBorder(Color.white));
      t1Y.setLocation(120, 70);
      add(t1Y);
      
      t1R = new JButton("Red");
      t1R.setSize(75, 20);
      t1R.setForeground(Color.white);
      t1R.setBackground(new Color(150, 0, 0));
      t1R.setOpaque(true);
      t1R.setBorder(BorderFactory.createLineBorder(Color.white));
      t1R.setLocation(200, 70);
      add(t1R);
      
      t1B = new JButton("Blue");
      t1B.setSize(75, 20);
      t1B.setForeground(Color.white);
      t1B.setBackground(new Color(0, 0, 150));
      t1B.setOpaque(true);
      t1B.setBorder(BorderFactory.createLineBorder(Color.white));
      t1B.setLocation(280, 70);
      add(t1B);
      
      t1An = new JButton("Answer");
      t1An.setSize(300, 50);
      t1An.setLocation(50, 350);
      add(t1An);
      
   //Team2 Buttons   
      t2G = new JButton("Green");
      t2G.setSize(75, 20);
      t2G.setForeground(Color.white);
      t2G.setBackground(new Color(0, 150, 0));
      t2G.setOpaque(true);
      t2G.setBorder(BorderFactory.createLineBorder(Color.white));
      t2G.setLocation(40, 470);
      add(t2G);
      
      t2Y = new JButton("Yellow");
      t2Y.setSize(75, 20);
      t2Y.setForeground(Color.white);
      t2Y.setBackground(new Color(175, 175, 0));
      t2Y.setOpaque(true);
      t2Y.setBorder(BorderFactory.createLineBorder(Color.white));
      t2Y.setLocation(120, 470);
      add(t2Y);
      
      t2R = new JButton("Red");
      t2R.setSize(75, 20);
      t2R.setForeground(Color.white);
      t2R.setBackground(new Color(150, 0, 0));
      t2R.setOpaque(true);
      t2R.setBorder(BorderFactory.createLineBorder(Color.white));
      t2R.setLocation(200, 470);
      add(t2R);
      
      t2B = new JButton("Blue");
      t2B.setSize(75, 20);
      t2B.setForeground(Color.white);
      t2B.setBackground(new Color(0, 0, 150));
      t2B.setOpaque(true);
      t2B.setBorder(BorderFactory.createLineBorder(Color.white));
      t2B.setLocation(280, 470);
      add(t2B);
      
      t2An = new JButton("Answer");
      t2An.setSize(300, 50);
      t2An.setLocation(50, 700);
      add(t2An);
    
    /***************** Panel ButtonListeners *****************/
      ButtonListener bListener = new ButtonListener();
      t1G.addActionListener(bListener);
      t1Y.addActionListener(bListener);
      t1R.addActionListener(bListener);
      t1B.addActionListener(bListener);
      t2G.addActionListener(bListener);
      t2Y.addActionListener(bListener);
      t2R.addActionListener(bListener);
      t2B.addActionListener(bListener);
      t1An.addActionListener(bListener);
      t2An.addActionListener(bListener);
   }

/***************** Setter methods for Buttons *****************/   
   public void setT1G(){
      t1G.setText("");
   }
   public void setT1Y(){
      t1Y.setText("");
   }
   public void setT1R(){
      t1R.setText("");
   }
   public void setT1B(){
      t1B.setText("");
   }
   public void setT2G(){
      t2G.setText("");
   }
   public void setT2Y(){
      t2Y.setText("");
   }
   public void setT2R(){
      t2R.setText("");
   }
   public void setT2B(){
      t2B.setText("");
   }
   
   public void setD1(){
      done1 = false;
   }
   
   public void setD2(){
      done2 = false;
   }
   
   public boolean getD1(){
      return done1;
   }
   
   public boolean getD2(){
      return done2;
   }
   public void setP(){
      pressable = true;
   }
   public void setP1(){
      pressable1 = true;
   }
   public void setP2(){
      pressable2 = true;
   }
   
   
   public void swapActiveTeam(int x){
      if(x == 1){
         t1G.setBackground(Color.black);
         t1Y.setBackground(Color.black);
         t1R.setBackground(Color.black);
         t1B.setBackground(Color.black);
               
         t2G.setBackground(new Color(0, 150, 0));
         t2Y.setBackground(new Color(175, 175, 0));
         t2R.setBackground(new Color(150, 0, 0));
         t2B.setBackground(new Color(0, 0, 150));
      }
      if(x == 2){
         t2G.setBackground(Color.black);
         t2Y.setBackground(Color.black);
         t2R.setBackground(Color.black);
         t2B.setBackground(Color.black);
               
         t1G.setBackground(new Color(0, 150, 0));
         t1Y.setBackground(new Color(175, 175, 0));
         t1R.setBackground(new Color(150, 0, 0));
         t1B.setBackground(new Color(0, 0, 150));
      }
   }
   
   public int getTeam(){
      return team;
   }
   
   public void getTeamC(){
      if(team == 1 && color.equals("g")){
         b.setGC();
         t.set1G();
      }
      if(team == 1 && color.equals("y")){
         b.setYC();
         t.set1Y();
      }
      if(team == 1 && color.equals("r")){
         b.setRC();
         t.set1R();
      }
      if(team == 1 && color.equals("b")){
         b.setBC();
         t.set1B();
      }
      if(team == 2 && color.equals("g")){
         b.setGC2();
         t.set2G();
      }
      if(team == 2 && color.equals("y")){
         b.setYC2();
         t.set2Y();
      }
      if(team == 2 && color.equals("r")){
         b.setRC2();
         t.set2R();
      }
      if(team == 2 && color.equals("b")){
         b.setBC2();
         t.set2B();
      }
   }
   
   /***************** Button Listener Class *****************/
   private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent ae){
      
      /***************** Team 1 Questions *****************/   
      //Team 1 Green Question
         if(ae.getSource() == t1G && !qAsked && t.get1G() < 10 && pressable && pressable1){         
            try{
               if(cB2){
                  t2Q.setText("");
                  t2A.setText("");
                  cB2 = false;
               }
               pressable2 = true;
               active1 = true;
               t1G.setSize(69, 16);
               t1G.setLocation(43, 72);
               team1 = 1;
               t1A.setText("");
               qAndA = g.getGreen();
               t1Q.setText("<html><div text-align: center>"+ qAndA[0] +"</div></html>");
               t1Q.setHorizontalAlignment(SwingConstants.CENTER);
               t1Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 1;
               color = "g";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t1G && t.get1G() == 10){
            t1G.setText("");
         }
         
      //Team 1 Yellow Question
         if(ae.getSource() == t1Y && !qAsked && t.get1Y() < 8 && pressable && pressable1){         
            try{
               if(cB2){
                  t2Q.setText("");
                  t2A.setText("");
                  cB2 = false;
               }
               pressable2 = true;
               active1 = true;
               t1Y.setSize(69, 16);
               t1Y.setLocation(123, 72);
               team1 = 1;
               t1A.setText("");
               qAndA = g.getYellow();
               t1Q.setText("<html><div text-align: center>"+ qAndA[0] +"</div></html>");
               t1Q.setHorizontalAlignment(SwingConstants.CENTER);
               t1Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 1;
               color = "y";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t1Y && t.get1Y() == 8){
            t1Y.setText("");
         }
      
      //Team 1 Red Question
         if(ae.getSource() == t1R && !qAsked && t.get1R() < 6 && pressable && pressable1){         
            try{
               if(cB2){
                  t2Q.setText("");
                  t2A.setText("");
                  cB2 = false;
               }
               pressable2 = true;
               active1 = true;
               t1R.setSize(69, 16);
               t1R.setLocation(203, 72);
               team1 = 1;
               t1A.setText("");
               qAndA = g.getRed();
               t1Q.setText("<html><div text-align: center>"+ qAndA[0] +"</div></html>");
               t1Q.setHorizontalAlignment(SwingConstants.CENTER);
               t1Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 1;
               color = "r";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t1R && t.get1R() == 6){
            t1R.setText("");
         }
      
      //Team 1 Blue Question
         if(ae.getSource() == t1B && !qAsked && t.get1B() < 4 && pressable && pressable1){         
            try{
               if(cB2){
                  t2Q.setText("");
                  t2A.setText("");
                  cB2 = false;
               }
               pressable2 = true;
               active1 = true;
               t1B.setSize(69, 16);
               t1B.setLocation(283, 72);
               team1 = 1;
               t1A.setText("");
               qAndA = g.getBlue();
               t1Q.setText("<html><div text-align: center>"+ qAndA[0] +"</div></html>");
               t1Q.setHorizontalAlignment(SwingConstants.CENTER);
               t1Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 1;
               color = "b";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t1B && t.get1B() == 4){
            t1B.setText("");
         }
         
      /***************** Team 2 Questions *****************/  
      //Team 2 Green Question
         if(ae.getSource() == t2G && !qAsked && t.get2G() < 10 && pressable && pressable2){         
            try{
               if(cB1){
                  t1Q.setText("");
                  t1A.setText("");
                  cB1 = false;
               }
               pressable1 = true;
               active2 = true;
               t2G.setSize(69, 16);
               t2G.setLocation(43, 472);
               team1 = 2;
               t2A.setText("");
               qAndA = g.getGreen();
               t2Q.setText("<html><div text-align: center>"+ qAndA[0] +"</div></html>");
               t2Q.setHorizontalAlignment(SwingConstants.CENTER);
               t2Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 2;
               color = "g";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t2G && t.get1G() == 10){
            t2G.setText("");
         }
         
      //Team 2 Yellow Question
         if(ae.getSource() == t2Y && !qAsked && t.get2Y() < 8 && pressable && pressable2){         
            try{
               if(cB1){
                  t1Q.setText("");
                  t1A.setText("");
                  cB1 = false;
               }
               pressable1 = true;
               active2 = true;
               t1Q.setText("");
               t1A.setText("");
               done1 = false;
               t2Y.setSize(69, 16);
               t2Y.setLocation(123, 472);
               team1 = 2;
               t2A.setText("");
               qAndA = g.getYellow();
               t2Q.setText("<html><div text-align: center>"+ qAndA[0] +"</div></html>");
               t2Q.setHorizontalAlignment(SwingConstants.CENTER);
               t2Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 2;
               color = "y";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t2Y && t.get2Y() == 8){
            t2Y.setText("");
         }
      
      //Team 2 Red Question
         if(ae.getSource() == t2R && !qAsked && t.get2R() < 6 && pressable && pressable2){         
            try{
               if(cB1){
                  t1Q.setText("");
                  t1A.setText("");
                  cB1 = false;
               }
               pressable1 = true;
               active2 = true;
               t2R.setSize(69, 16);
               t2R.setLocation(203, 472);
               team1 = 2;
               t2A.setText("");
               qAndA = g.getRed();
               t2Q.setText("<html><div text-align: center>"+ qAndA[0] +"</div></html>");
               t2Q.setHorizontalAlignment(SwingConstants.CENTER);
               t2Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 2;
               color = "r";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t2R && t.get2R() == 6){
            t2R.setText("");
         }
      
      //Team 2 Blue Question
         if(ae.getSource() == t2B && !qAsked && t.get2B() < 4 && pressable && pressable2){         
            try{
               if(cB1){
                  t1Q.setText("");
                  t1A.setText("");
                  cB1 = false;
               }
               pressable1 = true;
               active2 = true;
               t2B.setSize(69, 16);
               t2B.setLocation(283, 472);
               team1 = 2;
               t2A.setText("");
               qAndA = g.getBlue();
               t2Q.setText("<html><div text-align: center>"+ qAndA[0] + "</div></html>");
               t2Q.setHorizontalAlignment(SwingConstants.CENTER);
               t2Q.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = true;
               team = 2;
               color = "b";
            }catch(NumberFormatException ex){}
         }else if(ae.getSource() == t2B && t.get2B() == 4){
            t2B.setText("");
         }
      
      /***************** Answer Buttons *****************/ 
      //Team 1 Answer
         if(ae.getSource() == t1An && qAsked && team1 == 1){         
            try{
               t1A.setText("<html><div text-align: center>" + qAndA[1] + "</div></html>");
               t1A.setHorizontalAlignment(SwingConstants.CENTER);
               t1A.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = false;
               qAndA = null;
               team1 = 0;
               
               t1G.setForeground(Color.white);
               t1Y.setForeground(Color.white);
               t1R.setForeground(Color.white);
               t1B.setForeground(Color.white);
               
               t1G.setSize(75, 20);
               t1G.setLocation(40, 70);
               t1Y.setSize(75, 20);
               t1Y.setLocation(120, 70);
               t1R.setSize(75, 20);
               t1R.setLocation(200, 70);
               t1B.setSize(75, 20);
               t1B.setLocation(280, 70);
               
            }catch(NumberFormatException ex){}
         }
      
      //Team 2 Answer
         if(ae.getSource() == t2An && qAsked && team1 == 2){         
            try{
               t2A.setText("<html><div text-align: center>" + qAndA[1] + "</div></html>");
               t1A.setHorizontalAlignment(SwingConstants.CENTER);
               t1A.setVerticalAlignment(SwingConstants.CENTER);
               qAsked = false;
               qAndA = null;
               team1 = 0;
               
               t2G.setForeground(Color.white);
               t2Y.setForeground(Color.white);
               t2R.setForeground(Color.white);
               t2B.setForeground(Color.white);
               
               t2G.setSize(75, 20);
               t2G.setLocation(40, 470);
               t2Y.setSize(75, 20);
               t2Y.setLocation(120, 470);
               t2R.setSize(75, 20);
               t2R.setLocation(200, 470);
               t2B.setSize(75, 20);
               t2B.setLocation(280, 470);
               
            }catch(NumberFormatException ex){}
         }
         
         // Answer buttons
         //Team 1
         if(ae.getSource() == t1An && !done2 && active1){         
            try{
               b.setButtons();
               active1 = false;
               done1 = true;
               cB1 = true;
               pressable = false;
               pressable1 = false;
            }catch(NumberFormatException ex){}
         } 
         //Team2
         if(ae.getSource() == t2An && !done1 && active2){         
            try{
               b.setButtons();
               active2 = false;
               done2 = true;
               cB2 = true;
               pressable = false;
               pressable2 = false;
            }catch(NumberFormatException ex){}
         }
         
         
      }
   }
}