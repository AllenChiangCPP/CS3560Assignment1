public class Student {
       private String studentID;
       private String answer; 
       private boolean hasAnswer;
   
       public Student(String studentID) { //student constructor, hasAnswer initially set to false
           this.studentID = studentID;
           this.hasAnswer = false;
       }
   
       public void submitAnswer(String answer) { //set student's answer
           this.answer = answer;
           this.hasAnswer = true;
       }
   
       public String getStudentID() { //getter for studentID
           return studentID;
       }
   
       public String getAnswer() { //getter for answer 
           return answer;
       }

       public boolean hasAnswer() {
              return hasAnswer;
       }
       
       public String getPastAnswer() {
              if (hasAnswer) {
                     return answer;
              }
              else {
                     return null;
              }
       }
       public void updatePreviousAnswer(String newAnswer) {
              if (hasAnswer) {
                     this.answer = newAnswer;
              }
       }
   }
   
