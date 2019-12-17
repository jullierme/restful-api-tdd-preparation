package com.jullierme.restfultest.business.user;

import com.jullierme.restfultest.domain.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User save(@NonNull User user) {
        log.debug("save(user={})", user);
        return repository.save(user);
    }
}
