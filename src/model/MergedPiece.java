package model;

import javafx.scene.image.Image;

public class MergedPiece extends Piece {


    public MergedPiece(int a, int b, boolean isWhitePiece) {
        super(a, b, isWhitePiece);

        if (isWhitePiece) {
            this.icon = new Image(getClass().getResourceAsStream("/pic/icon/w_merge.png"));
            name = " m ";
        } else {
            this.icon = new Image(getClass().getResourceAsStream("/pic/icon/b_merge.png"));
            name = " M ";
        }
    }

    public MergedPiece(boolean isWhitePiece1){
        if (isWhitePiece1) {
            this.icon = new Image(getClass().getResourceAsStream("/pic/icon/w_merge.png"));
            name = " m ";
        } else {
            this.icon = new Image(getClass().getResourceAsStream("/pic/icon/b_merge.png"));
            name = " M ";
        }
    }

    @Override
    public boolean canMove(int row, int col, Board board) {
        return false;
    }
}
