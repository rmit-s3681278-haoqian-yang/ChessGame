package Tables;

import java.util.HashMap;

import Tables.Players.Player;

public class Table {

	Board gameBoard = new Board();
	HashMap<String, Player> PlayerLib = new HashMap<>();

	public boolean AddPlayer(String name, String pass) {
		PlayerLib.put(new Player(name, pass), name);
		return false;

	}

	private boolean SameNameHasExist() {

	}

}
