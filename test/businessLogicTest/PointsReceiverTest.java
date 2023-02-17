package businessLogicTest;
import businessLogic.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class PointsReceiverTest {
    private PointsReceiver pointsReceiver;

    @BeforeEach
    public void setup() {
        pointsReceiver = new PointsReceiver("John Doe", "johndoe", "password");
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", pointsReceiver.getName());
    }

    @Test
    public void testGetUsername() {
        assertEquals("johndoe", pointsReceiver.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", pointsReceiver.getPassword());
    }

    @Test
    public void testGetRole() {
        assertEquals("PR", pointsReceiver.getRole());
    }

    @Test
    public void testAddPoints() {
        pointsReceiver.addPoints(100);
        assertEquals(100, pointsReceiver.checkBalance());
    }
}

