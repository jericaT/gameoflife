package bbc.codingtests.gameoflife.gamestate;

public interface GameState {
	/**
	 * Whether the cell at the given row and column is alive or not Should
	 * return false if the coordinates are outside the grid
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	boolean isCellAliveAt(int row, int col);

	/**
	 * @return Number of rows the game has
	 */
	int getRows();

	/**
	 * @return Number of columns the game has
	 */
	int getCols();

	/**
	 * Loads the data into a char array
	 */
	void loadData();
	
	
	/**
	 * @return Retrieve the current grid of the game
	 */
	char[][] getGrid();
	
	/**
	 * @return Set the contents of the current grid of the game
	 */
	char[][] setGrid(char[][] input);
}
