package Tables;

import java.util.ArrayList;
import Tables.Player;

public class Table {

	Board gameBoard = new Board();

	//////////////////////////////// Player Operation
	//////////////////////////////// Section///////////////////////////////////////////

	ArrayList<Player> PlayerLib = new ArrayList<>();

	public boolean AddPlayer(Player P) {
		boolean k = false;

		if (!NameHasExisted(P.Name)) {
			PlayerLib.add(P);
			k = true;
		}

		return k;
	}

	public Player Login(String name, String password) {
		Player temp = new Player();
		temp = null;
		if (NameHasExisted(name)) {
			int k = IndexWithThisName(name);
			if (PlayerLib.get(k).MatchedPassword(password) && PlayerLib.get(k).hasLogin == false) {
				temp = PlayerLib.get(k);
				PlayerLib.get(k).hasLogin = true;
			}
		}
		return temp;
	}

	private boolean NameHasExisted(String name) {
		boolean k = false;

		if (IndexWithThisName(name) != -1) {
			k = true;
		}
		return k;

	}

	private int IndexWithThisName(String name) {

		int k = -1;

		for (int i = 0; i < PlayerLib.size(); i++) {

			if (PlayerLib.get(i).getName().equals(name)) {

				k = i;
				break;
			}
		}

		return k;
	}

	//////////////////////////////////////////// End of Player Operation
	//////////////////////////////////////////// Section/////////////////////////////////////////////////////////////

}
