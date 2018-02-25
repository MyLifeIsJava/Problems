package leetcode.weeklycontest._73;

public class Escape_The_Ghosts {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int d = Math.abs(target[0]) + Math.abs(target[1]);
        for(int[] g : ghosts){
            if(Math.abs(g[0]-target[0])+Math.abs(g[1]-target[1]) <= d){
                return false;
            }
        }
        return true;
    }
    
}
