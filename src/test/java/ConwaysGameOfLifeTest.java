import conways.iths.se.ConwaysGameOfLife;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConwaysGameOfLifeTest {

    @Test
    void currentPositionWithStateAliveShouldReturnTrue() {

        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        assertEquals(true, conwaysGameOfLife.isCurrentPositionAlive(1));
    }

    @Test
    void boardWithOnlyDeadCellsShouldReturnBoardWithDeadCells() {

        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        int [][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int [][] expectedResult = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        assertArrayEquals(expectedResult, conwaysGameOfLife.nextGeneration(board));
    }

    @Test
    void boardWithOneLiveCellAndNoLiveNeighboursShouldReturnBoardWithDeadCells() {

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
    void boardWithTwoLiveCellsShouldReturnBoardWithDeadCells() {
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




}
