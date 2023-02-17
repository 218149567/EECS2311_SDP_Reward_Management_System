package persistenceTest;
import persistence.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import businessLogic.Account;
import businessLogic.Administrator;
import businessLogic.PointsReceiver;
import businessLogic.Reward;

import java.util.ArrayList;

public class StubDataBaseTest {

    private StubDataBase stubDB;

    @BeforeEach
    public void setUp() {
        stubDB = new StubDataBase();
    }

    @Test
    public void testGetAccounts() {
        ArrayList<Account> accounts = stubDB.getAccounts();
        assertNotNull(accounts);
        assertEquals(4, accounts.size());

        Account account = accounts.get(0);
        assertTrue(account instanceof Administrator);
        assertEquals("admin", account.getUsername());

        account = accounts.get(1);
        assertTrue(account instanceof PointsReceiver);
        assertEquals("joe123", account.getUsername());

        account = accounts.get(2);
        assertTrue(account instanceof PointsReceiver);
        assertEquals("tara99", account.getUsername());

        account = accounts.get(3);
        assertTrue(account instanceof PointsReceiver);
        assertEquals("mike65", account.getUsername());
    }

    @Test
    public void testGetRewards() {
        ArrayList<Reward> rewards = stubDB.getRewards();
        assertNotNull(rewards);
        assertEquals(4, rewards.size());

        Reward reward = rewards.get(0);
        assertEquals("half-day", reward.getName());
        assertEquals("work only half a day", reward.getDescription());
        assertEquals(50, reward.getCost());
        assertEquals(100, reward.getQuantity());

        reward = rewards.get(1);
        assertEquals("1-day-off", reward.getName());
        assertEquals("free day off with pay", reward.getDescription());
        assertEquals(100, reward.getCost());
        assertEquals(100, reward.getQuantity());

        reward = rewards.get(2);
        assertEquals("week-off", reward.getName());
        assertEquals("week-off work with pay", reward.getDescription());
        assertEquals(500, reward.getCost());
        assertEquals(100, reward.getQuantity());

        reward = rewards.get(3);
        assertEquals("gift-card", reward.getName());
        assertEquals("$50 company giftcard", reward.getDescription());
        assertEquals(25, reward.getCost());
        assertEquals(100, reward.getQuantity());
    }

    @Test
    public void testToString() {
        String expected = "[ admin, joe123, tara99, mike65,]";
        String actual = stubDB.toString();
        assertEquals(expected, actual);
    }
}
