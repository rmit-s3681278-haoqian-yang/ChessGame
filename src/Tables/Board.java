package Tables;

import Pieces.Piece;
import Tables.Players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame implements MouseListener {

   final private Cell[][] AllCells;

   Players playerLib = new Players();
   Player player1;
   Player player2;
   
   
   private Piece PickedPiece;
   
   boolean isPlayer1turn;

    private int Steps = 50;///////////////////////////////////set limit steps of the game

    // public Table.Player player1;
    // public Table.Player player2;





    public Board() {
    	
    	
    	
    	String name1 ="aha";/////////////////
    	String pass1 ="123456";///////////////
    	String name2 = "Oho";/////////////////
    	String pass2 = "123123";///////////////
    	
    playerLib.AddPlayer(name1, pass1);
    playerLib.AddPlayer(name2, pass2);
    	
    	Player p1 = playerLib.Login( name1, pass1);
    	Player p2 = playerLib.Login( name2, pass2);


        JFrame mainWindow = new JFrame("Game Demo");
        mainWindow.setSize(800,600);
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(3);




        Container MainPad = new Container();
        MainPad= getContentPane();
        MainPad.setLayout(new BorderLayout());

        Container BoardPad = new Container();
        BoardPad.setLayout(new GridLayout(6,6));

        JPanel[][] squares = new JPanel[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                squares[i][j] = new JPanel();
                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.BLACK);
                } else {
                    squares[i][j].setBackground(Color.GRAY);
                }

                BoardPad.add(squares[i][j]);
              //  squares[i][j].addActionListener(buttonHandler);/////////////////////////////////////////////////////////
            }

        }

        BoardPad.setSize(600, 600);
      // BoardPad.setResizable(false);
       // MainPad.setComponentZOrder();
        setVisible(true);

        MainPad.add(BoardPad);



        Alliance A1 = new Alliance(p1, Color.BLACK,false);
        Alliance A2 = new Alliance(p2, Color.WHITE,true);

        Piece[] PiecesOfA1 = A1.getPieces();
        Piece[] PiecesOfA2 = A2.getPieces();


        AllCells = new Cell[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                AllCells[i][j] = new Cell(i, j);
            }
        }


        for (int j = 0; j < 6; j++) {
            AllCells[0][j].setPieceOnThisCell(PiecesOfA1[j]);
            AllCells[5][j].setPieceOnThisCell(PiecesOfA2[j]);

        }

        ShowBoard();


    }

    public void paint(Graphics g){

        g.fillRect(100, 100, 400, 400);
        for(int i = 100; i <= 400; i+=100){
            for(int j = 100; j <= 400; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }

        for(int i = 150; i <= 450; i+=100){
            for(int j = 150; j <= 450; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }
    }




    public void ShowBoard() {

        for (int i = 0; i < AllCells.length; i++) {

            for(int j = 0; j<AllCells[i].length;j++){
                System.out.print(AllCells[i][j].ToString()+AllCells[i][j].getXofCell()+";"+AllCells[i][j].getYofCell());/////////////////////////////////////////////////////
            }
        System.out.println();
        }

    }

   
    
   public Cell[][] getAllCells(){
	   return AllCells;
   }
   

   public void resetAllValidBooleans() {
	   for(int i = 0;i<AllCells.length;i++) {
		   for(int j = 0;j<AllCells[i].length;j++) {
			   AllCells[i][j].setInvalidCell();
		   }
	   }
   }
    
   public void moveRookValid(int fromRow, int fromCol) {
		// Check upwards.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			if (this.AllCells[toRow][fromCol].getPiece() == null) {
				this.AllCells[toRow][fromCol].setValidCell();
			}
		}
		// Check downwards.
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			if (this.AllCells[toRow][fromCol].getPiece() == null) {
				this.AllCells[toRow][fromCol].setValidCell();
			}
		}
		// Check left.
		for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
			if (this.AllCells[fromRow][toCol].getPiece() == null) {
				this.AllCells[fromRow][toCol].setValidCell();
			}
		}
		// Check right.
		for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
			if (this.AllCells[fromRow][toCol].getPiece() == null) {
				this.AllCells[fromRow][toCol].setValidCell();
			}
		}
	}
	
	public void moveBishopValid(int fromRow, int fromCol) {
		// Check top-left.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				}
			}
		}
		// Check top-right.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				}
			}
		}
		// Check bottom-left
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				}
			}
		}
		// Check bottom-right.
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				}
			}
		}
	}


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
