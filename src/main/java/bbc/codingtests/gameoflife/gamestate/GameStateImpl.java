package bbc.codingtests.gameoflife.gamestate;

public class GameStateImpl implements GameState {
	private String stringState;
	private char[][] grid;
	
    public char[][] getGrid(){
    	return this.grid;
    }
    
    @Override
    public char[][] setGrid(char[][] input){
    	return input = this.grid;
    }
	
    @Override
    public String toString() {
    	StringBuilder build = new StringBuilder();
    	
    	int check = 0;
    	
        for(int i = 0; i < getRows(); i++){
        	for(int j = 0; j < getCols(); j++){
        		build.append(grid[i][j]);
        		
        	}
        	if(check != getRows()-1){
        		build.append("\n");
            	check++;
        	}
        	
        }
        
     	return build.toString();
    }


    public GameStateImpl(String input) {
    	this.stringState = input;
    	
    }

    public boolean isCellAliveAt(int row, int col) {
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
