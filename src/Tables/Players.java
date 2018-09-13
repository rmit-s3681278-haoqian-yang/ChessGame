package Tables;

import java.util.ArrayList;

import Pieces.Piece;

public class Players {

	private ArrayList<Player> players = new ArrayList<>();

	public class Player {
		public String Name;
		private String Password;
		boolean hasLogin = false;

		public Player(String name, String pass) {
			Name = name;
			Password = pass;

		}

		public boolean MatchPassword(String str) {
			if (Password.equals(str)) {
				return true;
			} else {
				return false;
			}
		}

		public String getName() {
			return Name;
		}

	}

	public ArrayList<Player> getplayers() {
		return players;
	}

	public boolean AddPlayer(String name, String pass) {
		if (IndexOfPlayer(name) == -1) {
			players.add(new Player(name, pass));
			return true;
		} else {
			return false;
		}

	}

	public Player Login(String name, String pass) {// pick out the player in all registered players
		int k = IndexOfPlayer(name);
		if (k != -1 && players.get(k).MatchPassword(pass) && !players.get(k).hasLogin) {

			players.get(k).hasLogin = true;
			return players.get(k);

		} else {
			return null;
		}

	}

	private int IndexOfPlayer(String name) {
		int k = -1;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).Name.equals(name)) {
				k = i;
			}

		}
		return k;
	}

	public boolean AlreadyLogin(Player p1, Player p2) {
		boolean k = false;

		String name = "";
		String pass = "";

		if (p1.Name.equals(p1.Name) && p1.MatchPassword(pass)) {
			if (p1.equals(p2)) {
				k = true;
			}
		}

		return k;
	}

}
