package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {
	
    @Test
    public void testString() {
        String input = ".*.\n*.*\n...";
        GameState testState = new GameStateImpl(input);
        testState.loadData(); //must load data first
        assertEquals("Should be the same string", input, testState.toString());
    }

    @Test
    public void testParsing() {
        String input = ".*.\n*.*\n...";
        GameState testState = new GameStateImpl(input);
        testState.loadData();
        assertTrue("Row 0, col 1 should be alive",testState.isCellAliveAt(0,1));
        assertFalse("Row 2, col 2 should not be alive",testState.isCellAliveAt(2,2));
        assertFalse("Row 4, col 2 should not be alive",testState.isCellAliveAt(4,2)); //cell is outside grid
    }
    
    @Test
    public void testRowColCounts() {
        String input = "...\n***\n..*\n";
        GameState testState = new GameStateImpl(input);
        testState.loadData();
        assertEquals("The game should have 3 columns", 3, testState.getCols());
        assertEquals("The game should have 3 rows", 3, testState.getRows());
    }
    
}
