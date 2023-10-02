import java.util.List;
public class Question {
       private String qText; //text for the question
       private List<String> qOptions; //possible answers for the question, T, F or A, B, C, D
       private boolean qTF; //bool, if true, question is true false, else multiple choice
       private int selectionCount; //selection count for selecting answers, 2 if T, F, 4, if A, B, C, D

       public Question(String qText, boolean qTF) { //Question constructor 
              this.qText = qText;
              this.qTF = qTF;
              //if qTF true, question is true or false question, else multiple choice, sets qOptions and selectionCount accordingly
              if (qTF) { 
                     this.qOptions = List.of("T", "F");
                     selectionCount = 2;
              }
              else {
                     this.qOptions = List.of("A", "B", "C", "D");
                     selectionCount = 4;
              }
       }

       //QText getter and setter
       public String getQText(){ 
              return qText;
       }

       public void setQText(String qText){
              this.qText = qText;
       }
       
       //QOptions getter
       public List<String> getQOptions() {
              return qOptions;
       }

       //qTF getter 
       public boolean getQTF() {
              return qTF;
       }

       //selectionCount getter and setter
       public int getSelectionCount() {
              return selectionCount;
       }
       public void setSelectionCount(int selectionCount) {
              this.selectionCount = selectionCount;
       }

}
