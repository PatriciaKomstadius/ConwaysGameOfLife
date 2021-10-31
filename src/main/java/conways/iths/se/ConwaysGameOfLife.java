package conways.iths.se;

public class ConwaysGameOfLife {


    public boolean isCurrentPositionAlive(int currentPositionValue) {

        if (currentPositionValue == 1) return true;
        else return false;
    }

    public int[][] nextGeneration(int[][] board) {

        int[][] nextGenBoard = new int[board.length][board[0].length];

        for (int row = 1; row < board.length - 1; row++) {
            for (int column = 1; column < board[0].length - 1; column++) {

                int neighboursAlive = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int k = -1; k <= 1; k++) {
                        neighboursAlive += board[row + i][column + k];
                    }
                }
                neighboursAlive -= board[row][column];

                boolean alive = isCurrentPositionAlive(board[row][column]);

                if (alive && neighboursAlive <= 1) nextGenBoard[row][column] = 0;
                else if (alive && neighboursAlive == 2) nextGenBoard[row][column] = 1;
                else nextGenBoard[row][column] = board[row][column];
            }
        }
        return nextGenBoard;
    }

}
