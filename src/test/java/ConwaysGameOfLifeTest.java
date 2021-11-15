import conways.iths.se.ConwaysGameOfLife;
import conways.iths.se.CellState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConwaysGameOfLifeTest {


    @Test
    void currentPositionWithStateAliveShouldReturnALIVE() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();
        CellState cellStateAlive = CellState.ALIVE;
        assertEquals(cellStateAlive, conwaysGameOfLife.isCurrentPositionAlive(1));
    }

    @Test
    void currentPositionWithStateDeadShouldReturnDEAD() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();
        CellState cellStateDead = CellState.DEAD;
        assertEquals(cellStateDead, conwaysGameOfLife.isCurrentPositionAlive(0));
    }

    @Test
    void callingPrintGenerationShouldPrintOutBoard() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        String expected = (
                " .  .  .  .  .  .  .  .  .  . \n" +
                " .  *  *  .  .  .  .  *  .  . \n" +
                " .  .  *  .  .  .  .  .  .  . \n" +
                " .  .  .  .  *  *  .  .  .  . \n" +
                " .  .  .  .  *  *  *  .  .  . \n" +
                " .  .  .  .  .  .  .  .  .  . ");

        assertEquals(expected, conwaysGameOfLife.printGeneration(conwaysGameOfLife.board()));
    }



    @Test
    void boardWithOnlyDeadCellsShouldReturnBoardWithDeadCells() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

    @Test
    void oneLiveCellWithNoLiveNeighboursShouldDie() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

    @Test
    void twoLiveCellsWithNoLiveNeighboursShouldDie() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

    @Test
    void threeLiveCellNeighboursShouldStayAlive() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

    @Test
    void fourLiveCellNeighboursShouldStayAlive() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

    @Test
    void aLiveCellWithMoreThanThreeLiveNeighboursShouldDie() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

    @Test
    void deadCellWithThreeLiveNeighboursIsReborn() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

}
