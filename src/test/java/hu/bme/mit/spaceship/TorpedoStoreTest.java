package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }
    
    @Test
    void fire_Failure() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0); // Set failure rate to 100%

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void fire_EmptyStore() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        // Act & Assert
        try {
            store.fire(1);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }
    }

    @Test
    void fire_More() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act & Assert
        try {
            store.fire(2);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }
    }

    @Test
    void fire_Twice() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act 1
        boolean result1 = store.fire(1);
        //Assert 1
        assertEquals(true, result1);
        //Act 2 and Assert 2
        try {
            store.fire(1);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }
    }
}
