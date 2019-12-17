package com.jullierme.restfultest.business.user.web;

import com.jullierme.restfultest.business.user.UserService;
import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;
import com.jullierme.restfultest.business.user.web.mapper.UserMapper;
import com.jullierme.restfultest.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserWebServiceTest {

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserWebServiceImpl userWebService;

    @Test
    void shouldCreateNewUser() {
        //given
        UserRequest request = mock(UserRequest.class);
        User user = mock(User.class);
        UserResponse userResponse = mock(UserResponse.class);

        doReturn(user).when(userMapper).toUser(request);
        doReturn(user).when(userService).save(user);
        doReturn(userResponse).when(userMapper).toResponse(user);

        //when
        UserResponse response = userWebService.save(request);

        //then
        assertNotNull(response);
        verify(userMapper).toUser(request);
        verify(userService).save(user);
        verify(userMapper).toResponse(user);
    }
}
