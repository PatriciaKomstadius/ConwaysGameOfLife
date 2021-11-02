import conways.iths.se.ConwaysGameOfLife;
import conways.iths.se.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConwaysGameOfLifeTest {


    @Test
    void currentPositionWithStateAliveShouldReturnTrue() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();
        State stateAlive = State.ALIVE;
        assertEquals(stateAlive, conwaysGameOfLife.isCurrentPositionAlive(1));
    }

    @Test
    void currentPositionWithStateDeadShouldReturnFalse() {
        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();
        State stateDead = State.DEAD;
        assertEquals(stateDead, conwaysGameOfLife.isCurrentPositionAlive(0));
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

    //uppdaterat metod då villkoren uppdateras för döda celler - annan lösning?
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

    //uppdaterat metod då villkoren uppdateras för döda celler - annan lösning?
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
