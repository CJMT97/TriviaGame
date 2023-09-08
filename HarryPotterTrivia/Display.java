import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Display extends JPanel{

 private Tally t;
 private GamePanel gp;

   public Display(Tally t, JLabel team1, JLabel team2){
   
      GamePanel gp = new GamePanel(team1, team2, t);
      Board b1 = new Board(t, gp);
      add(gp);
      add(b1);
      
   }

}