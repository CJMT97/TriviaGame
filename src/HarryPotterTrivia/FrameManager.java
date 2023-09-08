/** Frame manager */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;

public class FrameManager extends JPanel{

//DataField
   private static JFrame frame;
   private Tally t;
   private int width, height, count;
   private StartUp panel1;
   private GridBagConstraints gbc = new GridBagConstraints();
   private String version;
   private Home h;
   
   /***************** Frame Manager Default Constructor *****************/
   public FrameManager(){
      frame = new JFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setTitle("Nerd Trivia");
      
      //frame.setLayout(new GridBagLayout());
      //gbc.insets = new Insets(0, 0, 0, 5);
      //gbc.gridx = 5;
      //gbc.gridy = 5;
      
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      h = new Home();
      frame.getContentPane().add(h);
      frame.setSize(1200, 800);
      frame.pack();     
      frame.setBackground(Color.black);
      frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
      frame.setVisible(true);
      
   }

/***************** Frame Manager Constructor *****************/
   public FrameManager(String version){
      this.version = version;
      frame = new JFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setTitle("Nerd Trivia");
      
      
      frame.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 5);
      gbc.gridx = 5;
      gbc.gridy = 5;
      
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      panel1 = new StartUp(1200, 800, version);
      frame.getContentPane().add(panel1);
      frame.setSize(1200, 800);
      frame.pack();     
      frame.setBackground(Color.black);
      frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
      frame.setVisible(true);
      
   }
   
   public String getVersion(){
      return version;
   }
   
/***************** Frame Manager Constructor2 *****************/   
   public FrameManager(int x, String version){
      this.version = version;
      t = new Tally();
   
      frame = new JFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setTitle("Nerd Trivia");
      frame.pack();
      
   }

/***************** Begin Game *****************/   
   public void beginGame(JLabel team1, JLabel team2){
      Container c = frame.getContentPane();
      Border blackline = BorderFactory.createLineBorder(Color.white);
      c.setBackground(Color.black); 
       
      //Create instances
      GamePanel newGame = new GamePanel(team1, team2, t, version);
      Board b1 = new Board(t, newGame);
      newGame.setB(b1);
      c.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 5);
      
      //Set attributes of instances
      newGame.setBorder(blackline);
      gbc.gridx = 5;
      gbc.gridy = 5;
      newGame.setBackground(Color.black);
      c.add(newGame);
      
      b1.setBorder(blackline);
      gbc.gridx = 410;
      gbc.gridy = 5;
      b1.setBackground(Color.black);
      c.add(b1);
      
      //Set Frame size
      c.setPreferredSize(new Dimension(1225, 850));
      frame.setSize(1225, 850); 
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
      frame.setVisible(true);
   }
}