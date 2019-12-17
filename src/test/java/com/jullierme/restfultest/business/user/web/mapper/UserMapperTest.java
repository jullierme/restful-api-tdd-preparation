package com.jullierme.restfultest.business.user.web.mapper;

import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;
import com.jullierme.restfultest.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UserMapperImpl();
    }

    @Test
    void giveUserRequest_whenToUser_thenShouldConvertToUser() {
        //given
        String login = "jsb";
        String id = "123";
        UserRequest request = UserRequest.builder()
                .login(login)
                .build();

        //when
        User user = mapper.toUser(request);

        //then
        assertNotNull(user);
        assertNull(user.getId());
        assertEquals(login, user.getLogin());
    }

    @Test
    void giveUser_whenToResponse_thenShouldConvertToUserResponse() {
        //given
        String login = "jsb";
        String id = "123";
        User user = User.builder()
                .login(login)
                .id(id)
                .build();

        //when
        UserResponse response = mapper.toResponse(user);

        //then
        assertNotNull(response);
        assertEquals(id, response.getId());
        assertEquals(login, response.getLogin());
    }
}
