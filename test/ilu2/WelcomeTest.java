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

	@Test
	void testWelcomeNom() {
		assertEquals("Hello, Bob",welcome.welcome("Bob"));
	}
	
	@Test
	void testWelcomeNullEtChainesVides(){
		final String ACTION = "Hello, my friend";  
		assertEquals(ACTION,welcome.welcome(null));
		assertEquals(ACTION,welcome.welcome(""));
		assertEquals(ACTION,welcome.welcome(" "));	
	}
	
	@Test
	void testWelcomeGestionCris(){
		final String ACTION_1 = "HELLO, JERRY!";  
		assertEquals(ACTION_1,welcome.welcome("JERRY"));
	}
	

}
