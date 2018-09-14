package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Tables.Player;
import Tables.Table;

class PlayersTest {
	
	Table t1 = new Table();

	String name1 = "Haha";
	String pass1 = "123123";
	String name2 = name1;
	String pass2 = "321321";

	Player p1 = new Player(name1, pass1);
	Player p2 = new Player(name2, pass1);
	boolean add1 = t1.AddPlayer(p1);//
	boolean add2 = t1.AddPlayer(p2);// redundant player

	@Test
	void test1() {// test two players register with same id

		assertEquals(add1, true);//test if  register success
		assertEquals(add2, false);//test if repeat name player is able to register

	}

	@Test
	void test2() {// wrong pass login returns null
//		playerLib.AddPlayer(name1, pass1);

		Player test1 = t1.Login(name1, pass2);
		assertEquals(test1, null);

	}

	@Test
	void test3() {// decide if same player has login

//				playerLib.AddPlayer(name1, pass1);

		Player test1 = t1.Login(name1, pass1);
		Player test2 = t1.Login(name2, pass1);

		
		assertEquals(test1, p1);
		assertEquals(test2, null);

	}

//	@Test
//	void test3_1() {
//
//		Player p1 = t1.Login(name1, pass1);
//		Player p2 = t1.Login(name2, pass1);
//
//		assertEquals(p2, null);
//	}

}
