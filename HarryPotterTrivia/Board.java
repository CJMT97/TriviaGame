
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Board extends JPanel{

// Datafield
   private boolean update;
   private int gcorrect, gcorrect2, ycorrect, ycorrect2, rcorrect, rcorrect2, bcorrect, bcorrect2;
   private JLabel title;
   private JButton correct, incorrect;
   private Graphics g;
   private Tally t;
   private GamePanel gp;

/***************** Board Constructor *****************/
   public Board(Tally t, GamePanel gp){
   //Set Panel Attributes
      
      this.gp = gp;
      this.t = t;
      setBackground(Color.black);
      setPreferredSize(new Dimension(800, 800));
      setLayout(null);
   
   //Title Label
      title = new JLabel();
      title.setSize(new Dimension(800, 100));
      title.setLocation(0, 10);
      title.setFont(new Font("Serif", Font.PLAIN, 70));
      title.setText("<html><div text-align: center>" + "*" + gp.getVersion() + " Trivia*" + "</div></html>");
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setVerticalAlignment(SwingConstants.CENTER);
      title.setForeground(Color.white); 
      add(title);
   
   /***************** BoardCircle *****************/
   
   /***************** JButtons *****************/  
   
      correct = new JButton("Correct");
      correct.setSize(260, 75);
      correct.setForeground(Color.white);
      correct.setBackground(Color.black);
      correct.setOpaque(true);
      correct.setBorder(BorderFactory.createLineBorder(Color.white));
      correct.setLocation(50, 650);
      correct.setFont(new Font("Serif", Font.BOLD, 50));
      add(correct);
      
      incorrect = new JButton("Incorrect");
      incorrect.setSize(260, 75);
      incorrect.setForeground(Color.white);
      incorrect.setBackground(Color.black);
      incorrect.setOpaque(true);
      incorrect.setFont(new Font("Serif", Font.BOLD, 50));
      incorrect.setBorder(BorderFactory.createLineBorder(Color.white));
      incorrect.setLocation(490, 650);
      add(incorrect);
   
   
      
      
      
   //Button Listners
      ButtonListener bListener = new ButtonListener();
      correct.addActionListener(bListener);
      incorrect.addActionListener(bListener);
   }
   
   /** Setter methods */
   public void setGC(){
      gcorrect++;
   }
   public void setYC(){
      ycorrect++;
   }
   public void setRC(){
      rcorrect++;
   }
   public void setBC(){
      bcorrect++;
   }
   public void setGC2(){
      gcorrect2++;
   }
   public void setYC2(){
      ycorrect2++;
   }
   public void setRC2(){
      rcorrect2++;
   }
   public void setBC2(){
      bcorrect2++;
   }
   
// Paint Component  
   public void paintComponent(Graphics g) {
      this.g = g;
      super.paintComponent(g);
      if(update){
         updateBoard(g);
      }
      else if(!update){
         drawBoard(g);
      }
   }

   public void drawBoard(Graphics g){
      gcorrect = 0; 
      gcorrect2 = 0;
      ycorrect = 0;
      ycorrect2 = 0;
      rcorrect = 0;
      rcorrect2 = 0;
      bcorrect = 0;
      bcorrect2 = 0;
      
      Graphics2D g2 = (Graphics2D)g;
      
      Circle circle1 = new Circle(true, 0, 0, new Color(0, 150, 0), 21, 200, 0.314159);
      circle1.draw(g);
      Circle circle2 = new Circle(true, 0, 0, new Color(175, 175, 0), 17, 150, 0.3926991);
      circle2.draw(g);
      Circle circle3 = new Circle(true, 0, 0, new Color(150, 0, 0), 13, 100, 0.523599);
      circle3.draw(g);
      Circle circle4 = new Circle(true, 0, 0, new Color(0, 0, 150), 9, 50, 0.785398);
      circle4.draw(g);
   
   }
   
   public void updateBoard(Graphics g){
      Graphics2D g2 = (Graphics2D)g;
      Circle circle1 = new Circle(true, gcorrect2, gcorrect, new Color(0, 150, 0), 21, 200, 0.314159);
      circle1.draw(g);
      Circle circle2 = new Circle(true, ycorrect2, ycorrect, new Color(175, 175, 0), 17, 150, 0.3926991);
      circle2.draw(g);
      Circle circle3 = new Circle(true, rcorrect2, rcorrect, new Color(150, 0, 0), 13, 100, 0.523599);
      circle3.draw(g);
      Circle circle4 = new Circle(true, bcorrect2, bcorrect, new Color(0, 0, 150), 9, 50, 0.785398);
      circle4.draw(g);
   }
   
   
   public void delay(){
      try{
         correct.setBackground(new Color(50, 50, 50));
         TimeUnit.SECONDS.sleep(2);
         correct.setBackground(Color.black);
      }catch(InterruptedException e){}
   }
   
   public void setButtons(){
      correct.setBackground(new Color(150, 150, 150));
      incorrect.setBackground(new Color(150, 150, 150));
   }
   
   private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent ae){
      
      /***************** Correct and Incorrect *****************/
      
         if(ae.getSource() == correct && gp.getD1()){
            correct.setBackground(Color.black);
            incorrect.setBackground(Color.black);
            gp.getTeamC();
            update = true;
            repaint();
            gp.setD1();
            gp.setD2();
            gp.swapActiveTeam(gp.getTeam());
            gp.setP();
            
            if(t.get1G() == 10){
               gp.setT1G();
            }
            if(t.get1Y() == 8){
               gp.setT1Y();
            }
            if(t.get1R() == 6){
               gp.setT1R();
            }
            if(t.get1B() == 4){
               gp.setT1B();
            }
         }
         
         if(ae.getSource() == correct && gp.getD2()){
            correct.setBackground(Color.black);
            incorrect.setBackground(Color.black);
            gp.getTeamC();
            update = true;
            repaint();
            gp.setD1();
            gp.setD2();
            gp.swapActiveTeam(gp.getTeam());
            gp.setP();
            if(t.get2G() == 10){
               gp.setT2G();
            }
            if(t.get2Y() == 8){
               gp.setT2Y();
            }
            if(t.get2R() == 6){
               gp.setT2R();
            }
            if(t.get2B() == 4){
               gp.setT2B();
            }
         }
      
         if(ae.getSource() == incorrect && (gp.getD1() || gp.getD2())){
            gp.setD1();
            gp.setD2();
            gp.swapActiveTeam(gp.getTeam());
            gp.setP();
         }
      
      }
   }
}