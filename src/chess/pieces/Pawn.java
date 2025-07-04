package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;

	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColum());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}

			p.setValues(position.getRow() - 2, position.getColum());
			Position p2 = new Position(position.getRow() - 1, position.getColum());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColum()] = true;

			}

			p.setValues(position.getRow() - 1, position.getColum() - 1);
			if (getBoard().positionExists(p) && isThereOppnentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColum() + 1);
			if (getBoard().positionExists(p) && isThereOppnentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}

			// #specialmove en passant white
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColum() - 1);
				if (getBoard().positionExists(left) && isThereOppnentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulerable()) {
					mat[left.getRow() - 1][left.getColum()] = true;
				}
				Position right = new Position(position.getRow(), position.getColum() + 1);
				if (getBoard().positionExists(right) && isThereOppnentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassantVulerable()) {
					mat[right.getRow() - 1][right.getColum()] = true;
				}
			}

		} else {

			p.setValues(position.getRow() + 1, position.getColum());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}

			p.setValues(position.getRow() + 2, position.getColum());
			Position p2 = new Position(position.getRow() + 1, position.getColum());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColum()] = true;

			}

			p.setValues(position.getRow() + 1, position.getColum() - 1);
			if (getBoard().positionExists(p) && isThereOppnentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColum() + 1);
			if (getBoard().positionExists(p) && isThereOppnentPiece(p)) {
				mat[p.getRow()][p.getColum()] = true;
			}

			// Special move enPassant black
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColum() - 1);
				if (getBoard().positionExists(left) && isThereOppnentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulerable()) {
					mat[left.getRow() + 1][left.getColum()] = true;
				}
				Position right = new Position(position.getRow(), position.getColum() + 1);
				if (getBoard().positionExists(right) && isThereOppnentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassantVulerable()) {
					mat[right.getRow() + 1][right.getColum()] = true;
				}
			}

		}

		return mat;
	}

}
