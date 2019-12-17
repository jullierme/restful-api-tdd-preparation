package com.jullierme.restfultest.business.user.web;

import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserWebService userWebService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse save(@RequestBody @Valid UserRequest userRequest) {
        log.debug("save(userRequest={})", userRequest);
        return userWebService.save(userRequest);

        /*ResponseEntity
                .created(getLocationPath(response.getId())).build();*/
    }

    private URI getLocationPath(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
