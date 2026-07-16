package com.company.mockitobasic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    @InjectMocks
    private MyService service;

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {
        // Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act
        String result = service.fetchData();

        // Assert
        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        // Act
        service.fetchData();

        // Verify that the getData method was called on mockApi
        verify(mockApi).getData();
    }

    // Exercise 3: Argument Matching
    @Test
    public void testArgumentMatching() {
        // Stub with argument matcher
        when(mockApi.getData(anyString())).thenReturn("Matched Data");

        // Act & Assert
        assertEquals("Matched Data", service.fetchDataWithKey("someKey"));
        assertEquals("Matched Data", service.fetchDataWithKey("anotherKey"));

        // Verify with specific and any arguments
        verify(mockApi).getData("someKey");
        verify(mockApi).getData("anotherKey");
        verify(mockApi, times(2)).getData(anyString());
    }

    // Exercise 4: Handling Void Methods
    @Test
    public void testHandlingVoidMethods() {
        // Act
        service.updateData("New Data");

        // Verify the interaction on the void method
        verify(mockApi).saveData("New Data");
    }

    // Exercise 5: Mocking and Stubbing with Multiple Returns
    @Test
    public void testMockingMultipleReturns() {
        // Stub to return different values on consecutive calls
        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call");

        // Act & Assert
        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Second Call", service.fetchData()); // Remains at the last return value
    }

    // Exercise 6: Verifying Interaction Order
    @Test
    public void testVerifyingInteractionOrder() {
        // Act
        service.fetchData();
        service.updateData("Ordered Data");

        // Verify order of calls
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).saveData("Ordered Data");
    }

    // Exercise 7: Handling Void Methods with Exceptions
    @Test
    public void testHandlingVoidMethodsWithExceptions() {
        // Stub void method to throw an exception when called with invalid data
        doThrow(new IllegalArgumentException("Invalid data")).when(mockApi).saveData(eq("Invalid"));

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateData("Invalid");
        });
        assertEquals("Invalid data", exception.getMessage());

        // Verify that it was indeed called
        verify(mockApi).saveData("Invalid");
    }
}
