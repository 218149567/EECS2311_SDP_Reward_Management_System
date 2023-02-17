package businessLogicTest;
import businessLogic.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTest {

    private static Account account;
    
    @BeforeAll
    static void setUp() {
        account = new Account("John Doe", "johndoe", "password123");
    }
    
    @Test
    void testGetRole() {
        assertNull(account.getRole());
    }
    
    @Test
    void testSetRole() {
        account.setRole("user");
        assertEquals("user", account.getRole());
    }
    
    @Test
    void testGetName() {
        assertEquals("John Doe", account.getName());
    }
    
    @Test
    void testSetName() {
        account.setName("Jane Doe");
        assertEquals("Jane Doe", account.getName());
    }
    
    @Test
    void testGetUsername() {
        assertEquals("johndoe", account.getUsername());
    }
    
    @Test
    void testSetUsername() {
        account.setUsername("janedoe");
        assertEquals("janedoe", account.getUsername());
    }
    
    @Test
    void testGetPassword() {
        assertEquals("password123", account.getPassword());
    }
    
    @Test
    void testSetPassword() {
        account.setPassword("newpassword123");
        assertEquals("newpassword123", account.getPassword());
    }
    
    @Test
    void testGetId() {
        assertEquals(1, account.getId());
    }
    
    @Test
    void testToString() {
        assertEquals("johndoe", account.toString());
    }
    
    @Test
    void testUsernameChecker() {
        assertTrue(account.usernameChecker("johndoe"));
        assertFalse(account.usernameChecker("janedoe"));
    }
    
    @Test
    void testPasswordChecker() {
        assertTrue(account.passwordChecker("johndoe", "password123"));
        assertFalse(account.passwordChecker("johndoe", "wrongpassword"));
    }
    
    @Test
    void testGetIdCounter() {
        assertEquals(1, Account.getIdCounter());
    }

}
