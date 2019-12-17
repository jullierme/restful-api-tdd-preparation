package com.jullierme.restfultest.business.user.web;

import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;

public interface UserWebService {
    UserResponse save(UserRequest user);
}
