package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char collum, int row) {
		if(collum <'a' || collum > 'h' || row <1 || row >8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from	a1 to h8");
		}
		
		
		this.column = collum;
		this.row = row;
	}

	public char getCollum() {
		return column;
	}


	public int getRow() {
		return row;
	}

	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColum()),8 - position.getRow() );
		
	}
	
	
	@Override
	public String toString() {
		return " " + column + row;
	}
	
}
