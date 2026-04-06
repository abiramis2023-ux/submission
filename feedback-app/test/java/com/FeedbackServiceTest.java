package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeedbackServiceTest {

    FeedbackService service = new FeedbackService();

    @Test
    void testValidFeedback() {
        assertTrue(service.submitFeedback("Abirami", "Great service!"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.submitFeedback("", "Nice");
        });

        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testShortMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.submitFeedback("User", "Bad");
        });

        assertEquals("Message must be at least 5 characters", exception.getMessage());
    }
}