package Tables;

import java.util.ArrayList;

import Pieces.Piece;

public class Player {

	private ArrayList<Player> players = new ArrayList<>();


		public String Name;
		private String Password;
		boolean hasLogin = false;

		public Player(String name, String pass) {
			Name = name;
			Password = pass;

		}
		
		public Player() {
			
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

	

	

}
