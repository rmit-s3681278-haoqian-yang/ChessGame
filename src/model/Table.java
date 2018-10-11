package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Table {

	private Board board;
	private Player PlayerWhite = null;
	private Player PlayerBlack = null;
	private boolean isPlayersReady = false;

	private Map<String, Player> players;

	public Table() {
		this.players = new HashMap<>();
	}

	public void setUpGame() {
		// setPlayersReady();
		checkAndSetReady();
		if (isPlayersReady) {

			board = new Board(PlayerWhite, PlayerBlack);
		}

	}

	public void setUpBoard() {
		board = new Board(PlayerWhite, PlayerBlack);
	}

	public void checkAndSetReady() {

		boolean k = PlayerWhite.getUsername().equals(PlayerBlack.getUsername());
		if (PlayerWhite != null && PlayerBlack != null && !k) {
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

	public boolean MatchLogin(String name, String pass) {
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

	public boolean LoginPlayerWhite(Player P) {
		if (PlayerBlack == null) {
			PlayerWhite = P;
			return true;
		} else if (!(P.getUsername()).equals(PlayerBlack.getUsername())) {
			PlayerWhite = P;
			return true;
		} else {
			return false;
		}
	}

	public boolean LoginPlayerBlack(Player P) {
		if (PlayerWhite == null) {
			PlayerBlack = P;
			return true;
		} else if (!(P.getUsername()).equals(PlayerWhite.getUsername())) {
			PlayerBlack = P;
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

	public Player getPlayerWhite() {
		return PlayerWhite;
	}

	public void setPlayerWhite(Player playerWhite) {
		PlayerWhite = playerWhite;
	}

	public Player getPlayerBlack() {
		return PlayerBlack;
	}

	public void setPlayerBlack(Player playerBlack) {
		PlayerBlack = playerBlack;
	}

	public Map<String, Player> getPlayerMap() {
		return players;
	}

}
