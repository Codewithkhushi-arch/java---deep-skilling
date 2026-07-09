package com.company.springtest.repository;

import com.company.springtest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Arrange
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Bob");
        User user3 = new User(3L, "Alice");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Act
        List<User> alices = userRepository.findByName("Alice");
        List<User> bobs = userRepository.findByName("Bob");
        List<User> johns = userRepository.findByName("John");

        // Assert
        assertEquals(2, alices.size());
        assertEquals(1, bobs.size());
        assertTrue(johns.isEmpty());
    }
}
