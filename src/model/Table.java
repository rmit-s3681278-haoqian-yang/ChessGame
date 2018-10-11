package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Table {

	private Board board;
	private ObjectProperty<Player> PlayerWhite = new SimpleObjectProperty<>(null);
	private ObjectProperty<Player> PlayerBlack = new SimpleObjectProperty<>(null);
	private boolean isPlayersReady = false;

	private Map<String, Player> players;

	public Table() {
		this.players = new HashMap<>();
	}

	public void setUpGame() {
		// setPlayersReady();
		checkAndSetReady();
		if (isPlayersReady) {

			board = new Board(PlayerWhite.get(), PlayerBlack.get());
		}

	}

	public void setUpBoard() {
		board = new Board(PlayerWhite.get(), PlayerBlack.get());
	}

	public void checkAndSetReady() {

		boolean k = PlayerWhite.get().getUsername().equals(PlayerBlack.get().getUsername());
		if (PlayerWhite.get() != null && PlayerBlack.get() != null && !k) {
			isPlayersReady = true;

		} else {
			isPlayersReady = false;
		}

	}

	public boolean AddPlayer(String name, String pass) {
		if (!players.containsKey(name)) {
			players.put(name, new Player(name, pass));
			return true;
		} else {
			return false;
		}

	}

	private int SearchIndexOfPlayerByName(String name) {

		int i = -1;
		if (players != null) {

			for (int j = 0; j < players.size(); j++) {
				if (name.equals(players.get(j))) {
					i = j;
				}

			}
		}

		return i;

	}

	public int SearchIndexByName(String name) {

		int s = -1;
		if (players == null) {
			return s;
		}

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(name)) {
				s = i;
			}
		}
		return s;
	}

	public boolean playerCheck(String name) {
		if (players.isEmpty() || !players.containsKey(name)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean passCheck(String name, String pass) {
		if (players.get(name).isPasswordMatch(pass)) { // Password match
			return true;
		} else {
			return false;
		}
	}

	public Player login(String name, String pass) {
		if (players.get(name).isPasswordMatch(pass)) {
			return players.get(name);
		} else {
			return null;
		}
	}

	public boolean checkPlayerWhite(Player P) {
		if (PlayerBlack.get() == null) {
			PlayerWhite.set(P);;
			return true;
		} else if (!(P.getUsername()).equals(PlayerBlack.get().getUsername())) {
			PlayerWhite.set(P);;
			return true;
		} else {
			return false;
		}
	}

	public boolean checkPlayerBlack(Player P) {
		if (PlayerWhite.get() == null) {
			PlayerBlack.set(P);
			return true;
		} else if (!(P.getUsername()).equals(PlayerWhite.get().getUsername())) {
			PlayerBlack.set(P);;
			return true;
		} else {
			return false;
		}
	}

	public boolean isPlayersReady() {
		return isPlayersReady;
	}

	public void setPlayersReady() {
		isPlayersReady = true;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	
	public ObjectProperty<Player> getWhiteProperty() {
		return PlayerWhite;
	}

	public void setPlayerWhite(Player playerWhite) {
		PlayerWhite.set(playerWhite);;
	}

	public ObjectProperty<Player> getBlackProperty() {
		return PlayerBlack;
	}

	public void setPlayerBlack(Player playerBlack) {
		PlayerBlack.set(playerBlack);
	}

	public Map<String, Player> getPlayerMap() {
		return players;
	}

}
