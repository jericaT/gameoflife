package bbc.codingtests.gameoflife.gamestate;

public class GameStateImpl implements GameState {
	private String stringState;
	
    //TODO implement this method such that live cells are represented as a '*' and dead cells are represented by a '.'
    //TODO use newline ('\n') to separate rows
    @Override
    public String toString() {
    	System.out.println("State of Grid: \n" + this.stringState);
     	return this.stringState;
    }

    //TODO implement this constructor to parse an input string and return a new GameStateImpl object representing what you got in the string
    //TODO as above, live cells are '*' and dead cells are '.' Rows are separated by newline ('\n')
    public GameStateImpl(String input) {
    	this.stringState = input;
    	
    }

    //TODO implement this method according to explanation in GameState.java
    public boolean isCellAliveAt(int row, int col) {
        throw new UnsupportedOperationException("Please implement the 'isCellAliveAt' method");
    }

    @Override
    public int getRows() {
        String[] splitInput =  stringState.split("\n");
        int count = 0;
    	for(String line : splitInput){
    		count++;
    	}
    	System.out.print("Rows: " + count + "\n");
    	return count;
    }

    @Override
    public int getCols() {
    	String[] splitInput = stringState.split("\n");
    	int count = splitInput[0].length();
    	System.out.print("Columns: " + count + "\n");
    	return count;
    }
}
