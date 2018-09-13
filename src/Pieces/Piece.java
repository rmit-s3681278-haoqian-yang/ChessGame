package Pieces;

import java.awt.*;
import java.util.ArrayList;

import Tables.Cell;

public abstract class Piece {

    protected int ROW;
    protected int COL;
    

    protected String NameOfPiece;

    protected ArrayList<Cell> ValidCells = new ArrayList<>();

    protected Cell OnWhichCell;

    private Color color;

    public Piece(Color c) {
        this.color = c;
    }


    public abstract void Move(int x, int y);

    public abstract String PieceName();

    public abstract void NameUpper();
    
    public abstract void ValidCells(Cell[][] C);
}
