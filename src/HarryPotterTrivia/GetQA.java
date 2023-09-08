/** Get Question and Answer Class */

import java.util.*;
import java.io.*;

public class GetQA{

   private QuestionType<Question> green, yellow, red, blue;
   private String version;

   public GetQA(String version){
   
   version = version.replaceAll(" ", "");
   this.version = version;
   System.out.println(version);
   /** Creates QuestionType stacks */
      green = new QuestionType<Question>();
      yellow = new QuestionType<Question>();
      red = new QuestionType<Question>();
      blue = new QuestionType<Question>();
   
   /** initilizes the green deck of cards */
      try{
         Scanner scanFile = new Scanner(new File("src/GameQuestions/" + version + "GreenQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 0);
            green.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
    
    /** initilizes the yellow deck of cards */  
      try{
         Scanner scanFile = new Scanner(new File("src/GameQuestions/" + version + "YellowQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 1);
            yellow.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
      
    /** initilizes the red deck of cards */
      try{
         Scanner scanFile = new Scanner(new File("src/GameQuestions/" + version + "RedQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 2);
            red.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
    
    /** initilizes the blue deck of cards */
      try{
         Scanner scanFile = new Scanner(new File("src/GameQuestions/" + version + "BlueQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 3);
            blue.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
     
     /** Shuffles Cards */
      green.shuffle();
      yellow.shuffle();
      red.shuffle();
      blue.shuffle();
   }

/********************** Getter methods **********************/   
//Green Question Getter
   public String[] getGreen(){
      String[] qA = new String[2];
      qA[0] = green.peek().getQuestion();
      qA[1] = green.pop().getAnswer();
      return qA;
   }

//Yellow Question Getter
   public String[] getYellow(){
      String[] qA = new String[2];
      qA[0] = yellow.peek().getQuestion();
      qA[1] = yellow.pop().getAnswer();
      return qA;
   }

//Red Question Getter
   public String[] getRed(){
      String[] qA = new String[2];
      qA[0] = red.peek().getQuestion();
      qA[1] = red.pop().getAnswer();
      return qA;
   }
   
//Blue Question Getter
   public String[] getBlue(){
      String[] qA = new String[2];
      qA[0] = blue.peek().getQuestion();
      qA[1] = blue.pop().getAnswer();
      return qA;
   }
}