package controller;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import model.*;
import view.*;
import java.util.ArrayList;
import java.util.Optional;

public class Controller {

	private Table table = new Table();

	private MainFrame mainFrame = new MainFrame();
	private HBox frame2 = new HBox();
	private BoardPanel boardPanel = new BoardPanel();
	private LeftPanel leftPanel = new LeftPanel();
	private RightPanel rightPanel = new RightPanel();
	private TilePane[][] tilePanes = new TilePane[6][6];

	private Piece selectPiece = null;
	private boolean isWhitePlayerTurn;
	private Object currentPiece;

	private int setCounts = 10;
	private int Counts;///////////////////////////////////// set default turns;

	private int WhitePlayerScore;
	private boolean WhiteReady = false;
	private boolean BlackReady = false;
	private int BlackPlayerScore;

	private boolean WhiteWins = false;
	private boolean BlackWins = false;

	private GameOverDialog GameResult;

	private int StartX;
	private int StartY;

	private int EndX;
	private int EndY;
	private Image background;

	private SelectSplitPiece SplitePanel;
	
	private BooleanBinding startButton = new BooleanBinding() {

		{
			super.bind(table.getWhiteProperty(), table.getBlackProperty());
		}

		@Override
		protected boolean computeValue() {
			return (table.getWhiteProperty().get() == null || table.getBlackProperty().get() == null);
		}

	};

