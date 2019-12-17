package com.jullierme.restfultest.business.user;

import com.jullierme.restfultest.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void shouldCreateNewUser() {
        //given
        String login = "mylogin";
        User user = dummyUser(login);

        //when
        user = userRepository.save(user);

        //then
        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(login, user.getLogin());
    }

    private User dummyUser(String login) {
        return User.builder()
                .login(login)
                .build();
    }

    @Test
    void shouldNotDuplicate() {
        //given
        String login = "mylogin";
        User user = dummyUser(login);
        User user2 = dummyUser(login);
        userRepository.save(user);

        //when
        Executable executable = () -> userRepository.save(user2);

        //then
        assertThrows(DataIntegrityViolationException.class, executable);
    }

    @Test
    void shouldNotSaveWithoutLogin() {
        //given
        String login = null;
        User user = dummyUser(login);

        //when
        Executable executable = () -> userRepository.save(user);

        //then
        assertThrows(DataIntegrityViolationException.class, executable);
    }
}
