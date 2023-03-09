package COMP9003.Week3;

public class SudokuSolve {

    public static boolean isSolvable(Integer[][] board) {
        //TODO
        int length = board.length;
        int height = board[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == null){
                    continue;
                }
                for (int k = j+1; k < height; k++) {
                    if (board[i][j] == board[i][k])
                        return false;
                }
                for (int k = i+1; k < length; k++) {
                    if (board[i][j] == board[k][j])
                        return false;
                }
                int a = i%3;
                int b = j%3;

                for (int k = i-a; k <= i+2-a ; k++) {
                    for (int l = j-b; l <=j+2-b ; l++) {
                        if (board[i][j] == board[k][l] && (i!=k && j!=l))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Write some tests if you want check here or change b
        Integer[][] b = {
                { 1, 2, 3},
                { 4, 5, 6},
                { 7, 5, 9}
        };
        if(isSolvable(b)) {
            System.out.println("Yes this is solvable!");
        }
    }

}