package Tables;

import Pieces.Bishop;
import Pieces.Knight;
import Pieces.Piece;
import Pieces.Rook;
import Tables.Players.Player;

import java.awt.*;

public class Alliance {


    public Player player;
    public Piece[] pieces;

    public Alliance(Player p1, Color color, boolean i){////////////////////////////////

        this.player = p1;
        pieces = new Piece[6];
        pieces[0]= new Rook(color);
        pieces[1]= new Bishop(color);
        pieces[2]= new Knight(color);
        pieces[3]= new Knight(color);
        pieces[4]= new Bishop(color);
        pieces[5]= new Rook(color);
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