	@SuppressWarnings("unchecked")
	public Controller() {

		background = new Image(getClass().getResourceAsStream("/pic/background1.jpg"));

		Counts = setCounts;
		initStartXYandEndXY();

		// setStartButtonStatus();
		rightPanel.getSplit().setDisable(true);

		boardPanel.setDisable(true);

		Image banner1 = new Image(getClass().getResourceAsStream("/pic/banner.png"));
		ImageView fit1 = new ImageView(banner1);

		ImageView fit2 = new ImageView(banner1);
		rightPanel.getRemainingTurns().setText(String.valueOf(Counts));

		HBox OnTopEmpty = new HBox();
		HBox OnBottomEmpty = new HBox();

		mainFrame.setTop(OnTopEmpty);
		OnTopEmpty.setPrefHeight(100);
		mainFrame.setLeft(leftPanel);
		mainFrame.setCenter(boardPanel);
		mainFrame.setRight(rightPanel);
		mainFrame.setBottom(OnBottomEmpty);
		OnBottomEmpty.setPrefHeight(100);

		frame2.getChildren().addAll(leftPanel, boardPanel, rightPanel);
		frame2.setAlignment(Pos.CENTER);
		frame2.setSpacing(60);

		frame2.setStyle("-fx-background-image:url(/pic/Background3.jpg)");
		leftPanel.setAlignment(Pos.CENTER);
		boardPanel.setAlignment(Pos.CENTER);
		rightPanel.setAlignment(Pos.CENTER);

		leftPanel.getAddNewPlayerButton().setOnAction(event -> {
			new PlayerInputNew() {
				{
					getOkButton().setOnAction((e1) -> {
						String name = this.getInputUsername().getText();
						String pass = this.getInputPassword().getText();

						if (table.getPlayerMap().containsKey(name)) {
							Alert a1 = new Alert(Alert.AlertType.ERROR);
							a1.setHeaderText("Name has existed!");
							a1.showAndWait();
						} else {
							table.AddPlayer(name, pass);
							close();
						}
					});
				}
			};
		});

		leftPanel.getLoginPlayerBlackButton().setOnAction(event -> {
			new PlayerLogin() {
				{
					getOkButton().setOnAction(event -> {
						String name = getInputUsername().getText();
						String pass = getInputPassword().getText();
						if (table.playerCheck(name)) {
							if (table.passCheck(name, pass)) {
								if (!table.checkPlayerBlack(table.login(name, pass))) {
									Alert a = new Alert(Alert.AlertType.ERROR);
									a.setContentText("Same player has logged in!");
									a.showAndWait();
								} else {
									close();
								}
							} else {
								Alert a = new Alert(Alert.AlertType.ERROR);
								a.setContentText("Wrong password!");
								a.showAndWait();
							}
						} else {
							Alert a = new Alert(Alert.AlertType.ERROR);
							a.setContentText("Player not registered!");
							a.showAndWait();
						}
					});
				}
			};
		});

		leftPanel.getLoginPlayerWhiteButton().setOnAction(event -> {
			new PlayerLogin() {
				{
					getOkButton().setOnAction(event -> {
						String name = getInputUsername().getText();
						String pass = getInputPassword().getText();
						if (table.playerCheck(name)) {
							if (table.passCheck(name, pass)) {
								if (!table.checkPlayerWhite(table.login(name, pass))) {
									Alert a = new Alert(Alert.AlertType.ERROR);
									a.setContentText("Same player has logged in!");
									a.showAndWait();
								} else {
									close();
								}
							} else {
								Alert a = new Alert(Alert.AlertType.ERROR);
								a.setContentText("Wrong password!");
								a.showAndWait();
							}
						} else {
							Alert a = new Alert(Alert.AlertType.ERROR);
							a.setContentText("Player not registered!");
							a.showAndWait();
						}
					});
				}
			};
		});

		leftPanel.getSetGameTurnsButton().setOnAction(event -> {
			new SetTurns() {
				{
					getOkButton().setOnAction((rel) -> {

						if (!getInputTurns().getText().isEmpty()) {
							int a = Integer.parseInt(getInputTurns().getText());
							if (a <= 0) {
								Alert a33 = new Alert(Alert.AlertType.ERROR);
								a33.setContentText("Please input a valid value!");
								a33.showAndWait();
							} else {
								setCounts = a;
								Counts = a;
								rightPanel.getRemainingTurns().setText(String.valueOf(a));
								close();
							}
						} else {
							Alert a33 = new Alert(Alert.AlertType.ERROR);
							a33.setContentText("Please input a valid value!");
							a33.showAndWait();
						}
					});
				}
			};
		});

		leftPanel.getStartButton().disableProperty().bind(startButton);
		
		leftPanel.getStartButton().setOnAction(event -> {

			initStartXYandEndXY();
			initGame();

		});

		leftPanel.getQuitButton().setOnAction((actionEvent) -> {

			new QuitConfirm();

		});

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				boardPanel.getTilePaneAt(i, j).setOnAction((actionEvent) -> {

					boardPanel.RepaintBoard();

					TilePane temp = (TilePane) (actionEvent.getSource());

					int CurrentX = temp.getRowGrid();
					int CurrentY = temp.getColGrid();
					System.out.println("A1");
					rightPanel.getSplit().setDisable(true);

					if (StartX == -1 && EndX == -1) {// have not set start coordinate
						System.out.println("have not set start coordinate");

						if (table.getBoard().getTileAt(CurrentX, CurrentY).isEmpty()) {// click an empty tile

							System.out.println("click an empty tile");
							return;

						} else {// click a tile that contains piece

							System.out.println("click a tile that contains piece");

							if (table.getBoard().getTileAt(CurrentX, CurrentY).getPieceByIndex(0)
									.isWhitePiece() == isWhitePlayerTurn) {//

								System.out.println("the tile contains current player's piece");

								if (table.getBoard().getTileAt(CurrentX, CurrentY).getNumsOfMergedPiece() > 1)//
								{
									System.out.println("The piece is a piece that can split");
									rightPanel.getSplit().setDisable(false);

									rightPanel.getSplit().setOnAction((efe) -> {

										SplitePanel = new SelectSplitPiece(
												table.getBoard().getTileAt(CurrentX, CurrentY).getPiecesOnTheTile());
										SplitePanel.showAndWait();

									});
								}

								System.out.println("Set start coordinate");

								StartX = CurrentX;
								StartY = CurrentY;
								PaintValidTilesFor(StartX, StartY);

								return;

							} else {// clicked a tile that does not contain owned piece
								return;

							}

						}

					} else {// here means the start coordinate has been set

						EndX = CurrentX;
						EndY = CurrentY;

						if (table.getBoard().getTileAt(StartX, StartY).CanMove(CurrentX, CurrentY, table.getBoard())) {
							// if the piece at start coordinate can move to the tile clicked right now
							if (table.getBoard().getTileAt(CurrentX, CurrentY).isEmpty()) {

								ArrayList<Piece> tempo1 = (ArrayList<Piece>) table.getBoard().getTileAt(StartX, StartY)
										.getPiecesOnTheTile().clone();

								for (int oo = 0; oo < table.getBoard().getTileAt(StartX, StartY)
										.getNumsOfMergedPiece(); oo++) {
									table.getBoard().getTileAt(EndX, EndY).AddMergePiece(tempo1.get(oo));
								}

								for (int o1 = 0; o1 < table.getBoard().getTileAt(EndX, EndY)
										.getNumsOfMergedPiece(); o1++) {
									table.getBoard().getTileAt(EndX, EndY).getPieceByIndex(o1).setROWandCOL(EndX, EndY);
								}

								table.getBoard().getTileAt(StartX, StartY).clearPiece();

								ChangePlayerTurn();

								return;

							} else if (table.getBoard().getTileAt(CurrentX, CurrentY).getPieceByIndex(0)
									.isWhitePiece() == isWhitePlayerTurn) {// å¦‚æžœç›®æ ?å¤?æ˜¯è‡ªå·±çš?æ£‹å­?

								ArrayList<Piece> tempo1 = (ArrayList<Piece>) table.getBoard().getTileAt(StartX, StartY)
										.getPiecesOnTheTile().clone();

								for (int oo = 0; oo < tempo1.size(); oo++) {

									if (tempo1 != null) {
										table.getBoard().getTileAt(EndX, EndY).AddMergePiece(tempo1.get(oo));
									}
								}

								for (int o1 = 0; o1 < table.getBoard().getTileAt(EndX, EndY)
										.getNumsOfMergedPiece(); o1++) {
									table.getBoard().getTileAt(EndX, EndY).getPieceByIndex(o1).setROWandCOL(EndX, EndY);
								}

								table.getBoard().getTileAt(StartX, StartY).clearPiece();

								ChangePlayerTurn();

								return;

							} else {
								// if target piece belongs to opponent's
								System.out.println(
										"Target tile is not empty and target piece belongs to opponent player");

								ArrayList<Piece> tempo1 = (ArrayList<Piece>) table.getBoard().getTileAt(StartX, StartY)
										.getPiecesOnTheTile().clone();

								table.getBoard().getTileAt(EndX, EndY).clearPiece();
								for (int k = 0; k < tempo1.size(); k++) {
									table.getBoard().getTileAt(EndX, EndY).getPiecesOnTheTile().add(tempo1.get(k));
								}

								table.getBoard().getTileAt(StartX, StartY).clearPiece();

								if (isWhitePlayerTurn == true) {

									WhitePlayerScore += 5;
								} else {
									BlackPlayerScore += 5;
								}

								showScore();
								ChangePlayerTurn();

								return;

							}
						} else {// cannot move to target

							initStartXYandEndXY();
							return;

						}
					}
				});
			}
		}
	}

	public void PaintValidTilesFor(int x, int y) {

		Tile temp = table.getBoard().getTileAt(x, y);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (temp != null && temp.CanMove(i, j, this.table.getBoard())) {
					boardPanel.FitGreenToTileAt(i, j);
					System.out.print("\t G");
				} else {
					if (table.getBoard().getTileAt(i, j).getNumsOfMergedPiece() == 1) {
						System.out.print("\t" + table.getBoard().getTileAt(i, j).toString());
					} else if (table.getBoard().getTileAt(i, j).getNumsOfMergedPiece() > 1) {
						System.out.print("\t" + " M");
					} else if (table.getBoard().getTileAt(i, j).isEmpty()) {
						System.out.print("\t" + " .");
					}
				}
			}
			System.out.println();
		}

	}

	private void initGame() {

		Counts = setCounts;
		rightPanel.getRemainingTurns().setText(String.valueOf(Counts));
		selectPiece = null;
		ClearBoardPanel();
		boardPanel.RepaintBoard();
		boardPanel.setDisable(false);

		table.setUpBoard();
		table.getBoard().setUpGame();
		paintAllIconInBoardPanel();
		BlackPlayerScore = 0;
		WhitePlayerScore = 0;
		rightPanel.getScoreOfWhite().setText("0");
		rightPanel.getScoreOfBlack().setText("0");
		SelectSplitPiece splitPanel;

	}

	private void updateRemainTurns() {

		// String winner1 = table.getPlayerWhite().getUsername();
		// String winner2 = table.getPlayerBlack().getUsername();
		String draw = "It is a draw!";

		Counts--;
		rightPanel.getRemainingTurns().setText(String.valueOf(Counts));
		if (Counts == 0) {
			boardPanel.setDisable(true);

			GameResult = new GameOverDialog(Alert.AlertType.CONFIRMATION);

			if (WhitePlayerScore > BlackPlayerScore) {
				GameResult.setHeaderText("" + "White Wins!");
			} else if (WhitePlayerScore < BlackPlayerScore) {
				GameResult.setHeaderText("" + "Black Wins!");
			} else if (WhitePlayerScore == BlackPlayerScore) {
				GameResult.setHeaderText(draw);
			}
			GameResult.setContentText("\nWant to Play Again?");
			Optional<ButtonType> result = GameResult.showAndWait();

			if (result.get() == ButtonType.OK) {

				initGame();
			}
		}

	}

	public HBox getFrame2() {
		return frame2;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public LeftPanel getLeftPanel() {
		return leftPanel;
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}

	public TilePane[][] getTilePanes() {
		return tilePanes;
	}
	
	private void setStartButtonStatus() {
		if (table.isPlayersReady() == false) {
			leftPanel.getStartButton().setDisable(true);
		}
		if (table.isPlayersReady() == true) {
			leftPanel.getStartButton().setDisable(false);
		}
	}

	private void ClearBoardPanel() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				boardPanel.getTilePaneAt(i, j).drawPiece(null);
			}
		}
	}

	private void ChangePlayerTurn() {
		isWhitePlayerTurn = !isWhitePlayerTurn;

		paintAllIconInBoardPanel();

		initStartXYandEndXY();

		updateRemainTurns();

	}

	private void paintAllIconInBoardPanel() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				boardPanel.getTilePaneAt(i, j).drawPiece(new ImageView(table.getBoard().getTileAt(i, j).getIcon()));

			}
		}
	}

	private void initStartXYandEndXY() {
		StartX = -1;
		StartY = -1;

		EndX = -1;
		EndY = -1;
	}

	private void showScore() {
		rightPanel.getScoreOfBlack().setText(String.valueOf(BlackPlayerScore));
		rightPanel.getScoreOfWhite().setText(String.valueOf(WhitePlayerScore));
	}
}