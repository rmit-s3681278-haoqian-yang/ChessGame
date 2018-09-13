package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Tables.Players;
import Tables.Players.Player;

class PlayersTest {

	String name1 = "Haha";
	String pass1 = "123123";
	String name2 = name1;
	String pass2 = "321321";

	Players playerLib = new Players();
	boolean add1 = playerLib.AddPlayer(name1, pass1);// register success
	boolean add2 = playerLib.AddPlayer(name2, pass1);// redundant player

	@Test
	void test1() {// test two players register with same id

		assertEquals(add1, true);
		assertEquals(add2, false);

	}

	@Test
	void test2() {// wrong pass login returns null
//		playerLib.AddPlayer(name1, pass1);

		Player test1 = playerLib.Login(name1, pass2);
		assertEquals(test1, null);

	}

	@Test
	void test3() {// decide if same player has login

//				playerLib.AddPlayer(name1, pass1);

		Player test1 = playerLib.Login(name1, pass1);
		Player test2 = playerLib.Login(name2, pass1);

		Player test0 = playerLib.getplayers().get(0);
		assertEquals(test1, test0);
		assertEquals(test2, null);

	}

	@Test
	void test4() {

	//	Player p1 = playerLib.Login(name1, pass1);
		Player p2 = playerLib.Login(name2, pass1);

		assertEquals(p2, null);
	}

}
