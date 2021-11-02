package conways.iths.se;

public class ConwaysGameOfLife {


    private final int ONE_ALIVE_NEIGHBOUR = 1;
    private final int THREE_ALIVE_NEIGHBOURS = 3;

    //changed signature to enum State
    public State isCurrentPositionAlive(int currentPositionValue) {
        if(currentPositionValue == 1) return State.ALIVE;
        else return State.DEAD;
    }

    public int[][] nextGeneration(int[][] board) {

        int[][] nextGenBoard = new int[board.length][board[0].length];

        for (int row = 1; row < board.length - 1; row++)
            for (int column = 1; column < board[0].length - 1; column++) {

                int neighboursAlive = 0;

                for (int i = -1; i <= 1; i++)
                    for (int k = -1; k <= 1; k++) neighboursAlive += board[row + i][column + k];
                neighboursAlive -= board[row][column];

                State state = isCurrentPositionAlive(board[row][column]);

                //extracting magic numbers to field constants
                if (state == State.ALIVE && neighboursAlive <= ONE_ALIVE_NEIGHBOUR || state == State.ALIVE && neighboursAlive > THREE_ALIVE_NEIGHBOURS) {
                    nextGenBoard[row][column] = 0;
                } else if (state == State.DEAD && neighboursAlive == THREE_ALIVE_NEIGHBOURS) {
                    nextGenBoard[row][column] = 1;
                } else {
                    nextGenBoard[row][column] = board[row][column];
                }
            }

        return nextGenBoard;
    }

}
