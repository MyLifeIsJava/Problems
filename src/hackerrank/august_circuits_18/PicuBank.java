package hackerrank.august_circuits_18;

import java.util.Scanner;

/**
 * 
 * 
https://www.hackerearth.com/challenge/competitive/august-circuits-18/algorithm/picu-bank-09e29493/
<pre>
Picu Bank
Max. Marks: 100
You have  dollars with you. You want to put it into a Bank, namely Picu Bank. This bank has a peculiar behavior for interest. Regardless of the Bank deposit amount, every month it adds  dollars to your bank account and this continues till  months. Exaxtly on  months, it adds  dollars  to your bank account. This scanario repeats again in same manner.( i.e on the  month  dollars are added, and so on.. ). Your task is to find out how many months does it take for the dollar amount to reach at least , in the bank account .    

Input:

Input starts with an integer , denoting the number of test cases.  Each case starts with 5 integers  , and  as described in problem statement.

 

Constraints:

 
Output:

For each case of input minimum number of months needed to reach dollar value of at least X in a single line.

Note that the Expected Output feature of Custom Invocation is not supported for this contest. 

SAMPLE INPUT 
2
2 5 4 3 51
2 5 4 3 46
SAMPLE OUTPUT 
11
10
Explanation
</pre>

Status : Success, 100 Marks
 * @author kiransringeri
 * 
 */
public class PicuBank {

  public static void main(String[] args) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(System.in);
      long testCases = scanner.nextLong();
      for(long i=0; i < testCases; i++) {
        long d = scanner.nextLong();
        long a = scanner.nextLong();
        long m = scanner.nextLong();
        long b = scanner.nextLong();
        long x = scanner.nextLong();
        long ans = compute(d, a, m, b, x);
        System.out.println(ans);
      }
    }finally {
      scanner.close();
    }
  }

  private static long compute(long d, long a, long m, long b, long x) {
    long months = 0;
    long totalInterest = x - d;
    long interestInMPlusOneMonth = m*a+b;
    long mPlusOneMonthTimes = totalInterest / interestInMPlusOneMonth;
    long interestInMonths1 = mPlusOneMonthTimes * interestInMPlusOneMonth;
    months = (m + 1) * mPlusOneMonthTimes;
    long remainingInterest = totalInterest - interestInMonths1;
    if(remainingInterest > 0) {
      long remainingMonths = remainingInterest / a;
      months += remainingMonths;
      long remaining = remainingInterest % a;
      if(remaining > 0) {
        months += 1;
      }
    }
    return months;
  }
  
}
