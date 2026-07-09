package com.company.mockitoadvanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApiServiceTest {

    @Mock
    private RestClient mockRestClient;

    @InjectMocks
    private ApiService apiService;

    @Test
    public void testServiceWithMockRestClient() {
        // Arrange
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Act
        String result = apiService.fetchData();

        // Assert
        assertEquals("Fetched Mock Response", result);
    }
}
