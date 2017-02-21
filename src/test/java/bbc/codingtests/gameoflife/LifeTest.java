package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	@Test
	public void testEmptyGrid() {
		String stateInput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState state = new GameStateImpl(stateInput);
		state.loadData();
		assertEquals("An empty grid should stay the same", stateInput, testLife.evolve(state).toString());
	}
	
	@Test
	public void testOne() {
		String stateInput = "...\n.*.\n...";

		Life testLife = new LifeImpl();
		GameState state = new GameStateImpl(stateInput);
		state.loadData();
		assertNotSame("An grid with one cell should die", stateInput, testLife.evolve(state).toString());
	}
	
	@Test
	public void testUnderpopulation() {
		String stateInput = "...\n.**\n...";
		String stateInput2 = "...\n.*.\n.*.";

		Life testLife = new LifeImpl();
		GameState state = new GameStateImpl(stateInput);
		GameState state2 = new GameStateImpl(stateInput2);
		state.loadData();
		state2.loadData();
		assertNotSame("An cell with less than two neighbours should die", stateInput, testLife.evolve(state).toString());
		assertNotSame("An cell with less than two neighbours should die", stateInput2, testLife.evolve(state2).toString());
	}
	
	@Test
	public void testOverCrowding() {
		String stateInput = ".*.\n***\n.*.";
		String stateInput2 = "..*\n***\n.*.";

		Life testLife = new LifeImpl();
		GameState state = new GameStateImpl(stateInput);
		GameState state2 = new GameStateImpl(stateInput2);
		state.loadData();
		state2.loadData();
		assertNotSame("An cell with more than 3 neighbours should die", stateInput, testLife.evolve(state).toString());
		assertNotSame("An cell with more than 3 neighbours should die", stateInput2, testLife.evolve(state2).toString());
	}
	
	@Test
	public void testSurvival() {
		String stateInput = "...\n***\n.*.";

		Life testLife = new LifeImpl();
		GameState state = new GameStateImpl(stateInput);
		state.loadData();
		assertEquals("An cell with 2 or 3 neighbours should live", stateInput, testLife.evolve(state).toString());
	}
	
	@Test
	public void testCreation() {
		String stateInput = "...\n*.*\n.*.";

		Life testLife = new LifeImpl();
		GameState state = new GameStateImpl(stateInput);
		state.loadData();
		assertEquals("Cell is created with 3 neighbouring cells", stateInput, testLife.evolve(state).toString());
	}
	
	@Test
	public void testGridSize() {
		String stateInput = "...\n...\n...\n...";
		String stateInput2 = "....\n.***\n....";

		Life testLife = new LifeImpl();
		GameState state = new GameStateImpl(stateInput);
		GameState state2 = new GameStateImpl(stateInput2);
		state.loadData();
		state2.loadData();
		assertEquals("Different grid sizes should still work", stateInput, testLife.evolve(state).toString());
		assertEquals("Different grid sizes should still work", stateInput2, testLife.evolve(state2).toString());
	}
	
}
