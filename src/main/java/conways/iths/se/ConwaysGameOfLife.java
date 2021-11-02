package conways.iths.se;

public class ConwaysGameOfLife {


    private final int ONE_ALIVE_NEIGHBOUR = 1;
    private final int THREE_ALIVE_NEIGHBOURS = 3;

    public boolean isCurrentPositionAlive(int currentPositionValue) {
        return currentPositionValue == 1;
    }

    public int[][] nextGeneration(int[][] board) {

        int[][] nextGenBoard = new int[board.length][board[0].length];

        for (int row = 1; row < board.length - 1; row++)
            for (int column = 1; column < board[0].length - 1; column++) {

                int neighboursAlive = 0;

                for (int i = -1; i <= 1; i++)
                    for (int k = -1; k <= 1; k++) neighboursAlive += board[row + i][column + k];
                neighboursAlive -= board[row][column];

                boolean alive = isCurrentPositionAlive(board[row][column]);

                //extracting magic numbers to field constants
                if (alive && neighboursAlive <= ONE_ALIVE_NEIGHBOUR || alive && neighboursAlive > THREE_ALIVE_NEIGHBOURS) {
                    nextGenBoard[row][column] = 0;
                } else if (!alive && neighboursAlive == THREE_ALIVE_NEIGHBOURS) {
                    nextGenBoard[row][column] = 1;
                } else {
                    nextGenBoard[row][column] = board[row][column];
                }
            }

        return nextGenBoard;
    }

}
