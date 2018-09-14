package Pieces;

import java.awt.*;

import Tables.Board;
import Tables.Cell;

public class Knight extends Piece {


    public Knight(Board board) {
        super(board);
        NameOfPiece =" k ";
    }

    @Override
    public void Move(int x, int y) {

    }


    public boolean MoveTo(Cell c) {

        return false;
    }

    @Override
    public String PieceName() {
        return NameOfPiece;
    }

    @Override
    public void NameUpper() {
        NameOfPiece = NameOfPiece.toUpperCase();

    }

	@Override
	public void ValidCells(Cell[][] C, int fromRow, int fromCol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean CanMove(Cell cell) {
		// TODO Auto-generated method stub
		return false;
	}
}
