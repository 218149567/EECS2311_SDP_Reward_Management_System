package businessLogicTest;
import businessLogic.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RewardTest {

    @Test
    void testRewardConstructor() {
        Reward reward = new Reward("Test Reward", "This is a test reward", 10, 5);
        assertEquals("Test Reward", reward.getName());
        assertEquals("This is a test reward", reward.getDescription());
        assertEquals(10, reward.getCost());
        assertEquals(5, reward.getQuantity());
    }

    @Test
    void testSetName() {
        Reward reward = new Reward("Test Reward", "This is a test reward", 10, 5);
        reward.setName("New Reward Name");
        assertEquals("New Reward Name", reward.getName());
    }

    @Test
    void testSetDescription() {
        Reward reward = new Reward("Test Reward", "This is a test reward", 10, 5);
        reward.setDescription("New reward description");
        assertEquals("New reward description", reward.getDescription());
    }

    @Test
    void testSetCost() {
        Reward reward = new Reward("Test Reward", "This is a test reward", 10, 5);
        reward.setCost(20);
        assertEquals(20, reward.getCost());
    }

    @Test
    void testSetQuantity() {
        Reward reward = new Reward("Test Reward", "This is a test reward", 10, 5);
        reward.setQuantity(10);
        assertEquals(10, reward.getQuantity());
    }
}
