import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Circle extends JPanel{

   protected Color bg;
   protected int lines;
   protected int x;
   protected int y;
   protected int radius;
   protected double theta;
   private boolean team;
   private int correct;
   private int correct2;

   public Circle(boolean team, int correct, int correct2, Color bg, int lines, int radius, double theta){
      this.bg = bg;
      this.lines = lines;
      this.x = (800 - radius*2)/2;
      this.y = (800 - radius*2)/2;
      this.radius = radius;
      this.theta = theta;
      this.team = team;
      this.correct = correct;
      this.correct2 = correct2;
   }
   
   public void setCorrect(int correct){
      this.correct = correct;
   }
   
   public void setCorrect2(int correct2){
      this.correct2 = correct2;
   }
   
   public void draw(Graphics g){
      //draw circle
      
      g.setColor(bg);
      g.fillOval(x, y, radius*2, radius*2);
      g.setColor(Color.white);
      g.drawOval(x, y, radius*2, radius*2);
      
      Graphics2D g2 = (Graphics2D)g;
      g2.setStroke(new BasicStroke(2));
      
      
      int count1 = 0;
      int count2 = 0;
      for(int i = 1; i<lines; i++){
         if(correct != 0 && count1<correct){
            g2.setColor(Color.white);
            g2.fillOval(408, y+8, radius/5, radius/5);
            g2.setColor(Color.black);
            g2.drawOval(408, y+8, radius/5, radius/5);
            g2.setColor(Color.white);
            g2.drawLine(400, y+radius, 400, y);
            g2.rotate(theta*1, 400, y+radius);
            count1++;
         }
         else if(i>=(lines/2+1) && correct2 != 0 && count2<correct2){
         
            g2.setColor(Color.white);
            g2.fillOval(408, y+8, radius/5, radius/5);
            g2.setColor(Color.black);
            g2.drawOval(408, y+8, radius/5, radius/5);
            g2.setColor(Color.white);
            g2.drawLine(400, y+radius, 400, y);
            g2.rotate(theta*1, 400, y+radius);
            count2++;
         }
         else{
            g2.setColor(Color.white);
            g2.drawLine(400, y+radius, 400, y);
            g2.rotate(theta*1, 400, y+radius);
         }
         
      } 
      
      g2.setStroke(new BasicStroke(5));

      g2.setColor(Color.black);
      g2.drawLine(400, 200, 400, 600);
      g2.setStroke(new BasicStroke(2));
   }
}

