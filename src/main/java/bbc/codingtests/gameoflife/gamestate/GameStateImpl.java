package bbc.codingtests.gameoflife.gamestate;

public class GameStateImpl implements GameState {
	private String stringState;
	private char[][] grid;
	
    //TODO implement this method such that live cells are represented as a '*' and dead cells are represented by a '.'
    //TODO use newline ('\n') to separate rows
    @Override
    public String toString() {
    	StringBuilder build = new StringBuilder();
    	loadData();
    	
    	int check = 0;
    	
    	System.out.println("toString:");
        for(int i = 0; i < getRows(); i++){
        	for(int j = 0; j < getCols(); j++){
        		System.out.print("["+grid[i][j]+"]");
        		build.append(grid[i][j]);
        		
        	}
        	System.out.println("");
        	if(check != getRows()-1){
        		build.append("\n");
            	check++;
        	}
        	
        }
        
     	return build.toString();
    }

    //TODO implement this constructor to parse an input string and return a new GameStateImpl object representing what you got in the string
    //TODO as above, live cells are '*' and dead cells are '.' Rows are separated by newline ('\n')
    public GameStateImpl(String input) {
    	this.stringState = input;
    	
    }

    //TODO implement this method according to explanation in GameState.java
    public boolean isCellAliveAt(int row, int col) {
    	loadData();
    	
        if(row < 0 || row > getRows() || col < 0 || col > getRows()){
        	return false;
        }else if(grid[row][col] == '*'){
        	return true;
        }
        return false;
    }
    
    public void loadData() {
    	grid = new char[getRows()][getCols()];
    	String[] splitInput =  stringState.split("\n");
    	
        for(int i = 0; i < getRows(); i++){
        	for(int j = 0; j < getCols(); j++){
        			grid[i][j] = splitInput[i].charAt(j);
        	}
        }
        
        System.out.println("loadData:");
        for(int i = 0; i < getRows(); i++){
        	for(int j = 0; j < getCols(); j++){
        		  System.out.print(grid[i][j]);
        	}
        	System.out.println("");
        }
    }

    @Override
    public int getRows() {
        String[] splitInput =  stringState.split("\n");
    	int rows = splitInput.length;
    	return rows;
    }

    @Override
    public int getCols() {
    	String[] splitInput = stringState.split("\n");
    	int cols = splitInput[0].length();
    	return cols;
    }
}
