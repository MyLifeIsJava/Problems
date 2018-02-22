package interviewbit;

import java.util.Arrays;
import java.util.List;

public class Noble_Integer {
    public static void main(String[] args) {
        try {
            Noble_Integer test = new Noble_Integer();
            Integer []array = {5, 6, 2};
            System.out.println(test.solve(Arrays.asList(array)));
        }catch(Throwable th) {
            th.printStackTrace();
        }
    }
    
    public int solve(List<Integer> A) {
        for(int i=0; i < A.size(); i++) {
            if(A.get(i) + 1 <= A.size()) {
                int count = 0;
                for(int k=0; k < A.size(); k++) {
                    if(A.get(k) > A.get(i))
                        count ++;
                }
                if(count == A.get(i)) {
                    return 1;
                }
            }
        }
        return -1;
    }
}
