package ss;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfileTest {

	@Test
	public void testList() {
		 new account("r","y");
		 new Profile("r","y",new account("r","y")).list();
	}

	@Test
	public void testUpdateUsername() {
		new Profile("r","y",new account("r","y")).updateUsername("y");
	}

}
