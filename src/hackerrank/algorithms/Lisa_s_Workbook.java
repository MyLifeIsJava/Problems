package hackerrank.algorithms;

import java.util.Scanner;

public class Lisa_s_Workbook {

    static int workbook(int n, int k, int[] arr) {
        int specialProblems = 0;
        if(n > 0) {
            int prevPage = 0;
            for(int chapter=1; chapter <= n; chapter++) {
                int chapterProblems = arr[chapter-1];
                int pagesPerChapter = chapterProblems / k;
                if(chapterProblems % k > 0)
                    pagesPerChapter ++;
                for(int l=1; l <= pagesPerChapter; l++) {
                    int currPage = prevPage + l;
                    int pageFirstProblem = 1 + (l-1) * k;
                    int pageLastProblem = Math.min(k * l, chapterProblems);
                    if(currPage >= pageFirstProblem && currPage <= pageLastProblem)
                        specialProblems ++;
                }
                prevPage += pagesPerChapter;
            }
        }
        return specialProblems;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = workbook(n, k, arr);
        System.out.println(result);
        in.close();
    }

}
