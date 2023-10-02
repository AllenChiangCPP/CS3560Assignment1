import java.util.*;

public class SimulationDriver {
       public static void main(String[] args) {
              //Create first question and run voting service, true and false
              Question TFQuestion = new Question("Java is a programming language. T/F", true);
              VotingService votingService = new VotingService(TFQuestion, "Invalid");

              //Create first question and run voting service, multiple choice
              Question ABCDQuestion = new Question("Which of the following is not a programming language?\nA: java\nB: python\nC: C++\nD: Bips\n", false);
              VotingService votingService2 = new VotingService(ABCDQuestion, "Invalid");

              //set number of students to 30 and create instance of class random
              int studentCount = 30;
              Random random = new Random();

              //for loop for simulating student submisions for the true or false question, prints results afterwards
              for (int i = 1; i <= studentCount; i++) {
                     Student student = new Student("Student" + i);
                     String randomAnswer = TFQuestion.getQOptions().get(random.nextInt(TFQuestion.getSelectionCount())); // Randomly select "True" or "False"
                     student.submitAnswer(randomAnswer);
                     votingService.acceptSubmission(student);
              }
              votingService.printResults();

              //for loop for simulating student submisions for the multiple choice question, prints results afterwards
              for (int i = 1; i <= studentCount; i++) {
                     Student student = new Student("Student" + i);
                     String randomAnswer = ABCDQuestion.getQOptions().get(random.nextInt(ABCDQuestion.getSelectionCount())); // Randomly select "True" or "False"
                     student.submitAnswer(randomAnswer);
                     votingService2.acceptSubmission(student);
              }
              votingService2.printResults();
       }
}
