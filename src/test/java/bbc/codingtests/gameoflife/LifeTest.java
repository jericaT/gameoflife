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
