package businessLogicTest;
import businessLogic.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdministratorTest {

    @Test
    void testCreateAdmin() {
        Administrator admin = new Administrator();
        admin.createAdmin("John Doe", "jdoe", "password");
        assertNotNull(Account.getSystem().getAccount("jdoe"));
    }

    @Test
    void testAddPoints() {
        Administrator admin = new Administrator();
        PointsReceiver user = new PointsReceiver("Jane Doe", "jane", "password");
        Account.getSystem().addAccount(user);
        admin.addPoints(100, "jane");
        assertEquals(100, user.checkBalance());
    }

    @Test
    void testChangePassword() {
        Administrator admin = new Administrator();
        Account user = new Account("John Smith", "jsmith", "oldpassword");
        Account.getSystem().addAccount(user);
        admin.changePassword("jsmith", "newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    void testRemoveAccount() {
        Administrator admin = new Administrator();
        Account user = new Account("John Smith", "jsmith", "password");
        Account.getSystem().addAccount(user);
        admin.removeAccount("jsmith");
        assertNull(Account.getSystem().getAccount("jsmith"));
    }
}
