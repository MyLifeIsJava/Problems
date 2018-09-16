package job.interview.amazon;

/**
 * Search for an element in unsorted array and return the index if the array were sorted.
 * 
 * Asked at Amazon on 01-Sep-2018
 * 
 * @author kiransringeri
 *
 */
public class FindIndexInUnsortedArray {

  public static void main(String[] args) {
    System.out.println(search(new int[]{3,1,4,3,3,9, 2, 1}, 3));
  }

  private static int search(int []data, int element) {
    int index = -1;
    int displacement = 0;
    boolean found = false;
    for(int i=0; i < data.length; i++) {
      if(!found && data[i] == element) {
        found = true;
        index = i;
      }
      if(!found) {
        if(data[i] > element) {
          displacement --;
        }
      }
      else {
        if(data[i] < element) {
          displacement ++;
        }
      }
    }
    if(!found) {
      return -1;
    }else {
      return index + displacement;
    }
  }
}
