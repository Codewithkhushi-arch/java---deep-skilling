package com.company.mockitoadvanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private Repository mockRepository;

    @InjectMocks
    private Service service;

    @Test
    public void testServiceWithMockRepository() {
        // Arrange
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Act
        String result = service.processData();

        // Assert
        assertEquals("Processed Mock Data", result);
    }
}
