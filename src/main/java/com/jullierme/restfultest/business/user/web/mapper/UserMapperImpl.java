package com.jullierme.restfultest.business.user.web.mapper;

import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;
import com.jullierme.restfultest.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserRequest user) {
        return User.builder()
                .login(user.getLogin())
                .build();
    }

    @Override
    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}
