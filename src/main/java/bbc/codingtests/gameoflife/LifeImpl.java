package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;

public class LifeImpl implements Life
{
	private char[][] grid;
	private int rows;
	private int cols;
	private char[][] nextGrid;
	
	public GameState evolve(GameState currentState) {
		
		grid = currentState.getGrid();
		rows = currentState.getRows();
		cols = currentState.getCols();
		nextGrid = new char[rows][cols];
		
		for(int i = 0; i < rows; i++ ){
			for(int j = 0; j < cols; j++) {
				if(currentState.isCellAliveAt(i, j) && neighbours(j,i,currentState) < 2) {
					nextGrid[i][j] = '.';
				} else if(currentState.isCellAliveAt(i, j) && neighbours(j,i,currentState) > 3) {
					nextGrid[i][j] = '.';
				} else if(currentState.isCellAliveAt(i, j) && (neighbours(j,i,currentState) == 2 || neighbours(j,i,currentState) == 3)) {
					nextGrid[i][j] = '*';
				} else if(!currentState.isCellAliveAt(i, j) && neighbours(j,i,currentState) == 3) { //checks for cell not alive
					nextGrid[i][j] = '*';
				} else{
					nextGrid[i][j] = '.'; //keep '.' as dead cell
				}
			}
		}
		currentState.setGrid(nextGrid);
	
		return currentState;
	}
	
	//check and count neighbours for specific cell
	public int neighbours(int x, int y, GameState curState) {
		grid = curState.getGrid();
		rows = curState.getRows();
		cols = curState.getCols();
		
		int neighCount = 0;
		
		int iStart;
		if(y > 0) {
			iStart = y-1;
		} else {
			iStart = 0;
		}
		
		int iFinish;
		if(y < rows-1) {
			iFinish = y+1;
		} else {
			iFinish = rows-1;
		}
		
		int jStart;
		if(x > 0) {
			jStart = x-1;
		} else {
			jStart = 0;
		}
		
		int jFinish;
		if(x < cols-1) {
			jFinish = x+1;
		} else {
			jFinish = cols-1;
		}
		
		for(int i = iStart; i <= iFinish; i++) {
			for(int j = jStart; j <= jFinish; j++) {
				neighCount += grid[i][j];
			}
		}
		
		neighCount -= grid[y][x];
		return neighCount;
	}
	
}
