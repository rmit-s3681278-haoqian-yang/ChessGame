package Tables;

import Pieces.Piece;
import Tables.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame implements MouseListener {

	final private Cell[][] AllCells;

<<<<<<< HEAD

   Player player1;
   Player player2;
   
   
   private Piece PickedPiece;
   
   boolean isPlayer1turn;
=======
	Players playerLib = new Players();
	Player player1;
	Player player2;
>>>>>>> 43dc427d6ac0d20342ab009efd431529ddd2c498

	private Piece PickedPiece;

	boolean isPlayer1turn;

	private int Steps = 50;/////////////////////////////////// set limit steps of the game

	// public Table.Player player1;
	// public Table.Player player2;

	public Board() {

		String name1 = "aha";/////////////////
		String pass1 = "123456";///////////////
		String name2 = "Oho";/////////////////
		String pass2 = "123123";///////////////

<<<<<<< HEAD
    public Board() {
    	
    	
    	
    	String name1 ="aha";/////////////////
    	String pass1 ="123456";///////////////
    	String name2 = "Oho";/////////////////
    	String pass2 = "123123";///////////////
  
    	
    	Player p1 = new Player( name1, pass1);////////////////////
    	Player p2 = new Player( name2, pass2);/////////////////
=======
		playerLib.AddPlayer(name1, pass1);
		playerLib.AddPlayer(name2, pass2);
>>>>>>> 43dc427d6ac0d20342ab009efd431529ddd2c498

		Player p1 = playerLib.Login(name1, pass1);
		Player p2 = playerLib.Login(name2, pass2);

		JFrame mainWindow = new JFrame("Game Demo");
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(3);

		Container MainPad = new Container();
		MainPad = getContentPane();
		MainPad.setLayout(new BorderLayout());

		Container BoardPad = new Container();
		BoardPad.setLayout(new GridLayout(6, 6));

		JPanel[][] squares = new JPanel[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				squares[i][j] = new JPanel();
				if ((i + j) % 2 == 0) {
					squares[i][j].setBackground(Color.BLACK);
				} else {
					squares[i][j].setBackground(Color.GRAY);
				}

<<<<<<< HEAD
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



        Alliance A1 = new Alliance(p1, Color.BLACK,false,this);
        Alliance A2 = new Alliance(p2, Color.WHITE,true,this);

        Piece[] PiecesOfA1 = A1.getPieces();
        Piece[] PiecesOfA2 = A2.getPieces();
=======
				BoardPad.add(squares[i][j]);
				// squares[i][j].addActionListener(buttonHandler);/////////////////////////////////////////////////////////
			}
>>>>>>> 43dc427d6ac0d20342ab009efd431529ddd2c498

		}

		BoardPad.setSize(600, 600);
		// BoardPad.setResizable(false);
		// MainPad.setComponentZOrder();
		setVisible(true);

<<<<<<< HEAD
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                AllCells[i][j] = new Cell(i, j);
            }
        }
//
//
//        for (int j = 0; j < 6; j++) {
//            AllCells[0][j].setPieceOnThisCell(PiecesOfA1[j]);
//            AllCells[5][j].setPieceOnThisCell(PiecesOfA2[j]);
//
//        }
=======
		MainPad.add(BoardPad);

		Alliance A1 = new Alliance(p1, Color.BLACK, false);
		Alliance A2 = new Alliance(p2, Color.WHITE, true);

		Piece[] PiecesOfA1 = A1.getPieces();
		Piece[] PiecesOfA2 = A2.getPieces();

		AllCells = new Cell[6][6];
>>>>>>> 43dc427d6ac0d20342ab009efd431529ddd2c498

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

	public void paint(Graphics g) {

<<<<<<< HEAD
    
    public void MovePieceTo(Cell c,Piece p) {
    	
    	
    	int row1 = p.getROW();
    	int col1 = p.getCOL();
    	
    	AllCells[row1][col1].setPieceNull();
    	
    	
        	int row2 = c.getROWofCell();
        	
        	int col2 = c.getCOLofCell();
        	
        	AllCells[row2][col2].setPieceOnThisCell(p);
        	
    	
    	
    }
    
    
    
public void putPieceTo(Cell c,Piece p) {
    	
	int row = c.getROWofCell();
	
	int col = c.getCOLofCell();
	
	AllCells[row][col].setPieceOnThisCell(p);
    
}
=======
		g.fillRect(100, 100, 400, 400);
		for (int i = 100; i <= 400; i += 100) {
			for (int j = 100; j <= 400; j += 100) {
				g.clearRect(i, j, 50, 50);
			}
		}

		for (int i = 150; i <= 450; i += 100) {
			for (int j = 150; j <= 450; j += 100) {
				g.clearRect(i, j, 50, 50);
			}
		}
	}
