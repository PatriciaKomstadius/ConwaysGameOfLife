package conways.iths.se;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConwaysGameOfLife {

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

    public State isCurrentPositionAlive(int currentPositionValue) {
        if (currentPositionValue == 1) return State.ALIVE;
        else return State.DEAD;
    }

    private void calculateNextGeneration(int[][] board, int neighboursAlive) {

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

    public int[][] nextGeneration(int[][] board) {

        nextGenBoard = new int[board.length][board[0].length];

        for (row = 1; row < board.length - 1; row++)
            for (column = 1; column < board[0].length - 1; column++) {

                int neighboursAlive = 0;

                for (int i = -1; i <= 1; i++)
                    for (int k = -1; k <= 1; k++) neighboursAlive += board[row + i][column + k];
                neighboursAlive -= board[row][column];

                calculateNextGeneration(board, neighboursAlive);
            }

        return nextGenBoard;
    }

    public String printGeneration(int [][] printThisBoard) {

        String printBoard = Arrays
                .stream(printThisBoard)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        if (printBoard.contains("1"))
            printBoard = printBoard.replace("1", "*");


        if (printBoard.contains("0"))
            printBoard = printBoard.replace("0", ".");


        if (printBoard.contains(",") || printBoard.contains("[") || printBoard.contains("]")) {
            printBoard = printBoard.replace(",", " ");
            printBoard = printBoard.replace("[", " ");
            printBoard = printBoard.replace("]", " ");
        }

        System.out.println(printBoard);

        return printBoard;
    }

}
