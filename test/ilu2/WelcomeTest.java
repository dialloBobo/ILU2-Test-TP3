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

}
