package conways.iths.se;

public class ConwaysGameOfLife {

    private final BoardPrinter boardPrinter = new BoardPrinter();
    private int[][] nextGenBoard;
    private int row;
    private int column;

    public static void main(String[] args) {

        ConwaysGameOfLife gol = new ConwaysGameOfLife();

        System.out.println("\n----------- FIRST GENERATION ----------");

        gol.printGeneration(gol.board());

        System.out.println("\n----------- SECOND GENERATION ----------");

        gol.printGeneration(gol.nextGeneration(gol.board()));

    }

    public int[][] board() {

        return new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }


    public int[][] nextGeneration(int[][] board) {

        nextGenBoard = new int[board.length][board[0].length];

        for (row = 1; row < board.length - 1; row++)
            for (column = 1; column < board[0].length - 1; column++) {

                int neighboursAlive = 0;

                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        neighboursAlive += board[row + i][column + j];
                neighboursAlive -= board[row][column];

                calculateCellsForNextGeneration(board, neighboursAlive);
            }

        return nextGenBoard;
    }

    private void calculateCellsForNextGeneration(int[][] board, int neighboursAlive) {

        State state = isCurrentPositionAlive(board[row][column]);

        if (((state == State.ALIVE) && isFewerThanTwo(neighboursAlive)) || ((state == State.ALIVE) && isMoreThanThree(neighboursAlive))) {
            nextGenBoard[row][column] = 0;
        } else if ((state == State.DEAD) && isThreeAliveNeighbours(neighboursAlive)) {
            nextGenBoard[row][column] = 1;
        } else {
            nextGenBoard[row][column] = board[row][column];
        }
    }

    private boolean isThreeAliveNeighbours(int neighboursAlive) {
        return neighboursAlive == 3;
    }

    private boolean isMoreThanThree(int neighboursAlive) {
        return neighboursAlive > 3;
    }

    private boolean isFewerThanTwo(int neighboursAlive) {
        return neighboursAlive <= 1;
    }

    public State isCurrentPositionAlive(int currentPositionValue) {
        if (currentPositionValue == 1) return State.ALIVE;
        else return State.DEAD;
    }

    public String printGeneration(int[][] printThisBoard) {

        return boardPrinter.printer(printThisBoard);
    }

}
