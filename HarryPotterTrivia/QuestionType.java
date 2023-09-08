import java.util.*;

public class QuestionType<E extends Question> implements Stack<E>{

   private SLLNode<E> firstQuestion;
   private int size;

   /** Adds an element to the top of the stack*/
   public void push(E element){
      if(firstQuestion == null){
         firstQuestion = new SLLNode(element, null);
         size++;
      }
      
      else{
         SLLNode<E> temp = new SLLNode(element, firstQuestion);
         firstQuestion = temp;
         size++;
      } 
   }
   
   /** Removes and returns the top element on the stack*/
   public E pop(){
      if(firstQuestion == null){
         return null;
      }
      
      SLLNode<E> temp = firstQuestion;
      firstQuestion = firstQuestion.next;
      size--;
      
      return temp.value;
   }
   
   /** Returns the value of the top element of the stack without removing it*/
   public E peek(){
      if(firstQuestion == null){
         return null;
      }
      return firstQuestion.value;
   }
   
   /** Is this stack empty? */
   public boolean empty(){
      if(firstQuestion == null){
         return true;
      }
      return false;
   }
   
   /** Clears this stack */
   public void clear(){
      size = 0;
      firstQuestion = null;
   }
   
   /** Shuffles array */
   public void shuffle(){
   
   Question[] questions = new Question[this.size];
   int counter1 = 0;  
      while(firstQuestion != null){
         questions[counter1] = firstQuestion.value;
         firstQuestion = firstQuestion.next;
         counter1++;
      }
      
      
      
   Random r = new Random();
   int cardShuffled = questions.length*5;
   int counter2 = 0;
   int high = questions.length;
   while(counter2 < cardShuffled){
      int firstIndex = r.nextInt(high);
      int secondIndex = r.nextInt(high);
      
      Question firstCard = questions[firstIndex];
      Question secondCard = questions[secondIndex];
      
      questions[firstIndex] = secondCard;
      questions[secondIndex] = firstCard;
      
      counter2++;
   }
   
   firstQuestion = new SLLNode(questions[0], null);   
      
   for(int i = 1; i<questions.length; i++){
      SLLNode<E> temp = new SLLNode(questions[i], firstQuestion);
      firstQuestion = temp;
   }
      
   }
   
   /** Creates a node */
   private class SLLNode<E>{
   
      private E value;
      private SLLNode<E> next;
   
      public SLLNode(E value, SLLNode<E> next){
         this.value = value;
         this.next = next;
      }
   }
}
