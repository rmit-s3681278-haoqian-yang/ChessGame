package Pieces;
import java.awt.*;
import java.util.ArrayList;

import Tables.Board;
import Tables.Cell;

public class Bishop extends Piece {


    public Bishop(Color c) {
        super(c);
        NameOfPiece =" b ";
    }
    
    

    @Override
    public void Move(int x, int y) {
    	
//    	if(Xs-2==x&&COL+2==y) {//Left up 2 blocks
////    		if(x+1==Xs-1&&y-1==Ys+1) {//if one block is on the way
////    			
////    		}
//    	
//    	
//    	
//    	
//    	}
//    	
//    	else if(Xs+2==x&&COL+2==y) {//Right up 2 blocks
////    		if(x-1==Xs+1&&y-1==Ys+1) {//same as above
////    			
////    		}
//    	
//    	
//    	
//    	}
//    	
//    	else if(Xs-2==x&&COL-2==y) {//Left down 2 blocks
////    		if(x+1==Xs-1&&y-1==Ys-1) {//same as above
////    			
////    		}
//    	
//    	
//    	}
//    	
//    	else if(Xs+2==x&&COL-2==y) {//Right down 2 blocks
////    		if(x-1==Xs+1&&y+1==Ys-1) {
////    			
////    		}
//    	
//    	
//    	}
//    	
//Cell leftup = new Cell(Xs-2,COL+2);
//
//Cell leftdown = new Cell(Xs-2,COL-2);
//
//Cell rightup = new Cell(Xs+2,COL+2);
//
//Cell rightdown = new Cell(Xs+2,COL-2);
//
//
    }


    public boolean MoveTo(Cell c) {
    	Board B = new Board();
    	boolean k = false;
    	if(c.isValidCell()) {
    		c.setPieceOnThisCell(this);
    		this.ROW = c.getXofCell();
    		this.COL = c.getYofCell();
    		
    	B.resetAllValidBooleans();
    	k= true;
    	}
    return k;
       
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
		
//		ArrayList<Cell> a = new ArrayList<>();
		
		int left1 = ROW-1;
		int right1 = ROW+1;
		int left2 = ROW-2;
		int right2 = ROW+2;
		
		int up1 = COL+1;
		int up2 = COL+2;
		int down1 = COL-1;
		int down2 = COL-2;
		
		
		
		C[left1][up1].setValidCell();
		
		C[right1][up1].setValidCell();
		
		C[left1][down1].setValidCell();
		
		C[right1][down1].setValidCell();
		
		if(C[left1][up1].isEmpty()) {
			C[left2][up2].setValidCell();
		}
		
		if(C[right1][up1].isEmpty()) {
			C[right2][up2].setValidCell();
		}
		
		if(C[left1][down1].isEmpty()) {
			C[left2][down2].setValidCell();
		}
		
		if(C[right1][down1].isEmpty()) {
			C[right2][down2].setValidCell();
		}
		
//		a.add(new Cell(Xs-1,Ys+1));
//		a.add(new Cell(Xs+1,Ys+1));
//		a.add(new Cell(Xs-1,Ys-1));
//		a.add(new Cell(Xs+1,Ys-1));
//		
//		a.add(new Cell(Xs-2,Ys+2));//left up
//		a.add(new Cell(Xs+2,Ys+2));//right up
//		a.add(new Cell(Xs-2,Ys-2));//left down
//		a.add(new Cell(Xs+2,Ys-2));//right down
//		
//		
//		
//		
//		if(Math.abs(Xs-x)==1&&Math.abs(Ys-y)==1) {
//			
//		}
//		
//		return a;
//		
//		
//		
//		// TODO Auto-generated method stub
//		return null;
	}
	
	
}
