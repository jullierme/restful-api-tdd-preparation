package com.jullierme.restfultest.business.user.web;

import com.jullierme.restfultest.business.user.UserService;
import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;
import com.jullierme.restfultest.business.user.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserWebServiceImpl implements UserWebService {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserResponse save(UserRequest request) {
        log.debug("save(request={})", request);
        return userMapper.toResponse(userService.save(userMapper.toUser(request)));
    }
}
