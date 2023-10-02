import java.util.*;

public class VotingService {
       private Question question;
       private Map<String, Integer> answerCounts; 
       private String invalidAnswer;

       //votingService constructor
       public VotingService(Question question, String invalidAnswer){
              this.question = question;
              this.invalidAnswer = invalidAnswer;
              this.answerCounts = new HashMap<>(); //answerCounts hashmap for storing count of the different answers from students
              for(String answer : question.getQOptions()) { //inintial count set to 0 for answerCounts
                     answerCounts.put(answer,0);
              }
       }

       //acceptSubmission method, adds student's submission to answerCounts
       public void acceptSubmission(Student student) {
              String answer = student.getAnswer();
              if (question.getQOptions().contains(answer)) { //check if student's answer is a valid option for hte question, if so add it to answerCOunts hashMap
                     answerCounts.put(answer, answerCounts.get(answer) + 1);
                     //if the student already has an answer, update old answer with the new answer
                     if(student.hasAnswer()) {
                            String previousAnswer = student.getPastAnswer();
                            answerCounts.put(previousAnswer, answerCounts.get(previousAnswer) - 1);
                            student.updatePreviousAnswer(answer);
                     }
              } 
              //else print INVALID ANSWER and set student's answer to empty string
              else { 
                     System.out.println("INVALID ANSWER");
                     student.submitAnswer(invalidAnswer);
              }
       }

       //printResults method, pritns results of answerCounts
       public void printResults() {
              System.out.println("Results for Question: " + question.getQText());
              for (String answer : question.getQOptions()) {
                     System.out.println(answer + " : " + answerCounts.get(answer));
              }
              System.out.println();
       }
}
