package codility.prefixsums;

import java.util.Arrays;

public class GenomicRangeQuery {

  public static void main(String[] args) {
    int[] result = null;
    
//    result = solution("A", new int[] {0}, new int[] {0});
//    System.out.println(Arrays.toString(result));

    result = solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6});
    System.out.println(Arrays.toString(result));
    
//    result = solution("AC", new int[] {0,0,1}, new int[] {0,1,1});
//    System.out.println(Arrays.toString(result));
  }

  public static int[] solution(String S, int[] P, int[] Q) {
    // We will maintain separate prefix sums for each DNA type (A, C, G, T)
    int n = S.length();
    int[] countsOfA = new int[n];
    int[] countsOfC = new int[n];
    int[] countsOfG = new int[n];
    int[] countsOfT = new int[n];
    int[] dnaSeq = new int[n];

    for (int i = 0; i < n; i++) {
      char c = S.charAt(i);
      int[] currArray = null;
      switch (c) {
        case 'A':
          currArray = countsOfA;
          dnaSeq[i] = 1;
          break;
        case 'C':
          currArray = countsOfC;
          dnaSeq[i] = 2;
          break;
        case 'G':
          currArray = countsOfG;
          dnaSeq[i] = 3;
          break;
        case 'T':
          currArray = countsOfT;
          dnaSeq[i] = 4;
          break;
      }
      if (i > 0) {
        countsOfA[i] = countsOfA[i - 1];
        countsOfC[i] = countsOfC[i - 1];
        countsOfG[i] = countsOfG[i - 1];
        countsOfT[i] = countsOfT[i - 1];
      }
      currArray[i] = currArray[i] + 1;
    }

//    System.out.println(Arrays.toString(dnaSeq));
//    System.out.println(Arrays.toString(countsOfA));
//    System.out.println(Arrays.toString(countsOfC));
//    System.out.println(Arrays.toString(countsOfG));
//    System.out.println(Arrays.toString(countsOfT));
    
    int k = P.length;
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      if ((countsOfA[Q[i]] - countsOfA[P[i]]) > 0 || dnaSeq[P[i]]==1) {
        // There are some A's in this range
        result[i] = 1;
      } else if (countsOfC[Q[i]] - countsOfC[P[i]] > 0 || dnaSeq[P[i]]==2) {
        // There are some C's in this range
        result[i] = 2;
      } else if (countsOfG[Q[i]] - countsOfG[P[i]] > 0 || dnaSeq[P[i]]==3) {
        // There are some G's in this range
        result[i] = 3;
      } else {
        // There has to be some T's in this range when we reach here
        result[i] = 4;
      }
//      System.out.println(P[i]+","+ Q[i]+"="+result[i]);
    }

    return result;
  }
}
