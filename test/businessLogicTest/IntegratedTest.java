package businessLogicTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import businessLogic.Account;
import businessLogic.PersistenceInterface;

import java.sql.SQLException;

public class IntegratedTest {
	
	private PersistenceInterface pi;
	
	@Before
	public void setUp() throws Exception {
		pi = new PersistenceInterface();
		pi.setUp("testuser", "testpassword");
	}
	
	@Test
	public void testSetAndGetAccount() throws SQLException {
		pi.setAccount("admin", "John Smith", "jsmith", "password");
		Account acc = pi.getAccount("jsmith");
		assertEquals("admin", acc.getRole());
		assertEquals("John Smith", acc.getName());
		assertEquals("jsmith", acc.getUsername());
		assertEquals("password", acc.getPassword());
	}
	
	@Test
	public void testUsernameChecker() throws SQLException {
		pi.setAccount("user", "Jane Doe", "jdoe", "password");
		assertTrue(pi.usernameChecker("jdoe"));
		assertFalse(pi.usernameChecker("jsmith"));
	}
	
	@Test
	public void testPasswordChecker() throws SQLException {
		pi.setAccount("user", "Jane Doe", "jdoe", "password");
		assertTrue(pi.passwordChecker("jdoe", "password"));
		assertFalse(pi.passwordChecker("jdoe", "wrongpassword"));
		assertFalse(pi.passwordChecker("jsmith", "password"));
	}
}