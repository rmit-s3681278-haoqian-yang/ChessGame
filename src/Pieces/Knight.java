package Pieces;

import java.awt.*;

import Tables.Cell;

public class Knight extends Piece {


    public Knight(Color c) {
        super(c);
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
	public void ValidCells(Cell[][] C) {
		// TODO Auto-generated method stub
		
	}
}
