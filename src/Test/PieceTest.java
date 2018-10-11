package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {


    Table table = new Table();
    Player P1 = new Player("Jill", "123456");
    Player P2 = new Player("Gill", "123123");

    @BeforeEach
    public void setUp() {

        table.LoginPlayerWhite(P1);
        table.LoginPlayerBlack(P2);

        table.checkAndSetReady();
        boolean ready = table.isPlayersReady();

        assertEquals(ready, true);

        table.setUpBoard();

    }


    @Test
    public void test1() {

        printBoard("Print empty board");

        table.getBoard().PutPieceTo(new Rook(0, 0, true), 0, 0);

        printBoard("Print board with white Rook at (0,0)");

        table.getBoard().PutPieceTo(new Rook(5, 0, true), 5, 0);

        printBoard("Print board with white Rooks at (0,0),(5,0)");


    }

    @Test
    public void test2() {


        table.getBoard().PutPieceTo(new Rook(1, 1, true), 1, 1);
        //  table.getBoard().PutPieceTo(new Rook(1,0,true),1,0);
        table.getBoard().PutPieceTo(new Rook(1, 2, true), 1, 2);
        printBoard("Print board with white Rook at (1,1),(1,2)");


    }

    @Test
    public void test3() {


        Rook r1 = new Rook(1, 1, true);
        Rook r2 = new Rook(1, 2, true);

        table.getBoard().PutPieceTo(r1, 1, 1);
        table.getBoard().PutPieceTo(r2, 1, 2);

        printBoard("Print");


        table.getBoard().PutPieceTo(r2, 1, 0);

        r2.setROWandCOL(1, 0);
        table.getBoard().getTileAt(1, 2).clearPiece();

        printBoard("After Move");


    }

    @Test
    public void test4() {

        Rook r1 = new Rook(1, 1, true);
        Rook r2 = new Rook(1, 2, true);

        table.getBoard().PutPieceTo(r1, 1, 1);
        table.getBoard().PutPieceTo(r2, 1, 2);

        printBoard("Print r1@(1,1),r2@(1,2)");

        boolean k = r2.canMove(1, 0, table.getBoard());

        assertEquals(k, false);

    }


    @Test
    public void test5() {

        Rook r1 = new Rook(1, 1, true);
        Rook r2 = new Rook(1, 2, true);

        table.getBoard().PutPieceTo(r1, 1, 1);
        table.getBoard().PutPieceTo(r2, 1, 2);

        printBoard("Print r1@(1,1),r2@(1,2)");

        boolean k = table.getBoard().getTileAt(1, 2).CanMove(1, 0, table.getBoard());

        assertEquals(k, false);


    }

    @Test
    public void test6() {

        Rook r1 = new Rook(1, 1, true);
        Rook r2 = new Rook(1, 2, true);
        Bishop b1 = new Bishop(1, 3, true);

        table.getBoard().PutPieceTo(r1, 1, 1);
        table.getBoard().PutPieceTo(r2, 1, 2);
        table.getBoard().PutPieceTo(b1, 1, 3);

        printBoard("Print r1@(1,1),r2@(1,2)");

        boolean k1 = table.getBoard().getTileAt(1, 2).CanMove(1, 0, table.getBoard());

        assertEquals(k1, false);


        table.getBoard().getTileAt(1, 2).setPiece(b1);

        boolean k2 = table.getBoard().getTileAt(1, 2).CanMove(1, 0, table.getBoard());

        assertEquals(k2, false);


        boolean k3 = table.getBoard().getTileAt(1, 2).CanMove(0, 2, table.getBoard());

        assertEquals(k3, true);

        Piece a = table.getBoard().getTileAt(1,2).getPieceByIndex(1);

        assertEquals(a instanceof Knight,false);
        assertEquals(a instanceof Rook,false);
        assertEquals(a instanceof Bishop,true);

        int ss = table.getBoard().getTileAt(1, 2).getNumsOfMergedPiece();

        assertEquals(ss, 2);


        Bishop b2 = new Bishop(2, 3, false);

        table.getBoard().PutPieceTo(b2, 2, 3);

        printBoard("Capture");

        //      table.getBoard().getTileAt(1,2).setPiece(b2);
        table.getBoard().PutPieceTo(b2, 1, 2);

        printBoard("After");

        printWithValidTile(table.getBoard().getTileAt(1, 2));


        table.getBoard().getTileAt(1, 2).clearPiece();
        table.getBoard().PutPieceTo(b2, 1, 2);
        printBoard("see?");

        table.getBoard().getTileAt(2, 3).clearPiece();

        printBoard("What now?");




    }


    private void printBoard(String s) {
        System.out.println("\n" + s);
        System.out.println("-------Begin------");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

                System.out.print(table.getBoard().getTileAt(i, j).toString());

            }
            System.out.println();
        }

        System.out.println("--------End-------");
    }

    private void printWithValidTile(Tile t) {


        System.out.println("-------Begin------");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (t.CanMove(i, j, table.getBoard())) {
                    System.out.print(" G ");
                } else {
                    System.out.print(table.getBoard().getTileAt(i, j).toString());
                }


            }
            System.out.println();
        }

        System.out.println("--------End-------");


    }
    private void printWithValidTile(Piece p) {


        System.out.println("-------Begin------");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (p.canMove(i, j, table.getBoard())) {
                    System.out.print(" G ");
                } else {
                    System.out.print(table.getBoard().getTileAt(i, j).toString());
                }


            }
            System.out.println();
        }

        System.out.println("--------End-------");


    }
}
