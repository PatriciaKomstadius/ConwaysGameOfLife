import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConwaysGameOfLifeTest {

    @Test
    void currentPositionWithStateAliveShouldReturnTrue() {

        ConwaysGameOfLife conwaysGameOfLife = new ConwaysGameOfLife();

        assertEquals(true, conwaysGameOfLife.isCurrentPositionAlive(1));
    }


}
