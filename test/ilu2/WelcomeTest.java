package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {
	private static final Object ACTION_6 = null;
	private Welcome welcome;
	
	@BeforeEach
	void setUp() throws Exception {
		welcome = new Welcome();
	}
	//EX_1
	@Test
	void testWelcomeNom() {
		assertEquals("Hello, Bob",welcome.welcome("Bob"));
	}
	
	//EX_2
	@Test
	void testWelcomeNullEtChainesVides(){
		final String ACTION = "Hello, my friend";  
		assertEquals(ACTION,welcome.welcome(null));
		assertEquals(ACTION,welcome.welcome(""));
		assertEquals(ACTION,welcome.welcome(" "));	
	}
	
	//EX_3
	@Test
	void testWelcomeGestionCris(){
		final String ACTION_1 = "HELLO, JERRY!";  
		assertEquals(ACTION_1,welcome.welcome("JERRY"));
	}	
	
	//EX_4
	@Test
	void testWelcomeDeuxNoms(){
		final String ACTION_2 = "Hello, Amy and Bob";
	    String input = "amy,bob";
        assertEquals(ACTION_2 , Welcome.welcome(input));
	}
	
	//EX_5
	@Test
	void testWelcomePlusieursNoms(){
		final String ACTION_3 = "Hello, Amy, Bob and Jerry";
		String input1 = "Amy,bob,jerry";
        assertEquals(ACTION_3 , Welcome.welcome(input1));	
	}
	
	
	//EX_6
	@Test
	void testWelcomePlusieursNomsCris(){
		final String ACTION_4 = "Hello, Amy and Jerry.AND HELLO BOB (x1)";
		String input1 = "Amy,BOB,Jerry";
	    assertEquals(ACTION_4 , Welcome.welcome(input1));	
	}
	//EX_7
	@Test
	void testWelcomePlusieursNomsAND(){
	    assertEquals("Hello, Bob, Amy and Jerry" , Welcome.welcome("bob,amy,jerry"));
	    assertEquals("Hello, Bob and Jerry.AND HELLO AMY (x1) AND JACK (x1)" , Welcome.welcome("bob,AMY,jerry,JACK"));
	}
	
	//EX_8
	@Test
	void testWelcomeSupprimerEspaceInutile(){
	    assertEquals("Hello, Bob and Amy" , Welcome.welcome("bob   ,amy,  "));
	    
	}
	
	
	//EX_9
	@Test
	void testWelcomeNombreApparition(){
		String input="bob, JERRY, amy, bob, JERRY, bob";
	    assertEquals("Hello, Bob (x3) and Amy.AND HELLO JERRY (x2)" , Welcome.welcome(input));
	    
	}
	
	
	//EX_10
	@Test
	void testWelcomeNomYoda(){
		String input1="bob, Yoda, amy, JERRY";
		assertEquals("Bob, Yoda and Amy, Hello.AND HELLO JERRY (x1)" , Welcome.welcome(input1));
		String input2="bob, YODA,amy,JERRY,YODA";
		assertEquals("Hello, Bob and Amy.AND YODA (x2) AND JERRY (x1) HELLO!" , Welcome.welcome(input2));
	    
	}
}
