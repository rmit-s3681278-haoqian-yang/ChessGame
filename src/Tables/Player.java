package Tables;

import java.util.ArrayList;

import Pieces.Piece;

public class Player {

	private ArrayList<Player> players = new ArrayList<>();

		private String Name;
		private String Password;
		private boolean isWhite;
		private boolean hasLogin = false;

		public Player(String name, String pass) {
			Name = name;
			Password = pass;
			isWhite = false;
		}
		
		public Player() {
			
		}

		public void setPlayers(ArrayList<Player> players) {
			this.players = players;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public boolean isWhite() {
			return isWhite;
		}
		
		public void setWhite(boolean isWhite) {
			this.isWhite = isWhite;
		}

		public boolean getHasLogin() {
			return hasLogin;
		}
		
		public void setHasLogin(boolean hasLogin) {
			this.hasLogin = hasLogin;
		}

		public boolean MatchedPassword(String str) {
			if (Password.equals(str)) {
				return true;
			} else {
				return false;
			}
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

}
