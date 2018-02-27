package leetcode.weeklycontest._73;

public class Escape_The_Ghosts {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
//        The distance (number of moves) the Pacman needs to reach teh target
        int d = Math.abs(target[0]) + Math.abs(target[1]);
        for(int[] g : ghosts){
//            The number of moves the Ghost needs to reach the Pacman
            if(Math.abs(g[0]-target[0])+Math.abs(g[1]-target[1]) <= d){
                return false;
            }
        }
        return true;
    }
    
}
