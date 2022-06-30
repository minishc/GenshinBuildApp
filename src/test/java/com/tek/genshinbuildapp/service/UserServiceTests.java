package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.UserRepository;
import com.tek.genshinbuildapp.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTests {

    @InjectMocks
    private static UserService userService;
    @Mock
    private static UserRepository repository;

    private static User user;

    @BeforeAll
    static void setup() {
        userService = new UserService(repository);

        user = new User(2,"Test", "expectedPassword");
    }

    @Test
    @Order(3)
    void retrieveUser() {
        Optional<User> mockDbRetrieve = Optional.of(user);
        when(repository.findByUsername(user.getUsername())).thenReturn(mockDbRetrieve);

    }

    @Test
    @Order(2)
    void testRetrieveUser() {
        Optional<User> mockDbRetrieve = Optional.of(user);
        when(repository.findById(user.getId())).thenReturn(mockDbRetrieve);
        Assertions.assertThat(userService.retrieveUser(user.getId()))
                .isNotNull().isEqualTo(mockDbRetrieve.get());
    }

    @Test
    @Order(1)
    void saveUser() {
        userService.saveUser(user);
        verify(repository).save(user);
    }

    @Test
    void removeAllCharacters() {
    }
}