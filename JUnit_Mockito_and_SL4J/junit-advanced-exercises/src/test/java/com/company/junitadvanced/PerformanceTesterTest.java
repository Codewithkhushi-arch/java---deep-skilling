package com.company.junitadvanced;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    final PerformanceTester tester = new PerformanceTester();

    @Test
    public void testPerformTaskWithinTimeout() {
        // Task should finish in 50ms, which is well within 200ms limit
        assertTimeout(Duration.ofMillis(200), () -> {
            tester.performTask(50);
        });
    }

    @Test
    public void testPerformTaskTimeoutPreemptively() {
        // Assert that a task taking 30ms completes before 100ms preemptively
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            tester.performTask(30);
        });
    }
}
