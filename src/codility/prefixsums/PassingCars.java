package codility.prefixsums;

public class PassingCars {

  public static void main(String[] args) {
    System.out.println(solution(new int[] {0,1,0,1,1}));
  }

  public static int solution(int[] A) {
    int limit = 1000000000;
    int passingCars = 0;
    int n = A.length;
    int cars2east = 0;
    for(int i=0; i < n; i++) {
      if(A[i] == 1) {
//        This car is traveling to west
//        We can pair this car with 'cars2east' cars
        passingCars += cars2east;
        if(passingCars > limit) {
          passingCars = -1;
          break;
        }
      }
      else {
//        This car is traveling to east
        cars2east ++;
      }
    }
    return passingCars;
  }
}
