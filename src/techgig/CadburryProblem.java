package techgig;

/**
 * Problem Statement : https://drive.google.com/open?id=16lVDkGAVxIsoSEhVcmVuCiHL20iy1e5-
 * 
 * Status : Completed
 * 
 * @author kiran
 *
 */
public class CadburryProblem {

    public static void main(String[] args) {
        try {
          long st = System.currentTimeMillis();
          int res = cadburry(1, 1000, 1, 1000);
          long et = System.currentTimeMillis();
          System.out.println(res+" : "+(et-st)+" ms");
      }catch(Throwable th){
          th.printStackTrace();
      }finally {
          
      }
  }

    public static int cadburry(int input1, int input2, int input3, int input4) {
//      Initialize students to ZERO
        int students = 0;
//      Create all possible combinations of cadburry sizes
        for(int i=input1; i <= input2; i++) {
            for(int j=input3; j <= input4; j++) {
//              Find out the minimum of length, breadth
                int min = i;
                int max = j;
                if(j < i) {
                    min = j;
                    max = i;
                }
                int studentsForThisBar = 0;
                while(min > 0) {
//                  How many squares of size min can be cut out from this bar
                    int times = max/min;
//                  And we can distribute those many squares to students
                    studentsForThisBar += times;
//                  Find out the remaining size of the bar
                    int tempMax = max;
                    max = min;
                    min = tempMax - times * min;
                }
                students += studentsForThisBar;
            }
        }
        return students;
    }
}