>>>>>>> 43dc427d6ac0d20342ab009efd431529ddd2c498

	public void ShowBoard() {

		for (int i = 0; i < AllCells.length; i++) {

			for (int j = 0; j < AllCells[i].length; j++) {
				System.out.print(
						AllCells[i][j].ToString() + AllCells[i][j].getXofCell() + ";" + AllCells[i][j].getYofCell());/////////////////////////////////////////////////////
			}
			System.out.println();
		}

<<<<<<< HEAD
            for(int j = 0; j<AllCells[i].length;j++){
                System.out.print(AllCells[i][j].ToString());//////////////+AllCells[i][j].getROWofCell()+";"+AllCells[i][j].getCOLofCell()///////////////////////
            }
        System.out.println();
        }
System.out.println();
    }
=======
	}

	public Cell[][] getAllCells() {
		return AllCells;
	}
>>>>>>> 43dc427d6ac0d20342ab009efd431529ddd2c498

	public void resetAllValidBooleans() {
		for (int i = 0; i < AllCells.length; i++) {
			for (int j = 0; j < AllCells[i].length; j++) {
				AllCells[i][j].setInvalidCell();
			}
		}
	}

<<<<<<< HEAD
   public void resetAllValidBooleans() {
	   for(int i = 0;i<AllCells.length;i++) {
		   for(int j = 0;j<AllCells[i].length;j++) {
			   AllCells[i][j].setInvalidCell();
		   }
	   }
   }
   
   
   public Cell getCell(int row, int col) {
	   return AllCells[row][col];
   }
   
   
    
   public void moveRookValid(int fromRow, int fromCol) {
=======
	public void moveRookValid(int fromRow, int fromCol) {
>>>>>>> 43dc427d6ac0d20342ab009efd431529ddd2c498
		// Check upwards.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			if (this.AllCells[toRow][fromCol].getPiece() == null) {
				this.AllCells[toRow][fromCol].setValidCell();
			} else {
				if (this.AllCells[toRow][fromCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
					this.AllCells[toRow][fromCol].setValidCell();
				}
			}
		}
		// Check downwards.
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			if (this.AllCells[toRow][fromCol].getPiece() == null) {
				this.AllCells[toRow][fromCol].setValidCell();
			} else {
				if (this.AllCells[toRow][fromCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
					this.AllCells[toRow][fromCol].setValidCell();
				}
			}
		}
		// Check left.
		for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
			if (this.AllCells[fromRow][toCol].getPiece() == null) {
				this.AllCells[fromRow][toCol].setValidCell();
			} else {
				if (this.AllCells[fromRow][toCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
					this.AllCells[fromRow][toCol].setValidCell();
				}
			}
		}
		// Check right.
		for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
			if (this.AllCells[fromRow][toCol].getPiece() == null) {
				this.AllCells[fromRow][toCol].setValidCell();
			} else {
				if (this.AllCells[fromRow][toCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
					this.AllCells[fromRow][toCol].setValidCell();
				}
			}
		}
	}

	public void moveBishopValid(int fromRow, int fromCol) {
		// Check top-left.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				} else {
					if (this.AllCells[toRow][toCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
						this.AllCells[toRow][toCol].setValidCell();
					}
				}
			}
		}
		// Check top-right.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				} else {
					if (this.AllCells[toRow][toCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
						this.AllCells[toRow][toCol].setValidCell();
					}
				}
			}
		}
		// Check bottom-left
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				} else {
					if (this.AllCells[toRow][toCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
						this.AllCells[toRow][toCol].setValidCell();
					}
				}
			}
		}
		// Check bottom-right.
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
				if (this.AllCells[toRow][toCol].getPiece() == null) {
					this.AllCells[toRow][toCol].setValidCell();
				} else {
					if (this.AllCells[toRow][toCol].getPiece().getColor().equals(this.AllCells[fromRow][fromCol].getPiece().getColor())){
						this.AllCells[toRow][toCol].setValidCell();
					}
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
