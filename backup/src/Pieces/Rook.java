package Pieces;



import java.awt.*;
import java.util.ArrayList;

import Tables.Board;
import Tables.Cell;

public class Rook extends Piece {


    public Rook(Board board) {
        super(board);
        NameOfPiece =" r ";
    }

    @Override
    public void Move(int x, int y) {
//int[] Xs = {x+2,x+1,x-1,x-2};
//int[] Ys = {y+2,y+1,y-1,y-2};
int DeltaX = ROW -x;
int DeltaY = COL -y;


       //x+1,y ; x+2 ,y; x-1,y; x-2,y;
       //x,y+1;x,y+2;x,y-1;x,y-2;
if(Math.abs(DeltaX)==2 && COL ==y){

}
else if(Math.abs(DeltaX)==1 && COL == y){

}
else if(ROW == x && Math.abs(DeltaY)==1){

}
else if(ROW == x && Math.abs(DeltaY)==2){

}


        ArrayList<Cell> Moves = new ArrayList<>();




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

	@Override
	public boolean CanMove(Cell cell) {
		// TODO Auto-generated method stub
		return false;
	}
}
