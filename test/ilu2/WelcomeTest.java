package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {
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
		final String ACTION_2 = "Hello, Amy, Bob";
	    String input = "amy,bob";
        assertEquals(ACTION_2 , Welcome.welcome(input));
	}
	
	//EX_5
	@Test
	void testWelcomePlusieursNoms(){
		final String ACTION_3 = "Hello, Amy, Bob, Jerry";
		String input1 = "Amy,Bob,Jerry";
        assertEquals(ACTION_3 , Welcome.welcome(input1));	
	}

}
