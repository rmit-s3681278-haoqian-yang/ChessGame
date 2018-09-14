package Tables;

import Pieces.Bishop;
import Pieces.Knight;
import Pieces.Piece;
import Pieces.Rook;
import Tables.Player;

import java.awt.*;

public class Alliance {


    public Player player;
    public Piece[] pieces;

    public Alliance(Player p1, Color color, boolean i,Board board){////////////////////////////////

        this.player = p1;
        pieces = new Piece[6];
        pieces[0]= new Rook(board);
        pieces[1]= new Bishop(board);
        pieces[2]= new Knight(board);
        pieces[3]= new Knight(board);
        pieces[4]= new Bishop(board);
        pieces[5]= new Rook(board);
        if(i){////////////////////////////////////////////////////////////////////////////
            for(int k = 0;k<pieces.length;k++){//////////////////////////////////////////
                pieces[k].NameUpper();///////////////////////////////////////////////////
            }
        }
    }

    public Piece[] getPieces(){
        return pieces;
    }
}
