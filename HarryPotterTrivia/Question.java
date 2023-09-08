public class Question{

   private String question;
   private String answer;
   private int arrayIndex;

   public Question(String question, String answer, int arrayIndex){
      this.question = question;
      this.answer = answer;
      this.arrayIndex = arrayIndex;
   }

   public String getQuestion(){
      return question;
   }
   
   public String getAnswer(){
      return answer;
   }
   
   public int getIndex(){
      return arrayIndex;
   }
   
   public String toString(){
      String s = "*";
      return s.repeat(question.length()) + "\n" + question + "\n" + s.repeat(question.length()) + "\n";
   }

}