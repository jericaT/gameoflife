package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	@Test
	public void testEmptyGrid() {
		String emptyStateInput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		emptyState.loadData();
		assertEquals("An empty grid should stay the same", emptyStateInput, testLife.evolve(emptyState).toString());
	}
	
	@Test
	public void testUnderpopulation() {
		String emptyStateInput = "...\n.**\n...";
		String emptyStateInput2 = "...\n.*.\n.*.";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		GameState emptyState2 = new GameStateImpl(emptyStateInput2);
		emptyState.loadData();
		emptyState2.loadData();
		assertNotSame("An cell with less than two neighbours should die", emptyStateInput, testLife.evolve(emptyState).toString());
		assertNotSame("An cell with less than two neighbours should die", emptyStateInput2, testLife.evolve(emptyState2).toString());
	}
	
	@Test
	public void testOverCrowding() {
		String emptyStateInput = ".*.\n***\n.*.";
		String emptyStateInput2 = "..*\n***\n.*.";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		GameState emptyState2 = new GameStateImpl(emptyStateInput2);
		emptyState.loadData();
		emptyState2.loadData();
		assertNotSame("An cell with more than 3 neighbours should die", emptyStateInput, testLife.evolve(emptyState).toString());
		assertNotSame("An cell with more than 3 neighbours should die", emptyStateInput2, testLife.evolve(emptyState2).toString());
	}
	
	@Test
	public void testSurvival() {
		String emptyStateInput = "...\n***\n.*.";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		emptyState.loadData();
		assertEquals("An cell with 2 or 3 neighbours should live", emptyStateInput, testLife.evolve(emptyState).toString());
	}
	
	@Test
	public void testCreation() {
		String emptyStateInput = "...\n*.*\n.*.";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		emptyState.loadData();
		assertEquals("Cell is created with 3 neighbouring cells", emptyStateInput, testLife.evolve(emptyState).toString());
	}
	
}
