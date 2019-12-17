package com.jullierme.restfultest.business.user.web.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotEmpty
    private String login;
}
