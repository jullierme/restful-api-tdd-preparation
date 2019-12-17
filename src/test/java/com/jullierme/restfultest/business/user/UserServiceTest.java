package com.jullierme.restfultest.business.user;

import com.jullierme.restfultest.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldCreateNewUser() {
        //given
        String login = "newLogin";
        User mockUser = mock(User.class);
        User user = User.builder().login(login).build();

        doReturn(mockUser).when(userRepository).save(user);

        //when
        User newUser = userService.save(user);

        //then
        assertEquals(mockUser, newUser);
        verify(userRepository).save(user);
    }

    @Test
    void whenSave_shouldNotAcceptInvalidUser() {
        //given
        User user = null;

        //when
        Executable executable = () -> userService.save(user);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }
}
