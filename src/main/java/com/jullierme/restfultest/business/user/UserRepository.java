package com.jullierme.restfultest.business.user;

import com.jullierme.restfultest.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
