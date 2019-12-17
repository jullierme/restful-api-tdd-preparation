package com.jullierme.restfultest.business.user.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private String id;
    private String login;
}
