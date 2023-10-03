import java.util.*;

public class VotingService {
    private Question question;
    private Map<String, String> studentAnswers; //Map that maps student ids to their answers
    private String invalidAnswer;

    //votingService constructor
    public VotingService(Question question, String invalidAnswer) {
        this.question = question;
        this.invalidAnswer = invalidAnswer;
        this.studentAnswers = new HashMap<>();
    }

    //acceptSubmission method, adds student's student id and submission to answerCounts
    public void acceptSubmission(Student student) {
        String studentId = student.getStudentID();
        String answer = student.getAnswer();
        if (question.getQOptions().contains(answer)) { //Check if the student's answer is valid
            //Check if the student has previously submitted an answer
            if (studentAnswers.containsKey(studentId)) { //check if student has already submitted an answer, if so replace previous answer with the new answer
                String previousAnswer = studentAnswers.get(studentId);
                if (!previousAnswer.equals(answer)) {
                    studentAnswers.put(studentId, answer);
                }
            } else {
                //Increment the count of the new answer by adding student id and submission to studentAnswers
                studentAnswers.put(studentId, answer);
            }
        } else { //if an error occurs, prints invalidAnswer message 
            System.out.println(invalidAnswer);
        }
    }

    //printResults method, prints results of answerCounts
    public void printResults() {
        System.out.println("Results for Question: " + question.getQText());
        //Count the number of answers
        Map<String, Integer> answerCounts = new HashMap<>();
        for (String answer : studentAnswers.values()) {
            answerCounts.put(answer, answerCounts.getOrDefault(answer, 0) + 1);
        }

        //Print the counts
        for (String answer : answerCounts.keySet()) {
            System.out.println(answer + " : " + answerCounts.get(answer));
        }
        System.out.println();
    }
}