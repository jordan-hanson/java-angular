package com.observepoint.test.test.repositories;

import com.observepoint.test.test.models.UserRoles;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoles, Long> {
}
