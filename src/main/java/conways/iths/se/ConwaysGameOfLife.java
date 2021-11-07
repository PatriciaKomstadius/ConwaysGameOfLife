package conways.iths.se;

public class ConwaysGameOfLife {

    private final BoardPrinter boardPrinter = new BoardPrinter();
    private int[][] nextGenBoard;
    private int row;
    private int column;
    private static final ConwaysGameOfLife gol = new ConwaysGameOfLife();


    public static void main(String[] args) {


        System.out.println("----------- FIRST GENERATION ----------");

        gol.printGeneration(gol.board());

        System.out.println("----------- SECOND GENERATION ----------");

        gol.printGeneration(gol.nextGeneration(gol.board()));

    }

    public int[][] board() {

        int[][] initialBoard = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        return initialBoard;
    }




    public int[][] nextGeneration(int[][] board) {

        nextGenBoard = new int[board.length][board[0].length];

        for (row = 1; row < board.length - 1; row++)
            for (column = 1; column < board[0].length - 1; column++) {

                int neighboursAlive = 0;

                for (int i = -1; i <= 1; i++)
                    for (int k = -1; k <= 1; k++) neighboursAlive += board[row + i][column + k];
                neighboursAlive -= board[row][column];

                calculateCellsForNextGeneration(board, neighboursAlive);
            }

        return nextGenBoard;
    }

    private void calculateCellsForNextGeneration(int[][] board, int neighboursAlive) {

        State state = isCurrentPositionAlive(board[row][column]);

        int THREE_ALIVE_NEIGHBOURS = 3;
        int ONE_ALIVE_NEIGHBOUR = 1;

        if (state == State.ALIVE && neighboursAlive <= ONE_ALIVE_NEIGHBOUR || state == State.ALIVE && neighboursAlive > THREE_ALIVE_NEIGHBOURS) {
            nextGenBoard[row][column] = 0;
        } else if (state == State.DEAD && neighboursAlive == THREE_ALIVE_NEIGHBOURS) {
            nextGenBoard[row][column] = 1;
        } else {
            nextGenBoard[row][column] = board[row][column];
        }
    }

    public State isCurrentPositionAlive(int currentPositionValue) {
        if (currentPositionValue == 1) return State.ALIVE;
        else return State.DEAD;
    }

    public String printGeneration(int [][] printThisBoard) {

        return boardPrinter.printGeneration(printThisBoard);
    }

}
