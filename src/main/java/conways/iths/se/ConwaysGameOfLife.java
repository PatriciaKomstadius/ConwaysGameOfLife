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

                int neighboursAlive = countNeighbours(board);

                calculateCellsForNextGeneration(board, neighboursAlive);
            }

        return nextGenBoard;
    }

    private int countNeighbours(int[][] board) {
        int neighboursAlive = 0;

        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                neighboursAlive += board[row + i][column + j];
        neighboursAlive -= board[row][column];
        return neighboursAlive;
    }

    private void calculateCellsForNextGeneration(int[][] board, int neighboursAlive) {

        CellState cellState = isCurrentPositionAlive(board[row][column]);

        if (((cellState == CellState.ALIVE) && isUnderpopulated(neighboursAlive)) || ((cellState == CellState.ALIVE) && isOvercrowded(neighboursAlive))) {
            nextGenBoard[row][column] = 0;
        } else if ((cellState == CellState.DEAD) && isReborn(neighboursAlive)) {
            nextGenBoard[row][column] = 1;
        } else {
            nextGenBoard[row][column] = board[row][column];
        }
    }

    private boolean isReborn(int neighboursAlive) {
        return neighboursAlive == 3;
    }

    private boolean isOvercrowded(int neighboursAlive) {
        return neighboursAlive > 3;
    }

    private boolean isUnderpopulated(int neighboursAlive) {
        return neighboursAlive <= 1;
    }

    public CellState isCurrentPositionAlive(int currentPositionValue) {
        if (currentPositionValue == 1) return CellState.ALIVE;
        else return CellState.DEAD;
    }

    public String printGeneration(int[][] printThisBoard) {

        return boardPrinter.printer(printThisBoard);
    }

}
