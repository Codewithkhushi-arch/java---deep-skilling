package com.company.mockitoadvanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NetworkServiceTest {

    @Mock
    private NetworkClient mockNetworkClient;

    @InjectMocks
    private NetworkService networkService;

    @Test
    public void testServiceWithMockNetworkClient() {
        // Arrange
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Act
        String result = networkService.connectToServer();

        // Assert
        assertEquals("Connected to Mock Connection", result);
    }
}
