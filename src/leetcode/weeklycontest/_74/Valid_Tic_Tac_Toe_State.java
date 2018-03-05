package leetcode.weeklycontest._74;

public class Valid_Tic_Tac_Toe_State {

    public static void main(String[] args) {
        Valid_Tic_Tac_Toe_State obj = new Valid_Tic_Tac_Toe_State();
//        System.out.println(obj.validTicTacToe(new String[]{"O  ", "   ", "   "}));
//        System.out.println(obj.validTicTacToe(new String[]{"XOX", " X ", "   "}));
//        System.out.println(obj.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
//        System.out.println(obj.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
//        System.out.println(obj.validTicTacToe(new String[]{"   ", "   ", "   "}));
//        System.out.println(obj.validTicTacToe(new String[]{"XXX","XOO","OO "}));
//        System.out.println(obj.validTicTacToe(new String[] {"XOX","OXO","OXX"}));
        System.out.println(obj.validTicTacToe(new String[] {"XOX","OXO","XXO"}));
    }

    public boolean validTicTacToe(String[] board) {
        int xes = 0;
        int oes = 0;
        
        for(int i=0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                if(board[i].charAt(j)=='X') {
                    xes++;
                }
                else if(board[i].charAt(j)=='O') {
                    oes++;
                }
            }
        }
        if(xes == 0 && oes == 0)
            return true;
        if(xes > 0 || oes > 0) {
            if(xes < oes) {
                return false;
            }else {
                int diff = xes - oes;
                if(diff > 1)
                    return false;
            }
        }
        int wins = 0;
        int xWins = 0;
        int yWins = 0;
        for(int i=0; i < 3; i++) {
            if(board[i].charAt(0) != ' ' && board[i].charAt(0)==board[i].charAt(1) && board[i].charAt(0)==board[i].charAt(2)) {
                if(board[i].charAt(0) == 'X')
                    xWins ++;
                else
                    yWins ++;
                wins ++;
            }
            if(board[0].charAt(i) != ' ' && board[0].charAt(i)==board[1].charAt(i) && board[0].charAt(i)==board[2].charAt(i)) {
                if(board[0].charAt(i) == 'X')
                    xWins ++;
                else
                    yWins ++;
                wins ++;
            }
        }
        System.out.println("xWins="+xWins);
        if(board[0].charAt(0) != ' ' && board[0].charAt(0)== board[1].charAt(1) && board[0].charAt(0)==board[2].charAt(2)) {
            if(board[0].charAt(0) == 'X')
                xWins ++;
            else
                yWins ++;
            wins ++;
        }
        System.out.println("xWins="+xWins);
        if(board[2].charAt(0) != ' ' && board[2].charAt(0)== board[1].charAt(1) && board[2].charAt(0)==board[0].charAt(2)) {
            if(board[2].charAt(0) == 'X')
                xWins ++;
            else
                yWins ++;
            wins ++;
        }
        System.out.println("xWins="+xWins+",yWins="+yWins+", xes="+xes+" oes="+oes);
        if(wins > 1)
            return false;
        if(xWins > 0 && oes >= xes)
            return false;
        if(yWins > 0 && xes > oes)
            return false;
        return true;
    }
}
