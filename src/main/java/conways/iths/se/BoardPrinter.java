package conways.iths.se;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BoardPrinter {

    public BoardPrinter() {
    }

    public String printer(int[][] board) {

        String printBoard = Arrays
                .stream(board)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        printBoard = printAliveCell(printBoard);

        printBoard = printDeadCell(printBoard);

        printBoard = printBoardDetails(printBoard);

        System.out.println(printBoard);

        return printBoard;
    }

    private String printBoardDetails(String printBoard) {
        if (printBoard.contains(",") || printBoard.contains("[") || printBoard.contains("]")) {
            printBoard = printBoard.replace(",", " ");
            printBoard = printBoard.replace("[", " ");
            printBoard = printBoard.replace("]", " ");
        }
        return printBoard;
    }

    public String printDeadCell(String printBoard) {
        if (printBoard.contains("0"))
            printBoard = printBoard.replace("0", ".");
        return printBoard;
    }

    public String printAliveCell(String printBoard) {
        if (printBoard.contains("1"))
            printBoard = printBoard.replace("1", "*");
        return printBoard;
    }
}