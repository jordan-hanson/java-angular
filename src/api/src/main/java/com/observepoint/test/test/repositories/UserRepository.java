package com.observepoint.test.test.repositories;

import com.observepoint.test.test.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
