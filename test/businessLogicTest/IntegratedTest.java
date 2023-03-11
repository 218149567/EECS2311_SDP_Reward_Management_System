package businessLogicTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import businessLogic.Account;
import businessLogic.PersistenceInterface;

import java.sql.SQLException;

public class IntegratedTest {
	
	private PersistenceInterface pinterface;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testSetAndGetAccount() throws SQLException {
		pinterface.setAccount("admin", "John Smith", "jsmith", "password");
		Account acc = pinterface.getAccount("jsmith");
		assertEquals("admin", acc.getRole());
		assertEquals("John Smith", acc.getName());
		assertEquals("jsmith", acc.getUsername());
		assertEquals("password", acc.getPassword());
	}
	
	@Test
	public void testUsernameChecker() throws SQLException {
		pinterface.setAccount("user", "Jane Doe", "je", "xxxxxxxx");
		assertTrue(pinterface.usernameChecker("je"));
		assertFalse(pinterface.usernameChecker("jsmith"));
	}
	
	@Test
	public void testPasswordChecker() throws SQLException {
		pinterface.setAccount("user", "Jane Doe", "jdoe", "password");
		assertTrue(pinterface.passwordChecker("jdoe", "password"));
		assertFalse(pinterface.passwordChecker("jdoe", "incorrect"));
		assertFalse(pinterface.passwordChecker("wrongusername", "password"));
	}
}