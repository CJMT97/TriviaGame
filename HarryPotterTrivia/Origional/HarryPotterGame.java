import java.util.*;
import java.io.*;

public class HarryPotterGame{

   private static int[] leftTeam = {10, 8, 6, 4};
   private static int[] rightTeam = {10, 8, 6, 4};
   private static String leftTeamName;
   private static String rightTeamName;

   public void startGame(){
   
      QuestionType<Question> green = new QuestionType<Question>();
      QuestionType<Question> yellow = new QuestionType<Question>();
      QuestionType<Question> red = new QuestionType<Question>();
      QuestionType<Question> blue = new QuestionType<Question>();
   
   /** initilizes the green deck of cards */
      try{
         Scanner scanFile = new Scanner(new File("HarryPotterGreenQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 0);
            green.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
    
    /** initilizes the yellow deck of cards */  
      try{
         Scanner scanFile = new Scanner(new File("HarryPotterYellowQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 1);
            yellow.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
      
    /** initilizes the red deck of cards */
      try{
         Scanner scanFile = new Scanner(new File("HarryPotterRedQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 2);
            red.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
    
    /** initilizes the blue deck of cards */
      try{
         Scanner scanFile = new Scanner(new File("HarryPotterBlueQuestions.txt"));
         while(scanFile.hasNextLine()){
            String s = scanFile.nextLine();
            String[] card = s.split("@");
            Question newQuestion = new Question(card[0], card[1], 3);
            blue.push(newQuestion);            
         }
      }catch(FileNotFoundException e){}
      play(green, yellow, red, blue);
   }
   
   public static void play(QuestionType<Question> green, QuestionType<Question> yellow, QuestionType<Question> red, QuestionType<Question> blue){
   
      shuffle(green, yellow, red, blue);
      
      String c = "";
      while(!c.equals("q")){
      System.out.println("\nPress g for a green card\nPress y for a yellow card\nPress r for a red card\nPress b for a blue card\nPress s for the score");
         Scanner sc = new Scanner(System.in);
         c = sc.next();
         if(c.equals("g") && !green.empty()){
            System.out.println(green.peek().toString());
            displayAnswer(green);
         }
         if(c.equals("y") && !yellow.empty()){
            System.out.println(yellow.peek().toString());
            displayAnswer(yellow);
         }
         if(c.equals("r") && !red.empty()){
            System.out.println(red.peek().toString());
            displayAnswer(red);
         }
         if(c.equals("b") && !blue.empty()){
            System.out.println(blue.peek().toString());
            displayAnswer(blue);
         }
         if(c.equals("s")){
            getScore();
         }
      } 
   }
   
   public static void shuffle(QuestionType<Question> green, QuestionType<Question> yellow, QuestionType<Question> red, QuestionType<Question> blue){
      green.shuffle();
      yellow.shuffle();
      red.shuffle();
      blue.shuffle();
   }
   
   public static void displayAnswer(QuestionType<Question> color){
         Scanner sc = new Scanner(System.in);
         System.out.println("Click enter to display answer.");
         String s = sc.nextLine();
         int index = color.peek().getIndex();
         System.out.println(color.pop().getAnswer() + "\n");
         changeScore(index);
      }  
   
   public static void changeScore(int index){
      Scanner sc = new Scanner(System.in);
      System.out.println("What team number are you?");
      int team = sc.nextInt();
      System.out.println("Press c if the answer was correct else press f");
      String c = sc.next();
      System.out.println(team);
      System.out.println(c + ":");
      if(c.equals("c") && team == 1){
         leftTeam[index] = leftTeam[index]-1;
         System.out.println("Done");
      }
      if(c.equals("c") && team == 2){
         rightTeam[index] = rightTeam[index]-1;
      }
      
         
   }
   
   public static void getScore(){
      System.out.println(leftTeamName + ":");
      int counter = 0;
      for(int n: leftTeam){
         if(counter==0){
            System.out.println(n + " green questions remaining.");
         }
         if(counter==1){
            System.out.println(n + " yellow questions remaining.");
         }
         if(counter==2){
            System.out.println(n + " red questions remaining.");
         }
         if(counter==3){
            System.out.println(n + " blue questions remaining.\n");
         }
         counter++;
      }
      
      System.out.println(rightTeamName + ":");
      int counter2 = 0;
      for(int n: rightTeam){
         if(counter2==0){
            System.out.println(n + " green questions remaining.");
         }
         if(counter2==1){
            System.out.println(n + " yellow questions remaining.");
         }
         if(counter2==2){
            System.out.println(n + " red questions remaining.");
         }
         if(counter2==3){
            System.out.println(n + " blue questions remaining.");
         }
         counter2++;
      }
   
   }
}